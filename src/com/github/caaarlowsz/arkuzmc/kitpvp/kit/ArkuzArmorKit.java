package com.github.caaarlowsz.arkuzmc.kitpvp.kit;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import com.github.caaarlowsz.arkuzmc.kitpvp.ArkuzKitPvP;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.event.inventory.InventoryType.SlotType;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.Plugin;

import Essencial.Cooldown;
import Essencial.KitUtil;
import Eventos.Habilidade;

public final class ArkuzArmorKit extends ArkuzKit implements Listener {

	private static final Map<UUID, ItemStack[]> armorMap = new HashMap<>();

	public ArkuzArmorKit() {
		super("Armor");
	}

	@EventHandler(priority = EventPriority.NORMAL)
	private void onPlayerInteract(PlayerInteractEvent event) {
		Player player = event.getPlayer();
		if (Habilidade.getAbility(player).equals(this.getName()) && event.hasItem() && event.getMaterial() == Material.GOLD_INGOT && event.getAction().name().contains("RIGHT")) {
			if (!Cooldown.add(player)) {
				Cooldown.add(player, 25);

				PlayerInventory inv = player.getInventory();
				armorMap.put(player.getUniqueId(), inv.getArmorContents());
				inv.setArmorContents(new ItemStack[] { new ItemStack(Material.GOLD_HELMET), new ItemStack(Material.GOLD_CHESTPLATE), new ItemStack(Material.GOLD_LEGGINGS), new ItemStack(Material.GOLD_BOOTS)});
				player.updateInventory();

				Bukkit.getScheduler().runTaskLater(ArkuzKitPvP.getInstance(), ()-> {
					if (armorMap.containsKey(player.getUniqueId()))
					inv.setArmorContents(armorMap.remove(player.getUniqueId()));
					player.updateInventory();
				}, 200L);
				Bukkit.getScheduler().runTaskLater(ArkuzKitPvP.getInstance(), ()-> {
					player.sendMessage(ArkuzKitPvP.prefix + " §4➼ §7Seu CoolDown Acabou");
				}, 500L);

				player.sendMessage(ArkuzKitPvP.prefix + " §4➼ §7Agora Você Recebeu Uma Armadura Temporaria!");
			} else
				KitUtil.MensagemCooldown(player);
		}
	}

	@EventHandler
	private void onInventoryClick(InventoryClickEvent event) {
		if (event.getWhoClicked() instanceof Player && event.getSlotType().equals(SlotType.ARMOR)) {
			Player player = (Player) event.getWhoClicked();
			if (Habilidade.getAbility(player).equals(this.getName()) && armorMap.containsKey(player.getUniqueId()))
				event.setCancelled(true);
		}
	}
}