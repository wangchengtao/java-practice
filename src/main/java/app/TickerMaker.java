package app;

public class TickerMaker {
    private static final TickerMaker tickerMaker = new TickerMaker();
    private int ticket = 1000;

    private TickerMaker() {

    }

    public static TickerMaker getInstance() {
        return tickerMaker;
    }

    public synchronized int getNextTickerNumber() {
        return ticket++;
    }
}
