package com.github.evoslab.mobfulbricks.init;

import co.eltrut.differentiate.common.repo.VariantBlocks;
import co.eltrut.differentiate.core.registrator.BlockHelper;
import com.github.evoslab.mobfulbricks.MobfulBricks;
import com.github.evoslab.mobfulbricks.blocks.MobBrickBlock;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.*;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.registry.Registry;

@SuppressWarnings({"unused"})
public class MobfulBricksBlocks {
    private static final BlockHelper HELPER = MobfulBricks.REGISTRATOR.getHelper(Registry.BLOCK);

    public static final VariantBlocks BEE_BRICKS = HELPER.createSimpleBlockWithVariants("bee_bricks", new MobBrickBlock(Settings.BRICKS), Settings.BRICKS, ItemGroup.BUILDING_BLOCKS);
    public static final VariantBlocks PANDA_BRICKS = HELPER.createSimpleBlockWithVariants("panda_bricks", new MobBrickBlock(Settings.BRICKS), Settings.BRICKS, ItemGroup.BUILDING_BLOCKS);
    public static final VariantBlocks POLAR_BEAR_BRICKS = HELPER.createSimpleBlockWithVariants("polar_bear_bricks", new MobBrickBlock(Settings.BRICKS), Settings.BRICKS, ItemGroup.BUILDING_BLOCKS);
    public static final VariantBlocks BLAZE_BRICKS = HELPER.createSimpleBlockWithVariants("blaze_bricks", new MobBrickBlock(Settings.BRICKS), Settings.BRICKS, ItemGroup.BUILDING_BLOCKS);
    public static final VariantBlocks STRIDER_BRICKS = HELPER.createSimpleBlockWithVariants("strider_bricks", new MobBrickBlock(Settings.BRICKS), Settings.BRICKS, ItemGroup.BUILDING_BLOCKS);
    public static final VariantBlocks HOGLIN_BRICKS = HELPER.createSimpleBlockWithVariants("hoglin_bricks", new MobBrickBlock(Settings.BRICKS), Settings.BRICKS, ItemGroup.BUILDING_BLOCKS);
    public static final VariantBlocks STEVE_BRICKS = HELPER.createSimpleBlockWithVariants("steve_bricks", new MobBrickBlock(Settings.BRICKS), Settings.BRICKS, ItemGroup.BUILDING_BLOCKS);
    public static final VariantBlocks CARMEN_BRICKS = HELPER.createSimpleBlockWithVariants("carmen_bricks", new MobBrickBlock(Settings.BRICKS), Settings.BRICKS, ItemGroup.BUILDING_BLOCKS);
    public static final VariantBlocks STEVEN_BRICKS = HELPER.createSimpleBlockWithVariants("steven_bricks", new MobBrickBlock(Settings.BRICKS), Settings.BRICKS, ItemGroup.BUILDING_BLOCKS);
    public static final VariantBlocks SPUD_BRICKS = HELPER.createSimpleBlockWithVariants("spud_bricks", new MobBrickBlock(Settings.BRICKS), Settings.BRICKS, ItemGroup.BUILDING_BLOCKS);

    public static class Settings {
        public static final FabricBlockSettings BRICKS = FabricBlockSettings.copyOf(Blocks.STONE_BRICKS);
    }
}