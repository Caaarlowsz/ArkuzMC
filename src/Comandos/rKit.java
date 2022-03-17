package Comandos;

import java.util.ArrayList;

import com.github.caaarlowsz.arkuzmc.kitpvp.ArkuzKitPvP;
import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Item;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import Essencial.Cooldown;
import Essencial.KitAPI;
import Eventos.Habilidade;
import Kits.C4;

public class rKit implements CommandExecutor {
	public static ArrayList<String> jaresetou;

	static {
		rKit.jaresetou = new ArrayList<String>();
	}

	public boolean onCommand(final CommandSender sender, final Command cmd, final String label, final String[] args) {
		final Player p = (Player) sender;
		if (cmd.getName().equalsIgnoreCase("rkit")) {
			if (p.hasPermission("arkuz.rkit")) {
				if (rKit.jaresetou.contains(p.getName())) {
					p.sendMessage(String.valueOf(ArkuzKitPvP.prefix) + " §4➼ §7Aguarde Para Resetar Seu Kit Novamente");
					return true;
				}
				rKit.jaresetou.add(p.getName());
				p.sendMessage(String.valueOf(ArkuzKitPvP.prefix) + " §4➼ §7Kit Resetado Com Sucesso");
				p.teleport(p.getWorld().getSpawnLocation());
				p.playSound(p.getLocation(), Sound.LEVEL_UP, 10.0f, 0.0f);
				p.getInventory().clear();
				Habilidade.removeAbility(p);
				Cooldown.remove(p);
				KitAPI.remove(p);
				p.setHealth(20.0);
				p.setFireTicks(0);
				p.setFoodLevel(20);
				p.setAllowFlight(false);
				p.setFlying(false);
				p.setGameMode(GameMode.SURVIVAL);
				p.getInventory().setHelmet((ItemStack) null);
				p.getInventory().setChestplate((ItemStack) null);
				p.getInventory().setLeggings((ItemStack) null);
				p.getInventory().setBoots((ItemStack) null);
				setitem(p, Material.PAPER, "§4➼ §cWarps", 1, Enchantment.DAMAGE_ALL, 0, false);
				setitem(p, Material.BOOK, "§4➼ §cLoja", 2, Enchantment.DAMAGE_ALL, 0, false);
				setitem(p, Material.PISTON_STICKY_BASE, "§4➼ §cKits", 4, Enchantment.DAMAGE_ALL, 0, false);
				setitem(p, Material.CHEST, "§4➼ §cCaixas", 6, Enchantment.DAMAGE_ALL, 0, false);
				setitem(p, Material.REDSTONE, "§4➼ §cOutros", 7, Enchantment.DAMAGE_ALL, 0, false);
				if (C4.bomba.containsKey(p.getName())) {
					final Item item = C4.bomba.get(p.getName());
					item.remove();
				}
				Bukkit.getScheduler().scheduleSyncDelayedTask(ArkuzKitPvP.getInstance(), (Runnable) new Runnable() {
					@Override
					public void run() {
						rKit.jaresetou.remove(p.getName());
						p.sendMessage(
								String.valueOf(ArkuzKitPvP.prefix) + " §4➼ §7Você Já Pode Resetar Seu Kit");
					}
				}, 100L);
				return true;
			} else {
				p.sendMessage(String.valueOf(ArkuzKitPvP.prefix) + " §4➼ §7Sem Permissão");
			}
		}
		return false;
	}

	public static void setitem(final Player p, final Material mat, final String nome, final int lugar,
			final Enchantment enchant, final int level, final boolean trueorfalse) {
		final ItemStack item = new ItemStack(mat);
		final ItemMeta itemmeta = item.getItemMeta();
		itemmeta.setDisplayName(nome);
		itemmeta.addEnchant(enchant, level, trueorfalse);
		item.setItemMeta(itemmeta);
		p.getInventory().setItem(lugar, item);
	}
}
