public class Asistant extends AcademicPersonal{
    private int officeHour;
    public Asistant(String name,String surname,String email,String title,String department,int officeHour){
        super(name,surname,email,title,department);
        this.officeHour=officeHour;
    }

    public int getOfficeHour() {
        return officeHour;
    }

    public void setOfficeHour(int officeHour) {
        this.officeHour = officeHour;
    }
    public void makeQuiz()
    {
        System.out.println(this.getName()+" "+this.getSurname()+" made a quiz of "+this.getTitle()+"lecture.");
    }
}
