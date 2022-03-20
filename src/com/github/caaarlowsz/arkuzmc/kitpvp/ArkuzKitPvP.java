package com.github.caaarlowsz.arkuzmc.kitpvp;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.Set;

import org.bukkit.Bukkit;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.HandlerList;
import org.bukkit.event.Listener;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitRunnable;

import com.github.caaarlowsz.arkuzmc.kitpvp.kit.ArkuzAjninKit;
import com.github.caaarlowsz.arkuzmc.kitpvp.kit.ArkuzArcherKit;
import com.github.caaarlowsz.arkuzmc.kitpvp.kit.ArkuzArmorKit;
import com.github.caaarlowsz.arkuzmc.kitpvp.kit.ArkuzAvatarKit;
import com.github.caaarlowsz.arkuzmc.kitpvp.kit.ArkuzC4Kit;
import com.github.caaarlowsz.arkuzmc.kitpvp.kit.ArkuzDeshFireKit;
import com.github.caaarlowsz.arkuzmc.kitpvp.kit.ArkuzFishermanKit;
import com.github.caaarlowsz.arkuzmc.kitpvp.kit.ArkuzForceFieldKit;
import com.github.caaarlowsz.arkuzmc.kitpvp.kit.ArkuzGladiatorKit;
import com.github.caaarlowsz.arkuzmc.kitpvp.kit.ArkuzKangarooKit;
import com.github.caaarlowsz.arkuzmc.kitpvp.kit.ArkuzKit;
import com.github.caaarlowsz.arkuzmc.kitpvp.kit.ArkuzMagmaKit;
import com.github.caaarlowsz.arkuzmc.kitpvp.kit.ArkuzMonkKit;
import com.github.caaarlowsz.arkuzmc.kitpvp.kit.ArkuzNinjaKit;
import com.github.caaarlowsz.arkuzmc.kitpvp.kit.ArkuzPoseidonKit;
import com.github.caaarlowsz.arkuzmc.kitpvp.kit.ArkuzPvPKit;
import com.github.caaarlowsz.arkuzmc.kitpvp.kit.ArkuzResouperKit;
import com.github.caaarlowsz.arkuzmc.kitpvp.kit.ArkuzSnailKit;
import com.github.caaarlowsz.arkuzmc.kitpvp.kit.ArkuzSonicKit;
import com.github.caaarlowsz.arkuzmc.kitpvp.kit.ArkuzStomperKit;
import com.github.caaarlowsz.arkuzmc.kitpvp.kit.ArkuzSwitcherKit;
import com.github.caaarlowsz.arkuzmc.kitpvp.kit.ArkuzSwordsKit;
import com.github.caaarlowsz.arkuzmc.kitpvp.kit.ArkuzTerroristaKit;
import com.github.caaarlowsz.arkuzmc.kitpvp.kit.ArkuzThreshKit;
import com.github.caaarlowsz.arkuzmc.kitpvp.kit.ArkuzTurtleKit;
import com.github.caaarlowsz.arkuzmc.kitpvp.kit.ArkuzVikingKit;
import com.github.caaarlowsz.arkuzmc.kitpvp.kit.ArkuzViperKit;
import com.github.caaarlowsz.kitpvpapi.Kit;
import com.github.caaarlowsz.kitpvpapi.KitPvP;
import com.github.caaarlowsz.kitpvpapi.KitPvPAPI;

