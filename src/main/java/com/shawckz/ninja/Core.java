package com.shawckz.ninja;

import com.shawckz.ninja.check.CheckManager;
import com.shawckz.ninja.player.CacheHandler;
import com.shawckz.ninja.player.NinjaPlayer;
import com.shawckz.ninja.player.PlayerManager;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

/**
 * Created by 360 on 3/26/2015.
 */
public class Core extends JavaPlugin {

    private static Plugin plugin;

    public static void log(String msg){
        Bukkit.getLogger().info("[Ninja] "+msg);
    }

    @Override
    public void onEnable(){
        plugin = this;

        CheckManager.get();

        CheckManager.get().registerListeners(this);

        Ninja.tick();

        getServer().getPluginManager().registerEvents(new CacheHandler(),this);

        for(Player pl : Bukkit.getOnlinePlayers()){
            PlayerManager.put(new NinjaPlayer(pl));
        }

        Runtime.getRuntime().addShutdownHook(new Thread(){
            @Override
            public void run() {
                log("Shutting down");
                plugin = null;
            }
        });
    }

    @Override
    public void onDisable(){
        log("You can't shut us down! Huehuehuehue");
    }

    public static Plugin getPlugin() {
        return plugin;
    }
}
