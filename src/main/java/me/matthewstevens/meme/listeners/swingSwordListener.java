package me.matthewstevens.meme.listeners;

import me.matthewstevens.meme.Meme;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;

public class swingSwordListener implements Listener {
    int max = 100;
    int min = 1;
    int range = max - min + 1;
    @EventHandler
    public void onPlayerDamage(EntityDamageByEntityEvent e){
        int rand = (int)(Math.random() * range) + min;
        if (rand > 20){
            if (e.getDamager() instanceof Player){
                Player player = (Player) e.getDamager();
                if (player.getInventory().getItemInMainHand().equals(Material.DIAMOND_SWORD)) {
                    Bukkit.getServer().broadcastMessage("<"+player.getPlayer().getDisplayName()+"> I can swing my sword, sword");
                    Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(Meme.plugin, new Runnable() {
                        @Override
                        public void run() {
                            Bukkit.getServer().broadcastMessage("<"+player.getPlayer().getDisplayName()+"> I can swing my sword, sword");
                        }
                    }, 25L);
                }
            }
        }
    }
}