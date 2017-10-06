package fr.MrJeje_.CustomMOTD;

import org.bukkit.event.Listener;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public class CustomMOTD extends JavaPlugin implements Listener {
	
	public void onEnable(){
		
		System.out.println("[CustomMOTD] Enable! (by MrJeje_)");
		
		getConfig().options().copyDefaults(true); //chargement de la config par defaut
		saveConfig();
		
		getCommand("CustomMOTD").setExecutor(new LesCommandes(this)); //creer la commande avec sa classe 
		getCommand("cmotd").setExecutor(new LesCommandes(this));
		
		PluginManager pm = getServer().getPluginManager(); //Indique qu'il existe d'autres classes a action
		pm.registerEvents(new Join(this), this);
	}
	
	public void onDisable(){
		System.out.println("[CustomMOTD] Disable! (by MrJeje_)");
	}

}