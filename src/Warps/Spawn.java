package Warps;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.Plugin;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import Essencial.KitAPI;
import Eventos.Habilidade;
import Eventos.TheTitle;
import Main.Main;

public class Spawn implements Listener, CommandExecutor {
	public static Main plugin;

	public Spawn(final Main main) {
		Spawn.plugin = main;
	}

	public boolean onCommand(final CommandSender sender, final Command cmd, final String commandLabel,
			final String[] args) {
		if (cmd.getName().equalsIgnoreCase("spawn")) {
			final Player p = (Player) sender;
			p.getInventory().clear();
			p.getInventory().setBoots((ItemStack) null);
			p.getInventory().setChestplate((ItemStack) null);
			p.getInventory().setLeggings((ItemStack) null);
			p.getInventory().setHelmet((ItemStack) null);
			p.addPotionEffect(new PotionEffect(PotionEffectType.SLOW, 500, 100));
			p.sendMessage("§7Voce esta sendo teleportado ao §a§lSPAWN");
			Bukkit.getScheduler().scheduleSyncDelayedTask((Plugin) Spawn.plugin, (Runnable) new Runnable() {
				@Override
				public void run() {
					final World w = Bukkit.getServer().getWorld(Spawn.plugin.getConfig().getString("spawn.world"));
					final double x = Spawn.plugin.getConfig().getDouble("spawn.x");
					final double y = Spawn.plugin.getConfig().getDouble("spawn.y");
					final double z = Spawn.plugin.getConfig().getDouble("spawn.z");
					final Location lobby = new Location(w, x, y, z);
					lobby.setPitch((float) Spawn.plugin.getConfig().getDouble("spawn.pitch"));
					lobby.setYaw((float) Spawn.plugin.getConfig().getDouble("spawn.yaw"));
					KitAPI.remove(p);
					Habilidade.removeAbility(p);
					p.getInventory().setBoots((ItemStack) null);
					p.getInventory().setChestplate((ItemStack) null);
					p.getInventory().setLeggings((ItemStack) null);
					p.getInventory().setHelmet((ItemStack) null);
					p.getInventory().clear();
					p.teleport(lobby);
					p.setExp(0.0f);
					p.setExhaustion(20.0f);
					p.setFireTicks(0);
					p.setFoodLevel(20000);
					p.setHealth(20.0);
					TheTitle.sendTitle(p, Main.prefix);
					TheTitle.sendSubTitle(p, "§7§lSPAWN");
					p.sendMessage(String.valueOf(Main.prefix) + " §4\u27bc §7Voce Foi Teleportado Para: §cSpawn");
					KitAPI.setitem(p, Material.PAPER, "§4\u27bc §cWarps", 1, Enchantment.DAMAGE_ALL, 0, false);
					KitAPI.setitem(p, Material.BOOK, "§4\u27bc §cLoja", 2, Enchantment.DAMAGE_ALL, 0, false);
					KitAPI.setitem(p, Material.PISTON_STICKY_BASE, "§4\u27bc §cKits", 4, Enchantment.DAMAGE_ALL, 0,
							false);
					KitAPI.setitem(p, Material.CHEST, "§4\u27bc §cCaixas", 6, Enchantment.DAMAGE_ALL, 0, false);
					KitAPI.setitem(p, Material.REDSTONE, "§4\u27bc §cOutros", 7, Enchantment.DAMAGE_ALL, 0, false);
					for (final PotionEffect effect : p.getActivePotionEffects()) {
						p.removePotionEffect(effect.getType());
					}
				}
			}, 90L);
		}
		return false;
	}
}
