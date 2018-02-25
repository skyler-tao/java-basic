package skyler.tao.jvm.stats;

import java.lang.management.GarbageCollectorMXBean;
import java.lang.management.ManagementFactory;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class GCMetricsDemo {
    static final Set<String> YOUNG_GC = new HashSet<String>(3);
    static final Set<String> OLD_GC = new HashSet<String>(3);

    static {
        // young generation GC names
        YOUNG_GC.add("PS Scavenge");
        YOUNG_GC.add("ParNew");
        YOUNG_GC.add("G1 Young Generation");

        // old generation GC names
        OLD_GC.add("PS MarkSweep");
        OLD_GC.add("ConcurrentMarkSweep");
        OLD_GC.add("G1 Old Generation");
    }
    
    public static void main(String[] args) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    String[] arrays = new String[999];
                    try {
                        Thread.sleep(3000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    for (int i = 0; i < arrays.length; i++) {
                        arrays[i] = String.valueOf(i * i * i);
                    }
                }
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    printGCMetrics();
                    try {
                        Thread.sleep(3000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();
    }

    private static void printGCMetrics() {

        long minorCount = 0;
        long minorTime = 0;
        long majorCount = 0;
        long majorTime = 0;
        long unknownCount = 0;
        long unknownTime = 0;

        List<GarbageCollectorMXBean> mxBeans
                = ManagementFactory.getGarbageCollectorMXBeans();
        for (GarbageCollectorMXBean gc : mxBeans) {
            long count = gc.getCollectionCount();
            if (count >= 0) {
                if (YOUNG_GC.contains(gc.getName())) {
                    minorCount += count;
                    minorTime += gc.getCollectionTime();
                } else if (OLD_GC.contains(gc.getName())) {
                    majorCount += count;
                    majorTime += gc.getCollectionTime();
                } else {
                    unknownCount += count;
                    unknownTime += gc.getCollectionTime();
                }
            }
        }



        StringBuilder sb = new StringBuilder();
        sb.append("MinorGC -> Count: ").append(minorCount)
                .append(", Time (ms): ").append(minorTime)
                .append(", MajorGC -> Count: ").append(majorCount)
                .append(", Time (ms): ").append(majorTime);

        if (unknownCount > 0) {
            sb.append(", UnknownGC -> Count: ").append(unknownCount)
                    .append(", Time (ms): ").append(unknownTime);
        }

        System.out.println(sb);
    }
}
