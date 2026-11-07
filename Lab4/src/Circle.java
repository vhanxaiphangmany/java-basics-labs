public class Circle extends Shapes
{
    private double r;
    double pi = 3.14;

    public Circle (double r)
    {
        this.r = r;
    }
    public void area()
    {
        System.out.println("Circle area = "+pi*r*r);
    }
}
