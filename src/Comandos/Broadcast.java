package Comandos;

import com.github.caaarlowsz.arkuzmc.kitpvp.ArkuzKitPvP;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.event.Listener;

public class Broadcast implements CommandExecutor, Listener {
	public boolean onCommand(final CommandSender sender, final Command cmd, final String label, final String[] args) {
		if (cmd.getName().equalsIgnoreCase("broadcast") || cmd.getName().equalsIgnoreCase("bc")) {
			if (sender.hasPermission("arkuz.bc")) {
				if (args.length == 0) {
					sender.sendMessage(String.valueOf(ArkuzKitPvP.prefix) + " §4➼ §7Use: /aviso {Menssagem}");
					return true;
				}
				String msg = "";
				for (final String msg2 : args) {
					msg = String.valueOf(String.valueOf(String.valueOf(msg))) + msg2 + " ";
				}
				Bukkit.broadcastMessage(" ");
				Bukkit.broadcastMessage(" ");
				Bukkit.broadcastMessage(String.valueOf(ArkuzKitPvP.prefix) + " §4➼ §7" + msg.replace("&", "§"));
				Bukkit.broadcastMessage(" ");
				Bukkit.broadcastMessage(" ");
				return true;
			} else {
				sender.sendMessage(String.valueOf(ArkuzKitPvP.prefix) + " §4➼ §7Sem Permissão");
			}
		}
		return false;
	}
}
