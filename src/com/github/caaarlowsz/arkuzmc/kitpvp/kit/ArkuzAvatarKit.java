package com.github.caaarlowsz.arkuzmc.kitpvp.kit;

import org.bukkit.Bukkit;
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
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.metadata.FixedMetadataValue;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.util.BlockIterator;

import com.github.caaarlowsz.arkuzmc.kitpvp.ArkuzKitPvP;

import Essencial.Cooldown;
import Essencial.KitUtil;
import Eventos.Habilidade;

public final class ArkuzAvatarKit extends ArkuzKit implements Listener {

	public ArkuzAvatarKit() {
		super("Avatar");
	}

	@EventHandler(priority = EventPriority.NORMAL)
	private void onPlayerInteract(PlayerInteractEvent event) {
		Player player = event.getPlayer();
		if (Habilidade.getAbility(player).equals(this.getName()) && event.hasItem()) {
			if (event.getMaterial() == Material.BEACON) {
				event.setCancelled(true);
				if (event.getAction().name().contains("LEFT")) {
					event.getItem().setType(Material.WOOL);
					ItemMeta meta = event.getItem().getItemMeta();
					meta.setDisplayName("§7Kit §eAvatar§7(§f§lAR§7)");
					event.getItem().setItemMeta(meta);
					player.updateInventory();
				}
			} else if (event.getMaterial() == Material.WOOL) {
				event.setCancelled(true);
				if (event.getAction().name().contains("LEFT")) {
					event.getItem().setType(Material.LAPIS_BLOCK);
					ItemMeta meta = event.getItem().getItemMeta();
					meta.setDisplayName("§7Kit §eAvatar§7(§1§lAGUA§7)");
					event.getItem().setItemMeta(meta);
					player.updateInventory();
				} else if (event.getAction().name().contains("RIGHT")) {
					if (!Cooldown.add(player)) {
						Cooldown.add(player, 30);

						BlockIterator blocks = new BlockIterator(player.getEyeLocation(), 0D, 40);
						while (blocks.hasNext()) {
							Location target = blocks.next().getLocation();
							player.getWorld().playEffect(target, Effect.STEP_SOUND, Material.WOOL, 15);
							player.playSound(target, Sound.FIREWORK_BLAST, 3F, 3F);
						}

						Snowball snowball = player.launchProjectile(Snowball.class);
						snowball.setVelocity(player.getLocation().getDirection().normalize().multiply(10));
						snowball.setMetadata("Ar", new FixedMetadataValue(ArkuzKitPvP.getInstance(), true));

						Bukkit.getScheduler().runTaskLater(ArkuzKitPvP.getInstance(),
								() -> player.sendMessage(ArkuzKitPvP.prefix + " §4➼ §7Seu Cooldown Acabou"), 600L);
					} else
						KitUtil.MensagemCooldown(player);
				}
			} else if (event.getMaterial() == Material.LAPIS_BLOCK) {
				event.setCancelled(true);
				if (event.getAction().name().contains("LEFT")) {
					event.getItem().setType(Material.GRASS);
					ItemMeta meta = event.getItem().getItemMeta();
					meta.setDisplayName("§7Kit §eAvatar§7(§2§lTERRA§7)");
					event.getItem().setItemMeta(meta);
					player.updateInventory();
				} else if (event.getAction().name().contains("RIGHT")) {
					if (!Cooldown.add(player)) {
						Cooldown.add(player, 30);

						BlockIterator blocks = new BlockIterator(player.getEyeLocation(), 0D, 40);
						while (blocks.hasNext()) {
							Location target = blocks.next().getLocation();
							player.getWorld().playEffect(target, Effect.STEP_SOUND, Material.LAPIS_BLOCK, 15);
							player.playSound(target, Sound.FIREWORK_BLAST, 3F, 3F);
						}

						Snowball snowball = player.launchProjectile(Snowball.class);
						snowball.setVelocity(player.getLocation().getDirection().normalize().multiply(10));
						snowball.setMetadata("Água", new FixedMetadataValue(ArkuzKitPvP.getInstance(), true));

						Bukkit.getScheduler().runTaskLater(ArkuzKitPvP.getInstance(),
								() -> player.sendMessage(ArkuzKitPvP.prefix + " §4➼ §7Seu Cooldown Acabou"), 600L);
					} else
						KitUtil.MensagemCooldown(player);
				}
			} else if (event.getMaterial() == Material.GRASS) {
				event.setCancelled(true);
				if (event.getAction().name().contains("LEFT")) {
					event.getItem().setType(Material.REDSTONE_BLOCK);
					ItemMeta meta = event.getItem().getItemMeta();
					meta.setDisplayName("§7Kit §eAvatar§7(§4FOGO§7)");
					event.getItem().setItemMeta(meta);
					player.updateInventory();
				} else if (event.getAction().name().contains("RIGHT")) {
					if (!Cooldown.add(player)) {
						Cooldown.add(player, 30);

						BlockIterator blocks = new BlockIterator(player.getEyeLocation(), 0D, 40);
						while (blocks.hasNext()) {
							Location target = blocks.next().getLocation();
							player.getWorld().playEffect(target, Effect.STEP_SOUND, Material.GRASS, 15);
							player.playSound(target, Sound.FIREWORK_BLAST, 3F, 3F);
						}

						Snowball snowball = player.launchProjectile(Snowball.class);
						snowball.setVelocity(player.getLocation().getDirection().normalize().multiply(10));
						snowball.setMetadata("Terra", new FixedMetadataValue(ArkuzKitPvP.getInstance(), true));

						Bukkit.getScheduler().runTaskLater(ArkuzKitPvP.getInstance(),
								() -> player.sendMessage(ArkuzKitPvP.prefix + " §4➼ §7Seu Cooldown Acabou"), 600L);
					} else
						KitUtil.MensagemCooldown(player);
				}
			} else if (event.getMaterial() == Material.REDSTONE_BLOCK) {
				event.setCancelled(true);
				if (event.getAction().name().contains("LEFT")) {
					event.getItem().setType(Material.WOOL);
					ItemMeta meta = event.getItem().getItemMeta();
					meta.setDisplayName("§7Kit §eAvatar§7(§f§lAR§7)");
					event.getItem().setItemMeta(meta);
					player.updateInventory();
				} else if (event.getAction().name().contains("RIGHT")) {
					if (!Cooldown.add(player)) {
						Cooldown.add(player, 30);

						BlockIterator blocks = new BlockIterator(player.getEyeLocation(), 0D, 40);
						while (blocks.hasNext()) {
							Location target = blocks.next().getLocation();
							player.getWorld().playEffect(target, Effect.STEP_SOUND, Material.REDSTONE_BLOCK, 15);
							player.playSound(target, Sound.FIREWORK_BLAST, 3F, 3F);
						}

						Snowball snowball = player.launchProjectile(Snowball.class);
						snowball.setVelocity(player.getLocation().getDirection().normalize().multiply(10));
						snowball.setMetadata("Fogo", new FixedMetadataValue(ArkuzKitPvP.getInstance(), true));

						Bukkit.getScheduler().runTaskLater(ArkuzKitPvP.getInstance(),
								() -> player.sendMessage(ArkuzKitPvP.prefix + " §4➼ §7Seu Cooldown Acabou"), 600L);
					} else
						KitUtil.MensagemCooldown(player);
				}
			}
		}
	}

	@EventHandler(priority = EventPriority.NORMAL)
	private void onEntityDamageByEntity(EntityDamageByEntityEvent event) {
		if (event.getEntity() instanceof Player && event.getDamager() instanceof Snowball) {
			Player player = (Player) event.getEntity();
			Snowball snowball = (Snowball) event.getDamager();
			if (snowball.hasMetadata("Ar")) {
				player.addPotionEffect(new PotionEffect(PotionEffectType.BLINDNESS, 200, 2), true);
				event.setDamage(8D);
			} else if (snowball.hasMetadata("Água")) {
				player.addPotionEffect(new PotionEffect(PotionEffectType.POISON, 200, 1), true);
				event.setDamage(8D);
			} else if (snowball.hasMetadata("Terra")) {
				player.setVelocity(player.getLocation().getDirection().multiply(-3.2F));
				event.setDamage(8D);
			} else if (snowball.hasMetadata("Fogo")) {
				player.setFireTicks(100);
				event.setDamage(8D);
			}
		}
	}
}