package net.andrewyernau.tutorialmod.energy;

import net.minecraft.nbt.CompoundTag;

public class PlayerMana {
    private int mana;
    public final int MAX_MANALEVEL=1000;
    public int getMAX_MANALEVEL(){
        return MAX_MANALEVEL;
    }
    private final int MIN_MANALEVEL=0;
    public int  getMana(){
        return mana;
    }
    public void addMana(int add){
        this.mana=Math.min(mana+add,MAX_MANALEVEL);
    }
    public void subMana(int sub){
        this.mana=Math.max(mana-sub,MIN_MANALEVEL);
    }
    public void copyFrom(PlayerMana source){
        this.mana=source.mana;
    }
    public void saveNBTData(CompoundTag nbt){
        nbt.putInt("mana",mana);
    }
    public void loadNBTData(CompoundTag nbt){
        mana=nbt.getInt("mana");
    }
}
