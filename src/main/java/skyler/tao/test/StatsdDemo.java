package skyler.tao.test;

import com.timgroup.statsd.NonBlockingStatsDClient;
import com.timgroup.statsd.StatsDClient;

public class StatsdDemo {
    public static void main(String[] args) throws InterruptedException {

        StatsDClient client = new NonBlockingStatsDClient("druid-monitor", "status.dev.rack.zhihu.com", 8126);
        long value = 1024*1024*1024*60l;

        while (true) {
            System.out.println("start to send value..");
            client.gauge("big-value-test.test-20170919", value++);
            Thread.sleep(3000);
        }
    }
}
