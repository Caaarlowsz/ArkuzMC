package Coins;

import Main.Main;
import org.bukkit.entity.Player;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.CommandExecutor;
import org.bukkit.event.Listener;

public class VerXp implements Listener, CommandExecutor
{
    public boolean onCommand(final CommandSender sender, final Command cmd, final String comando, final String[] args) {
        final Player p = (Player)sender;
        if (comando.equalsIgnoreCase("mp")) {
            p.sendMessage(String.valueOf(Main.prefix) + " §4\u27bc §7Voc\u00ea Possui §c" + XpM.getPlayerMoney(p) + " §7XP");
        }
        return false;
    }
}
