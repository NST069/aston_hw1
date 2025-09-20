package m3.Builder;

public class Main {

    public static void main(String[] args) {
        User user = new User.Builder()
                .setName("Иван")
                .setAge(25)
                .setEmail("ivan@gmail.com")
                .build();

        System.out.println(user);
    }
}
