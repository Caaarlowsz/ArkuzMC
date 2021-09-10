package Main;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitRunnable;

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
import Comandos.Kit;
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
import Kits.Ajnin;
import Kits.Anchor;
import Kits.Armor;
import Kits.Avatar;
import Kits.C4;
import Kits.DeshFire;
import Kits.Fisherman;
import Kits.Gladiator;
import Kits.Grappler;
import Kits.Hulk;
import Kits.JellyFish;
import Kits.Kangaroo;
import Kits.Magma;
import Kits.Monk;
import Kits.Ninja;
import Kits.Phantom;
import Kits.Poseidon;
import Kits.QuickDropper;
import Kits.Resouper;
import Kits.Snail;
import Kits.Sonic;
import Kits.Stomper;
import Kits.Switcher;
import Kits.Swords;
import Kits.Terrorista;
import Kits.TheForceField;
import Kits.Thor;
import Kits.Thresh;
import Kits.Turtle;
import Kits.Viking;
import Kits.Viper;
import Minigames.Clicktest;
import Minigames.Minigames;
import Score.ScoreBoarding;
import Score.Status;
import Warps.SetSpawn;
import Warps.SetWarp;
import Warps.Spawn;
import Warps.irWarp;

public class Main extends JavaPlugin {
	public File warpsfile;
	public YamlConfiguration warps;
	public static String prefix;
	public static String ts;
	public static String motd;
	public static String twitter;
	public static Plugin plugin;
	public static MyConfigManager manager;
	public static String loja;
	public static ArrayList<String> score;
	public static Main instance;
	public static ArrayList<String> staff;
	public static String form;

	static {
		Main.score = new ArrayList<String>();
		Main.staff = new ArrayList<String>();
	}

	public static Main getInstace() {
		return Main.instance;
	}

	public static Main getInstance() {
		return Main.instance;
	}

	public static Plugin getPlugin() {
		return Main.plugin;
	}

	public void onLoad() {
		Player[] onlinePlayers;
		for (int length = (onlinePlayers = Bukkit.getOnlinePlayers()).length, i = 0; i < length; ++i) {
			final Player todos = onlinePlayers[i];
			final ArrayList<String> msg = new ArrayList<String>();
			msg.add("§7Servidor foi §cReinicido §7ou §cFechado §7!");
			todos.kickPlayer(String.valueOf(msg));
		}
	}

	public void onEnable() {
		try {
			this.saveDefaultConfig();
		} catch (Exception ex) {
		}
		Main.prefix = this.getConfig().getString("Prefix").replace("&", "§");
		Main.twitter = this.getConfig().getString("Twitter").replace("&", "§");
		Main.ts = this.getConfig().getString("TeamSpeak").replace("&", "§");
		Main.motd = this.getConfig().getString("Motd").replace("&", "§");
		Main.form = this.getConfig().getString("Formulario").replace("&", "§");
		Main.loja = this.getConfig().getString("Loja").replace("&", "§");
		new BukkitRunnable() {
			public void run() {
				Player[] arrayOfPlayer;
				for (int j = (arrayOfPlayer = Bukkit.getOnlinePlayers()).length, i = 0; i < j; ++i) {
					final Player p = arrayOfPlayer[i];
					if (!Main.score.contains(p.getName())) {
						ScoreBoarding.setScoreBoard(p);
					} else {
						ScoreBoarding.removeScoreBoard(p);
					}
				}
			}
		}.runTaskTimer((Plugin) this, 0L, 20L);
		final File warps = new File(this.getDataFolder(), "warps.yml");
		if (!warps.exists()) {
			this.saveResource("warps.yml", false);
		}
		this.warpsfile = new File(this.getDataFolder(), "warps.yml");
		this.warps = YamlConfiguration.loadConfiguration(this.warpsfile);
		final ConsoleCommandSender e = Bukkit.getConsoleSender();
		e.sendMessage("§a§m------------------------------");
		e.sendMessage("§a\u27bc Plugin Iniciado Com Sucesso ");
		e.sendMessage("§a\u27bc Plugin  feito  Por    §3§lFleaShot !  ");
		e.sendMessage("§a§m------------------------------");
		this.saveDefaultConfig();
		Main.instance = this;
		Main.plugin = (Plugin) this;
		this.getConfig().options().copyDefaults(true);
		this.getConfig().options().copyHeader(true);
		this.saveConfig();
		Main.manager = new MyConfigManager(this);
		XpM.loadMoneyManager();
		this.Eventos();
		this.Comandos();
		this.Kits();
	}

	public void onDisable() {
		final ConsoleCommandSender e = Bukkit.getConsoleSender();
		e.sendMessage("§c§m------------------------------");
		e.sendMessage("§c\u27bc Plugin Desabilitado Com Sucesso ");
		e.sendMessage("§c\u27bc Plugin feito   Por    §3§l FleaShot !      ");
		e.sendMessage("§c§m------------------------------");
	}

