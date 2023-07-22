package net.andrew.exampleinherencepolymorphism;

public abstract class Vehicle {

    public String name;
    public String motor;
    public String picture;
    public String vehiclePlate;
    public float consumption;
    public int price;

    public Vehicle(String name,String motor, String picture, String vehiclePlate, float consumption,int price) {
        this.name = name;
        this.motor = motor;
        this.picture = picture;
        this.vehiclePlate = vehiclePlate;
        this.consumption = consumption;
        this.price= price;
    }
    public void aviableTricks(){
        System.out.println("It's too dangerous to do tricks without any knowledge. Stay safe!");
    }
    public void passITV(){
        System.out.println(" Your vehicle has passed the ITV" );
    }
    public void giveData(){
        System.out.println("The name of the vehicle is:"+this.getClass());
        System.out.println("The name of the vehicle is:"+this.name);
        System.out.println("The motor of the vehicle is:"+this.motor);
        System.out.println("The picture of the vehicle is:"+this.picture);
        System.out.println("The vehicle plate the vehicle is:"+this.vehiclePlate);
        System.out.println("The consumption of the vehicle is:"+this.consumption);
        System.out.println("The price of the vehicle is:"+this.price);
    }
}
