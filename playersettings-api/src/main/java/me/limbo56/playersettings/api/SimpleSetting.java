package me.limbo56.playersettings.api;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import org.bukkit.inventory.ItemStack;

@Builder
@Data
public class SimpleSetting implements Setting {
    private String rawName;
    private ItemStack item;
    private int page;
    private int slot;
    @Getter(AccessLevel.NONE)
    private boolean defaultValue;

    @Override
    public boolean getDefaultValue() {
        return defaultValue;
    }
}
