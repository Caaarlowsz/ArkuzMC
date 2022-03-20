package com.github.caaarlowsz.arkuzmc.kitpvp.kit;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.block.BlockPhysicsEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import com.github.caaarlowsz.arkuzmc.kitpvp.ArkuzKitPvP;

import Eventos.Habilidade;

public final class ArkuzJellyFishKit extends ArkuzKit implements Listener {

	private static final List<Block> physicsList = new ArrayList<>();

	public ArkuzJellyFishKit() {
		super("JellyFish");
	}

	@EventHandler(priority = EventPriority.NORMAL)
	private void onPlayerInteract(PlayerInteractEvent event) {
		Player player = event.getPlayer();
		if (Habilidade.getAbility(player).equals(this.getName())
				&& player.getItemInHand().getType() == Material.CLAY_BALL
				&& event.getAction() == Action.RIGHT_CLICK_BLOCK) {
			Block block = event.getClickedBlock().getRelative(event.getBlockFace());

			if (block.getType() == Material.AIR) {
				physicsList.add(block);
				block.setType(Material.STATIONARY_WATER);
				Bukkit.getScheduler().runTaskLater(ArkuzKitPvP.getInstance(), () -> {
					block.setType(Material.AIR);
					physicsList.remove(block);
				}, 60L);
			} else
				player.sendMessage(ArkuzKitPvP.prefix + " §4➼ §7Não se Pode Usar Seu Kit Aqui");
		}
	}

	@EventHandler(priority = EventPriority.NORMAL)
	private void onBlockPhysics(BlockPhysicsEvent event) {
		Block block = event.getBlock();
		if (block.getType() == Material.STATIONARY_WATER && physicsList.contains(block))
			event.setCancelled(true);
	}

	@EventHandler(priority = EventPriority.NORMAL)
	private void onPlayerMove(PlayerMoveEvent event) {
		Player player = event.getPlayer();
		Block block = event.getFrom().getBlock();
		if (block.getType() == Material.STATIONARY_WATER && !player.getInventory().contains(Material.CLAY_BALL)
				&& physicsList.contains(block))
			player.addPotionEffect(new PotionEffect(PotionEffectType.POISON, 100, 0));
	}
}