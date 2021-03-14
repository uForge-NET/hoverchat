package net.uforge.mc.pl.hoverchat.utils;

import net.md_5.bungee.api.ChatColor;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

public class Utils {

    public String INFO = ChatColor.AQUA + "[HoverChat/" + ChatColor.GREEN + "INFO" + ChatColor.AQUA + "]: " + ChatColor.GREEN;
    public String WARN = ChatColor.AQUA + "[HoverChat/" + ChatColor.YELLOW + "WARN" + ChatColor.AQUA + "]: " + ChatColor.YELLOW;
    public String ERR = ChatColor.AQUA + "[HoverChat/" + ChatColor.RED + "ERR" + ChatColor.AQUA + "]: " + ChatColor.RED;

    public void sendConsole(String prefix, String msg) {
        Bukkit.getConsoleSender().sendMessage(prefix + msg);
    }

    public void sendConsole(String msg) {
        Bukkit.getConsoleSender().sendMessage(msg);
    }

    public String colorize(String text) {
        return ChatColor.translateAlternateColorCodes('&', text);
    }

}
