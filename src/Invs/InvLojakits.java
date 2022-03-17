package Invs;

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

import Coins.XpM;
import Score.ScoreBoarding;

public class InvLojakits implements Listener, CommandExecutor {
	public static ItemStack vidro;
	public static ItemMeta vidrometa;
	public static ItemStack vidro2;
	public static ItemMeta vidro2meta;
	public static ItemStack ninja;
	public static ItemMeta ninjameta;
	public static ItemStack viking;
	public static ItemMeta vikingmeta;
	public static ItemStack stomper;
	public static ItemMeta stompermeta;
	public static ItemStack viper;
	public static ItemMeta vipermeta;
	public static ItemStack snail;
	public static ItemMeta snailmeta;
	public static ItemStack fisherman;
	public static ItemMeta fishermanmeta;
	public static ItemStack thor;
	public static ItemMeta thormeta;
	public static ItemStack xp;
	public static ItemMeta xpmeta;
	public static ItemStack coisa;
	public static ItemMeta coisameta;

	@EventHandler
	public void warps(final InventoryClickEvent e) {
		if (e.getCurrentItem() != null && e.getCurrentItem().getItemMeta() != null) {
			final Inventory inv = e.getInventory();
			final Player p = (Player) e.getWhoClicked();
			if (inv.getTitle().equals("§8{ §cXP §8}")) {
				p.playSound(p.getLocation(), Sound.LEVEL_UP, 5.0f, 5.0f);
				e.setCancelled(true);
				p.closeInventory();
			}
			if (e.getCurrentItem().isSimilar(InvLojakits.ninja)) {
				if (XpM.getPlayerMoney(p) >= 4000) {
					XpM.removeMoney(p, 4000);
					Bukkit.dispatchCommand((CommandSender) Bukkit.getConsoleSender(),
							"pex user " + p.getName() + " add kit.avatar");
					p.sendMessage(String.valueOf(ArkuzKitPvP.prefix) + " §4➼ §7Kit §c§nAVATAR§7 Adquirido Com Sucesso");
					ScoreBoarding.setScoreBoard(p);
					e.setCancelled(true);
					p.closeInventory();
				} else if (XpM.getPlayerMoney(p) < 4000) {
					p.sendMessage(String.valueOf(ArkuzKitPvP.prefix)
							+ " §4➼ §7Você Não Tem XP o Suficiente Para Esta Compra");
					e.setCancelled(true);
					p.closeInventory();
				}
			}
			if (e.getCurrentItem().isSimilar(InvLojakits.viking)) {
				if (XpM.getPlayerMoney(p) >= 15000) {
					XpM.removeMoney(p, 15000);
					Bukkit.dispatchCommand((CommandSender) Bukkit.getConsoleSender(),
							"pex user " + p.getName() + " add kit.Stomper");
					p.sendMessage(String.valueOf(ArkuzKitPvP.prefix) + " §4➼ §7Kit §c§nSTOMPER§7 Adquirido Com Sucesso");
					ScoreBoarding.setScoreBoard(p);
					e.setCancelled(true);
					p.closeInventory();
				} else if (XpM.getPlayerMoney(p) < 15000) {
					p.sendMessage(String.valueOf(ArkuzKitPvP.prefix)
							+ " §4➼ §7Você Não Tem XP o Suficiente Para Esta Compra");
					e.setCancelled(true);
					p.closeInventory();
				}
			}
			if (e.getCurrentItem().isSimilar(InvLojakits.stomper)) {
				if (XpM.getPlayerMoney(p) >= 1000) {
					XpM.removeMoney(p, 1000);
					Bukkit.dispatchCommand((CommandSender) Bukkit.getConsoleSender(),
							"pex user " + p.getName() + " add kit.thor");
					p.sendMessage(String.valueOf(ArkuzKitPvP.prefix) + " §4➼ §7Kit §c§nTHOR§7 Adquirido Com Sucesso");
					e.setCancelled(true);
					p.closeInventory();
					ScoreBoarding.setScoreBoard(p);
				} else if (XpM.getPlayerMoney(p) < 1000) {
					p.sendMessage(String.valueOf(ArkuzKitPvP.prefix)
							+ " §4➼ §7Você Não Tem XP o Suficiente Para Esta Compra");
					e.setCancelled(true);
					p.closeInventory();
				}
			}
			if (e.getCurrentItem().isSimilar(InvLojakits.viper)) {
				if (XpM.getPlayerMoney(p) >= 5000) {
					XpM.removeMoney(p, 5000);
					Bukkit.dispatchCommand((CommandSender) Bukkit.getConsoleSender(),
							"pex user " + p.getName() + " add kit.swords");
					p.sendMessage(String.valueOf(ArkuzKitPvP.prefix) + " §4➼ §7Kit §c§nSWORDS§7 Adquirido Com Sucesso");
					e.setCancelled(true);
					p.closeInventory();
					ScoreBoarding.setScoreBoard(p);
				} else if (XpM.getPlayerMoney(p) < 5000) {
					p.sendMessage(String.valueOf(ArkuzKitPvP.prefix)
							+ " §4➼ §7Você Não Tem XP o Suficiente Para Esta Compra");
					e.setCancelled(true);
					p.closeInventory();
				}
			}
			if (e.getCurrentItem().isSimilar(InvLojakits.snail)) {
				if (XpM.getPlayerMoney(p) >= 4000) {
					XpM.removeMoney(p, 4000);
					Bukkit.dispatchCommand((CommandSender) Bukkit.getConsoleSender(),
							"pex user " + p.getName() + " add kit.forcefield");
					p.sendMessage(String.valueOf(ArkuzKitPvP.prefix) + " §4➼ §7Kit §c§nFORCEFIELD§7 Adquirido");
					e.setCancelled(true);
					p.closeInventory();
					ScoreBoarding.setScoreBoard(p);
				} else if (XpM.getPlayerMoney(p) < 4000) {
					p.sendMessage(String.valueOf(ArkuzKitPvP.prefix)
							+ " §4➼ §7Você Não Tem XP o Suficiente Para Esta Compra");
					e.setCancelled(true);
					p.closeInventory();
				}
				if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§7{ §cAnterior §7}")) {
					e.setCancelled(true);
					p.closeInventory();
					InvXP.guiKits(p);
				}
			}
		}
	}

	public boolean onCommand(final CommandSender sender, final Command cmd, final String label, final String[] args) {
		if (!(sender instanceof Player)) {
			return true;
		}
		final Player p = (Player) sender;
		if (cmd.getName().equalsIgnoreCase("lojakits")) {
			final Inventory warps = Bukkit.createInventory((InventoryHolder) p, 27, "§8{ §cXP §8}");
			final ItemStack event4 = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short) 15);
			final ItemMeta event4v = event4.getItemMeta();
			event4v.setDisplayName("§7-");
			event4.setItemMeta(event4v);
			warps.setItem(2, event4);
			warps.setItem(3, event4);
			warps.setItem(4, event4);
			warps.setItem(5, event4);
			warps.setItem(6, event4);
			warps.setItem(10, event4);
			warps.setItem(16, event4);
			warps.setItem(20, event4);
			warps.setItem(21, event4);
			warps.setItem(22, event4);
			warps.setItem(23, event4);
			warps.setItem(24, event4);
			final ItemStack event5 = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short) 14);
			final ItemMeta event45v = event5.getItemMeta();
			event45v.setDisplayName("§7+");
			event5.setItemMeta(event4v);
			warps.setItem(26, event5);
			warps.setItem(18, event5);
			final ItemStack event6 = new ItemStack(Material.INK_SACK, 1, (short) 8);
			final ItemMeta event451v = event6.getItemMeta();
			event451v.setDisplayName("§7{ §cAnterior §7}");
			event6.setItemMeta(event451v);
			warps.setItem(0, event6);
			final ItemStack event7 = new ItemStack(Material.INK_SACK, 1, (short) 10);
			final ItemMeta event456v = event7.getItemMeta();
			event456v.setDisplayName("§7{ §aProximo §7}");
			event7.setItemMeta(event456v);
			warps.setItem(8, event7);
			final ItemStack loja23 = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short) 0);
			final ItemMeta loja23v = loja23.getItemMeta();
			loja23v.setDisplayName("§7=");
			loja23.setItemMeta(loja23v);
			warps.setItem(1, loja23);
			warps.setItem(7, loja23);
			warps.setItem(17, loja23);
			warps.setItem(9, loja23);
			warps.setItem(19, loja23);
			warps.setItem(25, loja23);
			InvLojakits.stomper = new ItemStack(Material.GOLD_AXE);
			(InvLojakits.stompermeta = InvLojakits.stomper.getItemMeta()).setDisplayName("§c§nKIT THOR - 1000 XP");
			InvLojakits.stomper.setItemMeta(InvLojakits.stompermeta);
			InvLojakits.viking = new ItemStack(Material.LEATHER_BOOTS, 1);
			(InvLojakits.vikingmeta = InvLojakits.viking.getItemMeta()).setDisplayName("§c§nKIT STOMPER - 15000 XP");
			InvLojakits.viking.setItemMeta(InvLojakits.vikingmeta);
			InvLojakits.viper = new ItemStack(Material.WOOD_SWORD);
			(InvLojakits.vipermeta = InvLojakits.viper.getItemMeta()).setDisplayName("§c§nKIT SWORDS - 5000 XP");
			InvLojakits.viper.setItemMeta(InvLojakits.vipermeta);
			InvLojakits.ninja = new ItemStack(Material.BEACON);
			(InvLojakits.ninjameta = InvLojakits.ninja.getItemMeta()).setDisplayName("§c§nKIT AVATAR - 4000 XP");
			InvLojakits.ninja.setItemMeta(InvLojakits.ninjameta);
			InvLojakits.snail = new ItemStack(Material.NETHER_FENCE);
			(InvLojakits.snailmeta = InvLojakits.snail.getItemMeta()).setDisplayName("§c§nKIT FF - 4000 XP");
			InvLojakits.snail.setItemMeta(InvLojakits.snailmeta);
			for (int i = 0; i != 27; ++i) {
				warps.setItem(11, InvLojakits.stomper);
				warps.setItem(12, InvLojakits.viper);
				warps.setItem(13, InvLojakits.snail);
				warps.setItem(14, InvLojakits.ninja);
				warps.setItem(15, InvLojakits.viking);
			}
			p.openInventory(warps);
			return true;
		}
		return true;
	}
}
