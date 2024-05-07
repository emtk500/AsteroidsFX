package dk.sdu.mmmi.enemy.common.asteroids;

import dk.sdu.mmmi.enemy.common.data.Entity;
import dk.sdu.mmmi.enemy.common.data.World;

/**
 *
 * @author corfixen
 */
public interface IAsteroidSplitter {
    void createSplitAsteroid(Entity e, World w);
}
