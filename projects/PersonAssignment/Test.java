package eric.projects.PersonAssignment;

public class Test {
    public static void main(String[] args){
        Person eric = new Person("Eric", "Beaulne", "25/07/2004");
        Person eric2 = new Person();
        System.out.println(eric.toString());
        System.out.println(eric.equals(eric2));
        System.out.println(eric2.toString());
        System.out.println(eric.compareTo(eric2));
    }
}
