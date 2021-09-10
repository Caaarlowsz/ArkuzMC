package Comandos;

import java.util.ArrayList;
import java.util.Arrays;

import org.apache.commons.lang.StringUtils;
import org.bukkit.Bukkit;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.plugin.Plugin;

import Essencial.ChatInterativoAPI;
import Eventos.Habilidade;
import Main.Main;

public class Report implements CommandExecutor, Listener {
	public ArrayList<String> reported;
	private Main plugin;

	public Report(final Main plugin) {
		this.reported = new ArrayList<String>();
		this.plugin = plugin;
	}

	public boolean onCommand(final CommandSender sender, final Command cmd, final String commandLabel,
			final String[] args) {
		final Player p = (Player) sender;
		if (!(sender instanceof Player)) {
			sender.sendMessage("§cVoce nao pode usar isso no console");
			return false;
		}
		if (commandLabel.equalsIgnoreCase("report")) {
			if (args.length >= 2) {
				final Player target = p.getServer().getPlayer(args[0]);
				if (target != null) {
					if (this.reported.contains(p.getName())) {
						p.sendMessage("§c* §7Voce ja efetuou um report, por favor aguarde!");
						return true;
					}
					final String reportMsg = StringUtils.join((Object[]) Arrays.copyOfRange(args, 1, args.length), " ");
					this.reported.add(p.getName());
					p.sendMessage("§6* §7O Report do jogador §6" + target.getName() + " §7Pelo motivo §6" + reportMsg
							+ "§7 Foi enviado a nossa equipe!");
					Player[] arrayOfPlayer;
					for (int j = (arrayOfPlayer = Bukkit.getOnlinePlayers()).length, i = 0; i < j; ++i) {
						final Player s = arrayOfPlayer[i];
						if (s.hasPermission("arkuz.report")) {
							s.playSound(s.getLocation(), Sound.LEVEL_UP, 15.0f, 1.0f);
							s.sendMessage("§c");
							s.sendMessage("§c§m--->-----------------------------<---");
							s.sendMessage("§c");
							s.sendMessage("§c             §c§lNOVO REPORT!§c               ");
							s.sendMessage("§c");
							s.sendMessage("   §c* §7Jogador Reportado: §c" + target.getName());
							s.sendMessage("   §a* §7Jogador que Reportou: §a" + p.getName());
							s.sendMessage("      §e* §7Motivo do Reporte: §e" + reportMsg);
							s.sendMessage("    §c* §7Kit do suspeito: §c" + Habilidade.getAbility(target));
							s.sendMessage("§c");
							ChatInterativoAPI.Comando(s.getName(), "§c* §7TELEPORTAR-SE AO JOGADOR§c *",
									"/tp " + target.getName(), "§eTeleporte Rapido. §7(Clique)");
							s.sendMessage("§c§m--->-----------------------------<---");
							s.sendMessage("§c");
							Bukkit.getServer().getScheduler().scheduleSyncDelayedTask((Plugin) this.plugin,
									(Runnable) new Runnable() {
										@Override
										public void run() {
											Report.this.reported.remove(p.getName());
										}
									}, 300L);
						}
					}
				} else {
					p.sendMessage("§c* §7Este jogador nao esta conectado!");
				}
			} else {
				p.sendMessage("§e* §7Voce usou de maneira incorreta, por favor use: §e/report (jogador) (motivo)");
			}
		}
		return false;
	}
}
