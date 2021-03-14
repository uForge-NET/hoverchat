package net.uforge.mc.pl.hoverchat.commands;

import net.uforge.mc.pl.hoverchat.utils.Utils;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class HOVERCHAT implements CommandInterface {

    private final Utils u = new Utils();

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {
        Player player = (Player) sender;
        player.sendMessage(u.colorize("&9&lHoverChat- Commands:"));
        player.sendMessage(u.colorize("&e- reload"));

        return false;
    }
}
