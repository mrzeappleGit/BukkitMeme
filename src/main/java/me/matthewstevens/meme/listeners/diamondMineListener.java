package me.matthewstevens.meme.listeners;

import me.matthewstevens.meme.helper.randNumGen;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;

import java.util.Objects;

import static me.matthewstevens.meme.Meme.plugin;

public class diamondMineListener implements Listener {
    FileConfiguration config = plugin.getConfig();

    String percentage = config.getString("DiamondMineDetection");
    String listenString = Objects.requireNonNull(config.getString("DiamondMineDetectionBool")).toLowerCase();

    boolean listen = Boolean.parseBoolean(listenString);
    double percentageInt = Double.parseDouble(percentage);
    int max = 1000;
    int min = 1;

    @EventHandler
    public void onBlockBreak(BlockBreakEvent event) {
        if(listen) {
            if (event.getBlock().getType() == Material.DIAMOND_ORE) {
                randNumGen rng = new randNumGen();
                double rand = rng.numGen(min, max);
                if (rand > percentageInt) {
                    // Code to execute when a diamond ore is mined goes here
                    Bukkit.getServer().broadcastMessage("<" + event.getPlayer().getDisplayName() + "> I yearn for the mine!");
                }
            }
        }
    }
}