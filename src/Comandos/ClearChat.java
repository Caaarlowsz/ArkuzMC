package Comandos;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;

import Main.Main;

public class ClearChat implements CommandExecutor, Listener {
	public ClearChat(final Main main) {
	}

	public boolean onCommand(final CommandSender sender, final Command cmd, final String commandLabel,
			final String[] args) {
		if (!(sender instanceof Player)) {
			sender.sendMessage("[Apenas Players Podem Utilizar Isto]");
			return false;
		}
		final Player p = (Player) sender;
		if (commandLabel.equalsIgnoreCase("cc") || cmd.getName().equalsIgnoreCase("clearchat")) {
			if (p.hasPermission("arkuz.cc")) {
				Bukkit.getServer().broadcastMessage("");
				Bukkit.getServer().broadcastMessage("");
				Bukkit.getServer().broadcastMessage("");
				Bukkit.getServer().broadcastMessage("");
				Bukkit.getServer().broadcastMessage("");
				Bukkit.getServer().broadcastMessage("");
				Bukkit.getServer().broadcastMessage("");
				Bukkit.getServer().broadcastMessage("");
				Bukkit.getServer().broadcastMessage("");
				Bukkit.getServer().broadcastMessage("");
				Bukkit.getServer().broadcastMessage("");
				Bukkit.getServer().broadcastMessage("");
				Bukkit.getServer().broadcastMessage("");
				Bukkit.getServer().broadcastMessage("");
				Bukkit.getServer().broadcastMessage("");
				Bukkit.getServer().broadcastMessage("");
				Bukkit.getServer().broadcastMessage("");
				Bukkit.getServer().broadcastMessage("");
				Bukkit.getServer().broadcastMessage("");
				Bukkit.getServer().broadcastMessage("");
				Bukkit.getServer().broadcastMessage("");
				Bukkit.getServer().broadcastMessage("");
				Bukkit.getServer().broadcastMessage("");
				Bukkit.getServer().broadcastMessage("");
				Bukkit.getServer().broadcastMessage("");
				Bukkit.getServer().broadcastMessage("");
				Bukkit.getServer().broadcastMessage("");
				Bukkit.getServer().broadcastMessage("");
				Bukkit.getServer().broadcastMessage("");
				Bukkit.getServer().broadcastMessage("");
				Bukkit.getServer().broadcastMessage("");
				Bukkit.getServer().broadcastMessage("");
				Bukkit.getServer().broadcastMessage("");
				Bukkit.getServer().broadcastMessage("");
				Bukkit.getServer().broadcastMessage("");
				Bukkit.getServer().broadcastMessage("");
				Bukkit.getServer().broadcastMessage("");
				Bukkit.getServer().broadcastMessage("");
				Bukkit.getServer().broadcastMessage("");
				Bukkit.getServer().broadcastMessage("");
				Bukkit.getServer().broadcastMessage("");
				Bukkit.getServer().broadcastMessage("");
				Bukkit.getServer().broadcastMessage("");
				Bukkit.getServer().broadcastMessage("");
				Bukkit.getServer().broadcastMessage("");
				Bukkit.getServer().broadcastMessage("");
				Bukkit.getServer().broadcastMessage("");
				Bukkit.getServer().broadcastMessage("");
				Bukkit.getServer().broadcastMessage("");
				Bukkit.getServer().broadcastMessage("");
				Bukkit.getServer().broadcastMessage("");
				Bukkit.getServer().broadcastMessage("");
				Bukkit.getServer().broadcastMessage("");
				Bukkit.getServer().broadcastMessage("");
				Bukkit.getServer().broadcastMessage("");
				Bukkit.getServer().broadcastMessage("");
				Bukkit.getServer().broadcastMessage("");
				Bukkit.getServer().broadcastMessage("");
				Bukkit.getServer().broadcastMessage("");
				Bukkit.getServer().broadcastMessage("");
				Bukkit.getServer().broadcastMessage("");
				Bukkit.getServer().broadcastMessage("");
				Bukkit.getServer().broadcastMessage("");
				Bukkit.getServer().broadcastMessage("");
				Bukkit.getServer().broadcastMessage("");
				Bukkit.getServer().broadcastMessage("");
				Bukkit.getServer().broadcastMessage("");
				Bukkit.getServer().broadcastMessage("");
				Bukkit.getServer().broadcastMessage("");
				Bukkit.getServer().broadcastMessage("");
				Bukkit.getServer().broadcastMessage("");
				Bukkit.getServer().broadcastMessage("");
				Bukkit.getServer().broadcastMessage("");
				Bukkit.getServer().broadcastMessage("");
				Bukkit.getServer().broadcastMessage("");
				Bukkit.getServer().broadcastMessage("");
				Bukkit.getServer().broadcastMessage("");
				Bukkit.getServer().broadcastMessage("");
				Bukkit.getServer().broadcastMessage("");
				Bukkit.getServer().broadcastMessage("");
				Bukkit.getServer().broadcastMessage("");
				Bukkit.getServer().broadcastMessage("");
				Bukkit.getServer().broadcastMessage("");
				Bukkit.getServer().broadcastMessage("");
				Bukkit.getServer().broadcastMessage("");
				Bukkit.getServer().broadcastMessage("");
				Bukkit.getServer().broadcastMessage("");
				Bukkit.getServer().broadcastMessage("");
				Bukkit.getServer().broadcastMessage("");
				Bukkit.getServer().broadcastMessage("");
				Bukkit.getServer().broadcastMessage("");
				Bukkit.getServer().broadcastMessage("");
				Bukkit.getServer().broadcastMessage("");
				Bukkit.getServer().broadcastMessage("");
				Bukkit.getServer().broadcastMessage("");
				Bukkit.getServer().broadcastMessage("");
				Bukkit.getServer().broadcastMessage("");
				Bukkit.getServer().broadcastMessage("");
				Bukkit.getServer().broadcastMessage("");
				Bukkit.getServer().broadcastMessage("");
				Bukkit.getServer().broadcastMessage("");
				Bukkit.getServer().broadcastMessage("");
				Bukkit.getServer().broadcastMessage("");
				Bukkit.getServer().broadcastMessage("");
				Bukkit.getServer().broadcastMessage("");
				Bukkit.getServer().broadcastMessage("");
				Bukkit.getServer().broadcastMessage("");
				Bukkit.getServer().broadcastMessage("");
				Bukkit.getServer().broadcastMessage("");
				Bukkit.getServer().broadcastMessage("");
				Bukkit.getServer().broadcastMessage("");
				Bukkit.getServer().broadcastMessage("");
				Bukkit.getServer().broadcastMessage("");
				Bukkit.getServer().broadcastMessage("");
				Bukkit.getServer().broadcastMessage("");
				Bukkit.getServer().broadcastMessage("");
				Bukkit.getServer().broadcastMessage("");
				Bukkit.getServer().broadcastMessage("");
				Bukkit.getServer().broadcastMessage(String.valueOf(Main.prefix) + " §4\u27bc §7Chat Limpo");
			}
			return false;
		}
		return false;
	}
}
