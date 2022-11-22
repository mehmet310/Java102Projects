public class Lecturer extends AcademicPersonal{
    private int doorNumber;
    public Lecturer(String name, String surname, String email, String department, String title, int doorNumber)
    {
        super(name,surname,email,department,title);
        this.doorNumber=doorNumber;

    }

    public int getDoorNumber()
    {
        return this.doorNumber;
    }
    public void setDoorNumber(int doorNumber)
    {
        this.doorNumber=doorNumber;
    }

    public void meetingSenate()
    {
        System.out.println(this.doorNumber+" door number of "+this.getName()+" was at meeting. ");
    }
    public void makeExam()
    {
        System.out.println(this.getName()+" "+this.getTitle()+" made an exam ");
    }
}
