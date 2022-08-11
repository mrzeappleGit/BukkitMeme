package me.matthewstevens.meme.listeners;

import me.matthewstevens.meme.Meme;
import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.event.player.PlayerItemConsumeEvent;

public class dropListener implements Listener {
    int max = 100;
    int min = 1;
    int range = max - min + 1;
    @EventHandler
    public void onPlayerDrop(PlayerDropItemEvent event){
        int rand = (int)(Math.random() * range) + min;
        if (rand > 80){
            Bukkit.getServer().broadcastMessage("<"+event.getPlayer().getDisplayName()+"> Oopsie I dropped an item");
        }
    }
}
