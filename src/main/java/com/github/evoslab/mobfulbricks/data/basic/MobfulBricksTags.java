package com.github.evoslab.mobfulbricks.data.basic;

import co.eltrut.differentiate.common.repo.VariantBlocks;
import com.github.evoslab.mobfulbricks.MobfulBricks;
import com.github.evoslab.mobfulbricks.data.MobfulBricksData;
import com.github.evoslab.mobfulbricks.init.MobfulBricksBlocks;
import me.shedaniel.cloth.api.datagen.v1.LootTableData;
import me.shedaniel.cloth.api.datagen.v1.RecipeData;
import me.shedaniel.cloth.api.datagen.v1.TagData;
import net.minecraft.advancement.criterion.InventoryChangedCriterion;
import net.minecraft.data.server.recipe.ShapedRecipeJsonFactory;
import net.minecraft.data.server.recipe.SingleItemRecipeJsonFactory;
import net.minecraft.recipe.CuttingRecipe;
import net.minecraft.recipe.Ingredient;
import net.minecraft.recipe.StonecuttingRecipe;
import net.minecraft.tag.BlockTags;
import net.minecraft.tag.ItemTags;
import net.minecraft.util.registry.Registry;
import org.apache.logging.log4j.Level;

public class MobfulBricksTags {
    public static void init(TagData tags) {
        try {
            var list = MobfulBricksBlocks.class;
            var values = list.getFields();
            int valuesLength = values.length;

            for(int valuesLengthZero = 0; valuesLengthZero < valuesLength; ++valuesLengthZero) {
                var blockField = values[valuesLengthZero];
                var blocks = ((VariantBlocks)blockField.get(MobfulBricksBlocks.class));

                tags.block(BlockTags.SLABS).append(blocks.getSlabBlock());
                tags.block(BlockTags.STAIRS).append(blocks.getStairsBlock());
                tags.block(BlockTags.WALLS).append(blocks.getWallBlock());
                tags.item(ItemTags.SLABS).append(blocks.getSlabBlock());
                tags.item(ItemTags.STAIRS).append(blocks.getStairsBlock());
                tags.item(ItemTags.WALLS).append(blocks.getWallBlock());
            }

            MobfulBricksData.handler.run();
        } catch (Throwable throwable) {
            throwable.printStackTrace();
            MobfulBricks.log(Level.INFO, "MobfulBricksTags Data Failed!");
            System.exit(1);
        }
        MobfulBricks.log(Level.INFO, "MobfulBricksTags Data Loaded!");
    }
}