	public void Eventos() {
		final PluginManager Eventos = Bukkit.getPluginManager();
		Eventos.registerEvents((Listener) new Teleport(), (Plugin) this);
		Eventos.registerEvents((Listener) new Gamemode(this), (Plugin) this);
		Eventos.registerEvents((Listener) new Givekit(), (Plugin) this);
		Eventos.registerEvents((Listener) new GivePermission(), (Plugin) this);
		Eventos.registerEvents((Listener) new Givevip(), (Plugin) this);
		Eventos.registerEvents((Listener) new Broadcast(), (Plugin) this);
		Eventos.registerEvents((Listener) new Head(), (Plugin) this);
		Eventos.registerEvents((Listener) new Fly(), (Plugin) this);
		Eventos.registerEvents((Listener) new ClearChat(this), (Plugin) this);
		Eventos.registerEvents((Listener) new Rank(), (Plugin) this);
		Eventos.registerEvents((Listener) new StaffChat(), (Plugin) this);
		Eventos.registerEvents((Listener) new Inv(), (Plugin) this);
		Eventos.registerEvents((Listener) new Chat(this), (Plugin) this);
		Eventos.registerEvents((Listener) new Admin(this), (Plugin) this);
		Eventos.registerEvents((Listener) new AutoSoup(this), (Plugin) this);
		Eventos.registerEvents((Listener) new Report(this), (Plugin) this);
		Eventos.registerEvents((Listener) new Build(), (Plugin) this);
		Eventos.registerEvents((Listener) new Ajuda(), (Plugin) this);
		Eventos.registerEvents((Listener) new Comum(), (Plugin) this);
		Eventos.registerEvents((Listener) new cPlugin(), (Plugin) this);
		Eventos.registerEvents((Listener) new Habilidade(this), (Plugin) this);
		Eventos.registerEvents((Listener) new KitAPI(this), (Plugin) this);
		Eventos.registerEvents((Listener) new Join(), (Plugin) this);
		Eventos.registerEvents((Listener) new Suicide(), (Plugin) this);
		Eventos.registerEvents((Listener) new Mensagens(), (Plugin) this);
		Eventos.registerEvents((Listener) new ChatForm(), (Plugin) this);
		Eventos.registerEvents((Listener) new Bot(), (Plugin) this);
		Eventos.registerEvents((Listener) new Tpall(), (Plugin) this);
		Eventos.registerEvents((Listener) new PvP(), (Plugin) this);
		Eventos.registerEvents((Listener) new Regras(), (Plugin) this);
		Eventos.registerEvents((Listener) new RemoverVip(), (Plugin) this);
		Eventos.registerEvents((Listener) new Aplicar(), (Plugin) this);
		Eventos.registerEvents((Listener) new TabPersonalizado(this), (Plugin) this);
		Eventos.registerEvents((Listener) new Kit(this), (Plugin) this);
		Eventos.registerEvents((Listener) new Manutencao(), (Plugin) this);
		Eventos.registerEvents((Listener) new SetArena(this), (Plugin) this);
		Eventos.registerEvents((Listener) new InvKits(this), (Plugin) this);
		Eventos.registerEvents((Listener) new ClickDef(), (Plugin) this);
		Eventos.registerEvents((Listener) new Bussola(), (Plugin) this);
		Eventos.registerEvents((Listener) new irWarp(), (Plugin) this);
		Eventos.registerEvents((Listener) new Status(), (Plugin) this);
		Eventos.registerEvents((Listener) new Permissionlist(), (Plugin) this);
		Eventos.registerEvents((Listener) new Spawn(this), (Plugin) this);
		Eventos.registerEvents((Listener) new Tag(this), (Plugin) this);
		Eventos.registerEvents((Listener) new SetSpawn(this), (Plugin) this);
		Eventos.registerEvents((Listener) new SetWarp(), (Plugin) this);
		Eventos.registerEvents((Listener) new InvWarps(), (Plugin) this);
		Eventos.registerEvents((Listener) new InvWarps2(), (Plugin) this);
		Eventos.registerEvents((Listener) new ScoreBoarding(), (Plugin) this);
		Eventos.registerEvents((Listener) new Score(), (Plugin) this);
		Eventos.registerEvents((Listener) new RemovePermission(), (Plugin) this);
		Eventos.registerEvents((Listener) new Ping(), (Plugin) this);
		Eventos.registerEvents((Listener) new Score(), (Plugin) this);
		Eventos.registerEvents((Listener) new Jump(this), (Plugin) this);
		Eventos.registerEvents((Listener) new PlacaDeSopa(), (Plugin) this);
		Eventos.registerEvents((Listener) new InvKits2(this), (Plugin) this);
		Eventos.registerEvents((Listener) new Nerfs(), (Plugin) this);
		Eventos.registerEvents((Listener) new Youtuber(), (Plugin) this);
		Eventos.registerEvents((Listener) new GanharXP(), (Plugin) this);
		Eventos.registerEvents((Listener) new MyConfigManager(this), (Plugin) this);
		Eventos.registerEvents((Listener) new VerXp(), (Plugin) this);
		Eventos.registerEvents((Listener) new XpM(), (Plugin) this);
		Eventos.registerEvents((Listener) new Caixas(this), (Plugin) this);
		Eventos.registerEvents((Listener) new InvEscolha(), (Plugin) this);
		Eventos.registerEvents((Listener) new SKit(this), (Plugin) this);
		Eventos.registerEvents((Listener) new SorteioVip(), (Plugin) this);
		Eventos.registerEvents((Listener) new SorteioKit(), (Plugin) this);
		Eventos.registerEvents((Listener) new InvOutros(), (Plugin) this);
		Eventos.registerEvents((Listener) new InvItems(), (Plugin) this);
		Eventos.registerEvents((Listener) new InvLoja(), (Plugin) this);
		Eventos.registerEvents((Listener) new Limpar(), (Plugin) this);
		Eventos.registerEvents((Listener) new InvRanks(), (Plugin) this);
		Eventos.registerEvents((Listener) new InvLojakits(this), (Plugin) this);
		Eventos.registerEvents((Listener) new InvLeve(), (Plugin) this);
		Eventos.registerEvents((Listener) new InvPesada(), (Plugin) this);
		Eventos.registerEvents((Listener) new InvXP(), (Plugin) this);
		Eventos.registerEvents((Listener) new InvSkulls(this), (Plugin) this);
		Eventos.registerEvents((Listener) new AntSpam(this), (Plugin) this);
		Eventos.registerEvents((Listener) new Clicktest(), (Plugin) this);
		Eventos.registerEvents((Listener) new Minigames(this), (Plugin) this);
		Eventos.registerEvents((Listener) new InvTreino(), (Plugin) this);
		Eventos.registerEvents((Listener) new InvCosmeticos(), (Plugin) this);
		Eventos.registerEvents((Listener) new Fake(), (Plugin) this);
	}

