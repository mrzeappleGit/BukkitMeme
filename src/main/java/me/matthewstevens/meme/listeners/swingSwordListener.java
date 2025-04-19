package me.matthewstevens.meme.listeners;

import me.matthewstevens.meme.Meme;
import me.matthewstevens.meme.helper.randNumGen;
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
    String listenString = Objects.requireNonNull(config.getString("SwordSwingDetectionBool")).toLowerCase();
    boolean listen = Boolean.parseBoolean(listenString);
    double percentageInt = Double.parseDouble(percentage);
    int max = 1000;
    int min = 1;
    @EventHandler
    public void onPlayerDamage(EntityDamageByEntityEvent e){
        randNumGen rng = new randNumGen();
        double rand = rng.numGen(min, max);
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