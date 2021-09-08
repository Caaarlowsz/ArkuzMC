package Kits;

import org.bukkit.event.EventHandler;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import Main.Main;
import org.bukkit.Bukkit;
import java.util.HashSet;
import Essencial.KitUtil;
import Essencial.Cooldown;
import org.bukkit.Material;
import org.bukkit.event.block.Action;
import Eventos.Habilidade;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.Listener;

public class Thor implements Listener
{
    @EventHandler
    public void ThorKit(final PlayerInteractEvent e) {
        final Player p = e.getPlayer();
        if (Habilidade.getAbility(p).equalsIgnoreCase("Thor") && (e.getAction() == Action.RIGHT_CLICK_AIR || e.getAction() == Action.RIGHT_CLICK_BLOCK) && p.getItemInHand().getType() == Material.GOLD_AXE) {
            if (Cooldown.add(p)) {
                KitUtil.MensagemCooldown(p);
                return;
            }
            Cooldown.add(p, 5);
            final Location loc = p.getTargetBlock((HashSet)null, 30).getLocation();
            p.getWorld().strikeLightning(loc);
            e.setCancelled(true);
            Bukkit.getScheduler().scheduleSyncDelayedTask(Main.plugin, (Runnable)new Runnable() {
                @Override
                public void run() {
                    p.sendMessage(String.valueOf(Main.prefix) + " §4\u27bc §7Seu CoolDown Foi Terminado");
                }
            }, 100L);
        }
    }
}
