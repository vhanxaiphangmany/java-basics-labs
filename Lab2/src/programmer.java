public class programmer extends  Employee
{
    private double baseSalary;
    private double OT;

    public programmer(String n, String r, double s, double ot)
    {
        super(n,r);
        baseSalary = s;
        OT = ot;
    }
        public double Salary()
        {
            return  baseSalary + OT;
        }
}
