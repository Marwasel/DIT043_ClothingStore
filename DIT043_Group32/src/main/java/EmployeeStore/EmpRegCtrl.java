package EmployeeStore;

import java.util.ArrayList;

public class EmpRegCtrl {

    public static ArrayList<Emp> EmpRegList = new ArrayList<Emp>();

    public static String createEmp (String EmpID, String EmpName, double GrossSalary,double NetSalary) {
        String createResult="";
        if (EmpID.isEmpty() || EmpName.isEmpty() || GrossSalary <= 0 || NetSalary <= 0) {
            createResult= "Invalid data for item.";
        } else {
            Emp emp = new Emp(EmpID, EmpName, GrossSalary,NetSalary);
            EmpRegList.add(emp);

            createResult="Employee "+EmpID+" was registered successfully";

        }

        return createResult;
    }

    public static String removeEmp (String EmpID){
        if(EmpRegList.contains(EmpID)){
            EmpRegList.remove(EmpID);
            System.out.println("Employee "+EmpID+" was successfully removed.");

        }else{
            System.out.println("Employee "+EmpID+" was not found in the database.");
        }
        return "";
    }


}
