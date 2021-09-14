package com.github.evoslab.mobfulbricks;

import co.eltrut.differentiate.common.repo.VariantBlocks;
import co.eltrut.differentiate.core.registrator.Registrator;
import com.github.evoslab.mobfulbricks.data.MobfulBricksData;
import com.github.evoslab.mobfulbricks.init.MobfulBricksBlocks;
import com.github.evoslab.mobfulbricks.village.MobfulBricksTradeOffers;
import com.google.common.reflect.Reflection;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.object.builder.v1.trade.TradeOfferHelper;
import net.minecraft.util.Identifier;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.lang.reflect.Field;

public class MobfulBricks implements ModInitializer {
    public static Logger LOGGER = LogManager.getLogger();

    public static final String MOD_NAME = "Mobful Bricks";
    public static final String MOD_ID = "mobfulbricks";

    public static final Registrator REGISTRATOR = new Registrator(MOD_ID);

    @Override
    @SuppressWarnings({"UnstableApiUsage"})
    public void onInitialize() {
        Reflection.initialize(
                MobfulBricksBlocks.class
        );

        var list = MobfulBricksBlocks.class;
        var values = list.getFields();
        int valuesLength = values.length;

        for(int valuesLengthZero = 0; valuesLengthZero < valuesLength; ++valuesLengthZero) {
            var block = values[valuesLengthZero];
            try {
                mbTrades((VariantBlocks)block.get(MobfulBricksBlocks.class), 16, 5,3);
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }

        MobfulBricksData.init();

        log(Level.INFO, "Brickalizing");
    }

    public static void mbTrades(VariantBlocks block, int price, int count, int experience) {
        TradeOfferHelper.registerWanderingTraderOffers(2, factories -> factories.add(new MobfulBricksTradeOffers.SellItemFactory(block.getBlock().asItem(), price, count, experience)));
    }

    public static Identifier id(String name) {
        return new Identifier(MOD_ID, name);
    }

    public static void log(Level level, String message){
        LOGGER.log(level, "["+MOD_NAME+"] " + message);
    }
}