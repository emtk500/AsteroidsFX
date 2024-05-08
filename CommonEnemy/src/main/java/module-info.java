module CommonEnemy {
    exports dk.sdu.mmmi;
    requires Common;
    requires spring.context;
    opens dk.sdu.mmmi to Collision;
}