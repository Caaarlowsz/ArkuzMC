package Kits;

import Essencial.KitAPI;
import com.github.caaarlowsz.arkuzmc.kitpvp.ArkuzPvP;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.util.Vector;

import java.util.ArrayList;
import java.util.List;

public class TheForceField implements Listener {
	public static List<Player> cooldownm;

	static {
		TheForceField.cooldownm = new ArrayList<Player>();
	}

	@EventHandler
	public void stomperApple(final PlayerInteractEvent event) {
		final Player p = event.getPlayer();
		if (event.getPlayer().getItemInHand().getType() == Material.NETHER_FENCE
				&& KitAPI.ForceField.contains(event.getPlayer().getName())) {
			if (event.getAction() == Action.LEFT_CLICK_AIR || event.getAction() == Action.LEFT_CLICK_BLOCK
					|| event.getAction() == Action.RIGHT_CLICK_BLOCK || event.getAction() == Action.RIGHT_CLICK_AIR) {
				event.setCancelled(true);
			}
			if (TheForceField.cooldownm.contains(p)) {
				p.sendMessage(String.valueOf(ArkuzPvP.prefix) + " §4➼ §7Aguarde o CoolDown Acabar");
				return;
			}
			final Location loc = p.getLocation();
			p.getWorld().playSound(loc, Sound.MAGMACUBE_WALK2, 0.5f, 0.5f);
			TheForceField.cooldownm.add(p);
			Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(ArkuzPvP.getInstance(), (Runnable) new Runnable() {
				@Override
				public void run() {
					KitAPI.ForceField1.add(p.getName());
					p.sendMessage(String.valueOf(ArkuzPvP.prefix) + " §4➼ §7Você Virou Um Hask Zaronimous");
				}
			}, 0L);
			Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(ArkuzPvP.getInstance(), (Runnable) new Runnable() {
				@Override
				public void run() {
					KitAPI.ForceField1.remove(p.getName());
				}
			}, 50L);
			Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(ArkuzPvP.getInstance(), (Runnable) new Runnable() {
				@Override
				public void run() {
					TheForceField.cooldownm.remove(p);
					p.sendMessage(String.valueOf(ArkuzPvP.prefix) + " §4➼ §7Seu CoolDown Acabou");
					p.getWorld().playSound(p.getLocation(), Sound.BURP, 0.5f, 0.5f);
				}
			}, 500L);
		}
	}

	@EventHandler
	public void fraqueza(final PlayerMoveEvent event) {
		final Player p = event.getPlayer();
		if (KitAPI.ForceField1.contains(p.getName())) {
			for (final Entity pertos : p.getNearbyEntities(8.0, 8.0, 8.0)) {
				if (pertos instanceof Player) {
					if (KitAPI.ForceField.contains(p.getName())) {
						((Player) pertos).damage(3.0);
					}
					pertos.setVelocity(new Vector(0.1, 0.0, 0.1));
					Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(ArkuzPvP.getInstance(), (Runnable) new Runnable() {
						@Override
						public void run() {
						}
					}, 10L);
				}
			}
		}
	}
}
