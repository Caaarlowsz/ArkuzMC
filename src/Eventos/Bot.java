package Eventos;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerLoginEvent;

public class Bot implements Listener {
	@EventHandler
	public void onbotJoin(final PlayerLoginEvent e) {
		final Player jogador = e.getPlayer();
		if (jogador.getName().contains("Build") || jogador.getName().contains("Nitro")
				|| jogador.getName().contains("Hydra") || jogador.getName().contains("Worms")
				|| jogador.getName().contains("Hydro") || jogador.getName().contains("Beach")
				|| jogador.getName().contains("Elder") || jogador.getName().contains("Slime")
				|| jogador.getName().contains("99") || jogador.getName().contains("50")
				|| jogador.getName().contains("49") || jogador.getName().contains("Tower")) {
			e.disallow(PlayerLoginEvent.Result.KICK_OTHER,
					"§cVocê foi listado como um BOT. \n \n §7Caso isso seja um engano, basta trocar o seu nick sem as palavras: \n §eTower,beach,lp,49,99,50,crazy,hydra,super,beach,worms... ");
		}
	}
}
