public class IncorrectPhoneNumber extends Exception {
    public IncorrectPhoneNumber() {
        super();
    }

    public IncorrectPhoneNumber(String message) {
        super(message);
    }

    public String print() {
        return "Incorrect phone number";
    }
}