import Caixas.Caixas;
import Caixas.InvEscolha;
import Caixas.InvItems;
import Caixas.InvLeve;
import Caixas.InvPesada;
import Coins.DarXp;
import Coins.GanharXP;
import Coins.MyConfigManager;
import Coins.VerXp;
import Coins.XpM;
import Comandos.Admin;
import Comandos.Ajuda;
import Comandos.Aplicar;
import Comandos.AutoSoup;
import Comandos.Broadcast;
import Comandos.Build;
import Comandos.Chat;
import Comandos.ClearChat;
import Comandos.Fake;
import Comandos.Fly;
import Comandos.Gamemode;
import Comandos.GivePermission;
import Comandos.Givekit;
import Comandos.Givevip;
import Comandos.Head;
import Comandos.Inv;
import Comandos.Limpar;
import Comandos.Manutencao;
import Comandos.Permissionlist;
import Comandos.Ping;
import Comandos.PvP;
import Comandos.Rank;
import Comandos.Regras;
import Comandos.RemovePermission;
import Comandos.RemoverVip;
import Comandos.Report;
import Comandos.SKit;
import Comandos.Score;
import Comandos.SetArena;
import Comandos.SorteioKit;
import Comandos.SorteioVip;
import Comandos.StaffChat;
import Comandos.Suicide;
import Comandos.Tag;
import Comandos.Teleport;
import Comandos.Tell;
import Comandos.Tpall;
import Comandos.Vis;
import Comandos.Youtuber;
import Comandos.cPlugin;
import Comandos.rKit;
import Essencial.KitAPI;
import Eventos.AntSpam;
import Eventos.Bot;
import Eventos.Bussola;
import Eventos.ChatForm;
import Eventos.ClickDef;
import Eventos.Comum;
import Eventos.Habilidade;
import Eventos.Join;
import Eventos.Jump;
import Eventos.Mensagens;
import Eventos.Nerfs;
import Eventos.PlacaDeSopa;
import Eventos.TabPersonalizado;
import Invs.InvCosmeticos;
import Invs.InvKits;
import Invs.InvKits2;
import Invs.InvLoja;
import Invs.InvLojakits;
import Invs.InvOutros;
import Invs.InvRanks;
import Invs.InvSkulls;
import Invs.InvTreino;
import Invs.InvWarps;
import Invs.InvWarps2;
import Invs.InvXP;
import Kits.Anchor;
import Kits.Grappler;
import Kits.Hulk;
import Kits.JellyFish;
import Kits.Phantom;
import Kits.QuickDropper;
import Minigames.Clicktest;
import Minigames.Minigames;
import Score.ScoreBoarding;
import Score.Status;
import Warps.SetSpawn;
import Warps.SetWarp;
import Warps.Spawn;
import Warps.irWarp;

public final class ArkuzKitPvP extends JavaPlugin implements KitPvP {

	private final Set<Kit> kits = new LinkedHashSet<>();

	@Override
	public Set<Kit> getKits() {
		return Collections.unmodifiableSet(this.kits);
	}

	@Override
	public Kit getKitByName(String name) {
		return this.getKits().stream().filter(kit -> kit.getName().equalsIgnoreCase(name)).findFirst().orElse(null);
	}

	@Override
	public void addKit(Kit kit) {
		if (Listener.class.isAssignableFrom(kit.getClass()))
			Bukkit.getPluginManager().registerEvents((Listener) kit, this);
		this.kits.add(kit);
	}

	@Override
	public void removeKit(Kit kit) {
		if (Listener.class.isAssignableFrom(kit.getClass()))
			HandlerList.unregisterAll((Listener) kit);
		this.kits.remove(kit);
	}

	public static ArkuzKitPvP getInstance() {
		return getPlugin(ArkuzKitPvP.class);
	}

	@Override
	public void onEnable() {
		super.onEnable();
		KitPvPAPI.setInstance(this);

		this.addKit(new ArkuzPvPKit());
		this.addKit(new ArkuzAjninKit());
		this.addKit(new ArkuzArcherKit());
		this.addKit(new ArkuzArmorKit());
		this.addKit(new ArkuzAvatarKit());
		this.addKit(new ArkuzC4Kit());
		this.addKit(new ArkuzDeshFireKit());
		this.addKit(new ArkuzFishermanKit());
		this.addKit(new ArkuzKangarooKit());
		this.addKit(new ArkuzMagmaKit());
		this.addKit(new ArkuzMonkKit());
		this.addKit(new ArkuzNinjaKit());
		this.addKit(new ArkuzGladiatorKit());
		this.addKit(new ArkuzPoseidonKit());
		this.addKit(new ArkuzResouperKit());
		this.addKit(new ArkuzSnailKit());
		this.addKit(new ArkuzSonicKit());
		this.addKit(new ArkuzStomperKit());
		this.addKit(new ArkuzSwitcherKit());
		this.addKit(new ArkuzSwordsKit());
		this.addKit(new ArkuzTerroristaKit());
		this.addKit(new ArkuzForceFieldKit());
		this.addKit(new ArkuzThreshKit());
		this.addKit(new ArkuzTurtleKit());
		this.addKit(new ArkuzVikingKit());
		this.addKit(new ArkuzViperKit());

		final PluginManager Eventos = Bukkit.getPluginManager();
		Eventos.registerEvents(new Grappler(), this);
		this.addKit(new ArkuzKit("Grappler"));
		Eventos.registerEvents(new JellyFish(), this);
		this.addKit(new ArkuzKit("JellyFish"));
		Eventos.registerEvents(new QuickDropper(), this);
		this.addKit(new ArkuzKit("QuickDropper"));
		Eventos.registerEvents(new Phantom(), this);
		Eventos.registerEvents(new Phantom(), this);
		this.addKit(new ArkuzKit("Phantom"));
		Eventos.registerEvents(new Hulk(), this);
		this.addKit(new ArkuzKit("Hulk"));
		Eventos.registerEvents(new Anchor(), this);
		this.addKit(new ArkuzKit("Anchor"));

		// TODO: Remover quando melhorar a classe principal
		this.enable();
	}

