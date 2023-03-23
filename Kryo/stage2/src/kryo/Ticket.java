package kryo;

public class Ticket {
    private final Integer price;
    private final TicketType type;

    public Ticket(Integer price, TicketType type) {
        this.price = price;
        this.type = type;
    }
}
