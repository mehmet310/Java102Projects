public class Main {
    public static void main(String[] args) {

        Personal personal = new Personal("Mehmet", "456465465", "marikan@gmail.com");
        Officer officer = new Officer("Erva", "Serra", "ervaserra@yahoo.com", "Physics", "09:00-18:00");
        Lecturer lecturer = new Lecturer("Kerem", "Yılmaz", "aya@hotmail.com", "Math", "Prof", 2);

        AcademicPersonal apersonal= new AcademicPersonal("Eray"," Özmen","erayayaya@gmail.com"," Assist. Prof. Dr. "," History");

        officer.work();
        lecturer.makeExam();
        apersonal.entranceToLecture();
        personal.exit();
    }
}
