import java.util.*;

public class Main {

    public static void main(String[] args) {

        HashMap<Integer, User> userHashMap = new HashMap<>();
        userHashMap.put(1, new User("xiaoming", 20));
        userHashMap.put(2, new User("xiaohong", 25));
        userHashMap.put(3, new User("xiaohua", 23));
        userHashMap.put(4, new User("xiaoxiao", 29));

        userHashMap = sortHashMap(userHashMap);
        System.out.println(userHashMap);
    }

    public static HashMap sortHashMap(HashMap<Integer, User> map) {
        Set<Map.Entry<Integer, User>> set = map.entrySet();
        List<Map.Entry<Integer, User>> list = new ArrayList(set);
        Collections.sort(list, new Comparator<Map.Entry<Integer, User>>() {
            @Override
            public int compare(Map.Entry<Integer, User> o1, Map.Entry<Integer, User> o2) {
                return o2.getValue().age - o1.getValue().age;
            }
        });

        LinkedHashMap<Integer, User> outPut = new LinkedHashMap<>();
        for (Map.Entry<Integer, User> entry : list) {
            outPut.put(entry.getKey(), entry.getValue());
        }
        return outPut;
    }

    static class User {
        private String name;
        private int age;

        public User(String name, int age) {
            this.name = name;
            this.age = age;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }
    }
}
