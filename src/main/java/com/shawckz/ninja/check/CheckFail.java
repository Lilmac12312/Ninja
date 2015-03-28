package com.shawckz.ninja.check;

import com.shawckz.ninja.player.NinjaPlayer;
import com.shawckz.ninja.util.Alert;

import java.util.HashSet;

/**
 * Created by 360 on 3/27/2015.
 */
public class CheckFail {

    private NinjaPlayer p;
    private Check check;
    private CheckData checkData;

    public CheckFail(NinjaPlayer p, Check check, CheckData checkData) {
        this.p = p;
        this.check = check;
        this.checkData = checkData;
    }

    public CheckData getCheckData() {
        return checkData;
    }

    public NinjaPlayer getPlayer() {
        return p;
    }

    public Check getCheck() {
        return check;
    }

    public CheckCallback call(){
        final CheckCallback checkCallback = new CheckCallback() {
            @Override
            public HashSet<CheckCallbackResult> checkFailed() {

                HashSet<CheckCallbackResult> results = new HashSet<>();

               // if(!p.getBukkitPlayer().hasPermission("ninja.checks."+check.getName().toLowerCase()+".bypass")){

                    p.addVL(check,check.getRaiseLevel());

                    if(p.getCheckVL(check) >= check.getMaxVL()){
                        Alert.send(p,check);
                        results.add(CheckCallbackResult.ALERTED);
                        results.add(CheckCallbackResult.CANCELLED);
                    }

             //   }
             //   else{//They can bypass this: ignore it
             //       results.add(CheckCallbackResult.IGNORED);
             //       return results;
             //   }

                if(results.isEmpty()){
                    results.add(CheckCallbackResult.IGNORED);
                }

                return results;
            }
        };

        return checkCallback;
    }

}
