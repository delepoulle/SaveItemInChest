package fr.manwald.save;

import org.bukkit.plugin.java.JavaPlugin;

public class SaveInventoryInChest extends JavaPlugin {

    // Fired when plugin is first enabled
    @Override
    public void onEnable() {
        getServer().getPluginManager().registerEvents(new MyListener(), this);
    }
    // Fired when plugin is disabled
    @Override
    public void onDisable() {

    }
}
