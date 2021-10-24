package Clothing_Store;

import EmployeeStore.Emp;


import java.util.ArrayList;


public class EmployeeMenu {



        private static ArrayList<Emp> EmpRegList = new ArrayList<Emp>();
        private static ArrayList<Emp> EmpManList = new ArrayList<Emp>();
        private static ArrayList<Emp> EmpDirList = new ArrayList<Emp>();
        private static ArrayList<Emp> EmpIntList = new ArrayList<Emp>();


        int input = -1;
        public static void main(String[] args) throws Exception {

            EmployeeMenu  menu  = new EmployeeMenu ();
            System.out.print(menu.input);
            menu.openEmployeeOptions();


        }

//Had to remove throws exception because this menu needed to be connected to the main menu first and it was not possible with the exception
        public void openEmployeeOptions() {


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

                        // Find the item in the database
                        if(EmpRegList.contains(removeId)) {
                            EmpRegList.remove(removeId);
                            System.out.println("Employee " + removeId + " was successfully removed.");
                        }else if(EmpDirList.contains(removeId)){
                            EmpRegList.remove(removeId);
                            System.out.println("Employee "+removeId+" was successfully removed.");
                        }else if(EmpIntList.contains(removeId)){
                            EmpRegList.remove(removeId);
                            System.out.println("Employee "+removeId+" was successfully removed.");
                        }else if(EmpManList.contains(removeId)){
                            EmpRegList.remove(removeId);
                            System.out.println("Employee "+removeId+" was successfully removed.");
                        }else{
                            System.out.println("Employee "+removeId+" was not found in the database.");
                        }
                        break;
                    case 6:
                        String PrintId = UserInput.readLine("Type the Employee's ID you want to print: ");
                        if(EmpRegList.contains(PrintId)) {
                            System.out.println( PrintId );
                        }else if(EmpDirList.contains(PrintId)){
                            System.out.println( PrintId );
                        }else if(EmpIntList.contains(PrintId)){
                            System.out.println( PrintId );
                        }else if(EmpManList.contains(PrintId)){
                            System.out.println( PrintId );
                        }else{
                            System.out.println("Employee "+PrintId+" was not found in the database.");
                        }
                        break;
                    case 7:
                        System.out.println("All registered employees:");
                        EmpRegList.forEach(System.out::println);
                        EmpManList.forEach(System.out::println);
                        EmpDirList.forEach(System.out::println);
                        EmpIntList.forEach(System.out::println);

                        break;
                    case 8:

                        //facade.getTotalNetSalary();
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

        void CreateAnEmployee_RegularEmployee()  {
            int input;
            String EmpID = UserInput.readLine("Type the employee's ID: ");
            String EmpName = UserInput.readLine("Type the employee's name: ");

            double GrossSalary_unround = UserInput.readDouble("Type the employee's gross salary ");
            double GrossSalary = Math.round(GrossSalary_unround*100.0)/100.0;
            double NetSalary_unround = GrossSalary-0.1*GrossSalary;
            double NetSalary = Math.round(NetSalary_unround*100.0)/100.0;

            if (EmpID.isEmpty() || EmpName.isEmpty() || GrossSalary <= 0 || NetSalary <= 0) {
                System.out.println("Invalid data for item.");
            } else {
                Emp emp = new Emp(EmpID, EmpName, GrossSalary,NetSalary);
                EmpRegList.add(emp);
                System.out.println("Employee "+EmpID+" was registered successfully");

            }

            //

        }
        void CreateAnEmployee_ManagerEmployee()  {
            String EmpID = UserInput.readLine("Type the employee's ID: ");
            String EmpName = UserInput.readLine("Type the employee's name: ");
            String degree = UserInput.readLine("Type his/her academic degree (BSc,Msc,Phd) :");
            double GrossSalary_unround = UserInput.readDouble("Type the employee's gross salary ");
            double GrossSalary = Math.round(GrossSalary_unround * 100.0) / 100.0;

            double NetSalary_unround = GrossSalary - 0.1 * GrossSalary;
            double NetSalary = Math.round(NetSalary_unround * 100.0) / 100.0;

            switch (degree) {
                case "BSc":
                    GrossSalary = GrossSalary*1.1;
                    NetSalary = NetSalary*1.1;
                    System.out.println("BSc." + EmpName + "'s gross salary is " + GrossSalary + "SEK per month");
                    break;
                case "MSc":

                    GrossSalary = GrossSalary*1.2;
                    NetSalary = NetSalary*1.2;
                    System.out.println("MSc." + EmpName + "'s gross salary is " + GrossSalary + "SEK per month");
                    break;

                case "PhD":

                    GrossSalary = GrossSalary*1.35;
                    NetSalary = NetSalary*1.35;
                    System.out.println("PhD." + EmpName + "'s gross salary is " + GrossSalary + "SEK per month");
                    break;
                //

            }

            if (EmpID.isEmpty() || EmpName.isEmpty() || GrossSalary <= 0 || NetSalary <= 0) {
                System.out.println("Invalid data for item.");
            } else {
                Emp emp = new Emp(EmpID, EmpName, GrossSalary,NetSalary);
                EmpManList.add(emp);
                System.out.println("Employee "+EmpID+" was registered successfully");

            }

        }

        void CreateAnEmployee_DirectorEmployee() {

            String EmpID = UserInput.readLine("Type the employee's ID: ");
            String EmpName = UserInput.readLine("Type the employee's name: ");
            String degree = UserInput.readLine("Type his/her academic degree (BSc,Msc,Phd) :");
            double GrossSalary_unround = UserInput.readDouble("Type the employee's gross salary ");
            double GrossSalary = Math.round(GrossSalary_unround*100.0)/100.0;
            double NetSalary_unround = GrossSalary-0.1*GrossSalary;
            double NetSalary = Math.round(NetSalary_unround*100.0)/100.0;

            switch (degree) {
                case "BSc":
                    GrossSalary = GrossSalary*1.1 +5000;
                    System.out.println("BSc." + EmpName + "'s gross salary is " + GrossSalary + "SEK per month");
                    break;
                case "MSc":

                    GrossSalary = GrossSalary*1.2 +5000;
                    System.out.println("MSc." + EmpName + "'s gross salary is " + GrossSalary + "SEK per month");
                    break;

                case "PhD":
                    GrossSalary = GrossSalary*1.35 +5000;
                    System.out.println("PhD." + EmpName + "'s gross salary is " + GrossSalary + "SEK per month");
                    break;
                //

            }
            if (GrossSalary<30000){
                GrossSalary=GrossSalary - 0.1 * GrossSalary;

            }else if ((GrossSalary>30000)&(GrossSalary<50000)){
                GrossSalary=GrossSalary - 0.2 * GrossSalary;

            }else if (GrossSalary>50000){
                GrossSalary=GrossSalary - 0.2 * 30000- 0.4 * (GrossSalary-30000);
            }

            if (EmpID.isEmpty() || EmpName.isEmpty() || GrossSalary <= 0 || NetSalary <= 0) {
                System.out.println("Invalid data for item.");
            } else {
                Emp emp = new Emp(EmpID, EmpName, GrossSalary,NetSalary);
                EmpDirList.add(emp);
                System.out.println("Employee "+EmpID+" was registered successfully");

            }


            //

        }
        void CreateAnEmployee_InternEmployee() {
            double input;
            String EmpID = UserInput.readLine("Type the employee's ID: ");
            String EmpName = UserInput.readLine("Type the employee's name: ");
            input = UserInput.readDouble("Type his/her GPA :");
            double GrossSalary_unround = UserInput.readDouble("Type the employee's gross salary ");
            double GrossSalary = Math.round(GrossSalary_unround*100.0)/100.0;
            double NetSalary_unround = GrossSalary-0.1*GrossSalary;
            double NetSalary = Math.round(NetSalary_unround*100.0)/100.0;


            if (input<5){
                GrossSalary=0;
                NetSalary=0;

            }else if ((input>5)&(input<8)){
                GrossSalary=GrossSalary;
                NetSalary=GrossSalary;

            }else if (input>8){
                GrossSalary=GrossSalary+1000;
                NetSalary=GrossSalary;
            }

            if (EmpID.isEmpty() || EmpName.isEmpty() || GrossSalary <= 0 || NetSalary <= 0) {
                System.out.println("Invalid data for item.");
            } else {
                Emp emp = new Emp(EmpID, EmpName, GrossSalary,NetSalary);
                EmpIntList.add(emp);
                System.out.println("Employee "+EmpID+" was registered successfully");

            }




        }


    }



