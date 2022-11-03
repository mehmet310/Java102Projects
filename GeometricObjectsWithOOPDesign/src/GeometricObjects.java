import java.util.Date;

//Main class
public class GeometricObjects {
    //Global variables
    private String color = "white";
    private boolean isFilled = false;
    private Date dateTime;

    //Default Constructor
    public GeometricObjects() {
        dateTime = new java.util.Date();

    }

    //Constructor With Parameters
    public GeometricObjects(String color, boolean isFilled) {
        this.color = color;
        this.isFilled = isFilled;
        dateTime = new java.util.Date();

    }

    //Methods with getter,setter methods
    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public boolean isFilled() {
        return isFilled;
    }

    public void setFilled(boolean isFilled) {
        this.isFilled = isFilled;
    }

    public Date getDateCreated() {
        return dateTime;
    }

    @Override //Override for toString()
    public String toString() {
        GeometricObjects go = new GeometricObjects();
        return "The color of this geometric object is " + go.color + " is itFilled? " + go.isFilled + " and its created time is " + go.getDateCreated();
    }


}
