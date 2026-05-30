package com.mystanica.dreamlands.common.worldgen.feature.decorator;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import com.mystanica.dreamlands.init.DreamBlocks;
import com.mystanica.dreamlands.init.DreamFeatures;
import net.minecraft.core.BlockPos;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.levelgen.feature.treedecorators.TreeDecorator;
import net.minecraft.world.level.levelgen.feature.treedecorators.TreeDecoratorType;

import javax.annotation.Nonnull;

public class HangingWisteriaDecorator extends TreeDecorator {
    public static final Codec<HangingWisteriaDecorator> CODEC = RecordCodecBuilder.create((instance) -> instance.group(
            Codec.doubleRange(0.0D, 1.0D).fieldOf("probability").forGetter(decorator -> decorator.probability)
    ).apply(instance, HangingWisteriaDecorator::new));
    private final double probability;

    public HangingWisteriaDecorator(double probability) {
        this.probability = probability;
    }

    @Nonnull
    @Override
    protected TreeDecoratorType<?> type() {
        return DreamFeatures.HANGING_WISTERIA.get();
    }

    @Override
    public void place(Context context) {
        RandomSource random = context.random();

        for (BlockPos pos : context.leaves()) {
            BlockPos start = pos.below();
            if (!context.isAir(start) || !context.isAir(start.below())) {
                continue;
            }

            int length = 2;
            if (context.isAir(start.below(3)) && random.nextDouble() < 0.4D) {
                length = 3;
            }

            for (int i = length - 1; i >= 0; i--) {
                BlockPos placePos = start.below(i);
                if (i == 0) {
                    context.setBlock(placePos, DreamBlocks.WISTERIA_BLOSSOMS.get().defaultBlockState());
                } else if (i == length - 1) {
                    context.setBlock(placePos, DreamBlocks.WISTERIA.get().defaultBlockState());
                } else {
                    context.setBlock(placePos, DreamBlocks.WISTERIA_PLANT.get().defaultBlockState());
                }
            }
        }
    }

}