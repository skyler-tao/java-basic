package skyler.tao.reflect;

public class Demo {
    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        Class c = Class.forName("skyler.tao.reflect.InstanceA");
        Basic basic = (InstanceA) c.newInstance();
        basic.func();
    }
}
