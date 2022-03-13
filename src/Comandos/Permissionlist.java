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
			p.sendMessage("§eExibindo lista de permissões:");
			p.sendMessage("§e");
			p.sendMessage("§7\u25b8 Admin - Permissão ao Modo Administrador");
			p.sendMessage("§7\u25b8 staffchat - Permissão ao StaffChat");
			p.sendMessage("§7\u25b8 fullkit - Permissão ao FullKit (Todos os kits)");
			p.sendMessage("§7\u25b8 teleportar - Permissão para Usar o /tp , tphere e /tpall");
			p.sendMessage("§7\u25b8 givevips - Permissão para dar Vips");
			p.sendMessage("§7\u25b8 givekit - Permissão para Dar Kits");
			p.sendMessage("§7\u25b8 sortearkit - Permissão para Sortear Kits (/sortearkit)");
			p.sendMessage("§7\u25b8 sortearvip - Permissão para Sortear Vips (/sortearvip)");
			p.sendMessage("§7");
			p.sendMessage(
					"§c[OBSERVAÇÃO] Essas permissões devem ser usadas no /givepermission ou /removepermission, Exemplo:");
			p.sendMessage("§7\u25b8 /givepermission Tester Admin");
			p.sendMessage("§cDará ao jogador 'Tester' a Permissão do /admin (Modo Administrador)");
			p.sendMessage(
					"§4[AVISO] O USO INAPROPRIADO, DE MÁ FÉ, E ABUSIVO DESTES COMANDOS PODEM CAUSAR PERDA PERMANENTE DO SEU CARGO!");
			return true;
		}
		return false;
	}
}
