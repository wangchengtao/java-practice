package Item1;

public class StringDisplay extends AbstractDisplay {
    public String string;
    public int length;

    public StringDisplay(String s) {
        string = s;
        length = s.length();
    }

    @Override
    public void open() {
        this.printLine();
    }

    @Override
    public void print() {
        System.out.println('|' + string + '|');
    }

    @Override
    public void close() {
        this.printLine();
    }

    private void printLine() {
        System.out.print('+');
        for (int i = 0; i < length; i++) {
            System.out.print('-');
        }
        System.out.println('+');
    }
}
