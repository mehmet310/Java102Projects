public class Personal {
    private String name;
    private String surname;
    private String email;


    public Personal(String name, String surname, String email) {

        this.name = name;
        this.surname = surname;
        this.email = email;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return this.surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void entrance() {

        System.out.println(this.name +" "+this.surname+ "  has entraced to office");

    }

    public void exit() {

        System.out.println(this.name +" "+this.surname+ " has exited from the office");


    }

    public void lunchroom() {
        System.out.println(this.name + " "+this.surname+" has come to lunchroom to eat");
    }

}
