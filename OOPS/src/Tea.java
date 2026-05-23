class Test1 
    { 
        int a; 
        int b; 
final int c=10;
        public Test1() {
        	
        	System.out.println("inside constructor");
        }
         Test1(int i) {
        	 
        	System.out.println("inside constructor with value "+i);
        }
        
    public void set(int a, int b) 
    {  
        b = a; 
        this.b = b; 
    } 

    void display() 
    { 
        System.out.println("a=" + a + " b=" + b); 
    } 
}
class Tea{
    public static void main(String[] args) 
    { 
        Test1 object = new Test1(10);
        object.set(10,20);
        object.display(); 
//        object.c=30;
    } 
} 