	@Override
	public void onDisable() {
		super.onDisable();
		KitPvPAPI.setInstance(null);

		// TODO: Remover quando melhorar a classe principal
		this.disable();
	}

	// TODO: Melhorar a classe principal...
	public File warpsfile;
	public YamlConfiguration warps;
	public static String prefix;
	public static String ts;
	public static String motd;
	public static String twitter;
	public static MyConfigManager manager;
	public static String loja;
	public static ArrayList<String> score = new ArrayList<>();
	public static ArrayList<String> staff = new ArrayList<>();
	public static String form;

	public void onLoad() {
		Player[] onlinePlayers;
		for (int length = (onlinePlayers = Bukkit.getOnlinePlayers()).length, i = 0; i < length; ++i) {
			final Player todos = onlinePlayers[i];
			final ArrayList<String> msg = new ArrayList<String>();
			msg.add("§7Servidor foi §cReiniciado §7ou §cFechado §7!");
			todos.kickPlayer(String.valueOf(msg));
		}
	}

	public void enable() {
		try {
			this.saveDefaultConfig();
		} catch (Exception ex) {
		}

		prefix = this.getConfig().getString("Prefix").replace("&", "§");
		twitter = this.getConfig().getString("Twitter").replace("&", "§");
		ts = this.getConfig().getString("TeamSpeak").replace("&", "§");
		motd = this.getConfig().getString("Motd").replace("&", "§");
		form = this.getConfig().getString("Formulario").replace("&", "§");
		loja = this.getConfig().getString("Loja").replace("&", "§");
		new BukkitRunnable() {
			public void run() {
				Player[] arrayOfPlayer;
				for (int j = (arrayOfPlayer = Bukkit.getOnlinePlayers()).length, i = 0; i < j; ++i) {
					final Player p = arrayOfPlayer[i];
					if (!score.contains(p.getName())) {
						ScoreBoarding.setScoreBoard(p);
					} else {
						ScoreBoarding.removeScoreBoard(p);
					}
				}
			}
		}.runTaskTimer(this, 0L, 20L);
		final File warps = new File(this.getDataFolder(), "warps.yml");
		if (!warps.exists()) {
			this.saveResource("warps.yml", false);
		}
		this.warpsfile = new File(this.getDataFolder(), "warps.yml");
		this.warps = YamlConfiguration.loadConfiguration(this.warpsfile);
		final ConsoleCommandSender e = Bukkit.getConsoleSender();
		e.sendMessage("§a§m------------------------------");
		e.sendMessage("§a➼ Plugin Iniciado Com Sucesso ");
		e.sendMessage("§a➼ Plugin  feito  Por    §3§lFleaShot !  ");
		e.sendMessage("§a§m------------------------------");
		this.saveDefaultConfig();
		this.getConfig().options().copyDefaults(true);
		this.getConfig().options().copyHeader(true);
		this.saveConfig();
		manager = new MyConfigManager(this);
		XpM.loadMoneyManager();
		this.Eventos();
		this.Comandos();
	}

