package skyler.tao.time.joda;

import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;

public class Demo {
    public static void main(String[] args) {
        DateTime dateTime = DateTimeFormat.forPattern("yyyy-MM-dd").parseDateTime("2017-12-12");
        System.out.println(dateTime);
    }
}
