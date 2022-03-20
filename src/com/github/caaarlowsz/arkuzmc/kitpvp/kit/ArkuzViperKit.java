package com.github.caaarlowsz.arkuzmc.kitpvp.kit;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import com.github.caaarlowsz.arkuzmc.kitpvp.ArkuzKitPvP;

import Essencial.KitAPI;

public final class ArkuzViperKit extends ArkuzKit implements Listener {

	public ArkuzViperKit() {
		super("Viper");
	}

	@EventHandler(priority = EventPriority.NORMAL)
	private void onEntityDamageByEntity(EntityDamageByEntityEvent event) {
		if (event.getEntity() instanceof Player && event.getDamager() instanceof Player) {
			Player player = (Player) event.getEntity(), damager = (Player) event.getDamager();
			if (KitAPI.Viper.contains(damager.getName()) && Math.random() > 0.4 && Math.random() > 0.1) {
				player.addPotionEffect(new PotionEffect(PotionEffectType.POISON, 80, 0), true);
				damager.sendMessage(ArkuzKitPvP.prefix + " §6➼ §7Você Infectou o Player §e " + player.getDisplayName());
			}
		}
	}
}