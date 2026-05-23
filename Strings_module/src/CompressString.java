
public class CompressString {

	public static String getCompressedString(String str) {
		String result="";
		int startIdx=0;
		System.out.println(str.length()-1);
		for(int i=0;i<str.length();) {
			Integer counter=0;
//			System.out.print(i);
//			System.out.println();
			for(int j=i;j<str.length();j++) {
				System.out.print(j+" ");
				if(str.charAt(i)==str.charAt(j)) {
					counter++;
				}
			
				else {
					i=j;
					break;
				}
				 if(j==(str.length()-1)) {
						System.out.println("inside else if");
						i=str.length();
						break;
					}
			}
			if(counter==1)
				result+=str.charAt(i-1);
			else {
				result+=str.charAt(i-1)+counter.toString();
			}
		}
		
		
		return result;
	}
	
	public static void main(String[] args) {
		String str="aaabbcddeeeee";
		
System.out.println(getCompressedString(str));
	}

}
