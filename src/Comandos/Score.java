package Comandos;

import com.github.caaarlowsz.arkuzmc.kitpvp.ArkuzPvP;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;

public class Score implements CommandExecutor, Listener {
	public boolean onCommand(final CommandSender sender, final Command cmd, final String label, final String[] args) {
		if (!(sender instanceof Player)) {
			sender.sendMessage("Comando de Jogador!");
			return true;
		}
		final Player p = (Player) sender;
		if (ArkuzPvP.score.contains(p.getName())) {
			ArkuzPvP.score.remove(p.getName());
			p.sendMessage(String.valueOf(ArkuzPvP.prefix) + " §4➼ §7ScoreBoard Ativada");
		} else {
			ArkuzPvP.score.add(p.getName());
			p.sendMessage(String.valueOf(ArkuzPvP.prefix) + " §4➼ §7ScoreBoard Desativada");
		}
		return false;
	}
}
