package com.mystanica.dreamlands.init;

import com.mystanica.dreamlands.Dreamlands;
import com.mystanica.dreamlands.common.advancement.DreamAdvancementTrigger;
import net.minecraft.advancements.CriteriaTriggers;

public class DreamCriteriaTriggers {

    public static final DreamAdvancementTrigger INDUCE_DREAM = create("induce_dream");
    public static final DreamAdvancementTrigger ENTER_DREAM = create("enter_dream");
    public static final DreamAdvancementTrigger WOKEN_UP_FROM_SLEEP = create("woken_up_from_sleep");

    private static DreamAdvancementTrigger create(String name) {
        return new DreamAdvancementTrigger(Dreamlands.modLoc(name));
    }

    public static void registerCriteriaTriggers() {
        CriteriaTriggers.register(INDUCE_DREAM);
        CriteriaTriggers.register(ENTER_DREAM);
        CriteriaTriggers.register(WOKEN_UP_FROM_SLEEP);
    }

}