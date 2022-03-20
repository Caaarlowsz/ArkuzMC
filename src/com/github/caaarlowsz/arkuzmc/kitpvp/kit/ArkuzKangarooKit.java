package com.github.caaarlowsz.arkuzmc.kitpvp.kit;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.EntityDamageEvent.DamageCause;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.util.Vector;

import com.github.caaarlowsz.arkuzmc.kitpvp.ArkuzKitPvP;

import Essencial.KitAPI;

public final class ArkuzKangarooKit extends ArkuzKit implements Listener {

	private static final List<UUID> cooldownList = new ArrayList<>(), jumpList = new ArrayList<>();

	public ArkuzKangarooKit() {
		super("Kangaroo");
	}

	@EventHandler(priority = EventPriority.NORMAL)
	private void onEntityDamageByEntity(EntityDamageByEntityEvent event) {
		if (event.getEntity() instanceof Player && event.getDamager() instanceof Player) {
			Player player = (Player) event.getEntity();
			if (player.getInventory().contains(Material.FIREWORK)) {
				cooldownList.add(player.getUniqueId());
				Bukkit.getScheduler().runTaskLater(ArkuzKitPvP.getInstance(),
						() -> cooldownList.remove(player.getUniqueId()), 100L);
			}
		}
	}

	@EventHandler(priority = EventPriority.NORMAL)
	private void onPlayerInteract(PlayerInteractEvent event) {
		Player player = event.getPlayer();
		if (KitAPI.Kangaroo.contains(player.getName()) && event.hasItem() && event.getMaterial() == Material.FIREWORK) {
			Vector velocity = player.getEyeLocation().getDirection();
			event.setCancelled(true);

			if (!cooldownList.contains(player.getUniqueId())) {
				cooldownList.add(player.getUniqueId());
				if (!jumpList.contains(player.getUniqueId())) {
					jumpList.add(player.getUniqueId());
					if (player.isSneaking()) {
						player.setFallDistance(-1F);
						player.setVelocity(velocity.multiply(1.5F).setY(0.5D));
					} else {
						player.setFallDistance(-1F);
						player.setVelocity(velocity.multiply(0.5F).setY(1D));
					}
				}
			} else
				player.sendMessage(
						String.valueOf(ArkuzKitPvP.prefix) + " §4➼ §7Você Não Pode Utilizar Seu Kit Em Combate");
		}
	}

	@EventHandler(priority = EventPriority.NORMAL)
	private void onPlayerMove(PlayerMoveEvent event) {
		Player player = event.getPlayer();
		if (jumpList.contains(player.getUniqueId())) {
			Block block = event.getTo().getBlock();
			if (block.getType() != Material.AIR || block.getRelative(BlockFace.DOWN).getType() != Material.AIR)
				jumpList.remove(player.getUniqueId());
		}
	}

	@EventHandler(priority = EventPriority.NORMAL)
	private void onEntityDamage(EntityDamageEvent event) {
		if (event.getEntity() instanceof Player && event.getCause() == DamageCause.FALL && event.getDamage() >= 7D) {
			Player player = (Player) event.getEntity();
			if (player.getInventory().contains(Material.FIREWORK))
				event.setDamage(7D);
		}
	}
}