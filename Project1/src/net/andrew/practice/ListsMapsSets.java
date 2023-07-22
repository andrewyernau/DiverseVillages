package net.andrew.practice;

import java.util.*;

public class ListsMapsSets {
    public static void main(String[] args) {
        List<String> datosLista = new ArrayList<>();
        datosLista.add("dato1");
        datosLista.remove(0);
        datosLista.add("Hola de nuevo");
        System.out.println(datosLista.get(0));
        System.out.println(datosLista.size());

        List<Integer> listaNum= new ArrayList<>();
        listaNum.add(532);
        listaNum.add(1);

        Map<String,String> PaisaCiudad =new HashMap<>();
        PaisaCiudad.put("Alemania","Berlin");
        PaisaCiudad.put("Italia","Roma");
        PaisaCiudad.put("España","Madrid");
        System.out.println(PaisaCiudad.get("Alemania"));
        System.out.println("Está Alemania en el mapa?"+PaisaCiudad.containsKey("Alemania"));
        System.out.println("Está Londres en el mapa?"+PaisaCiudad.containsValue("Londres"));
        System.out.println(PaisaCiudad.remove("Alemania"));

        Set<String> usuario=new HashSet<>();
        usuario.add("andrew");
        usuario.add("yernau");
        usuario.add("adrianman");
        System.out.println(usuario.add("nikita"));
        System.out.println(usuario.add("nikita"));

    }
}
