package Comandos;

import com.github.caaarlowsz.arkuzmc.kitpvp.ArkuzPvP;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class Tag implements Listener, CommandExecutor {

	public boolean onCommand(final CommandSender sender, final Command cmd, final String label, final String[] args) {
		if (!cmd.getName().equalsIgnoreCase("tag")) {
			return false;
		}
		final Player p = (Player) sender;
		if (args.length != 0) {
			if (args[0].equalsIgnoreCase("normal")) {
				if (p.hasPermission("tag.normal")) {
					p.sendMessage(String.valueOf(ArkuzPvP.prefix) + " §4➼ §7Tag Alterada Com Sucesso");
					p.setDisplayName("§7" + p.getName() + ChatColor.WHITE);
					p.setPlayerListName("§7" + getShortStr(p.getName()) + ChatColor.WHITE + ChatColor.ITALIC);
					Bukkit.dispatchCommand((CommandSender) Bukkit.getConsoleSender(),
							"ne prefix " + p.getName() + " &7&lPLAYER &7");
					return true;
				}
				p.sendMessage(String.valueOf(ArkuzPvP.prefix) + " §4➼ §7Sem Permissão");
			}
			if (args[0].equalsIgnoreCase("ultra")) {
				if (p.hasPermission("tag.ultra")) {
					p.sendMessage(String.valueOf(ArkuzPvP.prefix) + " §4➼ §7Tag Alterada Com Sucesso");
					p.setDisplayName("§a§lULTRA §a" + p.getName() + ChatColor.WHITE);
					p.setPlayerListName("§a" + getShortStr(p.getName()) + ChatColor.WHITE + ChatColor.ITALIC);
					Bukkit.dispatchCommand((CommandSender) Bukkit.getConsoleSender(),
							"ne prefix " + p.getName() + " &a&lULTRA &7");
					return true;
				}
				p.sendMessage(String.valueOf(ArkuzPvP.prefix) + " §4➼ §7Sem Permissão");
			}
			if (args[0].equalsIgnoreCase("pro")) {
				if (p.hasPermission("tag.pro")) {
					p.sendMessage(String.valueOf(ArkuzPvP.prefix) + " §4➼ §7Tag Alterada Com Sucesso");
					p.setDisplayName("§6§lPRO §6" + p.getName() + ChatColor.WHITE);
					p.setPlayerListName("§6" + getShortStr(p.getName()) + ChatColor.WHITE + ChatColor.ITALIC);
					Bukkit.dispatchCommand((CommandSender) Bukkit.getConsoleSender(),
							"ne prefix " + p.getName() + " &6&lPRO &7");
					return true;
				}
				p.sendMessage(String.valueOf(ArkuzPvP.prefix) + " §4➼ §7Sem Permissão");
			}
			if (args[0].equalsIgnoreCase("youtuber")) {
				if (p.hasPermission("tag.youtuber")) {
					p.sendMessage(String.valueOf(ArkuzPvP.prefix) + " §4➼ §7Tag Alterada Com Sucesso");
					p.setDisplayName("§b§lYT §b" + p.getName() + ChatColor.WHITE);
					p.setPlayerListName("§b" + getShortStr(p.getName()) + ChatColor.WHITE + ChatColor.ITALIC);
					Bukkit.dispatchCommand((CommandSender) Bukkit.getConsoleSender(),
							"ne prefix " + p.getName() + " &b&lYT &7");
					return true;
				}
				p.sendMessage(String.valueOf(ArkuzPvP.prefix) + " §4➼ §7Sem Permissão");
			}
			if (args[0].equalsIgnoreCase("youtuber+")) {
				if (p.hasPermission("tag.youtuber+")) {
					p.sendMessage(String.valueOf(ArkuzPvP.prefix) + " §4➼ §7Tag Alterada Com Sucesso");
					p.setDisplayName("§1§lYT+ §1" + p.getName() + ChatColor.WHITE);
					p.setPlayerListName("§1" + getShortStr(p.getName()) + ChatColor.WHITE + ChatColor.ITALIC);
					Bukkit.dispatchCommand((CommandSender) Bukkit.getConsoleSender(),
							"ne prefix " + p.getName() + " &1&lYT+ &7");
					return true;
				}
				p.sendMessage(String.valueOf(ArkuzPvP.prefix) + " §4➼ §7Sem Permissão");
			}
			if (args[0].equalsIgnoreCase("helper")) {
				if (p.hasPermission("tag.helper")) {
					p.sendMessage(String.valueOf(ArkuzPvP.prefix) + " §4➼ §7Tag Alterada Com Sucesso");
					p.setDisplayName("§8§lHELPER §8" + p.getName() + ChatColor.WHITE);
					p.setPlayerListName("§8" + getShortStr(p.getName()) + ChatColor.WHITE + ChatColor.ITALIC);
					Bukkit.dispatchCommand((CommandSender) Bukkit.getConsoleSender(),
							"ne prefix " + p.getName() + " &8&lHELPER &7");
					return true;
				}
				p.sendMessage(String.valueOf(ArkuzPvP.prefix) + " §4➼ §7Sem Permissão");
			}
			if (args[0].equalsIgnoreCase("builder")) {
				if (p.hasPermission("tag.builder")) {
					p.sendMessage(String.valueOf(ArkuzPvP.prefix) + " §4➼ §7Tag Alterada Com Sucesso");
					p.setDisplayName("§2§lBuilder §2" + p.getName() + ChatColor.WHITE);
					p.setPlayerListName("§2" + getShortStr(p.getName()) + ChatColor.WHITE + ChatColor.ITALIC);
					Bukkit.dispatchCommand((CommandSender) Bukkit.getConsoleSender(),
							"ne prefix " + p.getName() + " &2&lBUILDER &7");
					return true;
				}
				p.sendMessage(String.valueOf(ArkuzPvP.prefix) + " §4➼ §7Sem Permissão");
			}
			if (args[0].equalsIgnoreCase("trial")) {
				if (p.hasPermission("tag.trial")) {
					p.sendMessage(String.valueOf(ArkuzPvP.prefix) + " §4➼ §7Tag Alterada Com Sucesso");
					p.setDisplayName("§5§lTRIAL §5" + p.getName() + ChatColor.WHITE);
					p.setPlayerListName("§5" + getShortStr(p.getName()) + ChatColor.WHITE + ChatColor.ITALIC);
					Bukkit.dispatchCommand((CommandSender) Bukkit.getConsoleSender(),
							"ne prefix " + p.getName() + " &5&lTRIAL &7");
					return true;
				}
				p.sendMessage(String.valueOf(ArkuzPvP.prefix) + " §4➼ §7Sem Permissão");
			}
			if (args[0].equalsIgnoreCase("mod")) {
				if (p.hasPermission("tag.mod")) {
					p.sendMessage(String.valueOf(ArkuzPvP.prefix) + " §4➼ §7Tag Alterada Com Sucesso");
					p.setDisplayName("§5§lMOD §5" + p.getName() + ChatColor.WHITE);
					p.setPlayerListName("§5" + getShortStr(p.getName()) + ChatColor.WHITE + ChatColor.ITALIC);
					Bukkit.dispatchCommand((CommandSender) Bukkit.getConsoleSender(),
							"ne prefix " + p.getName() + " &5&lMOD &7");
					return true;
				}
				p.sendMessage(String.valueOf(ArkuzPvP.prefix) + " §4➼ §7Sem Permissão");
			}
			if (args[0].equalsIgnoreCase("mod+")) {
				if (p.hasPermission("tag.mod+")) {
					p.sendMessage(String.valueOf(ArkuzPvP.prefix) + " §4➼ §7Tag Alterada Com Sucesso");
					p.setDisplayName("§5§lMOD+ §5" + p.getName() + ChatColor.WHITE);
					p.setPlayerListName("§5" + getShortStr(p.getName()) + ChatColor.WHITE + ChatColor.ITALIC);
					Bukkit.dispatchCommand((CommandSender) Bukkit.getConsoleSender(),
							"ne prefix " + p.getName() + " &5&lMOD+ &7");
					return true;
				}
				p.sendMessage(String.valueOf(ArkuzPvP.prefix) + " §4➼ §7Sem Permissão");
			}
			if (args[0].equalsIgnoreCase("admin")) {
				if (p.hasPermission("tag.admin")) {
					p.sendMessage(String.valueOf(ArkuzPvP.prefix) + " §4➼ §7Tag Alterada Com Sucesso");
					p.setDisplayName("§c§lADMIN §c" + p.getName() + ChatColor.WHITE);
					p.setPlayerListName("§c" + getShortStr(p.getName()) + ChatColor.WHITE + ChatColor.ITALIC);
					Bukkit.dispatchCommand((CommandSender) Bukkit.getConsoleSender(),
							"ne prefix " + p.getName() + " &c&lADMIN &7");
					return true;
				}
				p.sendMessage(String.valueOf(ArkuzPvP.prefix) + " §4➼ §7Sem Permissão");
			}
			if (args[0].equalsIgnoreCase("diretor")) {
				if (p.hasPermission("tag.diretor")) {
					p.sendMessage(String.valueOf(ArkuzPvP.prefix) + " §4➼ §7Tag Alterada Com Sucesso");
					p.setDisplayName("§c§lDIRETOR §c" + p.getName() + ChatColor.WHITE);
					p.setPlayerListName("§c" + getShortStr(p.getName()) + ChatColor.WHITE + ChatColor.ITALIC);
					Bukkit.dispatchCommand((CommandSender) Bukkit.getConsoleSender(),
							"ne prefix " + p.getName() + " &c&lDIRETOR &7");
					return true;
				}
				p.sendMessage(String.valueOf(ArkuzPvP.prefix) + " §4➼ §7Sem Permissão");
			}
			if (args[0].equalsIgnoreCase("diretora")) {
				if (p.hasPermission("tag.diretora")) {
					p.sendMessage(String.valueOf(ArkuzPvP.prefix) + " §4➼ §7Tag Alterada Com Sucesso");
					p.setDisplayName("§c§lDIRETORA §c" + p.getName() + ChatColor.WHITE);
					p.setPlayerListName("§c" + getShortStr(p.getName()) + ChatColor.WHITE + ChatColor.ITALIC);
					Bukkit.dispatchCommand((CommandSender) Bukkit.getConsoleSender(),
							"ne prefix " + p.getName() + " &c&lDIRETORA &7");
					return true;
				}
				p.sendMessage(String.valueOf(ArkuzPvP.prefix) + " §4➼ §7Sem Permissão");
			}
			if (args[0].equalsIgnoreCase("dono")) {
				if (p.hasPermission("tag.dono")) {
					p.sendMessage(String.valueOf(ArkuzPvP.prefix) + " §4➼ §7Tag Alterada Com Sucesso");
					p.setDisplayName("§4§lDONO §4" + p.getName() + ChatColor.WHITE);
					p.setPlayerListName("§4" + getShortStr(p.getName()) + ChatColor.WHITE + ChatColor.ITALIC);
					Bukkit.dispatchCommand((CommandSender) Bukkit.getConsoleSender(),
							"ne prefix " + p.getName() + " &4&lDONO &7");
					return true;
				}
				p.sendMessage(String.valueOf(ArkuzPvP.prefix) + " §4➼ §7Sem Permissão");
			}
			if (args[0].equalsIgnoreCase("gerente")) {
				if (p.hasPermission("tag.gerente")) {
					p.sendMessage(String.valueOf(ArkuzPvP.prefix) + " §4➼ §7Tag Alterada Com Sucesso");
					p.setDisplayName("§3§lGERENTE §3" + p.getName() + ChatColor.WHITE);
					p.setPlayerListName("§3" + getShortStr(p.getName()) + ChatColor.WHITE + ChatColor.ITALIC);
					Bukkit.dispatchCommand((CommandSender) Bukkit.getConsoleSender(),
							"ne prefix " + p.getName() + " &3&lGERENTE &7");
					return true;
				}
				p.sendMessage(String.valueOf(ArkuzPvP.prefix) + " §4➼ §7Sem Permissão");
			}
			return false;
		}
		if (p.hasPermission("*")) {
			p.sendMessage(String.valueOf(ArkuzPvP.prefix) + " §4➼ §7Suas Tags");
			p.sendMessage("§c➼ §7§lNormal");
			p.sendMessage("§c➼ §a§lUltra");
			p.sendMessage("§c➼ §6Pro");
			p.sendMessage("§c➼ §b§lYoutuber");
			p.sendMessage("§c➼ §1§lYoutuber+");
			p.sendMessage("§c➼ §8§lHelper");
			p.sendMessage("§c➼ §2§lBuilder");
			p.sendMessage("§c➼ §5§lTrial");
			p.sendMessage("§c➼ §5§lMod");
			p.sendMessage("§c➼ §5§lMod+");
			p.sendMessage("§c➼ §c§lAdmin");
			p.sendMessage("§c➼ §c§lGerente");
			p.sendMessage("§c➼ §c§lDiretor");
			p.sendMessage("§c➼ §c§lDiretora");
			p.sendMessage("§c➼ §4§lDono");
			return true;
		}
		if (p.hasPermission("tag.normal")) {
			p.sendMessage(String.valueOf(ArkuzPvP.prefix) + " §4➼ §7Suas Tags");
			p.sendMessage("§c➼ §7§lNormal");
		}
		if (p.hasPermission("tag.Ultra")) {
			p.sendMessage(String.valueOf(ArkuzPvP.prefix) + " §4➼ §7Suas Tags");
			p.sendMessage("§c➼ §7§lNormal");
			p.sendMessage("§c➼ §a§lUltra");
		}
		if (p.hasPermission("tag.pro")) {
			p.sendMessage(String.valueOf(ArkuzPvP.prefix) + " §4➼ §7Suas Tags");
			p.sendMessage("§c➼ §7§lNormal");
			p.sendMessage("§c➼ §6§lPro");
		}
		if (p.hasPermission("tag.youtuber")) {
			p.sendMessage(String.valueOf(ArkuzPvP.prefix) + " §4➼ §7Suas Tags");
			p.sendMessage("§c➼ §7§lNormal");
			p.sendMessage("§c➼ §b§lYoutuber");
		}
		if (p.hasPermission("tag.youtuber+")) {
			p.sendMessage(String.valueOf(ArkuzPvP.prefix) + " §4➼ §7Suas Tags");
			p.sendMessage("§c➼ §7§lNormal");
			p.sendMessage("§c➼ §1§lYoutuber+");
		}
		if (p.hasPermission("tag.helper")) {
			p.sendMessage(String.valueOf(ArkuzPvP.prefix) + " §4➼ §7Suas Tags");
			p.sendMessage("§c➼ §7§lNormal");
			p.sendMessage("§c➼ §6§lHelper");
		}
		if (p.hasPermission("tag.builder")) {
			p.sendMessage(String.valueOf(ArkuzPvP.prefix) + " §4➼ §7Suas Tags");
			p.sendMessage("§c➼ §7§lNormal");
			p.sendMessage("§c➼ §2§lBuilder");
		}
		if (p.hasPermission("tag.trial")) {
			p.sendMessage(String.valueOf(ArkuzPvP.prefix) + " §4➼ §7Suas Tags");
			p.sendMessage("§c➼ §7§lNormal");
			p.sendMessage("§c➼ §5§lTrial");
		}
		if (p.hasPermission("tag.mod")) {
			p.sendMessage(String.valueOf(ArkuzPvP.prefix) + " §4➼ §7Suas Tags");
			p.sendMessage("§c➼ §7§lNormal");
			p.sendMessage("§c➼ §5§lMod");
		}
		if (p.hasPermission("tag.mod+")) {
			p.sendMessage(String.valueOf(ArkuzPvP.prefix) + " §4➼ §7Suas Tags");
			p.sendMessage("§c➼ §7§lNormal");
			p.sendMessage("§c➼ §5§lMod+");
		}
		if (p.hasPermission("tag.admin")) {
			p.sendMessage(String.valueOf(ArkuzPvP.prefix) + " §4➼ §7Suas Tags");
			p.sendMessage("§c➼ §7§lNormal");
			p.sendMessage("§c➼ §c§lAdmin");
		}
		if (p.hasPermission("tag.gerente")) {
			p.sendMessage(String.valueOf(ArkuzPvP.prefix) + " §4➼ §7Suas Tags");
			p.sendMessage("§c➼ §7§lNormal");
			p.sendMessage("§c➼ §c§lGerente");
		}
		if (p.hasPermission("tag.diretor")) {
			p.sendMessage(String.valueOf(ArkuzPvP.prefix) + " §4➼ §7Suas Tags");
			p.sendMessage("§c➼ §7§lNormal");
			p.sendMessage("§c➼ §c§lDiretor");
		}
		if (p.hasPermission("tag.diretora")) {
			p.sendMessage(String.valueOf(ArkuzPvP.prefix) + " §4➼ §7Suas Tags");
			p.sendMessage("§c➼ §7§lNormal");
			p.sendMessage("§c➼ §c§lDiretora");
		}
		if (p.hasPermission("tag.dono")) {
			p.sendMessage(String.valueOf(ArkuzPvP.prefix) + " §4➼ §7Suas Tags");
			p.sendMessage("§c➼ §7§lNormal");
			p.sendMessage("§c➼ §a§lUltra");
			p.sendMessage("§c➼ §6§lPro");
			p.sendMessage("§c➼ §b§lYoutuber");
			p.sendMessage("§c➼ §1§lYoutuber+");
			p.sendMessage("§c➼ §6§lHelper");
			p.sendMessage("§c➼ §2§lBuilder");
			p.sendMessage("§c➼ §5§lTrial");
			p.sendMessage("§c➼ §5§lMod");
			p.sendMessage("§c➼ §c§lAdmin");
			p.sendMessage("§c➼ §c§lGerente");
			p.sendMessage("§c➼ §c§lDiretor");
			p.sendMessage("§c➼ §c§lDiretora");
			p.sendMessage("§c➼ §4§lDono");
		}
		return false;
	}

	public static String getShortStr(final String s) {
		if (s.length() == 16) {
			final String shorts = s.substring(0, s.length() - 6);
			return shorts;
		}
		if (s.length() == 15) {
			final String shorts = s.substring(0, s.length() - 5);
			return shorts;
		}
		if (s.length() == 14) {
			final String shorts = s.substring(0, s.length() - 4);
			return shorts;
		}
		if (s.length() == 13) {
			final String shorts = s.substring(0, s.length() - 4);
			return shorts;
		}
		if (s.length() == 12) {
			final String shorts = s.substring(0, s.length() - 2);
			return shorts;
		}
		if (s.length() == 11) {
			final String shorts = s.substring(0, s.length() - 1);
			return shorts;
		}
		return s;
	}

	@EventHandler
	public void aoEntrar(final PlayerJoinEvent e) {
		final Player p = e.getPlayer();
		p.setDisplayName("§7§lPLAYER §7" + p.getName() + ChatColor.WHITE);
		p.setPlayerListName("§7" + getShortStr(p.getName()) + ChatColor.WHITE + ChatColor.ITALIC);
		Bukkit.dispatchCommand((CommandSender) Bukkit.getConsoleSender(),
				"ne prefix " + p.getName() + " &7&lPLAYER &7");
	}
}
