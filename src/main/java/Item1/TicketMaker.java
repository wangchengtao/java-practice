package Item1;

public class TicketMaker {
    private int ticket = 1000;
    private static final TicketMaker ticketmaker = new TicketMaker();

    private TicketMaker() {

    }

    public static TicketMaker getInstance() {
        return ticketmaker;
    }

    public synchronized int getNextTicketNumber() {
        return ticket++;
    }


}
