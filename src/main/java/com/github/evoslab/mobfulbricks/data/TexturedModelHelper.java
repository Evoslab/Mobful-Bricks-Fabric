package com.github.evoslab.mobfulbricks.data;

import com.github.evoslab.mobfulbricks.MobfulBricks;
import net.minecraft.block.Block;
import net.minecraft.data.client.model.*;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

import java.util.Optional;

public class TexturedModelHelper {
    public static TextureKey FACE;
    public static Model TEMPLATE_BRICKS;
    public static TexturedModel.Factory MOBFUL_BRICK;

    public static void init() {
        FACE = TextureKey.of("face");
        TEMPLATE_BRICKS = block("template_bricks", TextureKey.PATTERN, FACE);
        MOBFUL_BRICK = TexturedModel.makeFactory(TexturedModelHelper::templateBricks, TEMPLATE_BRICKS);
    }

    public static Texture templateBricks(Block block) {
        return (new Texture()).put(TextureKey.PATTERN, Texture.getId(block)).put(FACE, getSubIdMB(block));
    }

    public static Identifier getSubIdMB(Block block) {
        var id = Registry.BLOCK.getId(block);
        String name = id.getPath();
        String path = name.replace("_bricks", "_face_bricks");
        String namespace = id.getNamespace();
        return new Identifier(namespace, "block/" + path);
    }

    public static Model block(String parent, TextureKey... requiredTextures) {
        return new Model(Optional.of(new Identifier(MobfulBricks.MOD_ID, "block/" + parent)), Optional.empty(), requiredTextures);
    }
}