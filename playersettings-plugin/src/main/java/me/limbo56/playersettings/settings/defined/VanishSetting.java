package me.limbo56.playersettings.settings.defined;

import me.limbo56.playersettings.api.Setting;
import me.limbo56.playersettings.api.SettingCallback;
import me.limbo56.playersettings.utils.Item;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class VanishSetting implements Setting {
    @Override
    public String getRawName() {
        return "vanish_setting";
    }

    @Override
    public ItemStack getItem() {
        return Item.builder()
                .material(Material.ENDER_PEARL)
                .name("&aVanish")
                .lore("&7Make yourself invisible to")
                .lore("&7other players")
                .build();
    }

    @Override
    public int getPage() {
        return 1;
    }

    @Override
    public int getSlot() {
        return 31;
    }

    @Override
    public boolean getDefaultValue() {
        return false;
    }

    public static class VanishSettingCallback implements SettingCallback {
        @Override
        public void notifyChange(Setting setting, Player player, boolean newValue) {
            if (newValue) {
                player.addPotionEffect(new PotionEffect(PotionEffectType.INVISIBILITY, 99999, 1));
                Bukkit.getOnlinePlayers().forEach(players -> players.hidePlayer(player));
            } else {
                player.removePotionEffect(PotionEffectType.INVISIBILITY);
                Bukkit.getOnlinePlayers().forEach(players -> players.showPlayer(player));
            }
        }
    }
}
