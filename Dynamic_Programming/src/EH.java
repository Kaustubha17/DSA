
public class EH {
	static {
		System.out.println("Hello");
	}
	public void EH() {
		System.out.println("EH");
	}
	{
		System.out.println("Instance");
	}
	class Eh2 extends EH{
		private int data;
		public void derived() {
			
		}
	}
public static void main(String args[]) {
	int dividend=1;
	int divisor=0;
	EH eh=new EH();
	eh.EH();
	int a=1;
	switch(a) {
	case 1:System.out.println("hello");
	}
	
	try {
		System.out.println("Hello"+" "+1/0);
	}catch(ArithmeticException e) {
		System.out.println("World");
	}
	
}
}
