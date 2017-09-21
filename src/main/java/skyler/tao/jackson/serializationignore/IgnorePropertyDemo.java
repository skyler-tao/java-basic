package skyler.tao.jackson.serializationignore;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;

/**
 * 该 Demo 的目的是验证 jackson 是否支持对类的单个字段只在序列化时忽略，</br>
 * 包括 null 的情况
 */
public class IgnorePropertyDemo {
    public static void main(String[] args) throws IOException {
        String myself = "{\"name\":\"chaoqiang\",\"company\":\"zhihu\"}";
        People deserializedPeople = new ObjectMapper().readValue(myself, People.class);
        System.out.println("deserialized people: " + deserializedPeople.toString());

        String serializedPeople = new ObjectMapper().writeValueAsString(deserializedPeople);
        System.out.println("serialized people: " + serializedPeople);
    }
}
