import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {

        List<String> someArrayNumbers = Arrays.asList(
                "N40", "N36",
                "B12", "B6",
                "G53", "G49", "G60", "G50", "g64",
                "I26", "I17", "I29",
                "O71"
        );

        Stream<String> ioNumberStream = Stream.of("I26", "I17", "I29", "O71");
        Stream<String> inNumberStream = Stream.of("N40", "N36", "I26", "I17","I29", "O71");
        Stream<String> concatStream = Stream.concat(ioNumberStream, inNumberStream);
        System.out.println("\n___________________________");
        // System.out.println("Counts with no duplicates " + concatStream.distinct().count());
        System.out.println (concatStream
                .distinct()
                .peek(System.out::println)
                .count());
        System.out.println("___________________________");

//        List<String> gNumbers = new ArrayList<>();
//
//        someNumbers.forEach(number-> {
//            if(number.toUpperCase().startsWith("G")){
//                gNumbers.add(number);
//            }
//        });
//
//        gNumbers.sort((String s1, String s2) -> s1.compareTo(s2));
//
//        gNumbers.forEach((String s) -> System.out.println(s));

        someArrayNumbers
                .stream()
                .map(String::toUpperCase)
                .filter(s->s.startsWith("G"))
                .sorted()
                .collect(Collectors.toList());

        for(String s : someArrayNumbers){
            System.out.println(s);
        }


        // Declaring Employee objects.
        Employee john = new Employee("John Doe", 30);
        Employee jane = new Employee("Jane Hill", 32);
        Employee jack = new Employee("Jack Monroe", 45);
        Employee chris = new Employee("Chris Rock", 22);

        // Declaring Department objects.
        Department tech = new Department("Technology");
        tech.addEmployee(john);
        tech.addEmployee(jane);
        tech.addEmployee(jack);

        Department sales = new Department("Sales");
        sales.addEmployee(chris);

        // Printing
        List<Department> departments = new ArrayList<>();
        departments.add(tech);
        departments.add(sales);

        System.out.println("\n___Department Employees___");
        departments.stream()
                .flatMap(department -> department.getEmployee().stream())
                .forEach(System.out::println);

        System.out.println("\n___The youngest employees___");
        departments.stream()
                .flatMap(department -> department.getEmployee().stream())
                .reduce((e1, e2) -> e1.getAge() < e2.getAge() ? e1 : e2)
                .ifPresent(System.out::println);

    }

}