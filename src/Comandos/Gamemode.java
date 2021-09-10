package Comandos;

import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;

import Main.Main;

public class Gamemode implements CommandExecutor, Listener {
	public Gamemode(final Main main) {
	}

	public boolean onCommand(final CommandSender sender, final Command cmd, final String label, final String[] args) {
		if (cmd.getName().equalsIgnoreCase("gm") || cmd.getName().equalsIgnoreCase("gamemode")) {
			if (sender instanceof ConsoleCommandSender) {
				System.out.println("[Apenas Players Podem Utilizar Isto]");
				return true;
			}
			final Player p = (Player) sender;
			if (args.length == 0) {
				p.sendMessage(String.valueOf(Main.prefix) + " §4\u27bc §7Use: /Gm {1/0}");
			} else if (args.length == 1) {
				if (p.hasPermission("arkuz.gm") || p.isOp()) {
					if (args[0].equalsIgnoreCase("1") || args[0].equalsIgnoreCase("criativo")) {
						p.setGameMode(GameMode.CREATIVE);
						p.sendMessage(String.valueOf(Main.prefix) + " §4\u27bc §7Modo De Jogo Atualizado");
					} else if (args[0].equalsIgnoreCase("0") || args[0].equalsIgnoreCase("sobrevivencia")) {
						p.setGameMode(GameMode.SURVIVAL);
						p.sendMessage(String.valueOf(Main.prefix) + " §4\u27bc §7Modo De Jogo Atualizado");
					} else {
						p.sendMessage(String.valueOf(Main.prefix) + " §4\u27bc §7Use: /Gm {1/0}");
					}
				} else {
					p.sendMessage(String.valueOf(Main.prefix) + " §4\u27bc §7Sem Permiss\u00e3o");
				}
			}
		}
		return false;
	}
}
