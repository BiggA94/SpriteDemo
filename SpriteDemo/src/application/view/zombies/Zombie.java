package application.view.zombies;

import javafx.animation.Animation.Status;
import javafx.animation.Interpolator;
import javafx.animation.PathTransition;
import javafx.animation.TranslateTransition;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.ReadOnlyDoubleProperty;
import javafx.beans.property.ReadOnlyObjectProperty;
import javafx.collections.ObservableMap;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.shape.LineTo;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.Path;
import javafx.util.Duration;
import application.view.SpriteAnimation;

public abstract class Zombie {

	private Image sprite;

	/**
	 * @return the sprite
	 */
	public Image getSprite() {
		return sprite;
	}

	/**
	 * @param sprite
	 *            the sprite to set
	 */
	public void setSprite(Image sprite) {
		this.sprite = sprite;
	}

	private SpriteAnimation spriteAnimation = new SpriteAnimation();

	/**
	 * @return the spriteAnimation
	 */
	public SpriteAnimation getSpriteAnimation() {
		return spriteAnimation;
	}

	/**
	 * @param spriteAnimation
	 *            the spriteAnimation to set
	 */
	public void setSpriteAnimation(SpriteAnimation spriteAnimation) {
		this.spriteAnimation = spriteAnimation;
	}

	public Zombie() {
	}

	public Zombie(ImageView imageView, Duration duration, int count,
			int columns, int offsetX, int offsetY, int width, int height) {
		this.setSpriteAnimation(new SpriteAnimation(imageView, duration, count,
				columns, offsetX, offsetY, width, height));
	}

	public synchronized PathTransition moveTo(double x, double y,
			double duration) {
		// let him walk over the grid
		/*Path path = new Path();
		path.getElements().add(
				new MoveTo(this.getImageView().getTranslateX(), this
						.getImageView().getTranslateY()));
		// path.getElements().add(new LineTo(100,100));
		path.getElements().add(
				new LineTo(x - this.getImageView().getLayoutX(), y
						- this.getImageView().getLayoutY()));

		// Returns to start
		// path.getElements().add(new ClosePath());

		PathTransition pathTransition = new PathTransition(
				Duration.seconds(duration), path, this.getImageView());
		// pathTransition.setCycleCount(Animation.INDEFINITE);
		pathTransition.setDuration(Duration.seconds(duration));
		pathTransition.play();*/
		
		TranslateTransition translateTransition = new TranslateTransition();
		translateTransition.setFromX(this.getImageView().getTranslateX());
		translateTransition.setFromY(this.getImageView().getTranslateY());
		
		translateTransition.setToX(x);
		translateTransition.setToY(y);
		
		translateTransition.setNode(this.getImageView());
	    //translateTransition.setDuration(Duration.millis(duration));
	    translateTransition.play();

		return null;
	}

	/**
	 * @return
	 * @see application.view.SpriteAnimation#getImageView()
	 */
	public ImageView getImageView() {
		return spriteAnimation.getImageView();
	}

	/**
	 * @param imageView
	 * @see application.view.SpriteAnimation#setImageView(javafx.scene.image.ImageView)
	 */
	public void setImageView(ImageView imageView) {
		spriteAnimation.setImageView(imageView);
	}

	/**
	 * @return
	 * @see application.view.SpriteAnimation#getCount()
	 */
	public int getCount() {
		return spriteAnimation.getCount();
	}

	/**
	 * @param count
	 * @see application.view.SpriteAnimation#setCount(int)
	 */
	public void setCount(int count) {
		spriteAnimation.setCount(count);
	}

	/**
	 * @param count
	 * @return
	 * @see application.view.SpriteAnimation#withCount(int)
	 */
	public SpriteAnimation withCount(int count) {
		return spriteAnimation.withCount(count);
	}

	/**
	 * @return
	 * @see application.view.SpriteAnimation#getColumns()
	 */
	public int getColumns() {
		return spriteAnimation.getColumns();
	}

