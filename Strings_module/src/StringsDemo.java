
public class StringsDemo {
public static void main(String[] args) {
	
	String str="Code";
	String str1=" quality is excellent";
	
	System.out.println(str.length());
	
	System.out.println(str.charAt(3));
	
	System.out.println(str+str1);
	
	System.out.println(str1.equals(str));
	
	String a ="abcd";
	String b="abcda";
	System.out.println(a.compareTo(b));
	
	System.out.println(str.substring(1,3));
	 a="coding";
	for(int i=2;i<4;i++)
	{
	    System.out.print(a.substring(i));
	}
	 a="coding";
	 System.out.println();
	for(int i=2;i<5;i++)
	{
	    System.out.print(a.substring(i-2,i+1));
	}
}
}
