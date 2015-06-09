package application.view.zombies;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.util.Duration;
import application.view.SpriteAnimation;

public class HumanZombie extends Zombie {

	public HumanZombie() {
		super();
		this.setSprite(new Image(this.getClass().getResourceAsStream(
				"../../../res/chmale12-3.png")));
	}

	public HumanZombie(ImageView imageView, Duration duration, int count,
			int columns, int offsetX, int offsetY, int width, int height) {
		super(imageView, duration, count, columns, offsetX, offsetY, width,
				height);
	}

}
