import dk.sdu.mmmi.enemy.common.services.IPostEntityProcessingService;

module Collision {
    requires Common;   
    provides IPostEntityProcessingService with dk.sdu.mmmi.enemy.collisionsystem.CollisionDetector;
}