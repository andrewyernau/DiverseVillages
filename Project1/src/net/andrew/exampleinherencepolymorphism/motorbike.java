package net.andrew.exampleinherencepolymorphism;

public class motorbike extends Vehicle implements IEasyDrivable{
    public motorbike(String name,String motor,String picture,String vehiclePlate,int consumption,int price){
        super(name,motor,picture,vehiclePlate,consumption,price);
    }
    @Override
    public void EasyDrivable() {
        System.out.println("You can easily drive a "+this.name+" just with a driving license.");
    }
}
