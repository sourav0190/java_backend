public class DeluxePizza  extends SimplePizza{


    public DeluxePizza(boolean veg) {
        super(veg);
        super.extracheese();
        if(veg) {
            super.extratooping(Tooping.PANEER);
            super.extratooping(Tooping.GOLDEN_CORN);
        }
        else {
            super.extratooping(Tooping.CHICKEN);
            super.extratooping(Tooping.MUSHROOM);
        }



    }
        @Override
       public void extratooping(Tooping tooping ) {



        }
    @Override
    public void extracheese() {
        // Do nothing (prevents adding extra cheese)
    }


    }





