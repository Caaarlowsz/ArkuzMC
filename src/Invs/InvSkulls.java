package Invs;

import com.github.caaarlowsz.arkuzmc.kitpvp.ArkuzPvP;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryHolder;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;

public class InvSkulls implements Listener {
	private static ArrayList<String> comchapeu;

	static {
		InvSkulls.comchapeu = new ArrayList<String>();
	}

	public static void Inv(final Player p) {
		final Inventory inv = Bukkit.createInventory((InventoryHolder) p, 27, "§8{ §cCabeças §8}");
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
		inv.setItem(24, event4);
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
		final ItemStack event5 = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short) 14);
		final ItemMeta event45v = event5.getItemMeta();
		event45v.setDisplayName("§7+");
		event5.setItemMeta(event4v);
		inv.setItem(26, event5);
		inv.setItem(18, event5);
		inv.setItem(8, event5);
		inv.setItem(0, event5);
		final ItemStack ct = new ItemStack(Material.WORKBENCH);
		final ItemMeta ct2 = ct.getItemMeta();
		ct2.setDisplayName("§c§nCrafing Table");
		ct.setItemMeta(ct2);
		final ItemStack ft = new ItemStack(Material.FURNACE);
		final ItemMeta ft2 = ft.getItemMeta();
		ft2.setDisplayName("§c§nFornalha");
		ft.setItemMeta(ft2);
		final ItemStack vt = new ItemStack(Material.GLASS);
		final ItemMeta vt2 = vt.getItemMeta();
		vt2.setDisplayName("§c§nVidro");
		vt.setItemMeta(vt2);
		final ItemStack tt = new ItemStack(Material.TNT);
		final ItemMeta tt2 = tt.getItemMeta();
		tt2.setDisplayName("§c§nTnT");
		tt.setItemMeta(tt2);
		final ItemStack dt = new ItemStack(Material.DIAMOND_BLOCK);
		final ItemMeta dt2 = dt.getItemMeta();
		dt2.setDisplayName("§c§nDiamante");
		dt.setItemMeta(dt2);
		final ItemStack st = new ItemStack(Material.MOB_SPAWNER);
		final ItemMeta st2 = st.getItemMeta();
		st2.setDisplayName("§c§nMobSpawner");
		st.setItemMeta(st2);
		final ItemStack bt = new ItemStack(Material.BOOKSHELF);
		final ItemMeta bt2 = bt.getItemMeta();
		bt2.setDisplayName("§c§nEstante");
		bt.setItemMeta(bt2);
		final ItemStack rt = new ItemStack(Material.REDSTONE);
		final ItemMeta rt2 = rt.getItemMeta();
		rt2.setDisplayName("§c§nRetirar Skull");
		rt.setItemMeta(rt2);
		inv.setItem(11, ct);
		inv.setItem(12, ft);
		inv.setItem(13, vt);
		inv.setItem(14, bt);
		inv.setItem(15, tt);
		inv.setItem(21, st);
		inv.setItem(22, dt);
		inv.setItem(23, rt);
		p.openInventory(inv);
	}

	@EventHandler
	void clicou(final InventoryClickEvent e) {
		final Player p = (Player) e.getWhoClicked();
		if (p.getOpenInventory().getTitle().equalsIgnoreCase("§8{ §cSkulls §8}")) {
			if (e.getCurrentItem().getType() == Material.WORKBENCH) {
				p.getInventory().setHelmet(new ItemStack(Material.WORKBENCH));
				p.sendMessage(String.valueOf(ArkuzPvP.prefix)
						+ " §4➼ §7Você Alterou Sua Skulls Para: §c§nCrafting Table");
				InvSkulls.comchapeu.remove(p.getName());
				InvSkulls.comchapeu.add(p.getName());
				p.closeInventory();
			}
			if (e.getCurrentItem().getType() == Material.FURNACE) {
				p.getInventory().setHelmet(new ItemStack(Material.FURNACE));
				p.sendMessage(
						String.valueOf(ArkuzPvP.prefix) + " §4➼ §7Você Alterou Sua Skulls Para: §c§nFornalha");
				InvSkulls.comchapeu.remove(p.getName());
				InvSkulls.comchapeu.add(p.getName());
				p.closeInventory();
			}
			if (e.getCurrentItem().getType() == Material.REDSTONE) {
				if (!InvSkulls.comchapeu.contains(p.getName())) {
					p.sendMessage(
							String.valueOf(ArkuzPvP.prefix) + " §4➼ §7Você Não Está Com Uma Skull");
				} else {
					p.getInventory().setHelmet(new ItemStack(Material.AIR));
					p.sendMessage(
							String.valueOf(ArkuzPvP.prefix) + " §4➼ §7Você Alterou Sua Skulls Para: §c§nNenhuma");
					InvSkulls.comchapeu.remove(p.getName());
				}
				p.closeInventory();
			}
			if (e.getCurrentItem().getType() == Material.GLASS) {
				p.getInventory().setHelmet(new ItemStack(Material.GLASS));
				p.sendMessage(String.valueOf(ArkuzPvP.prefix) + " §4➼ §7Você Alterou Sua Skulls Para: §c§nVidro");
				InvSkulls.comchapeu.remove(p.getName());
				InvSkulls.comchapeu.add(p.getName());
				p.closeInventory();
			}
			if (e.getCurrentItem().getType() == Material.TNT) {
				p.getInventory().setHelmet(new ItemStack(Material.TNT));
				p.sendMessage(String.valueOf(ArkuzPvP.prefix) + " §4➼ §7Você Alterou Sua Skulls Para: §c§nTNT");
				InvSkulls.comchapeu.remove(p.getName());
				InvSkulls.comchapeu.remove(p.getName());
				InvSkulls.comchapeu.add(p.getName());
				p.closeInventory();
			}
			if (e.getCurrentItem().getType() == Material.DIAMOND_BLOCK) {
				p.getInventory().setHelmet(new ItemStack(Material.DIAMOND_BLOCK));
				p.sendMessage(
						String.valueOf(ArkuzPvP.prefix) + " §4➼ §7Você Alterou Sua Skulls Para: §c§nDiamante");
				InvSkulls.comchapeu.remove(p.getName());
				InvSkulls.comchapeu.add(p.getName());
				p.closeInventory();
			}
			if (e.getCurrentItem().getType() == Material.THIN_GLASS) {
				p.closeInventory();
			}
			if (e.getCurrentItem().getType() == Material.BOOKSHELF) {
				p.getInventory().setHelmet(new ItemStack(Material.BOOKSHELF));
				p.sendMessage(
						String.valueOf(ArkuzPvP.prefix) + " §4➼ §7Você Alterou Sua Skulls Para: §c§nEstante");
				InvSkulls.comchapeu.remove(p.getName());
				InvSkulls.comchapeu.add(p.getName());
				p.closeInventory();
			}
			if (e.getCurrentItem().getType() == Material.MOB_SPAWNER) {
				p.getInventory().setHelmet(new ItemStack(Material.MOB_SPAWNER));
				p.sendMessage(
						String.valueOf(ArkuzPvP.prefix) + " §4➼ §7Você Alterou Sua Skulls Para: §c§nMob Spawner");
				InvSkulls.comchapeu.remove(p.getName());
				InvSkulls.comchapeu.add(p.getName());
				p.closeInventory();
			}
		}
	}

	@EventHandler
	void clicounoblock(final PlayerInteractEvent e) {
		final Player p = e.getPlayer();
		if (p.getItemInHand().getType() == Material.JUKEBOX && e.getAction() == Action.RIGHT_CLICK_AIR) {
			Inv(p);
		}
	}
}
