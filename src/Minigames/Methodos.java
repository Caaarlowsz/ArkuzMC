package Minigames;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.bukkit.Bukkit;
import org.bukkit.Color;
import org.bukkit.FireworkEffect;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.SkullType;
import org.bukkit.craftbukkit.v1_7_R4.CraftWorld;
import org.bukkit.craftbukkit.v1_7_R4.entity.CraftPlayer;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Firework;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.FireworkMeta;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.SkullMeta;
import org.bukkit.plugin.Plugin;

import net.minecraft.server.v1_7_R4.EntityLiving;
import net.minecraft.server.v1_7_R4.EntityVillager;
import net.minecraft.server.v1_7_R4.Packet;
import net.minecraft.server.v1_7_R4.PacketPlayOutSpawnEntityLiving;
import net.minecraft.server.v1_7_R4.World;
import net.minecraft.server.v1_7_R4.WorldServer;

public class Methodos {
	public static void registerEvents(final Listener classe, final Plugin main) {
		Bukkit.getServer().getPluginManager().registerEvents(classe, main);
	}

	public static void DarItem(final Player p, final Material item, final int slot, final String name) {
		final ItemStack give = new ItemStack(item);
		final ItemMeta givem = give.getItemMeta();
		givem.setDisplayName(name);
		give.setItemMeta(givem);
		p.getInventory().setItem(slot, give);
	}

	public static void spawnFirework(final Location loc) {
		final Firework fw = (Firework) loc.getWorld().spawnEntity(loc, EntityType.FIREWORK);
		final FireworkMeta fwm = fw.getFireworkMeta();
		final Random r = new Random();
		final int rt = r.nextInt(4) + 1;
		FireworkEffect.Type type = FireworkEffect.Type.BALL;
		if (rt == 1) {
			type = FireworkEffect.Type.BALL;
		}
		if (rt == 2) {
			type = FireworkEffect.Type.BALL_LARGE;
		}
		if (rt == 3) {
			type = FireworkEffect.Type.BURST;
		}
		if (rt == 4) {
			type = FireworkEffect.Type.CREEPER;
		}
		if (rt == 5) {
			type = FireworkEffect.Type.STAR;
		}
		final Color c1 = Color.RED;
		final Color c2 = Color.YELLOW;
		final Color c3 = Color.ORANGE;
		final FireworkEffect effect = FireworkEffect.builder().flicker(r.nextBoolean()).withColor(c1).withColor(c2)
				.withFade(c3).with(type).trail(r.nextBoolean()).build();
		fwm.addEffect(effect);
		fwm.setPower(1);
		fw.setFireworkMeta(fwm);
	}

	public static ItemStack itemStack(final Material material, final String nome) {
		final ItemStack item = new ItemStack(material);
		final ItemMeta itemmeta = item.getItemMeta();
		itemmeta.setDisplayName(nome);
		item.setItemMeta(itemmeta);
		return item;
	}

	public static void fillLinhaInventory(final Inventory inv, final int fristSlot, final ItemStack slot1,
			final ItemStack slot2, final ItemStack slot3, final ItemStack slot4, final ItemStack slot5,
			final ItemStack slot6, final ItemStack slot7, final ItemStack slot8, final ItemStack slot9) {
		inv.setItem(fristSlot, slot1);
		inv.setItem(fristSlot + 1, slot2);
		inv.setItem(fristSlot + 2, slot3);
		inv.setItem(fristSlot + 3, slot4);
		inv.setItem(fristSlot + 4, slot5);
		inv.setItem(fristSlot + 5, slot6);
		inv.setItem(fristSlot + 6, slot7);
		inv.setItem(fristSlot + 7, slot8);
		inv.setItem(fristSlot + 8, slot9);
	}

	public static ItemStack itemStack(final Material material, final String nome, final String lore) {
		final ItemStack item = new ItemStack(material);
		final ItemMeta itemmeta = item.getItemMeta();
		final List<String> iteml = new ArrayList<String>();
		iteml.add(lore);
		itemmeta.setLore(iteml);
		itemmeta.setDisplayName(nome);
		item.setItemMeta(itemmeta);
		return item;
	}

	public static void spawnNpc(final Location loc, final Player player, final String name) {
		final WorldServer world = ((CraftWorld) loc.getWorld()).getHandle();
		final EntityVillager villager = new EntityVillager((World) world);
		villager.setCustomName(name);
		villager.setCustomNameVisible(true);
		villager.setLocation(loc.getX(), loc.getY(), loc.getZ(), loc.getYaw(), loc.getPitch());
		final PacketPlayOutSpawnEntityLiving packedt = new PacketPlayOutSpawnEntityLiving((EntityLiving) villager);
		Player[] onlinePlayers;
		for (int length = (onlinePlayers = Bukkit.getOnlinePlayers()).length, i = 0; i < length; ++i) {
			final Player all = onlinePlayers[i];
			((CraftPlayer) all).getHandle().playerConnection.sendPacket((Packet) packedt);
		}
	}

	public static ItemStack itemStack(final Material material, final String nome, final String lore,
			final Enchantment enchant, final int levelEnchant) {
		final ItemStack item = new ItemStack(material);
		item.addUnsafeEnchantment(enchant, levelEnchant);
		final ItemMeta itemmeta = item.getItemMeta();
		final List<String> iteml = new ArrayList<String>();
		iteml.add(lore);
		itemmeta.setLore(iteml);
		itemmeta.setDisplayName(nome);
		item.setItemMeta(itemmeta);
		return item;
	}

	public static ItemStack itemStack(final Material material, final String nome, final List<String> lore) {
		final ItemStack item = new ItemStack(material);
		final ItemMeta itemmeta = item.getItemMeta();
		itemmeta.setLore(lore);
		itemmeta.setDisplayName(nome);
		item.setItemMeta(itemmeta);
		return item;
	}

	public static ItemStack itemStack(final Material material, final String nome, final int amount,
			final int durability) {
		final ItemStack item = new ItemStack(material, amount, (short) durability);
		final ItemMeta itemmeta = item.getItemMeta();
		itemmeta.setDisplayName(nome);
		item.setItemMeta(itemmeta);
		return item;
	}

	public static ItemStack itemStack(final Material material, final String nome, final int amount,
			final int durability, final List<String> lore) {
		final ItemStack item = new ItemStack(material, amount, (short) durability);
		final ItemMeta itemmeta = item.getItemMeta();
		itemmeta.setLore(lore);
		itemmeta.setDisplayName(nome);
		item.setItemMeta(itemmeta);
		return item;
	}

	public static ItemStack headStack(final String namePlayer, final String displayName, final List<String> lore) {
		final ItemStack item = new ItemStack(Material.SKULL_ITEM, 1, (short) SkullType.PLAYER.ordinal());
		final SkullMeta itemmeta = (SkullMeta) item.getItemMeta();
		itemmeta.setLore(lore);
		itemmeta.setOwner(namePlayer);
		itemmeta.setDisplayName(displayName);
		item.setItemMeta((ItemMeta) itemmeta);
		return item;
	}
}
