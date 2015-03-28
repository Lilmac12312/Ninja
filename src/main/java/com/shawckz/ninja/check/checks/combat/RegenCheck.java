package com.shawckz.ninja.check.checks.combat;

import com.shawckz.ninja.check.Check;
import com.shawckz.ninja.player.NinjaPlayer;
import com.shawckz.ninja.player.PlayerManager;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityRegainHealthEvent;
import org.bukkit.potion.PotionEffectType;

/**
 * Created by 360 on 3/27/2015.
 */
public class RegenCheck extends Check implements Listener {

    public RegenCheck(){
        super("Regen");
    }

    @Override
    public float getRaiseLevel() {
        return 10F;
    }

    @EventHandler
    public void onHealthChange(EntityRegainHealthEvent e){
        if(e.getEntity() instanceof Player){
            if(e.getRegainReason() == EntityRegainHealthEvent.RegainReason.SATIATED){
                Player p = (Player) e.getEntity();
                NinjaPlayer ninja = PlayerManager.get(p.getName());
                double regain = e.getAmount();

                ninja.getCheckData().setHealth(p.getHealth());
                ninja.getCheckData().setHps(ninja.getCheckData().getHps()+regain);

                int ping = ninja.getCheckData().getPing();

                if(!p.hasPotionEffect(PotionEffectType.REGENERATION)){
                    if(ping < 200){
                        if(p.getFoodLevel() >= 18){
                            if(ninja.getCheckData().getHps() > 1.2){
                                if(handleCheckFail(ninja)){
                                    e.setAmount(0.0);
                                }
                            }
                        }
                        else{
                            if(ninja.getCheckData().getHps() >= 1.0){
                                if(handleCheckFail(ninja)){
                                    e.setAmount(0.0);
                                }
                            }
                        }
                    }
                    else{
                        if(p.getFoodLevel() >= 18){
                            if(ninja.getCheckData().getHps() > 2.4){
                                if(handleCheckFail(ninja)){
                                    e.setAmount(0.0);
                                }
                            }
                        }
                        else{
                            if(ninja.getCheckData().getHps() >= 2.0){
                                if(handleCheckFail(ninja)){
                                    e.setAmount(0.0);
                                }
                            }
                        }
                    }
                }



            }
        }
    }


}
