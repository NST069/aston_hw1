package m3.Adapter;

public class Main {

    public static void main(String[] args) {
        Printer printer = new PrinterAdapter(new OldPrinter());
        printer.print("lorem ipsum");
    }
}
