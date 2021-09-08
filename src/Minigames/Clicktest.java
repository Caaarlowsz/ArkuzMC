package Minigames;

import Eventos.TheTitle;
import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.event.EventHandler;
import Main.Main;
import org.bukkit.Bukkit;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.entity.Player;
import java.util.ArrayList;
import org.bukkit.event.Listener;
import org.bukkit.command.CommandExecutor;

public class Clicktest implements CommandExecutor, Listener
{
    public static ArrayList<Player> sela;
    public static Clicktest m;
    
    static {
        Clicktest.sela = new ArrayList<Player>();
    }
    
    public static Clicktest getMain() {
        return Clicktest.m;
    }
    
    @EventHandler
    public void bater(final PlayerInteractEvent e) {
        final Player p = e.getPlayer();
        if (Clicktest.sela.contains(p) && e.getAction() == Action.LEFT_CLICK_AIR) {
            p.setLevel(p.getLevel() + 1);
            Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(Main.plugin, (Runnable)new Runnable() {
                @Override
                public void run() {
                    if (Clicktest.sela.contains(p)) {
                        Clicktest.sela.remove(p);
                        p.sendMessage("§c§m-------------------------------------------");
                        p.sendMessage("§c§m----------§7 " + Main.prefix + "§c§m-------------------");
                        p.sendMessage("§cClicks em 10 segundos §b" + p.getLevel() + " §aclicks");
                        p.sendMessage("§cVoce fez a media §b" + p.getLevel() / 10 + " §aclicks por segundo!");
                        p.sendMessage("§cClicks em 60 segundos §b" + p.getLevel() * 6 + " §aclicks");
                        p.sendMessage("§c§m-------------------------------------------");
                        p.teleport(p.getWorld().getSpawnLocation());
                        if (p.getLevel() >= 300) {
                            p.setBanned(true);
                        }
                    }
                }
            }, 200L);
            Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(Main.plugin, (Runnable)new Runnable() {
                @Override
                public void run() {
                    p.setLevel(0);
                    Clicktest.sela.remove(p.getName());
                }
            }, 260L);
        }
    }
    
    public boolean onCommand(final CommandSender sender, final Command cmd, final String label, final String[] args) {
        if (sender instanceof Player && cmd.getName().equalsIgnoreCase("clicktest")) {
            final Player p = (Player)sender;
            p.setLevel(0);
            p.setGameMode(GameMode.SURVIVAL);
            p.sendMessage(String.valueOf(Main.prefix) + " §4\u27bc §7Iniciando Treino Em: §c5");
            Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(Main.plugin, (Runnable)new Runnable() {
                @Override
                public void run() {
                    p.sendMessage(String.valueOf(Main.prefix) + " §4\u27bc §7Iniciando Treino Em: §c4");
                }
            }, 20L);
            Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(Main.plugin, (Runnable)new Runnable() {
                @Override
                public void run() {
                    p.sendMessage(String.valueOf(Main.prefix) + " §4\u27bc §7Iniciando Treino Em: §c3");
                }
            }, 40L);
            Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(Main.plugin, (Runnable)new Runnable() {
                @Override
                public void run() {
                    p.sendMessage(String.valueOf(Main.prefix) + " §4\u27bc §7Iniciando Treino Em: §c2");
                }
            }, 60L);
            Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(Main.plugin, (Runnable)new Runnable() {
                @Override
                public void run() {
                    p.sendMessage(String.valueOf(Main.prefix) + " §4\u27bc §7Iniciando Treino Em: §c1");
                }
            }, 80L);
            Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(Main.plugin, (Runnable)new Runnable() {
                @Override
                public void run() {
                    TheTitle.sendTitle(p, "§4§lTREINO §8§lDE §c§lCLICKS");
                    TheTitle.sendSubTitle(p, "§8§lINICIADO");
                    p.sendMessage(String.valueOf(Main.prefix) + " §4\u27bc §7O §c§nTreino§7 §c§nDe§7 §c§nClicks§7 Foi Iniciado");
                    Clicktest.sela.add(p);
                }
            }, 100L);
        }
        return false;
    }
}
