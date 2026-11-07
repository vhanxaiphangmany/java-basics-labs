public class Rectangles extends Shapes
{
    private double a;
    private double h;

    public Rectangles (double a, double h)
    {
        this.a = a;
        this.h = h;
    }
    public void area()
    {
        System.out.println("Retangle ares= "+a*h);//implementation
    }
}
