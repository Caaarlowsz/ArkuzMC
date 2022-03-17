package Warps;

import com.github.caaarlowsz.arkuzmc.kitpvp.ArkuzKitPvP;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;

public class SetSpawn implements CommandExecutor, Listener {

	public boolean onCommand(final CommandSender sender, final Command cmd, final String commandLabel,
			final String[] args) {
		if (cmd.getName().equalsIgnoreCase("setspawn") && sender instanceof Player) {
			if (!sender.hasPermission("myth.set")) {
				final Player p1 = (Player) sender;
				p1.sendMessage(String.valueOf(ArkuzKitPvP.prefix) + " §4➼ §7Sem Permissão");
			}
			if (sender.hasPermission("myth.set")) {
				final Player p1 = (Player) sender;
				ArkuzKitPvP.getInstance().getConfig().set("spawn.x", (Object) p1.getLocation().getX());
				ArkuzKitPvP.getInstance().getConfig().set("spawn.y", (Object) p1.getLocation().getY());
				ArkuzKitPvP.getInstance().getConfig().set("spawn.z", (Object) p1.getLocation().getZ());
				ArkuzKitPvP.getInstance().getConfig().set("spawn.pitch", (Object) p1.getLocation().getPitch());
				ArkuzKitPvP.getInstance().getConfig().set("spawn.yaw", (Object) p1.getLocation().getYaw());
				ArkuzKitPvP.getInstance().getConfig().set("spawn.world", (Object) p1.getLocation().getWorld().getName());
				ArkuzKitPvP.getInstance().saveConfig();
				p1.sendMessage(String.valueOf(ArkuzKitPvP.prefix) + " §4➼ §7Você Setou a Warp: §cSpawn");
				p1.getWorld().setSpawnLocation(p1.getLocation().getBlockX(), p1.getLocation().getBlockY(),
						p1.getLocation().getBlockZ());
			}
			return false;
		}
		return false;
	}

	public static String getWarp(final Player p) {
		return null;
	}
}
