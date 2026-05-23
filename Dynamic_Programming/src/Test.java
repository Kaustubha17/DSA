public class Test extends B{
	
	public static String sing() 
	{
		return "fa";
	}
	public static void main(String args[]) {
		foo(null);
	
		}
	
	public static void foo(Object o) {
		System.out.println("object");
	}
	public static void foo(String o) {
		System.out.println("string");
	}
}

class B{
	public static String sing() 
	{
		return "la";
	}
}