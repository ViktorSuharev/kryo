package kryo;

import java.time.LocalDate;

public class Vacation {
    LocalDate startDate;
    City city;
    Ticket ticket;

    public Vacation() {
    }

    public Vacation(LocalDate startDate, City city, Ticket ticket) {
        this.startDate = startDate;
        this.city = city;
        this.ticket = ticket;
    }
}

class City {
    String name;
}

class Ticket {
    Integer price;
    TicketType ticketType;
}

enum TicketType {
    AIRLINE, TRAIN, BUS, CRUISE
}
