package Comandos;

import org.bukkit.entity.Player;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.event.Listener;
import org.bukkit.command.CommandExecutor;

public class Youtuber implements CommandExecutor, Listener
{
    public boolean onCommand(final CommandSender Sender, final Command cmd, final String string, final String[] args) {
        final Player p = (Player)Sender;
        if (cmd.getName().equalsIgnoreCase("youtuber")) {
            p.sendMessage("  ");
            p.sendMessage("        §3§lYouTuber+        ");
            p.sendMessage("  ");
            p.sendMessage("§b» V\u00eddeo No Servidor");
            p.sendMessage("§b» 1000 Inscritos");
            p.sendMessage("§b» 500 visualiza\u00e7\u00f5es");
            p.sendMessage("  ");
            p.sendMessage("        §b§lYou§f§lTuber        ");
            p.sendMessage("  ");
            p.sendMessage("§b» V\u00eddeo No Servidor");
            p.sendMessage("§b» 300 Inscritos");
            p.sendMessage("§b» 150 visualiza\u00e7\u00f5es");
            p.sendMessage("  ");
            p.sendMessage("  ");
            p.sendMessage("          §6§lPro                   ");
            p.sendMessage("  ");
            p.sendMessage("§f» Video no servidor   ");
            p.sendMessage("§6» 50 Inscritos");
            p.sendMessage("§f» 100 visualiza\u00e7\u00f5es");
        }
        return false;
    }
}
