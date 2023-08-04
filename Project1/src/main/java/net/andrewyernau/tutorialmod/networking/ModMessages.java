package net.andrewyernau.tutorialmod.networking;

import net.andrewyernau.tutorialmod.TutorialMod;
import net.andrewyernau.tutorialmod.networking.packet.CanalizeC2SPacket;
import net.andrewyernau.tutorialmod.networking.packet.CanalizeDataSyncC2SPacket;
import net.andrewyernau.tutorialmod.networking.packet.TEMPLATEC2SPacket;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerPlayer;
import net.minecraftforge.network.NetworkDirection;
import net.minecraftforge.network.NetworkRegistry;
import net.minecraftforge.network.PacketDistributor;
import net.minecraftforge.network.simple.SimpleChannel;

public class ModMessages {
    private static SimpleChannel INSTANCE;
    private static int packetID=0;
    private static int id(){
        return packetID++;
    }
    public static void register(){
        SimpleChannel net= NetworkRegistry.ChannelBuilder.named(
                new ResourceLocation(TutorialMod.MOD_ID,"messages"))
                .networkProtocolVersion(()->"1.0").clientAcceptedVersions(s->true)
                .serverAcceptedVersions(s->true)
                .simpleChannel();
        INSTANCE=net;
        net.messageBuilder(TEMPLATEC2SPacket.class,id(), NetworkDirection.PLAY_TO_SERVER)
                .decoder(TEMPLATEC2SPacket::new)
                .encoder(TEMPLATEC2SPacket::toBytes)
                .consumerMainThread(TEMPLATEC2SPacket::handle)
                .add();
        net.messageBuilder(CanalizeC2SPacket.class,id(), NetworkDirection.PLAY_TO_SERVER)
                .decoder(CanalizeC2SPacket::new)
                .encoder(CanalizeC2SPacket::toBytes)
                .consumerMainThread(CanalizeC2SPacket::handle)
                .add();

        net.messageBuilder(CanalizeDataSyncC2SPacket.class,id(), NetworkDirection.PLAY_TO_CLIENT)
                .decoder(CanalizeDataSyncC2SPacket::new)
                .encoder(CanalizeDataSyncC2SPacket::toBytes)
                .consumerMainThread(CanalizeDataSyncC2SPacket::handle)
                .add();
    }
    public static <MSG> void sendToServer(MSG message){
        INSTANCE.sendToServer(message);
    }
    public static <MSG> void sendToPlayer(MSG message, ServerPlayer player){
        INSTANCE.send(PacketDistributor.PLAYER.with(()->player),message);
    }
}
