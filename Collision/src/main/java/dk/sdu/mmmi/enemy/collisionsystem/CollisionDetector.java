package dk.sdu.mmmi.enemy.collisionsystem;

import dk.sdu.mmmi.Enemy;
import dk.sdu.mmmi.enemy.asteroid.AsteroidSplitterImpl;
import dk.sdu.mmmi.enemy.common.services.IPostEntityProcessingService;
import dk.sdu.mmmi.enemy.common.asteroids.IAsteroidSplitter;
import dk.sdu.mmmi.enemy.common.data.Entity;
import dk.sdu.mmmi.enemy.common.data.GameData;
import dk.sdu.mmmi.enemy.common.data.World;
import dk.sdu.mmmi.enemy.common.asteroids.Asteroid;
import dk.sdu.mmmi.enemy.common.bullet.Bullet;
import dk.sdu.mmmi.enemy.playersystem.Player;
import org.springframework.stereotype.Component;
import org.springframework.beans.factory.annotation.Autowired;

@Component
public class CollisionDetector implements IPostEntityProcessingService {

    private IAsteroidSplitter asteroidSplitter = new AsteroidSplitterImpl();

    public CollisionDetector(){

    }

   @Autowired
    public CollisionDetector(IAsteroidSplitter asteroidSplitter) {
        this.asteroidSplitter = asteroidSplitter;
    }



    @Override
    public void process(GameData gameData, World world) {

        for (Entity bullet : world.getEntities(Bullet.class)) {
            // Check for collisions with player
            for (Entity playerShip : world.getEntities(Player.class)) {
                if (collides(bullet, playerShip)) {

                    world.removeEntity(bullet);
                    System.out.println("player lives: " + playerShip.getLives());

                    if (playerShip.getLives() == 0){
                        world.removeEntity(playerShip);
                    } else {
                        playerShip.setLives(playerShip.getLives()-1);
                    }


                    break;
                }
            }
        }

        for (Entity bullet : world.getEntities(Bullet.class)) {
            // Check for collisions with enemy
            for (Entity enemy : world.getEntities(Enemy.class)) {
                if (collides(bullet, enemy)) {

                    world.removeEntity(bullet);
                    System.out.println("enemy lives: " + enemy.getLives());

                    if (enemy.getLives() == 0){
                        enemy.setAlive(false);
                        world.removeEntity(enemy);
                    } else {
                        enemy.setLives(enemy.getLives()-1);
                    }

                    break;
                }
            }
        }

        for (Entity bullet : world.getEntities(Bullet.class)) {
            // Check for collisions with asteroids
            for (Entity asteroid : world.getEntities(Asteroid.class)) {
                if (collides(bullet, asteroid)) {

                    // Remove bullet
                    world.removeEntity(bullet);

                    // Create split asteroids
                    asteroidSplitter.createSplitAsteroid(asteroid, world);


                    break;
                }
            }
        }

        for (Entity playerShip : world.getEntities(Player.class)) {
            // Check for collisions with player
            for (Entity asteroid : world.getEntities(Asteroid.class)) {
                if (collides(playerShip, asteroid)) {

                    world.removeEntity(playerShip);
                    asteroidSplitter.createSplitAsteroid(asteroid, world);

                    System.out.println("You died");


                    break;
                }
            }
        }


    }


    public Boolean collides(Entity entity1, Entity entity2) {
        float dx = (float) entity1.getX() - (float) entity2.getX();
        float dy = (float) entity1.getY() - (float) entity2.getY();
        float distance = (float) Math.sqrt(dx * dx + dy * dy);
        return distance < (entity1.getRadius() + entity2.getRadius());
    }


}
