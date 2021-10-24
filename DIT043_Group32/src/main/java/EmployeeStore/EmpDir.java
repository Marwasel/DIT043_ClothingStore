package EmpStore;

public class EmpDir {


    private String EmpID;
    private String EmpName;
    private String dep;
    private String degree;
    private double GrossSalary ;
    private double NetSalary ;


        public EmpDir(String EmpID, String EmpName , double unitGrossSalary, double unitNetSalary, String degree, String dep ) throws Exception {
            this.EmpID = EmpID;
            this.degree = degree;
            this.dep = dep;
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

        String getName() {
            return EmpName;
        }
        public void  setName(String EmpName){
        this.EmpName = EmpName;}

        String getDegree() {
        return degree;
    }
        void setDegree(){
        this.degree = degree;}


        String getDep() {
        return dep;
    }
        void setDep(){
        this.dep = dep;
    }


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

            return degree +" " + EmpName + "'s gross salary is " + String.format("%.2f", GrossSalary) + " SEK per month. Dept: "+ dep;
        }



}

