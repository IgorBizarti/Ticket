package ru.Netology.ticket;
public class Ticket implements Comparable<Ticket> {

    private int id;
    private int cost;
    private String from;
    private String to;
    private int duration;

    public Ticket(int id, int coast, String from, String to, int duration) {
        this.id = id;
        this.cost = cost;
        this.from = from;
        this.to = to;
        this.duration = duration;
    }


    public int getCost() {
        return cost;
    }

    public String getFrom() {
        return from;
    }

    public String getTo() {
        return to;
    }


    @Override
    public int compareTo(Ticket o) {
        if (cost < o.getCost()) {
            return -1;
        }
        if (cost > getCost()){
            return 1;
        } else {
            return 0;
        }
    }
}
