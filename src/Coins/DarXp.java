package Coins;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;

import Main.Main;

public class DarXp implements CommandExecutor, Listener {
	public static boolean isNumeric(final String str) {
		try {
			Integer.parseInt(str);
		} catch (NumberFormatException nfe) {
			return false;
		}
		return true;
	}

	public boolean onCommand(final CommandSender sender, final Command cmd, final String label, final String[] args) {
		final Player p = (Player) sender;
		if (cmd.getName().equalsIgnoreCase("gratis")) {
			if (!p.hasPermission("arkuz.gratis")) {
				p.sendMessage(String.valueOf(Main.prefix) + " §4\u27bc §7Sem Permiss\u00e3o");
			} else {
				if (args.length == 0) {
					sender.sendMessage(String.valueOf(Main.prefix) + " §4\u27bc §7Use: /Gratis {Player} {Quantidade}");
					return true;
				}
				final Player target = Bukkit.getPlayerExact(args[0]);
				if (target == null || !(target instanceof Player)) {
					sender.sendMessage(String.valueOf(Main.prefix)
							+ " §4\u27bc §7Esse Player N\u00e3o Est\u00e1 Conectado Ao Servidor");
					return true;
				}
				if (isNumeric(args[1])) {
					final int coins = Integer.parseInt(args[1]);
					XpM.addMoney(target, coins);
					p.sendMessage(String.valueOf(Main.prefix) + " §4\u27bc §7Voc\u00ea Deu Ao Jogador §c"
							+ target.getName() + " §4" + coins + " §7MP");
					target.sendMessage(String.valueOf(Main.prefix) + " §4\u27bc §7Voc\u00ea Recebeu Do Jogador §c"
							+ p.getName() + " §4" + coins + " §7MP");
				}
			}
		}
		return false;
	}
}
