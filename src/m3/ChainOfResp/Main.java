package m3.ChainOfResp;

public class Main {

    public static void main(String[] args) {
        Handler chain = new AuthHandler();
        chain.setNext(new LogHandler());

        chain.handle("auth");
        chain.handle("other");
    }
}
