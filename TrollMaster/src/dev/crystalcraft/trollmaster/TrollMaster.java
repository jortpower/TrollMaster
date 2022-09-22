package dev.crystalcraft.trollmaster;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public class TrollMaster extends JavaPlugin {
    @Override
    public void onEnable() {
        Bukkit.getPluginManager().registerEvents(new MainListener(),this);
        getCommand("troll").setExecutor(new MainCommand());
        System.out.println("[TrollMaster] has started");
    }
}
