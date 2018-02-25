package skyler.tao.map;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class List2MapDemo {
    public static void main(String[] args) {

        List<People> peopleList = new ArrayList<>();
        for (int i = 0; i < 29; i++) {
            peopleList.add(new People(i, "chaoqiang" + i, "location " + i));
        }
        System.out.println(new Date());
        Map<Integer, String> idWithName = peopleList.parallelStream().filter(people -> people.getId() > 10).map(a -> {
            try {
                Thread.sleep(300);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return a;
        }).collect(Collectors.toMap(people -> people.getId(), People::getName));
        System.out.println(new Date());
        System.out.println(idWithName);

//        Map<Integer, String> idWithNameParallel = peopleList.parallelStream().collect(Collectors.toMap(People::getId, People::getName));
//        System.out.println(idWithNameParallel);
    }

    static class People {
        private int id;
        private String name;
        private String location;

        public People(int id, String name, String location) {
            this.id = id;
            this.name = name;
            this.location = location;
        }

        public int getId() {
            return id;
        }

        public People setId(int id) {
            this.id = id;
            return this;
        }

        public String getName() {
            return name;
        }

        public People setName(String name) {
            this.name = name;
            return this;
        }

        public String getLocation() {
            return location;
        }

        public People setLocation(String location) {
            this.location = location;
            return this;
        }
    }
}
