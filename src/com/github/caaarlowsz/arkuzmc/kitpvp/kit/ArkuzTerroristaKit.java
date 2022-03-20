package com.github.caaarlowsz.arkuzmc.kitpvp.kit;

import org.bukkit.Bukkit;
import org.bukkit.Effect;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.EntityDamageEvent.DamageCause;
import org.bukkit.event.player.PlayerInteractEvent;

import com.github.caaarlowsz.arkuzmc.kitpvp.ArkuzKitPvP;

import Essencial.Cooldown;
import Essencial.KitUtil;
import Eventos.Habilidade;

public final class ArkuzTerroristaKit extends ArkuzKit implements Listener {

	public ArkuzTerroristaKit() {
		super("Terrorista");
	}

	@EventHandler(priority = EventPriority.NORMAL)
	private void onPlayerInteract(PlayerInteractEvent event) {
		Player player = event.getPlayer();
		if (Habilidade.getAbility(player).equals(this.getName())
				&& player.getItemInHand().getType() == Material.MAGMA_CREAM
				&& event.getAction().name().contains("RIGHT")) {
			if (!Cooldown.add(player)) {
				Cooldown.add(player, 25);

				player.setVelocity(player.getLocation().getDirection().setY(6));
				player.getWorld().playEffect(player.getLocation(), Effect.MOBSPAWNER_FLAMES, 15F);
				player.getWorld().playSound(player.getLocation(), Sound.ENDERMAN_TELEPORT, 1F, 1F);
				Bukkit.getScheduler().runTaskLater(ArkuzKitPvP.getInstance(),
						() -> player.sendMessage(ArkuzKitPvP.prefix + " §4➼ §7Seu CoolDown Acabou"), 500L);
			} else
				KitUtil.MensagemCooldown(player);
		}
	}

	@EventHandler
	private void onEntityDamage(EntityDamageEvent event) {
		if (event.getEntity() instanceof Player) {
			Player player = (Player) event.getEntity();
			if (Habilidade.getAbility(player).equals(this.getName())) {
				if (event.getCause() == DamageCause.FALL && event.getDamage() >= 8D) {
					event.setDamage(8D);
					for (Entity entities : player.getNearbyEntities(5D, 5D, 5D)) {
						if (entities instanceof Player) {
							Player players = (Player) entities;
							if (!players.isSneaking())
								player.getWorld().createExplosion(player.getLocation(), 3F);
						}
					}
				}
				if (event.getCause() == DamageCause.BLOCK_EXPLOSION)
					event.setCancelled(true);
			}
		}
	}
}