	public void disable() {
		final ConsoleCommandSender e = Bukkit.getConsoleSender();
		e.sendMessage("§c§m------------------------------");
		e.sendMessage("§➼ Plugin Desabilitado Com Sucesso ");
		e.sendMessage("§c➼ Plugin feito   Por    §3§l FleaShot !      ");
		e.sendMessage("§c§m------------------------------");
	}

	public void Eventos() {
		final PluginManager Eventos = Bukkit.getPluginManager();
		Eventos.registerEvents(new Teleport(), this);
		Eventos.registerEvents(new Gamemode(), this);
		Eventos.registerEvents(new Givekit(), this);
		Eventos.registerEvents(new GivePermission(), this);
		Eventos.registerEvents(new Givevip(), this);
		Eventos.registerEvents(new Broadcast(), this);
		Eventos.registerEvents(new Head(), this);
		Eventos.registerEvents(new Fly(), this);
		Eventos.registerEvents(new ClearChat(), this);
		Eventos.registerEvents(new Rank(), this);
		Eventos.registerEvents(new StaffChat(), this);
		Eventos.registerEvents(new Inv(), this);
		Eventos.registerEvents(new Chat(), this);
		Eventos.registerEvents(new Admin(), this);
		Eventos.registerEvents(new AutoSoup(), this);
		Eventos.registerEvents(new Report(), this);
		Eventos.registerEvents(new Build(), this);
		Eventos.registerEvents(new Ajuda(), this);
		Eventos.registerEvents(new Comum(), this);
		Eventos.registerEvents(new cPlugin(), this);
		Eventos.registerEvents(new Habilidade(), this);
		Eventos.registerEvents(new KitAPI(), this);
		Eventos.registerEvents(new Join(), this);
		Eventos.registerEvents(new Suicide(), this);
		Eventos.registerEvents(new Mensagens(), this);
		Eventos.registerEvents(new ChatForm(), this);
		Eventos.registerEvents(new Bot(), this);
		Eventos.registerEvents(new Tpall(), this);
		Eventos.registerEvents(new PvP(), this);
		Eventos.registerEvents(new Regras(), this);
		Eventos.registerEvents(new RemoverVip(), this);
		Eventos.registerEvents(new Aplicar(), this);
		Eventos.registerEvents(new TabPersonalizado(), this);
		Eventos.registerEvents(new Comandos.Kit(), this);
		Eventos.registerEvents(new Manutencao(), this);
		Eventos.registerEvents(new SetArena(), this);
		Eventos.registerEvents(new InvKits(), this);
		Eventos.registerEvents(new ClickDef(), this);
		Eventos.registerEvents(new Bussola(), this);
		Eventos.registerEvents(new irWarp(), this);
		Eventos.registerEvents(new Status(), this);
		Eventos.registerEvents(new Permissionlist(), this);
		Eventos.registerEvents(new Spawn(), this);
		Eventos.registerEvents(new Tag(), this);
		Eventos.registerEvents(new SetSpawn(), this);
		Eventos.registerEvents(new SetWarp(), this);
		Eventos.registerEvents(new InvWarps(), this);
		Eventos.registerEvents(new InvWarps2(), this);
		Eventos.registerEvents(new ScoreBoarding(), this);
		Eventos.registerEvents(new Score(), this);
		Eventos.registerEvents(new RemovePermission(), this);
		Eventos.registerEvents(new Ping(), this);
		Eventos.registerEvents(new Score(), this);
		Eventos.registerEvents(new Jump(), this);
		Eventos.registerEvents(new PlacaDeSopa(), this);
		Eventos.registerEvents(new InvKits2(), this);
		Eventos.registerEvents(new Nerfs(), this);
		Eventos.registerEvents(new Youtuber(), this);
		Eventos.registerEvents(new GanharXP(), this);
		Eventos.registerEvents(new MyConfigManager(this), this);
		Eventos.registerEvents(new VerXp(), this);
		Eventos.registerEvents(new XpM(), this);
		Eventos.registerEvents(new Caixas(), this);
		Eventos.registerEvents(new InvEscolha(), this);
		Eventos.registerEvents(new SKit(), this);
		Eventos.registerEvents(new SorteioVip(), this);
		Eventos.registerEvents(new SorteioKit(), this);
		Eventos.registerEvents(new InvOutros(), this);
		Eventos.registerEvents(new InvItems(), this);
		Eventos.registerEvents(new InvLoja(), this);
		Eventos.registerEvents(new Limpar(), this);
		Eventos.registerEvents(new InvRanks(), this);
		Eventos.registerEvents(new InvLojakits(), this);
		Eventos.registerEvents(new InvLeve(), this);
		Eventos.registerEvents(new InvPesada(), this);
		Eventos.registerEvents(new InvXP(), this);
		Eventos.registerEvents(new InvSkulls(), this);
		Eventos.registerEvents(new AntSpam(), this);
		Eventos.registerEvents(new Clicktest(), this);
		Eventos.registerEvents(new Minigames(), this);
		Eventos.registerEvents(new InvTreino(), this);
		Eventos.registerEvents(new InvCosmeticos(), this);
		Eventos.registerEvents(new Fake(), this);
	}

