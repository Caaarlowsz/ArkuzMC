package Comandos;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;

import Main.Main;

public class Givevip implements CommandExecutor, Listener {
	public boolean onCommand(final CommandSender sender, final Command cmd, final String label, final String[] args) {
		final Player p = (Player) sender;
		if (cmd.getName().equalsIgnoreCase("givevip")) {
			if (!sender.hasPermission("arkuz.givevip")) {
				sender.sendMessage(String.valueOf(Main.prefix)
						+ "\u279c §cDesculpe, mas voc\u00ea n\u00e3o tem permiss\u00e3o para fazer isso.");
				return true;
			}
			if (args.length == 0) {
				p.sendMessage(String.valueOf(Main.prefix)
						+ "\u279c §cOps! Use isso De Maneira Correta: §f/givevip <jogador> <vip>");
				return true;
			}
			if (args.length == 2) {
				final String vipgroup = args[1];
				final Player jogador = Bukkit.getPlayer(args[0]);
				if (vipgroup.equalsIgnoreCase("Vip")) {
					p.sendMessage("§eO Vip §aVip §eFoi dado ao jogador " + jogador.getName() + "§e("
							+ jogador.getUniqueId() + "§e)");
					Bukkit.dispatchCommand((CommandSender) Bukkit.getConsoleSender(),
							"pex user " + jogador.getName() + " group set vip");
					return true;
				}
			}
		}
		return false;
	}
}