	/**
	 * @param columns
	 * @see application.view.SpriteAnimation#setColumns(int)
	 */
	public void setColumns(int columns) {
		spriteAnimation.setColumns(columns);
	}

	/**
	 * @param columns
	 * @return
	 * @see application.view.SpriteAnimation#withCollumns(int)
	 */
	public SpriteAnimation withCollumns(int columns) {
		return spriteAnimation.withCollumns(columns);
	}

	/**
	 * @return
	 * @see application.view.SpriteAnimation#getOffsetX()
	 */
	public int getOffsetX() {
		return spriteAnimation.getOffsetX();
	}

	/**
	 * @param offsetX
	 * @see application.view.SpriteAnimation#setOffsetX(int)
	 */
	public void setOffsetX(int offsetX) {
		spriteAnimation.setOffsetX(offsetX);
	}

	/**
	 * @return
	 * @see java.lang.Object#hashCode()
	 */
	public int hashCode() {
		return spriteAnimation.hashCode();
	}

	/**
	 * @param offsetX
	 * @return
	 * @see application.view.SpriteAnimation#withOffsetX(int)
	 */
	public SpriteAnimation withOffsetX(int offsetX) {
		return spriteAnimation.withOffsetX(offsetX);
	}

	/**
	 * @return
	 * @see application.view.SpriteAnimation#getOffsetY()
	 */
	public int getOffsetY() {
		return spriteAnimation.getOffsetY();
	}

	/**
	 * @param offsetY
	 * @see application.view.SpriteAnimation#setOffsetY(int)
	 */
	public void setOffsetY(int offsetY) {
		spriteAnimation.setOffsetY(offsetY);
	}

	/**
	 * @param offsetY
	 * @return
	 * @see application.view.SpriteAnimation#withOffsetY(int)
	 */
	public SpriteAnimation withOffsetY(int offsetY) {
		return spriteAnimation.withOffsetY(offsetY);
	}

	/**
	 * @return
	 * @see application.view.SpriteAnimation#getWidth()
	 */
	public int getWidth() {
		return spriteAnimation.getWidth();
	}

	/**
	 * @param width
	 * @see application.view.SpriteAnimation#setWidth(int)
	 */
	public void setWidth(int width) {
		spriteAnimation.setWidth(width);
	}

	/**
	 * @param width
	 * @return
	 * @see application.view.SpriteAnimation#withWidth(int)
	 */
	public SpriteAnimation withWidth(int width) {
		return spriteAnimation.withWidth(width);
	}

	/**
	 * @return
	 * @see application.view.SpriteAnimation#getHeight()
	 */
	public int getHeight() {
		return spriteAnimation.getHeight();
	}

	/**
	 * @param height
	 * @see application.view.SpriteAnimation#setHeight(int)
	 */
	public void setHeight(int height) {
		spriteAnimation.setHeight(height);
	}

	/**
	 * @param height
	 * @return
	 * @see application.view.SpriteAnimation#withHeight(int)
	 */
	public SpriteAnimation withHeight(int height) {
		return spriteAnimation.withHeight(height);
	}

	/**
	 * @return
	 * @see application.view.SpriteAnimation#getLastIndex()
	 */
	public int getLastIndex() {
		return spriteAnimation.getLastIndex();
	}

	/**
	 * @param lastIndex
	 * @see application.view.SpriteAnimation#setLastIndex(int)
	 */
	public void setLastIndex(int lastIndex) {
		spriteAnimation.setLastIndex(lastIndex);
	}

	/**
	 * @param lastIndex
	 * @return
	 * @see application.view.SpriteAnimation#withLastIndex(int)
	 */
	public SpriteAnimation withLastIndex(int lastIndex) {
		return spriteAnimation.withLastIndex(lastIndex);
	}

	/**
	 * @param value
	 * @see javafx.animation.Transition#setInterpolator(javafx.animation.Interpolator)
	 */
	public final void setInterpolator(Interpolator value) {
		spriteAnimation.setInterpolator(value);
	}

