package com.github.evoslab.mobfulbricks.data.basic;

import co.eltrut.differentiate.common.repo.VariantBlocks;
import com.github.evoslab.mobfulbricks.MobfulBricks;
import com.github.evoslab.mobfulbricks.data.MobfulBricksData;
import com.github.evoslab.mobfulbricks.data.TexturedModelHelper;
import com.github.evoslab.mobfulbricks.init.MobfulBricksBlocks;
import me.shedaniel.cloth.api.datagen.v1.ModelStateData;
import net.minecraft.util.Identifier;
import org.apache.logging.log4j.Level;

public class MobfulBricksStates {
    public static void init(ModelStateData modelStates) {
        try {
            var list = MobfulBricksBlocks.class;
            var values = list.getFields();
            int valuesLength = values.length;

            for(int valuesLengthZero = 0; valuesLengthZero < valuesLength; ++valuesLengthZero) {
                var blockField = values[valuesLengthZero];
                var blocks = ((VariantBlocks)blockField.get(MobfulBricksBlocks.class));

                modelStates.addSimpleBlockItemModel(blocks.getBlock());
                modelStates.addSimpleBlockItemModel(blocks.getSlabBlock());
                modelStates.addSimpleBlockItemModel(blocks.getStairsBlock());
                modelStates.addSimpleBlockItemModel(blocks.getWallBlock());
                modelStates.addSingletonBlock(blocks.getBlock(), TexturedModelHelper.MOBFUL_BRICK);
            }

            MobfulBricksData.handler.run();
        } catch (Throwable throwable) {
            throwable.printStackTrace();
            MobfulBricks.log(Level.INFO, "MobfulBricksStates Data Failed!");
            System.exit(1);
        }
        MobfulBricks.log(Level.INFO, "MobfulBricksStates Data Loaded!");
    }
}