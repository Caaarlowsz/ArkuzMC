package Comandos;

import com.github.caaarlowsz.arkuzmc.kitpvp.ArkuzKitPvP;
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
		if (ArkuzKitPvP.score.contains(p.getName())) {
			ArkuzKitPvP.score.remove(p.getName());
			p.sendMessage(String.valueOf(ArkuzKitPvP.prefix) + " §4➼ §7ScoreBoard Ativada");
		} else {
			ArkuzKitPvP.score.add(p.getName());
			p.sendMessage(String.valueOf(ArkuzKitPvP.prefix) + " §4➼ §7ScoreBoard Desativada");
		}
		return false;
	}
}
