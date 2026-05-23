package anonymousClass;

import door.Door;


public class Shop {

	 class Car{
		public void status() {
			System.out.println("car is moving");
		}
	}
	
	public static void main(String[] args) {
		Door door=new Door();
		System.out.println(door.getLock().isLocked("qwerty"));
		
		Shop s=new Shop();
		
		Car c=s.new Car();
		c.status();
	}

}
