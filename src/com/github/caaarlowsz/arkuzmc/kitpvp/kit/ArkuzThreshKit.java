package com.github.caaarlowsz.arkuzmc.kitpvp.kit;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.entity.Snowball;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.util.Vector;

import com.github.caaarlowsz.arkuzmc.kitpvp.ArkuzKitPvP;

import Essencial.KitAPI;

public final class ArkuzThreshKit extends ArkuzKit implements Listener {

	private static final Map<UUID, Long> cooldownMap = new HashMap<>();

	public ArkuzThreshKit() {
		super("Thresh");
	}

	@EventHandler(priority = EventPriority.NORMAL)
	private void onPlayerInteract(PlayerInteractEvent event) {
		Player player = event.getPlayer();
		if (KitAPI.Thresh.contains(player.getName()) && player.getItemInHand().getType() == Material.LEVER
				&& event.getAction().name().contains("RIGHT")) {
			event.setCancelled(true);

			if (!cooldownMap.containsKey(player.getName())) {
				cooldownMap.put(player.getUniqueId(), System.currentTimeMillis() + 15000L);

				Snowball snowball = (Snowball) player.launchProjectile(Snowball.class);
				Vector velocity = player.getLocation().getDirection();
				snowball.setVelocity(new Vector(velocity.getX() * 3.5D, velocity.getY() * 4D, velocity.getZ() * 3.5D));
				player.updateInventory();

				player.playSound(player.getLocation(), Sound.GLASS, 1F, 1F);
				player.sendMessage(ArkuzKitPvP.prefix + " §4➼ §7Você Usou Seu Thresh!");
			} else
				player.sendMessage(ArkuzKitPvP.prefix + " §4➼ §7Aguarde o CoolDown Acabar");
		}
	}

	@EventHandler(priority = EventPriority.NORMAL)
	private void onEntityDamageByEntity(EntityDamageByEntityEvent event) {
		if (event.getEntity() instanceof Player && event.getDamager() instanceof Snowball) {
			Player player = (Player) event.getEntity();
			Snowball snowball = (Snowball) event.getDamager();

			if (snowball.getShooter() instanceof Player) {
				Player shooter = (Player) snowball.getShooter();
				if (KitAPI.Thresh.contains(shooter.getName())) {
					Location loc = shooter.getLocation();

					player.teleport(loc);
					player.addPotionEffect(new PotionEffect(PotionEffectType.POISON, 100, 1));
					player.addPotionEffect(new PotionEffect(PotionEffectType.SLOW, 100, 1));
					player.sendMessage(ArkuzKitPvP.prefix + " §4➼ §7Você Foi Pego Por Um Thresh");
				}
			}
		}
	}
}
