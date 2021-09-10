package Caixas;

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

public class InvPesada implements Listener, CommandExecutor {
	public static void guiKits(final Player p) {
		final Inventory inv = Bukkit.getServer().createInventory((InventoryHolder) p, 54, "§8{ §cKits (Pesada) §8}");
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
		inv.setItem(11, event4);
		inv.setItem(13, event4);
		inv.setItem(15, event4);
		inv.setItem(16, event4);
		inv.setItem(20, event4);
		inv.setItem(21, event4);
		inv.setItem(22, event4);
		inv.setItem(23, event4);
		inv.setItem(24, event4);
		final ItemStack loja23 = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short) 0);
		final ItemMeta loja23v = loja23.getItemMeta();
		loja23v.setDisplayName("§7=");
		loja23.setItemMeta(loja23v);
		inv.setItem(0, loja23);
		inv.setItem(1, loja23);
		inv.setItem(7, loja23);
		inv.setItem(8, loja23);
		inv.setItem(9, loja23);
		inv.setItem(17, loja23);
		inv.setItem(36, loja23);
		inv.setItem(44, loja23);
		inv.setItem(45, loja23);
		inv.setItem(46, loja23);
		inv.setItem(52, loja23);
		inv.setItem(53, loja23);
		final ItemStack event5 = new ItemStack(Material.NETHER_FENCE, 1, (short) 0);
		final ItemMeta event451v = event5.getItemMeta();
		event451v.setDisplayName("§7{ §cKit ForceField §7}");
		event5.setItemMeta(event451v);
		inv.setItem(12, event5);
		final ItemStack event6 = new ItemStack(Material.BEACON, 1, (short) 10);
		final ItemMeta event456v = event6.getItemMeta();
		event456v.setDisplayName("§7{ §cKit Avatar §7}");
		event6.setItemMeta(event456v);
		inv.setItem(13, event6);
		final ItemStack event7 = new ItemStack(Material.IRON_FENCE);
		final ItemMeta eventv = event7.getItemMeta();
		eventv.setDisplayName("§7{ §cKit Gladiator §7}");
		event7.setItemMeta(eventv);
		inv.setItem(14, event7);
		final ItemStack event8 = new ItemStack(Material.STONE_AXE);
		final ItemMeta eventv2 = event8.getItemMeta();
		eventv2.setDisplayName("§7{ §cKit Viking §7}");
		event8.setItemMeta(eventv2);
		inv.setItem(20, event8);
		final ItemStack event9 = new ItemStack(Material.GOLD_SWORD);
		final ItemMeta eventv3 = event9.getItemMeta();
		eventv3.setDisplayName("§7{ §cKit Swords §7}");
		event9.setItemMeta(eventv3);
		inv.setItem(21, event9);
		final ItemStack event10 = new ItemStack(Material.SLIME_BALL);
		final ItemMeta eventv4 = event10.getItemMeta();
		eventv4.setDisplayName("§7{ §cKit C4 §7}");
		event10.setItemMeta(eventv4);
		inv.setItem(22, event10);
		final ItemStack event11 = new ItemStack(Material.MAGMA_CREAM);
		final ItemMeta eventv5 = event11.getItemMeta();
		eventv5.setDisplayName("§7{ §cKit Terrorista §7}");
		event11.setItemMeta(eventv5);
		inv.setItem(23, event11);
		final ItemStack event12 = new ItemStack(Material.DIAMOND_CHESTPLATE);
		final ItemMeta eventv6 = event12.getItemMeta();
		eventv6.setDisplayName("§7{ §cKit Turtle §7}");
		event12.setItemMeta(eventv6);
		inv.setItem(24, event12);
		final ItemStack event13 = new ItemStack(Material.LEATHER_BOOTS);
		final ItemMeta eventv7 = event13.getItemMeta();
		eventv7.setDisplayName("§7{ §cKit Stomper §7}");
		event13.setItemMeta(eventv7);
		inv.setItem(29, event13);
		final ItemStack event14 = new ItemStack(Material.FEATHER);
		final ItemMeta eventv8 = event14.getItemMeta();
		eventv8.setDisplayName("§7{ §cKit Phantom §7}");
		event14.setItemMeta(eventv8);
		inv.setItem(30, event14);
		final ItemStack event15 = new ItemStack(Material.REDSTONE_BLOCK);
		final ItemMeta eventv9 = event15.getItemMeta();
		eventv9.setDisplayName("§7{ §cKit Deshfire §7}");
		event15.setItemMeta(eventv9);
		inv.setItem(31, event15);
		final ItemStack event16 = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short) 14);
		final ItemMeta event41v = event16.getItemMeta();
		event41v.setDisplayName("§7{ §cNada §7}");
		event16.setItemMeta(event41v);
		inv.setItem(32, event16);
		inv.setItem(33, event16);
		inv.setItem(39, event16);
		inv.setItem(40, event16);
		inv.setItem(41, event16);
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
		if (commandLabel.equalsIgnoreCase("warps")) {
			final Player p = (Player) sender;
			guiKits(p);
		}
		return false;
	}

	@EventHandler
	public void onPlayerCLickInventry(final InventoryClickEvent e) {
		if (e.getInventory().getTitle().equalsIgnoreCase("§8{ §cKits (Pesada) §8}") && e.getCurrentItem() != null
				&& e.getCurrentItem().getTypeId() != 0) {
			e.setCancelled(true);
			if (e.getSlot() == 12) {
				return;
			}
		}
	}

	public static void ir(final Player p, final String string) {
	}
}
