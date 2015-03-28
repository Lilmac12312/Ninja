package com.shawckz.ninja.player;

import com.shawckz.ninja.check.Check;
import com.shawckz.ninja.check.CheckData;
import com.shawckz.ninja.check.CheckManager;
import org.bukkit.entity.Player;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by 360 on 3/26/2015.
 */
public class NinjaPlayer {

    private Player bukkitPlayer;
    private CheckData checkData;
    private boolean alertsEnabled;
    private float vl;
    private Map<Check,Float> checkVl = new HashMap<>();

    public NinjaPlayer(Player bukkitPlayer) {
        this.bukkitPlayer = bukkitPlayer;
        this.checkData = new CheckData(bukkitPlayer);

        vl = 0F;

        for(Check c : CheckManager.get().getChecks()){
            checkVl.put(c,0F);
        }

        this.alertsEnabled = false;

    }

    public void reset(){
        this.checkData = new CheckData(bukkitPlayer);

        vl = 0F;

        for(Check c : CheckManager.get().getChecks()){
            checkVl.put(c,0F);
        }

        this.alertsEnabled = false;

    }

    public boolean isAlertsEnabled() {
        return alertsEnabled;
    }

    public void setAlertsEnabled(boolean alertsEnabled) {
        this.alertsEnabled = alertsEnabled;
    }

    public float getCheckVL(Check check){
        return checkVl.get(check);
    }

    public void setCheckVL(Check check, float vl){
        checkVl.put(check,vl);
    }

    public void addVL(Check check, float vl){
        setCheckVL(check,getCheckVL(check)+vl);

        addVL(vl);
    }

    private void addVL(float vl){
        this.vl+=vl;
    }

    public float getVL(){
        return vl;
    }

    public void setVL(float vl){
        this.vl = vl;
    }

    public CheckData getCheckData() {
        return checkData;
    }

    public Player getBukkitPlayer() {
        return bukkitPlayer;
    }

}
