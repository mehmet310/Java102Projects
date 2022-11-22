public class LabAsistant extends Asistant{

    public LabAsistant(String name,String surname,String email,String title,String department,int officeHour)
    {
        super(name,surname,email,title,department,officeHour);

    }

    public void enterLabs()
    {
        System.out.println(this.getName()+" "+this.getSurname()+" has entered to lab of "+this.getTitle());
    }
    public void enterLectures()
    {
        System.out.println(this.getName()+" "+this.getSurname()+" has entered to "+this.getTitle()+" lecture.");
    }
}
