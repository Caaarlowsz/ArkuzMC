package Invs;

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

public class InvRanks implements Listener, CommandExecutor {
	public static void guiKits(final Player p) {
		final Inventory inv = Bukkit.getServer().createInventory((InventoryHolder) p, 45, "§8{ §cRanks §8}");
		final ItemStack event12 = new ItemStack(Material.DIAMOND_SWORD);
		final ItemMeta eventv12 = event12.getItemMeta();
		eventv12.setDisplayName("§c" + p.getName());
		event12.setItemMeta(eventv12);
		inv.setItem(13, event12);
		final ItemStack event13 = new ItemStack(Material.getMaterial(353));
		final ItemMeta eventv13 = event13.getItemMeta();
		eventv13.setDisplayName("§f✖ §7/ §c0 - 50 Kills");
		event13.setItemMeta(eventv13);
		inv.setItem(28, event13);
		final ItemStack event14 = new ItemStack(Material.getMaterial(351), 1, (short) 8);
		final ItemMeta eventv14 = event14.getItemMeta();
		eventv14.setDisplayName("§a✾ §7/ §c50 - 100 Kills");
		event14.setItemMeta(eventv14);
		inv.setItem(29, event14);
		final ItemStack event15 = new ItemStack(Material.getMaterial(351), 1, (short) 10);
		final ItemMeta eventv15 = event15.getItemMeta();
		eventv15.setDisplayName("§e✿ §7/ §c100 - 150 Kills");
		event15.setItemMeta(eventv15);
		inv.setItem(30, event15);
		final ItemStack event16 = new ItemStack(Material.getMaterial(351), 1, (short) 9);
		final ItemMeta eventv16 = event16.getItemMeta();
		eventv16.setDisplayName("§c✦ §7/ §c150 - 200 Kills");
		event16.setItemMeta(eventv16);
		inv.setItem(31, event16);
		final ItemStack event17 = new ItemStack(Material.getMaterial(351), 1, (short) 13);
		final ItemMeta eventv17 = event15.getItemMeta();
		eventv17.setDisplayName("§9☱ §7/ §c200 - 250 Kills");
		event17.setItemMeta(eventv17);
		inv.setItem(32, event17);
		final ItemStack event18 = new ItemStack(Material.getMaterial(351), 1, (short) 12);
		final ItemMeta eventv18 = event18.getItemMeta();
		eventv18.setDisplayName("§bπ §7/ §c250 - 300 Kills");
		event18.setItemMeta(eventv18);
		inv.setItem(33, event18);
		final ItemStack event19 = new ItemStack(Material.getMaterial(337), 1, (short) 0);
		final ItemMeta eventv19 = event19.getItemMeta();
		eventv19.setDisplayName("§4❂ §7/ §c300 - 350 Kills");
		event19.setItemMeta(eventv19);
		inv.setItem(34, event19);
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
		if (e.getInventory().getTitle().equalsIgnoreCase("§8{ §cRanks §8}") && e.getCurrentItem() != null
				&& e.getCurrentItem().getTypeId() != 0) {
			e.setCancelled(true);
			if (e.getSlot() == 12) {
				e.setCancelled(true);
				p.closeInventory();
				p.sendMessage("§cEm Breve");
				return;
			}
			if (e.getSlot() == 14) {
				e.setCancelled(true);
				p.closeInventory();
				p.sendMessage("§cEm Breve");
			}
		}
	}

	public static void ir(final Player p, final String string) {
	}
}
