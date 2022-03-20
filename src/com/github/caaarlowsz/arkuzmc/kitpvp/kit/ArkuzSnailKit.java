package com.github.caaarlowsz.arkuzmc.kitpvp.kit;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import Essencial.KitAPI;

public final class ArkuzSnailKit extends ArkuzKit implements Listener {

	public ArkuzSnailKit() {
		super("Snail");
	}

	@EventHandler(priority = EventPriority.NORMAL)
	private void onEntityDamageByEntity(EntityDamageByEntityEvent event) {
		if (event.getEntity() instanceof Player && event.getDamager() instanceof Player) {
			Player player = (Player) event.getEntity(), damager = (Player) event.getDamager();
			if (KitAPI.Snail.contains(damager.getName()) && Math.random() > 0.4 && Math.random() > 0.1)
				player.addPotionEffect(new PotionEffect(PotionEffectType.SLOW, 120, 0));
		}
	}
}