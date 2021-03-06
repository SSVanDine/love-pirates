package com.pirates.game;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Contact;
import com.badlogic.gdx.physics.box2d.Fixture;
import com.badlogic.gdx.physics.box2d.PolygonShape;
import com.badlogic.gdx.physics.box2d.Shape;

public class TresureChest extends LootCrate {

	public TresureChest(float x, float y, int amount) {
		super(x, y, "treasure", amount);
		float choice = rand.nextFloat();
		if (choice> .6) {
			contents = "treasure";
		} else if (choice > .25){
			contents = "cannons";
			quantaty = (int) Math.ceil(amount/4f);
		} else {
			contents = "repair supplies";
		}
		fixture.setDensity(.01f);
		Shape s = fixture.getShape();
		if (s.getType() == Shape.Type.Polygon) {
			PolygonShape p = (PolygonShape) s;
			p.setAsBox(1, 1, new Vector2(0,0), 0);
		}
		body.setLinearVelocity(0, 0);
		body.setAngularVelocity(0);
	}
	@Override
	public boolean handlePreCollide(Contact contact) {
		Fixture f = contact.getFixtureB();
		if (f == fixture) {
			f = contact.getFixtureA();
		}
		Object b = f.getUserData();
		if (b instanceof Debries){
			return false;
		} else if (f.getFilterData().categoryBits == LovePirates.LAND_MASK) {
			return false;
		}
		
		return true;
	}

}
