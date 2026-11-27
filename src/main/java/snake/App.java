package snake;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class App extends Application {
    private static final String TITLE = "Змейка: отражение от границ";
    private static final int COLS = 40;
    private static final int ROWS = 30;
    private static final long STEP_NANOS = 100_000_000L;

    private final GameModel model = new GameModel(COLS, ROWS);
    private final GameView view = new GameView();

    @Override
    public void start(Stage stage) {
        Canvas canvas = view.getCanvas();
        canvas.setWidth(COLS * GameView.CELL);
        canvas.setHeight(ROWS * GameView.CELL);
        stage.setTitle(TITLE);
        stage.setScene(new Scene(new Pane(canvas)));
        stage.setResizable(false);
        stage.show();
        view.draw(model.getSnake());
        startLoop();
    }

    private void startLoop() {
        new AnimationTimer() {
            private long lastStep;

            @Override
            public void handle(long now) {
                if (now - lastStep >= STEP_NANOS) {
                    lastStep = now;
                    model.tick();
                    view.draw(model.getSnake());
                }
            }
        }.start();
    }
}