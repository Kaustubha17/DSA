package Inheritance;

public class Car extends Vehicle{
	public Car() {
		super(100);
//		System.out.println("car");
//super(100);//Constructor should be declared first
		

	}
	int distanceTravelled;
public void print() {
	System.out.println("distance travelled by car "+distanceTravelled+" maxspeed is "+maxSpeed);
}
}
