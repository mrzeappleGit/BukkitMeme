package me.matthewstevens.meme.listeners;

import me.matthewstevens.meme.Meme;
import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerItemConsumeEvent;
import org.bukkit.plugin.Plugin;

import java.util.Objects;

import static me.matthewstevens.meme.Meme.plugin;


public class eatListener implements Listener {

    FileConfiguration config = plugin.getConfig();

    String percentage = config.getString("EatDetection");
    String listenString = Objects.requireNonNull(config.getString("EatBool")).toLowerCase();
    boolean listen = Boolean.parseBoolean(listenString);
    int percentageInt = Integer.parseInt(percentage);
    int max = 100;
    int min = 1;
    int range = max - min + 1;
    @EventHandler
    public void onPlayerEat(PlayerItemConsumeEvent event) {
        int rand = (int) (Math.random() * range) + min;
        if (listen) {
            if (rand > percentageInt) {
                Bukkit.getServer().broadcastMessage("<" + event.getPlayer().getDisplayName() + "> I'll have 2 number 9s,");
                Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(Meme.plugin, new Runnable() {
                    @Override
                    public void run() {
                        Bukkit.getServer().broadcastMessage("<" + event.getPlayer().getDisplayName() + "> a number 9 large,");
                    }
                }, 25L);
                Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(Meme.plugin, new Runnable() {
                    @Override
                    public void run() {
                        Bukkit.getServer().broadcastMessage("<" + event.getPlayer().getDisplayName() + "> a number 6 with extra dip,");
                    }
                }, 50L);
                Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(Meme.plugin, new Runnable() {
                    @Override
                    public void run() {
                        Bukkit.getServer().broadcastMessage("<" + event.getPlayer().getDisplayName() + "> a number 7,");
                    }
                }, 75L);
                Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(Meme.plugin, new Runnable() {
                    @Override
                    public void run() {
                        Bukkit.getServer().broadcastMessage("<" + event.getPlayer().getDisplayName() + "> two number 45s,");
                    }
                }, 100L);
                Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(Meme.plugin, new Runnable() {
                    @Override
                    public void run() {
                        Bukkit.getServer().broadcastMessage("<" + event.getPlayer().getDisplayName() + "> one with cheese,");
                    }
                }, 125L);
                Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(Meme.plugin, new Runnable() {
                    @Override
                    public void run() {
                        Bukkit.getServer().broadcastMessage("<" + event.getPlayer().getDisplayName() + "> and a large soda.");
                    }
                }, 150L);


            }
        }
    }
}
