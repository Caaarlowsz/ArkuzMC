package Score;

import Coins.XpM;
import Eventos.Habilidade;
import com.github.caaarlowsz.arkuzmc.kitpvp.ArkuzPvP;
import net.md_5.bungee.api.ChatColor;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.scoreboard.DisplaySlot;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Scoreboard;

import java.util.Random;

public class ScoreBoarding implements Listener {
	public static ArkuzPvP plugin;

	public static String Rank(final Player p) {
		final double a = Status.getKills(p);
		if (a <= 100.0) {
			return "§f✖";
		}
		if (a <= 200.0) {
			return "§a✾";
		}
		if (a <= 300.0) {
			return "§e✿";
		}
		if (a <= 400.0) {
			return "§1✥";
		}
		if (a <= 500.0) {
			return "§7✯";
		}
		if (a <= 600.0) {
			return "§6✪";
		}
		if (a <= 700.0) {
			return "§b❈";
		}
		if (a <= 800.0) {
			return "§2✸";
		}
		if (a <= 900.0) {
			return "§c✦";
		}
		if (a <= 1000.0) {
			return "§3✷";
		}
		if (a <= 1500.0) {
			return "§4❂";
		}
		return "§4❂";
	}

	public static String getRankConfig(final Player p) {
		final double a = Status.getKills(p);
		if (a <= 100.0) {
			return "§fUNRANKED";
		}
		if (a <= 200.0) {
			return "§aINICIANTE";
		}
		if (a <= 300.0) {
			return "§eAPRENDIZ";
		}
		if (a <= 400.0) {
			return "§1EXPERT";
		}
		if (a <= 500.0) {
			return "§7SILVER";
		}
		if (a <= 600.0) {
			return "§6GOLD";
		}
		if (a <= 700.0) {
			return "§bDIAMOND";
		}
		if (a <= 800.0) {
			return "§2EMERALD";
		}
		if (a <= 900.0) {
			return "§cRUBY";
		}
		if (a <= 1000.0) {
			return "§3SAFIRA";
		}
		if (a <= 1500.0) {
			return "§4LENDARIO";
		}
		return "§4LENDARIO";
	}

	public static String getNomeRank(final Player p) {
		final double a = Status.getKills(p);
		if (a <= 100.0) {
			return "§fUNRANKED";
		}
		if (a <= 200.0) {
			return "§aINICIANTE";
		}
		if (a <= 300.0) {
			return "§eAPRENDIZ";
		}
		if (a <= 400.0) {
			return "§1EXPERT";
		}
		if (a <= 500.0) {
			return "§7SILVER";
		}
		if (a <= 600.0) {
			return "§6GOLD";
		}
		if (a <= 700.0) {
			return "§bDIAMOND";
		}
		if (a <= 800.0) {
			return "§2EMERALD";
		}
		if (a <= 900.0) {
			return "§CRUBY";
		}
		if (a <= 1000.0) {
			return "§3SAFIRA";
		}
		if (a <= 1500.0) {
			return "§4LENDARIO";
		}
		return "§4LENDARIO";
	}

	public static String Liga(final Player p) {
		final double a = Status.getKills(p);
		if (a <= 100.0) {
			return "§fUNRANKED";
		}
		if (a <= 200.0) {
			return "§aINICIANTE";
		}
		if (a <= 300.0) {
			return "§eAPRENDIZ";
		}
		if (a <= 400.0) {
			return "§1EXPERT";
		}
		if (a <= 500.0) {
			return "§7SILVER";
		}
		if (a <= 600.0) {
			return "§6GOLD";
		}
		if (a <= 700.0) {
			return "§bDIAMOND";
		}
		if (a <= 800.0) {
			return "§2EMERALD";
		}
		if (a <= 900.0) {
			return "§cRUBY";
		}
		if (a <= 1000.0) {
			return "§3SAFIRA";
		}
		if (a <= 1500.0) {
			return "§4LENDARIO";
		}
		return "§4LENDARIO";
	}

