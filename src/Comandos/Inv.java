package Comandos;

import org.bukkit.inventory.Inventory;
import org.bukkit.Bukkit;
import Main.Main;
import org.bukkit.entity.Player;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.CommandExecutor;
import org.bukkit.event.Listener;

public class Inv implements Listener, CommandExecutor
{
    public boolean onCommand(final CommandSender sender, final Command cmd, final String Label, final String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage("[Apenas Players Podem Utilizar Isto]");
            return true;
        }
        final Player p = (Player)sender;
        if (cmd.getName().equalsIgnoreCase("inv")) {
            if (sender.hasPermission("arkuz.inv")) {
                sender.sendMessage(String.valueOf(Main.prefix) + " §4\u27bc §7Use: /Inv {Player}");
                if (args.length > 0) {
                    final Player player = Bukkit.getPlayer(args[0]);
                    if (player == null) {
                        sender.sendMessage(String.valueOf(Main.prefix) + " §4\u27bc §7Este Player N\u00e3o Est\u00e1 Conectado Ao Servidor");
                        return true;
                    }
                    sender.sendMessage(String.valueOf(Main.prefix) + " §4\u27bc §7Inventario Aberto Com Sucesso");
                    p.openInventory((Inventory)player.getInventory());
                }
            }
            else {
                p.sendMessage(String.valueOf(Main.prefix) + " §4\u27bc §7Sem Permiss\u00e3o");
            }
            return true;
        }
        return true;
    }
}
