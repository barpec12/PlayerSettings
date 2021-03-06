package me.limbo56.playersettings.settings.defined;

import me.limbo56.playersettings.api.Setting;
import me.limbo56.playersettings.api.SettingCallback;
import me.limbo56.playersettings.utils.Item;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class JumpSetting implements Setting {
    @Override
    public String getRawName() {
        return "jump_setting";
    }

    @Override
    public ItemStack getItem() {
        return Item.builder()
                .material(Material.SLIME_BLOCK)
                .name("&aJump Boost")
                .lore("&7Ever wanted to be a slime?")
                .lore("&7Click this to feel like one")
                .build();
    }

    @Override
    public int getPage() {
        return 1;
    }

    @Override
    public int getSlot() {
        return 3;
    }

    @Override
    public boolean getDefaultValue() {
        return false;
    }

    public static class JumpSettingCallback implements SettingCallback {
        @Override
        public void notifyChange(Setting setting, Player player, boolean newValue) {
            if (newValue) {
                player.addPotionEffect(new PotionEffect(PotionEffectType.JUMP, 99999, 2));
            } else {
                player.removePotionEffect(PotionEffectType.JUMP);
            }
        }
    }
}
