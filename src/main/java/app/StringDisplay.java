package app;

public class StringDisplay extends AbstractDisplay {
    private String string;
    private int length;

    public StringDisplay(String string) {
        this.string = string;
        this.length = string.length();
    }

    @Override
    public void open() {
        printLine();
    }

    @Override
    public void print() {
        System.out.println("|" + string + "|");
    }

    @Override
    public void close() {
        printLine();
    }

    private void printLine() {
        System.out.println("+");
        for (int i = 0; i < length; i++) {
            System.out.println("-");
        }
        System.out.println("+");
    }
}
