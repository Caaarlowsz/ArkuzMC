package Comandos;

import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.SkullMeta;

import Main.Main;

public class Head implements CommandExecutor, Listener {
	Main main;

	public Head(Main plugin) {
		plugin = this.main;
	}

	public Head() {
	}

	public boolean onCommand(final CommandSender sender, final Command command, final String label,
			final String[] args) {
		if (!(sender instanceof Player)) {
			sender.sendMessage("[Apenas Players Podem Utilizar Isto]");
			return true;
		}
		if (sender instanceof Player) {
			final Player p = (Player) sender;
			if (args.length == 0) {
				p.sendMessage(String.valueOf(Main.prefix) + " §4\u27bc §7Use: /Head {Player}");
			}
			if (args.length != 0 && args.length == 1) {
				if (p.hasPermission("arkuz.head")) {
					final ItemStack skullItem = new ItemStack(Material.SKULL_ITEM);
					skullItem.setDurability((short) 3);
					final SkullMeta skullMeta = (SkullMeta) skullItem.getItemMeta();
					skullMeta.setOwner(args[0]);
					skullItem.setItemMeta((ItemMeta) skullMeta);
					p.getInventory().addItem(new ItemStack[] { skullItem });
					p.sendMessage(String.valueOf(Main.prefix) + " §4\u27bc §7A Head Foi Adicionada Ao Seu inventario");
				} else {
					p.sendMessage(String.valueOf(Main.prefix) + " §4\u27bc §7Sem Permiss\u00e3o");
				}
			}
		}
		return false;
	}
}
