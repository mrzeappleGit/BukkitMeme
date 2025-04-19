package me.matthewstevens.meme.listeners;

import me.matthewstevens.meme.helper.randNumGen;
import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.EntityDamageEvent.DamageCause;

import java.util.Objects;

import static me.matthewstevens.meme.Meme.plugin;

public class damageListener implements Listener {
    FileConfiguration config = plugin.getConfig();

    String percentage = config.getString("DamageDetection");
    String listenString = Objects.requireNonNull(config.getString("DamageDetectionBool")).toLowerCase();
    boolean listen = Boolean.parseBoolean(listenString);
    double percentageInt = Double.parseDouble(percentage);
    int max = 1000;
    int min = 1;
    @EventHandler
    public void onPlayerDamage(EntityDamageEvent e) {
        if (listen) {
            if (!(e.getEntity().getType() == EntityType.PLAYER)) {
                return; // It's not a player, so we just return
            }
            randNumGen rng = new randNumGen();
            double rand = rng.numGen(min, max);
            if (rand > percentageInt) {
                if (e.getCause().equals(DamageCause.FALL)) {
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
}