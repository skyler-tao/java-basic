package skyler.tao.jvm.sugar;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Demo3 {
    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new FileReader("./Demo1.class"))) {
            System.out.println(br.readLine());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
