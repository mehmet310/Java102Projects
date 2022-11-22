public class AcademicPersonal extends Personal {
    private String title;
    private String department;

    public AcademicPersonal(String name, String surname, String email, String title, String department) {
        super(name, surname, email);
        this.department = department;
        this.title = title;

    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
    public String getDepartment(){
        return this.department;
    }
    public void setDepartment(String department)
    {
        this.department=department;
    }

    public void entranceToLecture()
    {
        System.out.println(this.getName()+" "+this.getSurname()+" has entered to lecture!");
    }
}