	/**
	 * @return
	 * @see javafx.animation.Transition#getInterpolator()
	 */
	public final Interpolator getInterpolator() {
		return spriteAnimation.getInterpolator();
	}

	/**
	 * @return
	 * @see javafx.animation.Transition#interpolatorProperty()
	 */
	public final ObjectProperty<Interpolator> interpolatorProperty() {
		return spriteAnimation.interpolatorProperty();
	}

	/**
	 * @param obj
	 * @return
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	public boolean equals(Object obj) {
		return spriteAnimation.equals(obj);
	}

	/**
	 * @param value
	 * @see javafx.animation.Animation#setRate(double)
	 */
	public final void setRate(double value) {
		spriteAnimation.setRate(value);
	}

	/**
	 * @return
	 * @see javafx.animation.Animation#getRate()
	 */
	public final double getRate() {
		return spriteAnimation.getRate();
	}

	/**
	 * @return
	 * @see javafx.animation.Animation#rateProperty()
	 */
	public final DoubleProperty rateProperty() {
		return spriteAnimation.rateProperty();
	}

	/**
	 * @return
	 * @see java.lang.Object#toString()
	 */
	public String toString() {
		return spriteAnimation.toString();
	}

	/**
	 * @return
	 * @see javafx.animation.Animation#getCurrentRate()
	 */
	public final double getCurrentRate() {
		return spriteAnimation.getCurrentRate();
	}

	/**
	 * @return
	 * @see javafx.animation.Animation#currentRateProperty()
	 */
	public final ReadOnlyDoubleProperty currentRateProperty() {
		return spriteAnimation.currentRateProperty();
	}

	/**
	 * @return
	 * @see javafx.animation.Animation#getCycleDuration()
	 */
	public final Duration getCycleDuration() {
		return spriteAnimation.getCycleDuration();
	}

	/**
	 * @return
	 * @see javafx.animation.Animation#cycleDurationProperty()
	 */
	public final ReadOnlyObjectProperty<Duration> cycleDurationProperty() {
		return spriteAnimation.cycleDurationProperty();
	}

	/**
	 * @return
	 * @see javafx.animation.Animation#getTotalDuration()
	 */
	public final Duration getTotalDuration() {
		return spriteAnimation.getTotalDuration();
	}

	/**
	 * @return
	 * @see javafx.animation.Animation#totalDurationProperty()
	 */
	public final ReadOnlyObjectProperty<Duration> totalDurationProperty() {
		return spriteAnimation.totalDurationProperty();
	}

	/**
	 * @return
	 * @see javafx.animation.Animation#getCurrentTime()
	 */
	public final Duration getCurrentTime() {
		return spriteAnimation.getCurrentTime();
	}

	/**
	 * @return
	 * @see javafx.animation.Animation#currentTimeProperty()
	 */
	public final ReadOnlyObjectProperty<Duration> currentTimeProperty() {
		return spriteAnimation.currentTimeProperty();
	}

	/**
	 * @param value
	 * @see javafx.animation.Animation#setDelay(javafx.util.Duration)
	 */
	public final void setDelay(Duration value) {
		spriteAnimation.setDelay(value);
	}

	/**
	 * @return
	 * @see javafx.animation.Animation#getDelay()
	 */
	public final Duration getDelay() {
		return spriteAnimation.getDelay();
	}

	/**
	 * @return
	 * @see javafx.animation.Animation#delayProperty()
	 */
	public final ObjectProperty<Duration> delayProperty() {
		return spriteAnimation.delayProperty();
	}

	/**
	 * @param value
	 * @see javafx.animation.Animation#setCycleCount(int)
	 */
	public final void setCycleCount(int value) {
		spriteAnimation.setCycleCount(value);
	}