	void Comandos() {
		this.getCommand("gm").setExecutor(new Gamemode());
		this.getCommand("teleport").setExecutor(new Teleport());
		this.getCommand("gamemode").setExecutor(new Gamemode());
		this.getCommand("givekit").setExecutor(new Givekit());
		this.getCommand("givepermission").setExecutor(new GivePermission());
		this.getCommand("givevip").setExecutor(new Givevip());
		this.getCommand("bc").setExecutor(new Broadcast());
		this.getCommand("clicktest").setExecutor(new Clicktest());
		this.getCommand("broadcast").setExecutor(new Broadcast());
		this.getCommand("fly").setExecutor(new Fly());
		this.getCommand("head").setExecutor(new Head());
		this.getCommand("sc").setExecutor(new StaffChat());
		this.getCommand("cc").setExecutor(new ClearChat());
		this.getCommand("chat").setExecutor(new Chat());
		this.getCommand("inv").setExecutor(new Inv());
		this.getCommand("rank").setExecutor(new Rank());
		this.getCommand("ajuda").setExecutor(new Ajuda());
		this.getCommand("admin").setExecutor(new Admin());
		this.getCommand("autosoup").setExecutor(new AutoSoup());
		this.getCommand("tpall").setExecutor(new Tpall());
		this.getCommand("report").setExecutor(new Report());
		this.getCommand("build").setExecutor(new Build());
		this.getCommand("vis").setExecutor(new Vis());
		this.getCommand("tag").setExecutor(new Tag());
		this.getCommand("suicide").setExecutor(new Suicide());
		this.getCommand("lojakits").setExecutor(new InvLojakits());
		this.getCommand("pvp").setExecutor(new PvP());
		this.getCommand("regras").setExecutor(new Regras());
		this.getCommand("removervip").setExecutor(new RemoverVip());
		this.getCommand("removepermission").setExecutor(new RemovePermission());
		this.getCommand("aplicar").setExecutor(new Aplicar());
		this.getCommand("kit").setExecutor(new Comandos.Kit());
		this.getCommand("manutencao").setExecutor(new Manutencao());
		this.getCommand("tell").setExecutor(new Tell());
		this.getCommand("setarena").setExecutor(new SetArena());
		this.getCommand("warp").setExecutor(new irWarp());
		this.getCommand("set").setExecutor(new SetWarp());
		this.getCommand("spawn").setExecutor(new Spawn());
		this.getCommand("setspawn").setExecutor(new SetSpawn());
		this.getCommand("permissionslist").setExecutor(new Permissionlist());
		this.getCommand("ping").setExecutor(new Ping());
		this.getCommand("limpar").setExecutor(new Limpar());
		this.getCommand("score").setExecutor(new Score());
		this.getCommand("youtuber").setExecutor(new Youtuber());
		this.getCommand("mp").setExecutor(new VerXp());
		this.getCommand("gratis").setExecutor(new DarXp());
		this.getCommand("caixas").setExecutor(new Caixas());
		this.getCommand("rkit").setExecutor(new rKit());
		this.getCommand("skit").setExecutor(new SKit());
		this.getCommand("sortearvip").setExecutor(new SorteioVip());
		this.getCommand("sortearkit").setExecutor(new SorteioKit());
		this.getCommand("fake").setExecutor(new Fake());
	}

	public void save() {
		try {
			this.warps.save(this.warpsfile);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}