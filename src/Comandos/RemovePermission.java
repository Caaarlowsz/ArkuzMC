package Comandos;

import com.github.caaarlowsz.arkuzmc.kitpvp.ArkuzKitPvP;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;

public class RemovePermission implements CommandExecutor, Listener {
    public boolean onCommand(final CommandSender sender, final Command cmd, final String label, final String[] args) {
        final Player p = (Player) sender;
        if (cmd.getName().equalsIgnoreCase("removepermission")) {
            if (!sender.hasPermission("arkuz.removepermission")) {
                sender.sendMessage(String.valueOf(ArkuzKitPvP.prefix)
                        + " ➼ §cDesculpe, mas você não tem permissão para fazer isso.");
                return true;
            }
            if (args.length == 0) {
                p.sendMessage(String.valueOf(ArkuzKitPvP.prefix)
                        + " ➼ §cOps! Use isso De Maneira Correta: §f/removepermission <jogador> <permissao> ");
                p.sendMessage("§c(Para ver a Lista de permissões, use /permissionslist)");
                return true;
            }
            if (args.length != 2) {
                p.sendMessage(String.valueOf(ArkuzKitPvP.prefix) + "➼ §cEssa Permissão não existe!");
                return true;
            }
            final String permissions = args[1];
            final Player jogador = Bukkit.getPlayer(args[0]);
            if (permissions.equalsIgnoreCase("Admin")) {
                p.sendMessage(String.valueOf(ArkuzKitPvP.prefix)
                        + " ➼ §aVoce removeu A permissao §fModo Admin§c do jogador §f" + jogador.getName());
                jogador.sendMessage(
                        String.valueOf(ArkuzKitPvP.prefix) + " ➼ §cVoce perdeu a Permissão Para o §fModo Admin§c!");
                Bukkit.dispatchCommand((CommandSender) Bukkit.getConsoleSender(),
                        "pex user " + jogador.getName() + " remove arkuz.admin");
                return true;
            }
            if (permissions.equalsIgnoreCase("staffchat")) {
                p.sendMessage(String.valueOf(ArkuzKitPvP.prefix)
                        + " ➼ §aVoce removeu A permissao §fStaffChat§c do jogador §f" + jogador.getName());
                jogador.sendMessage(
                        String.valueOf(ArkuzKitPvP.prefix) + " ➼ §cVoce perdeu a Permissao do §fSstaffChat§c!");
                Bukkit.dispatchCommand((CommandSender) Bukkit.getConsoleSender(),
                        "pex user " + jogador.getName() + " remove arkuz.sc");
                return true;
            }
            if (permissions.equalsIgnoreCase("fullkit")) {
                p.sendMessage(String.valueOf(ArkuzKitPvP.prefix) + " ➼ §aVoce removeu Todos os Kits Ao jogador §f"
                        + jogador.getName());
                jogador.sendMessage(
                        String.valueOf(ArkuzKitPvP.prefix) + " ➼ §cVoce perdeu a Permissão de §fTodos os Kits§c!");
                jogador.sendMessage("§cSeus kits voltaram ao padrão do seu Rank.");
                Bukkit.dispatchCommand((CommandSender) Bukkit.getConsoleSender(),
                        "pex user " + jogador.getName() + " remove kit.*");
                return true;
            }
            if (permissions.equalsIgnoreCase("teleportar")) {
                p.sendMessage(String.valueOf(ArkuzKitPvP.prefix)
                        + " ➼ §aVoce removeu a Permissão de §fTeleportar§c do jogador §f"
                        + jogador.getName());
                jogador.sendMessage(
                        String.valueOf(ArkuzKitPvP.prefix) + " ➼ §cVoce perdeu a Permissão de §fTeleportar§c!");
                Bukkit.dispatchCommand((CommandSender) Bukkit.getConsoleSender(),
                        "pex user " + jogador.getName() + " remove arkuz.teleport");
                return true;
            }
            if (permissions.equalsIgnoreCase("givevips")) {
                p.sendMessage(String.valueOf(ArkuzKitPvP.prefix)
                        + " ➼ §aVoce removeu a Permissão de §fDar Vips§c do Jogador §f" + jogador.getName());
                jogador.sendMessage(
                        String.valueOf(ArkuzKitPvP.prefix) + " ➼ §aVoce perdeu a Permissão de §fDar Vips§c!");
                Bukkit.dispatchCommand((CommandSender) Bukkit.getConsoleSender(),
                        "pex user " + jogador.getName() + " remove arkuz.givevip");
                return true;
            }
            if (permissions.equalsIgnoreCase("givekit")) {
                p.sendMessage(String.valueOf(ArkuzKitPvP.prefix)
                        + " ➼ §aVoce removeu a Permissão de §fDar Kits§c do Jogador §f" + jogador.getName());
                jogador.sendMessage(
                        String.valueOf(ArkuzKitPvP.prefix) + "➼ §cVoce perdeu a Permissão de §fDar Kits§c!");
                Bukkit.dispatchCommand((CommandSender) Bukkit.getConsoleSender(),
                        "pex user " + jogador.getName() + " remove arkuz.givekit");
                return true;
            }
            if (permissions.equalsIgnoreCase("sortearkit")) {
                p.sendMessage(String.valueOf(ArkuzKitPvP.prefix)
                        + " ➼ §aVoce removeu a Permissão de §fSortear Kits§c do Jogador §f"
                        + jogador.getName());
                jogador.sendMessage(
                        String.valueOf(ArkuzKitPvP.prefix) + "➼ §cVoce perdeu a Permissao de §fSortear kits§c!");
                Bukkit.dispatchCommand((CommandSender) Bukkit.getConsoleSender(),
                        "pex user " + jogador.getName() + " remove arkuz.sortearkit");
                return true;
            }
            if (permissions.equalsIgnoreCase("sortearvip")) {
                p.sendMessage(String.valueOf(ArkuzKitPvP.prefix)
                        + "➼ §aVoce removeu a Permissão de §fSortear Vips§c do Jogador §f"
                        + jogador.getName());
                jogador.sendMessage(
                        String.valueOf(ArkuzKitPvP.prefix) + " ➼ §aVoce perdeu a Permissao de §fSortear Vips§c!");
                Bukkit.dispatchCommand((CommandSender) Bukkit.getConsoleSender(),
                        "pex user " + jogador.getName() + " remove arkuz.sortearvip");
                return true;
            }
        }
        return false;
    }
}
