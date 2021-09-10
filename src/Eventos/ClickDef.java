package Eventos;

import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;

import Caixas.InvEscolha;
import Invs.InvKits;
import Invs.InvLoja;
import Invs.InvOutros;
import Invs.InvWarps;

public class ClickDef implements Listener {
	@EventHandler
	public void onClickItem4(final PlayerInteractEvent e) {
		final Player p = e.getPlayer();
		if ((e.getAction() == Action.RIGHT_CLICK_AIR || e.getAction() == Action.RIGHT_CLICK_BLOCK)
				&& e.getPlayer().getItemInHand().getType() == Material.PISTON_STICKY_BASE) {
			e.setCancelled(true);
			p.playSound(p.getLocation(), Sound.DOOR_OPEN, 5.0f, 5.0f);
			InvKits.guiKits1(p);
		}
	}

	@EventHandler
	public void onClickItem41(final PlayerInteractEvent e) {
		final Player p = e.getPlayer();
		if ((e.getAction() == Action.RIGHT_CLICK_AIR || e.getAction() == Action.RIGHT_CLICK_BLOCK)
				&& e.getPlayer().getItemInHand().getType() == Material.PAPER) {
			e.setCancelled(true);
			p.playSound(p.getLocation(), Sound.DOOR_OPEN, 5.0f, 5.0f);
			InvWarps.guiKits(p);
		}
	}

	@EventHandler
	public void onClickItem4123(final PlayerInteractEvent e) {
		final Player p = e.getPlayer();
		if ((e.getAction() == Action.RIGHT_CLICK_AIR || e.getAction() == Action.RIGHT_CLICK_BLOCK)
				&& e.getPlayer().getItemInHand().getType() == Material.CHEST) {
			e.setCancelled(true);
			p.playSound(p.getLocation(), Sound.DOOR_OPEN, 5.0f, 5.0f);
			InvEscolha.guiKits(p);
		}
	}

	@EventHandler
	public void onClickItem401(final PlayerInteractEvent e) {
		final Player p = e.getPlayer();
		if ((e.getAction() == Action.RIGHT_CLICK_AIR || e.getAction() == Action.RIGHT_CLICK_BLOCK)
				&& e.getPlayer().getItemInHand().getType() == Material.REDSTONE) {
			e.setCancelled(true);
			p.playSound(p.getLocation(), Sound.DOOR_OPEN, 5.0f, 5.0f);
			InvOutros.guiKits(p);
		}
	}

	@EventHandler
	public void onClickItem412(final PlayerInteractEvent e) {
		final Player p = e.getPlayer();
		if ((e.getAction() == Action.RIGHT_CLICK_AIR || e.getAction() == Action.RIGHT_CLICK_BLOCK)
				&& e.getPlayer().getItemInHand().getType() == Material.BOOK) {
			e.setCancelled(true);
			p.playSound(p.getLocation(), Sound.DOOR_OPEN, 5.0f, 5.0f);
			InvLoja.guiKits(p);
		}
	}
}
