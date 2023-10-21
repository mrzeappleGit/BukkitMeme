package me.matthewstevens.meme.listeners;

import org.bukkit.Bukkit;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.EntityDamageEvent.DamageCause;
import org.bukkit.event.player.PlayerDropItemEvent;

import java.util.function.Supplier;

public class damageListener implements Listener {
    int max = 100;
    int min = 1;
    int range = max - min + 1;
    @EventHandler
    public void onPlayerDamage(EntityDamageEvent e){
        if (!(e.getEntity().getType() == EntityType.PLAYER)) {
            return; // It's not a player, so we just return
        }
        int rand = (int)(Math.random() * range) + min;
        Bukkit.getServer().getLogger().info(String.valueOf(rand));
        if(rand > 50){
            if(e.getCause().equals(DamageCause.FALL)){
                Player hurtplayer = (Player) e.getEntity();
                String hurtplayerString = hurtplayer.getDisplayName();
                Bukkit.getServer().broadcastMessage("Oopsie woopsie " + hurtplayerString + " did a fally wally.");
            } else {
                Player hurtplayer = (Player) e.getEntity();
                String hurtplayerString = hurtplayer.getDisplayName();
                Bukkit.getServer().broadcastMessage(hurtplayerString + " needs some milk.");
            }
        }
    }
}