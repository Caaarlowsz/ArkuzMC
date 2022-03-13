package Kits;

import java.util.Random;

import com.github.caaarlowsz.arkuzmc.kitpvp.ArkuzPvP;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEntityEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.Plugin;

import Essencial.Cooldown;
import Essencial.KitUtil;
import Eventos.Habilidade;

public class Monk implements Listener {
	@EventHandler
	public void aoMonk(final PlayerInteractEntityEvent e) {
		final Player p = e.getPlayer();
		if (e.getRightClicked() instanceof Player) {
			final Player jogadorClicado = (Player) e.getRightClicked();
			if (Habilidade.getAbility(p).equalsIgnoreCase("Monk")
					&& p.getItemInHand().getType() == Material.BLAZE_ROD) {
				if (Cooldown.add(p)) {
					KitUtil.MensagemCooldown(p);
					return;
				}
				final int random = new Random().nextInt(jogadorClicado.getInventory().getSize() - 10 + 1 + 10);
				final ItemStack ItemSelecionado = jogadorClicado.getInventory().getItem(random);
				final ItemStack ItemMudado = jogadorClicado.getItemInHand();
				jogadorClicado.setItemInHand(ItemSelecionado);
				jogadorClicado.getInventory().setItem(random, ItemMudado);
				jogadorClicado
						.sendMessage(String.valueOf(ArkuzPvP.prefix) + " §4➼ §7Um Player Usou o Monnk Em Você");
				p.sendMessage(String.valueOf(String.valueOf(ArkuzPvP.prefix)
						+ " §4➼ §7Você Usou o Monk No Player: §c" + jogadorClicado.getName()));
				Cooldown.add(p, 20);
				Bukkit.getScheduler().scheduleSyncDelayedTask((Plugin) ArkuzPvP.getInstance(), (Runnable) new Runnable() {
					@Override
					public void run() {
						p.sendMessage(String.valueOf(ArkuzPvP.prefix) + " §4➼ §7Seu Cooldown Acabou");
					}
				}, 400L);
			}
		}
	}
}
