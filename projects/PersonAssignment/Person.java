package eric.projects.PersonAssignment;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Person {

    private String firstName;
    private String lastName;
    private LocalDate dateOfBirth;

    Person(){
        firstName = "Unknown";
        lastName = "Unknown";
        dateOfBirth = LocalDate.now();
    }

    Person(String fName, String lName, String dOB){
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        firstName = fName;
        lastName = lName;
        dateOfBirth = LocalDate.parse(dOB, dateTimeFormatter);
    }

    Person(String fName, String lName, LocalDate dOB){
        firstName = fName;
        lastName = lName;
        dateOfBirth = dOB;
    }

    public String getFirstName(){
        return firstName;
    }

    public void setFirstName(String name){
        firstName = name;
    }

    public String getLastName(){
        return lastName;
    }

    public void setLastName(String name){
        lastName = name;
    }

    public LocalDate getDateOfBirth(){
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dob){
        dateOfBirth = dob;
    }

    @Override
    public String toString(){
        return String.format("First Name: %s | Last Name: %s | Date Of Birth: %s", firstName, lastName, dateOfBirth.toString());
    }

    public boolean equals(Person user){
        if (user.getFirstName().equals(firstName)){
            if (user.getLastName().equals(lastName)){
                if(user.getDateOfBirth().equals(dateOfBirth)){
                    return true;
                }
            }
        }
        return false;
    }

    public int compareTo(Person user){
        int firstNameCompare = firstName.compareTo(user.getFirstName());
        if (firstNameCompare == 0){
            int lastNameCompare = lastName.compareTo(user.getLastName());
            if (lastNameCompare == 0) {
                int dateOfBirthCompare = dateOfBirth.compareTo(user.getDateOfBirth());
                if (dateOfBirthCompare == 0) {
                    return 0;
                } else if (dateOfBirthCompare > 0){
                    return 1;
                } else {
                    return -1;
                }
            } else if (lastNameCompare > 0){
                return 1;
            } else {
                return -1;
            }
        } else if (firstNameCompare > 0){
            return 1;
        } else {
            return -1;
        }
    }
}
