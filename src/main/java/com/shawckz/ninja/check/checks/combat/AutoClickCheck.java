package com.shawckz.ninja.check.checks.combat;

import com.shawckz.ninja.check.Check;
import com.shawckz.ninja.player.NinjaPlayer;
import com.shawckz.ninja.player.PlayerManager;
import com.shawckz.ninja.util.Lag;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;

/**
 * Created by 360 on 3/27/2015.
 */
public class AutoClickCheck extends Check implements Listener {

    public AutoClickCheck(){
        super("AutoClick");
    }

    @Override
    public float getRaiseLevel() {
        return 5F;
    }

    @EventHandler
    public void onInteract(PlayerInteractEvent e){
        if(e.getAction().equals(Action.LEFT_CLICK_AIR) || e.getAction().equals(Action.LEFT_CLICK_BLOCK)){
            NinjaPlayer ninja = PlayerManager.get(e.getPlayer().getName());
            ninja.getCheckData().setCps(ninja.getCheckData().getCps() + 1);

            int vl = 0;

            final double lagAdd = Lag.getTPS();
            final double lagR = (20 - Lag.getTPS())*Lag.getTPS();
            vl+= lagAdd;
            vl-= lagR;

            vl+=ninja.getCheckData().getCps() * ninja.getCheckData().getCps();

            double trueVL = vl;
            trueVL-=lagAdd;
            trueVL+=lagR;

            double xVL = trueVL * vl;

            if(xVL >= 130000 && ninja.getCheckData().getCps() == ninja.getCheckData().getLastCps()){//to check for consistence, as the autoclicker does not (usually?) change speed
                if(handleCheckFail(ninja)){
                    e.setCancelled(true);
                }
            }



        }
    }

}
