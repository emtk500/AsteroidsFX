
import dk.sdu.mmmi.enemy.common.services.IEntityProcessingService;
import dk.sdu.mmmi.enemy.common.services.IGamePluginService;

module Player {
    exports dk.sdu.mmmi.enemy.playersystem;
    requires Common;
    requires CommonBullet;   
    uses dk.sdu.mmmi.enemy.common.bullet.BulletSPI;
    provides IGamePluginService with dk.sdu.mmmi.enemy.playersystem.PlayerPlugin;
    provides IEntityProcessingService with dk.sdu.mmmi.enemy.playersystem.PlayerControlSystem;
    
}
