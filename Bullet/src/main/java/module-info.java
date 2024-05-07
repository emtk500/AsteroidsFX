import dk.sdu.mmmi.enemy.common.bullet.BulletSPI;
import dk.sdu.mmmi.enemy.common.services.IEntityProcessingService;
import dk.sdu.mmmi.enemy.common.services.IGamePluginService;

module Bullet {
    requires Common;
    requires CommonBullet;
    provides IGamePluginService with dk.sdu.mmmi.enemy.bulletsystem.BulletPlugin;
    provides BulletSPI with dk.sdu.mmmi.enemy.bulletsystem.BulletControlSystem;
    provides IEntityProcessingService with dk.sdu.mmmi.enemy.bulletsystem.BulletControlSystem;
}