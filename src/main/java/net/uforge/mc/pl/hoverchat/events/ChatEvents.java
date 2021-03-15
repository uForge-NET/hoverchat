package net.uforge.mc.pl.hoverchat.events;

import me.clip.placeholderapi.PlaceholderAPI;
import net.md_5.bungee.api.chat.BaseComponent;
import net.md_5.bungee.api.chat.ComponentBuilder;
import net.md_5.bungee.api.chat.HoverEvent;
import net.md_5.bungee.api.chat.TextComponent;
import net.uforge.mc.pl.hoverchat.Config;
import net.uforge.mc.pl.hoverchat.HoverChat;
import net.uforge.mc.pl.hoverchat.utils.Utils;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class ChatEvents implements Listener {

    private final HoverChat core = HoverChat.getPlugin(HoverChat.class);
    private final Utils u = new Utils();

    @EventHandler
    public void onMessage(AsyncPlayerChatEvent event) {
        event.setCancelled(true);
        Player player = event.getPlayer();

        String config_messageFormat = Config.getString("global.chatFormat");
        config_messageFormat = config_messageFormat.replace("{DISPLAYNAME}", player.getDisplayName()).replace("{MESSAGE}", event.getMessage());
        config_messageFormat = PlaceholderAPI.setPlaceholders(player, config_messageFormat);

        TextComponent msg = new TextComponent(config_messageFormat);

        if(Config.isHoverMessageActive) {
            LocalDateTime date = LocalDateTime.now();
            DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern(Config.getString("global.dateFormat"));
            String dateText = date.format(dateTimeFormatter);
            String hoverText = "";
            List<String> hoverTextList = Config.getStringList("hoverMessage.hoverText");
            int i = 0;
            for(String hoverLore : hoverTextList) {
                i++;
                hoverLore = hoverLore.replace("{DATE}", dateText);
                if(i == hoverTextList.size()) {
                    hoverText += PlaceholderAPI.setPlaceholders(player, u.colorize(hoverLore));
                } else {
                    hoverText += PlaceholderAPI.setPlaceholders(player, u.colorize(hoverLore)) + "\n";
                }
            }
            msg.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new ComponentBuilder(hoverText).create()));
        }

        core.getServer().spigot().broadcast(msg);
    }

}
