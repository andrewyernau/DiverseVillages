package net.andrewyernau.tutorialmod.event;


import it.unimi.dsi.fastutil.ints.Int2ObjectMap;
import net.andrewyernau.tutorialmod.TutorialMod;
import net.andrewyernau.tutorialmod.block.ModBlocks;
import net.andrewyernau.tutorialmod.energy.PlayerMana;
import net.andrewyernau.tutorialmod.energy.PlayerManaProvider;
import net.andrewyernau.tutorialmod.entity.ModEntityTypes;
import net.andrewyernau.tutorialmod.entity.custom.GloomjawEntity;
import net.andrewyernau.tutorialmod.item.ModItems;
import net.andrewyernau.tutorialmod.networking.ModMessages;
import net.andrewyernau.tutorialmod.networking.packet.CanalizeDataSyncC2SPacket;
import net.andrewyernau.tutorialmod.villager.ModVillagers;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.npc.VillagerProfession;
import net.minecraft.world.entity.npc.VillagerTrades;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.trading.MerchantOffer;
import net.minecraftforge.common.capabilities.RegisterCapabilitiesEvent;
import net.minecraftforge.event.AttachCapabilitiesEvent;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.event.entity.EntityJoinLevelEvent;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.event.village.VillagerTradesEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.LogicalSide;
import net.minecraftforge.fml.common.Mod;

import java.util.List;


public class ModEvents {
    @Mod.EventBusSubscriber(modid= TutorialMod.MOD_ID)
    public class ForgeEvents{
        @SubscribeEvent
        public static void addCustomTrades(VillagerTradesEvent event){

            if(event.getType() == VillagerProfession.MASON){
                Int2ObjectMap<List<VillagerTrades.ItemListing>> trades= event.getTrades();
                ItemStack stack = new ItemStack(ModBlocks.SERPENTINE.get(),12);
                int villagerLevel=1;

                trades.get(villagerLevel).add((trader,rand) -> new MerchantOffer(new ItemStack(Items.EMERALD,4),stack,10,8,0.02F));
            }
            if(event.getType() == ModVillagers.NATURE_ENTHUSIAST.get()){
                Int2ObjectMap<List<VillagerTrades.ItemListing>> trades= event.getTrades();
                ItemStack stack = new ItemStack(Items.EMERALD,1);
                int villagerLevel=1;

                trades.get(villagerLevel).add((trader,rand) -> new MerchantOffer(new ItemStack(ModItems.RICE_SEEDS.get(),2),stack,10,8,0.02F));
            }
        }
        @SubscribeEvent
        public static void onAttachCapabilitiesPlayer(AttachCapabilitiesEvent<Entity>event){
            if(event.getObject() instanceof Player){
                if(!event.getObject().getCapability(PlayerManaProvider.PLAYER_MANA).isPresent()){
                    event.addCapability(new ResourceLocation(TutorialMod.MOD_ID,"properties"), new PlayerManaProvider());
                }
            }
        }
        @SubscribeEvent
        public static void onPlayerCloned(PlayerEvent.Clone event){
            if(event.isWasDeath()){
                event.getOriginal().getCapability(PlayerManaProvider.PLAYER_MANA).ifPresent(oldStore->{
                    event.getOriginal().getCapability(PlayerManaProvider.PLAYER_MANA).ifPresent(newStore->{
                        newStore.copyFrom(oldStore);
                    });
                });
            }
        }
        @SubscribeEvent
        public static void onRegisterCapabilities(RegisterCapabilitiesEvent event){
            event.register(PlayerMana.class);
        }
        //sub mana level
        @SubscribeEvent
        public static void onPlayerTick(TickEvent.PlayerTickEvent event){
            if(event.side == LogicalSide.SERVER){
                event.player.getCapability(PlayerManaProvider.PLAYER_MANA).ifPresent(playerMana -> {
                    if(playerMana.getMana()>0 && event.player.getRandom().nextFloat()<0.005f){
                        playerMana.subMana(1);
                        ModMessages.sendToPlayer(new CanalizeDataSyncC2SPacket(playerMana.getMana()),((ServerPlayer)event.player));
                    }
                });
            }
        }
        @SubscribeEvent
        public static void onPlayerJoinWorld(EntityJoinLevelEvent event){
            if(!event.getLevel().isClientSide()){
                if(event.getEntity() instanceof ServerPlayer player){
                    player.getCapability(PlayerManaProvider.PLAYER_MANA).ifPresent(playerMana -> {
                        ModMessages.sendToPlayer(new CanalizeDataSyncC2SPacket(playerMana.getMana()),player);
                    });
                }
            }
        }
    }
    @Mod.EventBusSubscriber(modid= TutorialMod.MOD_ID,bus=Mod.EventBusSubscriber.Bus.MOD)
    public static class ModEventBusEvents{
        @SubscribeEvent
        public static void entityAttributeEvent(EntityAttributeCreationEvent event){
            event.put(ModEntityTypes.GLOOMJAW.get(), GloomjawEntity.setAttributes());}
    }
}
