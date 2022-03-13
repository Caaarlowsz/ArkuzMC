package Comandos;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;

public class Tpall implements CommandExecutor, Listener {
	public boolean onCommand(final CommandSender Sender, final Command Cmd, final String Label, final String[] Args) {
		final Player p = (Player) Sender;
		if (!p.hasPermission("arkuz.tpall")) {
			p.sendMessage("§4➼ §7Sem Permissão");
			return true;
		}
		Player[] arrayOfPlayer;
		for (int j = (arrayOfPlayer = Bukkit.getOnlinePlayers()).length, i = 0; i < j; ++i) {
			final Player All = arrayOfPlayer[i];
			All.teleport((Entity) p);
			All.sendMessage("§aTodos os jogadores foram teleportados para " + p.getDisplayName());
		}
		return false;
	}
}