	void Comandos() {
		this.getCommand("gm").setExecutor((CommandExecutor) new Gamemode(this));
		this.getCommand("teleport").setExecutor((CommandExecutor) new Teleport());
		this.getCommand("gamemode").setExecutor((CommandExecutor) new Gamemode(this));
		this.getCommand("givekit").setExecutor((CommandExecutor) new Givekit());
		this.getCommand("givepermission").setExecutor((CommandExecutor) new GivePermission());
		this.getCommand("givevip").setExecutor((CommandExecutor) new Givevip());
		this.getCommand("bc").setExecutor((CommandExecutor) new Broadcast());
		this.getCommand("clicktest").setExecutor((CommandExecutor) new Clicktest());
		this.getCommand("broadcast").setExecutor((CommandExecutor) new Broadcast());
		this.getCommand("fly").setExecutor((CommandExecutor) new Fly());
		this.getCommand("head").setExecutor((CommandExecutor) new Head());
		this.getCommand("sc").setExecutor((CommandExecutor) new StaffChat());
		this.getCommand("cc").setExecutor((CommandExecutor) new ClearChat(this));
		this.getCommand("chat").setExecutor((CommandExecutor) new Chat(this));
		this.getCommand("inv").setExecutor((CommandExecutor) new Inv());
		this.getCommand("rank").setExecutor((CommandExecutor) new Rank());
		this.getCommand("ajuda").setExecutor((CommandExecutor) new Ajuda());
		this.getCommand("admin").setExecutor((CommandExecutor) new Admin(this));
		this.getCommand("autosoup").setExecutor((CommandExecutor) new AutoSoup(this));
		this.getCommand("tpall").setExecutor((CommandExecutor) new Tpall());
		this.getCommand("report").setExecutor((CommandExecutor) new Report(this));
		this.getCommand("build").setExecutor((CommandExecutor) new Build());
		this.getCommand("vis").setExecutor((CommandExecutor) new Vis());
		this.getCommand("tag").setExecutor((CommandExecutor) new Tag(this));
		this.getCommand("suicide").setExecutor((CommandExecutor) new Suicide());
		this.getCommand("lojakits").setExecutor((CommandExecutor) new InvLojakits(this));
		this.getCommand("pvp").setExecutor((CommandExecutor) new PvP());
		this.getCommand("regras").setExecutor((CommandExecutor) new Regras());
		this.getCommand("removervip").setExecutor((CommandExecutor) new RemoverVip());
		this.getCommand("removepermission").setExecutor((CommandExecutor) new RemovePermission());
		this.getCommand("aplicar").setExecutor((CommandExecutor) new Aplicar());
		this.getCommand("kit").setExecutor((CommandExecutor) new Kit(this));
		this.getCommand("manutencao").setExecutor((CommandExecutor) new Manutencao());
		this.getCommand("tell").setExecutor((CommandExecutor) new Tell());
		this.getCommand("setarena").setExecutor((CommandExecutor) new SetArena(this));
		this.getCommand("warp").setExecutor((CommandExecutor) new irWarp());
		this.getCommand("set").setExecutor((CommandExecutor) new SetWarp());
		this.getCommand("spawn").setExecutor((CommandExecutor) new Spawn(this));
		this.getCommand("setspawn").setExecutor((CommandExecutor) new SetSpawn(this));
		this.getCommand("permissionslist").setExecutor((CommandExecutor) new Permissionlist());
		this.getCommand("ping").setExecutor((CommandExecutor) new Ping());
		this.getCommand("limpar").setExecutor((CommandExecutor) new Limpar());
		this.getCommand("score").setExecutor((CommandExecutor) new Score());
		this.getCommand("youtuber").setExecutor((CommandExecutor) new Youtuber());
		this.getCommand("mp").setExecutor((CommandExecutor) new VerXp());
		this.getCommand("gratis").setExecutor((CommandExecutor) new DarXp());
		this.getCommand("caixas").setExecutor((CommandExecutor) new Caixas(this));
		this.getCommand("rkit").setExecutor((CommandExecutor) new rKit());
		this.getCommand("skit").setExecutor((CommandExecutor) new SKit(this));
		this.getCommand("sortearvip").setExecutor((CommandExecutor) new SorteioVip());
		this.getCommand("sortearkit").setExecutor((CommandExecutor) new SorteioKit());
		this.getCommand("fake").setExecutor((CommandExecutor) new Fake());
	}

