package net.uforge.mc.pl.hoverchat.commands;

import net.uforge.mc.pl.hoverchat.HoverChat;
import net.uforge.mc.pl.hoverchat.utils.Utils;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;

public class ReloadConfig implements CommandInterface {

    private final HoverChat core = HoverChat.getPlugin(HoverChat.class);
    private final Utils u = new Utils();


    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {
        core.reloadConfig();
        sender.sendMessage(u.colorize(u.INFO + "Plugin reloaded!"));
        return false;
    }
}
