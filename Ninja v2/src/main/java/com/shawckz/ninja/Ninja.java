package com.shawckz.ninja;

import com.shawckz.ninja.check.Check;
import com.shawckz.ninja.event.CheckFailedEvent;
import com.shawckz.ninja.player.NinjaPlayer;
import org.bukkit.Bukkit;

/**
 * Created by 360 on 3/27/2015.
 */
public class Ninja {

    public static float getMaxVL(){
        return 50F;
    }

    public static void callCheckFailedEvent(NinjaPlayer player,Check check){
        Bukkit.getPluginManager().callEvent(new CheckFailedEvent(player,check));
    }

}
