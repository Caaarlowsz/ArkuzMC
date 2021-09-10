package Comandos;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;

public class Permissionlist implements CommandExecutor, Listener {
	public boolean onCommand(final CommandSender sender, final Command cmd, final String label, final String[] args) {
		final Player p = (Player) sender;
		if (p.hasPermission("arkuz.permissionslist") && cmd.getName().equalsIgnoreCase("permissionslist")
				&& args.length == 0) {
			p.sendMessage("§eExibindo lista de permiss\u00f5es:");
			p.sendMessage("§e");
			p.sendMessage("§7\u25b8 Admin - Permiss\u00e3o ao Modo Administrador");
			p.sendMessage("§7\u25b8 staffchat - Permiss\u00e3o ao StaffChat");
			p.sendMessage("§7\u25b8 fullkit - Permiss\u00e3o ao FullKit (Todos os kits)");
			p.sendMessage("§7\u25b8 teleportar - Permiss\u00e3o para Usar o /tp , tphere e /tpall");
			p.sendMessage("§7\u25b8 givevips - Permiss\u00e3o para dar Vips");
			p.sendMessage("§7\u25b8 givekit - Permiss\u00e3o para Dar Kits");
			p.sendMessage("§7\u25b8 sortearkit - Permiss\u00e3o para Sortear Kits (/sortearkit)");
			p.sendMessage("§7\u25b8 sortearvip - Permiss\u00e3o para Sortear Vips (/sortearvip)");
			p.sendMessage("§7");
			p.sendMessage(
					"§c[OBSERVA\u00c7\u00c3O] Essas permiss\u00f5es devem ser usadas no /givepermission ou /removepermission, Exemplo:");
			p.sendMessage("§7\u25b8 /givepermission Tester Admin");
			p.sendMessage("§cDar\u00e1 ao jogador 'Tester' a Permiss\u00e3o do /admin (Modo Administrador)");
			p.sendMessage(
					"§4[AVISO] O USO INAPROPRIADO, DE M\ufffd? F\u00c9, E ABUSIVO DESTES COMANDOS PODEM CAUSAR PERDA PERMANENTE DO SEU CARGO!");
			return true;
		}
		return false;
	}
}
