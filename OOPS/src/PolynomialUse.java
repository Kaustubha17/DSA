
public class PolynomialUse {

	public static void main(String[] args) {
		Polynomial p1=new Polynomial();
		p1.setCoefficient(3,1);
		p1.setCoefficient(1,2);
		p1.setCoefficient(7,3);
	
		Polynomial p2=new Polynomial();
		p2.setCoefficient(2,7);
		p2.setCoefficient(1,8);
		p1.print();
		System.out.println();
		p2.print();
		Polynomial res=new Polynomial();
		res=p1.multiply(p2);
		System.out.println();
		res.print();
	}

}
