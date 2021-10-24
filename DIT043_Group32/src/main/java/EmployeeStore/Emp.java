package EmployeeStore;

public class Emp {


    private String EmpID;
    private String EmpName;
    private double GrossSalary ;
    private double NetSalary ;


        public Emp(String EmpID, String EmpName , double unitGrossSalary, double unitNetSalary ) {
            this.EmpID = EmpID;
            this.EmpName = EmpName;
            this.GrossSalary = unitGrossSalary;
            this.NetSalary = unitNetSalary;
        }


        String getEmpID(){
            return EmpID;
        }
        void setEmpID(){
            this.EmpID = EmpID;
        }

        String getName() {
            return EmpName;
        }
        void setName(){
            this.EmpName = EmpName;
        }

        double getunitGrossSalary() {
            return GrossSalary;
        }
        void setunitGrossSalary() {this.GrossSalary = GrossSalary;
        }

        double getunitNetSalary() {
        return NetSalary;
    }
        void setunitNetSalary() {
        this.NetSalary = NetSalary;
    }


        @Override
        public String toString() {

            return EmpID + ","	 + EmpName + "," + GrossSalary + "SEK" + "," + NetSalary + "SEK";
        }



}

