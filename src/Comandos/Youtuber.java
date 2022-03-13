package Comandos;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;

public class Youtuber implements CommandExecutor, Listener {
	public boolean onCommand(final CommandSender Sender, final Command cmd, final String string, final String[] args) {
		final Player p = (Player) Sender;
		if (cmd.getName().equalsIgnoreCase("youtuber")) {
			p.sendMessage("  ");
			p.sendMessage("        §3§lYouTuber+        ");
			p.sendMessage("  ");
			p.sendMessage("§b§ Vídeo No Servidor");
			p.sendMessage("§b§ 1000 Inscritos");
			p.sendMessage("§b§ 500 visualizações");
			p.sendMessage("  ");
			p.sendMessage("        §b§lYou§f§lTuber        ");
			p.sendMessage("  ");
			p.sendMessage("§b§ Vídeo No Servidor");
			p.sendMessage("§b§ 300 Inscritos");
			p.sendMessage("§b§ 150 visualizações");
			p.sendMessage("  ");
			p.sendMessage("  ");
			p.sendMessage("          §6§lPro                   ");
			p.sendMessage("  ");
			p.sendMessage("§f§ Video no servidor   ");
			p.sendMessage("§6§ 50 Inscritos");
			p.sendMessage("§f§ 100 visualizações");
		}
		return false;
	}
}
