package Comandos;

import org.bukkit.entity.Player;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.event.Listener;
import org.bukkit.command.CommandExecutor;

public class Rank implements CommandExecutor, Listener
{
    public boolean onCommand(final CommandSender sender, final Command cmd, final String label, final String[] args) {
        final Player jogador = (Player)sender;
        if (label.equalsIgnoreCase("rank")) {
            jogador.sendMessage("§4§lLENDARIO §7(§4\u272a§7) §a500+ Kills");
            jogador.sendMessage("§3§lSAFIRA §7(§c\u2730§7) §a450-500 Kills");
            jogador.sendMessage("§C§lRUBY §7(§5\u2739§7) §a400-450 Kills");
            jogador.sendMessage("§2§lEMERALD §7(§6\u2738§7) §a350-400 Kills");
            jogador.sendMessage("§B§lDIAMOND §7(§7\u2734§7) §a300-350 Kills");
            jogador.sendMessage("§6§lGOLD §7(§e\u2637§7) §a250-300 Kills");
            jogador.sendMessage("§7§lSILVER §7(§e\u2633§7) §a200-250 Kills");
            jogador.sendMessage("§1§lEXPERT §7(§e\u2631§7) §a150-200 Kills");
            jogador.sendMessage("§a§lAPRENDIZ §7(§a\u2630§7) §a100-150 Kills");
            jogador.sendMessage("§a§lINICIANTE §7(§f=§7) §a50-100 Kills");
            jogador.sendMessage("§7§lSem rank §7(§f-§7) §a- de 50 Kills");
        }
        return false;
    }
}
