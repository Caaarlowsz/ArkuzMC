package com.github.caaarlowsz.arkuzmc.kitpvp.kit;

import Eventos.Habilidade;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;

public final class ArkuzVikingKit extends ArkuzKit implements Listener {

	public ArkuzVikingKit() {
		super("Viking");
	}

	@EventHandler(priority = EventPriority.NORMAL)
	private void onEntityDamageByEntity(EntityDamageByEntityEvent event) {
		if (event.getEntity() instanceof Player && event.getDamager() instanceof Player) {
			Player damager = (Player) event.getDamager();
			if (Habilidade.getAbility(damager).equals(this.getName())
					&& damager.getItemInHand().getType() == Material.STONE_AXE)
				event.setDamage(event.getDamage() * 1.66D);
		}
	}
}