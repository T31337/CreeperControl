package T3;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Creeper;
import org.bukkit.entity.Player;

public class CreeperCmd implements CommandExecutor
{
   CreeperControl plugin;
   public CreeperCmd(CreeperControl plugin)
   {
	   this.plugin = plugin;
   }
	public boolean onCommand(CommandSender sender, Command cmd, String cmdName, String[] args)
	{
		if(args.length!=0)
		{
			sender.sendMessage("Usage: /Creeper");
			return true;
		}
		else
		{
			if(sender instanceof Player)
			{
				Player p = (Player)sender;
				p.getWorld().spawn(p.getEyeLocation().add((p.getLocation().getDirection().getZ()-5), 0, 0), Creeper.class);
				p.sendMessage("Creeper Spawned, Watch Out!");//Not Always Infront Of Player - Not Sure Why...
				return true;
			}
			else
			{
				sender.sendMessage("Sorry, Only Players May Spawn Creepers...");
				return true;
			}
		}
	}

}
