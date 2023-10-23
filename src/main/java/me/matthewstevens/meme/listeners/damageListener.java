package me.matthewstevens.meme.listeners;

import com.sun.org.apache.xpath.internal.operations.Bool;
import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.EntityDamageEvent.DamageCause;
import org.bukkit.event.player.PlayerDropItemEvent;

import java.util.Objects;
import java.util.function.Supplier;

import static me.matthewstevens.meme.Meme.plugin;

public class damageListener implements Listener {
    FileConfiguration config = plugin.getConfig();

    String percentage = config.getString("DamageDetection");
    String listenString = Objects.requireNonNull(config.getString("DamageDetectionBool")).toLowerCase();
    boolean listen = Boolean.parseBoolean(listenString);
    int percentageInt = Integer.parseInt(percentage);
    int max = 100;
    int min = 1;
    int range = max - min + 1;
    @EventHandler
    public void onPlayerDamage(EntityDamageEvent e) {
        if (listen) {
            if (!(e.getEntity().getType() == EntityType.PLAYER)) {
                return; // It's not a player, so we just return
            }
            int rand = (int) (Math.random() * range) + min;
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