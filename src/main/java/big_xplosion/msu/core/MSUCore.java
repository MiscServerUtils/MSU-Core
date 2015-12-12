package big_xplosion.msu.core;

import big_xplosion.msu.core.helper.RegistryHelper;
import big_xplosion.msu.core.lib.Constants;
import org.spongepowered.api.Game;
import org.spongepowered.api.event.Listener;
import org.spongepowered.api.event.game.state.GamePreInitializationEvent;
import org.spongepowered.api.plugin.Plugin;

@Plugin(id = Constants.PLUGIN_ID, name = Constants.PLUGIN_NAME, version = Constants.PLUGIN_VERSION)
public class MSUCore {

	private static MSUCore plugin;
	private static Game game;

	public static RegistryHelper registry = RegistryHelper.createRegistryHelper(plugin, game);

	@Listener
	public void preInit(GamePreInitializationEvent event) {
		plugin = this;
		game = event.getGame();
	}

	public static MSUCore getPlugin() {
		return plugin;
	}

	public Game getGame() {
		return game;
	}

}
