package Comandos;

import org.bukkit.Location;
import Main.Main;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.event.Listener;
import org.bukkit.command.CommandExecutor;

public class Teleport implements CommandExecutor, Listener
{
    public boolean onCommand(final CommandSender sender, final Command cmd, final String label, final String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage("[Apenas Players Podem Utilizar Isto]");
            return true;
        }
        if (cmd.getName().equalsIgnoreCase("teleport")) {
            if (sender instanceof ConsoleCommandSender) {
                System.out.println("§cN\u00e3o");
                return true;
            }
            final Player p = (Player)sender;
            if (args.length == 0) {
                p.sendMessage(String.valueOf(Main.prefix) + " §4\u27bc §7Use: /tp {Player}");
            }
            else if (args.length == 1) {
                if (p.hasPermission("arkuz.teleport") || p.isOp()) {
                    final Player targetPlayer = p.getServer().getPlayer(args[0]);
                    final Location tpLoc = targetPlayer.getLocation();
                    p.teleport(tpLoc);
                    p.sendMessage(String.valueOf(Main.prefix) + " §4\u27bc §7Voc\u00ea Foi Teleportado Para: §c" + targetPlayer.getDisplayName());
                }
                else {
                    p.sendMessage(String.valueOf(Main.prefix) + " §4\u27bc §7Sem Permiss\u00e3o");
                }
            }
            else if (args.length == 2) {
                if (p.hasPermission("arkuz.teleport") || p.isOp()) {
                    final Player targetPlayer = p.getServer().getPlayer(args[0]);
                    final Player targetPlayer2 = p.getServer().getPlayer(args[1]);
                    if (targetPlayer == null || targetPlayer2 == null) {
                        p.sendMessage(String.valueOf(Main.prefix) + " §4\u27bc §7Este Player N\u00e3o Est\u00e1 Conectado Ao Servidor");
                    }
                    else {
                        final Location tpLoc2 = targetPlayer2.getLocation();
                        targetPlayer.teleport(tpLoc2);
                        p.sendMessage(String.valueOf(Main.prefix) + " §4\u27bc §c" + targetPlayer.getDisplayName() + " §7Foi Teleportado Para §c" + targetPlayer2.getDisplayName());
                    }
                }
                else {
                    p.sendMessage(String.valueOf(Main.prefix) + " §4\u27bc §7Este Player N\u00e3o Est\u00e1 Conectado Ao Servidor");
                }
            }
        }
        return false;
    }
}
