package com.github.caaarlowsz.arkuzmc.kitpvp.kit;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerFishEvent;

import Essencial.KitAPI;

public final class ArkuzFishermanKit extends ArkuzKit implements Listener {

	public ArkuzFishermanKit() {
		super("Fisherman");
	}

	@EventHandler(priority = EventPriority.NORMAL)
	private void onPlayerFish(PlayerFishEvent event) {
		if (event.getCaught() instanceof Player) {
			Player player = event.getPlayer(), caught = (Player) event.getCaught();
			if (KitAPI.Fisherman.contains(player.getName()))
				caught.teleport(player.getLocation());
		}
	}
}
