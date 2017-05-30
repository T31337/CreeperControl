package T3;

import java.util.logging.Logger;

import org.bukkit.Bukkit;
import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public class CreeperControl extends JavaPlugin
{
	CreeperControl plugin;
	
	public static boolean CreeperGreif=false;
	public boolean FriendlyCreeper=true;
	
	Logger log =  Bukkit.getLogger();
	PluginDescriptionFile pd = this.getDescription();	
	PluginManager pm = Bukkit.getServer().getPluginManager();
	Cfg cfg;
	CfgMgr cfgmgr;
	@Override
	public void onEnable()
	{
		plugin=this;
		pm.registerEvents(new Explode(), this);
		this.getCommand("creeper").setExecutor(new CreeperCmd(this));
		log.info(pd.getName()+" Version: "+pd.getVersion()+" Enabled!");
		cfgmgr = new CfgMgr(this);
		cfg = cfgmgr.getNewConfig("cfg.yml", new String[]
				{"CreeperControl Configuration File","-=- CreeperGreif true - Creepers Can Greif","CreeperGreif Should Be Either true Or false"});
		cfg.saveConfig();
		
		if(!cfg.contains("CreeperGreif"))
		{
			cfg.createSection("CreeperGreif");
			cfg.set("CreeperGreif", false);
			cfg.saveConfig();
		}
		else
		{
			CreeperGreif = cfg.getBoolean("CreeperGreif",true);
		}
	}
	
	@Override
	public void onDisable()
	{
		Bukkit.getServer().clearRecipes();
		Bukkit.getPluginManager().disablePlugin(this);
		log.info(pd.getName()+" Version: "+pd.getVersion()+" Disabled :(");
		plugin = null;
	}
}
