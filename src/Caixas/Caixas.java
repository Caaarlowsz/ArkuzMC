package Caixas;

import Coins.XpM;
import Score.ScoreBoarding;
import com.github.caaarlowsz.arkuzmc.kitpvp.ArkuzKitPvP;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryHolder;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.Random;

public class Caixas implements Listener, CommandExecutor {
    public static ItemStack vidro;
    public static ItemStack fly;
    public static ItemMeta flymeta;
    public static ItemMeta vidrometa;
    public static ItemStack vidro2;
    public static ItemMeta vidro2meta;
    public static ItemStack tag;
    public static ItemMeta tagmeta;
    public static ItemStack resetkdr;
    public static ItemMeta resetkdrmeta;
    public static ItemStack todososkits;
    public static ItemMeta todososkitsmeta;
    public static ItemStack randomkit;
    public static ItemMeta randomkitmeta;
    public static ItemStack randomkit3;
    public static ItemMeta randomkit3meta;
    public static ItemStack randomkit2;
    public static ItemMeta randomkit2meta;

    @EventHandler
    public void warps(final InventoryClickEvent e) {
        if (e.getCurrentItem() != null && e.getCurrentItem().getItemMeta() != null) {
            final Inventory inv = e.getInventory();
            final Player p = (Player) e.getWhoClicked();
            if (inv.getTitle().equals("§8{ §cCaixas §8}")) {
                p.playSound(p.getLocation(), Sound.LEVEL_UP, 5.0f, 5.0f);
                e.setCancelled(true);
                p.closeInventory();
            }
            if (e.getCurrentItem().isSimilar(Caixas.todososkits)) {
                if (XpM.getPlayerMoney(p) < 50000) {
                    p.sendMessage(
                            String.valueOf(ArkuzKitPvP.prefix) + " §4➼ §7Você Não Possui Coins o Suficiente");
                } else {
                    XpM.getPlayerMoney(p);
                    XpM.removeMoney(p, 50000);
                    p.sendMessage(String.valueOf(ArkuzKitPvP.prefix) + "§7Você Comprou §aTodos Os Kits§7 Aproveite");
                    Bukkit.dispatchCommand((CommandSender) Bukkit.getConsoleSender(),
                            "pex user " + p.getName() + " add kit.*");
                    ScoreBoarding.setScoreBoard(p);
                }
            }
            if (e.getCurrentItem().isSimilar(Caixas.fly)) {
                if (XpM.getPlayerMoney(p) < 7000) {
                    p.sendMessage(
                            String.valueOf(ArkuzKitPvP.prefix) + " §4➼ §7Você Não Possui Coins o Suficiente");
                } else {
                    XpM.getPlayerMoney(p);
                    XpM.removeMoney(p, 7000);
                    p.sendMessage(String.valueOf(ArkuzKitPvP.prefix) + "§7Você Comprou §aFly§7 Aproveite");
                    Bukkit.dispatchCommand((CommandSender) Bukkit.getConsoleSender(),
                            "pex user " + p.getName() + " add kitpvp.fly");
                    ScoreBoarding.setScoreBoard(p);
                }
            }
            if (e.getCurrentItem().isSimilar(Caixas.tag)) {
                if (XpM.getPlayerMoney(p) < 4000) {
                    p.sendMessage(
                            String.valueOf(ArkuzKitPvP.prefix) + " §4➼ §7Você Não Possui Coins o Suficiente");
                } else {
                    XpM.getPlayerMoney(p);
                    XpM.removeMoney(p, 4000);
                    p.sendMessage(String.valueOf(ArkuzKitPvP.prefix) + " §4➼ §7Você Adquiriu §c");
                    Bukkit.dispatchCommand((CommandSender) Bukkit.getConsoleSender(),
                            "pex user " + p.getName() + " add tag.mc");
                    ScoreBoarding.setScoreBoard(p);
                }
            }
            if (e.getCurrentItem().isSimilar(Caixas.randomkit2)) {
                if (XpM.getPlayerMoney(p) < 5000) {
                    p.sendMessage(
                            String.valueOf(ArkuzKitPvP.prefix) + " §4➼ §7Você Não Possui Coins o Suficiente");
                } else {
                    XpM.removeMoney(p, 5000);
                    ScoreBoarding.setScoreBoard(p);
                    this.randomprata(p);
                }
            }
            if (e.getCurrentItem().isSimilar(Caixas.randomkit3)) {
                if (XpM.getPlayerMoney(p) < 1000) {
                    p.sendMessage(
                            String.valueOf(ArkuzKitPvP.prefix) + " §4➼ §7Você Não Possui Coins o Suficiente");
                } else {
                    XpM.removeMoney(p, 1000);
                    ScoreBoarding.setScoreBoard(p);
                    this.randomouro(p);
                }
            }
            if (e.getCurrentItem().isSimilar(Caixas.randomkit)) {
                if (XpM.getPlayerMoney(p) < 3000) {
                    p.sendMessage(
                            String.valueOf(ArkuzKitPvP.prefix) + " §4➼ §7Você Não Possui Coins o Suficiente");
                } else {
                    XpM.removeMoney(p, 3000);
                    ScoreBoarding.setScoreBoard(p);
                    this.randombronze(p);
                }
            }
        }
    }

