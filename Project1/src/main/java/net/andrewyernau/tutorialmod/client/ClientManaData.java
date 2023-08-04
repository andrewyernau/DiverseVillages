package net.andrewyernau.tutorialmod.client;

import net.andrewyernau.tutorialmod.energy.PlayerMana;

public class ClientManaData {
    private static int playerMana;
    public static void set(int Mana){
        ClientManaData.playerMana=Mana;
    }
    public static int getPlayerMana(){
        return playerMana;
    }
}
