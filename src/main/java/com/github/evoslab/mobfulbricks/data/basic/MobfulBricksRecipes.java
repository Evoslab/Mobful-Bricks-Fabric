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
import net.minecraft.recipe.Ingredient;
import net.minecraft.util.registry.Registry;
import org.apache.logging.log4j.Level;

public class MobfulBricksRecipes {
    public static void init(RecipeData recipes) {
        try {
            var list = MobfulBricksBlocks.class;
            var values = list.getFields();
            int valuesLength = values.length;

            for(int valuesLengthZero = 0; valuesLengthZero < valuesLength; ++valuesLengthZero) {
                var blockField = values[valuesLengthZero];
                var blocks = ((VariantBlocks)blockField.get(MobfulBricksBlocks.class));

                ShapedRecipeJsonFactory.create(blocks.getSlabBlock(), 6)
                        .pattern("###")
                        .input('#', blocks.getBlock())
                        .criterion("has_" + Registry.BLOCK.getId(blocks.getBlock()), InventoryChangedCriterion.Conditions.items(blocks.getBlock()))
                        .offerTo(recipes);

                ShapedRecipeJsonFactory.create(blocks.getStairsBlock(), 4)
                        .pattern("#  ")
                        .pattern("## ")
                        .pattern("###")
                        .input('#', blocks.getBlock())
                        .criterion("has_" + Registry.BLOCK.getId(blocks.getBlock()), InventoryChangedCriterion.Conditions.items(blocks.getBlock()))
                        .offerTo(recipes);

                ShapedRecipeJsonFactory.create(blocks.getWallBlock(), 6)
                        .pattern("###")
                        .pattern("###")
                        .input('#', blocks.getBlock())
                        .criterion("has_" + Registry.BLOCK.getId(blocks.getBlock()), InventoryChangedCriterion.Conditions.items(blocks.getBlock()))
                        .offerTo(recipes);


                SingleItemRecipeJsonFactory.createStonecutting(Ingredient.ofItems(blocks.getBlock()), blocks.getSlabBlock(), 2)
                        .criterion("has_" + Registry.BLOCK.getId(blocks.getBlock()), InventoryChangedCriterion.Conditions.items(blocks.getBlock()))
                        .offerTo(recipes, Registry.BLOCK.getId(blocks.getBlock()) + "_slab_stonecutting");
                SingleItemRecipeJsonFactory.createStonecutting(Ingredient.ofItems(blocks.getBlock()), blocks.getStairsBlock())
                        .criterion("has_" + Registry.BLOCK.getId(blocks.getBlock()), InventoryChangedCriterion.Conditions.items(blocks.getBlock()))
                        .offerTo(recipes, Registry.BLOCK.getId(blocks.getBlock()) + "_stair_stonecutting");
                SingleItemRecipeJsonFactory.createStonecutting(Ingredient.ofItems(blocks.getBlock()), blocks.getWallBlock())
                        .criterion("has_" + Registry.BLOCK.getId(blocks.getBlock()), InventoryChangedCriterion.Conditions.items(blocks.getBlock()))
                        .offerTo(recipes, Registry.BLOCK.getId(blocks.getBlock()) + "_wall_stonecutting");
            }

            MobfulBricksData.handler.run();
        } catch (Throwable throwable) {
            throwable.printStackTrace();
            MobfulBricks.log(Level.INFO, "MobfulBricksRecipes Data Failed!");
            System.exit(1);
        }
        MobfulBricks.log(Level.INFO, "MobfulBricksRecipes Data Loaded!");
    }
}