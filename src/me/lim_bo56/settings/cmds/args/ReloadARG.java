package me.lim_bo56.settings.cmds.args;

import me.lim_bo56.settings.Core;
import me.lim_bo56.settings.cmds.BaseCommand;
import me.lim_bo56.settings.managers.ConfigurationManager;
import me.lim_bo56.settings.utils.ColorUtils;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;

/**
 * Created by lim_bo56
 * On 8/14/2016
 * At 11:04 AM
 */
public class ReloadARG extends BaseCommand {

    public ReloadARG(Core plugin) {
        super(plugin);
    }

    @Override
    public void executeCommand(CommandSender sender, Command cmd, String[] args) {

        try {
            ConfigurationManager.getMessages().reloadConfig();
            ConfigurationManager.getDefault().reloadConfig();
            ConfigurationManager.getMenu().reloadConfig();
            Core.getInstance().reloadConfig();
            sender.sendMessage(ColorUtils.Color("&aAll files have been reloaded correctly!"));
        } catch (Exception exception) {
            sender.sendMessage(ColorUtils.Color("&cAn error occurred while reloading files!"));
        }
    }

}