package Eventos;

import java.util.HashMap;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

import Main.Main;

public class AntSpam implements Listener {
	public static HashMap<Player, Long> chat;

	static {
		AntSpam.chat = new HashMap<Player, Long>();
	}

	public AntSpam(final Main main) {
	}

	@EventHandler(priority = EventPriority.HIGHEST, ignoreCancelled = false)
	public void aAntiSpam(final AsyncPlayerChatEvent e) {
		final Player p = e.getPlayer();
		if (!AntSpam.chat.containsKey(p)) {
			final int zeitconfig = 2000;
			final long time = System.currentTimeMillis() + zeitconfig;
			if (p.hasPermission("arkuz.spam")) {
				return;
			}
			AntSpam.chat.put(p, time);
		} else if (AntSpam.chat.get(p) <= System.currentTimeMillis()) {
			if (p.hasPermission("arkuz.spam")) {
				return;
			}
			final int zeitconfig = 2000;
			final long time = System.currentTimeMillis() + zeitconfig;
			AntSpam.chat.put(p, time);
		} else {
			if (AntSpam.chat.get(p) < System.currentTimeMillis() || p.hasPermission("arkuz.spam")) {
				return;
			}
			p.sendMessage(String.valueOf(Main.prefix) + " §4\u27bc §7Pare De Floodar Ou Ser\u00e1 §cPunido");
			e.setCancelled(true);
		}
	}
}
