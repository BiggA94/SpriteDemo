package application.controller;

import application.view.zombies.HumanZombie;
import javafx.animation.Animation;
import javafx.animation.PathTransition;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.util.Duration;
import javafx.scene.layout.BorderPane;

public class mainController {

	@FXML
	GridPane grid;

	@FXML
	ImageView imageView;

	@FXML
	BorderPane root;

	private HumanZombie humanZombie_01;

	public mainController() {
		// TODO Auto-generated constructor stub

	}

	@FXML
	private void initialize() {
		imageView.setX(0);
		imageView.setY(0);
		humanZombie_01 = new HumanZombie(imageView, Duration.millis(1000), 16,
				4, 0, 0, 32, 48);
		// humanZombie_01.setAutoReverse(true);
		humanZombie_01.setCycleCount(Animation.INDEFINITE);
		humanZombie_01.playFromStart();

		// humanZombie_01.moveTo(0, 0, 1);
	}

	@FXML
	public void mouse_clicked(MouseEvent event) {
		humanZombie_01.moveTo(event.getSceneX(), event.getSceneY(), 1000);
	}
}
