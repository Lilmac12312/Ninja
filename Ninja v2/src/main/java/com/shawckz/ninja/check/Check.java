package com.shawckz.ninja.check;

import com.shawckz.ninja.Ninja;
import com.shawckz.ninja.player.NinjaPlayer;
import org.bukkit.plugin.Plugin;

/**
 * Created by 360 on 3/26/2015.
 */
public abstract class Check {

    private String name;

    public Check(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public abstract float getRaiseLevel();

    public abstract void registerListeners(Plugin plugin);

    public void handleCheckFail(NinjaPlayer player) {
        Ninja.callCheckFailedEvent(player, this);
    }

}
