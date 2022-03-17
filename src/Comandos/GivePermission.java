package Comandos;

import com.github.caaarlowsz.arkuzmc.kitpvp.ArkuzKitPvP;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;

public class GivePermission implements CommandExecutor, Listener {
	public boolean onCommand(final CommandSender sender, final Command cmd, final String label, final String[] args) {
		final Player p = (Player) sender;
		if (cmd.getName().equalsIgnoreCase("givepermission")) {
			if (!sender.hasPermission("arkuz.givepermission")) {
				sender.sendMessage(String.valueOf(ArkuzKitPvP.prefix)
						+ "➼ §cDesculpe, mas você não tem permissão para fazer isso.");
				return true;
			}
			if (args.length == 0) {
				p.sendMessage(String.valueOf(ArkuzKitPvP.prefix)
						+ "➼ §cOps! Use isso De Maneira Correta: §f/givepermission <jogador> <permissao> ");
				p.sendMessage("§6§l(Para ver a Lista de permissões, use §f§l/permissionslist");
				return true;
			}
			if (args.length != 2) {
				p.sendMessage(String.valueOf(ArkuzKitPvP.prefix)
						+ "➼ §cOps! Use isso De Maneira Correta: §f/givepermission <nick> <permission>");
				return true;
			}
			final String permissions = args[1];
			final Player jogador = Bukkit.getPlayer(args[0]);
			if (permissions.equalsIgnoreCase("Admin")) {
				p.sendMessage("§eA Permissão MODO ADMINISTRADOR Foi dada do Jogador " + jogador.getName());
				Bukkit.dispatchCommand((CommandSender) Bukkit.getConsoleSender(),
						"pex user " + jogador.getName() + " add arkuz.admin");
				return true;
			}
			if (permissions.equalsIgnoreCase("staffchat")) {
				p.sendMessage("§ea Permissão ACESSO AO STAFFCHAT Foi dada so Jogador " + jogador.getName());
				Bukkit.dispatchCommand((CommandSender) Bukkit.getConsoleSender(),
						"pex user " + jogador.getName() + " add arkuz.sc");
				return true;
			}
			if (permissions.equalsIgnoreCase("fullkit")) {
				p.sendMessage("§eA Permissao de TODOS OS KITS Foi dada ao Jogador " + jogador.getName());
				Bukkit.dispatchCommand((CommandSender) Bukkit.getConsoleSender(),
						"pex user " + jogador.getName() + " add kit.*");
				return true;
			}
			if (permissions.equalsIgnoreCase("teleportar")) {
				p.sendMessage("§ea Permissao TELETRANSPORTAR foi dada ao Jogador " + jogador.getName());
				Bukkit.dispatchCommand((CommandSender) Bukkit.getConsoleSender(),
						"pex user " + jogador.getName() + " add arkuz.teleport");
				return true;
			}
			if (permissions.equalsIgnoreCase("givevips")) {
				p.sendMessage("§eA Permissão para DAR VIPS Foi dada do Jogador " + jogador.getName());
				Bukkit.dispatchCommand((CommandSender) Bukkit.getConsoleSender(),
						"pex user " + jogador.getName() + " add arkuz.givevip");
				return true;
			}
			if (permissions.equalsIgnoreCase("givekit")) {
				p.sendMessage("§eA Permissão de DAR KITS Foi dada do Jogador " + jogador.getName());
				Bukkit.dispatchCommand((CommandSender) Bukkit.getConsoleSender(),
						"pex user " + jogador.getName() + " add arkuz.givekit");
				return true;
			}
			if (permissions.equalsIgnoreCase("sortearkit")) {
				p.sendMessage("§eA Permissão de SORTEAR KITS foi dada ao jogador " + jogador.getName());
				Bukkit.dispatchCommand((CommandSender) Bukkit.getConsoleSender(),
						"pex user " + jogador.getName() + " add arkuz.sortearkit");
				return true;
			}
			if (permissions.equalsIgnoreCase("sortearvip")) {
				p.sendMessage("§eA Permissão de SORTEAR VIPS Foi dada do jogador " + jogador.getName());
				Bukkit.dispatchCommand((CommandSender) Bukkit.getConsoleSender(),
						"pex user " + jogador.getName() + " add arkuz.sortearvip");
				return true;
			}
		}
		return false;
	}
}
