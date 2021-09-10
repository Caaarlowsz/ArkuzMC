package Comandos;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;

import Main.Main;

public class RemovePermission implements CommandExecutor, Listener {
	public boolean onCommand(final CommandSender sender, final Command cmd, final String label, final String[] args) {
		final Player p = (Player) sender;
		if (cmd.getName().equalsIgnoreCase("removepermission")) {
			if (!sender.hasPermission("arkuz.removepermission")) {
				sender.sendMessage(String.valueOf(Main.prefix)
						+ " \u279c §cDesculpe, mas voc\u00ea n\u00e3o tem permiss\u00e3o para fazer isso.");
				return true;
			}
			if (args.length == 0) {
				p.sendMessage(String.valueOf(Main.prefix)
						+ " \u279c §cOps! Use isso De Maneira Correta: §f/removepermission <jogador> <permissao> ");
				p.sendMessage("§c(Para ver a Lista de permiss\u00f5es, use /permissionslist)");
				return true;
			}
			if (args.length != 2) {
				p.sendMessage(String.valueOf(Main.prefix) + "\u279c §cEssa Permiss\u00e3o n\u00e3o existe!");
				return true;
			}
			final String permissions = args[1];
			final Player jogador = Bukkit.getPlayer(args[0]);
			if (permissions.equalsIgnoreCase("Admin")) {
				p.sendMessage(String.valueOf(Main.prefix)
						+ " \u279c §aVoce removeu A permissao §fModo Admin§c do jogador §f" + jogador.getName());
				jogador.sendMessage(
						String.valueOf(Main.prefix) + " \u279c §cVoce perdeu a Permiss\u00e3o Para o §fModo Admin§c!");
				Bukkit.dispatchCommand((CommandSender) Bukkit.getConsoleSender(),
						"pex user " + jogador.getName() + " remove arkuz.admin");
				return true;
			}
			if (permissions.equalsIgnoreCase("staffchat")) {
				p.sendMessage(String.valueOf(Main.prefix)
						+ " \u279c §aVoce removeu A permissao §fStaffChat§c do jogador §f" + jogador.getName());
				jogador.sendMessage(
						String.valueOf(Main.prefix) + " \u279c §cVoce perdeu a Permissao do §fSstaffChat§c!");
				Bukkit.dispatchCommand((CommandSender) Bukkit.getConsoleSender(),
						"pex user " + jogador.getName() + " remove arkuz.sc");
				return true;
			}
			if (permissions.equalsIgnoreCase("fullkit")) {
				p.sendMessage(String.valueOf(Main.prefix) + " \u279c §aVoce removeu Todos os Kits Ao jogador §f"
						+ jogador.getName());
				jogador.sendMessage(
						String.valueOf(Main.prefix) + " \u279c §cVoce perdeu a Permiss\u00e3o de §fTodos os Kits§c!");
				jogador.sendMessage("§cSeus kits voltaram ao padr\u00e3o do seu Rank.");
				Bukkit.dispatchCommand((CommandSender) Bukkit.getConsoleSender(),
						"pex user " + jogador.getName() + " remove kit.*");
				return true;
			}
			if (permissions.equalsIgnoreCase("teleportar")) {
				p.sendMessage(String.valueOf(Main.prefix)
						+ " \u279c §aVoce removeu a Permiss\u00e3o de §fTeleportar§c do jogador §f"
						+ jogador.getName());
				jogador.sendMessage(
						String.valueOf(Main.prefix) + " \u279c §cVoce perdeu a Permiss\u00e3o de §fTeleportar§c!");
				Bukkit.dispatchCommand((CommandSender) Bukkit.getConsoleSender(),
						"pex user " + jogador.getName() + " remove arkuz.teleport");
				return true;
			}
			if (permissions.equalsIgnoreCase("givevips")) {
				p.sendMessage(String.valueOf(Main.prefix)
						+ " \u279c §aVoce removeu a Permiss\u00e3o de §fDar Vips§c do Jogador §f" + jogador.getName());
				jogador.sendMessage(
						String.valueOf(Main.prefix) + " \u279c §aVoce perdeu a Permiss\u00e3o de §fDar Vips§c!");
				Bukkit.dispatchCommand((CommandSender) Bukkit.getConsoleSender(),
						"pex user " + jogador.getName() + " remove arkuz.givevip");
				return true;
			}
			if (permissions.equalsIgnoreCase("givekit")) {
				p.sendMessage(String.valueOf(Main.prefix)
						+ " \u279c §aVoce removeu a Permiss\u00e3o de §fDar Kits§c do Jogador §f" + jogador.getName());
				jogador.sendMessage(
						String.valueOf(Main.prefix) + "\u279c §cVoce perdeu a Permiss\u00e3o de §fDar Kits§c!");
				Bukkit.dispatchCommand((CommandSender) Bukkit.getConsoleSender(),
						"pex user " + jogador.getName() + " remove arkuz.givekit");
				return true;
			}
			if (permissions.equalsIgnoreCase("sortearkit")) {
				p.sendMessage(String.valueOf(Main.prefix)
						+ " \u279c §aVoce removeu a Permiss\u00e3o de §fSortear Kits§c do Jogador §f"
						+ jogador.getName());
				jogador.sendMessage(
						String.valueOf(Main.prefix) + "\u279c §cVoce perdeu a Permissao de §fSortear kits§c!");
				Bukkit.dispatchCommand((CommandSender) Bukkit.getConsoleSender(),
						"pex user " + jogador.getName() + " remove arkuz.sortearkit");
				return true;
			}
			if (permissions.equalsIgnoreCase("sortearvip")) {
				p.sendMessage(String.valueOf(Main.prefix)
						+ "\u279c §aVoce removeu a Permiss\u00e3o de §fSortear Vips§c do Jogador §f"
						+ jogador.getName());
				jogador.sendMessage(
						String.valueOf(Main.prefix) + " \u279c §aVoce perdeu a Permissao de §fSortear Vips§c!");
				Bukkit.dispatchCommand((CommandSender) Bukkit.getConsoleSender(),
						"pex user " + jogador.getName() + " remove arkuz.sortearvip");
				return true;
			}
		}
		return false;
	}
}
