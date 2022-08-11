package me.matthewstevens.meme.listeners;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.player.PlayerDropItemEvent;

public class damageListener implements Listener {
    int max = 100;
    int min = 1;
    int range = max - min + 1;
    @EventHandler
    public void onPlayerDamage(EntityDamageEvent e){
        int rand = (int)(Math.random() * range) + min;
        if (rand > 50){
            if(e.getClass().getName() == "PLAYER") {
                Player hurtplayer = (Player) e.getEntity();
                String hurtplayerString = hurtplayer.getDisplayName();
                Bukkit.getServer().broadcastMessage(hurtplayerString + " needs some milk.");
            }
        }
    }
}