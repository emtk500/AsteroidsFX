package dk.sdu.mmmi.enemy.common.services;

import dk.sdu.mmmi.enemy.common.data.GameData;
import dk.sdu.mmmi.enemy.common.data.World;

/**
 *
 * @author jcs
 */
public interface IPostEntityProcessingService {

    /**
     *
     * @param gameData
     * @param world
     * Pre-conditions:
     * - The 'gameData'  must not be null.
     * - The 'world'  must not be null.
     *
     * Post-conditions:
     * - The method processes entities within the game based on the provided game data and world.
     */

    void process(GameData gameData, World world);
}
