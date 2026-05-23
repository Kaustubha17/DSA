package Polymorphism;

class VehicleQ{
    String colour;
    private int number;
    void print()
    {
        System.out.println("vehicle");
    }
}

class CarQ extends VehicleQ{
    void print()
    {
        System.out.println("car");
    }
}
class Honda extends CarQ{
	 void print()
	    {
	        System.out.println("Honda");
	    }

   }
class buy_car{
    public static void main (String[] args) {
        CarQ c=new Honda();
//        c.print();
    }
}
