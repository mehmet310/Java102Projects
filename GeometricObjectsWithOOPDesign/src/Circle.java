
public class Circle extends GeometricObjects //Inheritance
{
    //global variable
    private double radius;

    //Constructors
    public Circle() {

    }

    public Circle(double radius) {
        this.radius = radius;
    }

    public Circle(double radius, String color) {
        this.radius = radius;
        setColor(color);


    }

    //Methods with get,set
    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public double getArea() //Area method of Circle
    {
        return Math.PI * radius * radius;
    }

    public double getPerimeter() //Perimeter method of Circle
    {
        return 2 * Math.PI * radius;
    }

    public double getDiameter() //Diameter method of Circle
    {
        return 2 * radius;
    }

    public void printCircle() {
        Circle c = new Circle();
        System.out.println("Radius of this circle is " + c.radius);
        System.out.println("Diameter of this circle is " + c.getDiameter());
        System.out.println("Area of this circle is " + c.getArea());
        System.out.println("Perimeter of this circle is " + c.getPerimeter());

    }

}
