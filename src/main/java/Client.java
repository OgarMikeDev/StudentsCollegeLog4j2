import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.*;

public class Student {
//    Logger logger = LoggerFactory.getLogger(Client.class);
    Logger loggerAddingClient = LogManager.getLogger(Student.class);
    Logger loggerIncorrectInformation = LogManager.getLogger(Student.class);
    Logger loggerConsole = LogManager.getLogger(Student.class);
    private static int count = 0;
    private String name; //Mike
    private int age; //23
    private String email; //mura.m.v@email.ru
    private long phoneNumber; //89676400941
    private String regexForPhoneNumber = "8[0-9]{10}";
    private static ArrayList<Student> setStudents = new ArrayList<>();

    public Student(String name, int age, long phoneNumber, String email) throws Exception {
        try {
            this.name = name;
            this.age = age;

            if (email.contains("@")) {
                this.email = email;
            } else {
                email = null;
                IncorrectEmail incorrectEmail = new IncorrectEmail("Work with email!");
//                logger.error(incorrectEmail.print() + " from \"" + name + "\"");
                loggerIncorrectInformation.error(incorrectEmail.print() + " from \"" + name + "\".");
            }

            if (String.valueOf(phoneNumber).matches(regexForPhoneNumber)) {
                this.phoneNumber = phoneNumber;
            } else {
                phoneNumber = 0;
                IncorrectPhoneNumber incorrectPhoneNumber =  new IncorrectPhoneNumber();
//                logger.error(incorrectPhoneNumber.print() + " from \"" + name + "\"");
                loggerIncorrectInformation.error(incorrectPhoneNumber.print() + " from \"" + name + "\".");
            }

            if (email != null && phoneNumber != 0 && !setStudents.contains(this)) {
                setStudents.add(this);
//                logger.info("Added user \"" + name + "\"");
//                logger.debug("Added user \"" + name + "\"");
                count++;
                loggerAddingClient.info(count + ". Added user \"" + name + "\".");
                loggerConsole.debug("Successful added student \""  + name + "\".");
            }
        } catch (Exception ex) {
            if (!email.contains("@")) {
                throw new IncorrectEmail("Invalid email exception!");
            }
            throw ex;
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public long getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(long phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return age == student.age && phoneNumber == student.phoneNumber && Objects.equals(name, student.name) && Objects.equals(email, student.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age, email, phoneNumber);
    }

    public static void printInformationAboutClients() {
        Collections.sort(setStudents, Comparator.comparing(Student::getName));
        for (Student student : setStudents) {
            System.out.println(
                    "Information about client \"" + student.getName() + "\":\n" + student
            );
        }
    }

    public static void removeClient(long phoneNumber) {
        Iterator<Student> clientIterator = setStudents.iterator();
        while (clientIterator.hasNext()) {
            Student student = clientIterator.next();
            String name = student.getName();
            if (student.getPhoneNumber() == phoneNumber) {
                clientIterator.remove();
                System.out.println("Client \"" + name + "\" removed!");
            }
        }
    }

    @Override
    public String toString() {
        return "Name \"" + getName() + "\"," +
                "\nAge \"" + getAge() + "\"," +
                "\nEmail \"" + getEmail() + "\"," +
                "\nPhone number " + getPhoneNumber() + ".\n";
    }
}
