package Invs;

import com.github.caaarlowsz.arkuzmc.kitpvp.ArkuzPvP;
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

public class InvLoja implements Listener, CommandExecutor {
	public static void guiKits(final Player p) {
		final Inventory inv = Bukkit.getServer().createInventory((InventoryHolder) p, 27, "§8{ §cLoja §8}");
		p.playSound(p.getLocation(), Sound.LEVEL_UP, 5.0f, 5.0f);
		final ItemStack event4 = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short) 15);
		final ItemMeta event4v = event4.getItemMeta();
		event4v.setDisplayName("§7-");
		event4.setItemMeta(event4v);
		inv.setItem(2, event4);
		inv.setItem(3, event4);
		inv.setItem(4, event4);
		inv.setItem(5, event4);
		inv.setItem(6, event4);
		inv.setItem(10, event4);
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
		final ItemStack event6 = new ItemStack(Material.INK_SACK, 1, (short) 8);
		final ItemMeta event451v = event6.getItemMeta();
		event451v.setDisplayName("§7{ §cAnterior §7}");
		event6.setItemMeta(event451v);
		inv.setItem(0, event6);
		final ItemStack event7 = new ItemStack(Material.INK_SACK, 1, (short) 10);
		final ItemMeta event456v = event7.getItemMeta();
		event456v.setDisplayName("§7{ §aProximo §7}");
		event7.setItemMeta(event456v);
		inv.setItem(8, event7);
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
		final ItemStack loja24 = new ItemStack(Material.EMERALD, 1, (short) 0);
		final ItemMeta loja235v = loja24.getItemMeta();
		loja235v.setDisplayName("§a§nXP");
		loja24.setItemMeta(loja235v);
		inv.setItem(12, loja24);
		final ItemStack loja25 = new ItemStack(Material.PAPER, 1, (short) 0);
		final ItemMeta loja2345v = loja25.getItemMeta();
		loja2345v.setDisplayName("§e§nSite");
		loja25.setItemMeta(loja2345v);
		inv.setItem(14, loja25);
		ItemStack[] arrayOfItemStack;
		for (int descpyro1 = (arrayOfItemStack = inv.getContents()).length,
				metapyro1 = 0; metapyro1 < descpyro1; ++metapyro1) {
			final ItemStack item = arrayOfItemStack[metapyro1];
			if (item == null) {
				inv.setItem(inv.firstEmpty(), event4);
			}
		}
		p.openInventory(inv);
	}

	public boolean onCommand(final CommandSender sender, final Command cmd, final String commandLabel,
			final String[] args) {
		if (commandLabel.equalsIgnoreCase("loja")) {
			final Player p = (Player) sender;
			guiKits(p);
		}
		return false;
	}

	@EventHandler
	public void onPlayerCLickInventry(final InventoryClickEvent e) {
		final Player p = (Player) e.getWhoClicked();
		if (e.getInventory().getTitle().equalsIgnoreCase("§8{ §cLoja §8}") && e.getCurrentItem() != null
				&& e.getCurrentItem().getTypeId() != 0) {
			if (e.getSlot() == 14) {
				e.setCancelled(true);
				p.closeInventory();
				p.sendMessage(String.valueOf(ArkuzPvP.prefix) + " §4\u27bc §7Entre Em Nossa Loja: §c" + ArkuzPvP.loja);
				return;
			}
			if (e.getSlot() == 12) {
				e.setCancelled(true);
				p.closeInventory();
				InvXP.guiKits(p);
				return;
			}
			for (int i = 0; i != 27; ++i) {
				if (e.getSlot() == i) {
					e.setCancelled(true);
					p.closeInventory();
					return;
				}
			}
		}
	}

	public static void ir(final Player p, final String string) {
	}
}
