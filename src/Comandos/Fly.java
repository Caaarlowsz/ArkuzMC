package Comandos;

import com.github.caaarlowsz.arkuzmc.kitpvp.ArkuzPvP;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;

import Eventos.TheTitle;

public class Fly implements CommandExecutor, Listener {
	public boolean onCommand(final CommandSender sender, final Command cmd, final String label, final String[] args) {
		if (!(sender instanceof Player)) {
			sender.sendMessage("[Apenas Players Podem Utilizar Isto]");
			return true;
		}
		if (cmd.getName().equalsIgnoreCase("fly")) {
			final Player p = (Player) sender;
			if (args.length == 0) {
				if (p.hasPermission("arkuz.fly")) {
					if (!p.getAllowFlight()) {
						p.sendMessage(String.valueOf(ArkuzPvP.prefix) + " §4➼ §7Você Habilitou o Modo Fly");
						TheTitle.sendTitle(p, "§a§lFLY");
						TheTitle.sendSubTitle(p, "§a§lATIVADO");
						p.setAllowFlight(true);
					} else {
						p.sendMessage(String.valueOf(ArkuzPvP.prefix) + " §4➼ §7Você Desabilitou o Modo Fly");
						TheTitle.sendTitle(p, "§c§lFLY");
						TheTitle.sendSubTitle(p, "§C§lDESATIVADO");
						p.setAllowFlight(false);
					}
				} else {
					p.sendMessage(String.valueOf(ArkuzPvP.prefix) + " §4➼ §7Sem Permissão");
				}
				if (args.length == 1) {
					if (sender.hasPermission("sword.fly")) {
						final Player k = Bukkit.getPlayer(args[0]);
						if (k == null) {
							sender.sendMessage(String.valueOf(ArkuzPvP.prefix)
									+ " §4➼ §7Este Player Não Está Conectado No Servidor");
							return true;
						}
						if (!p.getAllowFlight()) {
							p.sendMessage(String.valueOf(ArkuzPvP.prefix) + " §4➼ §7Você Habilitou o Fly Para §c"
									+ k.getName());
							k.setAllowFlight(true);
							k.sendMessage(String.valueOf(ArkuzPvP.prefix) + " §4➼ §7Seu Fly Foi Habilitado Por §c"
									+ p.getName());
						} else {
							p.sendMessage(String.valueOf(ArkuzPvP.prefix)
									+ " §4➼ §7Você Desabilitou o Fly Para §c" + k.getName());
							k.setAllowFlight(false);
							k.sendMessage(String.valueOf(ArkuzPvP.prefix) + " §4➼ §7Seu Fly Foi Desabilitado Por §c"
									+ p.getName());
						}
					} else {
						p.sendMessage(String.valueOf(ArkuzPvP.prefix) + " §4➼ §7Sem Permissaão");
					}
				}
			}
		}
		return false;
	}
}
