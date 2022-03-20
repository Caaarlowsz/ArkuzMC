package com.github.caaarlowsz.arkuzmc.kitpvp.kit;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.event.player.PlayerToggleSneakEvent;

import com.github.caaarlowsz.arkuzmc.kitpvp.ArkuzKitPvP;

import Essencial.Cooldown;
import Essencial.KitUtil;
import Eventos.Habilidade;

public final class ArkuzAjninKit extends ArkuzKit implements Listener {

	private static final Map<UUID, UUID> targetMap = new HashMap<>();

	public ArkuzAjninKit() {
		super("Ajnin");
	}

	@EventHandler(priority = EventPriority.NORMAL)
	private void onEntityDamageByEntity(EntityDamageByEntityEvent event) {
		if (event.getEntity() instanceof Player && event.getDamager() instanceof Player) {
			Player player = (Player) event.getEntity(), damager = (Player) event.getDamager();
			if (Habilidade.getAbility(damager).equals(this.getName()))
				targetMap.put(damager.getUniqueId(), player.getUniqueId());
		}
	}

	@EventHandler(priority = EventPriority.NORMAL)
	private void onPlayerToggleSneak(PlayerToggleSneakEvent event) {
		Player player = event.getPlayer();
		if (event.isSneaking() && Habilidade.getAbility(player).equals(this.getName())
				&& targetMap.containsKey(player.getUniqueId())) {
			if (!Cooldown.add(player)) {
				Player target = Bukkit.getPlayer(targetMap.get(player.getUniqueId()));
				if (target != null && !target.isDead() && player.getLocation().distance(target.getLocation()) < 200D) {
					Cooldown.add(player, 3);
					target.teleport(player.getLocation());
					player.sendMessage(ArkuzKitPvP.prefix + " §4➼ §7O Player Foi Teleportado Até Você");
					Bukkit.getScheduler().runTaskLater(ArkuzKitPvP.getInstance(),
							() -> player.sendMessage(ArkuzKitPvP.prefix + " §4➼ §7Seu Cooldown Acabou"), 140L);
				} else
					player.sendMessage(ArkuzKitPvP.prefix + " §4➼ §7O Ultimo Player Hitado Está Loge Demais");
			} else
				KitUtil.MensagemCooldown(player);
		}
	}

	@EventHandler(priority = EventPriority.NORMAL)
	private void onPlayerDeath(PlayerDeathEvent event) {
		Player player = event.getEntity();
		if (targetMap.containsKey(player.getUniqueId()))
			targetMap.remove(targetMap.remove(player.getUniqueId()));
	}

	@EventHandler(priority = EventPriority.NORMAL)
	private void onPlayerQuit(PlayerQuitEvent event) {
		Player player = event.getPlayer();
		if (targetMap.containsKey(player.getUniqueId()))
			targetMap.remove(targetMap.remove(player.getUniqueId()));
	}
}