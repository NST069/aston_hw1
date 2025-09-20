package m3.Decorator;

public class Main {

    public static void main(String[] args) {
        Notifier notifier = new SMSNotifier(new EmailNotifier());
        notifier.send("text");
    }
}
