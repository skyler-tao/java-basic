package skyler.tao.stream.parallel;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.stream.Collectors;

public class Demo {
    public static void main(String[] args) {
        System.out.println(Runtime.getRuntime().availableProcessors());
        System.out.println(new Date());
        demo3();
        System.out.println(new Date());
    }

    private static void demo1() {
        List<Integer> list = new ArrayList<Integer>();
        for (int i = 0; i < 29; i++) {
            list.add(i);
        }
        final CopyOnWriteArrayList<Integer> anotherList = new CopyOnWriteArrayList<Integer>();
        list.parallelStream().forEachOrdered(i -> {
            anotherList.add(i * i);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        System.out.println(anotherList);
    }

    private static void demo2() {
        int max = 999;
        range(1, max).stream().parallel();
    }

    private static List<Integer> range(int start, int end) {
        List<Integer> result = new ArrayList<>();
        for (int i = start; i < end; i++) {
            result.add(i);
        }
        return result;
    }

    private static void demo3() {
        List<Long> sourceList = new ArrayList<>();
        for (long i = 0; i < 9; i++) {
            sourceList.add(i);
        }
        List<Long> targetList = new ArrayList<>(sourceList.size());
//        targetList = IntStream.range(0, targetList.size()).parallel().mapToObj(i -> sourceList.get(i)).collect(Collectors.toList());
//        targetList = sourceList.parallelStream().map(i -> i + 1).collect(Collectors.toList());
        targetList = sourceList.parallelStream().map(i -> {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            ;
            return i + 1;
        }).collect(Collectors.toList());
        System.out.println(targetList);
    }
}
