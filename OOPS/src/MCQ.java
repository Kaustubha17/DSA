/*
class Test2{
    static int marks;
    void set_marks(int marks)
    {
        this.marks=marks;               //Line 1
    }
}
class MCQ {
    public static void main (String[] args) {
        Test2 t=new Test2();              
        t.set_marks(78);                //Line 2
        System.out.print(Test2.marks);   //Line 3
    }
}*/


class Test_MCQ
{
    static int a = 10; 
    int b = 20; 
    static void fun1() 
    { 
        a = 20;                             //Line 1
//        b = 10;                             //Line 2
//        fun2();                             //Line 3
//        System.out.print(this.b);           //Line 4
    } 
    void fun2() 
    {     
        System.out.println("from m2"); 
    }
}
class MCQ{    
    public static void main(String[] args) 
    { 
        Test_MCQ.fun1(); 
    } 
} 