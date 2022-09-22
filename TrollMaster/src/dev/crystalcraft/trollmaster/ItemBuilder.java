package dev.crystalcraft.trollmaster;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.SkullMeta;

public class ItemBuilder {
    public static ItemStack createItem(String name, Material material,boolean enchantmentGlint) {
        ItemStack item = new ItemStack(material);
        ItemMeta itemMeta = item.getItemMeta();
        itemMeta.setDisplayName(Colorize.translate(name));
        if (enchantmentGlint == true) {
            itemMeta.addEnchant(Enchantment.DURABILITY,1,false);
            itemMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        }
        item.setItemMeta(itemMeta);
        return item;
    }

    public static ItemStack createSkull(Player player) {
        ItemStack item = new ItemStack(Material.PLAYER_HEAD);
        SkullMeta itemMeta = (SkullMeta) item.getItemMeta();
        if (player.isOp())
            itemMeta.setDisplayName(ChatColor.RED + player.getName());
        else
            itemMeta.setDisplayName(ChatColor.GOLD + player.getName());
        itemMeta.setOwningPlayer(player);
        item.setItemMeta(itemMeta);
        return item;
    }
}
