import static org.junit.jupiter.api.Assertions.*;

import dk.sdu.mmmi.Enemy;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class EnemyTest {

    private Enemy enemy;

    @BeforeEach
    public void setUp() {
        enemy = new Enemy();
        enemy.setLives(3);
        enemy.setX(0);
        enemy.setY(0);
    }


    @Test
    public void testMove() {
        double oldX = enemy.getX();
        double oldY = enemy.getY();

        enemy.setX(5);
        enemy.setY(10);

        assertNotEquals(oldX, enemy.getX(), "Enemy should have moved on the x-axis");
        assertNotEquals(oldY, enemy.getY(), "Enemy should have moved on the y-axis");

    }

    @Test
    public void testLoseLife() {
        enemy.setLives(enemy.getLives()-1);
        assertEquals(2, enemy.getLives(), "Enemy should have 2 lives after losing one");

        enemy.setLives(enemy.getLives()-1);
        assertEquals(1, enemy.getLives(), "Enemy should have 1 life after losing another one");

        enemy.setLives(enemy.getLives()-1);
        assertEquals(0, enemy.getLives(), "Enemy should have 0 lives after losing all lives");

    }

    @Test
    public void testIsAlive() {
        assertTrue(enemy.isAlive(), "Enemy should initially be alive ");

        enemy.setLives(enemy.getLives()-1);
        enemy.setLives(enemy.getLives()-1);
        enemy.setLives(enemy.getLives()-1);

        assertFalse(enemy.isAlive(), "After losing it's 3 lives, enemy should no longer be alive");
    }
}
