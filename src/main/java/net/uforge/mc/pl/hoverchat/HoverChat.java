package net.uforge.mc.pl.hoverchat;

import net.uforge.mc.pl.hoverchat.commands.CommandHandler;
import net.uforge.mc.pl.hoverchat.commands.HOVERCHAT;
import net.uforge.mc.pl.hoverchat.commands.ReloadConfig;
import net.uforge.mc.pl.hoverchat.events.ChatEvents;
import net.uforge.mc.pl.hoverchat.utils.Utils;
import org.bukkit.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;

public class HoverChat extends JavaPlugin {

    private final Utils u = new Utils();

    @Override
    public void onEnable() {
        registerEvents();
        registerCommands();
        loadConfig();

        u.sendConsole(u.INFO, "Plugin has been activated!");
        u.sendConsole(u.INFO, "uForge © 2021");
        u.sendConsole(u.INFO, ChatColor.RED + "#####################################");
        u.sendConsole(u.INFO, ChatColor.RED + "# DO NOT USE CLASSIC RELOAD COMMAND #");
        u.sendConsole(u.INFO, ChatColor.RED + "#####################################");
    }

    @Override
    public void onDisable() {
        u.sendConsole(u.INFO, ChatColor.RED + "Plugin has been disabled!");
        u.sendConsole(u.INFO, "uForge © 2021");
    }

    private void registerEvents() {
        getServer().getPluginManager().registerEvents(new ChatEvents(), this);
    }

    private void registerCommands() {
        CommandHandler handler = new CommandHandler();
        handler.register("hoverchat", new HOVERCHAT());
        handler.register("reload", new ReloadConfig());
        getCommand("hoverchat").setExecutor(handler);
    }

    private void loadConfig() {
        getConfig().options().copyDefaults(true);
        saveConfig();
    }

}
