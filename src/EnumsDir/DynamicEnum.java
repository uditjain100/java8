package EnumsDir;

import java.util.*;

public class DynamicEnum {
    public static void main(String[] args) {

        EmployeeType fullTime = EmployeeType.addEmployeeType("FULL_TIME");
        EmployeeType partTime = EmployeeType.addEmployeeType("PART_TIME");

        System.out.println(fullTime.hashCode());
        System.out.println(partTime.hashCode());
        System.out.println(EmployeeType.getValue(fullTime.getName()).hashCode());

        EmployeeType.map.values().stream().forEach((en) -> System.out.println(en.name));

    }

    static class EmployeeType {
        private static final Map<String, EmployeeType> map = new HashMap<String, EmployeeType>();

        private String name;

        private EmployeeType(String name) {
            this.name = name;
            map.put(name, this);
        }

        public String getName() {
            return name;
        }

        public static EmployeeType getValue(String name) {
            return map.get(name);
        }

        public static EmployeeType addEmployeeType(String name) {
            if (map.containsKey(name))
                return map.get(name);
            return map.put(name, new EmployeeType(name));
        }

        public static EmployeeType removeEmployeeType(String name) {
            return map.remove(name);
        }
    }
}
