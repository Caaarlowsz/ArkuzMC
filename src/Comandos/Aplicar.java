package Comandos;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;

import Main.Main;

public class Aplicar implements CommandExecutor, Listener {
	public boolean onCommand(final CommandSender Sender, final Command cmd, final String string, final String[] args) {
		final Player p = (Player) Sender;
		if (cmd.getName().equalsIgnoreCase("aplicar")) {
			p.sendMessage("§7 ");
			p.sendMessage("§7                §4§lAPLICAR§7                ");
			p.sendMessage(String.valueOf(Main.prefix) + " §4\u27bc §7N\u00e3o mande mais de 1 vez o formul\u00e1rio !");
			p.sendMessage(String.valueOf(Main.prefix) + " §4\u27bc §7Link: " + Main.form);
			p.sendMessage(
					String.valueOf(Main.prefix) + " §4\u27bc §7Pedir Para Ler o Form Resulta Em Reprova\u00e7\u00e3o");
			p.sendMessage("§7                §4§lAPLICAR§7                ");
			p.sendMessage("§7   ");
		}
		return false;
	}
}
