package EmpStore;

public class EmpInt {


    private String EmpID;
    private String EmpName;
    private int gpa;
    private double GrossSalary ;
    private double NetSalary ;


        public EmpInt(String EmpID, String EmpName , double unitGrossSalary, double unitNetSalary, int gpa ) throws Exception {
            this.EmpID = EmpID;
            this.EmpName = EmpName;
            this.gpa = gpa;
            this.GrossSalary = unitGrossSalary;
            this.NetSalary = unitNetSalary;
        }


        public String getEmpID(){
            return this.EmpID;
        }
        void setEmpID(){
            this.EmpID = EmpID;
        }

        String getName() {
            return this.EmpName;
        }
        public void  setName(String EmpName){
        this.EmpName = EmpName;}

        public int getGPA() {
        return gpa;
    }
        public void  setGPA(int gpa){
        this.gpa = gpa;}

        public  double getGrossSalary(){
        return this.GrossSalary;}

        public void  setGrossSalary(double GrossSalary){
        this.GrossSalary = GrossSalary;}

        public Double getNetSalary() {
        return NetSalary;
    }
        void setNetSalary() {
        this.NetSalary = NetSalary;
    }


        @Override
        public String toString() {

            return EmpName + "'s gross salary is " + String.format("%.2f", GrossSalary) + " SEK per month. GPA: "+gpa;
        }



}

