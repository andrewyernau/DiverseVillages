package net.andrewyernau.diversevillagers.event;
import com.google.common.collect.ImmutableMap;
import it.unimi.dsi.fastutil.ints.Int2ObjectMap;
import net.andrewyernau.diversevillagers.DiverseVillagers;
import net.andrewyernau.diversevillagers.item.ModItems;
import net.andrewyernau.diversevillagers.villager.ModVillagers;
import net.minecraft.world.entity.npc.VillagerTrades;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.item.trading.MerchantOffer;
import net.minecraftforge.event.village.VillagerTradesEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import java.util.List;

public class ModEvents {
    @Mod.EventBusSubscriber(modid= DiverseVillagers.MOD_ID)
    public class ForgeEvents {
        @SubscribeEvent
        public static void addCustomTrades(VillagerTradesEvent event) {

            if (event.getType() == ModVillagers.MINE_MASTER.get()) {

                Int2ObjectMap<List<VillagerTrades.ItemListing>> trades = event.getTrades();
                int villagerLevel = 1;
                //First trade
                ItemStack input = new ItemStack(Items.COAL, 14);
                ItemStack output = new ItemStack(Items.EMERALD, 1);
                trades.get(villagerLevel).add((trader, rand) -> new MerchantOffer(input,output,10,8,0.2F));
                //Second trade
                trades.get(villagerLevel).add((trader, rand) -> {
                    ItemStack input2 = new ItemStack(Items.EMERALD, 4);
                    ItemStack output2 = new ItemStack(Items.STONE_PICKAXE, 1);
                    return new MerchantOffer(input2, output2, 6, 4, 0.1F);
                });
                if(villagerLevel>=2){
                    ItemStack input3 = new ItemStack(Items.EMERALD, 5);
                    ItemStack output3 = new ItemStack(Items.GOLD_ORE, 2);
                    trades.get(villagerLevel).add((trader, rand) -> new MerchantOffer(input3,output3,10,8,0.2F));
                    //Second trade
                    trades.get(villagerLevel).add((trader, rand) -> {
                        ItemStack input4 = new ItemStack(Items.EMERALD, 4);
                        ItemStack output4 = new ItemStack(Items.IRON_PICKAXE, 1);
                        return new MerchantOffer(input4, output4, 6, 4, 0.1F);
                    });
                }
                if(villagerLevel>=3){
                    ItemStack input3 = new ItemStack(Items.EMERALD, 1);
                    ItemStack output3 = new ItemStack(Items.LANTERN, 2);
                    trades.get(villagerLevel).add((trader, rand) -> new MerchantOffer(input3,output3,10,8,0.2F));
                    //Second trade
                    trades.get(villagerLevel).add((trader, rand) -> {
                        ItemStack input4 = new ItemStack(Items.EMERALD, 4);
                        ItemStack output4 = new ItemStack(Items.TNT, 1);
                        return new MerchantOffer(input4, output4, 10, 8, 0.15F);
                    });
                }
                if(villagerLevel>=4){
                    ItemStack input3 = new ItemStack(ModItems.BRUTE_DIAMOND.get(), 1);
                    ItemStack output3 = new ItemStack(Items.EMERALD, 8);
                    trades.get(villagerLevel).add((trader, rand) -> new MerchantOffer(input3,output3,10,8,0.2F));
                    //Second trade
                    ItemStack enchantedDiamondPickaxe = new ItemStack(Items.DIAMOND_PICKAXE);
                    EnchantmentHelper.setEnchantments(
                            ImmutableMap.of(
                                    Enchantments.BLOCK_EFFICIENCY, 3,       // Eficiencia IV
                                    Enchantments.UNBREAKING, 1       // Inquebrantable III
                            ),
                            enchantedDiamondPickaxe
                    );
                    trades.get(villagerLevel).add((trader, rand) -> {
                        ItemStack input4 = new ItemStack(Items.EMERALD, 26);

                        return new MerchantOffer(input4, enchantedDiamondPickaxe, 6, 4, 0.1F);
                    });
                }

            }
        }
    }
}
