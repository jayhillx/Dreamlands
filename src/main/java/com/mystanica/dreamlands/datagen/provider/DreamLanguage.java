package com.mystanica.dreamlands.datagen.provider;

import com.mystanica.dreamlands.Dreamlands;
import com.mystanica.dreamlands.init.DreamItems;
import net.minecraft.data.PackOutput;
import net.minecraftforge.common.data.LanguageProvider;

public class DreamLanguage extends LanguageProvider {

    public DreamLanguage(PackOutput output) {
        super(output, Dreamlands.modId, "en_us");
    }

    @Override
    protected void addTranslations() {
        DreamItems.ITEMS.getEntries().forEach((item) ->
                this.add(item.get(), formatName(item.getId().getPath()))
        );
    }

    private static String formatName(String path) {
        String[] spaces = path.split("_");
        StringBuilder name = new StringBuilder();

        for (String part : spaces) {
            name.append(Character.toUpperCase(part.charAt(0)))
                    .append(part.substring(1))
                    .append(" ");
        }
        return name.toString().trim();
    }

}