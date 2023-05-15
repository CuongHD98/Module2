public class ID10912 {
    public static void main(String[] args) {
        Students students = new Students();
        students.setName("Henry");
        students.setClasses("SO4");
        System.out.println(students.getName());
        System.out.println(students.getClasses());
    }
}

class Students {
    private String name = "John";
    private String classes = "CO2";

    public Students() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getClasses() {
        return classes;
    }

    public void setClasses(String classes) {
        this.classes = classes;
    }
}

