package com.shawckz.ninja.check.checks.combat;

import com.shawckz.ninja.check.Check;
import com.shawckz.ninja.player.PlayerManager;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.plugin.Plugin;

/**
 * Created by 360 on 3/27/2015.
 */
public class SelfHitCheck extends Check implements Listener {

    public SelfHitCheck(){
        super("SelfHitCheck");
    }

    @Override
    public float getRaiseLevel() {
        return 20F;
    }

    @Override
    public void registerListeners(Plugin plugin) {
        Bukkit.getServer().getPluginManager().registerEvents(this,plugin);
    }

    @Override
    public float getMaxVL() {
        return 20;
    }

    @EventHandler
    public void onDamage(EntityDamageByEntityEvent e){
        if(e.getDamager() instanceof Player && e.getEntity() instanceof Player){

            Player d = (Player) e.getDamager();
            Player p = (Player) e.getEntity();

            if(d.equals(p)){

                if(handleCheckFail(PlayerManager.get(d.getName()))){
                    e.setCancelled(true);
                }

            }

        }
    }
}
