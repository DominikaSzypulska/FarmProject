package buildings;

import notBuildings.Player;

public class Silos extends Building {


    public Silos(String name, double price) {
        super(name, price);
    }


    public  void buySilos(Player player) {
        if (player.getCash() > this.getPrice()) {
            player.setCash(-this.getPrice());
            player.isSilos = true;
            System.out.println("You bought " + this.name);
        } else {
            System.out.println("You don't have money for " + this.name);
        }
    }

    @Override
    public String toString() {
        return " name: '" + name +
                ", price: " + getPrice();

    }
}


