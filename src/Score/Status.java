package Score;

import com.github.caaarlowsz.arkuzmc.kitpvp.ArkuzKitPvP;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerJoinEvent;

public class Status implements Listener {
	@EventHandler
	void aoLogar(final PlayerJoinEvent evento) {
		final Player jogador = evento.getPlayer();
		if (ArkuzKitPvP.getInstance().getConfig().get("status." + jogador.getName().toLowerCase() + ".kills") == null) {
			ArkuzKitPvP.getInstance().getConfig().set("status." + jogador.getName().toLowerCase() + ".kills", (Object) 0);
			ArkuzKitPvP.getInstance().saveConfig();
		}
		if (ArkuzKitPvP.getInstance().getConfig().get("status." + jogador.getName().toLowerCase() + ".mortes") == null) {
			ArkuzKitPvP.getInstance().getConfig().set("status." + jogador.getName().toLowerCase() + ".mortes", (Object) 0);
			ArkuzKitPvP.getInstance().saveConfig();
		}
	}

	@EventHandler
	void aoMatar(final PlayerDeathEvent evento) {
		if (evento.getEntity().getKiller() instanceof Player) {
			final Player jogador = evento.getEntity().getKiller();
			final int kills = ArkuzKitPvP.getInstance().getConfig().getInt("status." + jogador.getName().toLowerCase() + ".kills");
			ArkuzKitPvP.getInstance().getConfig().set("status." + jogador.getName().toLowerCase() + ".kills", (Object) (kills + 1));
			ArkuzKitPvP.getInstance().saveConfig();
		}
	}

	@EventHandler
	void aoMorrer(final PlayerDeathEvent evento) {
		if (evento.getEntity() instanceof Player) {
			final Player jogador = evento.getEntity();
			final int mortes = ArkuzKitPvP.getInstance().getConfig().getInt("status." + jogador.getName().toLowerCase() + ".mortes");
			ArkuzKitPvP.getInstance().getConfig().set("status." + jogador.getName().toLowerCase() + ".mortes", (Object) (mortes + 1));
			ArkuzKitPvP.getInstance().saveConfig();
		}
	}

	public static int getKills(final Player p) {
		return ArkuzKitPvP.getInstance().getConfig().getInt("status." + p.getName().toLowerCase() + ".kills");
	}
}
