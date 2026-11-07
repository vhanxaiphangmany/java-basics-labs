public class Circle extends shapes
{
    private int radius;
    private double area;
    double pi = 3.14;
    public Circle(int radius)
    {
        this.radius = radius;
    }
    void calArea()
    {
        area = pi*radius*radius;
        System.out.println("Circle area = "+area);
    }
}