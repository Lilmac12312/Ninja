package com.shawckz.ninja;

import com.shawckz.ninja.check.Check;
import com.shawckz.ninja.check.CheckCallbackResult;
import com.shawckz.ninja.check.CheckData;
import com.shawckz.ninja.check.CheckFail;
import com.shawckz.ninja.player.NinjaPlayer;
import com.shawckz.ninja.player.PlayerManager;
import com.shawckz.ninja.type.BanMethod;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.HashSet;

/**
 * Created by 360 on 3/27/2015.
 */
public class Ninja {

    public static float getMaxVL(){
        return 50F;
    }

    public static final String NINJA_PREFIX = "§7[§cNinja§7]: ";

    public static BanMethod banMethod = BanMethod.CONSOLE_COMMAND;

    public static boolean callCheckFailedEvent(NinjaPlayer player,Check check,CheckData data){
        HashSet<CheckCallbackResult> result = new CheckFail(player,check,data).call().checkFailed();

        return result.contains(CheckCallbackResult.CANCELLED);
    }

    public static void tick(){
        new BukkitRunnable(){

            @Override
            public void run() {

                for(Player pl : Bukkit.getOnlinePlayers()){
                    NinjaPlayer p = PlayerManager.get(pl.getName());

                    p.getCheckData().setBlocksPerSecond(0);
                    p.getCheckData().setHps(0);
                    p.getCheckData().setLastCps(p.getCheckData().getCps());
                    p.getCheckData().setCps(0);
                }

            }

        }.runTaskTimer(Core.getPlugin(),20L,20L);
    }



}
