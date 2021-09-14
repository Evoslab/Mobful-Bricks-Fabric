package com.github.evoslab.mobfulbricks.data.basic;

import co.eltrut.differentiate.common.repo.VariantBlocks;
import com.github.evoslab.mobfulbricks.MobfulBricks;
import com.github.evoslab.mobfulbricks.data.MobfulBricksData;
import com.github.evoslab.mobfulbricks.init.MobfulBricksBlocks;
import me.shedaniel.cloth.api.datagen.v1.LootTableData;
import org.apache.logging.log4j.Level;

public class MobfulBricksTables {
    public static void init(LootTableData tableData) {
        try {
            var list = MobfulBricksBlocks.class;
            var values = list.getFields();
            int valuesLength = values.length;

            for(int valuesLengthZero = 0; valuesLengthZero < valuesLength; ++valuesLengthZero) {
                var blockField = values[valuesLengthZero];
                var blocks = ((VariantBlocks)blockField.get(MobfulBricksBlocks.class));

                tableData.registerBlockDropSelf(blocks.getBlock());
                tableData.registerBlockDropSelf(blocks.getSlabBlock());
                tableData.registerBlockDropSelf(blocks.getStairsBlock());
                tableData.registerBlockDropSelf(blocks.getWallBlock());
            }

            MobfulBricksData.handler.run();
        } catch (Throwable throwable) {
            throwable.printStackTrace();
            MobfulBricks.log(Level.INFO, "MobfulBricksTables Data Failed!");
            System.exit(1);
        }
        MobfulBricks.log(Level.INFO, "MobfulBricksTables Data Loaded!");
    }
}