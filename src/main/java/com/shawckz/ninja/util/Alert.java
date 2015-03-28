package com.shawckz.ninja.util;

import com.shawckz.ninja.Ninja;
import com.shawckz.ninja.check.Check;
import com.shawckz.ninja.player.NinjaPlayer;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

/**
 * Created by 360 on 3/27/2015.
 */
public class Alert {

    public static void send(NinjaPlayer p, Check check){
        for(Player pl : Bukkit.getOnlinePlayers()){
            if(pl.hasPermission(NinjaPerm.ALERTS_VIEW.getPerm()) && p.isAlertsEnabled()){
                pl.sendMessage(Ninja.NINJA_PREFIX+"§f"+p.getBukkitPlayer().getName()+" §7("+p.getVL()+"xVL) §7failed §c"+check.getName()+" §7("+p.getCheckVL(check)+"VL)");
            }
        }
    }

}