	/**
	 * @return
	 * @see javafx.animation.Animation#getCycleCount()
	 */
	public final int getCycleCount() {
		return spriteAnimation.getCycleCount();
	}

	/**
	 * @return
	 * @see javafx.animation.Animation#cycleCountProperty()
	 */
	public final IntegerProperty cycleCountProperty() {
		return spriteAnimation.cycleCountProperty();
	}

	/**
	 * @param value
	 * @see javafx.animation.Animation#setAutoReverse(boolean)
	 */
	public final void setAutoReverse(boolean value) {
		spriteAnimation.setAutoReverse(value);
	}

	/**
	 * @return
	 * @see javafx.animation.Animation#isAutoReverse()
	 */
	public final boolean isAutoReverse() {
		return spriteAnimation.isAutoReverse();
	}

	/**
	 * @return
	 * @see javafx.animation.Animation#autoReverseProperty()
	 */
	public final BooleanProperty autoReverseProperty() {
		return spriteAnimation.autoReverseProperty();
	}

	/**
	 * @return
	 * @see javafx.animation.Animation#getStatus()
	 */
	public final Status getStatus() {
		return spriteAnimation.getStatus();
	}

	/**
	 * @return
	 * @see javafx.animation.Animation#statusProperty()
	 */
	public final ReadOnlyObjectProperty<Status> statusProperty() {
		return spriteAnimation.statusProperty();
	}

	/**
	 * @return
	 * @see javafx.animation.Animation#getTargetFramerate()
	 */
	public final double getTargetFramerate() {
		return spriteAnimation.getTargetFramerate();
	}

	/**
	 * @param value
	 * @see javafx.animation.Animation#setOnFinished(javafx.event.EventHandler)
	 */
	public final void setOnFinished(EventHandler<ActionEvent> value) {
		spriteAnimation.setOnFinished(value);
	}

	/**
	 * @return
	 * @see javafx.animation.Animation#getOnFinished()
	 */
	public final EventHandler<ActionEvent> getOnFinished() {
		return spriteAnimation.getOnFinished();
	}

	/**
	 * @return
	 * @see javafx.animation.Animation#onFinishedProperty()
	 */
	public final ObjectProperty<EventHandler<ActionEvent>> onFinishedProperty() {
		return spriteAnimation.onFinishedProperty();
	}

	/**
	 * @return
	 * @see javafx.animation.Animation#getCuePoints()
	 */
	public final ObservableMap<String, Duration> getCuePoints() {
		return spriteAnimation.getCuePoints();
	}

	/**
	 * @param time
	 * @see javafx.animation.Animation#jumpTo(javafx.util.Duration)
	 */
	public void jumpTo(Duration time) {
		spriteAnimation.jumpTo(time);
	}

	/**
	 * @param cuePoint
	 * @see javafx.animation.Animation#jumpTo(java.lang.String)
	 */
	public void jumpTo(String cuePoint) {
		spriteAnimation.jumpTo(cuePoint);
	}

	/**
	 * @param cuePoint
	 * @see javafx.animation.Animation#playFrom(java.lang.String)
	 */
	public void playFrom(String cuePoint) {
		spriteAnimation.playFrom(cuePoint);
	}

	/**
	 * @param time
	 * @see javafx.animation.Animation#playFrom(javafx.util.Duration)
	 */
	public void playFrom(Duration time) {
		spriteAnimation.playFrom(time);
	}

	/**
	 * 
	 * @see javafx.animation.Animation#play()
	 */
	public void play() {
		spriteAnimation.play();
	}

	/**
	 * 
	 * @see javafx.animation.Animation#playFromStart()
	 */
	public void playFromStart() {
		spriteAnimation.playFromStart();
	}

	/**
	 * 
	 * @see javafx.animation.Animation#stop()
	 */
	public void stop() {
		spriteAnimation.stop();
	}

	/**
	 * 
	 * @see javafx.animation.Animation#pause()
	 */
	public void pause() {
		spriteAnimation.pause();
	}
}
