package com.shawckz.ninja.check.checks.combat;

import com.shawckz.ninja.check.Check;
import com.shawckz.ninja.check.CheckData;
import com.shawckz.ninja.player.NinjaPlayer;
import com.shawckz.ninja.player.PlayerManager;
import org.bukkit.Material;
import org.bukkit.entity.Arrow;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.entity.EntityShootBowEvent;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerItemHeldEvent;

/**
 * Created by 360 on 3/27/2015.
 */
public class FastBowCheck extends Check implements Listener {

    public FastBowCheck(){
        super("FastBow");
    }

    @Override
    public float getRaiseLevel() {
        return 5F;
    }

    @EventHandler
    public void onInteractBow(PlayerInteractEvent e){
        if(e.getAction() == Action.RIGHT_CLICK_AIR || e.getAction() == Action.RIGHT_CLICK_BLOCK){
            if(e.getPlayer().getItemInHand().getType() == Material.BOW){

                NinjaPlayer ninja = PlayerManager.get(e.getPlayer().getName());

                ninja.getCheckData().setBowPullTime(System.currentTimeMillis());
                ninja.getCheckData().setBowSlot(e.getPlayer().getInventory().getHeldItemSlot());
                ninja.getCheckData().setPullingBow(true);
            }
        }
    }

    @EventHandler
    public void onCancelBow(PlayerItemHeldEvent e){
        NinjaPlayer ninja = PlayerManager.get(e.getPlayer().getName());
        if(ninja.getCheckData().getBowSlot()== e.getPreviousSlot()){
            if(ninja.getCheckData().isPullingBow()){
                ninja.getCheckData().setBowArrow(null);
                ninja.getCheckData().setBowPullShot(0);
                ninja.getCheckData().setBowPullTime(0);
                ninja.getCheckData().setBowSlot(0);
                ninja.getCheckData().setPullingBow(false);
            }
        }
    }

    @EventHandler
    public void onDrop(PlayerDropItemEvent e){
        NinjaPlayer ninja = PlayerManager.get(e.getPlayer().getName());
        if(e.getItemDrop().getItemStack().getType() == Material.BOW){
            if(ninja.getCheckData().isPullingBow()){
                ninja.getCheckData().setBowArrow(null);
                ninja.getCheckData().setBowPullShot(0);
                ninja.getCheckData().setBowPullTime(0);
                ninja.getCheckData().setBowSlot(0);
                ninja.getCheckData().setPullingBow(false);
            }
        }
    }

    @EventHandler
    public void onShoot(EntityShootBowEvent e){
        if(e.getEntity() instanceof Player){
            if(e.getProjectile() instanceof Arrow){
                Player p = (Player) e.getEntity();
                NinjaPlayer ninja = PlayerManager.get(p.getName());
                ninja.getCheckData().setBowArrow((Arrow)e.getProjectile());
                ninja.getCheckData().setBowPullShot(System.currentTimeMillis());

                //TODO: Check
                if(check(ninja)){
                    e.setCancelled(true);
                }

                ninja.getCheckData().setPullingBow(false);
            }
        }
    }

    public boolean check(NinjaPlayer player){

        int ping = player.getCheckData().getPing();

        CheckData data = player.getCheckData();

        long bowPull = data.getBowPullTime();
        long bowShot = data.getBowPullShot();
        Arrow arrow = data.getBowArrow();

        long pullTime = bowShot-bowPull;
        double length = arrow.getVelocity().length();

        if(ping < 250){
            if(pullTime < 180){
                if(length > 1.5){
                    return handleCheckFail(player);
                }
            }
        }
        else {
            if (pullTime < 111) {
                if (length > 1.1) {
                    return handleCheckFail(player);
                }
            }

        }
        return false;
    }

}
