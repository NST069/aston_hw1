package m3.Proxy;

public class Main {

    public static void main(String[] args) {
        Image image = new ProxyImage("photo.jpg");
        image.display(); // загрузка + отображение
        image.display(); // только отображение
    }
}
