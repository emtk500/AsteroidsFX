package dk.sdu.mmmi.enemy.collisionsystem;

import dk.sdu.mmmi.enemy.common.services.IPostEntityProcessingService;
import dk.sdu.mmmi.enemy.common.asteroids.IAsteroidSplitter;
import dk.sdu.mmmi.enemy.common.data.Entity;
import dk.sdu.mmmi.enemy.common.data.GameData;
import dk.sdu.mmmi.enemy.common.data.World;
import dk.sdu.mmmi.enemy.common.asteroids.Asteroid;
import dk.sdu.mmmi.enemy.common.bullet.Bullet;

public class CollisionDetector implements IPostEntityProcessingService {

    private IAsteroidSplitter asteroidSplitter;

    public CollisionDetector(IAsteroidSplitter asteroidSplitter) {
        this.asteroidSplitter = asteroidSplitter;
    }

    @Override
    public void process(GameData gameData, World world) {
        // two for loops for all entities in the world
        for (Entity bullet : world.getEntities(Bullet.class)) {
            // Check for collisions with asteroids
            for (Entity asteroid : world.getEntities(Asteroid.class)) {
                if (collides(bullet, asteroid)) {
                    // Remove bullet and asteroid
                    world.removeEntity(bullet);
                    world.removeEntity(asteroid);
                    // Create split asteroids
                    asteroidSplitter.createSplitAsteroid(asteroid, world);
                    // Break out of the inner loop since bullet can collide with only one asteroid
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
