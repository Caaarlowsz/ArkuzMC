package Comandos;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;

import Main.Main;

public class PvP implements CommandExecutor, Listener {
	public boolean onCommand(final CommandSender sender, final Command cmd, final String label, final String[] args) {
		final Player p = (Player) sender;
		if (!cmd.getName().equalsIgnoreCase("pvp") || (!sender.hasPermission("arkuz.pvp") && !sender.isOp())) {
			return false;
		}
		if (p.getWorld().getPVP()) {
			p.getWorld().setPVP(false);
			Bukkit.getServer()
					.broadcastMessage(String.valueOf(Main.prefix) + " §4\u27bc §7O PvP Do Servidor Foi §cDesabilitado");
			return true;
		}
		p.getWorld().setPVP(true);
		Bukkit.getServer()
				.broadcastMessage(String.valueOf(Main.prefix) + " §4\u27bc §7O PvP Do Servidor Foi §aHabilitado");
		return true;
	}
}
