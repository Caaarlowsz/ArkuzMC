package Comandos;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;

public class Regras implements Listener, CommandExecutor {
	public boolean onCommand(final CommandSender sender, final Command cmd, final String label, final String[] args) {
		final Player p = (Player) sender;
		cmd.getName().equalsIgnoreCase("regras");
		p.sendMessage("§c----------------------------------------------");
		p.sendMessage("    §4§lREGRAS:    ");
		p.sendMessage("§c➼ Nao usar hack, macro, ou autoclick!");
		p.sendMessage("§c➼ Nao abusar de bugs");
		p.sendMessage("§c➼ Nao testar staff!");
		p.sendMessage("§c➼ Nao ofender staff");
		p.sendMessage("§c➼ Nao ofender jogadores");
		p.sendMessage("§c➼ Nao ofender o servidor");
		p.sendMessage("§c➼ Nao dilvugar outro servidor");
		p.sendMessage("§c➼ Nao abuse do report!");
		p.sendMessage("§c----------------------------------------------");
		return false;
	}
}
