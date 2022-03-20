package com.github.caaarlowsz.arkuzmc.kitpvp.kit;

import com.github.caaarlowsz.arkuzmc.kitpvp.ArkuzKitPvP;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.EntityDamageEvent.DamageCause;

import Essencial.KitAPI;

public final class ArkuzStomperKit extends ArkuzKit implements Listener {

	public ArkuzStomperKit() {
		super("Stomper");
	}

	@EventHandler(priority = EventPriority.NORMAL)
	private void onEntityDamage(EntityDamageEvent event) {
		if (event.getEntity() instanceof Player && event.getCause() == DamageCause.FALL) {
			Player player = (Player) event.getEntity();
			if (KitAPI.Stomper.contains(player.getName())) {
				for (Entity entities : player.getNearbyEntities(10D, 8D, 10D)) {
					if (entities instanceof Player) {
						Player players = (Player) entities;
						if (event.getDamage() <= 10D)
							event.setCancelled(true);
						if (players.isSneaking())
							players.damage(2D, player);
						else {
							players.damage(event.getDamage(), player);
							players.sendMessage(
									ArkuzKitPvP.prefix + " §4➼ §7Você Foi Stompado Por: " + player.getName());
						}
					}
				}

				event.setDamage(10D);
			}
		}
	}
}