package me.matthewstevens.meme.listeners;

import me.matthewstevens.meme.Meme;
import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerItemConsumeEvent;
import org.bukkit.plugin.Plugin;


public class eatListener implements Listener {
    int max = 100;
    int min = 1;
    int range = max - min + 1;
    @EventHandler
    public void onPlayerEat(PlayerItemConsumeEvent event){
        int rand = (int)(Math.random() * range) + min;
        if (rand > 50){
            Bukkit.getServer().broadcastMessage("<"+event.getPlayer().getDisplayName()+"> I'll have 2 number 9s,");
            Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(Meme.plugin, new Runnable() {
                @Override
                public void run() {
                    Bukkit.getServer().broadcastMessage("<"+event.getPlayer().getDisplayName()+"> a number 9 large,");
                }
            }, 25L);
            Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(Meme.plugin, new Runnable() {
                @Override
                public void run() {
                    Bukkit.getServer().broadcastMessage("<"+event.getPlayer().getDisplayName()+"> a number 6 with extra dip,");
                }
            }, 50L);
            Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(Meme.plugin, new Runnable() {
                @Override
                public void run() {
                    Bukkit.getServer().broadcastMessage("<"+event.getPlayer().getDisplayName()+"> a number 7,");
                }
            }, 75L);
            Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(Meme.plugin, new Runnable() {
                @Override
                public void run() {
                    Bukkit.getServer().broadcastMessage("<"+event.getPlayer().getDisplayName()+"> two number 45s,");
                }
            }, 100L);
            Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(Meme.plugin, new Runnable() {
                @Override
                public void run() {
                    Bukkit.getServer().broadcastMessage("<"+event.getPlayer().getDisplayName()+"> one with cheese,");
                }
            }, 125L);
            Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(Meme.plugin, new Runnable() {
                @Override
                public void run() {
                    Bukkit.getServer().broadcastMessage("<"+event.getPlayer().getDisplayName()+"> and a large soda.");
                }
            }, 150L);





        }
    }
}
