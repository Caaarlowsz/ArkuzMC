package Comandos;

import com.github.caaarlowsz.arkuzmc.kitpvp.ArkuzKitPvP;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.SkullMeta;

public class Head implements CommandExecutor, Listener {

	public boolean onCommand(final CommandSender sender, final Command command, final String label,
			final String[] args) {
		if (!(sender instanceof Player)) {
			sender.sendMessage("[Apenas Players Podem Utilizar Isto]");
			return true;
		}
		if (sender instanceof Player) {
			final Player p = (Player) sender;
			if (args.length == 0) {
				p.sendMessage(String.valueOf(ArkuzKitPvP.prefix) + " §4➼ §7Use: /Head {Player}");
			}
			if (args.length != 0 && args.length == 1) {
				if (p.hasPermission("arkuz.head")) {
					final ItemStack skullItem = new ItemStack(Material.SKULL_ITEM);
					skullItem.setDurability((short) 3);
					final SkullMeta skullMeta = (SkullMeta) skullItem.getItemMeta();
					skullMeta.setOwner(args[0]);
					skullItem.setItemMeta((ItemMeta) skullMeta);
					p.getInventory().addItem(new ItemStack[] { skullItem });
					p.sendMessage(String.valueOf(ArkuzKitPvP.prefix) + " §4➼ §7A Head Foi Adicionada Ao Seu inventario");
				} else {
					p.sendMessage(String.valueOf(ArkuzKitPvP.prefix) + " §4➼ §7Sem Permissão");
				}
			}
		}
		return false;
	}
}
