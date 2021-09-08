package Minigames;

import org.bukkit.event.EventHandler;
import Essencial.KitAPI;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.entity.Player;
import Main.Main;
import org.bukkit.event.Listener;

public class Minigames implements Listener
{
    public Minigames(final Main main) {
    }
    
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
