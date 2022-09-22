package dev.crystalcraft.trollmaster;

import org.bukkit.ChatColor;

public class Colorize {
    public static String translate(String string) {
        return ChatColor.WHITE + ChatColor.translateAlternateColorCodes('&',string);
    }

    public static String decoler(String string) {
        return ChatColor.stripColor(string);
    }
}
