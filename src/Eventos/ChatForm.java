package Eventos;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerChatEvent;

import Score.ScoreBoarding;

public class ChatForm implements Listener {
	@EventHandler(priority = EventPriority.HIGHEST)
	public void chat(final PlayerChatEvent e) {
		final Player p = e.getPlayer();
		if (!p.hasPermission("arkuz.cor")) {
			e.setFormat("§7{" + ScoreBoarding.Rank(p) + "§7} " + p.getDisplayName() + " §7 " + e.getMessage());
		} else {
			e.setFormat("§7{" + ScoreBoarding.Rank(p) + "§7} " + p.getDisplayName() + " §f "
					+ e.getMessage().replace("&", "§"));
		}
	}
}
