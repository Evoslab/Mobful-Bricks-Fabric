package com.github.evoslab.mobfulbricks.data;

import com.github.evoslab.mobfulbricks.MobfulBricks;
import com.github.evoslab.mobfulbricks.data.basic.MobfulBricksRecipes;
import com.github.evoslab.mobfulbricks.data.basic.MobfulBricksStates;
import com.github.evoslab.mobfulbricks.data.basic.MobfulBricksTables;
import com.github.evoslab.mobfulbricks.data.basic.MobfulBricksTags;
import me.shedaniel.cloth.api.datagen.v1.DataGeneratorHandler;
import org.apache.logging.log4j.Level;

import java.nio.file.Paths;

public class MobfulBricksData {
    public static final DataGeneratorHandler handler = DataGeneratorHandler.create(Paths.get("../src/generated/resources"));

    public static void init() {
        var modelStates = handler.getModelStates();
        var lootTables = handler.getLootTables();
        var recipes = handler.getRecipes();
        var tags = handler.getTags();

        TexturedModelHelper.init();
        MobfulBricksStates.init(modelStates);
        MobfulBricksTables.init(lootTables);
        MobfulBricksRecipes.init(recipes);
        MobfulBricksTags.init(tags);

//        System.exit(0);

        MobfulBricks.log(Level.INFO, "MobfulBricks Data Loaded!");
    }
}