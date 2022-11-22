public class Security extends Officer{
    private String document;
    public Security(String name,String surname,String email,String department,String shift,String document)
    {
        super(name, surname, email, department, shift);
        this.document=document;
    }

    public String getDocument() {
        return document;
    }

    public void setDocument(String document) {
        this.document = document;
    }

    public void watching()
    {
        System.out.println(this.getName()+" "+this.getSurname()+" delivered these "+this.document +" and started to watch.");
    }
}
