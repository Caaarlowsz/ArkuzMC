package com.github.caaarlowsz.arkuzmc.kitpvp.kit;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;

import com.github.caaarlowsz.arkuzmc.kitpvp.ArkuzKitPvP;

import Essencial.Cooldown;
import Essencial.KitUtil;
import Eventos.Habilidade;

public final class ArkuzThorKit extends ArkuzKit implements Listener {

	public ArkuzThorKit() {
		super("Thor");
	}

	@EventHandler(priority = EventPriority.NORMAL)
	private void onPlayerInteract(PlayerInteractEvent event) {
		Player player = event.getPlayer();
		if (Habilidade.getAbility(player).equals(this.getName())
				&& player.getItemInHand().getType() == Material.GOLD_AXE
				&& event.getAction().name().contains("RIGHT")) {
			event.setCancelled(true);

			if (!Cooldown.add(player)) {
				Cooldown.add(player, 5);

				player.getWorld().strikeLightning(player.getTargetBlock(null, 30).getLocation());
				Bukkit.getScheduler().runTaskLater(ArkuzKitPvP.getInstance(),
						() -> player
								.sendMessage(String.valueOf(ArkuzKitPvP.prefix) + " §4➼ §7Seu CoolDown Foi Terminado"),
						100L);
			} else
				KitUtil.MensagemCooldown(player);
		}
	}
}