package m3.Decorator;

public class EmailNotifier implements Notifier {
    public void send(String message) {
        System.out.println("Отправка email: " + message);
    }
}
