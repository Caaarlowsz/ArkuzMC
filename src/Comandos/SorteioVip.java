package Comandos;

import Essencial.HorarioAPI;
import Essencial.Vips;
import com.github.caaarlowsz.arkuzmc.kitpvp.ArkuzKitPvP;
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

public class SorteioVip implements CommandExecutor, Listener {
	public boolean onCommand(final CommandSender sender, final Command cmd, final String label, final String[] args) {
		if (sender.hasPermission("arkuz.sortearvip")) {
			final ArrayList<String> Vip = new ArrayList<String>();
			Vips[] values;
			for (int length = (values = Vips.values()).length, i = 0; i < length; ++i) {
				final Vips s = values[i];
				if (!Vip.contains(s.name())) {
					Vip.add(s.name().toLowerCase());
				}
			}
			Bukkit.broadcastMessage("               §E\u25cf §6§lSorteio §e\u25cf         ");
			Bukkit.broadcastMessage("");
			Bukkit.broadcastMessage("          §6Estamos iniciando um §eSorteio§a!  ");
			Bukkit.broadcastMessage("   §6Começou às: §f" + HorarioAPI.getHorario());
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
					Bukkit.broadcastMessage("           §E\u25cf §6§lSorteio §e\u25cf ");
					Bukkit.broadcastMessage("");
					Bukkit.broadcastMessage("   §6O Sorteio Foi Finalizado!");
					Bukkit.broadcastMessage("     §6O Ganhador Foi: §f" + random.getName());
					final Random r = new Random();
					final int x = r.nextInt(Vip.size());
					Bukkit.broadcastMessage("         §6Ganhou: §f" + Vip.get(x));
					Bukkit.broadcastMessage("");
					Bukkit.dispatchCommand((CommandSender) Bukkit.getConsoleSender(),
							"pex user " + random.getName() + " group set " + Vip.get(x));
				}
			}.runTaskLater((Plugin) ArkuzKitPvP.getInstance(), 200L);
		}
		return false;
	}
}
