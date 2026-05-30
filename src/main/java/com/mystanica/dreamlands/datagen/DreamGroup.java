package com.mystanica.dreamlands.datagen;

import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Block;

import java.util.LinkedList;
import java.util.List;
import java.util.function.Consumer;

public class DreamGroup {
    private final Category category;
    private final List<Entry> entries;

    public DreamGroup(Builder builder) {
        this.category = builder.category;
        this.entries = builder.entries;
    }

    public Category getCategory() {
        return this.category;
    }

    public List<Entry> entries() {
        return this.entries;
    }

    public static Builder builder(Category category) {
        return new Builder(category);
    }

    public static class Builder {
        private final Category category;
        private final List<Entry> entries = new LinkedList<>();

        public Builder(Category category) {
            this.category = category;
        }

        public Category getCategory() {
            return this.category;
        }

        public Builder entries(Consumer<EntryOutput> consumer) {
            consumer.accept(item -> {
                Entry entry = new Entry(item);
                this.entries.add(entry);
                return entry;
            });
            return this;
        }

        /**
         * finalize and register this group into {@link DreamGroups#GROUPS} after all entries are added.
         */
        public DreamGroup build() {
            DreamGroup group = new DreamGroup(this);
            DreamGroups.register(this.getCategory(), group);
            return group;
        }
    }

    /**
     * this is for containing the contents in a group, like a list.
     * <p>
     * should have it so each entry can specify certain criteria or not. like if a block should generate its model, etc.
     */
    public record Entry(ItemStack stack) {
        public Item asItem() {
            return this.stack.getItem();
        }

        public Block asBlock() {
            return Block.byItem(this.stack.getItem());
        }
    }

    public interface EntryOutput {
        Entry accept(ItemStack stack);

        default Entry accept(ItemLike item) {
            return this.accept(new ItemStack(item));
        }
    }

    public enum Category {
        LEAVES,
        SAPLINGS,
        SHRUBS,
        SMALL_FLOWERS,
        TALL_FLOWERS,
        FLOWERS,
        POTTED_PLANTS,
        POTTED_SHRUBS,
        PLANKS,
        WOODEN_STAIRS,
        WOODEN_SLABS,
        WOODEN_FENCES,
        WOODEN_BUTTONS,
        WOODEN_PRESSURE_PLATES,
        WOODEN_TRAPDOORS,
        WOODEN_DOORS
    }

}