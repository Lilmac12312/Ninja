package com.shawckz.ninja.check.checks.movement;

import com.shawckz.ninja.check.Check;
import com.shawckz.ninja.player.NinjaPlayer;
import com.shawckz.ninja.player.PlayerManager;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.potion.PotionEffectType;

/**
 * Created by 360 on 3/27/2015.
 */
public class SpeedCheck extends Check implements Listener {

    public SpeedCheck(){
        super("Speed");
    }

    @Override
    public float getRaiseLevel() {
        return 5F;
    }

    @EventHandler
    public void onMove(PlayerMoveEvent e){
        Player pl = e.getPlayer();

        NinjaPlayer ninja = PlayerManager.get(pl.getName());

        double move = e.getTo().distance(e.getFrom());

        ninja.getCheckData().setBlocksPerSecond(ninja.getCheckData().getBlocksPerSecond() + move);

        if(isEnabled()){
            if(pl.getVehicle() == null) {

                if(pl.getWalkSpeed() == 1F) {

                    int ping = ninja.getCheckData().getPing();

                    if (!pl.isFlying() && !pl.getAllowFlight()) {
                        if (!pl.hasPotionEffect(PotionEffectType.SPEED)) {
                            //8.3 no pot
                            if (ping > 200) {
                                //high lat.
                                if (ninja.getCheckData().getBlocksPerSecond() > 10.3) {
                                    if(handleCheckFail(ninja)){
                                        e.setTo(e.getFrom());
                                    }
                                    return;
                                }
                            } else {
                                //normal lat.
                                if (ninja.getCheckData().getBlocksPerSecond() > 8.3) {
                                    if(handleCheckFail(ninja)){
                                        e.setTo(e.getFrom());
                                    }
                                    return;
                                }
                            }
                        } else {
                            //10 pot
                            if (ping > 200) {
                                //high lat.
                                if (ninja.getCheckData().getBlocksPerSecond() > 13) {//add 2
                                    if(handleCheckFail(ninja)){
                                        e.setTo(e.getFrom());
                                    }
                                    return;
                                }
                            } else {
                                //normal lat.
                                if (ninja.getCheckData().getBlocksPerSecond() > 11) {
                                    if(handleCheckFail(ninja)){
                                        e.setTo(e.getFrom());
                                    }
                                    return;
                                }
                            }
                        }
                    }
                }
            }
        }

    }

}
