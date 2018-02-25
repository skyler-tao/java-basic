package skyler.tao.puzzlers.c01_expressive.timeforchange;

import java.math.BigDecimal;

public class Demo {
    public static void main(String[] args) {
        // not right
        System.out.println(2.00 - 1.10);

        // right
        System.out.println(new BigDecimal("2.00").subtract(new BigDecimal("1.10")));
    }
}
