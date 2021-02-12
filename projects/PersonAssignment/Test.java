/**
 * This Program makes 100 Random People and Displays their Values
 *
 * @Author Eric Beaulne
 * 2021/02/10
 */
package eric.projects.PersonAssignment;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

public class Test {
    public static void main(String[] args){

        //Get all names
        String[] firstNames = Names.getFirstNames();
        String[] lastNames = Names.getLastNames();

        Person[] people = new Person[100];

        for (int i = 0; i < people.length; i++){
            String randomFirstName = randomChoice(firstNames);
            String randomLastname = randomChoice(lastNames);
            LocalDate randomDateOfBirth = randomDate();
            people[i] = new Person(randomFirstName, randomLastname, randomDateOfBirth);
        }

        for (int k = 0; k < people.length; k++) {
            System.out.println("User "+ (k + 1) + "| " + people[k].toString());
        }

        Arrays.sort(people);
        System.out.println();

        for (int k = 0; k < people.length; k++) {
            System.out.println("User "+ (k + 1) + "| " + people[k].toString());
        }
    }

    public static String randomChoice(String[] arr){
        int choice = (int) (Math.random() * arr.length);
        return arr[choice];
    }

    public static LocalDate randomDate(){
        long minDay = LocalDate.of(2003, 1, 1).toEpochDay();
        long maxDay = LocalDate.of(2006, 12, 31).toEpochDay();
        long randomDay = ThreadLocalRandom.current().nextLong(minDay, maxDay);
        LocalDate randomDate = LocalDate.ofEpochDay(randomDay);
        return randomDate;
    }

    public static LocalDate randomDate(int min, int max){
        long minDay = LocalDate.of(min, 1, 1).toEpochDay();
        long maxDay = LocalDate.of(max, 12, 31).toEpochDay();
        long randomDay = ThreadLocalRandom.current().nextLong(minDay, maxDay);
        LocalDate randomDate = LocalDate.ofEpochDay(randomDay);
        return randomDate;
    }
}
