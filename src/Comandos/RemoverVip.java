package Comandos;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;

import Main.Main;

public class RemoverVip implements CommandExecutor, Listener {
	public boolean onCommand(final CommandSender sender, final Command cmd, final String label, final String[] args) {
		final Player p = (Player) sender;
		if (cmd.getName().equalsIgnoreCase("removervip")) {
			if (!sender.hasPermission("arkuz.removevip")) {
				sender.sendMessage(String.valueOf(Main.prefix)
						+ " \u279c §cDesculpe, mas voc\u00ea n\u00e3o tem permiss\u00e3o para fazer isso.");
				return true;
			}
			if (args.length == 0) {
				p.sendMessage(String.valueOf(Main.prefix)
						+ " \u279c §cOps! Use isso De Maneira Correta: §f/removevip <jogador> <vip>");
				return true;
			}
			if (args.length != 2) {
				p.sendMessage(String.valueOf(Main.prefix)
						+ "\u279c §cOps! Use isso De Maneira Correta: §f/removevip <nick> <vip>");
				return true;
			}
			final String vipgroup = args[1];
			final Player jogador = Bukkit.getPlayer(args[0]);
			if (vipgroup.equalsIgnoreCase("Gladiador")) {
				p.sendMessage("§eVoce Removeu o vip GLADIADOR Do jogador " + jogador.getName() + "§e("
						+ jogador.getUniqueId() + "§e)");
				jogador.sendMessage(
						"§eSeu Vip GLADIADOR Acaba de Expirar! Seu Rank Foi setado Para NORMAL Automaticamente.");
				Bukkit.dispatchCommand((CommandSender) Bukkit.getConsoleSender(),
						"pex user " + jogador.getName() + " group set normal");
				jogador.chat("/tag normal");
				return true;
			}
			if (vipgroup.equalsIgnoreCase("Heroi")) {
				p.sendMessage("§eVoce Removeu o vip HEROI Do jogador " + jogador.getName() + "§e("
						+ jogador.getUniqueId() + "§e)");
				jogador.sendMessage(
						"§eSeu Vip Heroi Acaba de Expirar! Seu Rank Foi setado Para NORMAL Automaticamente.");
				Bukkit.dispatchCommand((CommandSender) Bukkit.getConsoleSender(),
						"pex user " + jogador.getName() + " group set normal");
				jogador.chat("/tag normal");
				return true;
			}
			if (vipgroup.equalsIgnoreCase("Supremo")) {
				p.sendMessage("§eVoce Removeu o vip SUPREMO Do jogador " + jogador.getName() + "§e("
						+ jogador.getUniqueId() + "§e)");
				jogador.sendMessage(
						"§eSeu Vip SUPREMO Acaba de Expirar! Seu Rank Foi setado Para NORMAL Automaticamente.");
				Bukkit.dispatchCommand((CommandSender) Bukkit.getConsoleSender(),
						"pex user " + jogador.getName() + " group set normal");
				jogador.chat("/tag normal");
				return true;
			}
		}
		return false;
	}
}
