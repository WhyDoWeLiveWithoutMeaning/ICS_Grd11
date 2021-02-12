/**
 * This Program Reads the files and returns the names in string[] array
 *
 * @author Eric Beaulne
 * 2021/02/10
 */

package eric.projects.PersonAssignment;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Names {

    static final String path = "";

    public static String[] getFirstNames() {
        String[] firstNames = new String[100]; //

        try {
            File names = new File(path + "firstnames.txt");
            Scanner in = new Scanner(names);
            for(int i = 0; in.hasNextLine(); i++){
                firstNames[i] = in.nextLine();
            }
            in.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        return firstNames;
    }

    public static String[] getLastNames() { //Method to read and get last Names
        String[] firstNames = new String[100];

        try {
            File names = new File(path + "surnames.txt");
            Scanner in = new Scanner(names);
            for(int i = 0; in.hasNextLine(); i++){
                firstNames[i] = in.nextLine();
            }
            in.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        return firstNames;
    }
}
