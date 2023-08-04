package net.andrewyernau.tutorialmod.networking.packet;

import net.andrewyernau.tutorialmod.client.ClientManaData;
import net.andrewyernau.tutorialmod.energy.PlayerManaProvider;
import net.minecraft.ChatFormatting;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraftforge.network.NetworkEvent;

import java.util.function.Supplier;

public class CanalizeDataSyncC2SPacket {
    private final int mana;
    public CanalizeDataSyncC2SPacket(int mana){
        this.mana=mana;
    }
    public CanalizeDataSyncC2SPacket(FriendlyByteBuf buf){
        this.mana=buf.readInt();
    }
    public void toBytes(FriendlyByteBuf buf){
        buf.writeInt(mana);
    }
    public boolean handle (Supplier<NetworkEvent.Context> supplier){
        NetworkEvent.Context context= supplier.get();
        context.enqueueWork(()->{
            //EVERYTHING HAPPENS IN THE SERVER
            //Check if using the wand (temporaly STICK) in main hand
            ClientManaData.set(mana);


        });
        return true ;
    }
    public static boolean usingWandMainHand(ServerPlayer player){
        ItemStack mainHandItem= player.getMainHandItem();
        return mainHandItem.getItem()== Items.STICK;
    }

}
