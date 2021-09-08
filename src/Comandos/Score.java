package Comandos;

import Main.Main;
import org.bukkit.entity.Player;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.event.Listener;
import org.bukkit.command.CommandExecutor;

public class Score implements CommandExecutor, Listener
{
    public boolean onCommand(final CommandSender sender, final Command cmd, final String label, final String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage("Comando de Jogador!");
            return true;
        }
        final Player p = (Player)sender;
        if (Main.score.contains(p.getName())) {
            Main.score.remove(p.getName());
            p.sendMessage(String.valueOf(Main.prefix) + " §4\u27bc §7ScoreBoard Ativada");
        }
        else {
            Main.score.add(p.getName());
            p.sendMessage(String.valueOf(Main.prefix) + " §4\u27bc §7ScoreBoard Desativada");
        }
        return false;
    }
}
