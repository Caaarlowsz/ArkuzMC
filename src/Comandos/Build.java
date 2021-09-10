package Comandos;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;

import Main.Main;

public final class Build implements Listener, CommandExecutor {
	public static ArrayList<Player> embuild;

	static {
		Build.embuild = new ArrayList<Player>();
	}

	public boolean onCommand(final CommandSender sender, final Command cmd, final String label, final String[] args) {
		final Player p = (Player) sender;
		if (cmd.getName().equalsIgnoreCase("build")) {
			if (p.hasPermission("arkuz")) {
				if (args.length == 0) {
					if (!Build.embuild.contains(p)) {
						Build.embuild.add(p);
						p.sendMessage(String.valueOf(Main.prefix) + " §4\u27bc §7Seu Modo Build Foi Ativado");
					} else {
						Build.embuild.remove(p);
						p.sendMessage(String.valueOf(Main.prefix) + " §4\u27bc §7Seu Modo Build Foi Desativado");
					}
				} else {
					final Player t = Bukkit.getPlayer(args[0]);
					if (t == null) {
						p.sendMessage(String.valueOf(Main.prefix)
								+ " §4\u27bc §7Este Player N\u00e3o Est\u00e1 Conectado Ao Servidor");
						return true;
					}
					if (!Build.embuild.contains(t)) {
						Build.embuild.add(t);
						p.sendMessage(String.valueOf(Main.prefix) + " §4\u27bc §7Voc\u00ea Ativou o Modo Build Para §c"
								+ t.getName());
					} else {
						Build.embuild.remove(t);
						p.sendMessage(String.valueOf(Main.prefix)
								+ " §4\u27bc §7Voc\u00ea Desativou o Modo Build Para §c" + t.getName());
					}
				}
			} else {
				p.sendMessage(String.valueOf(Main.prefix) + " §4\u27bc §7Sem Permiss\u00e3o");
			}
		}
		return false;
	}

	@EventHandler
	public void aoconstruir(final BlockPlaceEvent e) {
		final Player p = e.getPlayer();
		if (!Build.embuild.contains(p)) {
			e.setCancelled(true);
		}
	}

	@EventHandler
	public void aoconstruir(final BlockBreakEvent e) {
		final Player p = e.getPlayer();
		if (!Build.embuild.contains(p)) {
			e.setCancelled(true);
		}
	}

	public enum EmBuild {
		ON("ON", 0), OFF("OFF", 1);

		private EmBuild(final String s, final int n) {
		}
	}
}