	public static void setScoreBoard(final Player p) {
		final String jogadoronline = String.valueOf(String.valueOf(Bukkit.getServer().getOnlinePlayers().length))
				+ "§7/§f" + Bukkit.getServer().getMaxPlayers();
		final Random r = new Random();
		final int animar = r.nextInt(12);
		if (animar == 1) {
			final SimpleScoreboard scoreboard = new SimpleScoreboard(ArkuzPvP.prefix);
			scoreboard.add("   " + ArkuzPvP.loja);
			scoreboard.blankLine();
			scoreboard.add(
					"§fKills: §7" + ArkuzPvP.getInstance().getConfig().getInt("status." + p.getName().toLowerCase() + ".kills"));
			scoreboard.add(
					"§fDeaths: §e" + ArkuzPvP.getInstance().getConfig().getInt("status." + p.getName().toLowerCase() + ".mortes"));
			scoreboard.blankLine();
			scoreboard.add("§fMoedas: §e" + XpM.getPlayerMoney(p));
			scoreboard.add("§fKit: §7" + Habilidade.getAbility(p));
			scoreboard.add("§fJogadores: §7" + jogadoronline);
			scoreboard.add("§fRank: " + Rank(p));
			scoreboard.add("§fLiga: " + Liga(p));
			scoreboard.blankLine();
			scoreboard.build();
			scoreboard.send(p);
		}
		if (animar == 2) {
			final SimpleScoreboard scoreboard = new SimpleScoreboard(ArkuzPvP.prefix);
			scoreboard.add("   " + ArkuzPvP.loja);
			scoreboard.blankLine();
			scoreboard.add(
					"§fKills: §7" + ArkuzPvP.getInstance().getConfig().getInt("status." + p.getName().toLowerCase() + ".kills"));
			scoreboard.add(
					"§fDeaths: §e" + ArkuzPvP.getInstance().getConfig().getInt("status." + p.getName().toLowerCase() + ".mortes"));
			scoreboard.blankLine();
			scoreboard.add("§fMoedas: §e" + XpM.getPlayerMoney(p));
			scoreboard.add("§fKit: §7" + Habilidade.getAbility(p));
			scoreboard.add("§fJogadores: §7" + jogadoronline);
			scoreboard.add("§fRank: " + Rank(p));
			scoreboard.add("§fLiga: " + Liga(p));
			scoreboard.blankLine();
			scoreboard.build();
			scoreboard.send(p);
		}
		if (animar == 3) {
			final SimpleScoreboard scoreboard = new SimpleScoreboard(ArkuzPvP.prefix);
			scoreboard.add("   " + ArkuzPvP.loja);
			scoreboard.blankLine();
			scoreboard.add(
					"§fKills: §7" + ArkuzPvP.getInstance().getConfig().getInt("status." + p.getName().toLowerCase() + ".kills"));
			scoreboard.add(
					"§fDeaths: §e" + ArkuzPvP.getInstance().getConfig().getInt("status." + p.getName().toLowerCase() + ".mortes"));
			scoreboard.blankLine();
			scoreboard.add("§fMoedas: §e" + XpM.getPlayerMoney(p));
			scoreboard.add("§fKit: §7" + Habilidade.getAbility(p));
			scoreboard.add("§fJogadores: §7" + jogadoronline);
			scoreboard.add("§fRank: " + Rank(p));
			scoreboard.add("§fLiga: " + Liga(p));
			scoreboard.blankLine();
			scoreboard.build();
			scoreboard.send(p);
		}
		if (animar == 4) {
			final SimpleScoreboard scoreboard = new SimpleScoreboard(ArkuzPvP.prefix);
			scoreboard.add("   " + ArkuzPvP.loja);
			scoreboard.blankLine();
			scoreboard.add(
					"§fKills: §7" + ArkuzPvP.getInstance().getConfig().getInt("status." + p.getName().toLowerCase() + ".kills"));
			scoreboard.add(
					"§fDeaths: §e" + ArkuzPvP.getInstance().getConfig().getInt("status." + p.getName().toLowerCase() + ".mortes"));
			scoreboard.blankLine();
			scoreboard.add("§fMoedas: §e" + XpM.getPlayerMoney(p));
			scoreboard.add("§fKit: §7" + Habilidade.getAbility(p));
			scoreboard.add("§fJogadores: §7" + jogadoronline);
			scoreboard.add("§fRank: " + Rank(p));
			scoreboard.add("§fLiga: " + Liga(p));
			scoreboard.blankLine();
			scoreboard.build();
			scoreboard.send(p);
		}
		if (animar == 5) {
			final SimpleScoreboard scoreboard = new SimpleScoreboard(ArkuzPvP.prefix);
			scoreboard.add("   " + ArkuzPvP.loja);
			scoreboard.blankLine();
			scoreboard.add(
					"§fKills: §7" + ArkuzPvP.getInstance().getConfig().getInt("status." + p.getName().toLowerCase() + ".kills"));
			scoreboard.add(
					"§fDeaths: §e" + ArkuzPvP.getInstance().getConfig().getInt("status." + p.getName().toLowerCase() + ".mortes"));
			scoreboard.blankLine();
			scoreboard.add("§fMoedas: §e" + XpM.getPlayerMoney(p));
			scoreboard.add("§fKit: §7" + Habilidade.getAbility(p));
			scoreboard.add("§fJogadores: §7" + jogadoronline);
			scoreboard.add("§fRank: " + Rank(p));
			scoreboard.add("§fLiga: " + Liga(p));
			scoreboard.blankLine();
			scoreboard.build();
			scoreboard.send(p);
		}
		if (animar == 6) {
			final SimpleScoreboard scoreboard = new SimpleScoreboard(ArkuzPvP.prefix);
			scoreboard.add("   " + ArkuzPvP.loja);
			scoreboard.blankLine();
			scoreboard.add(
					"§fKills: §7" + ArkuzPvP.getInstance().getConfig().getInt("status." + p.getName().toLowerCase() + ".kills"));
			scoreboard.add(
					"§fDeaths: §e" + ArkuzPvP.getInstance().getConfig().getInt("status." + p.getName().toLowerCase() + ".mortes"));
			scoreboard.blankLine();
			scoreboard.add("§fMoedas: §e" + XpM.getPlayerMoney(p));
			scoreboard.add("§fKit: §7" + Habilidade.getAbility(p));
			scoreboard.add("§fJogadores: §7" + jogadoronline);
			scoreboard.add("§fRank: " + Rank(p));
			scoreboard.add("§fLiga: " + Liga(p));
			scoreboard.blankLine();
			scoreboard.build();
			scoreboard.send(p);
		}
		if (animar == 7) {
			final SimpleScoreboard scoreboard = new SimpleScoreboard(ArkuzPvP.prefix);
			scoreboard.add("   " + ArkuzPvP.loja);
			scoreboard.blankLine();
			scoreboard.add(
					"§fKills: §7" + ArkuzPvP.getInstance().getConfig().getInt("status." + p.getName().toLowerCase() + ".kills"));
			scoreboard.add(
					"§fDeaths: §e" + ArkuzPvP.getInstance().getConfig().getInt("status." + p.getName().toLowerCase() + ".mortes"));
			scoreboard.blankLine();
			scoreboard.add("§fMoedas: §e" + XpM.getPlayerMoney(p));
			scoreboard.add("§fKit: §7" + Habilidade.getAbility(p));
			scoreboard.add("§fJogadores: §7" + jogadoronline);
			scoreboard.add("§fRank: " + Rank(p));
			scoreboard.add("§fLiga: " + Liga(p));
			scoreboard.blankLine();
			scoreboard.build();
			scoreboard.send(p);
		}
		if (animar == 8) {
			final SimpleScoreboard scoreboard = new SimpleScoreboard(ArkuzPvP.prefix);
			scoreboard.add("   " + ArkuzPvP.loja);
			scoreboard.blankLine();
			scoreboard.add(
					"§fKills: §7" + ArkuzPvP.getInstance().getConfig().getInt("status." + p.getName().toLowerCase() + ".kills"));
			scoreboard.add(
					"§fDeaths: §e" + ArkuzPvP.getInstance().getConfig().getInt("status." + p.getName().toLowerCase() + ".mortes"));
			scoreboard.blankLine();
			scoreboard.add("§fMoedas: §e" + XpM.getPlayerMoney(p));
			scoreboard.add("§fKit: §7" + Habilidade.getAbility(p));
			scoreboard.add("§fJogadores: §7" + jogadoronline);
			scoreboard.add("§fRank: " + Rank(p));
			scoreboard.add("§fLiga: " + Liga(p));
			scoreboard.blankLine();
			scoreboard.build();
			scoreboard.send(p);
		}
	}

	public static void removeScoreBoard(final Player p) {
		final Scoreboard score = Bukkit.getScoreboardManager().getNewScoreboard();
		final Objective o = score.registerNewObjective("tuts", "PvP");
		o.setDisplaySlot(DisplaySlot.SIDEBAR);
		o.setDisplayName("");
		p.setScoreboard(score);
	}
}
