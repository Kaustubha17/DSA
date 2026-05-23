public class Polynomial {


	/* This function sets coefficient for a particular degree value, if degree is not there in the polynomial
	 *  then corresponding term with specified degree and value is added int the polynomial. If the degree
	 *  is already present in the polynomial then previous coefficient is replaced by
	 *  new coefficient value passed as function argument
	 */

	private int polynomial[];
	private int maxDegree;

	public Polynomial(){
		polynomial=new int[1];
		maxDegree=0;
	}

	public void setCoefficient(int degree, int coeff){

		if(degree>maxDegree){
			maxDegree=degree;
			increasePolynomial(degree);
		}

		polynomial[degree]=coeff;
	}

	public int getCoefficient(int degree){
		return polynomial[degree];
	}

	private void increasePolynomial(int degree){
		int temp[]=polynomial;
		polynomial=new int[2*degree];
		for(int i=0;i<temp.length;i++){
			polynomial[i]=temp[i];
		}

	}

	// Prints all the terms(only terms with non zero coefficients are to be printed) in increasing order of degree.


	public void print(){




		for(int i=0;i<polynomial.length;i++){
			if(polynomial[i]!=0){
				System.out.print(polynomial[i]+"x"+i+" ");
			}
		}

	}


	// Adds two polynomials and returns a new polynomial which has result
	public Polynomial add(Polynomial p){

		int d1=this.getMaxDegree();
		int d2=p.getMaxDegree();
		Polynomial res=new Polynomial();
		if(d1>d2){
			int i=0;
			for(;i<=d2;i++){
				res.setCoefficient(i,this.getCoefficient(i)+p.getCoefficient(i));
			}
			for(;i<=d1;i++){
				res.setCoefficient(i,this.getCoefficient(i));
			}
		}
		else{
			int i=0;
			for(;i<=d1;i++){
				res.setCoefficient(i,this.getCoefficient(i)+p.getCoefficient(i));
			}
			for(;i<=d2;i++){
				res.setCoefficient(i,p.getCoefficient(i));
			}  
		}
		return res;

	}

	private int getMaxDegree(){

		return maxDegree;
	}

	// Subtracts two polynomials and returns a new polynomial which has result
	public Polynomial subtract(Polynomial p){
		int d1=this.getMaxDegree();
		int d2=p.getMaxDegree();
		Polynomial res=new Polynomial();
		if(d1>d2){
			int i=0;
			for(;i<=d2;i++){
				res.setCoefficient(i,this.getCoefficient(i)-p.getCoefficient(i));
			}
			for(;i<=d1;i++){
				res.setCoefficient(i,this.getCoefficient(i));
			}
		}
		else{
			int i=0;
			for(;i<=d1;i++){
				res.setCoefficient(i,this.getCoefficient(i)-p.getCoefficient(i));
			}
			for(;i<=d2;i++){
				res.setCoefficient(i,-p.getCoefficient(i));
			}  
		}
		return res;

	}

	// Multiply two polynomials and returns a new polynomial which has result
	public Polynomial multiply(Polynomial p){
		int d1=this.getMaxDegree();
		int d2=p.getMaxDegree();
		Polynomial res=new Polynomial();
		if(d1>d2){
			int temp;
			for(int i=0;i<=d1;i++){
				for(int j=0;j<=d2;j++){
					if((i+j)<=res.getMaxDegree()) {
					 temp=res.getCoefficient(i+j);
					 }
					else
						temp=0;
					
					res.setCoefficient(i+j,temp+this.getCoefficient(i)*p.getCoefficient(j));
					
				}
			}

		}
		else{
int temp;
			for(int i=0;i<=d2;i++){
				for(int j=0;j<=d1;j++){

					if((i+j)<=res.getMaxDegree()) {
						 temp=res.getCoefficient(i+j);
						 }
						else
							temp=0;
					res.setCoefficient(i+j,temp+this.getCoefficient(j)*p.getCoefficient(i));

				}
			}

		}

		return res;  
	}

}