
public class StringPool {

	public static void main(String[] args) {
		//String pool is used to store strings when strings are directly stored in String variable i.e. new keyword is not used eg str1  
		//		benefit of string pool is that if another variable holds same value then memory is not re-allocated instead it is pointed to same memory location as the first one
		
		
		String str1="abc";
		String str2="abc";
		System.out.println(str1);
				System.out.println(str2);
		System.out.println(System.identityHashCode(str1));
		System.out.println(System.identityHashCode(str2));
	
		
	
		String str3="abc";
		String str4=new String("abc");
		String str5="abc";
		System.out.println(str3==str4);
		String str6=str3;
		System.out.println(str3==str6);
		String str7="abc";
		String str8="";
		System.out.println(str7.contains(str8));
		
		
	}

}
