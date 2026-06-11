import java.util.ArrayList;
import java.util.List;

public class SimplePizza implements Pizza {
    private int price;
    private final boolean veg;
    private final int baseprice;
    private final int extracheeseprice = 100;
    private final int extrabag = 20;
    private boolean ischeeseadded = false;
    private boolean isbagadded = false;
    private final List<Tooping> ToopingList = new ArrayList<Tooping>();

    // Constructor taking only 'veg' (since base price is calculated from it)
    public SimplePizza(boolean veg) {
        this.veg = veg;
        this.baseprice = veg ? 300 : 400;
        this.price = this.baseprice;
    }

    @Override
    public void extratooping(Tooping tooping) {
        ToopingList.add(tooping);
        this.price += tooping.getPrice();
    }

    @Override
    public void extracheese() {
        if (!ischeeseadded) {
            ischeeseadded = true;
            this.price += extracheeseprice; // Fix: Add cheeseprice instead of bag
        }
    }

    @Override
    public void addcarry_bag() {
        if (!isbagadded) {
            isbagadded = true;
            this.price += extrabag;
        }
    }


    @Override
    public void get_Bill() { // This matches the interface
        StringBuilder bill = new StringBuilder();
        bill.append(veg ? "Vegetarian Pizza : " : "Non-Vegetarian Pizza : ")
                .append(baseprice).append("\n");

        if (ischeeseadded) {
            bill.append("Extra Cheese : ").append(extracheeseprice).append("\n");
        }

        for (Tooping tooping : ToopingList) {
            bill.append("Topping (").append(tooping.getName()).append(") : ")
                    .append(tooping.getPrice()).append("\n");
        }

        if (isbagadded) {
            bill.append("Carry Bag : ").append(extrabag).append("\n");
        }

        bill.append("Total Price : ").append(price);
        System.out.println(bill);
    }

    @Override
    public int getPrice() {
        return this.price;
    }
}
