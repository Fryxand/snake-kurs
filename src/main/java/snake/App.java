package snake;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class App extends Application {
    private static final String TITLE = "Змейка: отражение от границ";
    private static final int INITIAL_COLS = 40;
    private static final int INITIAL_ROWS = 30;
    private static final double SCENE_WIDTH = 800;
    private static final double SCENE_HEIGHT = 600;
    private static final double MIN_WINDOW_WIDTH = 400;
    private static final double MIN_WINDOW_HEIGHT = 440;
    private static final long STEP_NANOS = 100_000_000L;

    private final GameModel model = new GameModel(INITIAL_COLS, INITIAL_ROWS);
    private final GameView view = new GameView();

    @Override
    public void start(Stage stage) {
        Scene scene = new Scene(createCanvasPane(), SCENE_WIDTH, SCENE_HEIGHT);
        stage.setTitle(TITLE);
        stage.setMinWidth(MIN_WINDOW_WIDTH);
        stage.setMinHeight(MIN_WINDOW_HEIGHT);
        stage.setScene(scene);
        stage.show();
        startLoop();
    }

    private Pane createCanvasPane() {
        Canvas canvas = view.getCanvas();
        Pane pane = new Pane(canvas);
        pane.setMinSize(0, 0);
        canvas.widthProperty().bind(pane.widthProperty());
        canvas.heightProperty().bind(pane.heightProperty());
        canvas.widthProperty().addListener((obs, oldValue, newValue) -> onCanvasResized());
        canvas.heightProperty().addListener((obs, oldValue, newValue) -> onCanvasResized());
        return pane;
    }

    private void onCanvasResized() {
        Canvas canvas = view.getCanvas();
        model.resize((int) (canvas.getWidth() / GameView.CELL), (int) (canvas.getHeight() / GameView.CELL));
        view.draw(model.getSnake());
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