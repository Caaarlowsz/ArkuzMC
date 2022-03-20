package com.github.caaarlowsz.arkuzmc.kitpvp.kit;

import org.bukkit.Effect;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.entity.Snowball;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import Eventos.Habilidade;

public final class ArkuzSwitcherKit extends ArkuzKit implements Listener {

	public ArkuzSwitcherKit() {
		super("Switcher");
	}

	@EventHandler(priority = EventPriority.NORMAL)
	private void onEntityDamageByEntity(EntityDamageByEntityEvent event) {
		if (event.getEntity() instanceof Player && event.getDamager() instanceof Snowball) {
			Player player = (Player) event.getEntity();
			Snowball snowball = (Snowball) event.getDamager();
			if (snowball.getShooter() instanceof Player) {
				Player shooter = (Player) snowball.getShooter();
				if (Habilidade.getAbility(shooter).equals(this.getName())) {
					Location location = shooter.getLocation();
					shooter.teleport(player.getLocation());
					player.teleport(location);
					shooter.getWorld().playEffect(location, Effect.ENDER_SIGNAL, 10);
					shooter.getWorld().playEffect(location, Effect.EXTINGUISH, 10);
					shooter.getWorld().playSound(location, Sound.ENDERMAN_TELEPORT, 1F, 1.2F);
				}
			}
		}
	}

	@EventHandler(priority = EventPriority.NORMAL)
	private void onPlayerDeath(PlayerDeathEvent event) {
		Player killer = event.getEntity().getKiller();
		if (event.getEntity().getKiller() instanceof Player && Habilidade.getAbility(killer).equals(this.getName())) {
			ItemStack item = new ItemStack(Material.SNOW_BALL);
			ItemMeta itemm = item.getItemMeta();
			itemm.setDisplayName("§7Kit §cSwitcher");
			item.setItemMeta(itemm);
			killer.getInventory().addItem(item);
			killer.updateInventory();
		}
	}
}