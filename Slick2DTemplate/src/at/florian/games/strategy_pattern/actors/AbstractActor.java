package at.florian.games.strategy_pattern.actors;

import at.florian.games.first_game.Actor;
import at.florian.games.strategy_pattern.movement.MovementStrategy;
import org.newdawn.slick.Graphics;

public abstract class AbstractActor implements Actor {
    protected MovementStrategy movementStrategy;
    protected float height, width;

    public AbstractActor(MovementStrategy movementStrategy, float height, float width) {
        this.movementStrategy = movementStrategy;
        this.height = height;
        this.width = width;
    }

    @Override
    public void update(int delta) {
        this.movementStrategy.update(delta,this.height,this.width);
    }
}
