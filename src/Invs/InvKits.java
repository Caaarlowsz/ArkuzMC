package Invs;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.Sound;
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

import Caixas.InvEscolha;
import Main.Main;

public class InvKits implements Listener, CommandExecutor {
	public InvKits(final Main main) {
	}

	@EventHandler
	public void warps(final InventoryClickEvent e) {
		if (e.getCurrentItem() != null && e.getCurrentItem().getItemMeta() != null) {
			final Inventory inv = e.getInventory();
			final Player p = (Player) e.getWhoClicked();
			if (inv.getTitle().equals("§8{ §cKits §8}")) {
				p.playSound(p.getLocation(), Sound.NOTE_PIANO, 5.0f, 5.0f);
			}
		}
	}

	public static void guiKits1(final Player p) {
		final Inventory inv = Bukkit.getServer().createInventory((InventoryHolder) p, 54, "§8{ §cKits §8}");
		final ItemStack vidro21 = new ItemStack(Material.EMERALD, 1, (short) 0);
		final ItemMeta meta21v = vidro21.getItemMeta();
		meta21v.setDisplayName("§7{ §aLoja De Kits §7}");
		vidro21.setItemMeta(meta21v);
		inv.setItem(3, vidro21);
		final ItemStack vidro22 = new ItemStack(Material.DIAMOND, 1, (short) 0);
		final ItemMeta meta31v = vidro22.getItemMeta();
		meta31v.setDisplayName("§7{ §aLoja R$ §7}");
		vidro22.setItemMeta(meta31v);
		inv.setItem(5, vidro22);
		final ItemStack vidro23 = new ItemStack(Material.ENDER_CHEST, 1, (short) 0);
		final ItemMeta meta41v = vidro23.getItemMeta();
		meta41v.setDisplayName("§7{ §5Caixas §7}");
		vidro23.setItemMeta(meta41v);
		inv.setItem(4, vidro23);
		final ItemStack vidro24 = new ItemStack(Material.INK_SACK, 1, (short) 10);
		final ItemMeta meta312v = vidro24.getItemMeta();
		meta312v.setDisplayName("§7{ §aProximo §7}");
		vidro24.setItemMeta(meta312v);
		inv.setItem(8, vidro24);
		final ItemStack vidro25 = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short) 0);
		final ItemMeta meta1v = vidro25.getItemMeta();
		meta1v.setDisplayName("§7+");
		vidro25.setItemMeta(meta1v);
		inv.setItem(1, vidro25);
		inv.setItem(0, vidro25);
		inv.setItem(7, vidro25);
		inv.setItem(9, vidro25);
		inv.setItem(10, vidro25);
		inv.setItem(16, vidro25);
		inv.setItem(17, vidro25);
		final ItemStack vidro26 = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short) 15);
		final ItemMeta meta12v = vidro26.getItemMeta();
		meta12v.setDisplayName("§7=");
		vidro26.setItemMeta(meta12v);
		inv.setItem(18, vidro26);
		inv.setItem(19, vidro26);
		inv.setItem(20, vidro26);
		inv.setItem(21, vidro26);
		inv.setItem(22, vidro26);
		inv.setItem(23, vidro26);
		inv.setItem(24, vidro26);
		inv.setItem(25, vidro26);
		inv.setItem(26, vidro26);
		final ItemStack vidro27 = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short) 14);
		final ItemMeta meta2v = vidro27.getItemMeta();
		meta2v.setDisplayName("§7-");
		vidro27.setItemMeta(meta2v);
		inv.setItem(2, vidro27);
		inv.setItem(6, vidro27);
		inv.setItem(11, vidro27);
		inv.setItem(12, vidro27);
		inv.setItem(13, vidro27);
		inv.setItem(14, vidro27);
		inv.setItem(15, vidro27);
		if (p.hasPermission("kit.pvp")) {
			final ItemStack pyro = new ItemStack(Material.STONE_SWORD);
			final ItemMeta metapyro = pyro.getItemMeta();
			metapyro.setDisplayName("§cPvP");
			final ArrayList<String> descpyro1 = new ArrayList<String>();
			metapyro.setLore((List<String>) descpyro1);
			pyro.setItemMeta(metapyro);
			inv.addItem(new ItemStack[] { pyro });
		}
		if (p.hasPermission("kit.ajnin")) {
			final ItemStack pyro = new ItemStack(Material.NETHER_STAR);
			final ItemMeta metapyro = pyro.getItemMeta();
			metapyro.setDisplayName("§cAjnin");
			final ArrayList<String> descpyro1 = new ArrayList<String>();
			metapyro.setLore((List<String>) descpyro1);
			pyro.setItemMeta(metapyro);
			inv.addItem(new ItemStack[] { pyro });
		}
		if (p.hasPermission("kit.archer")) {
			final ItemStack pyro = new ItemStack(Material.BOW);
			final ItemMeta metapyro = pyro.getItemMeta();
			metapyro.setDisplayName("§cArcher");
			final ArrayList<String> descpyro1 = new ArrayList<String>();
			metapyro.setLore((List<String>) descpyro1);
			pyro.setItemMeta(metapyro);
			inv.addItem(new ItemStack[] { pyro });
		}
		if (p.hasPermission("kit.armor")) {
			final ItemStack pyro = new ItemStack(Material.GOLD_INGOT);
			final ItemMeta metapyro = pyro.getItemMeta();
			metapyro.setDisplayName("§cArmor");
			final ArrayList<String> descpyro1 = new ArrayList<String>();
			metapyro.setLore((List<String>) descpyro1);
			pyro.setItemMeta(metapyro);
			inv.addItem(new ItemStack[] { pyro });
		}
		if (p.hasPermission("kit.Avatar")) {
			final ItemStack pyro = new ItemStack(Material.BEACON);
			final ItemMeta metapyro = pyro.getItemMeta();
			metapyro.setDisplayName("§cAvatar");
			final ArrayList<String> descpyro1 = new ArrayList<String>();
			metapyro.setLore((List<String>) descpyro1);
			pyro.setItemMeta(metapyro);
			inv.addItem(new ItemStack[] { pyro });
		}
		if (p.hasPermission("kit.c4")) {
			final ItemStack pyro = new ItemStack(Material.SLIME_BALL);
			final ItemMeta metapyro = pyro.getItemMeta();
			metapyro.setDisplayName("§cC4");
			final ArrayList<String> descpyro1 = new ArrayList<String>();
			metapyro.setLore((List<String>) descpyro1);
			pyro.setItemMeta(metapyro);
			inv.addItem(new ItemStack[] { pyro });
		}
		if (p.hasPermission("kit.deshfire")) {
			final ItemStack pyro = new ItemStack(Material.REDSTONE_BLOCK);
			final ItemMeta metapyro = pyro.getItemMeta();
			metapyro.setDisplayName("§cDeshFire");
			final ArrayList<String> descpyro1 = new ArrayList<String>();
			metapyro.setLore((List<String>) descpyro1);
			pyro.setItemMeta(metapyro);
			inv.addItem(new ItemStack[] { pyro });
		}
		if (p.hasPermission("kit.fisherman")) {
			final ItemStack pyro = new ItemStack(Material.FISHING_ROD);
			final ItemMeta metapyro = pyro.getItemMeta();
			metapyro.setDisplayName("§cFisherman");
			final ArrayList<String> descpyro1 = new ArrayList<String>();
			metapyro.setLore((List<String>) descpyro1);
			pyro.setItemMeta(metapyro);
			inv.addItem(new ItemStack[] { pyro });
		}
		if (p.hasPermission("kit.kangaroo")) {
			final ItemStack pyro = new ItemStack(Material.FIREWORK);
			final ItemMeta metapyro = pyro.getItemMeta();
			metapyro.setDisplayName("§cKangaroo");
			final ArrayList<String> descpyro1 = new ArrayList<String>();
			metapyro.setLore((List<String>) descpyro1);
			pyro.setItemMeta(metapyro);
			inv.addItem(new ItemStack[] { pyro });
		}
		if (p.hasPermission("kit.magma")) {
			final ItemStack pyro = new ItemStack(Material.FIREBALL);
			final ItemMeta metapyro = pyro.getItemMeta();
			metapyro.setDisplayName("§cMagma");
			final ArrayList<String> descpyro1 = new ArrayList<String>();
			metapyro.setLore((List<String>) descpyro1);
			pyro.setItemMeta(metapyro);
			inv.addItem(new ItemStack[] { pyro });
		}
		if (p.hasPermission("kit.monk")) {
			final ItemStack pyro = new ItemStack(Material.BLAZE_ROD);
			final ItemMeta metapyro = pyro.getItemMeta();
			metapyro.setDisplayName("§cMonk");
			final ArrayList<String> descpyro1 = new ArrayList<String>();
			metapyro.setLore((List<String>) descpyro1);
			pyro.setItemMeta(metapyro);
			inv.addItem(new ItemStack[] { pyro });
		}
		if (p.hasPermission("kit.ninja")) {
			final ItemStack pyro = new ItemStack(Material.COMPASS);
			final ItemMeta metapyro = pyro.getItemMeta();
			metapyro.setDisplayName("§cNinja");
			final ArrayList<String> descpyro1 = new ArrayList<String>();
			metapyro.setLore((List<String>) descpyro1);
			pyro.setItemMeta(metapyro);
			inv.addItem(new ItemStack[] { pyro });
		}
		if (p.hasPermission("kit.gladiator")) {
			final ItemStack pyro = new ItemStack(Material.IRON_FENCE);
			final ItemMeta metapyro = pyro.getItemMeta();
			metapyro.setDisplayName("§cGladiator");
			final ArrayList<String> descpyro1 = new ArrayList<String>();
			metapyro.setLore((List<String>) descpyro1);
			pyro.setItemMeta(metapyro);
			inv.addItem(new ItemStack[] { pyro });
		}
		if (p.hasPermission("kit.poseidon")) {
			final ItemStack pyro = new ItemStack(Material.WATER_BUCKET);
			final ItemMeta metapyro = pyro.getItemMeta();
			metapyro.setDisplayName("§cPoseidon");
			final ArrayList<String> descpyro1 = new ArrayList<String>();
			metapyro.setLore((List<String>) descpyro1);
			pyro.setItemMeta(metapyro);
			inv.addItem(new ItemStack[] { pyro });
		}
		if (p.hasPermission("kit.resouper")) {
			final ItemStack pyro = new ItemStack(Material.MUSHROOM_SOUP);
			final ItemMeta metapyro = pyro.getItemMeta();
			metapyro.setDisplayName("§cResouper");
			final ArrayList<String> descpyro1 = new ArrayList<String>();
			metapyro.setLore((List<String>) descpyro1);
			pyro.setItemMeta(metapyro);
			inv.addItem(new ItemStack[] { pyro });
		}
		if (p.hasPermission("kit.snail")) {
			final ItemStack pyro = new ItemStack(Material.WEB);
			final ItemMeta metapyro = pyro.getItemMeta();
			metapyro.setDisplayName("§cSnail");
			final ArrayList<String> descpyro1 = new ArrayList<String>();
			metapyro.setLore((List<String>) descpyro1);
			pyro.setItemMeta(metapyro);
			inv.addItem(new ItemStack[] { pyro });
		}
		if (p.hasPermission("kit.sonic")) {
			final ItemStack pyro = new ItemStack(Material.LAPIS_BLOCK);
			final ItemMeta metapyro = pyro.getItemMeta();
			metapyro.setDisplayName("§cSonic");
			final ArrayList<String> descpyro1 = new ArrayList<String>();
			metapyro.setLore((List<String>) descpyro1);
			pyro.setItemMeta(metapyro);
			inv.addItem(new ItemStack[] { pyro });
		}
		if (p.hasPermission("kit.stomper")) {
			final ItemStack pyro = new ItemStack(Material.LEATHER_BOOTS);
			final ItemMeta metapyro = pyro.getItemMeta();
			metapyro.setDisplayName("§cStomper");
			final ArrayList<String> descpyro1 = new ArrayList<String>();
			metapyro.setLore((List<String>) descpyro1);
			pyro.setItemMeta(metapyro);
			inv.addItem(new ItemStack[] { pyro });
		}
		if (p.hasPermission("kit.switcher")) {
			final ItemStack pyro = new ItemStack(Material.SNOW_BALL);
			final ItemMeta metapyro = pyro.getItemMeta();
			metapyro.setDisplayName("§cSwitcher");
			final ArrayList<String> descpyro1 = new ArrayList<String>();
			metapyro.setLore((List<String>) descpyro1);
			pyro.setItemMeta(metapyro);
			inv.addItem(new ItemStack[] { pyro });
		}
		if (p.hasPermission("kit.swords")) {
			final ItemStack pyro = new ItemStack(Material.WOOD_SWORD);
			final ItemMeta metapyro = pyro.getItemMeta();
			metapyro.setDisplayName("§cSwords");
			final ArrayList<String> descpyro1 = new ArrayList<String>();
			metapyro.setLore((List<String>) descpyro1);
			pyro.setItemMeta(metapyro);
			inv.addItem(new ItemStack[] { pyro });
		}
		if (p.hasPermission("kit.terrorista")) {
			final ItemStack pyro = new ItemStack(Material.MAGMA_CREAM);
			final ItemMeta metapyro = pyro.getItemMeta();
			metapyro.setDisplayName("§cTerrorista");
			final ArrayList<String> descpyro1 = new ArrayList<String>();
			metapyro.setLore((List<String>) descpyro1);
			pyro.setItemMeta(metapyro);
			inv.addItem(new ItemStack[] { pyro });
		}
		if (p.hasPermission("kit.forcefield")) {
			final ItemStack pyro = new ItemStack(Material.NETHER_FENCE);
			final ItemMeta metapyro = pyro.getItemMeta();
			metapyro.setDisplayName("§cForceField");
			final ArrayList<String> descpyro1 = new ArrayList<String>();
			metapyro.setLore((List<String>) descpyro1);
			pyro.setItemMeta(metapyro);
			inv.addItem(new ItemStack[] { pyro });
		}
		if (p.hasPermission("kit.thor")) {
			final ItemStack pyro = new ItemStack(Material.GOLD_AXE);
			final ItemMeta metapyro = pyro.getItemMeta();
			metapyro.setDisplayName("§cThor");
			final ArrayList<String> descpyro1 = new ArrayList<String>();
			metapyro.setLore((List<String>) descpyro1);
			pyro.setItemMeta(metapyro);
			inv.addItem(new ItemStack[] { pyro });
		}
		if (p.hasPermission("kit.thresh")) {
			final ItemStack pyro = new ItemStack(Material.LEVER);
			final ItemMeta metapyro = pyro.getItemMeta();
			metapyro.setDisplayName("§cThresh");
			final ArrayList<String> descpyro1 = new ArrayList<String>();
			metapyro.setLore((List<String>) descpyro1);
			pyro.setItemMeta(metapyro);
			inv.addItem(new ItemStack[] { pyro });
		}
		if (p.hasPermission("kit.turtle")) {
			final ItemStack pyro = new ItemStack(Material.DIAMOND_CHESTPLATE);
			final ItemMeta metapyro = pyro.getItemMeta();
			metapyro.setDisplayName("§cTurtle");
			final ArrayList<String> descpyro1 = new ArrayList<String>();
			metapyro.setLore((List<String>) descpyro1);
			pyro.setItemMeta(metapyro);
			inv.addItem(new ItemStack[] { pyro });
		}
		if (p.hasPermission("kit.viking")) {
			final ItemStack pyro = new ItemStack(Material.STONE_AXE);
			final ItemMeta metapyro = pyro.getItemMeta();
			metapyro.setDisplayName("§cViking");
			final ArrayList<String> descpyro1 = new ArrayList<String>();
			metapyro.setLore((List<String>) descpyro1);
			pyro.setItemMeta(metapyro);
			inv.addItem(new ItemStack[] { pyro });
		}
		if (p.hasPermission("kit.viper")) {
			final ItemStack pyro = new ItemStack(Material.SPIDER_EYE);
			final ItemMeta metapyro = pyro.getItemMeta();
			metapyro.setDisplayName("§cViper");
			final ArrayList<String> descpyro1 = new ArrayList<String>();
			metapyro.setLore((List<String>) descpyro1);
			pyro.setItemMeta(metapyro);
			inv.addItem(new ItemStack[] { pyro });
		}
		p.openInventory(inv);
	}

	public boolean onCommand(final CommandSender sender, final Command cmd, final String commandLabel,
			final String[] args) {
		if (commandLabel.equalsIgnoreCase("kits")) {
			final Player p = (Player) sender;
			guiKits1(p);
		}
		return false;
	}

	@EventHandler
	public void onPlayerCLickInventry(final InventoryClickEvent e) {
		final Player p = (Player) e.getWhoClicked();
		if (e.getInventory().getTitle().equalsIgnoreCase("§8{ §cKits §8}") && e.getCurrentItem() != null
				&& e.getCurrentItem().getTypeId() != 0) {
			e.setCancelled(true);
			if (e.getCurrentItem().getType() == Material.STONE_SWORD) {
				e.setCancelled(true);
				p.closeInventory();
				p.chat("/kit pvp");
				return;
			}
			if (e.getCurrentItem().getType() == Material.NETHER_STAR) {
				e.setCancelled(true);
				p.closeInventory();
				p.chat("/kit ajnin");
				return;
			}
			if (e.getCurrentItem().getType() == Material.NETHER_FENCE) {
				e.setCancelled(true);
				p.closeInventory();
				p.chat("/kit forcefield");
				return;
			}
			if (e.getCurrentItem().getType() == Material.GOLD_INGOT) {
				e.setCancelled(true);
				p.closeInventory();
				p.chat("/kit armor");
				return;
			}
			if (e.getCurrentItem().getType() == Material.WATER_BUCKET) {
				e.setCancelled(true);
				p.closeInventory();
				p.chat("/kit poseidon");
				return;
			}
			if (e.getCurrentItem().getType() == Material.LEVER) {
				e.setCancelled(true);
				p.closeInventory();
				p.chat("/kit thresh");
				return;
			}
			if (e.getCurrentItem().getType() == Material.STONE_AXE) {
				e.setCancelled(true);
				p.closeInventory();
				p.chat("/kit viking");
				return;
			}
			if (e.getCurrentItem().getType() == Material.ANVIL) {
				e.setCancelled(true);
				p.closeInventory();
				p.chat("/kit anchor");
				return;
			}
			if (e.getCurrentItem().getType() == Material.BEACON) {
				e.setCancelled(true);
				p.closeInventory();
				p.chat("/kit avatar");
				return;
			}
			if (e.getCurrentItem().getType() == Material.DIAMOND_CHESTPLATE) {
				e.setCancelled(true);
				p.closeInventory();
				p.chat("/kit turtle");
				return;
			}
			if (e.getCurrentItem().getType() == Material.WOOD_SWORD) {
				e.setCancelled(true);
				p.closeInventory();
				p.chat("/kit swords");
				return;
			}
			if (e.getCurrentItem().getType() == Material.SNOW_BALL) {
				e.setCancelled(true);
				p.closeInventory();
				p.chat("/kit switcher");
				return;
			}
			if (e.getCurrentItem().getType() == Material.MAGMA_CREAM) {
				e.setCancelled(true);
				p.closeInventory();
				p.chat("/kit terrorista");
				return;
			}
			if (e.getCurrentItem().getType() == Material.SPIDER_EYE) {
				e.setCancelled(true);
				p.closeInventory();
				p.chat("/kit viper");
				return;
			}
			if (e.getCurrentItem().getType() == Material.SLIME_BALL) {
				e.setCancelled(true);
				p.closeInventory();
				p.chat("/kit c4");
				return;
			}
			if (e.getCurrentItem().getType() == Material.BOW) {
				e.setCancelled(true);
				p.closeInventory();
				p.chat("/kit archer");
				return;
			}
			if (e.getCurrentItem().getType() == Material.GOLD_AXE) {
				e.setCancelled(true);
				p.closeInventory();
				p.chat("/kit thor");
				return;
			}
			if (e.getCurrentItem().getType() == Material.REDSTONE_BLOCK) {
				e.setCancelled(true);
				p.closeInventory();
				p.chat("/kit deshfire");
				return;
			}
			if (e.getCurrentItem().getType() == Material.FISHING_ROD) {
				e.setCancelled(true);
				p.closeInventory();
				p.chat("/kit fisherman");
				return;
			}
			if (e.getCurrentItem().getType() == Material.IRON_FENCE) {
				e.setCancelled(true);
				p.closeInventory();
				p.chat("/kit gladiator");
				return;
			}
			if (e.getCurrentItem().getType() == Material.LEASH) {
				e.setCancelled(true);
				p.closeInventory();
				p.chat("/kit grappler");
				return;
			}
			if (e.getCurrentItem().getType() == Material.SADDLE) {
				e.setCancelled(true);
				p.closeInventory();
				p.chat("/kit hulk");
				return;
			}
			if (e.getCurrentItem().getType() == Material.CLAY_BALL) {
				e.setCancelled(true);
				p.closeInventory();
				p.chat("/kit jellyfish");
				return;
			}
			if (e.getCurrentItem().getType() == Material.FIREWORK) {
				e.setCancelled(true);
				p.closeInventory();
				p.chat("/kit kangaroo");
				return;
			}
			if (e.getCurrentItem().getType() == Material.FIREBALL) {
				e.setCancelled(true);
				p.closeInventory();
				p.chat("/kit magma");
				return;
			}
			if (e.getCurrentItem().getType() == Material.BLAZE_ROD) {
				e.setCancelled(true);
				p.closeInventory();
				p.chat("/kit monk");
				return;
			}
			if (e.getCurrentItem().getType() == Material.COMPASS) {
				e.setCancelled(true);
				p.closeInventory();
				p.chat("/kit ninja");
				return;
			}
			if (e.getCurrentItem().getType() == Material.FEATHER) {
				e.setCancelled(true);
				p.closeInventory();
				p.chat("/kit phantom");
				return;
			}
			if (e.getCurrentItem().getType() == Material.WATER) {
				e.setCancelled(true);
				p.closeInventory();
				p.chat("/kit poseidon");
				return;
			}
			if (e.getCurrentItem().getType() == Material.MUSHROOM_SOUP) {
				e.setCancelled(true);
				p.closeInventory();
				p.chat("/kit resouper");
				return;
			}
			if (e.getCurrentItem().getType() == Material.WEB) {
				e.setCancelled(true);
				p.closeInventory();
				p.chat("/kit snail");
				return;
			}
			if (e.getCurrentItem().getType() == Material.LEATHER_BOOTS) {
				e.setCancelled(true);
				p.closeInventory();
				p.chat("/kit stomper");
				return;
			}
			if (e.getCurrentItem().getType() == Material.LAPIS_BLOCK) {
				e.setCancelled(true);
				p.closeInventory();
				p.chat("/kit sonic");
				return;
			}
			if (e.getCurrentItem().getType() == Material.EMERALD) {
				e.setCancelled(true);
				p.closeInventory();
				p.chat("/lojakits");
				return;
			}
			if (e.getCurrentItem().getType() == Material.ENDER_CHEST) {
				e.setCancelled(true);
				p.closeInventory();
				InvEscolha.guiKits(p);
				return;
			}
			if (e.getCurrentItem().getType() == Material.DIAMOND) {
				e.setCancelled(true);
				p.closeInventory();
				p.sendMessage(String.valueOf(Main.prefix) + " §4\u27bc §7Entrem Em Nossa Loja: §c" + Main.loja);
				return;
			}
			if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§7{ §aProximo §7}")) {
				e.setCancelled(true);
				p.closeInventory();
				InvKits2.guiKits1(p);
			}
		}
	}
}
