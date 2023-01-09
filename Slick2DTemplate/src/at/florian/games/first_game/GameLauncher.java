package at.florian.games.first_game;

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
        this.actors = new ArrayList<Actor>();
        Rectangle rectangle = new Rectangle(100, 100, 100, 100, 10.0f);
        Circle circle = new Circle(100, 100, 100, 10.0f);
        Oval oval = new Oval(100, 300, 100, 50, 10.0f);

        this.actors.add(rectangle);
        this.actors.add(circle);
        this.actors.add(oval);
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
            AppGameContainer container = new AppGameContainer(new GameLauncher("Objects"));
            container.setDisplayMode(800, 600, false);
            container.start();
        } catch (SlickException e) {
            e.printStackTrace();
        }
    }
}
