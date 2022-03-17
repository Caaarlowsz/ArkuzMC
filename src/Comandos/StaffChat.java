package Comandos;

import com.github.caaarlowsz.arkuzmc.kitpvp.ArkuzKitPvP;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

import java.util.ArrayList;

public class StaffChat implements Listener, CommandExecutor {
	ArrayList<String> staff;

	public StaffChat() {
		this.staff = ArkuzKitPvP.staff;
	}

	@EventHandler
	public void onChat(final AsyncPlayerChatEvent e) {
		final Player p = e.getPlayer();
		Player[] arrayOfPlayer;
		for (int j = (arrayOfPlayer = Bukkit.getOnlinePlayers()).length, i = 0; i < j; ++i) {
			final Player online = arrayOfPlayer[i];
			if (this.isStaffChatting(p)) {
				e.setCancelled(true);
				if (online.hasPermission("arkuz.sc") || this.isStaffChatting(online)) {
					online.sendMessage("§7{ §cSC §7} §7" + p.getName() + " §4➼ " + "§7" + e.getMessage());
				}
			}
		}
	}

	public boolean onCommand(final CommandSender sender, final Command cmd, final String commandLabel,
			final String[] args) {
		if (!(sender instanceof Player)) {
			return true;
		}
		final Player p = (Player) sender;
		if (cmd.getName().equalsIgnoreCase("sc") && p.hasPermission("arkuz.sc")) {
			if (this.isStaffChatting(p)) {
				this.staff.remove(p.getName());
				p.sendMessage(String.valueOf(ArkuzKitPvP.prefix) + " §4➼ §7Você Saiu Do Chat Da Staff");
			} else {
				this.staff.add(p.getName());
				p.sendMessage(String.valueOf(ArkuzKitPvP.prefix) + " §4➼ §7Você Está No Chat Da Staff");
			}
		}
		return false;
	}

	public boolean isStaffChatting(final Player player) {
		return this.staff.contains(player.getName());
	}
}
