package pl.vjasieg.nostalherobrine;

import net.citizensnpcs.api.CitizensAPI;
import net.citizensnpcs.api.npc.NPC;
import net.citizensnpcs.api.npc.NPCRegistry;
import org.bukkit.Bukkit;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class HerobrineEntity {
    public static void spawnHerobrine(String player) throws InterruptedException {
        Player p = Bukkit.getPlayer(player);
        PotionEffect effect = new PotionEffect(PotionEffectType.BLINDNESS, 200, 1);
        PotionEffect effect1 = new PotionEffect(PotionEffectType.CONFUSION, 200, 2);
        NPCRegistry registry = CitizensAPI.getNPCRegistry();
        NPC npc = registry.createNPC(EntityType.PLAYER, "Herobrine");
        npc.spawn(p.getLocation());
        npc.getNavigator().setTarget(Bukkit.getPlayer(player), true);
        p.addPotionEffect(effect);
        p.addPotionEffect(effect1);
        Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(Bukkit.getPluginManager().getPlugin("NostalHerobrine"), new Runnable() {
            public void run() {
                npc.despawn();
                p.removePotionEffect(PotionEffectType.BLINDNESS);
                p.removePotionEffect(PotionEffectType.CONFUSION);
                p.setHealth(20);
            }
        }, 200L);
    }
}
