package dk.sdu.mmmi.enemy;

import dk.sdu.mmmi.Enemy;
import dk.sdu.mmmi.enemy.common.bullet.BulletSPI;
import dk.sdu.mmmi.enemy.common.data.Entity;
import dk.sdu.mmmi.enemy.common.data.GameData;
import dk.sdu.mmmi.enemy.common.data.GameKeys;
import dk.sdu.mmmi.enemy.common.data.World;
import dk.sdu.mmmi.enemy.common.services.IEntityProcessingService;

import java.util.Collection;
import java.util.Random;
import java.util.ServiceLoader;

import static java.util.stream.Collectors.toList;

import org.springframework.stereotype.Component;

@Component
public class EnemyProcessor implements IEntityProcessingService {

    private Random random = new Random();

    private long lastShootTime = System.currentTimeMillis();
    private long shootInterval = 500;


    @Override
    public void process(GameData gameData, World world) {



            for (Entity enemy : world.getEntities(Enemy.class)) {

                double changeX = Math.cos(Math.toRadians(enemy.getRotation()));
                double changeY = Math.sin(Math.toRadians(enemy.getRotation()));

                enemy.setX(enemy.getX() + changeX * 0.5);
                enemy.setY(enemy.getY() + changeY * 0.5);

                // Wrap around the screen
                if (enemy.getX() < 0) {
                    enemy.setX(gameData.getDisplayWidth());
                } else if (enemy.getX() > gameData.getDisplayWidth()) {
                    enemy.setX(0);
                }

                if (enemy.getY() < 0) {
                    enemy.setY(gameData.getDisplayHeight());
                } else if (enemy.getY() > gameData.getDisplayHeight()) {
                    enemy.setY(0);
                }

                long currentTime = System.currentTimeMillis();
                if (currentTime - lastShootTime >= shootInterval) {
                    // Reset the timer
                    lastShootTime = currentTime;

                    // Randomly shoot
                    if (random.nextDouble() < 0.20) {
                        getBulletSPIs().stream().findFirst().ifPresent(
                                spi -> {
                                    world.addEntity(spi.createBullet(enemy, gameData));
                                }
                        );
                    }
                }

        }
    }

    private Collection<? extends BulletSPI> getBulletSPIs() {
        return ServiceLoader.load(BulletSPI.class).stream().map(ServiceLoader.Provider::get).collect(toList());
    }
}
