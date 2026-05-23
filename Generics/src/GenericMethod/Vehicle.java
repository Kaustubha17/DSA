package GenericMethod;

public class Vehicle implements PrintInterface{
private int maxSpeeed;
private int distanceTravelled;
public Vehicle(int maxSpeeed, int distanceTravelled) {
	super();
	this.maxSpeeed = maxSpeeed;
	this.distanceTravelled = distanceTravelled;
}

public  void print() {
	System.out.println("Max speed of vehicle is "+maxSpeeed+" and distance travelled by it is "+distanceTravelled);
}

}
