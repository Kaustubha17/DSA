package door;

public class Door {
	Lock lock=new Lock() {
		public boolean isLocked(String s){
			if(s.equals("qwerty"))
			{
				System.out.println("Door is unlocked");
				return true;
			}
			return false;
		}
	};

	public Lock getLock() {
		return lock;
	}


}
