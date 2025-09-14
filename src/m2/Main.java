package m2;

public class Main {

    public static void main(String[] args){
        System.out.println("Модуль 2");

        String path = System.getProperty("user.dir");
        try{
            System.out.println(FileHandler.readFile(path + "\\src\\m2\\in.txt"));
        }
        catch (CustomFileException e){
            System.out.println(e);
        }

        try{
            FileHandler.writeToFile(path+"\\src\\m2\\out.txt", "Идёт Райан Гослинг по лесу, видит: машина стоит. Сел в неё, подождал ровно 5 минут и уехал.");
            System.out.println(FileHandler.readFile(path + "\\src\\m2\\out.txt"));
        }
        catch (CustomFileException e){
            System.out.println(e);
        }
    }
}
