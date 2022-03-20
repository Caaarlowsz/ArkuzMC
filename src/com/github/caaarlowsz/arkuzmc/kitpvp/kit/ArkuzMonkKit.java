package com.github.caaarlowsz.arkuzmc.kitpvp.kit;

import java.util.Random;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEntityEvent;
import org.bukkit.inventory.ItemStack;

import com.github.caaarlowsz.arkuzmc.kitpvp.ArkuzKitPvP;

import Essencial.Cooldown;
import Essencial.KitUtil;
import Eventos.Habilidade;

public final class ArkuzMonkKit extends ArkuzKit implements Listener {

	public ArkuzMonkKit() {
		super("Monk");
	}

	@EventHandler(priority = EventPriority.NORMAL)
	private void onPlayerInteractEntity(PlayerInteractEntityEvent event) {
		if (event.getRightClicked() instanceof Player) {
			Player player = event.getPlayer(), righted = (Player) event.getRightClicked();
			if (Habilidade.getAbility(player).equals(this.getName())
					&& player.getItemInHand().getType() == Material.BLAZE_ROD) {
				if (!Cooldown.add(player)) {
					Cooldown.add(player, 20);

					int random = new Random().nextInt(37);
					ItemStack item = righted.getInventory().getItem(random), hand = righted.getItemInHand();

					righted.setItemInHand(item);
					righted.sendMessage(ArkuzKitPvP.prefix + " §4➼ §7Um Player Usou o Monnk Em Você");

					righted.getInventory().setItem(random, hand);
					player.sendMessage(
							ArkuzKitPvP.prefix + " §4➼ §7Você Usou o Monk No Player: §c" + righted.getName());

					Bukkit.getScheduler().runTaskLater(ArkuzKitPvP.getInstance(),
							() -> player.sendMessage(ArkuzKitPvP.prefix + " §4➼ §7Seu Cooldown Acabou"), 400L);
				} else
					KitUtil.MensagemCooldown(player);
			}
		}
	}
}