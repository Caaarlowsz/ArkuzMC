package com.github.caaarlowsz.arkuzmc.kitpvp.kit;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.util.Vector;

import com.github.caaarlowsz.arkuzmc.kitpvp.ArkuzKitPvP;

import Essencial.KitAPI;

public final class ArkuzForceFieldKit extends ArkuzKit implements Listener {

	private static final List<Player> cooldownList = new ArrayList<Player>();

	public ArkuzForceFieldKit() {
		super("ForceField");
	}

	@EventHandler(priority = EventPriority.NORMAL)
	private void onPlayerInteract(PlayerInteractEvent event) {
		Player player = event.getPlayer();
		if (KitAPI.ForceField.contains(player.getName()) && player.getItemInHand().getType() == Material.NETHER_FENCE) {
			event.setCancelled(true);

			if (!ArkuzForceFieldKit.cooldownList.contains(player)) {
				cooldownList.add(player);

				player.getWorld().playSound(player.getLocation(), Sound.MAGMACUBE_WALK2, 0.5F, 0.5F);
				Bukkit.getScheduler().runTask(ArkuzKitPvP.getInstance(), () -> {
					KitAPI.ForceField1.add(player.getName());
					player.sendMessage(ArkuzKitPvP.prefix + " §4➼ §7Você Virou Um Hask Zaronimous");
				});
				Bukkit.getScheduler().runTaskLater(ArkuzKitPvP.getInstance(),
						() -> KitAPI.ForceField1.remove(player.getName()), 50L);
				Bukkit.getScheduler().runTaskLater(ArkuzKitPvP.getInstance(), () -> {
					cooldownList.remove(player);
					player.sendMessage(ArkuzKitPvP.prefix + " §4➼ §7Seu CoolDown Acabou");
					player.getWorld().playSound(player.getLocation(), Sound.BURP, 0.5F, 0.5F);
				}, 500L);
			} else
				player.sendMessage(String.valueOf(ArkuzKitPvP.prefix) + " §4➼ §7Aguarde o CoolDown Acabar");
		}
	}

	@EventHandler(priority = EventPriority.NORMAL)
	private void onPlayerMove(PlayerMoveEvent event) {
		Player player = event.getPlayer();
		if (KitAPI.ForceField.contains(player.getName()) && KitAPI.ForceField1.contains(player.getName())) {
			for (Entity entities : player.getNearbyEntities(8D, 8D, 8D)) {
				if (entities instanceof Player) {
					Player players = (Player) entities;
					players.damage(3D, player);
					players.setVelocity(new Vector(0.1D, 0D, 0.1D));
				}
			}
		}
	}
}