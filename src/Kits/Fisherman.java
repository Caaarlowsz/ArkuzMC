package Kits;

import org.bukkit.event.EventHandler;
import org.bukkit.block.Block;
import org.bukkit.entity.Entity;
import Essencial.KitAPI;
import org.bukkit.event.player.PlayerFishEvent;
import Main.Main;
import org.bukkit.event.Listener;

public class Fisherman implements Listener
{
    public Fisherman(final Main main) {
    }
    
    @EventHandler
    public void onPlayerFish(final PlayerFishEvent event) {
        final Entity caught = event.getCaught();
        final Block block = event.getHook().getLocation().getBlock();
        if (caught != null && caught != block && KitAPI.Fisherman.contains(event.getPlayer().getName())) {
            caught.teleport(event.getPlayer().getLocation());
        }
    }
}
