import java.util.Scanner;

public class Main {
    public static void main(String[] args) {


        Scanner s = new Scanner(System.in);
        System.out.println("Enter radius: ");
        double radius = s.nextDouble();
        Circle circle = new Circle(radius);
        System.out.println(circle.toString());
        System.out.println("The color is " + circle.getColor());
        System.out.println("The radius is " + circle.getRadius());
        System.out.println("The area is " + circle.getArea());
        System.out.println("The diameter is " + circle.getDiameter());

        System.out.println("Enter width of Rectangle: ");
        double width = s.nextDouble();
        System.out.println("Enter height of Rectangle: ");
        double height = s.nextDouble();
        Rectangle rectangle = new Rectangle(width, height);
        System.out.println(rectangle.toString());
        System.out.println("The area is " + rectangle.getArea());
        System.out.println("The perimeter is " + rectangle.getPerimeter());
        ;

    }
}
