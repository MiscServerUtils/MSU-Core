package big_xplosion.msu.core.helper;

import org.spongepowered.api.Game;
import org.spongepowered.api.command.spec.CommandSpec;

public class RegistryHelper {

	private Object plugin;
	private Game game;

	private RegistryHelper(Object plugin, Game game) {
		this.plugin = plugin;
		this.game = game;
	}

	public static RegistryHelper createRegistryHelper(Object plugin, Game game) {
		return new RegistryHelper(plugin, game);
	}

	public void registerCommand(CommandSpec command, String... names) {
		game.getCommandManager().register(plugin, command, names);
	}

	public void registerEventListener(Object eventListenerClass) {
		game.getEventManager().registerListeners(this, eventListenerClass);
	}
}