    public boolean onCommand(final CommandSender sender, final Command cmd, final String label, final String[] args) {
        if (!(sender instanceof Player)) {
            return true;
        }
        final Player p = (Player) sender;
        if (cmd.getName().equalsIgnoreCase("caixas")) {
            final Inventory lojadeoutros = Bukkit.createInventory((InventoryHolder) p, 27, "§8{ §cCaixas §8}");
            final ItemStack event4 = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short) 15);
            final ItemMeta event4v = event4.getItemMeta();
            event4v.setDisplayName("§7-");
            event4.setItemMeta(event4v);
            lojadeoutros.setItem(2, event4);
            lojadeoutros.setItem(3, event4);
            lojadeoutros.setItem(4, event4);
            lojadeoutros.setItem(5, event4);
            lojadeoutros.setItem(6, event4);
            lojadeoutros.setItem(10, event4);
            lojadeoutros.setItem(12, event4);
            lojadeoutros.setItem(14, event4);
            lojadeoutros.setItem(16, event4);
            lojadeoutros.setItem(20, event4);
            lojadeoutros.setItem(21, event4);
            lojadeoutros.setItem(22, event4);
            lojadeoutros.setItem(23, event4);
            lojadeoutros.setItem(24, event4);
            final ItemStack event5 = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short) 14);
            final ItemMeta event45v = event5.getItemMeta();
            event45v.setDisplayName("§7+");
            event5.setItemMeta(event4v);
            lojadeoutros.setItem(26, event5);
            lojadeoutros.setItem(18, event5);
            final ItemStack event6 = new ItemStack(Material.INK_SACK, 1, (short) 8);
            final ItemMeta event451v = event6.getItemMeta();
            event451v.setDisplayName("§7{ §cAnterior §7}");
            event6.setItemMeta(event451v);
            lojadeoutros.setItem(0, event6);
            final ItemStack event7 = new ItemStack(Material.INK_SACK, 1, (short) 10);
            final ItemMeta event456v = event7.getItemMeta();
            event456v.setDisplayName("§7{ §aProximo §7}");
            event7.setItemMeta(event456v);
            lojadeoutros.setItem(8, event7);
            final ItemStack loja23 = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short) 0);
            final ItemMeta loja23v = loja23.getItemMeta();
            loja23v.setDisplayName("§7=");
            loja23.setItemMeta(loja23v);
            lojadeoutros.setItem(1, loja23);
            lojadeoutros.setItem(7, loja23);
            lojadeoutros.setItem(17, loja23);
            lojadeoutros.setItem(9, loja23);
            lojadeoutros.setItem(19, loja23);
            lojadeoutros.setItem(25, loja23);
            Caixas.randomkit = new ItemStack(Material.CHEST);
            (Caixas.randomkitmeta = Caixas.randomkit.getItemMeta()).setDisplayName("§7{ §aKits (Leve) §7} §2R$ 3000");
            Caixas.randomkit.setItemMeta(Caixas.randomkitmeta);
            Caixas.randomkit2 = new ItemStack(Material.ENDER_CHEST);
            (Caixas.randomkit2meta = Caixas.randomkit2.getItemMeta())
                    .setDisplayName("§7{ §cKits (Pesada) §7} §2R$ 5000");
            Caixas.randomkit2.setItemMeta(Caixas.randomkit2meta);
            Caixas.randomkit3 = new ItemStack(Material.GOLDEN_APPLE);
            (Caixas.randomkit3meta = Caixas.randomkit3.getItemMeta()).setDisplayName("§7{ §eCoins §7} §2R$ 1000");
            Caixas.randomkit3.setItemMeta(Caixas.randomkit3meta);
            for (int i = 0; i != 27; ++i) {
                lojadeoutros.setItem(11, Caixas.randomkit);
                lojadeoutros.setItem(13, Caixas.randomkit2);
                lojadeoutros.setItem(15, Caixas.randomkit3);
            }
            p.openInventory(lojadeoutros);
            return true;
        }
        return true;
    }

    public void randombronze(final Player p) {
        final Random r = new Random();
        final int o = r.nextInt(14);
        if (o == 0) {
            p.sendMessage(String.valueOf(ArkuzKitPvP.prefix) + " §4➼ §7Você Adquiriu §cKit Magma");
            Bukkit.dispatchCommand((CommandSender) Bukkit.getConsoleSender(),
                    "pex user " + p.getName() + " add kit.magma");
        } else if (o == 1) {
            p.sendMessage(String.valueOf(ArkuzKitPvP.prefix) + " §4➼ §7Você Adquiriu §cKit Sonic");
            Bukkit.dispatchCommand((CommandSender) Bukkit.getConsoleSender(),
                    "pex user " + p.getName() + " add kit.sonic");
        } else if (o == 2) {
            p.sendMessage(String.valueOf(ArkuzKitPvP.prefix) + " §4➼ §7Você Adquiriu §cKit Resouper");
            Bukkit.dispatchCommand((CommandSender) Bukkit.getConsoleSender(),
                    "pex user " + p.getName() + " add kit.resouper");
        } else if (o == 3) {
            p.sendMessage(String.valueOf(ArkuzKitPvP.prefix) + " §4➼ §7Você Adquiriu §cKit Armor");
            Bukkit.dispatchCommand((CommandSender) Bukkit.getConsoleSender(),
                    "pex user " + p.getName() + " add kit.armor");
        } else if (o == 4) {
            p.sendMessage(String.valueOf(ArkuzKitPvP.prefix) + " §4➼ §7Você Adquiriu §cKit Switcher");
            Bukkit.dispatchCommand((CommandSender) Bukkit.getConsoleSender(),
                    "pex user " + p.getName() + " add kit.switcher");
        } else if (o == 5) {
            p.sendMessage(String.valueOf(ArkuzKitPvP.prefix) + " §4➼ §7Você Adquiriu §cKit Thresh");
            Bukkit.dispatchCommand((CommandSender) Bukkit.getConsoleSender(),
                    "pex user " + p.getName() + " add kit.thresh");
        } else if (o == 6) {
            p.sendMessage(String.valueOf(ArkuzKitPvP.prefix) + " §4➼ §7Você Adquiriu §cKit Monk");
            Bukkit.dispatchCommand((CommandSender) Bukkit.getConsoleSender(),
                    "pex user " + p.getName() + " add kit.monk");
            XpM.addMoney(p, 1000);
        } else if (o == 7) {
            p.sendMessage(String.valueOf(ArkuzKitPvP.prefix) + " §4➼ §7Você Adquiriu §cKit Turtle");
            Bukkit.dispatchCommand((CommandSender) Bukkit.getConsoleSender(),
                    "pex user " + p.getName() + " add kit.turtle");
        } else if (o == 8) {
            p.sendMessage(String.valueOf(ArkuzKitPvP.prefix) + " §4➼ §7Você Adquiriu §cKit Ajnin");
            Bukkit.dispatchCommand((CommandSender) Bukkit.getConsoleSender(),
                    "pex user " + p.getName() + " add kit.ajnin");
        } else if (o == 9) {
            p.sendMessage(String.valueOf(ArkuzKitPvP.prefix) + " §4➼ §7Você Adquiriu §cKit Archer");
            Bukkit.dispatchCommand((CommandSender) Bukkit.getConsoleSender(),
                    "pex user " + p.getName() + " add kit.archer");
        } else if (o == 10) {
            p.sendMessage(String.valueOf(ArkuzKitPvP.prefix) + " §4➼ §7Você Adquiriu §cKit Thor");
            Bukkit.dispatchCommand((CommandSender) Bukkit.getConsoleSender(),
                    "pex user " + p.getName() + " add kit.thor");
        } else if (o == 11) {
            p.sendMessage(String.valueOf(ArkuzKitPvP.prefix) + " §4➼ §7Você Adquiriu §cKit Ninja");
            Bukkit.dispatchCommand((CommandSender) Bukkit.getConsoleSender(),
                    "pex user " + p.getName() + " add kit.ninja");
        } else if (o == 12) {
            p.sendMessage(String.valueOf(ArkuzKitPvP.prefix) + " §4➼ §7Você Adquiriu §cKit Resouper");
            Bukkit.dispatchCommand((CommandSender) Bukkit.getConsoleSender(),
                    "pex user " + p.getName() + " add kit.resouper");
        } else if (o == 13) {
            p.sendMessage(String.valueOf(ArkuzKitPvP.prefix) + " §4➼ §7Você Adquiriu §cKit Ajnin");
            Bukkit.dispatchCommand((CommandSender) Bukkit.getConsoleSender(),
                    "pex user " + p.getName() + " add kit.ajnin");
        } else if (o == 14) {
            p.sendMessage(String.valueOf(ArkuzKitPvP.prefix) + " §4➼ §7Você Adquiriu §cKit Thor");
            Bukkit.dispatchCommand((CommandSender) Bukkit.getConsoleSender(),
                    "pex user " + p.getName() + " add kit.thor");
            if (o == 7 || o == 8 || o == 9 || o == 10 || o == 11 || o == 12 || o != 13) {
            }
        }
    }

    public void randomprata(final Player p) {
        final Random r = new Random();
        final int o = r.nextInt(14);
        if (o == 0) {
            p.sendMessage(String.valueOf(ArkuzKitPvP.prefix) + " §4➼ §7Você Adquiriu §cKit ForceField");
            Bukkit.dispatchCommand((CommandSender) Bukkit.getConsoleSender(),
                    "pex user " + p.getName() + " add kit.forcefield");
        } else if (o == 1) {
            p.sendMessage(String.valueOf(ArkuzKitPvP.prefix) + " §4➼ §7Você Adquiriu §cKit Avatar");
            Bukkit.dispatchCommand((CommandSender) Bukkit.getConsoleSender(),
                    "pex user " + p.getName() + " add kit.avatar");
        } else if (o == 2) {
            p.sendMessage(String.valueOf(ArkuzKitPvP.prefix) + " §4➼ §7Você Adquiriu §cKit Gladiator");
            Bukkit.dispatchCommand((CommandSender) Bukkit.getConsoleSender(),
                    "pex user " + p.getName() + " add kit.gladiator");
        } else if (o == 3) {
            p.sendMessage(String.valueOf(ArkuzKitPvP.prefix) + " §4➼ §7Você Adquiriu §cKit Viking");
            Bukkit.dispatchCommand((CommandSender) Bukkit.getConsoleSender(),
                    "pex user " + p.getName() + " add kit.viking");
        } else if (o == 4) {
            p.sendMessage(String.valueOf(ArkuzKitPvP.prefix) + " §4➼ §7Você Adquiriu §cSwords");
            Bukkit.dispatchCommand((CommandSender) Bukkit.getConsoleSender(),
                    "pex user " + p.getName() + " add kit.swords");
        } else if (o == 5) {
            p.sendMessage(String.valueOf(ArkuzKitPvP.prefix) + " §4➼ §7Você Adquiriu §cC4");
            Bukkit.dispatchCommand((CommandSender) Bukkit.getConsoleSender(),
                    "pex user " + p.getName() + " add kit.c4");
        } else if (o == 6) {
            p.sendMessage(String.valueOf(ArkuzKitPvP.prefix) + " §4➼ §7Você Adquiriu §cKit Terrorista");
            Bukkit.dispatchCommand((CommandSender) Bukkit.getConsoleSender(),
                    "pex user " + p.getName() + " add kit.terrorista");
            XpM.addMoney(p, 1000);
        } else if (o == 7) {
            p.sendMessage(String.valueOf(ArkuzKitPvP.prefix) + " §4➼ §7Você Adquiriu §cKit Turtle");
            Bukkit.dispatchCommand((CommandSender) Bukkit.getConsoleSender(),
                    "pex user " + p.getName() + " add kit.turtle");
        } else if (o == 8) {
            p.sendMessage(String.valueOf(ArkuzKitPvP.prefix) + " §4➼ §7Você Adquiriu §cStomper");
            Bukkit.dispatchCommand((CommandSender) Bukkit.getConsoleSender(),
                    "pex user " + p.getName() + " add kit.stomper");
        } else if (o == 9) {
            p.sendMessage(String.valueOf(ArkuzKitPvP.prefix) + " §4➼ §7Você Adquiriu §cKit Ajnin");
            Bukkit.dispatchCommand((CommandSender) Bukkit.getConsoleSender(),
                    "pex user " + p.getName() + " add kit.ajnin");
        } else if (o == 10) {
            p.sendMessage(String.valueOf(ArkuzKitPvP.prefix) + " §4➼ §7Você Adquiriu §cKit Phantom");
            Bukkit.dispatchCommand((CommandSender) Bukkit.getConsoleSender(),
                    "pex user " + p.getName() + " add kit.phantom");
        } else if (o == 11) {
            p.sendMessage(String.valueOf(ArkuzKitPvP.prefix) + " §4➼ §7Você Adquiriu §cKit DeshFire");
            Bukkit.dispatchCommand((CommandSender) Bukkit.getConsoleSender(),
                    "pex user " + p.getName() + " add kit.deshfire");
        } else if (o == 12) {
            p.sendMessage(String.valueOf(ArkuzKitPvP.prefix) + " §4➼ §7Você Adquiriu §cKit Stomper");
            Bukkit.dispatchCommand((CommandSender) Bukkit.getConsoleSender(),
                    "pex user " + p.getName() + " add kit.stomper");
        } else if (o == 13) {
            p.sendMessage(String.valueOf(ArkuzKitPvP.prefix) + " §4➼ §7Você Adquiriu §cKit ForceField");
            Bukkit.dispatchCommand((CommandSender) Bukkit.getConsoleSender(),
                    "pex user " + p.getName() + " add kit.resouper");
        } else if (o == 14) {
            p.sendMessage(String.valueOf(ArkuzKitPvP.prefix) + " §4➼ §7Você Adquiriu §cKit Kangaroo");
            Bukkit.dispatchCommand((CommandSender) Bukkit.getConsoleSender(),
                    "pex user " + p.getName() + " add kit.kangaroo");
            if (o == 7 || o == 8 || o == 9 || o == 10 || o == 11 || o == 12 || o != 13) {
            }
        }
    }

    public void randomouro(final Player p) {
        final Random r = new Random();
        final int o = r.nextInt(14);
        if (o == 0) {
            p.sendMessage(String.valueOf(ArkuzKitPvP.prefix) + " §4➼ §7Você Adquiriu §c500 Coins");
            XpM.addMoney(p, 500);
        } else if (o == 1) {
            p.sendMessage(String.valueOf(ArkuzKitPvP.prefix) + " §4➼ §7Você Adquiriu §c1000 Coins");
            XpM.addMoney(p, 1000);
        } else if (o == 2) {
            p.sendMessage(String.valueOf(ArkuzKitPvP.prefix) + " §4➼ §7Você Adquiriu §c1500 Coins");
            XpM.addMoney(p, 1500);
        } else if (o == 3) {
            p.sendMessage(String.valueOf(ArkuzKitPvP.prefix) + " §4➼ §7Você Adquiriu §c800 Coins");
            XpM.addMoney(p, 800);
        } else if (o == 4) {
            p.sendMessage(String.valueOf(ArkuzKitPvP.prefix) + " §4➼ §7Você Adquiriu §c400 Coins");
            XpM.addMoney(p, 400);
        } else if (o == 5) {
            p.sendMessage(String.valueOf(ArkuzKitPvP.prefix) + " §4➼ §7Você Adquiriu §c300 Coins");
            XpM.addMoney(p, 300);
        } else if (o == 6) {
            p.sendMessage(String.valueOf(ArkuzKitPvP.prefix) + " §4➼ §7Você Adquiriu §c200 Coins");
            XpM.addMoney(p, 200);
        } else if (o == 7) {
            p.sendMessage(String.valueOf(ArkuzKitPvP.prefix) + " §4➼ §7Você Adquiriu §c100 Coins");
            XpM.addMoney(p, 100);
        } else if (o == 8) {
            p.sendMessage(String.valueOf(ArkuzKitPvP.prefix) + " §4➼ §7Você Adquiriu §c1100 Coins");
            XpM.addMoney(p, 1100);
        } else if (o == 9) {
            p.sendMessage(String.valueOf(ArkuzKitPvP.prefix) + " §4➼ §7Você Adquiriu §c1200 Coins");
            XpM.addMoney(p, 1200);
        } else if (o == 10) {
            p.sendMessage(String.valueOf(ArkuzKitPvP.prefix) + " §4➼ §7Você Adquiriu §1300 Coins");
            XpM.addMoney(p, 1300);
        } else if (o == 11) {
            p.sendMessage(String.valueOf(ArkuzKitPvP.prefix) + " §4➼ §7Você Adquiriu §c1400 Coins");
            XpM.addMoney(p, 1400);
        } else if (o == 12) {
            p.sendMessage(String.valueOf(ArkuzKitPvP.prefix) + " §4➼ §7Você Adquiriu §c1500 Coins");
            XpM.addMoney(p, 1500);
        } else if (o == 13) {
            p.sendMessage(String.valueOf(ArkuzKitPvP.prefix) + " §4➼ §7Você Adquiriu §c2000 Coins");
            XpM.addMoney(p, 2000);
        } else if (o == 14) {
            p.sendMessage(String.valueOf(ArkuzKitPvP.prefix) + " §4➼ §7Você Adquiriu §c4000 Coins");
            XpM.addMoney(p, 4000);
            if (o == 7 || o == 8 || o == 9 || o == 10 || o == 11 || o == 12 || o != 13) {
            }
        }
    }
}
