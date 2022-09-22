package dev.crystalcraft.trollmaster;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

public class MainListener implements Listener {
    @EventHandler
    public void onClick(InventoryClickEvent e) {
        if (e.getView().getTitle().equals("Please select a player")) {
            if (e.getCurrentItem().getType() == Material.PLAYER_HEAD) {
                String targetname = Colorize.decoler(e.getCurrentItem().getItemMeta().getDisplayName());
                Player clicker = (Player) e.getWhoClicked();
                Player target = Bukkit.getPlayer(targetname);
                MainCommand.trollPlayer(clicker,target);
            }
        } else if (e.getView().getTitle().equals("please select troll")) {
            Player target =Bukkit.getPlayer(Colorize.decoler(e.getInventory().getItem(4).getItemMeta().getDisplayName()));
            Player troller = (Player) e.getWhoClicked();
            switch (e.getSlot()) {
                case 10:
                    troller.sendMessage("[" + ChatColor.GREEN + "Troll" + ChatColor.RED + "Master" + ChatColor.RESET + "] selected smite");
                    target.sendMessage("[" + ChatColor.GREEN + "Troll" + ChatColor.RED + "Master" + ChatColor.RESET + "] you have been smitten");
                    target.getWorld().strikeLightning(target.getLocation());
                    e.getWhoClicked().closeInventory();
                    MainCommand.trollPlayer(troller,target);
                    break;
                case 12:
                    troller.sendMessage("[" + ChatColor.GREEN + "Troll" + ChatColor.RED + "Master" + ChatColor.RESET + "] selected super jump");
                    Location jumpLoc = target.getLocation();
                    jumpLoc.add(0.0,100.0,0.0);
                    target.teleport(jumpLoc);
                    target.sendMessage("[" + ChatColor.GREEN + "Troll" + ChatColor.RED + "Master" + ChatColor.RESET + "] i believe i can fly");
                    MainCommand.trollPlayer(troller,target);
                    break;
                case 14:
                    troller.sendMessage("[" + ChatColor.GREEN + "Troll" + ChatColor.RED + "Master" + ChatColor.RESET + "] selected clear inventory");
                    target.getInventory().clear();
                    target.sendMessage("[" + ChatColor.GREEN + "Troll" + ChatColor.RED + "Master" + ChatColor.RESET + "] oops i lost my items");
                    MainCommand.trollPlayer(troller,target);
                    break;
                case 16:
                    troller.sendMessage("[" + ChatColor.GREEN + "Troll" + ChatColor.RED + "Master" + ChatColor.RESET + "] selected teleport here");
                    target.teleport(troller.getLocation());
                    target.sendMessage("[" + ChatColor.GREEN + "Troll" + ChatColor.RED + "Master" + ChatColor.RESET + "] could you come here real quick");
                    MainCommand.trollPlayer(troller,target);
                    break;
            }
        }
    }
}
