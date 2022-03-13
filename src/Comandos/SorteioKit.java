package Comandos;

import Essencial.HorarioAPI;
import Essencial.ListKits;
import com.github.caaarlowsz.arkuzmc.kitpvp.ArkuzPvP;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.plugin.Plugin;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.ArrayList;
import java.util.Random;

public class SorteioKit implements CommandExecutor, Listener {
	public boolean onCommand(final CommandSender sender, final Command cmd, final String label, final String[] args) {
		if (sender.hasPermission("arkuz.sortearkit")) {
			final ArrayList<String> Kit = new ArrayList<String>();
			ListKits[] values;
			for (int length = (values = ListKits.values()).length, i = 0; i < length; ++i) {
				final ListKits s = values[i];
				if (!Kit.contains(s.name())) {
					Kit.add(s.name().toLowerCase());
				}
			}
			Bukkit.broadcastMessage("               §E\u25cf §6§lSorteio §E\u25cf        ");
			Bukkit.broadcastMessage("");
			Bukkit.broadcastMessage("          §6Estamos iniciando um §fSorteio§a!  ");
			Bukkit.broadcastMessage("              §6Começou às: §f" + HorarioAPI.getHorario());
			Bukkit.broadcastMessage("");
			new BukkitRunnable() {
				public void run() {
					final ArrayList<Player> Players = new ArrayList<Player>();
					Player[] onlinePlayers;
					for (int length = (onlinePlayers = Bukkit.getOnlinePlayers()).length, i = 0; i < length; ++i) {
						final Player all = onlinePlayers[i];
						if (!Players.contains(all)) {
							Players.add(all);
						}
					}
					final Player random = Players.get(new Random().nextInt(Players.size()));
					Bukkit.broadcastMessage("           §E\u25cf §6§lSorteio §E\u25cf ");
					Bukkit.broadcastMessage("");
					Bukkit.broadcastMessage("       §6O Sorteio Foi Finalizado!");
					Bukkit.broadcastMessage("       §6O Ganhador Foi: §f" + random.getName());
					final Random r = new Random();
					final int x = r.nextInt(Kit.size());
					Bukkit.broadcastMessage("         §6O prêmio foi: §fO kit " + Kit.get(x));
					Bukkit.broadcastMessage("");
					Bukkit.dispatchCommand((CommandSender) Bukkit.getConsoleSender(),
							"pex user " + random.getName() + " add kit." + Kit.get(x));
				}
			}.runTaskLater((Plugin) ArkuzPvP.getInstance(), 200L);
		}
		return false;
	}
}
