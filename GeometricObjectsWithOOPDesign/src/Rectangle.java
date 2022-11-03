
public class Rectangle extends GeometricObjects {
    //Global variables
    private double width;
    private double height;

    //Constructors
    public Rectangle() {

    }

    public Rectangle(double width, double height) {
        this.height = height;
        this.width = width;

    }

    public Rectangle(double width, double height, String color) {
        this.height = height;
        this.width = width;
        setColor(color);
    }

    //Methods with get,set
    public double getWidth() {
        return this.width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public double getHeigth() {
        return this.height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getArea() //Area of Rectangle
    {
        return width * height;
    }

    public double getPerimeter() //Perimeter of Rectangle
    {
        return 2 * (width + height);
    }

    public void printRectangle() {
        Rectangle r = new Rectangle();
        System.out.println("Width of this rectangle is " + r.width);
        System.out.println("Height of this rectangle is " + r.height);
        System.out.println("Area of this rectangle is " + r.getArea());
        System.out.println("Perimeter of this rectangle is " + r.getPerimeter());

    }


}
