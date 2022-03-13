package Comandos;

import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;

public class Limpar implements CommandExecutor, Listener {
	public static List<String> registered;

	public boolean onCommand(final CommandSender Sender, final Command Cmd, final String Label, final String[] Args) {
		final Player p = (Player) Sender;
		if (Cmd.getName().equalsIgnoreCase("limpar")) {
			if (!p.hasPermission("arkuz.limpar")) {
				p.sendMessage("§c§lSem permissão");
				return true;
			}
			Bukkit.broadcastMessage(
					"§cExecutando limpeza do servidor, isto pode causar LAG, mas será temporario!");
			final Runtime r2 = Runtime.getRuntime();
			final long Lused2 = (r2.totalMemory() - r2.freeMemory()) / 1024L / 1024L;
			System.gc();
			final long Lused3 = (r2.totalMemory() - r2.freeMemory()) / 1024L / 1024L;
			Player[] onlinePlayers;
			for (int length = (onlinePlayers = Bukkit.getOnlinePlayers()).length, i = 0; i < length; ++i) {
				final Player s = onlinePlayers[i];
				if (s.hasPermission("arkuz.limpar")) {
					s.sendMessage(
							"§a§l!§7 Foram removidos §6" + Long.toString(Lused2 - Lused3) + "M §7RAM do Servidor");
				}
			}
		}
		Bukkit.broadcastMessage("§4§lINFO: §7Limpeza concluída!");
		return false;
	}
}
