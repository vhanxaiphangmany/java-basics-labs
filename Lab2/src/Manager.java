 public class Manager extends Employee
 {
     private double baseSalary;
     private double bonus;

     public Manager ( String n, String r, double s, double bonus)
     {
         super(n,r);
         baseSalary = s;
         this.bonus = bonus;

     }


     public double Salary() {
         return baseSalary + bonus; //implemetation
     }
 }


