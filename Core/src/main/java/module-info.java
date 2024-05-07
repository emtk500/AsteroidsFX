module Core {
    requires Common;
    requires CommonBullet;    
    requires javafx.graphics;    
    opens dk.sdu.mmmi.enemy.main to javafx.graphics;
    uses dk.sdu.mmmi.enemy.common.services.IGamePluginService;
    uses dk.sdu.mmmi.enemy.common.services.IEntityProcessingService;
    uses dk.sdu.mmmi.enemy.common.services.IPostEntityProcessingService;
}


