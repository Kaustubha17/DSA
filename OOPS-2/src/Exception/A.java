package Exception;

class A{
    public static void main(String[] args)throws DivideBy1 {

   
       int a = 5/1;
       if(a==5)
    	   throw new DivideBy1();
   
   
  
       System.out.print("finally block ");
   
 }
}