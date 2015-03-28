package com.shawckz.ninja.check;

import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.craftbukkit.v1_7_R4.entity.CraftPlayer;
import org.bukkit.entity.Arrow;
import org.bukkit.entity.Player;

/**
 * Created by 360 on 3/27/2015.
 */
public class CheckData {

    private Player player;

    private int ping;
    private Location playerLocation;

    private int cps;
    private int lastCps;
    private GameMode gameMode;
    private long lastAttackTime;
    private double blocksPerSecond;
    private double hps;
    private double health;
    private long bowPullTime;
    private long bowPullShot;
    private Arrow bowArrow;
    private int bowSlot;
    private boolean pullingBow;


    public CheckData(Player player) {
        this.player = player;

        this.cps = 0;
        this.gameMode = player.getGameMode();
        this.ping = ((CraftPlayer)player).getHandle().ping;
        this.playerLocation = player.getLocation();
        this.lastAttackTime = 0;
        this.blocksPerSecond = 0;
        this.hps = 0;
        this.lastCps = 0;
        this.health = player.getHealth();
        this.bowPullTime = 0;
        this.bowPullShot = 0;
        this.bowArrow = null;
        this.bowSlot = 0;
        this.pullingBow = false;
    }

    public long getBowPullTime() {
        return bowPullTime;
    }

    public void setBowPullTime(long bowPullTime) {
        this.bowPullTime = bowPullTime;
    }

    public long getBowPullShot() {
        return bowPullShot;
    }

    public void setBowPullShot(long bowPullShot) {
        this.bowPullShot = bowPullShot;
    }

    public Arrow getBowArrow() {
        return bowArrow;
    }

    public void setBowArrow(Arrow bowArrow) {
        this.bowArrow = bowArrow;
    }

    public int getBowSlot() {
        return bowSlot;
    }

    public void setBowSlot(int bowSlot) {
        this.bowSlot = bowSlot;
    }

    public boolean isPullingBow() {
        return pullingBow;
    }

    public void setPullingBow(boolean pullingBow) {
        this.pullingBow = pullingBow;
    }

    public int getLastCps() {
        return lastCps;
    }

    public void setLastCps(int lastCps) {
        this.lastCps = lastCps;
    }

    public double getHps() {
        return hps;
    }

    public void setHps(double hps) {
        this.hps = hps;
    }

    public double getHealth() {
        return health;
    }

    public void setHealth(double health) {
        this.health = health;
    }

    public double getBlocksPerSecond() {
        return blocksPerSecond;
    }

    public void setBlocksPerSecond(double blocksPerSecond) {
        this.blocksPerSecond = blocksPerSecond;
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
