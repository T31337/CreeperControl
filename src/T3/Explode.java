package T3;

import org.bukkit.entity.EntityType;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityExplodeEvent;

public class Explode implements Listener 
{	
		CreeperControl plugin;

	@EventHandler
	public void onEntityExplode(EntityExplodeEvent event)
	{
	

		//This Event Only Gets Registered And Listened For If Player Set CreeperGreif To false In Configuration File
		if(event.getEntityType()==EntityType.CREEPER)
		{	
			if(CreeperControl.CreeperGreif==false)
			{
				event.setYield(0.00F);
				event.blockList().clear();
			}		
		}	
	}
}
