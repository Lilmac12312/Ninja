package com.shawckz.ninja.check;

import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.craftbukkit.v1_7_R4.entity.CraftPlayer;
import org.bukkit.entity.Player;

/**
 * Created by 360 on 3/27/2015.
 */
public class CheckData {

    private Player player;

    private int ping;
    private Location playerLocation;

    private int cps;
    private GameMode gameMode;
    private long lastAttackTime;

    public CheckData(Player player) {
        this.player = player;

        this.cps = 0;
        this.gameMode = player.getGameMode();
        this.ping = ((CraftPlayer)player).getHandle().ping;
        this.playerLocation = player.getLocation();
        this.lastAttackTime = 0;
    }


    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public int getPing() {
        return ping;
    }

    public void setPing(int ping) {
        this.ping = ping;
    }

    public Location getPlayerLocation() {
        return playerLocation;
    }

    public void setPlayerLocation(Location playerLocation) {
        this.playerLocation = playerLocation;
    }

    public int getCps() {
        return cps;
    }

    public void setCps(int cps) {
        this.cps = cps;
    }

    public GameMode getGameMode() {
        return gameMode;
    }

    public void setGameMode(GameMode gameMode) {
        this.gameMode = gameMode;
    }

    public long getLastAttackTime() {
        return lastAttackTime;
    }

    public void setLastAttackTime(long lastAttackTime) {
        this.lastAttackTime = lastAttackTime;
    }
}
