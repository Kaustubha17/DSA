
public class StudentUse {

	public static void main(String[] args) {

		Student s1=new Student();
		Student s2=new Student();
		System.out.println(s1);
		s1.name="Ram";
		s1.rollNumber=12;
		s1.setMarks(100);
		System.out.println(s1.getMarks());
//		
System.out.println(s1.name+" "+s1.rollNumber);
		
	}

}
