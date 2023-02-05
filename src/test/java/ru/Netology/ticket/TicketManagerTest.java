package ru.Netology.ticket;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;


class TicketManagerTest {

    @Test
    public void testSortSeveralTickets() {

        TicketRepository repository = new TicketRepository();
        TicketManager manager = new TicketManager(repository);

        Ticket ticket1 = new Ticket(1, 200, "MSK", "OGZ", 93);
        Ticket ticket2 = new Ticket(2, 100, "MSK", "SPB", 98);
        Ticket ticket3 = new Ticket(3, 200, "MSK", "OGZ", 180);
        Ticket ticket4 = new Ticket(4, 400, "OGZ", "MSK", 170);
        Ticket ticket5 = new Ticket(5, 800, "MSK", "OGZ", 300);
        Ticket ticket6 = new Ticket(6, 200, "MSK", "SPB", 400);
        Ticket ticket7 = new Ticket(7, 300, "MSK", "OGZ", 160);
        Ticket ticket8 = new Ticket(8, 500, "MSK", "SPB", 160);


        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        manager.add(ticket6);
        manager.add(ticket7);
        manager.add(ticket8);

        Ticket[] expected = {ticket2, ticket6, ticket8};
        Ticket[] actual = manager.findAll("MSK", "SPB");

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test

    public void testSortOneTickets() {
        TicketRepository repository = new TicketRepository();
        TicketManager manager = new TicketManager(repository);

        Ticket ticket1 = new Ticket(1, 200, "MSK", "OGZ", 93);
        Ticket ticket2 = new Ticket(2, 100, "MSK", "SPB", 98);
        Ticket ticket3 = new Ticket(3, 200, "MSK", "OGZ", 180);
        Ticket ticket4 = new Ticket(4, 400, "OGZ", "MSK", 170);
        Ticket ticket5 = new Ticket(5, 800, "MSK", "OGZ", 300);
        Ticket ticket6 = new Ticket(6, 200, "MSK", "SPB", 400);
        Ticket ticket7 = new Ticket(7, 300, "MSK", "RZE", 160);
        Ticket ticket8 = new Ticket(8, 500, "MSK", "SPB", 160);


        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        manager.add(ticket6);
        manager.add(ticket7);
        manager.add(ticket8);

        Ticket[] expected = {ticket7};
        Ticket[] actual = manager.findAll("MSK", "RZE");

        Assertions.assertArrayEquals(expected, actual);

    }

    @Test
    public void testSearchWithNoResults() {
        Ticket t1 = new Ticket(1, 100, "MSK", "OGZ", 120);
        Ticket t2 = new Ticket(2, 200, "MSK", "SPB", 150);
        Ticket t3 = new Ticket(3, 150, "MSK", "OGZ", 240);


        List<Ticket> tickets = new ArrayList<>();
        tickets.add(t1);
        tickets.add(t2);
        tickets.add(t3);

        TicketManager searchManager = new TicketManager(new TicketRepository());

        Ticket[] expected = new Ticket[]{};
        Ticket[] actual = searchManager.search("SFO", "PIT");

        Assertions.assertArrayEquals(expected, actual);
    }

}





