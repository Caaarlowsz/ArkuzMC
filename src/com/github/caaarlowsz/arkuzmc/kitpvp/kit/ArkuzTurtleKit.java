package com.github.caaarlowsz.arkuzmc.kitpvp.kit;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent;

import com.github.caaarlowsz.arkuzmc.kitpvp.ArkuzKitPvP;

import Eventos.Habilidade;

public final class ArkuzTurtleKit extends ArkuzKit implements Listener {

	public ArkuzTurtleKit() {
		super("Turtle");
	}

	@EventHandler(priority = EventPriority.NORMAL)
	private void onEntityDamage(EntityDamageEvent event) {
		if (event.getEntity() instanceof Player) {
			Player player = (Player) event.getEntity();
			if (Habilidade.getAbility(player).equals(this.getName()) && player.isSneaking())
				event.setDamage(1D);
		}
	}

	@EventHandler(priority = EventPriority.NORMAL)
	private void onEntityDamageByEntity(EntityDamageByEntityEvent event) {
		if (event.getEntity() instanceof Player && event.getDamager() instanceof Player) {
			Player damager = (Player) event.getDamager();
			if (Habilidade.getAbility(damager).equals(this.getName()) && damager.isSneaking()) {
				event.setCancelled(true);
				damager.sendMessage(ArkuzKitPvP.prefix + " §4➼ §7Não Se Pode Bater No Shift");
			}
		}
	}
}
