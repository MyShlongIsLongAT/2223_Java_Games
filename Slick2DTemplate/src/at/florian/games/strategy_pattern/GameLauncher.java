package at.florian.games.strategy_pattern;

import at.florian.games.first_game.Actor;
import at.florian.games.strategy_pattern.actors.Circle;
import at.florian.games.strategy_pattern.movement.MoveRightnLeft;
import at.florian.games.strategy_pattern.movement.MoveUpnDown;
import at.florian.games.strategy_pattern.movement.MovementStrategy;
import org.newdawn.slick.*;

import java.util.ArrayList;
import java.util.List;

public class GameLauncher extends BasicGame {
    private List<Actor> actors;

    public GameLauncher(String title) {
        super(title);
    }

    @Override
    public void init(GameContainer gameContainer) throws SlickException {
        MovementStrategy moveUpnDown = new MoveUpnDown(100, 100, 0.5f);
        MovementStrategy moveRightnLeft = new MoveRightnLeft(100, 100, 0.5f);
        this.actors = new ArrayList<Actor>();

        Circle circle = new Circle(100, moveRightnLeft);

        this.actors.add(circle);
    }

    @Override
    public void update(GameContainer gameContainer, int delta) throws SlickException {
        for (Actor actor : this.actors) {
            actor.update(delta);
        }
    }

    @Override
    public void render(GameContainer gameContainer, Graphics graphics) throws SlickException {
        for (Actor actor : this.actors) {
            actor.render(graphics);
        }
    }

    public static void main(String[] argv) {
        try {
            AppGameContainer container = new AppGameContainer(new GameLauncher("Fortnite-4K"));
            container.setDisplayMode(800, 600, false);
            container.start();
        } catch (SlickException e) {
            e.printStackTrace();
        }
    }
}
