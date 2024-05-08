import dk.sdu.mmmi.enemy.common.services.IPostEntityProcessingService;

module Collision {
    requires Common;
    requires CommonAsteroids;
    requires CommonBullet;
    requires Asteroid;
    requires Player;
    requires CommonEnemy;

    provides IPostEntityProcessingService with dk.sdu.mmmi.enemy.collisionsystem.CollisionDetector;
}