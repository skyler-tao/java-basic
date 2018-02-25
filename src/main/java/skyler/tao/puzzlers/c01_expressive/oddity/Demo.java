package skyler.tao.puzzlers.c01_expressive.oddity;

public class Demo {
    public static void main(String[] args) {
        int i = -33;
        System.out.println(isOddBad(i));
        System.out.println(isOddGood(i));
    }

    /**
     * 对于负数均返回 false
     * @param i
     * @return
     */
    public static boolean isOddBad(int i) {
        return i % 2 == 1;
    }

    public static boolean isOddGood(int i) {
        return i % 2 != 0;
    }
}
