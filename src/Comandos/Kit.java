package Comandos;

import Essencial.KitUtil;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.Material;
import Eventos.TheTitle;
import Eventos.Habilidade;
import Essencial.KitAPI;
import org.bukkit.entity.Player;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import Main.Main;
import org.bukkit.event.Listener;
import org.bukkit.command.CommandExecutor;

public class Kit implements CommandExecutor, Listener
{
    public Kit(final Main main) {
    }
    
    public boolean onCommand(final CommandSender sender, final Command cmd, final String label, final String[] args) {
        final Player p = (Player)sender;
        if (label.equalsIgnoreCase("kit")) {
            if (args.length == 0) {
                p.sendMessage(String.valueOf(Main.prefix) + " §4\u27bc §7Use: /Kit {Kit}");
                return true;
            }
            if (KitAPI.Kit.contains(p.getName())) {
                p.sendMessage(String.valueOf(Main.prefix) + " §4\u27bc §7Para Usar Outro Kit Digite: /Spawn");
                return true;
            }
        }
        if (args[0].equalsIgnoreCase("pvp")) {
            if (p.hasPermission("kit.pvp")) {
                p.getInventory().clear();
                KitAPI.recraft(p);
                KitAPI.sopa(p);
                KitAPI.sword(p);
                Habilidade.setAbility(p, "PvP");
                KitAPI.Kit.add(p.getName());
                p.sendMessage(String.valueOf(Main.prefix) + " §4\u27bc §7Voc\u00ea Selecionou o Kit: §cPvP");
                TheTitle.sendTitle(p, "§7§lKIT §4§lPVP");
                TheTitle.sendSubTitle(p, "§c§lFOI SELECIONADO");
                SetArena.TeleportArenaRandom(p);
            }
            else {
                p.sendMessage(String.valueOf(Main.prefix) + " §4\u27bc §7Voc\u00ea N\u00e3o Tem Permiss\u00e3o Para Usar Este Kit");
            }
        }
        if (args[0].equalsIgnoreCase("ajnin")) {
            if (p.hasPermission("kit.ajnin")) {
                p.getInventory().clear();
                KitAPI.recraft(p);
                KitAPI.sopa(p);
                KitAPI.sword(p);
                Habilidade.setAbility(p, "Ajnin");
                KitAPI.Kit.add(p.getName());
                KitAPI.Ajnin.add(p.getName());
                p.sendMessage(String.valueOf(Main.prefix) + " §4\u27bc §7Voc\u00ea Selecionou o Kit: §cAjnin");
                TheTitle.sendTitle(p, "§7§lKIT §4§lAJNIN");
                TheTitle.sendSubTitle(p, "§c§lFOI SELECIONADO");
                SetArena.TeleportArenaRandom(p);
            }
            else {
                p.sendMessage(String.valueOf(Main.prefix) + "§4\u27bc§7Voc\u00ea N\u00e3o Tem Permiss\u00e3o Para Usar Este Kit");
            }
        }
        if (args[0].equalsIgnoreCase("anchor")) {
            if (p.hasPermission("kit.anchor")) {
                p.getInventory().clear();
                KitAPI.recraft(p);
                KitAPI.sopa(p);
                KitAPI.sword(p);
                Habilidade.setAbility(p, "Anchor");
                KitAPI.Kit.add(p.getName());
                KitAPI.Anchor.add(p.getName());
                p.sendMessage(String.valueOf(Main.prefix) + " §4\u27bc §7Voc\u00ea Selecionou o Kit: §cAnchor");
                TheTitle.sendTitle(p, "§7§lKIT §4§lANCHOR");
                TheTitle.sendSubTitle(p, "§c§lFOI SELECIONADO");
                SetArena.TeleportArenaRandom(p);
            }
            else {
                p.sendMessage(String.valueOf(Main.prefix) + " §4\u27bc §7Voc\u00ea N\u00e3o Tem Permiss\u00e3o Para Usar Este Kit");
            }
        }
        if (args[0].equalsIgnoreCase("armor")) {
            if (p.hasPermission("kit.armor")) {
                p.getInventory().clear();
                KitAPI.recraft(p);
                KitAPI.sopa(p);
                KitAPI.sword(p);
                Habilidade.setAbility(p, "Armor");
                KitAPI.Kit.add(p.getName());
                KitAPI.Armor.add(p.getName());
                p.sendMessage(String.valueOf(Main.prefix) + " §4\u27bc §7Voc\u00ea Selecionou o Kit: §cArmor");
                KitAPI.setitem(p, Material.GOLD_INGOT, "§7Kit §cArmor", 1, Enchantment.DAMAGE_ALL, 0, false);
                TheTitle.sendTitle(p, "§7§lKIT §4§lARMOR");
                TheTitle.sendSubTitle(p, "§c§lFOI SELECIONADO");
                SetArena.TeleportArenaRandom(p);
            }
            else {
                p.sendMessage(String.valueOf(Main.prefix) + " §4\u27bc §7Voc\u00ea N\u00e3o Tem Permiss\u00e3o Para Usar Este Kit");
            }
        }
        if (args[0].equalsIgnoreCase("avatar")) {
            if (p.hasPermission("kit.avatar")) {
                p.getInventory().clear();
                KitAPI.recraft(p);
                KitAPI.sopa(p);
                KitAPI.sword(p);
                Habilidade.setAbility(p, "Avatar");
                KitAPI.Kit.add(p.getName());
                KitAPI.Avatar.add(p.getName());
                p.sendMessage(String.valueOf(Main.prefix) + " §4\u27bc §7Voc\u00ea Selecionou o Kit: §cAvatar");
                KitAPI.setitem(p, Material.BEACON, "§7Kit §cAvatar", 1, Enchantment.DAMAGE_ALL, 0, false);
                TheTitle.sendTitle(p, "§7§lKIT §4§lAVATAR");
                TheTitle.sendSubTitle(p, "§c§lFOI SELECIONADO");
                SetArena.TeleportArenaRandom(p);
            }
            else {
                p.sendMessage(String.valueOf(Main.prefix) + " §4\u27bc §7Voc\u00ea N\u00e3o Tem Permiss\u00e3o Para Usar Este Kit");
            }
        }
        if (args[0].equalsIgnoreCase("C4")) {
            if (p.hasPermission("kit.C4")) {
                p.getInventory().clear();
                KitAPI.recraft(p);
                KitAPI.sopa(p);
                KitAPI.sword(p);
                Habilidade.setAbility(p, "C4");
                KitAPI.Kit.add(p.getName());
                KitAPI.C4.add(p.getName());
                p.sendMessage(String.valueOf(Main.prefix) + " §4\u27bc §7Voc\u00ea Selecionou o Kit: §cC4");
                KitAPI.setitem(p, Material.SLIME_BALL, "§7Kit §cC4", 1, Enchantment.DAMAGE_ALL, 0, false);
                TheTitle.sendTitle(p, "§7§lKIT §4§lC4");
                TheTitle.sendSubTitle(p, "§c§lFOI SELECIONADO");
                SetArena.TeleportArenaRandom(p);
            }
            else {
                p.sendMessage(String.valueOf(Main.prefix) + " §4\u27bc §7Voc\u00ea N\u00e3o Tem Permiss\u00e3o Para Usar Este Kit");
            }
        }
        if (args[0].equalsIgnoreCase("DeshFire")) {
            if (p.hasPermission("kit.deshfire")) {
                p.getInventory().clear();
                KitAPI.recraft(p);
                KitAPI.sopa(p);
                KitAPI.sword(p);
                Habilidade.setAbility(p, "DeshFire");
                KitAPI.Kit.add(p.getName());
                KitAPI.DeshFire.add(p.getName());
                p.sendMessage(String.valueOf(Main.prefix) + " §4\u27bc §7Voc\u00ea Selecionou o Kit: §cDeshFire");
                KitAPI.setitem(p, Material.REDSTONE_BLOCK, "§7Kit §cDeshFire", 1, Enchantment.DAMAGE_ALL, 0, false);
                TheTitle.sendTitle(p, "§7§lKIT §4§lDESHFIRE");
                TheTitle.sendSubTitle(p, "§c§lFOI SELECIONADO");
                SetArena.TeleportArenaRandom(p);
            }
            else {
                p.sendMessage(String.valueOf(Main.prefix) + " §4\u27bc §7Voc\u00ea N\u00e3o Tem Permiss\u00e3o Para Usar Este Kit");
            }
        }
        if (args[0].equalsIgnoreCase("fisherman")) {
            if (p.hasPermission("kit.fisherman")) {
                p.getInventory().clear();
                KitAPI.recraft(p);
                KitAPI.sopa(p);
                KitAPI.sword(p);
                Habilidade.setAbility(p, "Fisherman");
                KitAPI.Kit.add(p.getName());
                KitAPI.Fisherman.add(p.getName());
                p.sendMessage(String.valueOf(Main.prefix) + " §4\u27bc §7Voc\u00ea Selecionou o Kit: §cFisherman");
                KitAPI.setitem(p, Material.FISHING_ROD, "§7Kit §cFisherman", 1, Enchantment.DAMAGE_ALL, 0, false);
                TheTitle.sendTitle(p, "§7§lKIT §4§lFISHERMAN");
                TheTitle.sendSubTitle(p, "§c§lFOI SELECIONADO");
                SetArena.TeleportArenaRandom(p);
            }
            else {
                p.sendMessage(String.valueOf(Main.prefix) + " §4\u27bc §7Voc\u00ea N\u00e3o Tem Permiss\u00e3o Para Usar Este Kit");
            }
        }
        if (args[0].equalsIgnoreCase("gladiator")) {
            if (p.hasPermission("kit.gladiator")) {
                p.getInventory().clear();
                KitAPI.recraft(p);
                KitAPI.sopa(p);
                KitAPI.sword(p);
                Habilidade.setAbility(p, "Gladiator");
                KitAPI.Kit.add(p.getName());
                KitAPI.Gladiator.add(p.getName());
                p.sendMessage(String.valueOf(Main.prefix) + " §4\u27bc §7Voc\u00ea Selecionou o Kit: §cGladiator");
                KitAPI.setitem(p, Material.IRON_FENCE, "§7Kit §cGladiator", 1, Enchantment.DAMAGE_ALL, 0, false);
                TheTitle.sendTitle(p, "§7§lKIT §4§lGLADIATOR");
                TheTitle.sendSubTitle(p, "§c§lFOI SELECIONADO");
                SetArena.TeleportArenaRandom(p);
            }
            else {
                p.sendMessage(String.valueOf(Main.prefix) + " §4\u27bc §7Voc\u00ea N\u00e3o Tem Permiss\u00e3o Para Usar Este Kit");
            }
        }
        if (args[0].equalsIgnoreCase("grappler")) {
            if (p.hasPermission("kit.grappler")) {
                p.getInventory().clear();
                KitAPI.recraft(p);
                KitAPI.sopa(p);
                KitAPI.sword(p);
                Habilidade.setAbility(p, "Grappler");
                KitAPI.Kit.add(p.getName());
                KitAPI.Grappler.add(p.getName());
                p.sendMessage(String.valueOf(Main.prefix) + " §4\u27bc §7Voc\u00ea Selecionou o Kit: §cGrappler");
                KitAPI.setitem(p, Material.LEASH, "§7Kit §cGrappler", 1, Enchantment.DAMAGE_ALL, 0, false);
                TheTitle.sendTitle(p, "§7§lKIT §4§lGRAPPLER");
                TheTitle.sendSubTitle(p, "§c§lFOI SELECIONADO");
                SetArena.TeleportArenaRandom(p);
            }
            else {
                p.sendMessage(String.valueOf(Main.prefix) + " §4\u27bc §7Voc\u00ea N\u00e3o Tem Permiss\u00e3o Para Usar Este Kit");
            }
        }
        if (args[0].equalsIgnoreCase("hulk")) {
            if (p.hasPermission("kit.hulk")) {
                p.getInventory().clear();
                KitAPI.recraft(p);
                KitAPI.sopa(p);
                KitAPI.sword(p);
                Habilidade.setAbility(p, "Hulk");
                KitAPI.Kit.add(p.getName());
                KitAPI.Hulk.add(p.getName());
                p.sendMessage(String.valueOf(Main.prefix) + " §4\u27bc §7Voc\u00ea Selecionou o Kit: §cHulk");
                KitAPI.setitem(p, Material.SADDLE, "§7Kit §cHulk", 1, Enchantment.DAMAGE_ALL, 0, false);
                TheTitle.sendTitle(p, "§7§lKIT §4§lHULK");
                TheTitle.sendSubTitle(p, "§c§lFOI SELECIONADO");
                SetArena.TeleportArenaRandom(p);
            }
            else {
                p.sendMessage(String.valueOf(Main.prefix) + " §4\u27bc §7Voc\u00ea N\u00e3o Tem Permiss\u00e3o Para Usar Este Kit");
            }
        }
        if (args[0].equalsIgnoreCase("jellyfish")) {
            if (p.hasPermission("kit.jellyfish")) {
                p.getInventory().clear();
                KitAPI.recraft(p);
                KitAPI.sopa(p);
                KitAPI.sword(p);
                Habilidade.setAbility(p, "JellyFish");
                KitAPI.Kit.add(p.getName());
                KitAPI.JellyFish.add(p.getName());
                p.sendMessage(String.valueOf(Main.prefix) + " §4\u27bc §7Voc\u00ea Selecionou o Kit: §cJellyFish");
                KitAPI.setitem(p, Material.CLAY_BALL, "§7Kit §cJellyFish", 1, Enchantment.DAMAGE_ALL, 0, false);
                TheTitle.sendTitle(p, "§7§lKIT §4§lJELLYFISH");
                TheTitle.sendSubTitle(p, "§c§lFOI SELECIONADO");
                SetArena.TeleportArenaRandom(p);
            }
            else {
                p.sendMessage(String.valueOf(Main.prefix) + " §4\u27bc §7Voc\u00ea N\u00e3o Tem Permiss\u00e3o Para Usar Este Kit");
            }
        }
        if (args[0].equalsIgnoreCase("phantom")) {
            if (p.hasPermission("kit.phantom")) {
                p.getInventory().clear();
                KitAPI.recraft(p);
                KitAPI.sopa(p);
                KitAPI.sword(p);
                Habilidade.setAbility(p, "Phantom");
                KitAPI.Kit.add(p.getName());
                KitAPI.Phantom.add(p.getName());
                p.sendMessage(String.valueOf(Main.prefix) + " §4\u27bc §7Voc\u00ea Selecionou o Kit: §cPhantom");
                KitAPI.setitem(p, Material.FEATHER, "§7Kit §cPhantom", 1, Enchantment.DAMAGE_ALL, 0, false);
                TheTitle.sendTitle(p, "§7§lKIT §4§lPHANTOM");
                TheTitle.sendSubTitle(p, "§c§lFOI SELECIONADO");
                SetArena.TeleportArenaRandom(p);
            }
            else {
                p.sendMessage(String.valueOf(Main.prefix) + " §4\u27bc §7Voc\u00ea N\u00e3o Tem Permiss\u00e3o Para Usar Este Kit");
            }
        }
        if (args[0].equalsIgnoreCase("quickdropper")) {
            if (p.hasPermission("kit.quickdropper")) {
                p.getInventory().clear();
                KitAPI.recraft(p);
                KitAPI.sopa(p);
                KitAPI.sword(p);
                Habilidade.setAbility(p, "QuickDropper");
                KitAPI.Kit.add(p.getName());
                KitAPI.QuickDropper.add(p.getName());
                p.sendMessage(String.valueOf(Main.prefix) + " §4\u27bc §7Voc\u00ea Selecionou o Kit: §cQuickDropper");
                TheTitle.sendTitle(p, "§7§lKIT §4§lQUICKDROPPER");
                TheTitle.sendSubTitle(p, "§c§lFOI SELECIONADO");
                SetArena.TeleportArenaRandom(p);
            }
            else {
                p.sendMessage(String.valueOf(Main.prefix) + " §4\u27bc §7Voc\u00ea N\u00e3o Tem Permiss\u00e3o Para Usar Este Kit");
            }
        }
        if (args[0].equalsIgnoreCase("kangaroo")) {
            if (p.hasPermission("kit.kangaroo")) {
                p.getInventory().clear();
                KitAPI.recraft(p);
                KitAPI.sopa(p);
                KitAPI.sword(p);
                Habilidade.setAbility(p, "Kangaroo");
                KitAPI.Kit.add(p.getName());
                KitAPI.Kangaroo.add(p.getName());
                p.sendMessage(String.valueOf(Main.prefix) + " §4\u27bc §7Voc\u00ea Selecionou o Kit: §cKangaroo");
                KitUtil.darItem(p, Material.FIREWORK, 1, "§7Kit §cKangaroo", 1);
                TheTitle.sendTitle(p, "§7§lKIT §4§lKANGAROO");
                TheTitle.sendSubTitle(p, "§c§lFOI SELECIONADO");
                SetArena.TeleportArenaRandom(p);
            }
            else {
                p.sendMessage(String.valueOf(Main.prefix) + " §4\u27bc §7Voc\u00ea N\u00e3o Tem Permiss\u00e3o Para Usar Este Kit");
            }
        }
        if (args[0].equalsIgnoreCase("magma")) {
            if (p.hasPermission("kit.magma")) {
                p.getInventory().clear();
                KitAPI.recraft(p);
                KitAPI.sopa(p);
                KitAPI.sword(p);
                Habilidade.setAbility(p, "Magma");
                KitAPI.Kit.add(p.getName());
                KitAPI.Magma.add(p.getName());
                p.sendMessage(String.valueOf(Main.prefix) + " §4\u27bc §7Voc\u00ea Selecionou o Kit: §cMagma");
                TheTitle.sendTitle(p, "§7§lKIT §4§lMAGMA");
                TheTitle.sendSubTitle(p, "§c§lFOI SELECIONADO");
                SetArena.TeleportArenaRandom(p);
            }
            else {
                p.sendMessage(String.valueOf(Main.prefix) + " §4\u27bc §7Voc\u00ea N\u00e3o Tem Permiss\u00e3o Para Usar Este Kit");
            }
        }
        if (args[0].equalsIgnoreCase("monk")) {
            if (p.hasPermission("kit.monk")) {
                p.getInventory().clear();
                KitAPI.recraft(p);
                KitAPI.sopa(p);
                KitAPI.sword(p);
                Habilidade.setAbility(p, "Monk");
                KitAPI.Kit.add(p.getName());
                KitAPI.Monk.add(p.getName());
                p.sendMessage(String.valueOf(Main.prefix) + " §4\u27bc §7Voc\u00ea Selecionou o Kit: §cMonk");
                KitAPI.setitem(p, Material.BLAZE_ROD, "§7Kit §cMonk", 1, Enchantment.DAMAGE_ALL, 0, false);
                TheTitle.sendTitle(p, "§7§lKIT §4§lMONK");
                TheTitle.sendSubTitle(p, "§c§lFOI SELECIONADO");
                SetArena.TeleportArenaRandom(p);
            }
            else {
                p.sendMessage(String.valueOf(Main.prefix) + " §4\u27bc §7Voc\u00ea N\u00e3o Tem Permiss\u00e3o Para Usar Este Kit");
            }
        }
        if (args[0].equalsIgnoreCase("ninja")) {
            if (p.hasPermission("kit.ninja")) {
                p.getInventory().clear();
                KitAPI.recraft(p);
                KitAPI.sopa(p);
                KitAPI.sword(p);
                Habilidade.setAbility(p, "Ninja");
                KitAPI.Kit.add(p.getName());
                KitAPI.Ninja.add(p.getName());
                p.sendMessage(String.valueOf(Main.prefix) + " §4\u27bc §7Voc\u00ea Selecionou o Kit: §cNinja");
                TheTitle.sendTitle(p, "§7§lKIT §4§lNINJA");
                TheTitle.sendSubTitle(p, "§c§lFOI SELECIONADO");
                SetArena.TeleportArenaRandom(p);
            }
            else {
                p.sendMessage(String.valueOf(Main.prefix) + " §4\u27bc §7Voc\u00ea N\u00e3o Tem Permiss\u00e3o Para Usar Este Kit");
            }
        }
        if (args[0].equalsIgnoreCase("poseidon")) {
            if (p.hasPermission("kit.poseidon")) {
                p.getInventory().clear();
                KitAPI.recraft(p);
                KitAPI.sopa(p);
                KitAPI.sword(p);
                Habilidade.setAbility(p, "Poseidon");
                KitAPI.Kit.add(p.getName());
                KitAPI.Poseidon.add(p.getName());
                p.sendMessage(String.valueOf(Main.prefix) + " §4\u27bc §7Voc\u00ea Selecionou o Kit: §cPoseidon");
                TheTitle.sendTitle(p, "§7§lKIT §4§lPOSEIDON");
                TheTitle.sendSubTitle(p, "§c§lFOI SELECIONADO");
                SetArena.TeleportArenaRandom(p);
            }
            else {
                p.sendMessage(String.valueOf(Main.prefix) + " §4\u27bc §7Voc\u00ea N\u00e3o Tem Permiss\u00e3o Para Usar Este Kit");
            }
        }
        if (args[0].equalsIgnoreCase("resouper")) {
            if (p.hasPermission("kit.resouper")) {
                p.getInventory().clear();
                KitAPI.recraft(p);
                KitAPI.sopa(p);
                KitAPI.sword(p);
                Habilidade.setAbility(p, "Resouper");
                KitAPI.Kit.add(p.getName());
                KitAPI.Resouper.add(p.getName());
                p.sendMessage(String.valueOf(Main.prefix) + " §4\u27bc §7Voc\u00ea Selecionou o Kit: §cResouper");
                TheTitle.sendTitle(p, "§7§lKIT §4§lRESOUPER");
                TheTitle.sendSubTitle(p, "§c§lFOI SELECIONADO");
                SetArena.TeleportArenaRandom(p);
            }
            else {
                p.sendMessage(String.valueOf(Main.prefix) + " §4\u27bc §7Voc\u00ea N\u00e3o Tem Permiss\u00e3o Para Usar Este Kit");
            }
        }
        if (args[0].equalsIgnoreCase("snail")) {
            if (p.hasPermission("kit.snai\u00e7")) {
                p.getInventory().clear();
                KitAPI.recraft(p);
                KitAPI.sopa(p);
                KitAPI.sword(p);
                Habilidade.setAbility(p, "Snai\u00e7");
                KitAPI.Kit.add(p.getName());
                KitAPI.Snail.add(p.getName());
                p.sendMessage(String.valueOf(Main.prefix) + " §4\u27bc §7Voc\u00ea Selecionou o Kit: §cSnail");
                TheTitle.sendTitle(p, "§7§lKIT §4§lSNAIL");
                TheTitle.sendSubTitle(p, "§c§lFOI SELECIONADO");
                SetArena.TeleportArenaRandom(p);
            }
            else {
                p.sendMessage(String.valueOf(Main.prefix) + " §4\u27bc §7Voc\u00ea N\u00e3o Tem Permiss\u00e3o Para Usar Este Kit");
            }
        }
        if (args[0].equalsIgnoreCase("sonic")) {
            if (p.hasPermission("kit.sonic")) {
                p.getInventory().clear();
                KitAPI.recraft(p);
                KitAPI.sopa(p);
                KitAPI.sword(p);
                Habilidade.setAbility(p, "Sonic");
                KitAPI.Kit.add(p.getName());
                KitAPI.Sonic.add(p.getName());
                p.sendMessage(String.valueOf(Main.prefix) + " §4\u27bc §7Voc\u00ea Selecionou o Kit: §cSonic");
                KitAPI.setitem(p, Material.LAPIS_BLOCK, "§7Kit §cSonic", 1, Enchantment.DAMAGE_ALL, 0, false);
                TheTitle.sendTitle(p, "§7§lKIT §4§lSONIC");
                TheTitle.sendSubTitle(p, "§c§lFOI SELECIONADO");
                SetArena.TeleportArenaRandom(p);
            }
            else {
                p.sendMessage(String.valueOf(Main.prefix) + " §4\u27bc §7Voc\u00ea N\u00e3o Tem Permiss\u00e3o Para Usar Este Kit");
            }
        }
        if (args[0].equalsIgnoreCase("archer")) {
            if (p.hasPermission("kit.archer")) {
                p.getInventory().clear();
                KitAPI.recraft(p);
                KitAPI.sopa(p);
                KitAPI.sword(p);
                Habilidade.setAbility(p, "Archer");
                KitAPI.Kit.add(p.getName());
                KitAPI.Archer.add(p.getName());
                p.sendMessage(String.valueOf(Main.prefix) + " §4\u27bc §7Voc\u00ea Selecionou o Kit: §cArcher");
                KitAPI.setitem(p, Material.BOW, "§7Kit §cArcher", 1, Enchantment.ARROW_INFINITE, 1, false);
                KitAPI.setitem(p, Material.ARROW, "§cArrrow", 2, Enchantment.DAMAGE_ALL, 1, false);
                TheTitle.sendTitle(p, "§7§lKIT §4§lARCHER");
                TheTitle.sendSubTitle(p, "§c§lFOI SELECIONADO");
                SetArena.TeleportArenaRandom(p);
            }
            else {
                p.sendMessage(String.valueOf(Main.prefix) + " §4\u27bc §7Voc\u00ea N\u00e3o Tem Permiss\u00e3o Para Usar Este Kit");
            }
        }
        if (args[0].equalsIgnoreCase("stomper")) {
            if (p.hasPermission("kit.stomper")) {
                p.getInventory().clear();
                KitAPI.recraft(p);
                KitAPI.sopa(p);
                KitAPI.sword(p);
                Habilidade.setAbility(p, "Stomper");
                KitAPI.Kit.add(p.getName());
                KitAPI.Stomper.add(p.getName());
                p.sendMessage(String.valueOf(Main.prefix) + " §4\u27bc §7Voc\u00ea Selecionou o Kit: §cStomper");
                TheTitle.sendTitle(p, "§7§lKIT §4§lSTOMPER");
                TheTitle.sendSubTitle(p, "§c§lFOI SELECIONADO");
                SetArena.TeleportArenaRandom(p);
            }
            else {
                p.sendMessage(String.valueOf(Main.prefix) + " §4\u27bc §7Voc\u00ea N\u00e3o Tem Permiss\u00e3o Para Usar Este Kit");
            }
        }
        if (args[0].equalsIgnoreCase("switcher")) {
            if (p.hasPermission("kit.switcher")) {
                p.getInventory().clear();
                KitAPI.recraft(p);
                KitAPI.sopa(p);
                KitAPI.sword(p);
                Habilidade.setAbility(p, "Switcher");
                KitAPI.Kit.add(p.getName());
                KitAPI.Switcher.add(p.getName());
                KitUtil.darItem(p, Material.SNOW_BALL, 32, "§7Kit §cSwitcher", 1);
                p.sendMessage(String.valueOf(Main.prefix) + " §4\u27bc §7Voc\u00ea Selecionou o Kit: §cSwicther");
                TheTitle.sendTitle(p, "§7§lKIT §4§lSWITCHER");
                TheTitle.sendSubTitle(p, "§c§lFOI SELECIONADO");
                SetArena.TeleportArenaRandom(p);
            }
            else {
                p.sendMessage(String.valueOf(Main.prefix) + " §4\u27bc §7Voc\u00ea N\u00e3o Tem Permiss\u00e3o Para Usar Este Kit");
            }
        }
        if (args[0].equalsIgnoreCase("swords")) {
            if (p.hasPermission("kit.swords")) {
                p.getInventory().clear();
                KitAPI.recraft(p);
                KitAPI.sopa(p);
                KitAPI.sword(p);
                Habilidade.setAbility(p, "Swords");
                KitAPI.Kit.add(p.getName());
                KitAPI.Swords.add(p.getName());
                p.sendMessage(String.valueOf(Main.prefix) + " §4\u27bc §7Voc\u00ea Selecionou o Kit: §cSwords");
                TheTitle.sendTitle(p, "§7§lKIT §4§lSWORDS");
                TheTitle.sendSubTitle(p, "§c§lFOI SELECIONADO");
                SetArena.TeleportArenaRandom(p);
            }
            else {
                p.sendMessage(String.valueOf(Main.prefix) + " §4\u27bc §7Voc\u00ea N\u00e3o Tem Permiss\u00e3o Para Usar Este Kit");
            }
        }
        if (args[0].equalsIgnoreCase("terrorista")) {
            if (p.hasPermission("kit.terrorista")) {
                p.getInventory().clear();
                KitAPI.recraft(p);
                KitAPI.sopa(p);
                KitAPI.sword(p);
                Habilidade.setAbility(p, "Terrorista");
                KitAPI.Kit.add(p.getName());
                KitAPI.Terrorista.add(p.getName());
                p.sendMessage(String.valueOf(Main.prefix) + " §4\u27bc §7Voc\u00ea Selecionou o Kit: §cTerrorista");
                KitAPI.setitem(p, Material.MAGMA_CREAM, "§7Kit §cTerrorista", 1, Enchantment.DAMAGE_ALL, 0, false);
                TheTitle.sendTitle(p, "§7§lKIT §4§lTERRORISTA");
                TheTitle.sendSubTitle(p, "§c§lFOI SELECIONADO");
                SetArena.TeleportArenaRandom(p);
            }
            else {
                p.sendMessage(String.valueOf(Main.prefix) + " §4\u27bc §7Voc\u00ea N\u00e3o Tem Permiss\u00e3o Para Usar Este Kit");
            }
        }
        if (args[0].equalsIgnoreCase("forcefield")) {
            if (p.hasPermission("kit.forcefield")) {
                p.getInventory().clear();
                KitAPI.recraft(p);
                KitAPI.sopa(p);
                KitAPI.sword(p);
                Habilidade.setAbility(p, "ForceField");
                KitAPI.Kit.add(p.getName());
                KitAPI.ForceField.add(p.getName());
                p.sendMessage(String.valueOf(Main.prefix) + " §4\u27bc §7Voc\u00ea Selecionou o Kit: §cForceField");
                KitAPI.setitem(p, Material.NETHER_FENCE, "§7Kit §cForceField", 1, Enchantment.DAMAGE_ALL, 0, false);
                TheTitle.sendTitle(p, "§7§lKIT §4§lFORCEFIELD");
                TheTitle.sendSubTitle(p, "§c§lFOI SELECIONADO");
                SetArena.TeleportArenaRandom(p);
            }
            else {
                p.sendMessage(String.valueOf(Main.prefix) + " §4\u27bc §7Voc\u00ea N\u00e3o Tem Permiss\u00e3o Para Usar Este Kit");
            }
        }
        if (args[0].equalsIgnoreCase("thor")) {
            if (p.hasPermission("kit.thor")) {
                p.getInventory().clear();
                KitAPI.recraft(p);
                KitAPI.sopa(p);
                KitAPI.sword(p);
                Habilidade.setAbility(p, "Thor");
                KitAPI.Kit.add(p.getName());
                KitAPI.Thor.add(p.getName());
                p.sendMessage(String.valueOf(Main.prefix) + " §4\u27bc §7Voc\u00ea Selecionou o Kit: §cThor");
                KitAPI.setitem(p, Material.GOLD_AXE, "§7Kit §cThor", 1, Enchantment.DAMAGE_ALL, 0, false);
                TheTitle.sendTitle(p, "§7§lKIT §4§lTHOR");
                TheTitle.sendSubTitle(p, "§c§lFOI SELECIONADO");
                SetArena.TeleportArenaRandom(p);
            }
            else {
                p.sendMessage(String.valueOf(Main.prefix) + " §4\u27bc §7Voc\u00ea N\u00e3o Tem Permiss\u00e3o Para Usar Este Kit");
            }
        }
        if (args[0].equalsIgnoreCase("thresh")) {
            if (p.hasPermission("kit.thresh")) {
                p.getInventory().clear();
                KitAPI.recraft(p);
                KitAPI.sopa(p);
                KitAPI.sword(p);
                Habilidade.setAbility(p, "Thresh");
                KitAPI.Kit.add(p.getName());
                KitAPI.Thresh.add(p.getName());
                p.sendMessage(String.valueOf(Main.prefix) + " §4\u27bc §7Voc\u00ea Selecionou o Kit: §cThresh");
                KitAPI.setitem(p, Material.LEVER, "§7Kit §cThresh", 1, Enchantment.DAMAGE_ALL, 0, false);
                TheTitle.sendTitle(p, "§7§lKIT §4§lTHRESH");
                TheTitle.sendSubTitle(p, "§c§lFOI SELECIONADO");
                SetArena.TeleportArenaRandom(p);
            }
            else {
                p.sendMessage(String.valueOf(Main.prefix) + " §4\u27bc §7Voc\u00ea N\u00e3o Tem Permiss\u00e3o Para Usar Este Kit");
            }
        }
        if (args[0].equalsIgnoreCase("turtle")) {
            if (p.hasPermission("kit.turtle")) {
                p.getInventory().clear();
                KitAPI.recraft(p);
                KitAPI.sopa(p);
                KitAPI.sword(p);
                Habilidade.setAbility(p, "Turtle");
                KitAPI.Kit.add(p.getName());
                KitAPI.Turtle.add(p.getName());
                p.sendMessage(String.valueOf(Main.prefix) + " §4\u27bc §7Voc\u00ea Selecionou o Kit: §cTurtle");
                TheTitle.sendTitle(p, "§7§lKIT §4§lTURTLE");
                TheTitle.sendSubTitle(p, "§c§lFOI SELECIONADO");
                SetArena.TeleportArenaRandom(p);
            }
            else {
                p.sendMessage(String.valueOf(Main.prefix) + " §4\u27bc §7Voc\u00ea N\u00e3o Tem Permiss\u00e3o Para Usar Este Kit");
            }
        }
        if (args[0].equalsIgnoreCase("viper")) {
            if (p.hasPermission("kit.viper")) {
                p.getInventory().clear();
                KitAPI.recraft(p);
                KitAPI.sopa(p);
                KitAPI.sword(p);
                Habilidade.setAbility(p, "Viper");
                KitAPI.Kit.add(p.getName());
                KitAPI.Viper.add(p.getName());
                p.sendMessage(String.valueOf(Main.prefix) + " §4\u27bc §7Voc\u00ea Selecionou o Kit: §cViper");
                TheTitle.sendTitle(p, "§7§lKIT §4§lVIPER");
                TheTitle.sendSubTitle(p, "§c§lFOI SELECIONADO");
                SetArena.TeleportArenaRandom(p);
            }
            else {
                p.sendMessage(String.valueOf(Main.prefix) + " §4\u27bc §7Voc\u00ea N\u00e3o Tem Permiss\u00e3o Para Usar Este Kit");
            }
        }
        if (args[0].equalsIgnoreCase("viking")) {
            if (p.hasPermission("kit.Viking")) {
                p.getInventory().clear();
                KitAPI.recraft(p);
                KitAPI.sopa(p);
                KitUtil.darItem(p, Material.STONE_AXE, 1, "§7Kit §cViking", 0);
                Habilidade.setAbility(p, "Viking");
                KitAPI.Kit.add(p.getName());
                KitAPI.Viking.add(p.getName());
                p.sendMessage(String.valueOf(Main.prefix) + " §4\u27bc §7Voc\u00ea Selecionou o Kit: §cViking");
                TheTitle.sendTitle(p, "§7§lKIT §4§lVIKING");
                TheTitle.sendSubTitle(p, "§c§lFOI SELECIONADO");
                SetArena.TeleportArenaRandom(p);
            }
            else {
                p.sendMessage(String.valueOf(Main.prefix) + " §4\u27bc §7Voc\u00ea N\u00e3o Tem Permiss\u00e3o Para Usar Este Kit");
            }
        }
        return false;
    }
}
