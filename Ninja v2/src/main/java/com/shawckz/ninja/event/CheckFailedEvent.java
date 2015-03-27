package com.shawckz.ninja.event;

import com.shawckz.ninja.check.Check;
import com.shawckz.ninja.player.NinjaPlayer;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

/**
 * Created by 360 on 3/27/2015.
 */
public class CheckFailedEvent extends Event {

    public static final HandlerList handlers = new HandlerList();

    private NinjaPlayer player;
    private Check check;

    public CheckFailedEvent(NinjaPlayer player, Check check) {
        this.player = player;
        this.check = check;
    }

    public NinjaPlayer getPlayer() {
        return player;
    }

    public Check getCheck() {
        return check;
    }

    @Override
    public HandlerList getHandlers() {
        return handlers;
    }
}
