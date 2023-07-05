import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
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

        List<Department> departments = new ArrayList<>();
        departments.add(tech);
        departments.add(sales);

        // Printing all departmental employees
        System.out.println("\n___Department Employees___");
        departments.stream()
                .flatMap(department -> department.getEmployee().stream())
                .forEach(System.out::println);

        // Finding the youngest employee
        System.out.println("\n___The youngest employees___");
        departments.stream()
                .flatMap(department -> department.getEmployee().stream())
                .reduce((e1, e2) -> e1.getAge() < e2.getAge() ? e1 : e2)
                .ifPresent(System.out::println);


        // Regular expressions
        String string = "I am a string. Yes, I am.";
        System.out.println("\n___Regular expression in Java___");
        System.out.println(string);
        String myString = string.replaceAll("I", "You");
        System.out.println(myString);
        String alphaNumeric = "abcDeeef12Ghiiiijkl99387zuv";
        System.out.println(alphaNumeric.replaceAll(".", "P"));
        // Matching and replacing at the beginning of the string.
        System.out.println(alphaNumeric.replaceAll("^abcDe{3}", "OPIYO"));
        // Return Boolean True of False.
        System.out.println(alphaNumeric.matches("^OPIYO"));
        // Matching and replacing at the end of the string.
        System.out.println(alphaNumeric.replaceAll("l99zuv$", "THE END"));
        // Matching and replacing specific characters.
        System.out.println(alphaNumeric.replaceAll("[aei]", "Z"));
        // Matching and replacing all characters except ej
        System.out.println(alphaNumeric.replaceAll("[^ej]", "T"));
        // Matching and replacing characters and numeric in a range.
        System.out.println(alphaNumeric.replaceAll("(?i)[a-f3-8]", "Q"));

        // Removing a tab and a newline.
        String whiteSpaceAlphaNumeric = "I have blanks and\ta tab, also a newline\n";
        System.out.println(whiteSpaceAlphaNumeric);
        System.out.println(whiteSpaceAlphaNumeric.replaceAll("\t", "D"));

        StringBuilder htmlText = new StringBuilder("<h1>My Heading</h1>");
        htmlText.append("<h2>Sub-heading</h2>");
        htmlText.append("<p>This is a paragraph about something.</p>");
        htmlText.append("<p>This is another paragraph about something else.</p>");
        htmlText.append("<h2>Summary</h2>");
        htmlText.append("<p>Here is the summary.</p>");

        String h2Pattern = "(<h2>)(.+?)(</h2>)";
        Pattern pattern = Pattern.compile(h2Pattern);
        Matcher matcher = pattern.matcher(htmlText);
        System.out.println(matcher.matches());

        matcher.reset();
        int count = 0;
        while(matcher.find()){
            System.out.println("Occurrence: " + matcher.group(2));
        }

        // VISA Validation: ^4[0-9]{12}([0-9]{3})?$

        String visa1 = "4102512345000";
        String visa2 = "5102512345004";
        String visa3 = "51026";
        String visa4 = "4102512345000918";
        System.out.println("\nVisa 1: " + visa1.matches("^4[0-9]{12}([0-9]{3})?$"));
        System.out.println("Visa 2: " + visa2.matches("^4[0-9]{12}([0-9]{3})?$"));
        System.out.println("Visa 3: " + visa3.matches("^4[0-9]{12}([0-9]{3})?$"));
        System.out.println("Visa 4: " + visa4.matches("^4[0-9]{12}([0-9]{3})?$"));

        // Challenge 1: Write the string literal regular expression that will match the following String.
        // Use the String.matches() to method to verify your answer.
        // String challenge1 = "I want a bike";

        String challenge1 = "I want a bike";

        String regExp = "I want a \\w+";
        Pattern pattern1 = Pattern.compile(regExp);
        Matcher matcher1 = pattern1.matcher(challenge1);
        System.out.println("\nChallenge 1 result: " + matcher1.matches());

        // Challenge 2: Replace all blanks with an _
        String challenge2 = "Replace all blanks with underscore.";
        System.out.println(challenge2.replaceAll(" ", "_"));

        // Challenge 3: Match a given string in its entirety.
        String challenge3 = "aaabccccccccdddefffg";
        System.out.println("Challenge 3 result: " + challenge3.matches("^a{3}bc{8}d{3}ef{3}g$"));

        // Challenge 4: Match a string that starts with a series of letters
        // The letter must be followed by a period, after the period, there must be series of digits.
        String challenge4 = "abcd.1459";
        System.out.println("Challenge 4 result: " + challenge4.matches("^[A-z][a-z]+\\.\\d+$"));

        // Challenge 5: "abcd.135\tuvqz.7\tttzik.999\n"
        // Write a regular expression to extract all the numbers.
        System.out.println("___________Challenge 5____________");
        String challenge5 = "abcd.135\tuvqz.7\tttzik.999\n";
        Pattern pattern5 = Pattern.compile("[A-Za-z]+\\.(\\d+)\\s");
        Matcher matcher5 = pattern5.matcher(challenge5);
        while(matcher5.find()){
            System.out.println("Occurrence: " + matcher5.group(1));
        }

        // Challenge 6: "{0, 2}, {0, 5}, {1, 3}, {2, 4}"
        // Write a regular expression to extract all the values in the enclosed by {}.
        System.out.println("___________Challenge 6____________");
        String challenge6= "{0, 2}, {0, 5}, {1, 3}, {2, 4}";
        Pattern pattern6 = Pattern.compile("\\{(.+?)\\}");
        Matcher matcher6 = pattern6.matcher(challenge6);
        while(matcher6.find()){
            System.out.println("Occurrence: " + matcher6.group(1));
        }

        // Challenge 7: "{0, 2}, {0, 5}, {1, 3}, {2, 4}, {x, y}, {2, 4}, {11, 12}"
        // Write a regular expression to extract all the values in the enclosed by {}.

        System.out.println("___________Challenge 7____________");
        String challenge7= "{0, 2}, {0, 5}, {1, 3}, {2, 4}, {x, y}, {2, 4}, {11, 12}";
        Pattern pattern7 = Pattern.compile("\\{(\\d+, \\d+)\\}");
        Matcher matcher7 = pattern6.matcher(challenge7);
        while(matcher7.find()){
            System.out.println("Occurrence: " + matcher7.group(1));
        }


    }

}