package com.mystanica.dreamlands.init;

import com.mystanica.dreamlands.Dreamlands;
import com.mystanica.dreamlands.common.effect.DreamingEffect;
import com.mystanica.dreamlands.common.effect.SleepyEffect;
import net.minecraft.core.Holder;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.effect.MobEffect;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class DreamEffects {
    public static final DeferredRegister<MobEffect> EFFECTS = DeferredRegister.create(Registries.MOB_EFFECT, Dreamlands.modId);

    public static final RegistryObject<MobEffect> SLEEPY = EFFECTS.register("sleepy", SleepyEffect::new);
    public static final RegistryObject<MobEffect> DREAMING = EFFECTS.register("dreaming", DreamingEffect::new);

}