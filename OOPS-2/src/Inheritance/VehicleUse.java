package Inheritance;

public class VehicleUse {

	public static void main(String[] args) {
		Vehicle v=new Vehicle(200);
//		v.print();

		Car c=new Car();
		c.color="red";
		c.maxSpeed=280;
		c.distanceTravelled=100;
//		c.print();
	}

}
