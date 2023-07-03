import java.util.ArrayList;
import java.util.List;

public class Department {
    private String name;
    private List<Employee> employees;

    public Department(String name){
        this.name = name;
        employees = new ArrayList<>();
    }
}
