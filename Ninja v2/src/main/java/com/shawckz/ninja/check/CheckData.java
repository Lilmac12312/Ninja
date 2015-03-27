package com.shawckz.ninja.check;

import org.bukkit.Location;

/**
 * Created by 360 on 3/27/2015.
 */
public class CheckData {

    private int ping;
    private Location playerLocation;

    public CheckData() {
        this.ping = 0;
        this.playerLocation = null;
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
}
