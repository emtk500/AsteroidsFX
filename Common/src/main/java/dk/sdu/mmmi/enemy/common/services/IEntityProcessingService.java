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
     * @throws
     */
    void process(GameData gameData, World world);
}
