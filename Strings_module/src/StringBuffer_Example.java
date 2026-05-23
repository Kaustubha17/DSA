
public class StringBuffer_Example {

	public static void main(String[] args) {
//		StringBuffer is mutable while String is immutable
		
		StringBuffer str1=new StringBuffer("abc");
		
		str1.setCharAt(0, 'd');
		System.out.println(str1);
	}

}
