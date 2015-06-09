package application.view;

import javafx.animation.Interpolator;
import javafx.animation.Transition;
import javafx.geometry.Rectangle2D;
import javafx.scene.image.ImageView;
import javafx.util.Duration;

public class SpriteAnimation extends Transition {

	private ImageView imageView;
	/**
	 * Number of Pictures that should be used
	 */
	private int count = 0;
	private int columns = 1;
	private int offsetX = 0;
	private int offsetY = 0;
	private int width = 0;
	private int height = 0;

	private int lastIndex;

	/**
	 * @return the imageView
	 */
	public ImageView getImageView() {
		return imageView;
	}

	/**
	 * @param imageView
	 *            the imageView to set
	 */
	public void setImageView(ImageView imageView) {
		this.imageView = imageView;
	}

	/**
	 * @return the count
	 */
	public int getCount() {
		return count;
	}

	/**
	 * @param count
	 *            the count to set
	 */
	public void setCount(int count) {
		this.count = count;
	}

	public SpriteAnimation withCount(int count) {
		this.setCount(count);
		return this;
	}

	/**
	 * @return the columns
	 */
	public int getColumns() {
		return columns;
	}

	/**
	 * @param columns
	 *            the columns to set
	 */
	public void setColumns(int columns) {
		this.columns = columns;
	}

	public SpriteAnimation withCollumns(int columns) {
		this.setColumns(columns);
		return this;
	}

	/**
	 * @return the offsetX
	 */
	public int getOffsetX() {
		return offsetX;
	}

	/**
	 * @param offsetX
	 *            the offsetX to set
	 */
	public void setOffsetX(int offsetX) {
		this.offsetX = offsetX;
	}

	public SpriteAnimation withOffsetX(int offsetX) {
		setOffsetX(offsetX);
		return this;
	}

	/**
	 * @return the offsetY
	 */
	public int getOffsetY() {
		return offsetY;
	}

	/**
	 * @param offsetY
	 *            the offsetY to set
	 */
	public void setOffsetY(int offsetY) {
		this.offsetY = offsetY;
	}

	public SpriteAnimation withOffsetY(int offsetY) {
		setOffsetY(offsetY);
		return this;
	}

	/**
	 * @return the width
	 */
	public int getWidth() {
		return width;
	}

	/**
	 * @param width
	 *            the width to set
	 */
	public void setWidth(int width) {
		this.width = width;
	}

	public SpriteAnimation withWidth(int width) {
		setWidth(width);
		return this;
	}

	/**
	 * @return the height
	 */
	public int getHeight() {
		return height;
	}

	/**
	 * @param height
	 *            the height to set
	 */
	public void setHeight(int height) {
		this.height = height;
	}

	public SpriteAnimation withHeight(int height) {
		setHeight(height);
		return this;
	}

	/**
	 * @return the lastIndex
	 */
	public int getLastIndex() {
		return lastIndex;
	}

	/**
	 * @param lastIndex
	 *            the lastIndex to set
	 */
	public void setLastIndex(int lastIndex) {
		this.lastIndex = lastIndex;
	}

	public SpriteAnimation withLastIndex(int lastIndex) {
		setLastIndex(lastIndex);
		return this;
	}

	public SpriteAnimation() {

	}

	public SpriteAnimation(ImageView imageView, Duration duration, int count,
			int columns, int offsetX, int offsetY, int width, int height) {
		this.imageView = imageView;
		this.count = count;
		this.columns = columns;
		this.offsetX = offsetX;
		this.offsetY = offsetY;
		this.width = width;
		this.height = height;
		setCycleDuration(duration);
		setInterpolator(Interpolator.LINEAR);
	}

	protected void interpolate(double k) {
		final int index = Math.min((int) Math.floor(k * count), count - 1);
		if (index != lastIndex) {
			final int x = (index % columns) * width + offsetX;
			final int y = (index / columns) * height + offsetY;
			imageView.setViewport(new Rectangle2D(x, y, width, height));
			lastIndex = index;
		}
	}
}