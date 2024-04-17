import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        Student studentOne = new Student(
                "Vadim", 32, 89676400941l, "sotnikov.v.v@mail.ru");

        Student studentTwo = new Student(
                "Alex", 39, 89676400942l, "rybyhin.a.v@mail.ru");

        Student studentThree = new Student(
                "Seva", 30, 89676400943l, "ostrovscki.v.a@mail.ru");

        Student studentFour = new Student(
                "Rad", 14, 89676400944l, "juravlev.r.k@mail.ru");

        Student studentFive = new Student(
                "Sasha", 20, 89676400945l, "karpinskiy.v.v@mail.ru");

        Student studentSix = new Student(
                "Ulyana", 16, 89676400946l, "frolova.u.i@mail.ru");

        Student studentSeven = new Student(
                "Dima", 17, 89676400947l, "minosyan.d.v@mail.ru");

        Student studentEight = new Student(
                "Andry", 16, 89676400948l, "grigorov.a.g@mail.ru");

        Student studentNine = new Student(
                "Andry", 16, 89676400948l, "grigorov.a.g@mail.ru");

        Student studentTen = new Student(
                "Mike", 23, 89676400948l, "muramail.ru");

        Student studentEleven = new Student(
                "Gregory", 26, 896764009481111111l, "avosin@mail.ru");

//        Client clientTwelve = null;
//        System.out.println(clientTwelve.toString());

        while (true) {
            System.out.println("Input on the console command \"PrintInformationAboutClients\", \"Remove\":");
            String command = new Scanner(System.in).nextLine();
            if (command.equals("PrintInformationAboutClients")) {
                Student.printInformationAboutClients();
            } else if (command.equals("Remove")) {
                System.out.println("Input criterion for remove client: ");
                long number = new Scanner(System.in).nextLong();
                Student.removeClient(number);
            }
        }
    }
}
