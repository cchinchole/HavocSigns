package havoc.havocsigns;

import org.bukkit.Bukkit;
import org.bukkit.Server;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.SignChangeEvent;

public class SIGNListener implements Listener{

	private Server server = havocsigns.server;

@SuppressWarnings("deprecation")
@EventHandler
public void onSignCreate(SignChangeEvent sign){
	Player player = sign.getPlayer();
	if (sign.getLine(0).equalsIgnoreCase("<killme>")){
		if (player.hasPermission("signs.killme") || Bukkit.getServer().getPlayer(player.getName()).isOp()){
		player.sendMessage("LOLZ ok well bye :)");
		//player.damage(10);
		server.dispatchCommand(server.getConsoleSender(), "kill "+ player.getName());
		sign.setLine(0, player.getName());
		sign.setLine(1, "has been killed.");
		}
		else
		{
			sign.setLine(0, "Sorry cant use");
			sign.setLine(1, "this command");
		}
	}
	
	if (sign.getLine(0).equalsIgnoreCase("<vanish>")){
		if (player.hasPermission("signs.vanish") || Bukkit.getServer().getPlayer(player.getName()).isOp()){
		player.sendMessage("You hide in an unseeable fog...");
		//player.damage(10);
		//getServer().dispatchCommand(getServer().getConsoleSender(), "kill "+ player.getName());
		player.hidePlayer(player);
		sign.setLine(0, player.getName());
		sign.setLine(1, "is hiding form you");
		}
		else
		{
			sign.setLine(0, "Sorry cant use");
			sign.setLine(1, "this command");
		}
	}
}


}
