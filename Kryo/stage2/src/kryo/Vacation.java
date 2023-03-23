package kryo;

import java.time.LocalDate;

public class Vacation {
    private final LocalDate startDate;
    private final City city;
    private final Ticket ticket;

    public Vacation(LocalDate startDate, City city, Ticket ticket) {
        this.startDate = startDate;
        this.city = city;
        this.ticket = ticket;
    }
}
