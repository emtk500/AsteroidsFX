package dk.sdu.mmmi.enemy.common.services;

import dk.sdu.mmmi.enemy.common.data.GameData;
import dk.sdu.mmmi.enemy.common.data.World;

public interface IEntityProcessingService {

    /**
     *
     *
     *
     * @param gameData
     * @param world
     * @throws Exception
     *
     * Pre-conditions:
     * - The 'gameData'  must not be null.
     * - The 'world'  must not be null.
     *
     * Post-conditions:
     * - The method processes entities within the game based on the provided game data and world.
     * - Any exception during processing is propagated (not caught within the method).
     */
    void process(GameData gameData, World world);
}
