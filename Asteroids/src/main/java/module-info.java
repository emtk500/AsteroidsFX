import dk.sdu.mmmi.enemy.common.services.IEntityProcessingService;
import dk.sdu.mmmi.enemy.common.services.IGamePluginService;

module Asteroid {
    exports dk.sdu.mmmi.enemy.asteroid;
    requires Common;
    requires CommonAsteroids;
    provides IGamePluginService with dk.sdu.mmmi.enemy.asteroid.AsteroidPlugin;
    provides IEntityProcessingService with dk.sdu.mmmi.enemy.asteroid.AsteroidProcessor;
}