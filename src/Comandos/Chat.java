package Comandos;

import org.bukkit.event.EventHandler;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import Main.Main;
import org.bukkit.event.Listener;
import org.bukkit.command.CommandExecutor;

public class Chat implements CommandExecutor, Listener
{
    public static boolean c;
    
    static {
        Chat.c = false;
    }
    
    public Chat(final Main main) {
    }
    
    public boolean onCommand(final CommandSender Sender, final Command Cmd, final String Label, final String[] Args) {
        final Player p = (Player)Sender;
        if (Cmd.getName().equalsIgnoreCase("chat")) {
            if (!p.hasPermission("arkuz.chat")) {
                p.sendMessage(String.valueOf(Main.prefix) + " §4\u27bc §7Sem Permiss\u00e3o");
                return true;
            }
            if (Args.length == 0) {
                p.sendMessage(String.valueOf(Main.prefix) + " §4\u27bc §7Use: /Chat {Mutar|Desmutar}");
                return true;
            }
            if (Args[0].equalsIgnoreCase("mutar")) {
                Chat.c = true;
                Bukkit.broadcastMessage(String.valueOf(Main.prefix) + " §4\u27bc §7O Chat Foi §4MUTADO");
            }
            if (Args[0].equalsIgnoreCase("desmutar")) {
                Chat.c = false;
                Bukkit.broadcastMessage(String.valueOf(Main.prefix) + " §4\u27bc §7O Chat Foi §cDESMUTADO");
            }
        }
        return false;
    }
    
    @EventHandler
    public void naoFalarNoChatQuandoTiverOFF(final AsyncPlayerChatEvent e) {
        final Player p = e.getPlayer();
        if (!p.hasPermission("sword.chat") && Chat.c) {
            e.setCancelled(true);
            p.sendMessage(String.valueOf(Main.prefix) + " §4\u27bc §7N\u00e3o \u00e9 Possivel Falar Com o Chat Mutado");
        }
    }
}
