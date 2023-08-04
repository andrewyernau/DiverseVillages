package net.andrewyernau.tutorialmod.networking.packet;

import net.andrewyernau.tutorialmod.energy.PlayerManaProvider;
import net.andrewyernau.tutorialmod.networking.ModMessages;
import net.minecraft.ChatFormatting;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.levelgen.placement.PlacementModifier;
import net.minecraftforge.network.NetworkEvent;

import java.util.function.Supplier;

public class CanalizeC2SPacket {
    private static final String MESSAGE_CANALIZING="message.tutorialmod.canalizing";
    private static final String MESSAGE_CANT_CANALIZING="message.tutorialmod.cant_canalizing";
    public CanalizeC2SPacket(){
    }
    public CanalizeC2SPacket(FriendlyByteBuf buf){

    }
    public void toBytes(FriendlyByteBuf buf){

    }
    public boolean handle (Supplier<NetworkEvent.Context> supplier){
        NetworkEvent.Context context= supplier.get();
        context.enqueueWork(()->{
            //EVERYTHING HAPPENS IN THE SERVER
            //Check if using the wand (temporaly STICK) in main hand

            ServerPlayer player=context.getSender();
            ServerLevel level=player.getLevel();
            if(usingWandMainHand(player)){

                //message mid-screen Canalizing
                //play sound

                level.playSound(null,player.getOnPos(), SoundEvents.ALLAY_AMBIENT_WITHOUT_ITEM, SoundSource.PLAYERS,0.5F,level.random.nextFloat()*0.1F+0.9F);
                player.sendSystemMessage(Component.translatable(MESSAGE_CANALIZING).withStyle(ChatFormatting.DARK_AQUA));
                //animation

                int durationTicks=10;
                int amplifier=5;
                boolean showParticles=false;
                MobEffectInstance slownessEffect= new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN,durationTicks,amplifier,false,showParticles);
                player.addEffect(slownessEffect);
                player.getCapability(PlayerManaProvider.PLAYER_MANA).ifPresent(playerMana -> {
                    playerMana.addMana(1);
                    player.sendSystemMessage(Component.literal("Current mana: "+playerMana.getMana())
                            .withStyle(ChatFormatting.AQUA));
                    ModMessages.sendToPlayer(new CanalizeDataSyncC2SPacket(playerMana.getMana()),player);
                });
                //counter++ while r pressed
            }
            else{
                player.sendSystemMessage(Component.translatable(MESSAGE_CANT_CANALIZING).withStyle(ChatFormatting.RED));
                player.getCapability(PlayerManaProvider.PLAYER_MANA).ifPresent(playerMana -> {
                    player.sendSystemMessage(Component.literal("Current mana: "+playerMana.getMana()).withStyle(ChatFormatting.AQUA));
                });
            }


        });
        return true ;
    }
    public static boolean usingWandMainHand(ServerPlayer player){
        ItemStack mainHandItem= player.getMainHandItem();
        return mainHandItem.getItem()== Items.STICK;
    }

}
