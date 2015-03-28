package com.shawckz.ninja.check;

import com.shawckz.ninja.Ninja;
import com.shawckz.ninja.player.NinjaPlayer;
import org.bukkit.Bukkit;
import org.bukkit.event.Listener;
import org.bukkit.plugin.Plugin;

/**
 * Created by 360 on 3/26/2015.
 */
public abstract class Check implements Listener{

    private String name;
    private float maxVL;
    private boolean enabled;

    public Check(String name){
        this.name = name;
        this.maxVL = 7F;
        this.enabled = true;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public float getMaxVL() {
        return maxVL;
    }

    public String getName() {
        return name;
    }

    public abstract float getRaiseLevel();

    public void registerListeners(Plugin plugin){
        Bukkit.getServer().getPluginManager().registerEvents(this,plugin);
    }

    public boolean handleCheckFail(NinjaPlayer player) {
        player.addVL(this,getRaiseLevel());
        return Ninja.callCheckFailedEvent(player, this, player.getCheckData());
    }

}
