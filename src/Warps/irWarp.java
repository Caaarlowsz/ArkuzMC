package Warps;

import Essencial.KitUtil;
import Eventos.Habilidade;
import Eventos.TheTitle;
import com.github.caaarlowsz.arkuzmc.kitpvp.ArkuzKitPvP;
import org.bukkit.*;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class irWarp implements CommandExecutor, Listener {
    public boolean onCommand(final CommandSender sender, final Command cmd, final String commandLabel,
                             final String[] args) {
        final Player p = (Player) sender;
        if (cmd.getName().equalsIgnoreCase("warp") && args.length == 0) {
            p.sendMessage(String.valueOf(ArkuzKitPvP.prefix) + " �4? �7Use: /Warp {Warp}");
            return true;
        }
        if (args[0].equalsIgnoreCase("challenge")) {
            if (ArkuzKitPvP.getInstance().warps.getConfigurationSection("challenge") == null) {
                p.sendMessage(String.valueOf(ArkuzKitPvP.prefix) + " �4? �7Warp Challenge Ainda N�o Foi Setada");
                return true;
            }
            final World w = Bukkit.getServer().getWorld(ArkuzKitPvP.getInstance().warps.getString("challenge.world"));
            final double x = ArkuzKitPvP.getInstance().warps.getDouble("challenge.x");
            final double y = ArkuzKitPvP.getInstance().warps.getDouble("challenge.y");
            final double z = ArkuzKitPvP.getInstance().warps.getDouble("challenge.z");
            final Location lobby = new Location(w, x, y, z);
            lobby.setPitch((float) ArkuzKitPvP.getInstance().warps.getDouble("challenge.pitch"));
            lobby.setYaw((float) ArkuzKitPvP.getInstance().warps.getDouble("challenge.yaw"));
            p.teleport(lobby);
            Habilidade.removeAbility(p);
            p.getInventory().clear();
            p.sendMessage(String.valueOf(ArkuzKitPvP.prefix) + " �4? �7Voc� Foi Teleportado Para: �cLava Challenge");
            TheTitle.sendTitle(p, ArkuzKitPvP.prefix);
            TheTitle.sendSubTitle(p, "�7�lCHALLENGE");
            Habilidade.setAbility(p, "Challenge");
            p.setFireTicks(0);
            p.setGameMode(GameMode.SURVIVAL);
            KitUtil.darSopa(p, 36);
            KitUtil.tirarEfeitos(p);
            KitUtil.tirarArmadura(p);
            final ItemStack sopas = new ItemStack(Material.BOWL, 64);
            final ItemMeta ksopas = sopas.getItemMeta();
            sopas.setItemMeta(ksopas);
            final ItemStack cogur = new ItemStack(Material.RED_MUSHROOM, 64);
            final ItemMeta kcogur = cogur.getItemMeta();
            cogur.setItemMeta(kcogur);
            final ItemStack cogum = new ItemStack(Material.BROWN_MUSHROOM, 64);
            final ItemMeta kcogum = cogum.getItemMeta();
            cogum.setItemMeta(kcogum);
            p.getInventory().setItem(13, sopas);
            p.getInventory().setItem(14, cogur);
            p.getInventory().setItem(15, cogum);
            p.setAllowFlight(false);
            p.updateInventory();
            return true;
        } else if (args[0].equalsIgnoreCase("fps")) {
            if (ArkuzKitPvP.getInstance().warps.getConfigurationSection("fps") == null) {
                p.sendMessage(String.valueOf(ArkuzKitPvP.prefix) + " �4? �7Warp FPS Ainda N�o Foi Setada");
                return true;
            }
            final World w = Bukkit.getServer().getWorld(ArkuzKitPvP.getInstance().warps.getString("fps.world"));
            final double x = ArkuzKitPvP.getInstance().warps.getDouble("fps.x");
            final double y = ArkuzKitPvP.getInstance().warps.getDouble("fps.y");
            final double z = ArkuzKitPvP.getInstance().warps.getDouble("fps.z");
            final Location lobby = new Location(w, x, y, z);
            lobby.setPitch((float) ArkuzKitPvP.getInstance().warps.getDouble("fps.pitch"));
            lobby.setYaw((float) ArkuzKitPvP.getInstance().warps.getDouble("fps.yaw"));
            p.teleport(lobby);
            Habilidade.removeAbility(p);
            p.getInventory().clear();
            p.setHealth(20.0);
            p.sendMessage(String.valueOf(ArkuzKitPvP.prefix) + " �4? �7Voc� Foi Teleportado Para: �cFps");
            TheTitle.sendTitle(p, ArkuzKitPvP.prefix);
            TheTitle.sendSubTitle(p, "�7�lFPS");
            Habilidade.setAbility(p, "Fps");
            p.setFireTicks(0);
            KitUtil.darItem(p, Material.STONE_SWORD, 1, "�aEspada", 0);
            KitUtil.darSopa(p, 35);
            p.setGameMode(GameMode.ADVENTURE);
            KitUtil.tirarEfeitos(p);
            KitUtil.tirarArmadura(p);
            p.setAllowFlight(false);
            p.updateInventory();
            return true;
        } else if (args[0].equalsIgnoreCase("main")) {
            if (ArkuzKitPvP.getInstance().warps.getConfigurationSection("main") == null) {
                p.sendMessage(String.valueOf(ArkuzKitPvP.prefix) + " �4? �7Warp Main Ainda N�o Foi Setada");
                return true;
            }
            final World w = Bukkit.getServer().getWorld(ArkuzKitPvP.getInstance().warps.getString("main.world"));
            final double x = ArkuzKitPvP.getInstance().warps.getDouble("main.x");
            final double y = ArkuzKitPvP.getInstance().warps.getDouble("main.y");
            final double z = ArkuzKitPvP.getInstance().warps.getDouble("main.z");
            final Location lobby = new Location(w, x, y, z);
            lobby.setPitch((float) ArkuzKitPvP.getInstance().warps.getDouble("main.pitch"));
            lobby.setYaw((float) ArkuzKitPvP.getInstance().warps.getDouble("main.yaw"));
            p.teleport(lobby);
            Habilidade.removeAbility(p);
            p.getInventory().clear();
            p.sendMessage(String.valueOf(ArkuzKitPvP.prefix) + " �4? �7Voc� Foi Teleportado Para: �cMain");
            TheTitle.sendTitle(p, ArkuzKitPvP.prefix);
            TheTitle.sendSubTitle(p, "�7�lMAIN");
            p.setGameMode(GameMode.SURVIVAL);
            Habilidade.setAbility(p, "Main");
            p.setFireTicks(0);
            p.setHealth(20.0);
            KitUtil.darItemEnchant(p, Material.DIAMOND_SWORD, 1, "�aEspada", 0, Enchantment.DAMAGE_ALL, 1, true);
            p.getInventory().setHelmet(new ItemStack(Material.IRON_HELMET));
            p.getInventory().setChestplate(new ItemStack(Material.IRON_CHESTPLATE));
            p.getInventory().setLeggings(new ItemStack(Material.IRON_LEGGINGS));
            p.getInventory().setBoots(new ItemStack(Material.IRON_BOOTS));
            p.addPotionEffect(new PotionEffect(PotionEffectType.INCREASE_DAMAGE, 999999999, 0));
            p.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 999999999, 0));
            KitUtil.darSopa(p, 34);
            p.setAllowFlight(false);
            p.updateInventory();
            return true;
        } else {
            if (args[0].equalsIgnoreCase("gladiator")) {
                p.sendMessage(
                        String.valueOf(ArkuzKitPvP.prefix) + " �4? �7Warp gladiator est� em desenvolvimento...");
                return true;
            }
            if (args[0].equalsIgnoreCase("knock")) {
                if (ArkuzKitPvP.getInstance().warps.getConfigurationSection("knock") == null) {
                    p.sendMessage(String.valueOf(ArkuzKitPvP.prefix) + " �4? �7Warp Knock Ainda N�o Foi Setada");
                    return true;
                }
                final World w = Bukkit.getServer().getWorld(ArkuzKitPvP.getInstance().warps.getString("knock.world"));
                final double x = ArkuzKitPvP.getInstance().warps.getDouble("knock.x");
                final double y = ArkuzKitPvP.getInstance().warps.getDouble("knock.y");
                final double z = ArkuzKitPvP.getInstance().warps.getDouble("knock.z");
                final Location lobby = new Location(w, x, y, z);
                lobby.setPitch((float) ArkuzKitPvP.getInstance().warps.getDouble("knock.pitch"));
                lobby.setYaw((float) ArkuzKitPvP.getInstance().warps.getDouble("knock.yaw"));
                p.teleport(lobby);
                Habilidade.removeAbility(p);
                p.getInventory().clear();
                p.setGameMode(GameMode.SURVIVAL);
                p.sendMessage(String.valueOf(ArkuzKitPvP.prefix) + " �4? �7Voc� Foi Teleportado Para: �cKnock");
                TheTitle.sendTitle(p, ArkuzKitPvP.prefix);
                TheTitle.sendSubTitle(p, "�7�lKNOCK");
                Habilidade.setAbility(p, "Knock");
                p.setFireTicks(0);
                p.setHealth(20.0);
                KitUtil.darItemEnchant(p, Material.STICK, 1, "�aVaret�o", 0, Enchantment.KNOCKBACK, 5, true);
                KitUtil.tirarEfeitos(p);
                KitUtil.tirarArmadura(p);
                p.setAllowFlight(false);
                p.updateInventory();
                return true;
            } else if (args[0].equalsIgnoreCase("textura")) {
                if (ArkuzKitPvP.getInstance().warps.getConfigurationSection("textura") == null) {
                    p.sendMessage(String.valueOf(ArkuzKitPvP.prefix) + " �4? �7Warp Textura Ainda N�o Foi Setada");
                    return true;
                }
                final World w = Bukkit.getServer().getWorld(ArkuzKitPvP.getInstance().warps.getString("textura.world"));
                final double x = ArkuzKitPvP.getInstance().warps.getDouble("textura.x");
                final double y = ArkuzKitPvP.getInstance().warps.getDouble("textura.y");
                final double z = ArkuzKitPvP.getInstance().warps.getDouble("textura.z");
                final Location lobby = new Location(w, x, y, z);
                lobby.setPitch((float) ArkuzKitPvP.getInstance().warps.getDouble("textura.pitch"));
                lobby.setYaw((float) ArkuzKitPvP.getInstance().warps.getDouble("textura.yaw"));
                p.teleport(lobby);
                Habilidade.removeAbility(p);
                p.getInventory().clear();
                p.setGameMode(GameMode.SURVIVAL);
                p.sendMessage(String.valueOf(ArkuzKitPvP.prefix) + " �4? �7Voc� Foi Teleportado Para: �cTextura");
                TheTitle.sendTitle(p, ArkuzKitPvP.prefix);
                TheTitle.sendSubTitle(p, "�7�lTEXTURA");
                Habilidade.setAbility(p, "Textura");
                p.setFireTicks(0);
                p.setHealth(20.0);
                KitUtil.tirarEfeitos(p);
                KitUtil.tirarArmadura(p);
                p.setAllowFlight(false);
                p.updateInventory();
                return true;
            } else if (args[0].equalsIgnoreCase("mdr")) {
                if (ArkuzKitPvP.getInstance().warps.getConfigurationSection("mdr") == null) {
                    p.sendMessage(String.valueOf(ArkuzKitPvP.prefix) + " �4? �7Warp Mdr Ainda N�o Foi Setada");
                    return true;
                }
                final World w = Bukkit.getServer().getWorld(ArkuzKitPvP.getInstance().warps.getString("mdr.world"));
                final double x = ArkuzKitPvP.getInstance().warps.getDouble("mdr.x");
                final double y = ArkuzKitPvP.getInstance().warps.getDouble("mdr.y");
                final double z = ArkuzKitPvP.getInstance().warps.getDouble("mdr.z");
                final Location lobby = new Location(w, x, y, z);
                lobby.setPitch((float) ArkuzKitPvP.getInstance().warps.getDouble("mdr.pitch"));
                lobby.setYaw((float) ArkuzKitPvP.getInstance().warps.getDouble("mdr.yaw"));
                p.teleport(lobby);
                p.setGameMode(GameMode.SURVIVAL);
                Habilidade.removeAbility(p);
                p.getInventory().clear();
                p.sendMessage(String.valueOf(ArkuzKitPvP.prefix) + " �4? �7Voc� Foi Teleportado Para: �cMdr");
                TheTitle.sendTitle(p, ArkuzKitPvP.prefix);
                TheTitle.sendSubTitle(p, "�7�lMDR");
                Habilidade.setAbility(p, "Mdr");
                p.setHealth(20.0);
                p.setFireTicks(0);
                KitUtil.tirarEfeitos(p);
                KitUtil.tirarArmadura(p);
                p.setAllowFlight(false);
                p.updateInventory();
                return true;
            } else {
                if (!args[0].equalsIgnoreCase("rdm")) {
                    return false;
                }
                if (ArkuzKitPvP.getInstance().warps.getConfigurationSection("rdm") == null) {
                    p.sendMessage(String.valueOf(ArkuzKitPvP.prefix) + " �4? �7Warp Rdm Ainda N�o Foi Setada");
                    return true;
                }
                final World w = Bukkit.getServer().getWorld(ArkuzKitPvP.getInstance().warps.getString("rdm.world"));
                final double x = ArkuzKitPvP.getInstance().warps.getDouble("rdm.x");
                final double y = ArkuzKitPvP.getInstance().warps.getDouble("rdm.y");
                final double z = ArkuzKitPvP.getInstance().warps.getDouble("rdm");
                final Location lobby = new Location(w, x, y, z);
                lobby.setPitch((float) ArkuzKitPvP.getInstance().warps.getDouble("rdm.pitch"));
                lobby.setYaw((float) ArkuzKitPvP.getInstance().warps.getDouble("rdm.yaw"));
                p.teleport(lobby);
                Habilidade.removeAbility(p);
                p.getInventory().clear();
                p.setHealth(20.0);
                p.setGameMode(GameMode.SURVIVAL);
                p.sendMessage(String.valueOf(ArkuzKitPvP.prefix) + " �4? �7Voc� Foi Teleportado Para: �cRdm");
                TheTitle.sendTitle(p, ArkuzKitPvP.prefix);
                TheTitle.sendSubTitle(p, "�7�lRDM");
                Habilidade.setAbility(p, "Rdm");
                KitUtil.darItemEnchant(p, Material.STONE_SWORD, 1, "�aEspada", 0, Enchantment.DAMAGE_ALL, 1, true);
                p.getInventory().setHelmet(new ItemStack(Material.LEATHER_HELMET));
                p.getInventory().setChestplate(new ItemStack(Material.LEATHER_CHESTPLATE));
                p.getInventory().setLeggings(new ItemStack(Material.LEATHER_LEGGINGS));
                p.getInventory().setBoots(new ItemStack(Material.LEATHER_BOOTS));
                KitUtil.darSopa(p, 34);
                p.setFireTicks(0);
                KitUtil.tirarEfeitos(p);
                p.setAllowFlight(false);
                p.updateInventory();
                return true;
            }
        }
    }

    public static void Ir(final Player p, final String string) {
    }
}
