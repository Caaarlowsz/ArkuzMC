package Coins;

import com.github.caaarlowsz.arkuzmc.kitpvp.ArkuzPvP;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;

public class VerXp implements Listener, CommandExecutor {
	public boolean onCommand(final CommandSender sender, final Command cmd, final String comando, final String[] args) {
		final Player p = (Player) sender;
		if (comando.equalsIgnoreCase("mp")) {
			p.sendMessage(
					String.valueOf(ArkuzPvP.prefix) + " §4➼ §7Você Possui §c" + XpM.getPlayerMoney(p) + " §7XP");
		}
		return false;
	}
}
