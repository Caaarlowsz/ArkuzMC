package com.github.caaarlowsz.arkuzmc.kitpvp.kit;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.craftbukkit.v1_7_R4.entity.CraftPlayer;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.EntityDamageEvent.DamageCause;
import org.bukkit.event.entity.PlayerLeashEntityEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerItemHeldEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.util.Vector;

import Essencial.KitAPI;
import Kits.Cordinha;

public final class ArkuzGrapplerKit extends ArkuzKit implements Listener {

	private static final Map<UUID, Cordinha> hookingMap = new HashMap<>();

	public ArkuzGrapplerKit() {
		super("Grappler");
	}

	@EventHandler(priority = EventPriority.NORMAL)
	private void onPlayerInteract(PlayerInteractEvent event) {
		Player player = event.getPlayer();
		if (KitAPI.Grappler.contains(player.getName()) && player.getItemInHand().getType().equals(Material.LEASH)) {
			event.setCancelled(true);

			if (event.getAction().name().contains("LEFT")) {
				if (hookingMap.containsKey(player.getUniqueId()))
					hookingMap.get(player.getUniqueId()).remove();

				Cordinha grapplingHook = new Cordinha(player.getWorld(), ((CraftPlayer) player).getHandle());
				Vector direction = player.getLocation().getDirection();

				grapplingHook.spawn(player.getEyeLocation().add(direction.getX(), direction.getY(), direction.getZ()));
				grapplingHook.move(direction.getX() * 5D, direction.getY() * 5D, direction.getZ() * 5D);
				hookingMap.put(player.getUniqueId(), grapplingHook);
			} else if (event.getAction().name().contains("RIGHT")) {
				if (hookingMap.containsKey(player.getUniqueId()) && hookingMap.get(player.getUniqueId()).isHooked()) {
					Location hookLoc = hookingMap.get(player.getUniqueId()).getBukkitEntity().getLocation(),
							loc = player.getLocation();
					double distance = hookLoc.distance(loc),
							x = (1.2D * distance) * (hookLoc.getX() - loc.getX()) / distance,
							y = (1.03D * distance) * (hookLoc.getY() - loc.getY()) / distance,
							z = (1.2D * distance) * (hookLoc.getZ() - loc.getZ()) / distance;
					player.playSound(player.getLocation(), Sound.STEP_GRAVEL, 2F, 2F);
					player.setVelocity(player.getVelocity().setX(x).setY(y).setZ(z));
				}
			}
		}
	}

	@EventHandler(priority = EventPriority.NORMAL)
	private void onPlayerLeashEntity(PlayerLeashEntityEvent event) {
		Player player = event.getPlayer();
		if (KitAPI.Grappler.contains(player.getName()) && player.getItemInHand().getType().equals(Material.LEASH)) {
			event.setCancelled(true);
			player.updateInventory();

			if (hookingMap.containsKey(player.getUniqueId()) && hookingMap.get(player.getUniqueId()).isHooked()) {
				Location hookLoc = hookingMap.get(player.getUniqueId()).getBukkitEntity().getLocation(),
						loc = player.getLocation();
				double distance = hookLoc.distance(loc),
						x = (1.07D * distance) * (hookLoc.getX() - loc.getX()) / distance,
						y = (1.03D * distance) * (hookLoc.getY() - loc.getY()) / distance,
						z = (1.07D * distance) * (hookLoc.getZ() - loc.getZ()) / distance;
				player.setVelocity(player.getVelocity().setX(x).setY(y).setZ(z));
			}
		}
	}

	@EventHandler(priority = EventPriority.NORMAL)
	private void onEntityDamage(EntityDamageEvent event) {
		if (event.getEntity() instanceof Player && event.getCause() == DamageCause.FALL) {
			Player player = (Player) event.getEntity();
			if (hookingMap.containsKey(player.getUniqueId()) && hookingMap.get(player.getUniqueId()).isHooked()
					&& event.getDamage() > 3D)
				event.setDamage(3D);
		}
	}

	@EventHandler(priority = EventPriority.NORMAL)
	private void onPlayerItemHeld(PlayerItemHeldEvent event) {
		Player player = event.getPlayer();
		if (hookingMap.containsKey(player.getUniqueId()))
			hookingMap.remove(player.getUniqueId()).remove();
	}

	@EventHandler(priority = EventPriority.NORMAL)
	private void onPlayerMove(PlayerMoveEvent event) {
		Player player = event.getPlayer();
		if (hookingMap.containsKey(player.getUniqueId()) && !player.getItemInHand().getType().equals(Material.LEASH))
			hookingMap.remove(player.getUniqueId()).remove();
	}
}