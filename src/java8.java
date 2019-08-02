import java.util.Optional;

public class java8 {

    public static void main(String[] args) {
      /*  Employee employee = new Employee();
        employee.setId(1);
        employee.setName("name1");
        Employee employee2 = new Employee();
        employee2.setId(1);
        employee2.setName("name1");
        TreeSet treeSet = new TreeSet<Employee>((o1, o2) -> (o1.getId() == o2.getId()
                && o1.getName().equalsIgnoreCase(o2.getName()) ? 0 : -1));


        treeSet.add(employee2);
        treeSet.add(employee);

        // listDevs.sort((Employee o1, Employee o2)-> compare(null, null));
        // System.out.println(treeSet.size());

        java.util.List<String> duplicates = Arrays.asList("A", "B", "B", "C", "D", "D", "Z", "E", "E");

        duplicates.stream().collect(Collectors.groupingBy(Function.identity(),
                Collectors.counting()))
                .entrySet().stream()
                .filter(e -> e.getValue() == 1L)
                .map(e -> e.getKey())
                .collect(Collectors.toSet())
                .forEach(System.out::println);

        System.out.println(testOptional().isPresent());*/

    }


    public static Optional<String> testOptional(){
        return Optional.of("test");
    }
    static class Employee {

        private String name;
        private int id;

        public Employee(String f, int i) {
            f =name;
            i= id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }
    }
}
