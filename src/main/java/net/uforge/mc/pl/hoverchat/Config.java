package net.uforge.mc.pl.hoverchat;

import java.util.List;

public class Config {

    private static final HoverChat core = HoverChat.getPlugin(HoverChat.class);

    // @s: Config Variables
    public static boolean isHoverMessageActive;
    // @e: Config Variables

    public static void load() {
        core.getConfig().options().copyDefaults(true);
        core.saveConfig();
        setConfigVariables();
    }

    public static void reload() {
        core.reloadConfig();
    }

    private static void setConfigVariables() {
        isHoverMessageActive = getBoolean("hoverMessage.active");
    }

    public static String getString(String key) {
        return core.getConfig().getString(key);
    }

    public static Boolean getBoolean(String key) {
        return core.getConfig().getBoolean(key);
    }

    public static List<String> getStringList(String key) {
        return core.getConfig().getStringList(key);
    }

}
