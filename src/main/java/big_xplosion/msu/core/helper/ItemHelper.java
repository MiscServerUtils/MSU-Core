package big_xplosion.msu.core.helper;

import big_xplosion.msu.core.MSUCore;
import org.spongepowered.api.data.key.Keys;
import org.spongepowered.api.entity.Entity;
import org.spongepowered.api.entity.EntityTypes;
import org.spongepowered.api.entity.Item;
import org.spongepowered.api.entity.living.player.Player;
import org.spongepowered.api.event.cause.Cause;
import org.spongepowered.api.item.inventory.ItemStack;
import org.spongepowered.api.world.Location;
import org.spongepowered.api.world.World;

import java.util.Optional;

public class ItemHelper {

	public static void dropItemOnPlayer(ItemStack item, Player player) {
		dropItemOnEntity(item, player);
	}

	public static void dropItemOnEntity(ItemStack item, Entity entity) {
		Location<World> loc = entity.getLocation();
		Optional<Entity> optEntity = loc.getExtent().createEntity(EntityTypes.ITEM, loc.getPosition());

		if (optEntity.isPresent()) {
			Item itemEntity = (Item) optEntity.get();
			itemEntity.offer(Keys.REPRESENTED_ITEM, item.createSnapshot());
			loc.getExtent().spawnEntity(itemEntity, Cause.of(entity));
		}
	}

	public static ItemStack.Builder createItemStackBuilder() {
		return MSUCore.getPlugin().getGame().getRegistry().createBuilder(ItemStack.Builder.class);
	}
}
