package com.shawckz.ninja.check;

import com.shawckz.ninja.Ninja;
import com.shawckz.ninja.player.NinjaPlayer;
import org.bukkit.plugin.Plugin;

/**
 * Created by 360 on 3/26/2015.
 */
public abstract class Check {

    private String name;
    private float maxVL;

    public Check(String name){
        this.name = name;
        this.maxVL = 7F;
    }

    public float getMaxVL() {
        return maxVL;
    }

    public String getName() {
        return name;
    }

    public abstract float getRaiseLevel();

    public abstract void registerListeners(Plugin plugin);

    public boolean handleCheckFail(NinjaPlayer player) {
        return Ninja.callCheckFailedEvent(player, this, player.getCheckData());
    }

}
