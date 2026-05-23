class Car{
    static int year;
    String company_name;
}
class new_Car {
    public static void main (String[] args) {
        Car c=new Car();        
        Car.year=2018;              
        c.company_name="KIA";
        Car d=new Car();
        d.year=2019;
        System.out.print(c.year);
    }
}