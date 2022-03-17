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

public class Chat implements CommandExecutor, Listener {
	public static boolean c;

	static {
		Chat.c = false;
	}

	public boolean onCommand(final CommandSender Sender, final Command Cmd, final String Label, final String[] Args) {
		final Player p = (Player) Sender;
		if (Cmd.getName().equalsIgnoreCase("chat")) {
			if (!p.hasPermission("arkuz.chat")) {
				p.sendMessage(String.valueOf(ArkuzKitPvP.prefix) + " §4➼ §7Sem Permissão");
				return true;
			}
			if (Args.length == 0) {
				p.sendMessage(String.valueOf(ArkuzKitPvP.prefix) + " §4➼ §7Use: /Chat {Mutar|Desmutar}");
				return true;
			}
			if (Args[0].equalsIgnoreCase("mutar")) {
				Chat.c = true;
				Bukkit.broadcastMessage(String.valueOf(ArkuzKitPvP.prefix) + " §4➼ §7O Chat Foi §4MUTADO");
			}
			if (Args[0].equalsIgnoreCase("desmutar")) {
				Chat.c = false;
				Bukkit.broadcastMessage(String.valueOf(ArkuzKitPvP.prefix) + " §4➼ §7O Chat Foi §cDESMUTADO");
			}
		}
		return false;
	}

	@EventHandler
	public void naoFalarNoChatQuandoTiverOFF(final AsyncPlayerChatEvent e) {
		final Player p = e.getPlayer();
		if (!p.hasPermission("sword.chat") && Chat.c) {
			e.setCancelled(true);
			p.sendMessage(String.valueOf(ArkuzKitPvP.prefix) + " §4➼ §7Não é Possivel Falar Com o Chat Mutado");
		}
	}
}
