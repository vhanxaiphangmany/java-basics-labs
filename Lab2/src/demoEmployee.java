public class demoEmployee
{
    public static void main(String[] args)
    {
        Employee e1 = new Manager("vhanxai","Manager",2000.0,500.0);
        Employee e2 = new programmer("alex","Programmer",1500.0,350.0);

        System.out.println("e1.getEmpName: "+e1.getEmpName());
        System.out.println("Employee Role: "+e1.getRole());
        System.out.println("Employee Salary: "+e1.Salary());

        System.out.println("e2.getEmpName: "+e2.getEmpName());
        System.out.println("Employee Role: "+e2.getRole());
        System.out.println("Employee Salary: "+e2.Salary());

    }
}
