package com.github.caaarlowsz.arkuzmc.kitpvp.kit;

import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.player.PlayerToggleSneakEvent;

import com.github.caaarlowsz.arkuzmc.kitpvp.ArkuzKitPvP;

import Essencial.KitAPI;

public final class ArkuzNinjaKit extends ArkuzKit implements Listener {

	private static final Map<UUID, UUID> targetMap = new HashMap<>();
	private static final Map<UUID, Long> cooldownMap = new HashMap<>();

	public ArkuzNinjaKit() {
		super("Ninja");
	}

	@EventHandler(priority = EventPriority.NORMAL)
	private void onEntityDamageByEntity(EntityDamageByEntityEvent event) {
		if (event.getEntity() instanceof Player && event.getDamager() instanceof Player) {
			Player player = (Player) event.getEntity(), damager = (Player) event.getDamager();
			if (KitAPI.Ninja.contains(damager.getName())) {
				targetMap.put(damager.getUniqueId(), player.getUniqueId());
				Bukkit.getScheduler().runTaskLater(ArkuzKitPvP.getInstance(),
						() -> targetMap.remove(damager.getUniqueId()), 140L);
			}
		}
	}

	@EventHandler(priority = EventPriority.NORMAL)
	private void onPlayerToggleSneak(PlayerToggleSneakEvent event) {
		Player player = event.getPlayer();
		if (event.isSneaking() && KitAPI.Ninja.contains(player.getName())
				&& targetMap.containsKey(player.getUniqueId())) {
			Player target = Bukkit.getPlayer(targetMap.get(player.getUniqueId()));
			if (target != null && !target.isDead()) {
				if (!cooldownMap.containsKey(player.getUniqueId())) {
					if (player.getLocation().distance(target.getLocation()) < 100D) {
						cooldownMap.put(player.getUniqueId(), System.currentTimeMillis() + 10000L);
						player.teleport(target.getLocation());
						player.sendMessage(ArkuzKitPvP.prefix + " §4➼ §7Você Foi Teleportado");
					} else
						player.sendMessage(
								ArkuzKitPvP.prefix + " §4➼ §7O Utimo Player Que Você Hitou Está Longe Demais!");
				} else {
					long l = cooldownMap.get(player.getUniqueId()) - System.currentTimeMillis();
					String seconds = new DecimalFormat("##").format(l / 1000);
					player.sendMessage(
							ArkuzKitPvP.prefix + " §4➼ §7Aguarde §c" + seconds + "§7 Para o Cooldown Acabar");
				}
			}
		}
	}
}