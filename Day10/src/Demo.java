import java.util.*;

public class Demo {
    public static void main(String[]args) {
        Set<String> set = new HashSet<>();
        set.add("London");
        set.add("Paris");
        set.add("New York"); set.add("San Francisco"); set.add("Beijing");
                set.add("NewYork");
        System.out.println(set);
        for (String s: set) { System.out.print(s.toUpperCase()+
                " ");
        }
    }
}
