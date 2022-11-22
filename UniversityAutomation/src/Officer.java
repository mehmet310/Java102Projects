public class Officer extends Personal{
    private String department;
    private String shift;
    public Officer(String name,String surname,String email,String department,String shift)
    {
        //we can set constructor at subclass by using super() keyword.

        super(name,surname,email);
        this.department=department;
        this.shift=shift;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getShift() {
        return shift;
    }

    public void setShift(String shift) {
        this.shift = shift;
    }
    public void work()
    {
        System.out.println(this.getName()+" "+this.getSurname()+" works now!");
    }
}
