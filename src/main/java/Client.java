import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.*;

public class Client {
//    Logger logger = LoggerFactory.getLogger(Client.class);
    Logger loggerAddingClient = LogManager.getLogger(Client.class);
    Logger loggerIncorrectInformation = LogManager.getLogger(Client.class);
    private String name; //Mike
    private int age; //23
    private String email; //mura.m.v@email.ru
    private long phoneNumber; //89676400941
    private String regexForPhoneNumber = "8[0-9]{10}";
    private static ArrayList<Client> setClients = new ArrayList<>();

    public Client(String name, int age, long phoneNumber, String email) throws Exception {
        try {
            this.name = name;
            this.age = age;

            if (email.contains("@")) {
                this.email = email;
            } else {
                email = null;
                IncorrectEmail incorrectEmail = new IncorrectEmail("Work with email!");
//                logger.error(incorrectEmail.print() + " from \"" + name + "\"");
                loggerIncorrectInformation.error(incorrectEmail.print() + " from \"" + name + "\"");
            }

            if (String.valueOf(phoneNumber).matches(regexForPhoneNumber)) {
                this.phoneNumber = phoneNumber;
            } else {
                phoneNumber = 0;
                IncorrectPhoneNumber incorrectPhoneNumber =  new IncorrectPhoneNumber();
//                logger.error(incorrectPhoneNumber.print() + " from \"" + name + "\"");
                loggerIncorrectInformation.error(incorrectPhoneNumber.print() + " from \"" + name + "\"");
            }

            if (email != null && phoneNumber != 0 && !setClients.contains(this)) {
                setClients.add(this);
//                logger.info("Added user \"" + name + "\"");
//                logger.debug("Added user \"" + name + "\"");
                loggerAddingClient.info("Added user \"" + name + "\"");
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
        Client client = (Client) o;
        return age == client.age && phoneNumber == client.phoneNumber && Objects.equals(name, client.name) && Objects.equals(email, client.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age, email, phoneNumber);
    }

    public static void printInformationAboutClients() {
        Collections.sort(setClients, Comparator.comparing(Client::getName));
        for (Client client : setClients) {
            System.out.println(
                    "Information about client \"" + client.getName() + "\":\n" + client
            );
        }
    }

    public static void removeClient(long phoneNumber) {
        Iterator<Client> clientIterator = setClients.iterator();
        while (clientIterator.hasNext()) {
            Client client = clientIterator.next();
            String name = client.getName();
            if (client.getPhoneNumber() == phoneNumber) {
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
