package havoc.havocsigns;

import org.bukkit.Bukkit;
import org.bukkit.Server;
import org.bukkit.event.Listener;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

public class havocsigns extends JavaPlugin {

	
	private static Plugin plugin;
	public static Server server;
	 
	@Override
	public void onEnable() {
	server = getServer();
	registerEvents(this, new SIGNListener());
	plugin = this;
	//This is where we register our events/commands
	}
	 
	public void onDisable() {
	plugin = null;//To stop memory leeks
	 
	}
	 
	 
	//Much eaisier then registering events in 10 diffirent methods
	public static void registerEvents(org.bukkit.plugin.Plugin plugin, Listener... listeners) {
	for (Listener listener : listeners) {
	Bukkit.getServer().getPluginManager().registerEvents(listener, plugin);
	}
	}
	
	
	 
	//To access the plugin variable from other classes
	public static Plugin getPlugin() {
	return plugin;
	}
	

	
}
