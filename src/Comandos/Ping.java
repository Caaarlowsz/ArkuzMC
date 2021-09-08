package Comandos;

import org.bukkit.ChatColor;
import org.bukkit.Bukkit;
import Main.Main;
import org.bukkit.craftbukkit.v1_7_R4.entity.CraftPlayer;
import org.bukkit.entity.Player;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.event.Listener;
import org.bukkit.command.CommandExecutor;

public class Ping implements CommandExecutor, Listener
{
    public boolean onCommand(final CommandSender sender, final Command command, final String c, final String[] args) {
        if (sender instanceof Player) {
            final Player p = (Player)sender;
            final int ping = ((CraftPlayer)p).getHandle().ping;
            if (c.equalsIgnoreCase("ping")) {
                if (args.length == 0) {
                    p.sendMessage(String.valueOf(Main.prefix) + " §4\u27bc §7Seu Ping e de: §c" + ping + " §7Ms");
                }
                else if (p.getServer().getPlayer(args[0]) != null) {
                    final String player2 = args[0];
                    final Player target = Bukkit.getServer().getPlayer(args[0]);
                    final int ping2 = ((CraftPlayer)target).getHandle().ping;
                    p.sendMessage(String.valueOf(Main.prefix) + " §4\u27bc §7O Player: §c" + player2 + " §7Tem Um Ping De: §c" + ChatColor.WHITE + ping2 + ChatColor.GREEN + " ms!");
                }
                else {
                    final String player2 = args[0];
                    p.sendMessage(String.valueOf(player2) + " Nao esta Online!");
                }
            }
        }
        return false;
    }
}
