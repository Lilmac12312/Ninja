package com.shawckz.ninja.check;

import com.shawckz.ninja.Core;
import org.bukkit.event.Listener;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 360 on 3/26/2015.
 */
public class CheckManager implements Listener {

    private List<Check> checks;
    private static CheckManager instance;

    protected CheckManager(){
        checks = new ArrayList<>();
        //TODO: Add checks to list
    }

    public List<Check> getChecks() {
        return checks;
    }

    public static CheckManager get() {
        if (instance == null) {
            synchronized (CheckManager.class) {
                if (instance == null) {
                    instance = new CheckManager();
                }
            }
        }
        return instance;
    }

    public Check getCheck(String name){
        for(Check c : checks){
            if(c.getName().equalsIgnoreCase(name)){
                return c;
            }
        }
        return null;
    }

    public void registerListeners(Core core){
        for(Check c : checks){
            c.registerListeners(core);
        }
    }

}
