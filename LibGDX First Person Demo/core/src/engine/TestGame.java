package engine;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.assets.loaders.ModelLoader;
import com.badlogic.gdx.graphics.g3d.Model;
import com.badlogic.gdx.graphics.g3d.ModelInstance;
import com.badlogic.gdx.graphics.g3d.loader.ObjLoader;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.physics.bullet.collision.btBoxShape;
import com.badlogic.gdx.physics.bullet.collision.btCollisionShape;
import com.badlogic.gdx.physics.bullet.dynamics.btRigidBody;
import com.badlogic.gdx.physics.bullet.linearmath.btDefaultMotionState;

import engine.core.BaseEngine;
import engine.physics.Entity;

public class TestGame extends BaseEngine {

	private CharacterController player;
	//private ModelInstance instance;

	@Override
	public void create() {
		super.create();

		createPlayer();
		createWorld();
	}


	private void createPlayer() {
		btCollisionShape player_shape = new btBoxShape(new Vector3(1.5f, 2, 1.5f));

		final Vector3 inertia = new Vector3(0, 0, 0);
		player_shape.calculateLocalInertia(1.0f, inertia);

		btDefaultMotionState motionState = new btDefaultMotionState();
		btRigidBody player_body = new btRigidBody(2, motionState, player_shape, inertia);
		player_body.setDamping(0.8f, 0.8f);
		player_body.setAngularFactor(new Vector3(0, 0, 0)); // prevent the player from falling over

		player = new CharacterController(camera, getWorld().getConstructor("box").model, player_body, 5, 5, 5);
		getWorld().add(player);
	}


	private void createWorld() {
		// Add the grounds
		Entity ground = getWorld().add("ground", 0f, 0f, 0f);
		ground.setColour(
				0.25f + 0.5f * (float) Math.random(),
				0.25f + 0.5f * (float) Math.random(),
				0.25f + 0.5f * (float) Math.random(),
				1f
				);

		ground = getWorld().add("ground", 25f, 0f, 0f);
		ground.setColour(
				0.25f + 0.5f * (float) Math.random(),
				0.25f + 0.5f * (float) Math.random(),
				0.25f + 0.5f * (float) Math.random(),
				1f
				);

		// Create some boxes to play with
		final int BOXCOUNT_X = 5;
		final int BOXCOUNT_Y = 5;
		final int BOXCOUNT_Z = 1;

		final float BOXOFFSET_X = -2.5f;
		final float BOXOFFSET_Y = 0.5f;
		final float BOXOFFSET_Z = 0f;

		for (int x = 0; x < BOXCOUNT_X; x++) {
			for (int y = 0; y < BOXCOUNT_Y; y++) {
				for (int z = 0; z < BOXCOUNT_Z; z++) {
					getWorld().add("box", BOXOFFSET_X + x, BOXOFFSET_Y + y, BOXOFFSET_Z + z).setColour(
							0.5f + 0.5f * (float) Math.random(),
							0.5f + 0.5f * (float) Math.random(),
							0.5f + 0.5f * (float) Math.random(),
							1f
							);
				}
			}
		}
		
		// Load castle
		//ModelLoader loader = new ObjLoader();
		//Model model = loader.loadModel(Gdx.files.internal("castle.obj"));
		//instance = new ModelInstance(model);
	}

	
	protected void subrender() {
		//instance.re
	}
	
	
	@Override
	public void update(float dt) {
		player.update(dt);
		super.update(dt);
	}

	
	@Override
	public void dispose() {
		super.dispose();
	}

}
