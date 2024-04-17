public class IncorrectEmail extends Exception {
    public IncorrectEmail() {
        super();
    }

    public IncorrectEmail(String message) {
        super(message);
    }

    public String print() {
        return "Incorrect email";
    }
}
