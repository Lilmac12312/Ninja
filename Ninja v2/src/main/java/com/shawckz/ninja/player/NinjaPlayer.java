package com.shawckz.ninja.player;

import org.bukkit.entity.Player;

/**
 * Created by 360 on 3/26/2015.
 */
public class NinjaPlayer {

    private Player bukkitPlayer;

    public NinjaPlayer(Player bukkitPlayer) {
        this.bukkitPlayer = bukkitPlayer;
    }

    public Player getBukkitPlayer() {
        return bukkitPlayer;
    }

}
