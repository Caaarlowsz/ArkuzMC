package Comandos;

import com.github.caaarlowsz.arkuzmc.kitpvp.ArkuzKitPvP;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;

public class Ajuda implements Listener, CommandExecutor {
	public boolean onCommand(final CommandSender sender, final Command cmd, final String label, final String[] args) {
		final Player p = (Player) sender;
		cmd.getName().equalsIgnoreCase("ajuda");
		p.sendMessage(" ");
		p.sendMessage("§a*Ola, Bem-Vindo a ferramente de §aAjuda§7 do: " + ArkuzKitPvP.prefix);
		p.sendMessage(" ");
		p.sendMessage("§b* §7Deseja tornar-se §bYoutuber§7? Utilize o comando: §b/youtuber§7.");
		p.sendMessage(" ");
		p.sendMessage("§c*§7 Deseja Aplicar-se na staff? Utilize o comando §c/aplicar§7.");
		p.sendMessage(" ");
		p.sendMessage("§6*§7 Caso encontre algum §4HACK §7reporte-o no §6/report [NICK] [MOTIVO].");
		p.sendMessage(" ");
		p.sendMessage("§9*§7 Olhe as §cREGRAS §7 usando o comando §9/regras.");
		return false;
	}
}
