public class Pizza {
    private int price;
    private Boolean veg = true;
    private int extracheese = 100 ;
    private int extratoppings = 150 ;
    private int extrabag = 20;
    private boolean ischeeseadded = false ;
    private boolean istoppingseadded = false ;
    private boolean isbageadded = false ;
    private int baseprice ;



    public Pizza(Boolean veg) {
        this.veg = veg;
        if(this.veg ){
            this.price = 300;
        }
        else{
            this.price = 400 ;
        }
        this.baseprice = this.price; // added

    }
    public void extrachees(){
        ischeeseadded = true;
        this.price += extracheese;




    }
    public void extratoppings(){
        istoppingseadded = true;
        this.price += extratoppings;


    }
    public void extrabag(){
        isbageadded = true;
        this.price += extrabag;

    }

    public void getbill() {
        String bill = "";

        if (this.veg) {
            bill += "Vegetarian Pizza : " + baseprice + "\n";
        } else {
            bill += "Non-Vegetarian Pizza : " + baseprice + "\n";
        }

        if (ischeeseadded) {
            bill += "Extra Cheese : " + extracheese + "\n";
        }

        if (istoppingseadded) {
            bill += "Extra Toppings : " + extratoppings + "\n";
        }

        if (isbageadded) {
            bill += "Carry Bag : " + extrabag + "\n";
        }

        bill += "Total Price : " + price;

        System.out.println(bill);
    }



}
