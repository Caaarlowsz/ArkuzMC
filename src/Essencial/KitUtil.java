package Essencial;

import com.github.caaarlowsz.arkuzmc.kitpvp.ArkuzPvP;
import org.bukkit.Color;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.LeatherArmorMeta;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class KitUtil implements Listener {
	public static void MensagemCooldown(final Player p) {
		p.sendMessage(String.valueOf(ArkuzPvP.prefix) + " §4➼ §7Aguarde §c" + Cooldown.CoolDown(p)
				+ " §7Segundos De Cooldown");
	}

	public static ItemStack darArmadura(final Material material, final Color cor) {
		final ItemStack item = new ItemStack(material);
		final LeatherArmorMeta itemm = (LeatherArmorMeta) item.getItemMeta();
		itemm.setColor(cor);
		item.setItemMeta((ItemMeta) itemm);
		return item;
	}

	public static void tirarEfeitos(final Player p) {
		p.removePotionEffect(PotionEffectType.ABSORPTION);
		p.removePotionEffect(PotionEffectType.BLINDNESS);
		p.removePotionEffect(PotionEffectType.CONFUSION);
		p.removePotionEffect(PotionEffectType.DAMAGE_RESISTANCE);
		p.removePotionEffect(PotionEffectType.FAST_DIGGING);
		p.removePotionEffect(PotionEffectType.FIRE_RESISTANCE);
		p.removePotionEffect(PotionEffectType.HARM);
		p.removePotionEffect(PotionEffectType.HEAL);
		p.removePotionEffect(PotionEffectType.HEALTH_BOOST);
		p.removePotionEffect(PotionEffectType.HUNGER);
		p.removePotionEffect(PotionEffectType.INCREASE_DAMAGE);
		p.removePotionEffect(PotionEffectType.INVISIBILITY);
		p.removePotionEffect(PotionEffectType.JUMP);
		p.removePotionEffect(PotionEffectType.NIGHT_VISION);
		p.removePotionEffect(PotionEffectType.POISON);
		p.removePotionEffect(PotionEffectType.REGENERATION);
		p.removePotionEffect(PotionEffectType.SATURATION);
		p.removePotionEffect(PotionEffectType.SLOW);
		p.removePotionEffect(PotionEffectType.SLOW_DIGGING);
		p.removePotionEffect(PotionEffectType.SPEED);
		p.removePotionEffect(PotionEffectType.WATER_BREATHING);
		p.removePotionEffect(PotionEffectType.WEAKNESS);
		p.removePotionEffect(PotionEffectType.WITHER);
	}

	public static void ItemServer(final Player p) {
		setitem(p, Material.PAPER, "§4➼ §cWarps", 1, Enchantment.DAMAGE_ALL, 0, false);
		setitem(p, Material.BOOK, "§4➼ §cLoja", 2, Enchantment.DAMAGE_ALL, 0, false);
		setitem(p, Material.PISTON_STICKY_BASE, "§4➼ §cKits", 4, Enchantment.DAMAGE_ALL, 0, false);
		setitem(p, Material.CHEST, "§4➼ §cCaixas", 6, Enchantment.DAMAGE_ALL, 0, false);
		setitem(p, Material.REDSTONE, "§4➼ §cOutros", 7, Enchantment.DAMAGE_ALL, 0, false);
	}

	public static void darSopa(final Player p, final int quantas) {
		final ItemStack sopa = new ItemStack(Material.MUSHROOM_SOUP);
		final ItemMeta msopa = sopa.getItemMeta();
		msopa.setDisplayName("§4➼ §cSopa");
		sopa.setItemMeta(msopa);
		for (int i = 0; i < quantas; ++i) {
			p.getInventory().setItem(p.getInventory().firstEmpty(), new ItemStack(sopa));
		}
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

	public static void darItemEnchant(final Player p, final Material mat, final int quantidade, final String nome,
			final int lugar, final Enchantment enchant, final int level, final boolean trueorfalse) {
		final ItemStack item = new ItemStack(mat, quantidade);
		final ItemMeta itemmeta = item.getItemMeta();
		itemmeta.addEnchant(enchant, level, trueorfalse);
		itemmeta.setDisplayName(nome);
		item.setItemMeta(itemmeta);
		p.getInventory().setItem(lugar, item);
	}

	public static void tirarArmadura(final Player p) {
		p.getInventory().setHelmet(new ItemStack(Material.AIR));
		p.getInventory().setChestplate(new ItemStack(Material.AIR));
		p.getInventory().setLeggings(new ItemStack(Material.AIR));
		p.getInventory().setBoots(new ItemStack(Material.AIR));
	}

	public static void darEfeito(final Player p, final PotionEffectType tipo, final int duracao, final int level) {
		p.addPotionEffect(new PotionEffect(tipo, 20 * duracao, level));
	}

	public static void darItem(final Player p, final Material mat, final int quantidade, final String nome,
			final int lugar) {
		final ItemStack item = new ItemStack(mat, quantidade);
		final ItemMeta itemmeta = item.getItemMeta();
		itemmeta.setDisplayName(nome);
		item.setItemMeta(itemmeta);
		p.getInventory().setItem(lugar, item);
	}
}
