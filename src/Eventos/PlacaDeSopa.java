package Eventos;

import com.github.caaarlowsz.arkuzmc.kitpvp.ArkuzKitPvP;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.block.Sign;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.block.SignChangeEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryHolder;
import org.bukkit.inventory.ItemStack;

public class PlacaDeSopa implements Listener {

	public PlacaDeSopa() {
	}

	@EventHandler
	public void onSignChange(final SignChangeEvent e) {
		if (e.getLine(0).equalsIgnoreCase("sopa")) {
			e.setLine(0, "--={+}=--");
			e.setLine(1, ArkuzKitPvP.prefix);
			e.setLine(2, "§f Sopas");
			e.setLine(3, "--={+}=--");
		}
	}

	@EventHandler
	public void inv(final PlayerInteractEvent e) {
		final Player p = e.getPlayer();
		final ItemStack sopas = new ItemStack(Material.MUSHROOM_SOUP);
		final Inventory inve = Bukkit.getServer().createInventory((InventoryHolder) p, 36, "§8{ §cSopas §8}");
		
		for (int i = 0; i < 35; i++)
			inve.setItem(i, sopas);
		
		if (e.getAction() == Action.RIGHT_CLICK_BLOCK && e.getClickedBlock() != null
				&& (e.getClickedBlock().getType() == Material.WALL_SIGN
						|| e.getClickedBlock().getType() == Material.SIGN_POST)) {
			final Sign s = (Sign) e.getClickedBlock().getState();
			final String[] lines = s.getLines();
			if (lines.length > 0 && lines[0].equals("--={+}=--") && lines.length > 1 && lines[1].equals(ArkuzKitPvP.prefix)
					&& lines.length > 2 && lines[2].equals("§f Sopas") && lines.length > 3
					&& lines[3].equals("--={+}=--")) {
				p.openInventory(inve);
			}
		}
	}

	@EventHandler
	public void onPlayerColor(final SignChangeEvent e) {
		if (e.getLine(0).contains("&")) {
			e.setLine(0, e.getLine(0).replace("&", "?"));
		}
		if (e.getLine(1).contains("&")) {
			e.setLine(1, e.getLine(1).replace("&", "?"));
		}
		if (e.getLine(2).contains("&")) {
			e.setLine(2, e.getLine(2).replace("&", "?"));
		}
		if (e.getLine(3).contains("&")) {
			e.setLine(3, e.getLine(3).replace("&", "?"));
		}
	}
}
