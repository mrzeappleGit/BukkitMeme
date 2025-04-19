package me.matthewstevens.meme.listeners;

import me.matthewstevens.meme.helper.randNumGen;
import org.bukkit.ChatColor;
import org.bukkit.Color;
import org.bukkit.FireworkEffect;
import org.bukkit.FireworkEffect.Type;
import org.bukkit.Location;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Chicken;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Firework;
import org.bukkit.entity.Husk;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Zombie;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.CreatureSpawnEvent;
import org.bukkit.inventory.meta.FireworkMeta;

import java.util.Objects;

import static me.matthewstevens.meme.Meme.plugin;

public class chickenJockeyListener implements Listener {

    FileConfiguration config = plugin.getConfig();

    String percentage = config.getString("ChickenJockeyDetection");
    String listenString = Objects.requireNonNull(config.getString("ChickenJockeyDetectionBool")).toLowerCase();

    boolean listen = Boolean.parseBoolean(listenString);
    double percentageInt = Double.parseDouble(percentage);
    int max = 1000;
    int min = 1;
    @EventHandler
    public void onCreatureSpawn(CreatureSpawnEvent event) {
        if(listen) {
            LivingEntity spawnedEntity = (LivingEntity) event.getEntity();
            LivingEntity vehicle = (LivingEntity) spawnedEntity.getVehicle();

            if ((spawnedEntity.getType() == EntityType.ZOMBIE || spawnedEntity.getType() == EntityType.HUSK) && vehicle != null && vehicle.getType() == EntityType.CHICKEN) {
                if (spawnedEntity.getType() == EntityType.ZOMBIE) {
                    Zombie zombie = (Zombie) spawnedEntity;
                    if (zombie.isBaby()) {
                        triggerFireworks("Baby Zombie");
                    } else {
                        triggerFireworks("Adult Zombie");
                    }
                } else if (spawnedEntity.getType() == EntityType.HUSK) {
                    Husk husk = (Husk) spawnedEntity;
                    if (husk.isBaby()) {
                        triggerFireworks("Baby Husk");
                    } else {
                        triggerFireworks("Adult Husk");
                    }
                }
            }
        }
    }

    private void triggerFireworks(String jockeyType) {
        randNumGen rng = new randNumGen();
        double rand = rng.numGen(min, max);
        if (rand > percentageInt) {
            String baseMessage;
            if (jockeyType.startsWith("Baby")) {
                baseMessage = "A Chicken Jockey, a real one like from the movie!";
            } else {
                baseMessage = "Chicken Jockey... Oh dag nabit it is only an adult " + jockeyType.split(" ")[0] + "!";
            }

            // Define the rainbow colors
            ChatColor[] rainbowColors = {
                    ChatColor.RED,
                    ChatColor.GOLD,
                    ChatColor.YELLOW,
                    ChatColor.GREEN,
                    ChatColor.AQUA,
                    ChatColor.BLUE,
                    ChatColor.LIGHT_PURPLE
            };

            StringBuilder rainbowMessage = new StringBuilder();
            int colorIndex = 0;
            for (char c : baseMessage.toCharArray()) {
                rainbowMessage.append(rainbowColors[colorIndex % rainbowColors.length]).append(c);
                colorIndex++;
            }

            plugin.getServer().broadcastMessage(rainbowMessage.toString());

            plugin.getServer().getOnlinePlayers().forEach(player -> {
                Location playerLocation = player.getLocation().add(0, 2, 0);
                Firework firework = player.getWorld().spawn(playerLocation, Firework.class);
                FireworkMeta meta = firework.getFireworkMeta();
                meta.addEffect(FireworkEffect.builder()
                        .flicker(true)
                        .trail(false)
                        .with(Type.BALL_LARGE)
                        .withColor(Color.RED, Color.YELLOW)
                        .withFade(Color.ORANGE)
                        .build());
                meta.setPower(1);
                firework.setFireworkMeta(meta);
            });
        }
    }
}