package Minigames;

import java.util.Random;

import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.Plugin;
import org.bukkit.scheduler.BukkitRunnable;

import Essencial.KitAPI;
import Eventos.TheTitle;
import Main.Main;

public class refillTest {
	Random rand;

	public refillTest(final Player p) {
		this.rand = new Random();
		if (KitAPI.refillTest.contains(p.getName())) {
			p.sendMessage(String.valueOf(Main.prefix) + " §4\u27bc §7Voc\u00ea J\u00e1 Est\u00e1 Treinando Seu Refil");
			return;
		}
		new BukkitRunnable() {
			int seconds = 5;

			public void run() {
				if (this.seconds > 0) {
					p.sendMessage(String.valueOf(Main.prefix) + " §4\u27bc §7Treino De Refil Iniciando Em: §c"
							+ this.seconds);
					--this.seconds;
					return;
				}
				if (this.seconds == 0) {
					this.seconds = -1;
					p.getInventory().clear();
					TheTitle.sendTitle(p, "§4§lTREINO §8§lDE §c§lREFIL");
					TheTitle.sendSubTitle(p, "§8§lINICIADO");
					p.sendMessage(
							String.valueOf(Main.prefix) + " §4\u27bc §7O §c§nTreino§7 §c§nDe§7 §c§nRefil§7 Iniciado");
					KitAPI.refillTest.add(p.getName());
					KitAPI.refillTestTime.put(p.getName(), refillTest.this.getTime(p) + 1);
					final ItemStack sopa = Methodos.itemStack(Material.MUSHROOM_SOUP, "§cSopa");
					final int r = refillTest.this.rand.nextInt(16);
					Methodos.fillLinhaInventory((Inventory) p.getInventory(), r + 9, sopa, sopa, sopa, sopa, sopa, sopa,
							sopa, sopa, sopa);
				}
				KitAPI.refillTestTime.put(p.getName(), refillTest.this.getTime(p) + 1);
				p.setLevel(refillTest.this.getTime(p));
				if (refillTest.this.hasRefiled(p)) {
					p.setExp(0.0f);
					p.sendMessage(String.valueOf(Main.prefix) + " §4\u27bc §7Voc\u00ea Terminou Seu Refil Em: §c"
							+ Stringtimer.timerChecker(KitAPI.refillTestTime.get(p.getName())) + " §7Segundos");
					p.getInventory().clear();
					refillTest.setitem(p, Material.BOOK, "§4\u27bc §cWarps", 1, Enchantment.DAMAGE_ALL, 0, false);
					refillTest.setitem(p, Material.BREWING_STAND_ITEM, "§4\u27bc §cLoja", 2, Enchantment.DAMAGE_ALL, 0,
							false);
					refillTest.setitem(p, Material.CHEST, "§4\u27bc §cKits", 4, Enchantment.DAMAGE_ALL, 0, false);
					refillTest.setitem(p, Material.MINECART, "§4\u27bc §cCaixas", 6, Enchantment.DAMAGE_ALL, 0, false);
					refillTest.setitem(p, Material.REDSTONE, "§4\u27bc §cOutros", 7, Enchantment.DAMAGE_ALL, 0, false);
					p.teleport(p.getWorld().getSpawnLocation());
					KitAPI.refillTest.remove(p.getName());
					KitAPI.refillTestTime.remove(p.getName());
					this.cancel();
					return;
				}
				if (!KitAPI.refillTest.contains(p.getName()) && this.seconds < 0) {
					this.cancel();
				}
				if (this.seconds >= 60) {
					p.sendMessage(
							String.valueOf(Main.prefix) + " §4\u27bc §7Voc\u00ea Demorou Demais, Tente Mais Uma Vez !");
					this.cancel();
				}
			}
		}.runTaskTimer((Plugin) Main.instance, 0L, 20L);
	}

	private int getTime(final Player p) {
		if (!KitAPI.refillTestTime.containsKey(p.getName())) {
			return 0;
		}
		return KitAPI.refillTestTime.get(p.getName());
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

	private boolean hasRefiled(final Player p) {
		try {
			if (p.getInventory().getItem(0).getType() == Material.AIR) {
				return false;
			}
			if (p.getInventory().getItem(1).getType() == Material.AIR) {
				return false;
			}
			if (p.getInventory().getItem(2).getType() == Material.AIR) {
				return false;
			}
			if (p.getInventory().getItem(3).getType() == Material.AIR) {
				return false;
			}
			if (p.getInventory().getItem(4).getType() == Material.AIR) {
				return false;
			}
			if (p.getInventory().getItem(5).getType() == Material.AIR) {
				return false;
			}
			if (p.getInventory().getItem(6).getType() == Material.AIR) {
				return false;
			}
			if (p.getInventory().getItem(7).getType() == Material.AIR) {
				return false;
			}
			if (p.getInventory().getItem(8).getType() == Material.AIR) {
				return false;
			}
		} catch (Exception e) {
			return false;
		}
		return true;
	}
}
