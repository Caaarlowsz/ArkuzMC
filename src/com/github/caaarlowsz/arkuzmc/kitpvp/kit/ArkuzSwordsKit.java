package com.github.caaarlowsz.arkuzmc.kitpvp.kit;

import java.util.Random;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;

import Eventos.Habilidade;

public final class ArkuzSwordsKit extends ArkuzKit implements Listener {

	public ArkuzSwordsKit() {
		super("Swords");
	}

	@EventHandler(priority = EventPriority.NORMAL)
	private void onPlayerInteract(PlayerInteractEvent event) {
		Player player = event.getPlayer();
		if (Habilidade.getAbility(player).equals(this.getName())
				&& player.getItemInHand().getType().name().contains("_SWORD")) {
			switch (new Random().nextInt(5)) {
			case 0:
				player.getItemInHand().setType(Material.GOLD_SWORD);
			case 1:
				player.getItemInHand().setType(Material.WOOD_SWORD);
			case 2:
				player.getItemInHand().setType(Material.STONE_SWORD);
			case 3:
				player.getItemInHand().setType(Material.IRON_SWORD);
			case 4:
				player.getItemInHand().setType(Material.STONE_SWORD);
			}
			player.updateInventory();
		}
	}
}