package Warps;

import com.github.caaarlowsz.arkuzmc.kitpvp.ArkuzPvP;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;

public class SetWarp implements CommandExecutor, Listener {
	public boolean onCommand(final CommandSender sender, final Command cmd, final String label, final String[] args) {
		Player p = (Player) sender;
		if (cmd.getName().equalsIgnoreCase("set") && args.length == 0) {
			p.sendMessage(String.valueOf(ArkuzPvP.prefix) + " §4➼ §7Use: /Set {Warp}");
			return true;
		}
		if (!sender.hasPermission("myth.set")) {
			p = (Player) sender;
			p.sendMessage(
					String.valueOf(ArkuzPvP.prefix) + " §4➼ §7Sem Permissão ou esta WARP não existe !");
			return false;
		}
		if (args[0].equalsIgnoreCase("challenge")) {
			ArkuzPvP.getInstance().warps.set("challenge.x", (Object) p.getLocation().getX());
			ArkuzPvP.getInstance().warps.set("challenge.y", (Object) p.getLocation().getY());
			ArkuzPvP.getInstance().warps.set("challenge.z", (Object) p.getLocation().getZ());
			ArkuzPvP.getInstance().warps.set("challenge.pitch", (Object) p.getLocation().getPitch());
			ArkuzPvP.getInstance().warps.set("challenge.yaw", (Object) p.getLocation().getYaw());
			ArkuzPvP.getInstance().warps.set("challenge.world", (Object) p.getLocation().getWorld().getName());
			ArkuzPvP.getInstance().save();
			p.sendMessage(String.valueOf(ArkuzPvP.prefix) + " §4➼ §7Você Setou a Warp: §cChallenge");
			return true;
		}
		if (args[0].equalsIgnoreCase("fps")) {
			ArkuzPvP.getInstance().warps.set("fps.x", (Object) p.getLocation().getX());
			ArkuzPvP.getInstance().warps.set("fps.y", (Object) p.getLocation().getY());
			ArkuzPvP.getInstance().warps.set("fps.z", (Object) p.getLocation().getZ());
			ArkuzPvP.getInstance().warps.set("fps.pitch", (Object) p.getLocation().getPitch());
			ArkuzPvP.getInstance().warps.set("fps.yaw", (Object) p.getLocation().getYaw());
			ArkuzPvP.getInstance().warps.set("fps.world", (Object) p.getLocation().getWorld().getName());
			ArkuzPvP.getInstance().save();
			p.sendMessage(String.valueOf(ArkuzPvP.prefix) + " §4➼ §7Você Setou a Warp: §cFps");
			return true;
		}
		if (args[0].equalsIgnoreCase("textura")) {
			ArkuzPvP.getInstance().warps.set("textura.x", (Object) p.getLocation().getX());
			ArkuzPvP.getInstance().warps.set("textura.y", (Object) p.getLocation().getY());
			ArkuzPvP.getInstance().warps.set("textura.z", (Object) p.getLocation().getZ());
			ArkuzPvP.getInstance().warps.set("textura.pitch", (Object) p.getLocation().getPitch());
			ArkuzPvP.getInstance().warps.set("textura.yaw", (Object) p.getLocation().getYaw());
			ArkuzPvP.getInstance().warps.set("textura.world", (Object) p.getLocation().getWorld().getName());
			ArkuzPvP.getInstance().save();
			p.sendMessage(String.valueOf(ArkuzPvP.prefix) + " §4➼ §7Você Setou a Warp: §cTextura");
			return true;
		}
		if (args[0].equalsIgnoreCase("knock")) {
			ArkuzPvP.getInstance().warps.set("knock.x", (Object) p.getLocation().getX());
			ArkuzPvP.getInstance().warps.set("knock.y", (Object) p.getLocation().getY());
			ArkuzPvP.getInstance().warps.set("knock.z", (Object) p.getLocation().getZ());
			ArkuzPvP.getInstance().warps.set("knock.pitch", (Object) p.getLocation().getPitch());
			ArkuzPvP.getInstance().warps.set("knock.yaw", (Object) p.getLocation().getYaw());
			ArkuzPvP.getInstance().warps.set("knock.world", (Object) p.getLocation().getWorld().getName());
			ArkuzPvP.getInstance().save();
			p.sendMessage(String.valueOf(ArkuzPvP.prefix) + " §4➼ §7Você Setou a Warp: §cKnock");
			return true;
		}
		if (args[0].equalsIgnoreCase("main")) {
			ArkuzPvP.getInstance().warps.set("main.x", (Object) p.getLocation().getX());
			ArkuzPvP.getInstance().warps.set("main.y", (Object) p.getLocation().getY());
			ArkuzPvP.getInstance().warps.set("main.z", (Object) p.getLocation().getZ());
			ArkuzPvP.getInstance().warps.set("main.pitch", (Object) p.getLocation().getPitch());
			ArkuzPvP.getInstance().warps.set("main.yaw", (Object) p.getLocation().getYaw());
			ArkuzPvP.getInstance().warps.set("main.world", (Object) p.getLocation().getWorld().getName());
			ArkuzPvP.getInstance().save();
			p.sendMessage(String.valueOf(ArkuzPvP.prefix) + " §4➼ §7Você Setou a Warp: §cMain");
			return true;
		}
		if (args[0].equalsIgnoreCase("gladiator")) {
			p.sendMessage(String.valueOf(ArkuzPvP.prefix) + " §4➼ §7Warp em desenvolvimento...");
			return true;
		}
		if (args[0].equalsIgnoreCase("mdr")) {
			ArkuzPvP.getInstance().warps.set("mdr.x", (Object) p.getLocation().getX());
			ArkuzPvP.getInstance().warps.set("mdr.y", (Object) p.getLocation().getY());
			ArkuzPvP.getInstance().warps.set("mdr.z", (Object) p.getLocation().getZ());
			ArkuzPvP.getInstance().warps.set("mdr.pitch", (Object) p.getLocation().getPitch());
			ArkuzPvP.getInstance().warps.set("mdr.yaw", (Object) p.getLocation().getYaw());
			ArkuzPvP.getInstance().warps.set("mdr.world", (Object) p.getLocation().getWorld().getName());
			ArkuzPvP.getInstance().save();
			p.sendMessage(String.valueOf(ArkuzPvP.prefix) + " §4➼ §7Você Setou a Warp: §cMdr");
			return true;
		}
		if (args[0].equalsIgnoreCase("rdm")) {
			ArkuzPvP.getInstance().warps.set("rdm.x", (Object) p.getLocation().getX());
			ArkuzPvP.getInstance().warps.set("rdm.y", (Object) p.getLocation().getY());
			ArkuzPvP.getInstance().warps.set("rdm.z", (Object) p.getLocation().getZ());
			ArkuzPvP.getInstance().warps.set("rdm.pitch", (Object) p.getLocation().getPitch());
			ArkuzPvP.getInstance().warps.set("rdm.yaw", (Object) p.getLocation().getYaw());
			ArkuzPvP.getInstance().warps.set("rdm.world", (Object) p.getLocation().getWorld().getName());
			ArkuzPvP.getInstance().save();
			p.sendMessage(String.valueOf(ArkuzPvP.prefix) + " §4➼ §7Você Setou a Warp: §cRdm");
			return true;
		}
		return false;
	}

	public static void setWarp(final Player m, final String string) {
	}

	public static String getWarp(final Player p) {
		return null;
	}
}
