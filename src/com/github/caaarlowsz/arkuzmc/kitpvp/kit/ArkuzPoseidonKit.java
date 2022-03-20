package com.github.caaarlowsz.arkuzmc.kitpvp.kit;

import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import Eventos.Habilidade;

public final class ArkuzPoseidonKit extends ArkuzKit implements Listener {

	public ArkuzPoseidonKit() {
		super("Poseidon");
	}

	@EventHandler(priority = EventPriority.NORMAL)
	private void onPlayerMove(PlayerMoveEvent event) {
		Player player = event.getPlayer();
		Block block = event.getFrom().getBlock();
		if (Habilidade.getAbility(player).equals(this.getName()) && block.getType().name().contains("WATER")) {
			player.addPotionEffect(new PotionEffect(PotionEffectType.INCREASE_DAMAGE, 200, 1), true);
			player.addPotionEffect(new PotionEffect(PotionEffectType.INCREASE_DAMAGE, 200, 1), true);
			player.addPotionEffect(new PotionEffect(PotionEffectType.INCREASE_DAMAGE, 160, 0), true);
		}
	}
}