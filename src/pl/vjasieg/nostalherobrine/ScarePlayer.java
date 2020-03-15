package pl.vjasieg.nostalherobrine;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.server.PluginEnableEvent;

import java.util.Random;

public class ScarePlayer implements Listener {

    Random r = new Random();

    @EventHandler
    public void onPluginEnable(PluginEnableEvent event) {
        Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(Bukkit.getPluginManager().getPlugin("NostalHerobrine"), new Runnable() {
            public void run() {
                Player p = Bukkit.getOnlinePlayers()[r.nextInt(Bukkit.getOnlinePlayers().length)].getPlayer();
                try {
                    HerobrineEntity.spawnHerobrine(p.getName());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, 36000L); //36000
    }

}
