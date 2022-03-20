package com.github.caaarlowsz.arkuzmc.kitpvp.kit;

import java.util.Random;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.EntityDamageEvent.DamageCause;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import Eventos.Habilidade;

public final class ArkuzMagmaKit extends ArkuzKit implements Listener {

	public ArkuzMagmaKit() {
		super("Magma");
	}

	@EventHandler(priority = EventPriority.NORMAL)
	private void onEntityDamageByEntity(EntityDamageByEntityEvent event) {
		if (event.getEntity() instanceof Player && event.getDamager() instanceof Player) {
			Player player = (Player) event.getEntity(), damager = (Player) event.getDamager();
			if (Habilidade.getAbility(damager).equals(this.getName())
					&& damager.getInventory().getItemInHand() != null) {
				player.addPotionEffect(new PotionEffect(PotionEffectType.INCREASE_DAMAGE, 10, 1));
				if (new Random().nextInt(100) <= 33)
					player.setFireTicks(50);
			}
		}
	}

	@EventHandler(priority = EventPriority.NORMAL)
	private void onEntityDamage(EntityDamageEvent event) {
		if (event.getEntity() instanceof Player) {
			Player player = (Player) event.getEntity();
			if (Habilidade.getAbility(player).equals(this.getName())
					&& (event.getCause() == DamageCause.LAVA || event.getCause().name().contains("FIRE")))
				event.setCancelled(true);
		}
	}

	@EventHandler(priority = EventPriority.NORMAL)
	private void onPlayerMove(PlayerMoveEvent event) {
		Player player = event.getPlayer();
		Material type = event.getTo().getBlock().getType();
		if (Habilidade.getAbility(player).equals(this.getName())
				&& (type == Material.STATIONARY_WATER || type == Material.WATER))
			player.damage(1D);
	}
}