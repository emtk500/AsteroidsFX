package dk.sdu.mmmi.enemy.asteroid;

import dk.sdu.mmmi.enemy.common.asteroids.Asteroid;
import dk.sdu.mmmi.enemy.common.asteroids.IAsteroidSplitter;
import dk.sdu.mmmi.enemy.common.data.Entity;
import dk.sdu.mmmi.enemy.common.data.World;
import org.springframework.stereotype.Component;

import java.util.Random;

/**
 *
 * @author corfixen
 */
@Component
public class AsteroidSplitterImpl implements IAsteroidSplitter {

    @Override
    public void createSplitAsteroid(Entity e, World world) {
        // Cast the entity to an Asteroid
        Asteroid asteroid = (Asteroid) e;

        // Get the size of the original asteroid
        float originalSize = asteroid.getRadius();

        // Decide the size of the split asteroids
        float newSize = originalSize / 2;

        // Create two split asteroids
        Entity splitAsteroid1 = createAsteroid(newSize, asteroid.getX(), asteroid.getY(), world);
        Entity splitAsteroid2 = createAsteroid(newSize, asteroid.getX(), asteroid.getY(), world);

        // Remove the original asteroid
        world.removeEntity(asteroid);

        // Add the split asteroids to the world
        if (newSize > 2){
            world.addEntity(splitAsteroid1);
            world.addEntity(splitAsteroid2);
        }
        System.out.println(splitAsteroid1.getX());
    }
    /**
     * Create a new asteroid entity with the specified size and position.
     *
     * @param size  The radius of the asteroid.
     * @param x     The x-coordinate of the asteroid.
     * @param y     The y-coordinate of the asteroid.
     * @param world The game world.
     * @return The new asteroid entity.
     */
    private Entity createAsteroid(float size, double x, double y, World world) {
        Entity asteroid = new Asteroid();
        asteroid.setType("Asteroid");
        asteroid.setRadius(size);
        asteroid.setX(x);
        asteroid.setY(y);
        asteroid.setRotation(new Random().nextInt(90));
        asteroid.setPolygonCoordinates(size, -size, -size, -size, -size, size, size, size);
        return asteroid;
    }

}
