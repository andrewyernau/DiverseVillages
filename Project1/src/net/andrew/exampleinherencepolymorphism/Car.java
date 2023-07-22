package net.andrew.exampleinherencepolymorphism;

public class Car extends Vehicle implements IEasyDrivable{
    public Car(String name,String motor,String picture,String vehiclePlate,int consumption,int price){
        super(name,motor,picture,vehiclePlate,consumption,price);
    }

    @Override
    public void passITV() {
        System.out.println(this.name+ " has passed the ITV perfectly.");
    }
    public static final double carPriceDecreasePerYearFactor=0.92;
    public double priceReduced(int years){
        double finalPrice=this.price*Math.pow(carPriceDecreasePerYearFactor,(double)years);
        return finalPrice;
    }

    @Override
    public void EasyDrivable() {
        System.out.println("You can easily drive a "+this.name+" just with a driving license.");
    }
}
