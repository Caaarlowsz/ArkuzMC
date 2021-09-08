package Kits;

import java.util.Iterator;
import org.bukkit.entity.Entity;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.EventHandler;
import org.bukkit.plugin.Plugin;
import org.bukkit.entity.Player;
import Main.Main;
import org.bukkit.Bukkit;
import org.bukkit.Sound;
import org.bukkit.Effect;
import Essencial.KitUtil;
import Essencial.Cooldown;
import org.bukkit.Material;
import org.bukkit.event.block.Action;
import Eventos.Habilidade;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.Listener;

public class Terrorista implements Listener
{
    @EventHandler
    public void aoterrorista(final PlayerInteractEvent e) {
        final Player p = e.getPlayer();
        if (Habilidade.getAbility(p).equalsIgnoreCase("Terrorista") && (e.getAction() == Action.RIGHT_CLICK_AIR || e.getAction() == Action.RIGHT_CLICK_BLOCK) && p.getItemInHand().getType() == Material.MAGMA_CREAM) {
            if (Cooldown.add(p)) {
                KitUtil.MensagemCooldown(p);
                return;
            }
            p.setVelocity(p.getLocation().getDirection().setY(6));
            p.getWorld().playEffect(p.getLocation(), Effect.MOBSPAWNER_FLAMES, 15);
            p.getWorld().playSound(p.getLocation(), Sound.ENDERMAN_TELEPORT, 1.0f, 1.0f);
            Cooldown.add(p, 25);
            Bukkit.getScheduler().scheduleSyncDelayedTask((Plugin)Main.getInstance(), (Runnable)new Runnable() {
                @Override
                public void run() {
                    p.sendMessage(String.valueOf(Main.prefix) + " §4\u27bc §7Seu CoolDown Acabou");
                }
            }, 500L);
        }
    }
    
    @EventHandler
    public void naodanoexplosion(final EntityDamageEvent e) {
        if (e.getEntity() instanceof Player) {
            final Player p = (Player)e.getEntity();
            if (e.getCause() != EntityDamageEvent.DamageCause.BLOCK_EXPLOSION) {
                return;
            }
            if (Habilidade.getAbility(p).equalsIgnoreCase("Terrorista")) {
                e.setCancelled(true);
            }
        }
    }
    
    @EventHandler
    public void stomper(final EntityDamageEvent event) {
        if (!(event.getEntity() instanceof Player)) {
            return;
        }
        if (event.getCause() != EntityDamageEvent.DamageCause.FALL) {
            return;
        }
        final Player p = (Player)event.getEntity();
        if (Habilidade.getAbility(p).equalsIgnoreCase("Terrorista") && event.getDamage() >= 8.0) {
            event.setDamage(8.0);
            for (final Entity e : p.getNearbyEntities(5.0, 5.0, 5.0)) {
                if (e instanceof Player && !((Player)e).isSneaking()) {
                    p.getWorld().createExplosion(p.getLocation(), 3.0f);
                }
            }
        }
    }
}
