package com.github.caaarlowsz.arkuzmc.kitpvp.kit;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import com.github.caaarlowsz.arkuzmc.kitpvp.ArkuzKitPvP;
import org.bukkit.Bukkit;
import org.bukkit.Effect;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Item;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.Plugin;
import org.bukkit.util.Vector;

import Essencial.Cooldown;
import Essencial.KitUtil;
import Eventos.Habilidade;

public final class ArkuzC4Kit extends ArkuzKit implements Listener {

	public static final Map<UUID, Item> bombMap = new HashMap<>();

	public ArkuzC4Kit() {
		super("C4");
	}

	@EventHandler(priority = EventPriority.NORMAL)
	private void onPlayerInteract(PlayerInteractEvent event) {
		Player player = event.getPlayer();
		if (Habilidade.getAbility(player).equals(this.getName()) && event.hasItem()) {
			if (event.getMaterial() == Material.SLIME_BALL && event.getAction().name().contains("RIGHT")) {
				if (!Cooldown.add(player)) {
					Item item = player.getWorld().dropItem(player.getLocation().add(0, 2, 0), new ItemStack(Material.TNT));
					item.setVelocity(player.getEyeLocation().getDirection());
					bombMap.put(player.getUniqueId(), item);

					event.getItem().setType(Material.STONE_BUTTON);
					ItemMeta meta = event.getItem().getItemMeta();
					meta.setDisplayName(ArkuzKitPvP.prefix + " §4➼ §7Kit §cC4");
					event.getItem().setItemMeta(meta);
					player.updateInventory();

					player.sendMessage(ArkuzKitPvP.prefix + " §4➼ §7Bomba Implantada");
				} else
					KitUtil.MensagemCooldown(player);
			} else if (event.getMaterial() == Material.STONE_BUTTON) {
				if (event.getAction().name().contains("LEFT")) {
					if (!Cooldown.add(player)) {
						event.getItem().setType(Material.SLIME_BALL);
						ItemMeta meta = event.getItem().getItemMeta();
						meta.setDisplayName(ArkuzKitPvP.prefix + " §4➼ §7Kit §cC4");
						event.getItem().setItemMeta(meta);
						player.updateInventory();

						if (bombMap.containsKey(player.getUniqueId()))
							bombMap.remove(player.getUniqueId()).remove();
						player.sendMessage(ArkuzKitPvP.prefix + " §4➼ §7Bomba Desarmada");
					} else
						KitUtil.MensagemCooldown(player);
				} else if (event.getAction().name().contains("RIGHT")) {
					Cooldown.add(player, 20);

					event.getItem().setType(Material.SLIME_BALL);
					ItemMeta meta = event.getItem().getItemMeta();
					meta.setDisplayName("§7Kit §cC4");
					event.getItem().setItemMeta(meta);
					player.updateInventory();

					if (bombMap.containsKey(player.getUniqueId())) {
						Item item = bombMap.remove(player.getUniqueId());
						player.getWorld().createExplosion(item.getLocation(), 2.5F);
						player.getWorld().playEffect(item.getLocation(), Effect.EXPLOSION_HUGE, 10);
						item.remove();

						player.sendMessage(ArkuzKitPvP.prefix + " §4➼ §7Bomba Explodida");
					}

					Bukkit.getScheduler().runTaskLater(ArkuzKitPvP.getInstance(), () -> player.sendMessage(ArkuzKitPvP.prefix + " §4➼ §7Seu CoolDown Acabou"), 400L);
				}
			}

		}
	}

	@EventHandler(priority = EventPriority.NORMAL)
	private void onPlayerDeath(PlayerDeathEvent event) {
		Player player = event.getEntity();
		if (bombMap.containsKey(player.getUniqueId()))
			bombMap.remove(player.getName()).remove();
	}
}