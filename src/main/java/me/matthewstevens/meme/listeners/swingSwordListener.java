package me.matthewstevens.meme.listeners;

import me.matthewstevens.meme.Meme;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;

import java.util.Objects;

import static me.matthewstevens.meme.Meme.plugin;

public class swingSwordListener implements Listener {

    FileConfiguration config = plugin.getConfig();

    String percentage = config.getString("SwordSwingDetection");
    String listenString = Objects.requireNonNull(config.getString("SwordSwingBool")).toLowerCase();
    boolean listen = Boolean.parseBoolean(listenString);
    int percentageInt = Integer.parseInt(percentage);
    int max = 100;
    int min = 1;
    int range = max - min + 1;
    @EventHandler
    public void onPlayerDamage(EntityDamageByEntityEvent e){
        int rand = (int)(Math.random() * range) + min;
        if(listen) {
            if (rand > percentageInt) {
                if (e.getDamager() instanceof Player) {
                    Player player = (Player) e.getDamager();
                    if (player.getInventory().getItemInMainHand().getType() == Material.DIAMOND_SWORD) {
                        Bukkit.getServer().broadcastMessage("<" + Objects.requireNonNull(player.getPlayer()).getDisplayName() + "> I can swing my sword, sword");
                        Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(Meme.plugin, new Runnable() {
                            @Override
                            public void run() {
                                Bukkit.getServer().broadcastMessage("<" + player.getPlayer().getDisplayName() + "> I can swing my sword, sword");
                            }
                        }, 25L);
                    }
                }
            }
        }
    }
}