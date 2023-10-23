package me.matthewstevens.meme.listeners;

import me.matthewstevens.meme.Meme;
import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.event.player.PlayerItemConsumeEvent;

import java.util.Objects;

import static me.matthewstevens.meme.Meme.plugin;

public class dropListener implements Listener {

    FileConfiguration config = plugin.getConfig();

    String percentage = config.getString("DropDetection");
    String listenString = Objects.requireNonNull(config.getString("DropDetectionBool")).toLowerCase();
    boolean listen = Boolean.parseBoolean(listenString);
    int percentageInt = Integer.parseInt(percentage);
    int max = 100;
    int min = 1;
    int range = max - min + 1;
    @EventHandler
    public void onPlayerDrop(PlayerDropItemEvent event) {
        int rand = (int) (Math.random() * range) + min;
        if (listen) {
            if (rand > percentageInt) {
                Bukkit.getServer().broadcastMessage("<" + event.getPlayer().getDisplayName() + "> Oopsie I dropped an item");
            }
        }
    }
}
