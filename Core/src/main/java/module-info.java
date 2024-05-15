module Core {
    requires Common;
    requires CommonBullet;
    requires javafx.graphics;
    requires spring.context;
    requires spring.web;
    exports dk.sdu.mmmi.enemy.main;
    opens dk.sdu.mmmi.enemy.main to javafx.graphics,spring.core;
    uses dk.sdu.mmmi.enemy.common.services.IGamePluginService;
    uses dk.sdu.mmmi.enemy.common.services.IEntityProcessingService;
    uses dk.sdu.mmmi.enemy.common.services.IPostEntityProcessingService;
}


