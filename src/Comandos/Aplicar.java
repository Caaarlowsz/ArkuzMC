package Comandos;

import com.github.caaarlowsz.arkuzmc.kitpvp.ArkuzPvP;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;

public class Aplicar implements CommandExecutor, Listener {
    public boolean onCommand(final CommandSender Sender, final Command cmd, final String string, final String[] args) {
        final Player p = (Player) Sender;
        if (cmd.getName().equalsIgnoreCase("aplicar")) {
            p.sendMessage("§7 ");
            p.sendMessage("§7                §4§lAPLICAR§7                ");
            p.sendMessage(String.valueOf(ArkuzPvP.prefix) + " §4➼ §7Não mande mais de 1 vez o formulário !");
            p.sendMessage(String.valueOf(ArkuzPvP.prefix) + " §4➼ §7Link: " + ArkuzPvP.form);
            p.sendMessage(
                    String.valueOf(ArkuzPvP.prefix) + " §4➼ §7Pedir Para Ler o Form Resulta Em Reprovação");
            p.sendMessage("§7                §4§lAPLICAR§7                ");
            p.sendMessage("§7   ");
        }
        return false;
    }
}
