package dev.crystalcraft.trollmaster;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;

import java.util.ArrayList;

public class MainCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {

        if (commandSender instanceof Player) {
            if (strings.length == 0) {
                selectPlayer((Player) commandSender);
            } else if(strings.length == 1) {
                if (Bukkit.getPlayer(strings[0]) != null) {
                    trollPlayer((Player) commandSender, Bukkit.getPlayer(strings[0]));
                }
                else {
                    commandSender.sendMessage("[" + ChatColor.GREEN + "Troll" + ChatColor.RED + "Master" + ChatColor.RESET + "] " + ChatColor.RED + " specify a player");
                }
            }
        }
        else {
            commandSender.sendMessage("[TrollMaster] you must be a player to do this");
        }

        return true;
    }

    private void selectPlayer(Player open) {
        open.closeInventory();
        Inventory ui = Bukkit.createInventory(open,45,"Please select a player");

        Player[] players = Bukkit.getOnlinePlayers().toArray(new Player[0]);

        for (int i = 0;i<players.length; i++) {
            ui.setItem(i, ItemBuilder.createSkull(players[i]));
        }

        for (int i = 0;i<45;i++) {
            if (ui.getItem(i) == null)
                ui.setItem(i,ItemBuilder.createItem(" ", Material.GRAY_STAINED_GLASS_PANE,false));
        }

        open.openInventory(ui);
    }

    public static void trollPlayer(Player open,Player target) {
        open.closeInventory();
        Inventory ui = Bukkit.createInventory(open,27,"please select troll");
        ui.setItem(4,ItemBuilder.createSkull(target));

        ui.setItem(10,ItemBuilder.createItem("Smite",Material.IRON_AXE,true));

        ui.setItem(12,ItemBuilder.createItem("Super Jump",Material.FEATHER,true));

        ui.setItem(14,ItemBuilder.createItem("Clear Inventory",Material.BUCKET,true));

        ui.setItem(16,ItemBuilder.createItem("teleport here",Material.ENDER_PEARL,true));

        for (int i = 0;i<27;i++) {
            if (ui.getItem(i) == null)
                ui.setItem(i,ItemBuilder.createItem(" ", Material.GRAY_STAINED_GLASS_PANE,false));
        }

        open.openInventory(ui);
    }
}
