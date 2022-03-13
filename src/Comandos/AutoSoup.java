package Comandos;

import java.util.HashMap;

import com.github.caaarlowsz.arkuzmc.kitpvp.ArkuzPvP;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class AutoSoup implements CommandExecutor, Listener {
	public static HashMap<String, ItemStack[]> saveinv;
	public static HashMap<String, ItemStack[]> armadura;
	ItemStack sopa;
	ItemMeta msopa;
	ItemStack sopa1;
	ItemMeta msopa1;
	ItemStack sopa2;
	ItemMeta msopa2;

	static {
		AutoSoup.saveinv = new HashMap<String, ItemStack[]>();
		AutoSoup.armadura = new HashMap<String, ItemStack[]>();
	}

	public AutoSoup() {
		this.sopa = new ItemStack(Material.MUSHROOM_SOUP);
		this.msopa = this.sopa.getItemMeta();
		this.sopa1 = new ItemStack(Material.MUSHROOM_SOUP);
		this.msopa1 = this.sopa.getItemMeta();
		this.sopa2 = new ItemStack(Material.MUSHROOM_SOUP);
		this.msopa2 = this.sopa.getItemMeta();
	}

	public boolean onCommand(final CommandSender sender, final Command cmd, final String Label, final String[] args) {
		final Player p = (Player) sender;
		if (cmd.getName().equalsIgnoreCase("autosoup")) {
			if (!p.hasPermission("arkuz.admin")) {
				p.sendMessage(String.valueOf(ArkuzPvP.prefix) + " §4➼ §7Sem Permissão");
				return true;
			}
			final Player testando = p.getServer().getPlayer(args[0]);
			p.openInventory((Inventory) testando.getInventory());
			AutoSoup.saveinv.put(testando.getName(), testando.getInventory().getContents());
			AutoSoup.armadura.put(testando.getName(), testando.getInventory().getArmorContents());
			testando.addPotionEffect(new PotionEffect(PotionEffectType.SLOW, 70, 999));
			testando.addPotionEffect(new PotionEffect(PotionEffectType.BLINDNESS, 70, 999));
			this.sopa.setItemMeta(this.msopa);
			Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(ArkuzPvP.getInstance(), (Runnable) new Runnable() {
				@Override
				public void run() {
					testando.getInventory().clear();
					testando.setHealth(5.0);
					testando.getInventory().setItem(10, AutoSoup.this.sopa);
					testando.getInventory().setItem(11, AutoSoup.this.sopa1);
					testando.getInventory().setItem(12, AutoSoup.this.sopa2);
				}
			}, 20L);
			Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(ArkuzPvP.getInstance(), (Runnable) new Runnable() {
				@Override
				public void run() {
					testando.getInventory().clear();
					testando.getInventory().setContents((ItemStack[]) AutoSoup.saveinv.get(testando.getName()));
					testando.getInventory().setArmorContents((ItemStack[]) AutoSoup.armadura.get(testando.getName()));
					testando.setHealth(20.0);
				}
			}, 50L);
		}
		return false;
	}
}
