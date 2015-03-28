package com.shawckz.ninja;

import com.shawckz.ninja.check.Check;
import com.shawckz.ninja.check.CheckCallbackResult;
import com.shawckz.ninja.check.CheckData;
import com.shawckz.ninja.check.CheckFail;
import com.shawckz.ninja.player.NinjaPlayer;
import com.shawckz.ninja.type.BanMethod;

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
        check.handleCheckFail(player);

        HashSet<CheckCallbackResult> result = new CheckFail(player,check,data).call().checkFailed();

        //TODO: Do something with the results

        return result.contains(CheckCallbackResult.CANCELLED);

    }



}
