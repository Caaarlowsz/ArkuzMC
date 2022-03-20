package com.github.caaarlowsz.arkuzmc.kitpvp.kit;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.bukkit.Bukkit;
import org.bukkit.Color;
import org.bukkit.Effect;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;
import org.bukkit.inventory.meta.LeatherArmorMeta;
import org.bukkit.util.Vector;

import com.github.caaarlowsz.arkuzmc.kitpvp.ArkuzKitPvP;

import Essencial.KitAPI;

public final class ArkuzDeshFireKit extends ArkuzKit implements Listener {

	private static final List<Player> cooldownList = new ArrayList<Player>();

	private static final Map<UUID, ItemStack[]> armorMap = new HashMap<>();

	public ArkuzDeshFireKit() {
		super("DeshFire");
	}

	@EventHandler(priority = EventPriority.NORMAL)
	private void onPlayerInteract(PlayerInteractEvent event) {
		Player player = event.getPlayer();
		if (KitAPI.DeshFire.contains(player.getName()) && event.hasItem()
				&& event.getMaterial() == Material.REDSTONE_BLOCK) {
			event.setCancelled(true);
			if (!cooldownList.contains(player)) {
				cooldownList.add(player);
				player.setVelocity(player.getEyeLocation().getDirection().multiply(6).add(new Vector()));
				player.getWorld().playEffect(player.getLocation(), Effect.SMOKE, 10, 0);

				for (Entity entities : player.getNearbyEntities(8D, 8D, 8D)) {
					if (entities instanceof Player) {
						Player players = (Player) entities;
						players.damage(10D);
						players.setVelocity(new Vector(0.1D, 0D, 0.1D));
						players.setFireTicks(120);
					}
				}

				PlayerInventory inv = player.getInventory();
				armorMap.put(player.getUniqueId(), inv.getArmorContents());

				ItemStack helmet = new ItemStack(Material.LEATHER_HELMET);
				LeatherArmorMeta mHelmet = (LeatherArmorMeta) helmet.getItemMeta();
				mHelmet.setColor(Color.RED);
				helmet.setItemMeta(mHelmet);
				inv.setHelmet(helmet);

				ItemStack chestplate = new ItemStack(Material.LEATHER_CHESTPLATE);
				LeatherArmorMeta mChestplate = (LeatherArmorMeta) chestplate.getItemMeta();
				mChestplate.setColor(Color.RED);
				chestplate.setItemMeta(mChestplate);
				inv.setChestplate(chestplate);

				ItemStack leggings = new ItemStack(Material.LEATHER_LEGGINGS);
				LeatherArmorMeta mLeggings = (LeatherArmorMeta) leggings.getItemMeta();
				mLeggings.setColor(Color.RED);
				leggings.setItemMeta(mLeggings);
				inv.setLeggings(leggings);

				ItemStack boots = new ItemStack(Material.LEATHER_BOOTS);
				LeatherArmorMeta mBoots = (LeatherArmorMeta) boots.getItemMeta();
				mBoots.setColor(Color.RED);
				boots.setItemMeta(mBoots);
				inv.setBoots(boots);
				player.updateInventory();

				Bukkit.getScheduler().runTaskLater(ArkuzKitPvP.getInstance(), () -> {
					if (armorMap.containsKey(player.getUniqueId()))
						inv.setArmorContents(armorMap.remove(player.getUniqueId()));
					player.updateInventory();
				}, 50L);
				Bukkit.getScheduler().runTaskLater(ArkuzKitPvP.getInstance(), () -> {
					cooldownList.remove(player);
					player.getWorld().playSound(player.getLocation(), Sound.BURP, 5F, 5F);
					player.sendMessage(ArkuzKitPvP.prefix + " §4➼ §7Seu CoolDown Acabou");
				}, 700L);
			} else
				player.sendMessage(String.valueOf(ArkuzKitPvP.prefix) + " §4➼ §7Aguarde o CoolDown Acabar");
		}
	}
}