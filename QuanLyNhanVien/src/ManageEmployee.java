import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class ManageEmployee {
    //    private List<Employee> listEmployees = new ArrayList<>();
    Scanner scanner = new Scanner(System.in);
    SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

    public ManageEmployee() {
    }

    public void writeDataToFile(List<Employee> listEmployees) {
        try (FileOutputStream fos = new FileOutputStream("Employees.dat"); ObjectOutputStream oos = new ObjectOutputStream(fos)) {
            oos.writeObject(listEmployees);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public List<Employee> readDataFromFile() {
        List<Employee> listEmployees = new ArrayList<>();
        try (FileInputStream fis = new FileInputStream("Employees.dat"); ObjectInputStream ois = new ObjectInputStream(fis)) {
            listEmployees = (List<Employee>) ois.readObject();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return listEmployees;
    }

    public void display() {
        List<Employee> listEmployees = readDataFromFile();
        for (Employee e : listEmployees) {
            System.out.println(e);
        }
    }

    public Employee createEmployee() {
        String name;
        do {
            System.out.print("Enter Name : ");
            name = scanner.nextLine();
            if (name.isEmpty()) System.out.println("Name cannot null!");
        } while (name.isEmpty());
        Date birthday;
        while (true) {
            try {
                System.out.print("Enter date with format dd/MM/yyyy : ");
                String inputDate = scanner.nextLine();
                birthday = dateFormat.parse(inputDate);
                break;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        String inoutSalary;
        int salary;
        do {
            System.out.print("Enter Salary : ");
            inoutSalary = scanner.nextLine();
            if (inoutSalary == null) System.out.println("Salary cannot null!");
        } while (inoutSalary == null);
        while (true) {
            try {
                salary = Integer.parseInt(inoutSalary);
                break;
            } catch (NumberFormatException e) {
                System.out.println("Salary only can has number!");
            }
        }
        String inputDaysOn;
        int daysOn;
        do {
            System.out.print("Enter DaysOn : ");
            inputDaysOn = scanner.nextLine();
            if (inputDaysOn == null) System.out.println("DaysOn cannot null!");
        } while (inputDaysOn == null);
        while (true) {
            try {
                daysOn = Integer.parseInt(inputDaysOn);
                break;
            } catch (NumberFormatException e) {
                System.out.println("DaysOn only can has number!");
            }
        }
        return new Employee(name, birthday, salary, daysOn);
    }

    public AdministrativeEmployee createAdministrativeEmployee() {
        Employee employee = createEmployee();
        Employee.count--;
        String inputDaysOff;
        int daysOff;
        do {
            System.out.print("Enter DaysOff : ");
            inputDaysOff = scanner.nextLine();
            if (inputDaysOff == null) System.out.println("DaysOff cannot null!");
        } while (inputDaysOff == null);
        while (true) {
            try {
                daysOff = Integer.parseInt(inputDaysOff);
                break;
            } catch (NumberFormatException e) {
                System.out.println("DaysOff only can has number!");
            }
        }
        return new AdministrativeEmployee(employee.getName(), employee.getBirthday(), employee.getSalary(), employee.getDaysOn(), daysOff);
    }

    public TechnicalEmployee createTechnicalEmployee() {
        Employee employee = createEmployee();
        Employee.count--;
        String inputProjects;
        int projects;
        do {
            System.out.print("Enter Projects : ");
            inputProjects = scanner.nextLine();
            if (inputProjects == null) System.out.println("Projects cannot null!");
        } while (inputProjects == null);
        while (true) {
            try {
                projects = Integer.parseInt(inputProjects);
                break;
            } catch (NumberFormatException e) {
                System.out.println("Projects only can has number!");
            }
        }
        return new TechnicalEmployee(employee.getName(), employee.getBirthday(), employee.getSalary(), employee.getDaysOn(), projects);
    }

    public SalesEmployee createSalesEmployee() {
        Employee employee = createEmployee();
        Employee.count--;
        String inputSales;
        int sales;
        do {
            System.out.print("Enter Sales : ");
            inputSales = scanner.nextLine();
            if (inputSales == null) System.out.println("Sales cannot null!");
        } while (inputSales == null);
        while (true) {
            try {
                sales = Integer.parseInt(inputSales);
                break;
            } catch (NumberFormatException e) {
                System.out.println("Sales only can has number!");
            }
        }
        return new SalesEmployee(employee.getName(), employee.getBirthday(), employee.getSalary(), employee.getDaysOn(), sales);
    }

    public void addEmployee() {
        List<Employee> listEmployees = readDataFromFile();
        while (true) {
            System.out.println("MenuAdd : ");
            System.out.println("1. AdministrativeEmployee");
            System.out.println("2. TechnicalEmployee");
            System.out.println("3. SalesEmployee");
            System.out.println("4. Exit Add");
            System.out.print("Enter Choice : ");
            String choice = scanner.nextLine();
            switch (choice) {
                case "1":
                    listEmployees.add(createAdministrativeEmployee());
                    writeDataToFile(listEmployees);
                    break;
                case "2":
                    listEmployees.add(createTechnicalEmployee());
                    writeDataToFile(listEmployees);
                    break;
                case "3":
                    listEmployees.add(createSalesEmployee());
                    writeDataToFile(listEmployees);
                    break;
                case "4":
                    return;
                default:
                    System.out.println("Not found Choice!");
            }
        }
    }

    public void displaySalary() {
        List<Employee> listEmployees = readDataFromFile();
        for (Employee e : listEmployees) {
            System.out.println(e.calculateMonthlySalary());
        }
    }

    public void checkIn() {
        List<Employee> listEmployees = readDataFromFile();
        String inputID;
        int id;
        do {
            System.out.print("Enter ID : ");
            inputID = scanner.nextLine();
            if (inputID == null) System.out.println("ID cannot null!");
        } while (inputID == null);
        while (true) {
            try {
                id = Integer.parseInt(inputID);
                break;
            } catch (NumberFormatException e) {
                System.out.println("ID only can has number!");
            }
        }
        for (Employee e : listEmployees) {
            if (e.getId() == id) {
                int daysOn = e.getDaysOn();
                e.setDaysOn(++daysOn);
                break;
            }
        }
        writeDataToFile(listEmployees);
    }
}
