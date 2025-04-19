package me.matthewstevens.meme.listeners;

import me.matthewstevens.meme.Meme;
import me.matthewstevens.meme.helper.randNumGen;
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
    double percentageInt = Double.parseDouble(percentage);
    int max = 1000;
    int min = 1;
    @EventHandler
    public void onPlayerDrop(PlayerDropItemEvent event) {
        randNumGen rng = new randNumGen();
        double rand = rng.numGen(min, max);
        if (listen) {
            if (rand > percentageInt) {
                Bukkit.getServer().broadcastMessage("<" + event.getPlayer().getDisplayName() + "> Oopsie I dropped an item");
            }
        }
    }
}
