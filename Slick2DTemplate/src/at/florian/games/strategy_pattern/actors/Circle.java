package at.florian.games.strategy_pattern.actors;

import at.florian.games.first_game.Actor;
import at.florian.games.strategy_pattern.movement.MovementStrategy;
import org.newdawn.slick.Graphics;

public class Circle extends AbstractActor {
    public Circle(float diameter,MovementStrategy movementStrategy) {
        super(movementStrategy,diameter,diameter);
    }

    @Override
    public void render(Graphics graphics) {
        graphics.drawOval(this.movementStrategy.getX(), this.movementStrategy.getY(), this.height, this.width);
    }
}
