package Comandos;

import com.github.caaarlowsz.arkuzmc.kitpvp.ArkuzPvP;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;

import java.util.Random;

public class SetArena implements Listener, CommandExecutor {

	public boolean onCommand(final CommandSender sender, final Command cmd, final String label, final String[] args) {
		final Player p = (Player) sender;
		if (p.hasPermission("arkuz.setarena") && label.equalsIgnoreCase("setarena")) {
			if (args.length == 0) {
				p.sendMessage(String.valueOf(ArkuzPvP.prefix) + " §4➼ §7Use: /SetArena {1-7}");
				return true;
			}
			if (args[0].equalsIgnoreCase("1")) {
				ArkuzPvP.getInstance().getConfig();
				p.sendMessage(String.valueOf(ArkuzPvP.prefix) + " §4➼ §7A Arena 1 Foi Setada Com Sucesso");
				ArkuzPvP.getInstance().getConfig().set("arena1.x", (Object) p.getLocation().getX());
				ArkuzPvP.getInstance().getConfig().set("arena1.y", (Object) p.getLocation().getY());
				ArkuzPvP.getInstance().getConfig().set("arena1.z", (Object) p.getLocation().getZ());
				p.getWorld();
				ArkuzPvP.getInstance().getConfig().set("arena1.pitch", (Object) p.getLocation().getPitch());
				ArkuzPvP.getInstance().getConfig().set("arena1.yaw", (Object) p.getLocation().getYaw());
				ArkuzPvP.getInstance().getConfig().set("arena1.world", (Object) p.getLocation().getWorld().getName());
				ArkuzPvP.getInstance().saveConfig();
			}
			if (args[0].equalsIgnoreCase("2")) {
				ArkuzPvP.getInstance().getConfig();
				p.sendMessage(String.valueOf(ArkuzPvP.prefix) + " §4➼ §7A Arena 2 Foi Setada Com Sucesso");
				ArkuzPvP.getInstance().getConfig().set("arena2.x", (Object) p.getLocation().getX());
				ArkuzPvP.getInstance().getConfig().set("arena2.y", (Object) p.getLocation().getY());
				ArkuzPvP.getInstance().getConfig().set("arena2.z", (Object) p.getLocation().getZ());
				p.getWorld();
				ArkuzPvP.getInstance().getConfig().set("arena2.pitch", (Object) p.getLocation().getPitch());
				ArkuzPvP.getInstance().getConfig().set("arena2.yaw", (Object) p.getLocation().getYaw());
				ArkuzPvP.getInstance().getConfig().set("arena2.world", (Object) p.getLocation().getWorld().getName());
				ArkuzPvP.getInstance().saveConfig();
			}
			if (args[0].equalsIgnoreCase("3")) {
				ArkuzPvP.getInstance().getConfig();
				p.sendMessage(String.valueOf(ArkuzPvP.prefix) + " §4➼ §7A Arena 3 Foi Setada Com Sucesso");
				ArkuzPvP.getInstance().getConfig().set("arena3.x", (Object) p.getLocation().getX());
				ArkuzPvP.getInstance().getConfig().set("arena3.y", (Object) p.getLocation().getY());
				ArkuzPvP.getInstance().getConfig().set("arena3.z", (Object) p.getLocation().getZ());
				p.getWorld();
				ArkuzPvP.getInstance().getConfig().set("arena3.pitch", (Object) p.getLocation().getPitch());
				ArkuzPvP.getInstance().getConfig().set("arena3.yaw", (Object) p.getLocation().getYaw());
				ArkuzPvP.getInstance().getConfig().set("arena3.world", (Object) p.getLocation().getWorld().getName());
				ArkuzPvP.getInstance().saveConfig();
			}
			if (args[0].equalsIgnoreCase("4")) {
				ArkuzPvP.getInstance().getConfig();
				p.sendMessage(String.valueOf(ArkuzPvP.prefix) + " §4➼ §7A Arena 4 Foi Setada Com Sucesso");
				ArkuzPvP.getInstance().getConfig().set("arena4.x", (Object) p.getLocation().getX());
				ArkuzPvP.getInstance().getConfig().set("arena4.y", (Object) p.getLocation().getY());
				ArkuzPvP.getInstance().getConfig().set("arena4.z", (Object) p.getLocation().getZ());
				p.getWorld();
				ArkuzPvP.getInstance().getConfig().set("arena4.pitch", (Object) p.getLocation().getPitch());
				ArkuzPvP.getInstance().getConfig().set("arena4.yaw", (Object) p.getLocation().getYaw());
				ArkuzPvP.getInstance().getConfig().set("arena4.world", (Object) p.getLocation().getWorld().getName());
				ArkuzPvP.getInstance().saveConfig();
			}
			if (args[0].equalsIgnoreCase("5")) {
				ArkuzPvP.getInstance().getConfig();
				p.sendMessage(String.valueOf(ArkuzPvP.prefix) + " §4➼ §7A Arena 5 Foi Setada Com Sucesso");
				ArkuzPvP.getInstance().getConfig().set("arena5.x", (Object) p.getLocation().getX());
				ArkuzPvP.getInstance().getConfig().set("arena5.y", (Object) p.getLocation().getY());
				ArkuzPvP.getInstance().getConfig().set("arena5.z", (Object) p.getLocation().getZ());
				p.getWorld();
				ArkuzPvP.getInstance().getConfig().set("arena5.pitch", (Object) p.getLocation().getPitch());
				ArkuzPvP.getInstance().getConfig().set("arena5.yaw", (Object) p.getLocation().getYaw());
				ArkuzPvP.getInstance().getConfig().set("arena5.world", (Object) p.getLocation().getWorld().getName());
				ArkuzPvP.getInstance().saveConfig();
			}
			if (args[0].equalsIgnoreCase("6")) {
				ArkuzPvP.getInstance().getConfig();
				p.sendMessage(String.valueOf(ArkuzPvP.prefix) + " §4➼ §7A Arena 6 Foi Setada Com Sucesso");
				ArkuzPvP.getInstance().getConfig().set("arena6.x", (Object) p.getLocation().getX());
				ArkuzPvP.getInstance().getConfig().set("arena6.y", (Object) p.getLocation().getY());
				ArkuzPvP.getInstance().getConfig().set("arena6.z", (Object) p.getLocation().getZ());
				p.getWorld();
				ArkuzPvP.getInstance().getConfig().set("arena6.pitch", (Object) p.getLocation().getPitch());
				ArkuzPvP.getInstance().getConfig().set("arena6.yaw", (Object) p.getLocation().getYaw());
				ArkuzPvP.getInstance().getConfig().set("arena6.world", (Object) p.getLocation().getWorld().getName());
				ArkuzPvP.getInstance().saveConfig();
			}
			if (args[0].equalsIgnoreCase("7")) {
				ArkuzPvP.getInstance().getConfig();
				p.sendMessage(String.valueOf(ArkuzPvP.prefix) + " §4➼ §7A Arena 7 Foi Setada Com Sucesso");
				ArkuzPvP.getInstance().getConfig().set("arena7.x", (Object) p.getLocation().getX());
				ArkuzPvP.getInstance().getConfig().set("arena7.y", (Object) p.getLocation().getY());
				ArkuzPvP.getInstance().getConfig().set("arena7.z", (Object) p.getLocation().getZ());
				p.getWorld();
				ArkuzPvP.getInstance().getConfig().set("arena7.pitch", (Object) p.getLocation().getPitch());
				ArkuzPvP.getInstance().getConfig().set("arena7.yaw", (Object) p.getLocation().getYaw());
				ArkuzPvP.getInstance().getConfig().set("arena7.world", (Object) p.getLocation().getWorld().getName());
				ArkuzPvP.getInstance().saveConfig();
			}
		}
		return false;
	}

