package Invs;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.Material;
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
import Main.Main;
import Score.ScoreBoarding;

public class InvOutros implements Listener, CommandExecutor {
	public static void guiKits(final Player p) {
		final Inventory inv = Bukkit.getServer().createInventory((InventoryHolder) p, 27, "§8{ §cOutros §8}");
		final ItemStack event4 = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short) 15);
		final ItemMeta event4v = event4.getItemMeta();
		event4v.setDisplayName("§7-");
		event4.setItemMeta(event4v);
		inv.setItem(2, event4);
		inv.setItem(3, event4);
		inv.setItem(5, event4);
		inv.setItem(6, event4);
		inv.setItem(10, event4);
		inv.setItem(11, event4);
		inv.setItem(15, event4);
		inv.setItem(16, event4);
		inv.setItem(20, event4);
		inv.setItem(21, event4);
		inv.setItem(22, event4);
		inv.setItem(23, event4);
		inv.setItem(24, event4);
		final ItemStack event5 = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short) 14);
		final ItemMeta event45v = event5.getItemMeta();
		event45v.setDisplayName("§7+");
		event5.setItemMeta(event4v);
		inv.setItem(26, event5);
		inv.setItem(18, event5);
		inv.setItem(0, event5);
		final ItemStack event6 = new ItemStack(Material.INK_SACK, 1, (short) 10);
		final ItemMeta event456v = event6.getItemMeta();
		event456v.setDisplayName("§7{ §aProximo §7}");
		event6.setItemMeta(event456v);
		inv.setItem(8, event6);
		final ItemStack loja23 = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short) 0);
		final ItemMeta loja23v = loja23.getItemMeta();
		loja23v.setDisplayName("§7=");
		loja23.setItemMeta(loja23v);
		inv.setItem(1, loja23);
		inv.setItem(7, loja23);
		inv.setItem(17, loja23);
		inv.setItem(9, loja23);
		inv.setItem(19, loja23);
		inv.setItem(25, loja23);
		final ItemStack event7 = new ItemStack(Material.BOWL);
		final ItemMeta eventv12 = event7.getItemMeta();
		eventv12.setDisplayName("§cRanks");
		event7.setItemMeta(eventv12);
		inv.setItem(12, event7);
		final ItemStack event8 = new ItemStack(Material.EXP_BOTTLE);
		final ItemMeta eventv13 = event8.getItemMeta();
		eventv13.setDisplayName("§cCosm\u00e9ticos");
		event8.setItemMeta(eventv13);
		inv.setItem(13, event8);
		final ItemStack event9 = new ItemStack(Material.NAME_TAG);
		final ItemMeta eventv14 = event9.getItemMeta();
		eventv14.setDisplayName("§cTreinos");
		event9.setItemMeta(eventv14);
		inv.setItem(14, event9);
		final ItemStack pyro = new ItemStack(Material.INK_SACK);
		final ItemMeta metapyro = pyro.getItemMeta();
		metapyro.setDisplayName("§c§lPerfil");
		final ArrayList<String> descpyro1 = new ArrayList<String>();
		descpyro1.add("§a\u27bc XP: §7" + XpM.getPlayerMoney(p));
		descpyro1.add("§9\u27bc Kills: §7"
				+ Main.plugin.getConfig().getInt("status." + p.getName().toLowerCase() + ".kills"));
		descpyro1.add("§4\u27bc Mortes: §7"
				+ Main.plugin.getConfig().getInt("status." + p.getName().toLowerCase() + ".mortes"));
		descpyro1.add("§8\u27bc Rank: §7" + ScoreBoarding.Rank(p));
		metapyro.setLore((List<String>) descpyro1);
		pyro.setItemMeta(metapyro);
		inv.addItem(new ItemStack[] { pyro });
		ItemStack[] arrayOfItemStack;
		for (int descpyro2 = (arrayOfItemStack = inv.getContents()).length,
				metapyro2 = 0; metapyro2 < descpyro2; ++metapyro2) {
			final ItemStack item = arrayOfItemStack[metapyro2];
			if (item == null) {
				inv.setItem(inv.firstEmpty(), event4);
			}
		}
		p.openInventory(inv);
	}

	public boolean onCommand(final CommandSender sender, final Command cmd, final String commandLabel,
			final String[] args) {
		if (commandLabel.equalsIgnoreCase("warps")) {
			final Player p = (Player) sender;
			guiKits(p);
		}
		return false;
	}

	@EventHandler
	public void onPlayerCLickInventry(final InventoryClickEvent e) {
		final Player p = (Player) e.getWhoClicked();
		if (e.getInventory().getTitle().equalsIgnoreCase("§8{ §cOutros §8}") && e.getCurrentItem() != null
				&& e.getCurrentItem().getTypeId() != 0) {
			e.setCancelled(true);
			if (e.getSlot() == 12) {
				e.setCancelled(true);
				p.closeInventory();
				InvRanks.guiKits(p);
				return;
			}
			if (e.getSlot() == 14) {
				e.setCancelled(true);
				p.closeInventory();
				InvTreino.guiKits(p);
				return;
			}
			if (e.getSlot() == 13) {
				e.setCancelled(true);
				p.closeInventory();
				InvCosmeticos.guiKits(p);
			}
		}
	}

	public static void ir(final Player p, final String string) {
	}
}