	public void Kits() {
		final PluginManager Eventos = Bukkit.getPluginManager();
		Eventos.registerEvents((Listener) new Ajnin(), (Plugin) this);
		Eventos.registerEvents((Listener) new Anchor(), (Plugin) this);
		Eventos.registerEvents((Listener) new Armor(), (Plugin) this);
		Eventos.registerEvents((Listener) new Avatar(), (Plugin) this);
		Eventos.registerEvents((Listener) new C4(), (Plugin) this);
		Eventos.registerEvents((Listener) new DeshFire(this), (Plugin) this);
		Eventos.registerEvents((Listener) new Fisherman(this), (Plugin) this);
		Eventos.registerEvents((Listener) new Gladiator(this), (Plugin) this);
		Eventos.registerEvents((Listener) new Hulk(), (Plugin) this);
		Eventos.registerEvents((Listener) new JellyFish(), (Plugin) this);
		Eventos.registerEvents((Listener) new Kangaroo(this), (Plugin) this);
		Eventos.registerEvents((Listener) new Magma(), (Plugin) this);
		Eventos.registerEvents((Listener) new Monk(), (Plugin) this);
		Eventos.registerEvents((Listener) new Ninja(this), (Plugin) this);
		Eventos.registerEvents((Listener) new Phantom(this), (Plugin) this);
		Eventos.registerEvents((Listener) new Poseidon(), (Plugin) this);
		Eventos.registerEvents((Listener) new Resouper(), (Plugin) this);
		Eventos.registerEvents((Listener) new Snail(this), (Plugin) this);
		Eventos.registerEvents((Listener) new Sonic(this), (Plugin) this);
		Eventos.registerEvents((Listener) new Stomper(this), (Plugin) this);
		Eventos.registerEvents((Listener) new Switcher(), (Plugin) this);
		Eventos.registerEvents((Listener) new Swords(), (Plugin) this);
		Eventos.registerEvents((Listener) new Terrorista(), (Plugin) this);
		Eventos.registerEvents((Listener) new Grappler(this), (Plugin) this);
		Eventos.registerEvents((Listener) new TheForceField(this), (Plugin) this);
		Eventos.registerEvents((Listener) new Thor(), (Plugin) this);
		Eventos.registerEvents((Listener) new Thresh(this), (Plugin) this);
		Eventos.registerEvents((Listener) new QuickDropper(), (Plugin) this);
		Eventos.registerEvents((Listener) new Turtle(), (Plugin) this);
		Eventos.registerEvents((Listener) new Phantom(this), (Plugin) this);
		Eventos.registerEvents((Listener) new Viking(), (Plugin) this);
		Eventos.registerEvents((Listener) new Viper(this), (Plugin) this);
	}

	public void save() {
		try {
			this.warps.save(this.warpsfile);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
