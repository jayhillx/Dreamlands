package com.mystanica.dreamlands.common.advancement;

import com.google.gson.JsonObject;
import net.minecraft.advancements.critereon.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerPlayer;

public class DreamAdvancementTrigger extends SimpleCriterionTrigger<DreamAdvancementTrigger.Instance> {
    public final ResourceLocation location;

    public DreamAdvancementTrigger(ResourceLocation location) {
        this.location = location;
    }

    @Override
    public DreamAdvancementTrigger.Instance createInstance(JsonObject json, ContextAwarePredicate predicate, DeserializationContext context) {
        return new DreamAdvancementTrigger.Instance(this.location, predicate);
    }

    public void trigger(ServerPlayer player) {
        this.trigger(player, (instance) -> true);
    }

    @Override
    public ResourceLocation getId() {
        return this.location;
    }

    public static class Instance extends AbstractCriterionTriggerInstance {

        public Instance(ResourceLocation location, ContextAwarePredicate predicate) {
            super(location, predicate);
        }
    }

}