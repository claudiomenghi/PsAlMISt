package se.gu.evaluation.rq.environment;

import java.awt.Color;

import javax.vecmath.Color3f;
import javax.vecmath.Vector3d;
import javax.vecmath.Vector3f;

import simbad.sim.Box;
import simbad.sim.EnvironmentDescription;

public class Obstacle extends Box {

	private final int x;
	private final int y;

	private final static Color c = Color.YELLOW;

	public static final float BOX_LENGHT = 0.7f;

	public Obstacle(int x, int y, EnvironmentDescription e, float originx, float originy) {
		super(new Vector3d(
				((float) x) * Room.ROOM_LENGHT + originx+ BOX_LENGHT/2, 
				0, 
				((float) y) * Room.ROOM_LENGHT + originy+ BOX_LENGHT/2),
				new Vector3f(BOX_LENGHT, BOX_LENGHT, BOX_LENGHT), e);
		setColor(new Color3f(c));

		this.x = x;
		this.y = y;
		e.add(this);
	}

	/**
	 * @return the x
	 */
	public int getX() {
		return x;
	}

	/**
	 * @return the y
	 */
	public int getY() {
		return y;
	}

}
