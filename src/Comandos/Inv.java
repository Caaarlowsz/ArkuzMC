package Comandos;

import com.github.caaarlowsz.arkuzmc.kitpvp.ArkuzPvP;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.inventory.Inventory;

public class Inv implements Listener, CommandExecutor {
	public boolean onCommand(final CommandSender sender, final Command cmd, final String Label, final String[] args) {
		if (!(sender instanceof Player)) {
			sender.sendMessage("[Apenas Players Podem Utilizar Isto]");
			return true;
		}
		final Player p = (Player) sender;
		if (cmd.getName().equalsIgnoreCase("inv")) {
			if (sender.hasPermission("arkuz.inv")) {
				sender.sendMessage(String.valueOf(ArkuzPvP.prefix) + " §4➼ §7Use: /Inv {Player}");
				if (args.length > 0) {
					final Player player = Bukkit.getPlayer(args[0]);
					if (player == null) {
						sender.sendMessage(String.valueOf(ArkuzPvP.prefix)
								+ " §4➼ §7Este Player Não Está Conectado Ao Servidor");
						return true;
					}
					sender.sendMessage(String.valueOf(ArkuzPvP.prefix) + " §4➼ §7Inventario Aberto Com Sucesso");
					p.openInventory((Inventory) player.getInventory());
				}
			} else {
				p.sendMessage(String.valueOf(ArkuzPvP.prefix) + " §4➼ §7Sem Permissão");
			}
			return true;
		}
		return true;
	}
}
