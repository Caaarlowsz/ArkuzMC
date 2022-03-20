package com.github.caaarlowsz.arkuzmc.kitpvp.kit;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;
import org.bukkit.event.player.PlayerInteractEntityEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import com.github.caaarlowsz.arkuzmc.kitpvp.ArkuzKitPvP;

import Essencial.KitAPI;

public final class ArkuzGladiatorKit extends ArkuzKit implements Listener {

	private static final Map<Block, UUID> blockMap = new HashMap<>();
	private static final Map<UUID, UUID> fightingMap = new HashMap<>();
	private static final Map<UUID, Location> locationMap = new HashMap<>();

	public ArkuzGladiatorKit() {
		super("Gladiator");
	}

	@EventHandler(priority = EventPriority.NORMAL)
	private void onPlayerInteractEntity(PlayerInteractEntityEvent event) {
		Player player = event.getPlayer();
		if (KitAPI.Gladiator.contains(player.getName()) && player.getItemInHand().getType() == Material.IRON_FENCE
				&& event.getRightClicked() instanceof Player) {
			Player righted = (Player) event.getRightClicked();
			if (!fightingMap.containsKey(player.getUniqueId()) && !fightingMap.containsKey(righted.getUniqueId())) {
				Location location = player.getLocation(), center = location.clone().add(0D, 80D, 0D),
						pos1 = center.clone().add(8D, 2D, 8D), pos2 = center.clone().add(-8D, 2D, -8D);

				List<Location> locs = new ArrayList<Location>();
				for (int x = -10; x <= 10; x++) {
					for (int z = -10; z <= 10; z++) {
						for (int y = -1; y <= 10; y++) {
							Block block = center.clone().add(x, y, z).getBlock();
							if (!block.isEmpty()) {
								player.sendMessage(ArkuzKitPvP.prefix + " §4➼ §7Você Não Pode Usar o seu Kit Aqui");
								break;
							}

							if (x == -10 || x == 10 || y == -1 || y == 10 || z == -10 || z == 10)
								locs.add(center.clone().add(x, y, z));
						}
					}
				}

				for (Location loc : locs) {
					Block block = loc.getBlock();
					block.setType(Material.GLASS);
					blockMap.put(block, player.getUniqueId());
				}

				fightingMap.put(player.getUniqueId(), righted.getUniqueId());
				locationMap.put(player.getUniqueId(), player.getLocation());
				player.addPotionEffect(new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE, 110, 5), true);
				player.teleport(pos1);

				fightingMap.put(righted.getUniqueId(), player.getUniqueId());
				locationMap.put(righted.getUniqueId(), righted.getLocation());
				righted.addPotionEffect(new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE, 110, 5), true);
				righted.teleport(pos2);

				Bukkit.getScheduler().runTaskLater(ArkuzKitPvP.getInstance(), () -> {
					if (fightingMap.containsKey(player.getUniqueId())
							&& fightingMap.containsKey(righted.getUniqueId())) {
						fightingMap.remove(player.getUniqueId());
						player.teleport(locationMap.remove(player.getUniqueId()));

						fightingMap.remove(righted.getUniqueId());
						fightingMap.remove(locationMap.remove(righted.getUniqueId()));

						for (Block block : blockMap.keySet()) {
							if (blockMap.get(block).equals(player.getUniqueId())
									|| blockMap.get(block).equals(righted.getUniqueId())
											&& block.getType() == Material.GLASS) {
								block.setType(Material.AIR);
								blockMap.remove(block);
							}
						}
					}
				}, 6000L);
			} else
				player.sendMessage(String.valueOf(ArkuzKitPvP.prefix) + " §4➼ §7Você Ja Está Em Um Gladiator");
		}
	}

	@EventHandler(priority = EventPriority.NORMAL)
	private void onPlayerDeath(PlayerDeathEvent event) {
		Player player = event.getEntity();
		if (fightingMap.containsKey(player.getUniqueId())) {
			Player enemy = Bukkit.getPlayer(fightingMap.remove(player.getUniqueId()));

			for (Block block : blockMap.keySet()) {
				if (blockMap.get(block).equals(player.getUniqueId())
						|| blockMap.get(block).equals(enemy.getUniqueId()) && block.getType() == Material.GLASS) {
					block.setType(Material.AIR);
					blockMap.remove(block);
				}
			}

			locationMap.remove(player.getUniqueId());
			player.sendMessage(ArkuzKitPvP.prefix + " §4➼ §7Você Perdeu o Gladiator");

			fightingMap.remove(enemy.getUniqueId());
			enemy.teleport(locationMap.remove(player.getUniqueId()));
			enemy.addPotionEffect(new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE, 100, 10), true);
			enemy.sendMessage(ArkuzKitPvP.prefix + " §4➼ §7Você Ganhou o Gladiator");
		}
	}

	@EventHandler(priority = EventPriority.NORMAL)
	private void onPlayerQuit(PlayerQuitEvent event) {
		Player player = event.getPlayer();
		if (fightingMap.containsKey(player.getUniqueId())) {
			Player enemy = Bukkit.getPlayer(fightingMap.remove(player.getUniqueId()));

			for (Block block : blockMap.keySet()) {
				if (blockMap.get(block).equals(player.getUniqueId())
						|| blockMap.get(block).equals(enemy.getUniqueId()) && block.getType() == Material.GLASS) {
					block.setType(Material.AIR);
					blockMap.remove(block);
				}
			}

			locationMap.remove(player.getUniqueId());
			fightingMap.remove(enemy.getUniqueId());
			enemy.teleport(locationMap.remove(player.getUniqueId()));
			enemy.addPotionEffect(new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE, 100, 10), true);
			enemy.sendMessage(
					ArkuzKitPvP.prefix + " §4➼ §7O Player §c" + player.getDisplayName() + " §7Deslogou No Gladiator");
		}
	}

	@EventHandler(priority = EventPriority.NORMAL)
	private void onBlockBreak(BlockBreakEvent event) {
		if (event.getPlayer().getGameMode() != GameMode.CREATIVE)
			event.setCancelled(true);
	}

	@EventHandler(priority = EventPriority.NORMAL)
	private void onPlayerCommandPreprocess(PlayerCommandPreprocessEvent event) {
		Player player = event.getPlayer();
		if (fightingMap.containsKey(player.getUniqueId())) {
			event.setCancelled(true);
			player.sendMessage(ArkuzKitPvP.prefix + " §4➼ §7Não se Pode Usar Comandos No Gladiator");
		}
	}
}