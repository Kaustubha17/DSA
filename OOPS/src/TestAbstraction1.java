abstract class Shape{
	abstract void draw();
}

class Rec extends Shape{

	@Override
	void draw() {
System.out.println("rec");		
	}
	
}

class Cir extends Shape{

	@Override
	void draw() {
System.out.println("cir");		
	}
	
}

public  class TestAbstraction1 {
	public static void main(String[] args) {
//Shape s=new Shape();
//s.draw();
		
		
	}

}