	public static void TeleportArenaRandom(final Player p) {
		final Random dice = new Random();
		final int number = dice.nextInt(4);
		switch (number) {
		case 0: {
			final World w = Bukkit.getServer().getWorld(ArkuzPvP.getInstance().getConfig().getString("arena1.world"));
			final double x = ArkuzPvP.getInstance().getConfig().getDouble("arena1.x");
			final double y = ArkuzPvP.getInstance().getConfig().getDouble("arena1.y");
			final double z = ArkuzPvP.getInstance().getConfig().getDouble("arena1.z");
			final Location lobby = new Location(w, x, y, z);
			lobby.setPitch((float) ArkuzPvP.getInstance().getConfig().getDouble("arena1.pitch"));
			lobby.setYaw((float) ArkuzPvP.getInstance().getConfig().getDouble("arena1.yaw"));
			p.teleport(lobby);
			break;
		}
		case 1: {
			final World w2 = Bukkit.getServer().getWorld(ArkuzPvP.getInstance().getConfig().getString("arena2.world"));
			final double x2 = ArkuzPvP.getInstance().getConfig().getDouble("arena2.x");
			final double y2 = ArkuzPvP.getInstance().getConfig().getDouble("arena2.y");
			final double z2 = ArkuzPvP.getInstance().getConfig().getDouble("arena2.z");
			final Location lobby2 = new Location(w2, x2, y2, z2);
			lobby2.setPitch((float) ArkuzPvP.getInstance().getConfig().getDouble("arena2.pitch"));
			lobby2.setYaw((float) ArkuzPvP.getInstance().getConfig().getDouble("arena2.yaw"));
			p.teleport(lobby2);
			break;
		}
		case 2: {
			final World w3 = Bukkit.getServer().getWorld(ArkuzPvP.getInstance().getConfig().getString("arena3.world"));
			final double x3 = ArkuzPvP.getInstance().getConfig().getDouble("arena3.x");
			final double y3 = ArkuzPvP.getInstance().getConfig().getDouble("arena3.y");
			final double z3 = ArkuzPvP.getInstance().getConfig().getDouble("arena3.z");
			final Location lobby3 = new Location(w3, x3, y3, z3);
			lobby3.setPitch((float) ArkuzPvP.getInstance().getConfig().getDouble("arena3.pitch"));
			lobby3.setYaw((float) ArkuzPvP.getInstance().getConfig().getDouble("arena3.yaw"));
			p.teleport(lobby3);
			break;
		}
		case 3: {
			final World w4 = Bukkit.getServer().getWorld(ArkuzPvP.getInstance().getConfig().getString("arena4.world"));
			final double x4 = ArkuzPvP.getInstance().getConfig().getDouble("arena4.x");
			final double y4 = ArkuzPvP.getInstance().getConfig().getDouble("arena4.y");
			final double z4 = ArkuzPvP.getInstance().getConfig().getDouble("arena4.z");
			final Location lobby4 = new Location(w4, x4, y4, z4);
			lobby4.setPitch((float) ArkuzPvP.getInstance().getConfig().getDouble("arena4.pitch"));
			lobby4.setYaw((float) ArkuzPvP.getInstance().getConfig().getDouble("arena4.yaw"));
			p.teleport(lobby4);
			break;
		}
		case 4: {
			final World w5 = Bukkit.getServer().getWorld(ArkuzPvP.getInstance().getConfig().getString("arena5.world"));
			final double x5 = ArkuzPvP.getInstance().getConfig().getDouble("arena5.x");
			final double y5 = ArkuzPvP.getInstance().getConfig().getDouble("arena5.y");
			final double z5 = ArkuzPvP.getInstance().getConfig().getDouble("arena5.z");
			final Location lobby5 = new Location(w5, x5, y5, z5);
			lobby5.setPitch((float) ArkuzPvP.getInstance().getConfig().getDouble("arena5.pitch"));
			lobby5.setYaw((float) ArkuzPvP.getInstance().getConfig().getDouble("arena5.yaw"));
			p.teleport(lobby5);
			break;
		}
		case 5: {
			final World w6 = Bukkit.getServer().getWorld(ArkuzPvP.getInstance().getConfig().getString("arena6.world"));
			final double x6 = ArkuzPvP.getInstance().getConfig().getDouble("arena6.x");
			final double y6 = ArkuzPvP.getInstance().getConfig().getDouble("arena6.y");
			final double z6 = ArkuzPvP.getInstance().getConfig().getDouble("arena6.z");
			final Location lobby6 = new Location(w6, x6, y6, z6);
			lobby6.setPitch((float) ArkuzPvP.getInstance().getConfig().getDouble("arena6.pitch"));
			lobby6.setYaw((float) ArkuzPvP.getInstance().getConfig().getDouble("arena6.yaw"));
			p.teleport(lobby6);
			break;
		}
		case 6: {
			final World w7 = Bukkit.getServer().getWorld(ArkuzPvP.getInstance().getConfig().getString("arena7.world"));
			final double x7 = ArkuzPvP.getInstance().getConfig().getDouble("arena7.x");
			final double y7 = ArkuzPvP.getInstance().getConfig().getDouble("arena7.y");
			final double z7 = ArkuzPvP.getInstance().getConfig().getDouble("arena7.z");
			final Location lobby7 = new Location(w7, x7, y7, z7);
			lobby7.setPitch((float) ArkuzPvP.getInstance().getConfig().getDouble("arena7.pitch"));
			lobby7.setYaw((float) ArkuzPvP.getInstance().getConfig().getDouble("arena7.yaw"));
			p.teleport(lobby7);
			break;
		}
		}
	}
}
