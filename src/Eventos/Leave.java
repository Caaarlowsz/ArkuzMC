package Eventos;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

import Essencial.KitAPI;

public class Leave implements Listener {
	@EventHandler
	public void Sair(final PlayerQuitEvent e) {
		final Player p = e.getPlayer();
		e.setQuitMessage("§c- §7" + p.getDisplayName());
		KitAPI.remove(p);
		Bukkit.broadcastMessage("§c- §7" + p.getName());
	}
}
