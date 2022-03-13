package Minigames;

import Essencial.KitAPI;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

public class Minigames implements Listener {

	public static void joinMinigame(final Player p, final ListGames minigame) {
		if (minigame == ListGames.refillTest) {
			new refillTest(p);
		}
	}

	@EventHandler
	public void onQuit(final PlayerQuitEvent e) {
		if (KitAPI.refillTest.contains(e.getPlayer().getName())) {
			KitAPI.refillTest.remove(e.getPlayer().getName());
			KitAPI.refillTestTime.remove(e.getPlayer().getName());
		}
	}
}
