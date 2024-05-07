package dk.sdu.mmmi.enemy.common.services;

import dk.sdu.mmmi.enemy.common.data.GameData;
import dk.sdu.mmmi.enemy.common.data.World;

public interface IGamePluginService {

    /**
     *
     * @param gameData
     * @param world
     * Pre-conditions:
     * - The 'gameData'  must not be null.
     * - The 'world'  must not be null.
     *
     * Post-conditions:
     * - The game plugin started based on the given game data and world.
     */
    

    void start(GameData gameData, World world);

    void stop(GameData gameData, World world);
}
