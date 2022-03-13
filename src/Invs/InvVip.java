package Invs;

import java.util.Arrays;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryHolder;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class InvVip implements Listener {
	public static ItemStack criarItemMenu(final Material material, final String nome, final String[] habilidade) {
		final ItemStack item = new ItemStack(material);
		final ItemMeta kitem = item.getItemMeta();
		kitem.setDisplayName(nome);
		kitem.setLore(Arrays.asList(habilidade));
		item.setItemMeta(kitem);
		return item;
	}

	public static void inventory(final Player p) {
		final Inventory menu = Bukkit.createInventory((InventoryHolder) p, 9, "§aMenu de §6§lVIPS");
		menu.setItem(0, new ItemStack(Material.STAINED_GLASS_PANE));
		menu.setItem(1, new ItemStack(Material.STAINED_GLASS_PANE));
		menu.setItem(3, new ItemStack(Material.STAINED_GLASS_PANE));
		menu.setItem(5, new ItemStack(Material.STAINED_GLASS_PANE));
		menu.setItem(7, new ItemStack(Material.STAINED_GLASS_PANE));
		menu.setItem(8, new ItemStack(Material.STAINED_GLASS_PANE));
		menu.setItem(3,
				criarItemMenu(Material.GOLD_BLOCK, "§aVip",
						new String[] { " ", "              §b§lVANTAGENS", "§7§ §fVaga reservada no servidor.",
								"§a§ §fTag §aVip §fpara ser diferenciado.", "§a§ §fAcesso ao §6/FAKE §fe §6/SKIN",
								"§a§ §fMelhor suporte", "§a§ §fFalar colorido", "§a§ §fAcesso ao §a/FLY",
								"§a§ §aAcesso \u00e0 TODAS classes do servidor.", " " }));
		p.openInventory(menu);
	}

	public static void inventarioLojas(final Player p) {
		final Inventory menu = Bukkit.createInventory((InventoryHolder) p, 9, "§aMenu de Lojas");
		menu.setItem(0, new ItemStack(Material.STAINED_GLASS_PANE));
		menu.setItem(1, new ItemStack(Material.STAINED_GLASS_PANE, 1, (short) 1));
		menu.setItem(3, new ItemStack(Material.STAINED_GLASS_PANE));
		menu.setItem(4, new ItemStack(Material.STAINED_GLASS_PANE, 1, (short) 1));
		menu.setItem(5, new ItemStack(Material.STAINED_GLASS_PANE));
		menu.setItem(7, new ItemStack(Material.STAINED_GLASS_PANE, 1, (short) 1));
		menu.setItem(8, new ItemStack(Material.STAINED_GLASS_PANE));
		menu.setItem(2, criarItemMenu(Material.EMERALD_BLOCK, "§fLoja de §6Vips", new String[0]));
		p.openInventory(menu);
	}

	@EventHandler
	public void clickarloja(final InventoryClickEvent e) {
		final Player p = (Player) e.getWhoClicked();
		if (e.getInventory().getTitle().equals("§aMenu de Lojas") && e.getCurrentItem() != null
				&& e.getCurrentItem().getTypeId() != 0) {
			e.setCancelled(true);
			if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§fLoja de §6Vips")) {
				e.setCancelled(true);
				inventory(p);
			}
		}
	}

	@EventHandler
	public void clickarlojavips(final InventoryClickEvent e) {
		final Player p = (Player) e.getWhoClicked();
		if (e.getInventory().getTitle().equals("§aMenu de §6§lVIPS") && e.getCurrentItem() != null
				&& e.getCurrentItem().getTypeId() != 0) {
			e.setCancelled(true);
			if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§aVip")) {
				e.setCancelled(true);
				p.closeInventory();
				p.sendMessage("§a§lVIP §e> ");
			}
		}
	}
}
