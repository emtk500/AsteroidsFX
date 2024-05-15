package dk.sdu.mmmi.enemy;

import dk.sdu.mmmi.Enemy;
import dk.sdu.mmmi.enemy.common.data.Entity;

import dk.sdu.mmmi.enemy.common.data.GameData;
import dk.sdu.mmmi.enemy.common.data.World;
import dk.sdu.mmmi.enemy.common.services.IGamePluginService;

import java.util.Random;

import org.springframework.stereotype.Component;


@Component
public class EnemyPlugin implements IGamePluginService {

    @Override
    public void start(GameData gameData, World world) {
        Entity enemy = createEnemy(gameData);
        world.addEntity(enemy);
    }

    @Override
    public void stop(GameData gameData, World world) {
        // Remove entities
        for (Entity enemy : world.getEntities(Enemy.class)) {
            world.removeEntity(enemy);
        }
    }

    private Entity createEnemy(GameData gameData) {
        Entity enemy = new Enemy();
        enemy.setType("Enemy");
        enemy.setLives(3);
        enemy.setAlive(true);
        Random rnd = new Random();
        int size = rnd.nextInt(10) + 5;
        enemy.setPolygonCoordinates(12, -1, 8, -1, 8, -3, 6, -3, 6, -5, -2, -5, -2, -7, 0, -7, 0, -9, -10, -9, -10, -5, -8, -5, -8, -3, -6, -3, -6, -1, -10, -1, -10, 1, -6, 1, -6, 3, -8, 3, -8, 5, -10, 5, -10, 9, 0, 9, 0, 7, -2, 7, -2, 5, 2, 5, 2, 1, 4, 1, 4, -1, 2, -1, 2, -3, 4, -3, 4, -1, 6, -1, 6, 1, 4, 1, 4, 3, 2, 3, 2, 5, 6, 5, 6, 3, 8, 3, 8, 1, 12, 1);
        enemy.setX(0);
        enemy.setY(0);
        enemy.setRadius(size);
        enemy.setRotation(rnd.nextInt(90));
        return enemy;
    }
}
