package Comandos;

import org.bukkit.event.EventHandler;
import org.bukkit.event.player.PlayerLoginEvent;
import org.bukkit.Bukkit;
import Main.Main;
import org.bukkit.entity.Player;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.event.Listener;
import org.bukkit.command.CommandExecutor;

public class Manutencao implements CommandExecutor, Listener
{
    public static boolean manutencao;
    
    static {
        Manutencao.manutencao = false;
    }
    
    public boolean onCommand(final CommandSender sender, final Command cmd, final String label, final String[] args) {
        final Player p = (Player)sender;
        if (cmd.getName().equalsIgnoreCase("manutencao")) {
            if (!sender.hasPermission("arkuz.manutencao")) {
                sender.sendMessage(String.valueOf(Main.prefix) + "\u279c §7Desculpe, mas voc\u00ea n\u00e3o tem permiss\u00e3o para fazer isso.");
                return true;
            }
            if (args.length == 0) {
                p.sendMessage(String.valueOf(Main.prefix) + "\u279c §7Ops! Use isso De Maneira Correta: §f/manutencao <on/off>");
                return true;
            }
            if (args.length == 1) {
                if (args[0].equalsIgnoreCase("on")) {
                    if (Manutencao.manutencao) {
                        p.sendMessage(String.valueOf(Main.prefix) + "\u279c §cO Servidor j\u00e1 est\u00e1 em Manuten\u00e7\u00e3o!");
                        return true;
                    }
                    Bukkit.broadcastMessage(String.valueOf(Main.prefix) + "\u279c §eServidor entrando em Manuten\u00e7\u00e3o! Todos ser\u00e3o Kickados em §f5 Segundos!");
                    Manutencao.manutencao = true;
                    p.sendMessage(String.valueOf(Main.prefix) + "\u279c §aManuten\u00e7\u00e3o sendo Ativa...");
                    p.sendMessage(String.valueOf(Main.prefix) + "\u279c §aManuten\u00e7\u00e3o ativada com Sucesso!");
                    p.sendMessage(String.valueOf(Main.prefix) + "\u279c §a Voc\u00ea Ativou a Manuten\u00e7\u00e3o!");
                    Player[] onlinePlayers;
                    for (int length = (onlinePlayers = Bukkit.getOnlinePlayers()).length, i = 0; i < length; ++i) {
                        final Player todos = onlinePlayers[i];
                        if (!sender.hasPermission("ficar.manutencao")) {
                            todos.kickPlayer(String.valueOf(Main.prefix) + "\n" + "   §7§oDesculpe, mas o Servidor em que voce estava conectado foi §cFechado§7§o Para Manuten\u00e7\u00f5es!" + "\n" + "§7§oEstaremos de Volta Assim que Possivel!" + "\n" + "\n" + Main.loja + "\n" + "§7Atenciosamente, Equipe!" + Main.prefix);
                            return true;
                        }
                    }
                    return true;
                }
                else if (args[0].equalsIgnoreCase("off")) {
                    if (!Manutencao.manutencao) {
                        p.sendMessage(String.valueOf(Main.prefix) + "\u279c §cO Servidor N\u00e3o Est\u00e1 em Manuten\u00e7ao!");
                        return true;
                    }
                    Manutencao.manutencao = false;
                    p.sendMessage(String.valueOf(Main.prefix) + "\u279c §aManuten\u00e7\u00e3o Desativada!");
                    p.sendMessage(String.valueOf(Main.prefix) + "\u279c §eVoce desativou a Manuten\u00e7\u00e3o!");
                    return true;
                }
            }
        }
        return false;
    }
    
    @EventHandler
    public void aoEntrarManutencao(final PlayerLoginEvent e) {
        final Player p = e.getPlayer();
        if (Manutencao.manutencao && !p.hasPermission("sword.manutencao")) {
            e.disallow(PlayerLoginEvent.Result.KICK_OTHER, String.valueOf(Main.prefix) + "\n" + "   §7§oDesculpe, mas o Servidor em que voce estava conectado foi §cFechado§7§o Para Manuten\u00e7\u00f5es!" + "\n" + "§7§oEstaremos de Volta Assim que Possivel!" + "\n" + "\n" + Main.loja + "\n" + "§7Atenciosamente, Equipe!" + Main.prefix);
        }
    }
}
