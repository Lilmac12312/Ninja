package com.shawckz.ninja.check.checks.movement;

import com.shawckz.ninja.check.Check;
import com.shawckz.ninja.player.NinjaPlayer;
import com.shawckz.ninja.player.PlayerManager;
import com.shawckz.ninja.util.Lag;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;

/**
 * Created by 360 on 3/27/2015.
 */
public class FlyCheck extends Check implements Listener {

    public FlyCheck(){
        super("Fly");
    }

    @Override
    public float getRaiseLevel() {
        return 5F;
    }

    @Override
    public float getMaxVL() {
        return 15F;
    }

    @EventHandler
    public void onMove(PlayerMoveEvent e){
        Player p = e.getPlayer();
        NinjaPlayer np = PlayerManager.get(p.getName());

        if(isEnabled()){

            if(p.getAllowFlight() == true) return;
            if(p.isOnGround()) return;

            double vl = 0;

            final double xDistance = e.getTo().getX() - e.getFrom().getX();
            final double yDistance = e.getTo().getY() - e.getFrom().getY();
            final double zDistance = e.getTo().getZ() - e.getFrom().getZ();

            // How far did the player move horizontally?
            final double hDistance = Math.sqrt(xDistance * xDistance + zDistance * zDistance);


            final double lagAdd = Lag.getTPS();
            final double lagR = (20 - Lag.getTPS())*Lag.getTPS();
            vl+= lagAdd;
            vl-= lagR;

            vl+= hDistance * hDistance;
            if(yDistance >= 1.0 || yDistance <= -1.0){
                return;
            }

            double trueVL = vl;
            trueVL-=lagAdd;
            trueVL+=lagR;

            double xVL = trueVL * vl;

            if(xVL >= 4.6){
                if(handleCheckFail(np)){
                    e.setTo(e.getFrom());
                }
            }

        }

    }

}
