package Comandos;

import com.github.caaarlowsz.arkuzmc.kitpvp.ArkuzKitPvP;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.HashMap;

public class Tell implements CommandExecutor {
	public static HashMap<Player, Player> gettell;
	static ArrayList<Player> telloff;

	static {
		Tell.gettell = new HashMap<Player, Player>();
		Tell.telloff = new ArrayList<Player>();
	}

	public boolean onCommand(final CommandSender sender, final Command cmd, final String label, final String[] args) {
		final Player p = (Player) sender;
		if (label.equalsIgnoreCase("tell")) {
			if (args.length == 0) {
				p.sendMessage(String.valueOf(ArkuzKitPvP.prefix) + " §4➼ §7Utilize: /Tell §c{Nick} {Msg}");
				return true;
			}
			final Player target = Bukkit.getPlayer(args[0]);
			if (args[0].toLowerCase().equalsIgnoreCase("on")) {
				Tell.telloff.remove(p);
				p.sendMessage(String.valueOf(ArkuzKitPvP.prefix) + " §4➼ §7Tell §c§nATIVADO");
			} else if (args[0].toLowerCase().equalsIgnoreCase("off")) {
				Tell.telloff.add(p);
				p.sendMessage(String.valueOf(ArkuzKitPvP.prefix) + " §4➼ §7Tell §4§nDESATIVADO");
			}
			if (args.length > 1) {
				if (target == null) {
					p.sendMessage(String.valueOf(ArkuzKitPvP.prefix) + " §4➼ §7Este Jogador Não Se Encontra Online");
					return true;
				}
				if (Tell.telloff.contains(target)) {
					p.sendMessage(
							String.valueOf(ArkuzKitPvP.prefix) + " §4➼ §7O Tell Desse Jogador Se Encontra Desativado");
					return true;
				}
				final StringBuilder sb = new StringBuilder();
				for (int i = 1; i < args.length; ++i) {
					sb.append(args[i]).append(" ");
				}
				final String allArgs = sb.toString().trim();
				p.sendMessage("§cEu §4➼ §c" + target.getName() + " §7§ §f" + allArgs);
				target.sendMessage("§c" + p.getName() + " §4➼ §cEu §7§ §f" + allArgs);
				Tell.gettell.put(target, p);
			}
		} else if (label.equalsIgnoreCase("off")) {
			if (args.length == 0) {
				p.sendMessage(String.valueOf(ArkuzKitPvP.prefix) + " §4➼ §7Utilize o Chat Publico");
				return true;
			}
			if (!Tell.gettell.containsKey(p)) {
				p.sendMessage(String.valueOf(ArkuzKitPvP.prefix) + " §4➼ §7Não Há Ninguem Para Responder");
				return true;
			}
			final Player deslogo = Tell.gettell.get(p);
			if (deslogo == null) {
				p.sendMessage(String.valueOf(ArkuzKitPvP.prefix) + " §4➼ §7Este Jogador Não Se Encontra Online");
				return true;
			}
			if (Tell.telloff.contains(deslogo)) {
				p.sendMessage(String.valueOf(ArkuzKitPvP.prefix) + " §4➼ §7O Tell Desse Jogador Se Encontra Desativado");
				return true;
			}
			final StringBuilder sb = new StringBuilder();
			for (int i = 0; i < args.length; ++i) {
				sb.append(args[i]).append(" ");
			}
			final String allArgs = sb.toString().trim();
			p.sendMessage("§cEu §4➼ §c" + deslogo.getName() + " §7§ §f" + allArgs);
			deslogo.sendMessage("§c" + p.getName() + " §4➼ §cEu §7§ §f" + allArgs);
		}
		return false;
	}
}
