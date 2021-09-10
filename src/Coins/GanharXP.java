package Coins;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;

public class GanharXP implements Listener {
	@EventHandler
	public void a(final PlayerDeathEvent e) {
		if (e.getEntity() instanceof Player && e.getEntity().getKiller() instanceof Player) {
			final Player killer = e.getEntity().getKiller();
			final Player killed = e.getEntity();
			killed.teleport(killed.getWorld().getSpawnLocation());
			e.setDeathMessage((String) null);
			XpM.addMoney(killer, 50);
			XpM.removeMoney(killed, 25);
		}
	}
}
