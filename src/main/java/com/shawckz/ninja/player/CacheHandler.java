package com.shawckz.ninja.player;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

/**
 * Created by 360 on 3/27/2015.
 */
public class CacheHandler implements Listener {

    @EventHandler
    public void onJoin(PlayerJoinEvent e){
        PlayerManager.put(new NinjaPlayer(e.getPlayer()));
    }

    @EventHandler
    public void onQuit(PlayerQuitEvent e){
        PlayerManager.remove(e.getPlayer().getName());
    }

}
