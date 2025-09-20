package m3.ChainOfResp;

public class AuthHandler extends Handler {
    public void handle(String request) {
        if (request.equals("auth")) {
            System.out.println("Авторизация пройдена");
        } else if (next != null) {
            next.handle(request);
        }
    }
}