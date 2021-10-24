package Employee;

import Clothing_Store.Menu;
import Clothing_Store.UserInput;

import facade.Facade;


public class EmployeeeInput2 {

    Facade facade = new Facade();

    // Temporarily. It should be only in Facade
   // private static ArrayList<EmpReg> EmpRegList = new ArrayList<>();
   // private static ArrayList<EmpMan> EmpManList = new ArrayList<>();
   // private static ArrayList<EmpDir> EmpDirList = new ArrayList<>();
   // private static ArrayList<EmpInt> EmpIntList = new ArrayList<>();


    int input = -1;
    public static void main(String[] args) throws Exception {

        EmployeeeInput2 menu  = new EmployeeeInput2();
        System.out.print(menu.input);
        menu.EmpMenu();


    }




    public void EmpMenu() throws Exception {


        do {

            System.out.println("Please choose among the options below.");
            System.out.println("0. Return to Main Menu.");
            System.out.println("1. Create an employee (Regular Employee).");
            System.out.println("2. Create an employee (Manager).");
            System.out.println("3. Create an employee (Director).");
            System.out.println("4. Create an employee (Intern).");
            System.out.println("5. Remove an employee.");
            System.out.println("6. Print specific employee.");
            System.out.println("7. Print all registered employees.");
            System.out.println("8. Print the total expense with net salary.");
            System.out.println("9. Print all employees sorted by gross salary.");

            input = UserInput.readInt("Type an option number: ");

            switch (input) {
                case 0:
                    System.exit(0);
                    break;
                case 1:
                    CreateAnEmployee_RegularEmployee();
                    break;
                case 2:
                    CreateAnEmployee_ManagerEmployee();
                    break;
                case 3:
                    CreateAnEmployee_DirectorEmployee();
                    break;
                case 4:
                    CreateAnEmployee_InternEmployee();
                    break;
                case 5:
                    String removeId = UserInput.readLine("Type the Employee's ID you want to remove: ");

                    String messageRemove = facade.removeEmployee(removeId);
                    System.out.println(messageRemove);

                    break;
                case 6:
                    String PrintId = UserInput.readLine("Type the Employee's ID you want to print: ");
                    String messagePrint = facade.printEmployee(PrintId);
                    System.out.println(messagePrint);

                    break;
                case 7:
                    System.out.println("All registered employees:");
                    String messagePrintAll = facade.printAllEmployees();
                    System.out.println(messagePrintAll);
                    //EmpRegList.forEach(System.out::println);
                    //EmpManList.forEach(System.out::println);
                    //EmpDirList.forEach(System.out::println);
                    //EmpIntList.forEach(System.out::println);

                    break;
                case 8:
                    Double messagePrintTotNet = facade.getTotalNetSalary();
                    System.out.println(messagePrintTotNet);
                    break;
                case 9:

                    //facade.PrintSortedEmployee();
                    break;
                default:
                    System.out.println("Invalid input. Try again!");
                    break;
            }
        } while (input > 0 && input < 9);
    }

    void CreateAnEmployee_RegularEmployee()  throws Exception {
        String EmpID = UserInput.readLine("Type the employee's ID: ");
        String EmpName = UserInput.readLine("Type the employee's name: ");

        double GrossSalary_unround = UserInput.readDouble("Type the employee's gross salary ");
        double GrossSalary = Math.round(GrossSalary_unround*100.0)/100.0;

        String message = facade.createEmployee(EmpID, EmpName, GrossSalary);
        System.out.println(message);

        //

    }
    void CreateAnEmployee_ManagerEmployee()  throws Exception {
        String EmpID = UserInput.readLine("Type the employee's ID: ");
        String EmpName = UserInput.readLine("Type the employee's name: ");
        String degree = UserInput.readLine("Type his/her academic degree (BSc,Msc,Phd) :");
        double GrossSalary_unround = UserInput.readDouble("Type the employee's gross salary ");
        double GrossSalary = Math.round(GrossSalary_unround * 100.0) / 100.0;

        String message = facade.createEmployee(EmpID, EmpName, GrossSalary,degree);
        System.out.println(message);

    }

    void CreateAnEmployee_DirectorEmployee() throws Exception {

        String EmpID = UserInput.readLine("Type the employee's ID: ");
        String EmpName = UserInput.readLine("Type the employee's name: ");
        String degree = UserInput.readLine("Type his/her academic degree (BSc,Msc,Phd) :");
        String dep = UserInput.readLine("Type his/her department :");
        double GrossSalary_unround = UserInput.readDouble("Type the employee's gross salary ");
        double GrossSalary = Math.round(GrossSalary_unround*100.0)/100.0;


        String message = facade.createEmployee(EmpID, EmpName, GrossSalary,degree,dep);
        System.out.println(message);

        //

    }
    void CreateAnEmployee_InternEmployee() throws Exception {
        int GPA;
        String EmpID = UserInput.readLine("Type the employee's ID: ");
        String EmpName = UserInput.readLine("Type the employee's name: ");
        GPA = UserInput.readInt("Type his/her GPA :");
        double GrossSalary_unround = UserInput.readDouble("Type the employee's gross salary ");
        double GrossSalary = Math.round(GrossSalary_unround*100.0)/100.0;

        String message = facade.createEmployee(EmpID, EmpName, GrossSalary,GPA);
        System.out.println(message);


        //

    }


}

