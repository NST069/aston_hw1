package m2;

import java.io.*;

public class FileHandler{

    public static String readFile(String fileName) throws CustomFileException{
        StringBuilder sb = new StringBuilder();
        System.out.println(fileName);
        try (BufferedReader in = new BufferedReader(new FileReader(fileName))) {
            String fileLine;
            while ((fileLine = in.readLine()) != null) {
                sb.append(fileLine).append("\n");
            }
        }
        catch(IOException e){
            throw new CustomFileException(e.getMessage());
        }

        return sb.toString().trim();

    }

    public static void writeToFile(String fileName, String content) throws CustomFileException{
        try(FileOutputStream out = new FileOutputStream(fileName)) {
            out.write(content.getBytes());
        }
        catch (IOException e) {
            throw new CustomFileException(e.getMessage());
        }
    }
}
