package concreteguy.guncollection.procedures;

import concreteguy.guncollection.network.GCVariables;
import net.minecraft.world.entity.Entity;

public class NVGkeyOnKeyPressedProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		{
			boolean _setval = true;
			entity.getCapability(GCVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
				capability.nvg_1 = _setval;
				capability.syncPlayerVariables(entity);
			});
		}
	}
}
