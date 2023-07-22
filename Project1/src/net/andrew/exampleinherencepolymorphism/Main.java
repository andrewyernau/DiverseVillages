package net.andrew.exampleinherencepolymorphism;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Car audiR8 = new Car("AudiR8", "V8", "audia8.png", "1047LGT", 13,208000);
        Car daciaSandero = new Car("Dacia Sandero", "V4", "daciasandero.png", "3820GDD", 5,45000);
        motorbike kawasakiK7 = new motorbike("Kawasaki K7", "V6", "kawasakiK7.png", "1193MDZ", 3,7800);
        audiR8.passITV();
        System.out.println(audiR8.priceReduced(8));
        audiR8.aviableTricks();
        kawasakiK7.aviableTricks();
        audiR8.giveData();
        List<Vehicle> vehicle= new ArrayList<>();
        vehicle.add(audiR8);
        vehicle.add(daciaSandero);
        vehicle.add(kawasakiK7);

        vehicle.get(1).aviableTricks();

        Vehicle vehicl=new Car("Ford Focus","V4","fordfocus.png","9930LLZ",6,33500);
        vehicl.aviableTricks();
        List<IEasyDrivable>easyDrive= new ArrayList<>();
        easyDrive.add(audiR8);
        easyDrive.add(daciaSandero);
        easyDrive.add(new Plane("Boeing 747","unknown","boeing747.png","PRIVATE",1200,420000000));
        for(IEasyDrivable easydrivable : easyDrive){
            easydrivable.EasyDrivable();
        }

    }
}
