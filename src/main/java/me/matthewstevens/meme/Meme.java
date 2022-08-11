package me.matthewstevens.meme;

import me.matthewstevens.meme.listeners.damageListener;
import me.matthewstevens.meme.listeners.dropListener;
import me.matthewstevens.meme.listeners.eatListener;
import me.matthewstevens.meme.listeners.swingSwordListener;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

public final class Meme extends JavaPlugin{

    public static Meme plugin;
    @Override
    public void onEnable() {
        plugin = this;
        // Plugin startup logic
        getServer().getPluginManager().registerEvents(new eatListener(), this);
        getServer().getPluginManager().registerEvents(new dropListener(), this);
        getServer().getPluginManager().registerEvents(new damageListener(), this);
        getServer().getPluginManager().registerEvents(new swingSwordListener(), this);

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
