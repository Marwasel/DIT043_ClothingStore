package EmpStore;

public class EmpReg {


    private String EmpID;
    private String EmpName;
    private double GrossSalary ;
    private double NetSalary ;


        public EmpReg(String EmpID, String EmpName , double unitGrossSalary, double unitNetSalary ) throws Exception {
            this.EmpID = EmpID;
            this.EmpName = EmpName;
            this.GrossSalary = unitGrossSalary;
            this.NetSalary = unitNetSalary;
        }


        public String getEmpID(){
            return this.EmpID;
        }
        void setEmpID(){
            this.EmpID = EmpID;
        }

        public String getName() {
            return EmpName;
        }
        public void  setName(String EmpName){
            this.EmpName = EmpName;}

        double getGrossSalary() {
            return GrossSalary;
        }
        void setGrossSalary() {this.GrossSalary = GrossSalary;
        }

        public Double getNetSalary() {
        return NetSalary;
    }
        void setNetSalary() {
        this.NetSalary = NetSalary;
    }


        @Override
        public String toString() {

            return EmpName + "'s gross salary is " + String.format("%.2f", GrossSalary) + " SEK per month.";
        }



}

