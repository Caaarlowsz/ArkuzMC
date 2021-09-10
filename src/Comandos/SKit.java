package Comandos;

import java.util.HashMap;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.inventory.ItemStack;

import Main.Main;

public class SKit implements Listener, CommandExecutor {
	public HashMap<String, ItemStack[]> itens;
	public HashMap<String, ItemStack[]> armor;

	public SKit(final Main main) {
		this.itens = new HashMap<String, ItemStack[]>();
		this.armor = new HashMap<String, ItemStack[]>();
	}

	public boolean isInt(final String s) {
		try {
			Integer.parseInt(s);
			return true;
		} catch (NumberFormatException ex) {
			return false;
		}
	}

	public boolean onCommand(final CommandSender Sender, final Command Cmd, final String Label, final String[] Args) {
		final Player p = (Player) Sender;
		if (Label.equalsIgnoreCase("skit") && Sender instanceof Player) {
			if (!p.hasPermission("arkuz.skit")) {
				p.sendMessage(String.valueOf(Main.prefix) + " §6» §7Sem Permiss\u00e3o");
				return true;
			}
			if (Args.length == 0) {
				p.sendMessage("       ");
				p.sendMessage("§6§m--------------------------------------------");
				p.sendMessage("                " + Main.prefix);
				p.sendMessage("      §4\u27bc §7Mini Tutorial De Como Usar o /SKit  ");
				p.sendMessage("");
				p.sendMessage(String.valueOf(Main.prefix) + " §4\u27bc §7Utilize /SKit Criar [Kit] [Blocos]");
				p.sendMessage(String.valueOf(Main.prefix) + " §4\u27bc §7Utilize /SKit Aplicar [Kit] [Blocos]");
				p.sendMessage("§6§m--------------------------------------------");
				p.sendMessage("       ");
				return true;
			}
			if (Args[0].equalsIgnoreCase("criar")) {
				if (Args.length == 1) {
					p.sendMessage(String.valueOf(Main.prefix) + " §4\u27bc §7Use: /SKit Para Ver o MiniTutorial");
					return true;
				}
				final String nome = Args[1];
				this.itens.put(nome, p.getInventory().getContents());
				this.armor.put(nome, p.getInventory().getArmorContents());
				p.sendMessage(String.valueOf(Main.prefix) + " §4\u27bc §7O Kit: §c" + Args[1] + " §7Foi Criado");
				return true;
			} else if (Args[0].equalsIgnoreCase("aplicar")) {
				if (Args.length <= 2) {
					p.sendMessage(String.valueOf(Main.prefix) + " §4\u27bc §7Utlize /SKit Para Ver o MiniTutorial");
					return true;
				}
				final String nome = Args[1];
				if (!this.itens.containsKey(nome) && !this.armor.containsKey(nome)) {
					p.sendMessage(String.valueOf(Main.prefix) + " §4\u27bc §7O Kit §c" + nome + " §7N\u00e3o Existe");
					return true;
				}
				if (this.isInt(Args[2])) {
					final int n = Integer.parseInt(Args[2]);
					for (final Entity e : p.getNearbyEntities((double) n, (double) n, (double) n)) {
						if (e instanceof Player) {
							final Player p2 = (Player) e;
							p2.getInventory().setArmorContents((ItemStack[]) this.armor.get(nome));
							p2.getInventory().setContents((ItemStack[]) this.itens.get(nome));
						}
					}
					Bukkit.getServer().broadcastMessage("");
					Bukkit.getServer().broadcastMessage(String.valueOf(Main.prefix) + " §4\u27bc §7O Kit §c" + nome
							+ " §7Foi Aplicado Em Um Raio De §c" + n + " §7Blocos");
					Bukkit.getServer().broadcastMessage("");
					p.sendMessage(String.valueOf(Main.prefix) + " §4\u27bc §7Voc\u00ea Aplicou o Kit §c" + nome
							+ " §7Em Um Raio De §c" + n + " §7Blocos");
					return true;
				}
			}
		}
		return false;
	}
}
