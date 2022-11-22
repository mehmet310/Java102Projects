public class ComputingDepartment extends Officer{
    private String task;
    public ComputingDepartment(String name,String surname,String email,String department,String shift,String task)
    {
        super(name,surname,email,department,shift);
        this.task=task;
    }

    public String getTask() {
        return task;
    }

    public void setTask(String task) {
        this.task = task;
    }

    public void setUpNetworking()
    {
        System.out.println(this.getName()+" "+this.getSurname()+" started to set up network at "+this.task);
    }
}
