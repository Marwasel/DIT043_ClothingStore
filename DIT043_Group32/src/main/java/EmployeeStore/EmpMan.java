package EmpStore;

public class EmpMan {


    private String EmpID;
    private String EmpName;
    private String degree;
    private double GrossSalary ;
    private double NetSalary ;


        public EmpMan(String EmpID, String EmpName , double unitGrossSalary, double unitNetSalary, String degree ) throws Exception {
            this.EmpID = EmpID;
            this.EmpName = EmpName;
            this.degree = degree;
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

        public String getDegree() {
        return degree;
    }
        void setDegree(){
        this.degree = degree;
    }

        public double getGrossSalary() {
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

            return degree +" " + EmpName + "'s gross salary is " + String.format("%.2f", GrossSalary) + " SEK per month.";
        }



}

