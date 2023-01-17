package at.florian.games.strategy_pattern.actors;

import at.florian.games.first_game.Actor;
import at.florian.games.observer_pattern.ObserverColorChanger;
import at.florian.games.strategy_pattern.movement.MovementStrategy;
import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;

public class Rectangle extends AbstractActor implements ObserverColorChanger {
    private Color color;
    public Rectangle(float height,float width, MovementStrategy movementStrategy) {
        super(movementStrategy,height,width);
    }

    @Override
    public void render(Graphics graphics) {
        graphics.setColor(this.color);
        graphics.fillRect(this.movementStrategy.getX(), this.movementStrategy.getY(), this.width, this.height);
    }


    @Override
    public void isTouched() {
        this.color=Color.blue;
    }

    @Override
    public void isNotTouched() {
        this.color=Color.white;
    }
}
