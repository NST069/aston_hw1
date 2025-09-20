package m3.ChainOfResp;

public class LogHandler extends Handler {
    public void handle(String request) {
        System.out.println("Логируем запрос: " + request);
        if (next != null) {
            next.handle(request);
        }
    }
}