package Kits;

import org.bukkit.event.EventPriority;
import org.bukkit.event.EventHandler;
import java.util.Iterator;
import org.bukkit.entity.Entity;
import Essencial.KitAPI;
import org.bukkit.entity.Player;
import org.bukkit.event.entity.EntityDamageEvent;
import Main.Main;
import org.bukkit.event.Listener;

public class Stomper implements Listener
{
    public Stomper(final Main main) {
    }
    
    @EventHandler(priority = EventPriority.HIGH)
    public void onPlayerStomp(final EntityDamageEvent e) {
        if (!(e.getEntity() instanceof Player)) {
            return;
        }
        final Player p = (Player)e.getEntity();
        if (e.getCause() != EntityDamageEvent.DamageCause.FALL) {
            return;
        }
        if (KitAPI.Stomper.contains(p.getName())) {
            for (final Entity ent : p.getNearbyEntities(10.0, 8.0, 10.0)) {
                if (ent instanceof Player) {
                    final Player plr = (Player)ent;
                    if (e.getDamage() <= 10.0) {
                        e.setCancelled(true);
                        return;
                    }
                    if (plr.isSneaking()) {
                        plr.damage(20.0, (Entity)p);
                    }
                    else {
                        plr.damage(e.getDamage(), (Entity)p);
                        plr.sendMessage(String.valueOf(Main.prefix) + " §4\u27bc §7Voc\u00ea Foi Stompado Por: " + p.getName());
                    }
                }
            }
            e.setDamage(10.0);
        }
    }
}
