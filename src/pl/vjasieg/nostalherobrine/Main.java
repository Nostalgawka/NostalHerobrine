package pl.vjasieg.nostalherobrine;

import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {

    public void onEnable() {
        if(getServer().getPluginManager().getPlugin("Citizens") == null || getServer().getPluginManager().getPlugin("Citizens").isEnabled() == false) {
            getLogger().log(java.util.logging.Level.SEVERE, "Citizens 2.0 not found or not enabled");
            getServer().getPluginManager().disablePlugin(this);
            return;
        }
        getCommand("herobrine").setExecutor(new Debug());
        getServer().getPluginManager().registerEvents(new ScarePlayer(), this);
    }

    public void onDisable() {
        System.out.println("NostalHerobrine disabled.");
    }

}
