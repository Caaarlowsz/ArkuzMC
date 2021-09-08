package Comandos;

import Main.Main;
import org.bukkit.entity.Player;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.CommandExecutor;
import org.bukkit.event.Listener;

public class Suicide implements Listener, CommandExecutor
{
    public boolean onCommand(final CommandSender sender, final Command cmd, final String label, final String[] args) {
        final Player p = (Player)sender;
        if (cmd.getName().equalsIgnoreCase("suicide")) {
            p.setHealth(0.0);
            p.sendMessage(String.valueOf(Main.prefix) + " §4\u27bc §7Voc\u00ea Morreu");
        }
        return false;
    }
}
