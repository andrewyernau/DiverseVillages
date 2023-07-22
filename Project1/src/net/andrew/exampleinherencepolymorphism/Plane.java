package net.andrew.exampleinherencepolymorphism;

public class Plane extends Vehicle implements IFly,IEasyDrivable{
    public Plane(String name, String motor, String picture, String vehiclePlate, float consumption, int price) {
        super(name, motor, picture, vehiclePlate, consumption, price);
    }

    @Override
    public void fly() {
        System.out.println(this.name + "has taken off.");
    }

    @Override
    public void EasyDrivable() {
        System.out.println("Not everyone can drive a " + this.name);
    }
}
