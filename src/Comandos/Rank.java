package Comandos;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;

public class Rank implements CommandExecutor, Listener {
	public boolean onCommand(final CommandSender sender, final Command cmd, final String label, final String[] args) {
		final Player jogador = (Player) sender;
		if (label.equalsIgnoreCase("rank")) {
			jogador.sendMessage("§4§lLENDARIO §7(§4❂§7) §a500+ Kills");
			jogador.sendMessage("§3§lSAFIRA §7(§3✷§7) §a450-500 Kills");
			jogador.sendMessage("§C§lRUBY §7(§c✦§7) §a400-450 Kills");
			jogador.sendMessage("§2§lEMERALD §7(§2✸§7) §a350-400 Kills");
			jogador.sendMessage("§B§lDIAMOND §7(§b❈§7) §a300-350 Kills");
			jogador.sendMessage("§6§lGOLD §7(§6✪§7) §a250-300 Kills");
			jogador.sendMessage("§7§lSILVER §7(§7✯§7) §a200-250 Kills");
			jogador.sendMessage("§1§lEXPERT §7(§1✥§7) §a150-200 Kills");
			jogador.sendMessage("§e§lAPRENDIZ §7(§e✿§7) §a100-150 Kills");
			jogador.sendMessage("§a§lINICIANTE §7(§a✾§7) §a50-100 Kills");
			jogador.sendMessage("§7§lSem rank §7(§f-§7) §a- de 50 Kills");
		}
		return false;
	}
}
