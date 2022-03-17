package Comandos;

import com.github.caaarlowsz.arkuzmc.kitpvp.ArkuzKitPvP;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerLoginEvent;

public class Manutencao implements CommandExecutor, Listener {
    public static boolean manutencao;

    static {
        Manutencao.manutencao = false;
    }

    public boolean onCommand(final CommandSender sender, final Command cmd, final String label, final String[] args) {
        final Player p = (Player) sender;
        if (cmd.getName().equalsIgnoreCase("manutencao")) {
            if (!sender.hasPermission("arkuz.manutencao")) {
                sender.sendMessage(String.valueOf(ArkuzKitPvP.prefix)
                        + "➼ §7Desculpe, mas você não tem permissão para fazer isso.");
                return true;
            }
            if (args.length == 0) {
                p.sendMessage(String.valueOf(ArkuzKitPvP.prefix)
                        + "➼ §7Ops! Use isso De Maneira Correta: §f/manutencao <on/off>");
                return true;
            }
            if (args.length == 1) {
                if (args[0].equalsIgnoreCase("on")) {
                    if (Manutencao.manutencao) {
                        p.sendMessage(String.valueOf(ArkuzKitPvP.prefix)
                                + "➼ §cO Servidor já está em Manutenção!");
                        return true;
                    }
                    Bukkit.broadcastMessage(String.valueOf(ArkuzKitPvP.prefix)
                            + "➼ §eServidor entrando em Manutenção! Todos serão Kickados em §f5 Segundos!");
                    Manutencao.manutencao = true;
                    p.sendMessage(String.valueOf(ArkuzKitPvP.prefix) + "➼ §aManutenção sendo Ativa...");
                    p.sendMessage(String.valueOf(ArkuzKitPvP.prefix) + "➼ §aManutenção ativada com Sucesso!");
                    p.sendMessage(String.valueOf(ArkuzKitPvP.prefix) + "➼ §a Você Ativou a Manutenção!");
                    Player[] onlinePlayers;
                    for (int length = (onlinePlayers = Bukkit.getOnlinePlayers()).length, i = 0; i < length; ++i) {
                        final Player todos = onlinePlayers[i];
                        if (!sender.hasPermission("ficar.manutencao")) {
                            todos.kickPlayer(String.valueOf(ArkuzKitPvP.prefix) + "\n"
                                    + "   §7§oDesculpe, mas o Servidor em que voce estava conectado foi §cFechado§7§o Para Manutenções!"
                                    + "\n" + "§7§oEstaremos de Volta Assim que Possivel!" + "\n" + "\n" + ArkuzKitPvP.loja
                                    + "\n" + "§7Atenciosamente, Equipe!" + ArkuzKitPvP.prefix);
                            return true;
                        }
                    }
                    return true;
                } else if (args[0].equalsIgnoreCase("off")) {
                    if (!Manutencao.manutencao) {
                        p.sendMessage(String.valueOf(ArkuzKitPvP.prefix)
                                + "➼ §cO Servidor Não Está em Manutençao!");
                        return true;
                    }
                    Manutencao.manutencao = false;
                    p.sendMessage(String.valueOf(ArkuzKitPvP.prefix) + "➼ §aManutenção Desativada!");
                    p.sendMessage(String.valueOf(ArkuzKitPvP.prefix) + "➼ §eVoce desativou a Manutenção!");
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
            e.disallow(PlayerLoginEvent.Result.KICK_OTHER, String.valueOf(ArkuzKitPvP.prefix) + "\n"
                    + "   §7§oDesculpe, mas o Servidor em que voce estava conectado foi §cFechado§7§o Para Manutenções!"
                    + "\n" + "§7§oEstaremos de Volta Assim que Possivel!" + "\n" + "\n" + ArkuzKitPvP.loja + "\n"
                    + "§7Atenciosamente, Equipe!" + ArkuzKitPvP.prefix);
        }
    }
}
