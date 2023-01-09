package at.florian.games.strategy_pattern.actors;

import at.florian.games.first_game.Actor;
import at.florian.games.strategy_pattern.movement.MovementStrategy;
import org.newdawn.slick.Graphics;

public class Circle implements Actor {
    private float diameter;
    private MovementStrategy movementStrategy;

    public Circle(float diameter, MovementStrategy movementStrategy) {
        this.diameter = diameter;
        this.movementStrategy = movementStrategy;
    }

    @Override
    public void render(Graphics graphics) {
        System.out.println(this.movementStrategy.getY());
        graphics.drawOval(this.movementStrategy.getX(), this.movementStrategy.getY(), this.diameter, this.diameter);
    }

    @Override
    public void update(int delta) {
        this.movementStrategy.update(delta, this.diameter, this.diameter);
    }
}
