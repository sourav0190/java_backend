public class Main {
    public static void main(String[] args) {
        // Example 1: Creating a Regular Vegetarian Pizza
        System.out.println("--- REGULAR VEG PIZZA ---");
        Pizza regularVeg = new SimplePizza(true);

        regularVeg.extracheese();                  // Add cheese (+100)
        regularVeg.extratooping(Tooping.MUSHROOM); // Add Mushroom (+50)
        regularVeg.addcarry_bag();                 // Add Carry Bag (+20)
        regularVeg.get_Bill();                     // Print Bill (Expected: 300 + 100 + 50 + 20 = 470)

        System.out.println("\n-----------------------------------\n");

        // Example 2: Creating a Deluxe Non-Vegetarian Pizza
        System.out.println("--- DELUXE NON-VEG PIZZA ---");
        Pizza deluxeNonVeg = new DeluxePizza(false);

        // Let's try adding extra cheese and toppings again 
        // (These should do nothing because they are overridden in DeluxePizza)
        deluxeNonVeg.extracheese();
        deluxeNonVeg.extratooping(Tooping.CHICKEN);

        deluxeNonVeg.addcarry_bag();               // Add Carry Bag (+20)
        deluxeNonVeg.get_Bill();
        System.out.println("--- REGULAR  NON VEG PIZZA ---");
        Pizza regularnonveg = new SimplePizza(false);

        regularnonveg.extracheese();                  // Add cheese (+100)
        regularnonveg.extratooping(Tooping.MUSHROOM); // Add Mushroom (+50)
//        regularVeg.addcarry_bag();                 // Add Carry Bag (+20)
        regularnonveg.get_Bill();                     // Print Bill (Expected: 300 + 100 + 50 + 20 = 470)

        System.out.println("\n-----------------------------------\n");// Print Bill (Expected: 400 base + 100 cheese + 120 chicken + 50 mushroom + 20 bag = 690)
    }
}
