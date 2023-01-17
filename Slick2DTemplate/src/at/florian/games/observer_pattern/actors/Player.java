package at.florian.games.observer_pattern.actors;

import at.florian.games.strategy_pattern.actors.AbstractActor;
import at.florian.games.strategy_pattern.movement.MovementStrategy;
import org.newdawn.slick.Graphics;

public class Player extends AbstractActor {

    public Player(float height, float width, MovementStrategy movementStrategy) {
        super(movementStrategy, height, width);
    }

    @Override
    public void render(Graphics graphics) {
        graphics.fillRect(this.movementStrategy.getX(), this.movementStrategy.getY(), this.width, this.height);
    }
}
