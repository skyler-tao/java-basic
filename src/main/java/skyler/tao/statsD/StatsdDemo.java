package skyler.tao.statsD;

import com.timgroup.statsd.NonBlockingStatsDClient;
import com.timgroup.statsd.StatsDClient;

/**
 * 写该类的目的是：Druid 线上集群发送的 StatsD 监控指标发送后，在 graphite 上数据有误，</br>
 * 猜测可能是 statsD 服务发送时数据有丢失。</br>
 * 结论：猜测有误。
 */
public class StatsdDemo {
    public static void main(String[] args) throws InterruptedException {

        StatsDClient client = new NonBlockingStatsDClient("druid-monitor", "status.dev.rack.zhihu.com", 8126);
        long value = 1024*1024*1024*60l;

        while (true) {
            System.out.println("start to send value..");
            client.gauge("big-value-test.test-20170919", value++);      // 经验证，statsD 服务受到的确实是 long 型，数据没丢失。
            Thread.sleep(3000);
        }
    }
}
