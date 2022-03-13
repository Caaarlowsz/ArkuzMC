package com.github.caaarlowsz.arkuzmc.kitpvp;

import Caixas.*;
import Coins.*;
import Comandos.*;
import Essencial.KitAPI;
import Eventos.*;
import Invs.*;
import Kits.*;
import Minigames.Clicktest;
import Minigames.Minigames;
import Score.ScoreBoarding;
import Score.Status;
import Warps.SetSpawn;
import Warps.SetWarp;
import Warps.Spawn;
import Warps.irWarp;
import com.github.caaarlowsz.kitpvpapi.KitPvP;
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

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class ArkuzPvP extends JavaPlugin implements KitPvP {

    private static ArkuzPvP instance;

    public static ArkuzPvP getInstance() {
        return instance;
    }

    @Override
    public void onEnable() {
        super.onEnable();
        instance = this;

        //TODO: Remover quando melhorar a classe principal
        this.enable();
    }

    @Override
    public void onDisable() {
        super.onDisable();
        instance = null;

        //TODO: Remover quando melhorar a classe principal
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
        }.runTaskTimer((Plugin) this, 0L, 20L);
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
        this.Kits();
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
        Eventos.registerEvents((Listener) new Teleport(), (Plugin) this);
        Eventos.registerEvents((Listener) new Gamemode(), (Plugin) this);
        Eventos.registerEvents((Listener) new Givekit(), (Plugin) this);
        Eventos.registerEvents((Listener) new GivePermission(), (Plugin) this);
        Eventos.registerEvents((Listener) new Givevip(), (Plugin) this);
        Eventos.registerEvents((Listener) new Broadcast(), (Plugin) this);
        Eventos.registerEvents((Listener) new Head(), (Plugin) this);
        Eventos.registerEvents((Listener) new Fly(), (Plugin) this);
        Eventos.registerEvents((Listener) new ClearChat(), (Plugin) this);
        Eventos.registerEvents((Listener) new Rank(), (Plugin) this);
        Eventos.registerEvents((Listener) new StaffChat(), (Plugin) this);
        Eventos.registerEvents((Listener) new Inv(), (Plugin) this);
        Eventos.registerEvents((Listener) new Chat(), (Plugin) this);
        Eventos.registerEvents((Listener) new Admin(), (Plugin) this);
        Eventos.registerEvents((Listener) new AutoSoup(), (Plugin) this);
        Eventos.registerEvents((Listener) new Report(), (Plugin) this);
        Eventos.registerEvents((Listener) new Build(), (Plugin) this);
        Eventos.registerEvents((Listener) new Ajuda(), (Plugin) this);
        Eventos.registerEvents((Listener) new Comum(), (Plugin) this);
        Eventos.registerEvents((Listener) new cPlugin(), (Plugin) this);
        Eventos.registerEvents((Listener) new Habilidade(), (Plugin) this);
        Eventos.registerEvents((Listener) new KitAPI(), (Plugin) this);
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
        Eventos.registerEvents((Listener) new TabPersonalizado(), (Plugin) this);
        Eventos.registerEvents((Listener) new Kit(), (Plugin) this);
        Eventos.registerEvents((Listener) new Manutencao(), (Plugin) this);
        Eventos.registerEvents((Listener) new SetArena(), (Plugin) this);
        Eventos.registerEvents((Listener) new InvKits(), (Plugin) this);
        Eventos.registerEvents((Listener) new ClickDef(), (Plugin) this);
        Eventos.registerEvents((Listener) new Bussola(), (Plugin) this);
        Eventos.registerEvents((Listener) new irWarp(), (Plugin) this);
        Eventos.registerEvents((Listener) new Status(), (Plugin) this);
        Eventos.registerEvents((Listener) new Permissionlist(), (Plugin) this);
        Eventos.registerEvents((Listener) new Spawn(), (Plugin) this);
        Eventos.registerEvents((Listener) new Tag(), (Plugin) this);
        Eventos.registerEvents((Listener) new SetSpawn(), (Plugin) this);
        Eventos.registerEvents((Listener) new SetWarp(), (Plugin) this);
        Eventos.registerEvents((Listener) new InvWarps(), (Plugin) this);
        Eventos.registerEvents((Listener) new InvWarps2(), (Plugin) this);
        Eventos.registerEvents((Listener) new ScoreBoarding(), (Plugin) this);
        Eventos.registerEvents((Listener) new Score(), (Plugin) this);
        Eventos.registerEvents((Listener) new RemovePermission(), (Plugin) this);
        Eventos.registerEvents((Listener) new Ping(), (Plugin) this);
        Eventos.registerEvents((Listener) new Score(), (Plugin) this);
        Eventos.registerEvents((Listener) new Jump(), (Plugin) this);
        Eventos.registerEvents((Listener) new PlacaDeSopa(), (Plugin) this);
        Eventos.registerEvents((Listener) new InvKits2(), (Plugin) this);
        Eventos.registerEvents((Listener) new Nerfs(), (Plugin) this);
        Eventos.registerEvents((Listener) new Youtuber(), (Plugin) this);
        Eventos.registerEvents((Listener) new GanharXP(), (Plugin) this);
        Eventos.registerEvents((Listener) new MyConfigManager(this), (Plugin) this);
        Eventos.registerEvents((Listener) new VerXp(), (Plugin) this);
        Eventos.registerEvents((Listener) new XpM(), (Plugin) this);
        Eventos.registerEvents((Listener) new Caixas(), (Plugin) this);
        Eventos.registerEvents((Listener) new InvEscolha(), (Plugin) this);
        Eventos.registerEvents((Listener) new SKit(), (Plugin) this);
        Eventos.registerEvents((Listener) new SorteioVip(), (Plugin) this);
        Eventos.registerEvents((Listener) new SorteioKit(), (Plugin) this);
        Eventos.registerEvents((Listener) new InvOutros(), (Plugin) this);
        Eventos.registerEvents((Listener) new InvItems(), (Plugin) this);
        Eventos.registerEvents((Listener) new InvLoja(), (Plugin) this);
        Eventos.registerEvents((Listener) new Limpar(), (Plugin) this);
        Eventos.registerEvents((Listener) new InvRanks(), (Plugin) this);
        Eventos.registerEvents((Listener) new InvLojakits(), (Plugin) this);
        Eventos.registerEvents((Listener) new InvLeve(), (Plugin) this);
        Eventos.registerEvents((Listener) new InvPesada(), (Plugin) this);
        Eventos.registerEvents((Listener) new InvXP(), (Plugin) this);
        Eventos.registerEvents((Listener) new InvSkulls(), (Plugin) this);
        Eventos.registerEvents((Listener) new AntSpam(), (Plugin) this);
        Eventos.registerEvents((Listener) new Clicktest(), (Plugin) this);
        Eventos.registerEvents((Listener) new Minigames(), (Plugin) this);
        Eventos.registerEvents((Listener) new InvTreino(), (Plugin) this);
        Eventos.registerEvents((Listener) new InvCosmeticos(), (Plugin) this);
        Eventos.registerEvents((Listener) new Fake(), (Plugin) this);
    }

    void Comandos() {
        this.getCommand("gm").setExecutor((CommandExecutor) new Gamemode());
        this.getCommand("teleport").setExecutor((CommandExecutor) new Teleport());
        this.getCommand("gamemode").setExecutor((CommandExecutor) new Gamemode());
        this.getCommand("givekit").setExecutor((CommandExecutor) new Givekit());
        this.getCommand("givepermission").setExecutor((CommandExecutor) new GivePermission());
        this.getCommand("givevip").setExecutor((CommandExecutor) new Givevip());
        this.getCommand("bc").setExecutor((CommandExecutor) new Broadcast());
        this.getCommand("clicktest").setExecutor((CommandExecutor) new Clicktest());
        this.getCommand("broadcast").setExecutor((CommandExecutor) new Broadcast());
        this.getCommand("fly").setExecutor((CommandExecutor) new Fly());
        this.getCommand("head").setExecutor((CommandExecutor) new Head());
        this.getCommand("sc").setExecutor((CommandExecutor) new StaffChat());
        this.getCommand("cc").setExecutor((CommandExecutor) new ClearChat());
        this.getCommand("chat").setExecutor((CommandExecutor) new Chat());
        this.getCommand("inv").setExecutor((CommandExecutor) new Inv());
        this.getCommand("rank").setExecutor((CommandExecutor) new Rank());
        this.getCommand("ajuda").setExecutor((CommandExecutor) new Ajuda());
        this.getCommand("admin").setExecutor((CommandExecutor) new Admin());
        this.getCommand("autosoup").setExecutor((CommandExecutor) new AutoSoup());
        this.getCommand("tpall").setExecutor((CommandExecutor) new Tpall());
        this.getCommand("report").setExecutor((CommandExecutor) new Report());
        this.getCommand("build").setExecutor((CommandExecutor) new Build());
        this.getCommand("vis").setExecutor((CommandExecutor) new Vis());
        this.getCommand("tag").setExecutor((CommandExecutor) new Tag());
        this.getCommand("suicide").setExecutor((CommandExecutor) new Suicide());
        this.getCommand("lojakits").setExecutor((CommandExecutor) new InvLojakits());
        this.getCommand("pvp").setExecutor((CommandExecutor) new PvP());
        this.getCommand("regras").setExecutor((CommandExecutor) new Regras());
        this.getCommand("removervip").setExecutor((CommandExecutor) new RemoverVip());
        this.getCommand("removepermission").setExecutor((CommandExecutor) new RemovePermission());
        this.getCommand("aplicar").setExecutor((CommandExecutor) new Aplicar());
        this.getCommand("kit").setExecutor((CommandExecutor) new Kit());
        this.getCommand("manutencao").setExecutor((CommandExecutor) new Manutencao());
        this.getCommand("tell").setExecutor((CommandExecutor) new Tell());
        this.getCommand("setarena").setExecutor((CommandExecutor) new SetArena());
        this.getCommand("warp").setExecutor((CommandExecutor) new irWarp());
        this.getCommand("set").setExecutor((CommandExecutor) new SetWarp());
        this.getCommand("spawn").setExecutor((CommandExecutor) new Spawn());
        this.getCommand("setspawn").setExecutor((CommandExecutor) new SetSpawn());
        this.getCommand("permissionslist").setExecutor((CommandExecutor) new Permissionlist());
        this.getCommand("ping").setExecutor((CommandExecutor) new Ping());
        this.getCommand("limpar").setExecutor((CommandExecutor) new Limpar());
        this.getCommand("score").setExecutor((CommandExecutor) new Score());
        this.getCommand("youtuber").setExecutor((CommandExecutor) new Youtuber());
        this.getCommand("mp").setExecutor((CommandExecutor) new VerXp());
        this.getCommand("gratis").setExecutor((CommandExecutor) new DarXp());
        this.getCommand("caixas").setExecutor((CommandExecutor) new Caixas());
        this.getCommand("rkit").setExecutor((CommandExecutor) new rKit());
        this.getCommand("skit").setExecutor((CommandExecutor) new SKit());
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
        Eventos.registerEvents((Listener) new DeshFire(), (Plugin) this);
        Eventos.registerEvents((Listener) new Fisherman(), (Plugin) this);
        Eventos.registerEvents((Listener) new Gladiator(), (Plugin) this);
        Eventos.registerEvents((Listener) new Hulk(), (Plugin) this);
        Eventos.registerEvents((Listener) new JellyFish(), (Plugin) this);
        Eventos.registerEvents((Listener) new Kangaroo(), (Plugin) this);
        Eventos.registerEvents((Listener) new Magma(), (Plugin) this);
        Eventos.registerEvents((Listener) new Monk(), (Plugin) this);
        Eventos.registerEvents((Listener) new Ninja(), (Plugin) this);
        Eventos.registerEvents((Listener) new Phantom(), (Plugin) this);
        Eventos.registerEvents((Listener) new Poseidon(), (Plugin) this);
        Eventos.registerEvents((Listener) new Resouper(), (Plugin) this);
        Eventos.registerEvents((Listener) new Snail(), (Plugin) this);
        Eventos.registerEvents((Listener) new Sonic(), (Plugin) this);
        Eventos.registerEvents((Listener) new Stomper(), (Plugin) this);
        Eventos.registerEvents((Listener) new Switcher(), (Plugin) this);
        Eventos.registerEvents((Listener) new Swords(), (Plugin) this);
        Eventos.registerEvents((Listener) new Terrorista(), (Plugin) this);
        Eventos.registerEvents((Listener) new Grappler(), (Plugin) this);
        Eventos.registerEvents((Listener) new TheForceField(), (Plugin) this);
        Eventos.registerEvents((Listener) new Thor(), (Plugin) this);
        Eventos.registerEvents((Listener) new Thresh(), (Plugin) this);
        Eventos.registerEvents((Listener) new QuickDropper(), (Plugin) this);
        Eventos.registerEvents((Listener) new Turtle(), (Plugin) this);
        Eventos.registerEvents((Listener) new Phantom(), (Plugin) this);
        Eventos.registerEvents((Listener) new Viking(), (Plugin) this);
        Eventos.registerEvents((Listener) new Viper(), (Plugin) this);
    }

    public void save() {
        try {
            this.warps.save(this.warpsfile);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}