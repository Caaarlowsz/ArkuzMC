package com.github.caaarlowsz.arkuzmc.kitpvp.kit;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.inventory.ItemStack;

import Eventos.Habilidade;

public final class ArkuzResouperKit extends ArkuzKit implements Listener {

	public ArkuzResouperKit() {
		super("Resouper");
	}

	@EventHandler(priority = EventPriority.NORMAL)
	private void onPlayerDeath(PlayerDeathEvent event) {
		if (event.getEntity().getKiller() instanceof Player) {
			Player killer = event.getEntity().getKiller();
			if (Habilidade.getAbility(killer).equals(this.getName())) {
				for (int i = 0; i < killer.getInventory().getSize(); i++)
					killer.getInventory().addItem(new ItemStack[] { new ItemStack(Material.MUSHROOM_SOUP) });
				killer.updateInventory();
			}
		}
	}
}