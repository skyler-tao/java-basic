package skyler.tao.jvm.classfile;

public class Demo1 {
    public static void main(String[] args) {
        {
            byte[] placeholder = new byte[64 * 1024 * 1024];
        }
        int a = 0;  // add to gc placeholder
        int b;
//        System.out.println(b);
        System.gc();
    }
}
