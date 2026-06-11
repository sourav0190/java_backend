public enum Tooping {
    MUSHROOM("Mushroom", 50),
    PANEER("Paneer", 80),
    ONION("Onion", 30),
    GOLDEN_CORN("Golden Corn", 40),
    CHICKEN("Chicken", 120);
    private final String name;
    private final int price;

    Tooping(String name, int price) {
        this.name = name;
        this.price = price;
    }

    public int getPrice() {
        return price;
    }

    public String getName() {
        return name;
    }
}
