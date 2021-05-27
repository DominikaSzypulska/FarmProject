package buildings;

public class Pigsty extends Building {

    public Pigsty(String name, double price, double fieldRequired, double capacity, String type) {
        super(name, price, fieldRequired, capacity, type);
    }

    @Override
    public String toString() {
        return " name: '" + type +
                ", price: " + getPrice() +
                ", fieldRequired: " + fieldRequired +
                ", capacity: " + capacity;
    }
}
