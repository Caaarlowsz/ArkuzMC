package Eventos;

import org.bukkit.Bukkit;
import org.bukkit.Color;
import org.bukkit.FireworkEffect;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Firework;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.event.player.PlayerRespawnEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.FireworkMeta;
import org.bukkit.inventory.meta.ItemMeta;

import Essencial.KitAPI;
import Main.Main;

public class Join implements Listener {
	@EventHandler
	public void Entrar(final PlayerJoinEvent e) {
		final Player p = e.getPlayer();
		TheTitle.sendTitle(p, "§7Seja bem vindo ao " + Main.prefix);
		TheTitle.sendSubTitle(p, "§aAgradecemos a sua escolha");
		p.sendMessage(" ");
		p.sendMessage(" ");
		p.sendMessage(" ");
		p.sendMessage(" ");
		p.sendMessage(" ");
		p.sendMessage(" ");
		p.sendMessage(" ");
		p.sendMessage(" ");
		p.sendMessage(" ");
		p.sendMessage(" ");
		p.sendMessage(" ");
		p.sendMessage(" ");
		p.sendMessage(" ");
		p.sendMessage(" ");
		p.sendMessage(" ");
		p.sendMessage(" ");
		p.sendMessage(" ");
		p.sendMessage(" ");
		p.sendMessage(" ");
		p.sendMessage(" ");
		p.sendMessage(" ");
		p.sendMessage(" ");
		p.sendMessage(" ");
		p.sendMessage(" ");
		p.sendMessage(" ");
		p.sendMessage(" ");
		p.sendMessage(" ");
		p.sendMessage(" ");
		p.sendMessage(" ");
		p.sendMessage(" ");
		p.sendMessage(" ");
		p.sendMessage(" ");
		p.sendMessage(" ");
		p.sendMessage(" ");
		p.sendMessage(" ");
		p.sendMessage(" ");
		p.sendMessage(" ");
		p.sendMessage(" ");
		p.sendMessage(" ");
		p.sendMessage(" ");
		p.sendMessage(" ");
		p.sendMessage(" ");
		p.sendMessage(" ");
		p.sendMessage(" ");
		p.sendMessage(" ");
		p.sendMessage(" ");
		p.sendMessage("              " + Main.prefix);
		p.sendMessage("            §aOl\u00e1, §f" + p.getName() + "§a!   ");
		p.sendMessage("    §aSeja bem vindo (a) ao nosso servidor ");
		p.sendMessage("    §aQualquer bug deve ser reportado \u00e0 §c§lStaff ");
		p.sendMessage("     §aDependendo da gravidade do BUG ser\u00e1 §6§lRECOMPENSADO");
		p.sendMessage("       §a Use o /ajuda §a para saber MAIS !");
		Bukkit.broadcastMessage("§a+ §7" + p.getDisplayName());
		p.chat("/tag normal");
		p.teleport(p.getWorld().getSpawnLocation());
		p.playSound(p.getLocation(), Sound.LEVEL_UP, 10.0f, 0.0f);
		p.getInventory().setHelmet((ItemStack) null);
		p.getInventory().setChestplate((ItemStack) null);
		p.getInventory().setLeggings((ItemStack) null);
		p.getInventory().setBoots((ItemStack) null);
		KitAPI.remove(p);
		e.setJoinMessage((String) null);
		Habilidade.removeAbility(p);
		p.getInventory().clear();
		setitem(p, Material.PAPER, "§4\u27bc §cWarps", 1, Enchantment.DAMAGE_ALL, 0, false);
		setitem(p, Material.BOOK, "§4\u27bc §cLoja", 2, Enchantment.DAMAGE_ALL, 0, false);
		setitem(p, Material.PISTON_STICKY_BASE, "§4\u27bc §cKits", 4, Enchantment.DAMAGE_ALL, 0, false);
		setitem(p, Material.CHEST, "§4\u27bc §cCaixas", 6, Enchantment.DAMAGE_ALL, 0, false);
		setitem(p, Material.REDSTONE, "§4\u27bc §cOutros", 7, Enchantment.DAMAGE_ALL, 0, false);
		final Firework f = (Firework) p.getPlayer().getWorld().spawn(p.getPlayer().getLocation(),
				Firework.class);
		final FireworkMeta fm = f.getFireworkMeta();
		fm.addEffect(FireworkEffect.builder().flicker(true).trail(true).with(FireworkEffect.Type.BALL)
				.withColor(Color.RED).withFade(Color.GREEN).build());
		fm.setPower(2);
		f.setFireworkMeta(fm);
	}

	@EventHandler
	public void Morte(final PlayerRespawnEvent e) {
		final Player p = e.getPlayer();
		p.getInventory().setHelmet((ItemStack) null);
		p.getInventory().setChestplate((ItemStack) null);
		p.getInventory().setLeggings((ItemStack) null);
		p.getInventory().setBoots((ItemStack) null);
		KitAPI.remove(p);
		p.getInventory().clear();
		Habilidade.removeAbility(p);
		setitem(p, Material.PAPER, "§4\u27bc §cWarps", 1, Enchantment.DAMAGE_ALL, 0, false);
		setitem(p, Material.BOOK, "§4\u27bc §cLoja", 2, Enchantment.DAMAGE_ALL, 0, false);
		setitem(p, Material.PISTON_STICKY_BASE, "§4\u27bc §cKits", 4, Enchantment.DAMAGE_ALL, 0, false);
		setitem(p, Material.CHEST, "§4\u27bc §cCaixas", 6, Enchantment.DAMAGE_ALL, 0, false);
		setitem(p, Material.REDSTONE, "§4\u27bc §cOutros", 7, Enchantment.DAMAGE_ALL, 0, false);
		TheTitle.sendTitle(p, Main.prefix);
		TheTitle.sendSubTitle(p, "§c§lVOC\u00ca MORREU !");
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

	@EventHandler
	public void onSair(final PlayerQuitEvent e) {
		final Player p = e.getPlayer();
		e.setQuitMessage("§c- §7" + p.getDisplayName());
	}
}
