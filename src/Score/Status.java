package Score;

import com.github.caaarlowsz.arkuzmc.kitpvp.ArkuzPvP;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerJoinEvent;

public class Status implements Listener {
	@EventHandler
	void aoLogar(final PlayerJoinEvent evento) {
		final Player jogador = evento.getPlayer();
		if (ArkuzPvP.getInstance().getConfig().get("status." + jogador.getName().toLowerCase() + ".kills") == null) {
			ArkuzPvP.getInstance().getConfig().set("status." + jogador.getName().toLowerCase() + ".kills", (Object) 0);
			ArkuzPvP.getInstance().saveConfig();
		}
		if (ArkuzPvP.getInstance().getConfig().get("status." + jogador.getName().toLowerCase() + ".mortes") == null) {
			ArkuzPvP.getInstance().getConfig().set("status." + jogador.getName().toLowerCase() + ".mortes", (Object) 0);
			ArkuzPvP.getInstance().saveConfig();
		}
	}

	@EventHandler
	void aoMatar(final PlayerDeathEvent evento) {
		if (evento.getEntity().getKiller() instanceof Player) {
			final Player jogador = evento.getEntity().getKiller();
			final int kills = ArkuzPvP.getInstance().getConfig().getInt("status." + jogador.getName().toLowerCase() + ".kills");
			ArkuzPvP.getInstance().getConfig().set("status." + jogador.getName().toLowerCase() + ".kills", (Object) (kills + 1));
			ArkuzPvP.getInstance().saveConfig();
		}
	}

	@EventHandler
	void aoMorrer(final PlayerDeathEvent evento) {
		if (evento.getEntity() instanceof Player) {
			final Player jogador = evento.getEntity();
			final int mortes = ArkuzPvP.getInstance().getConfig().getInt("status." + jogador.getName().toLowerCase() + ".mortes");
			ArkuzPvP.getInstance().getConfig().set("status." + jogador.getName().toLowerCase() + ".mortes", (Object) (mortes + 1));
			ArkuzPvP.getInstance().saveConfig();
		}
	}

	public static int getKills(final Player p) {
		return ArkuzPvP.getInstance().getConfig().getInt("status." + p.getName().toLowerCase() + ".kills");
	}
}
