import dk.sdu.mmmi.enemy.common.services.IEntityProcessingService;
import dk.sdu.mmmi.enemy.common.services.IGamePluginService;

module Enemy {
    requires java.xml;
    requires Common;
    requires CommonEnemy;
    requires CommonBullet;

    uses dk.sdu.mmmi.enemy.common.bullet.BulletSPI;

    provides IGamePluginService with dk.sdu.mmmi.enemy.EnemyPlugin;
    provides IEntityProcessingService with dk.sdu.mmmi.enemy.EnemyProcessor;

}