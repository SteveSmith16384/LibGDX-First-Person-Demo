package engine;

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

import com.badlogic.gdx.math.Matrix4;
import com.badlogic.gdx.math.RandomXS128;
import com.badlogic.gdx.math.Vector3;


/**
 * Contains the definitions for the game engine. Globals is a collection list
 * the collection of global variables and constants that the game engine may
 * require. As consequence you don't have to touch that much code this time.
 * <b>You can not instantiate this class.</b>
 *
 * @author root
 */
public final class Globals implements Core {

	/**
	 * You can not instantiate this class.
	 */
	private Globals() {
	}


	public static final RandomXS128 RAND = new RandomXS128(new SecureRandom().nextLong());

	static {
		new Thread(new Runnable() {

			@Override
			public void run() {
				try {
					final SecureRandom secureRandom = SecureRandom.getInstanceStrong();

					final long seed0 = secureRandom.nextLong();
					final long seed1 = secureRandom.nextLong();

					RAND.setState(seed0, seed1);
				} catch (NoSuchAlgorithmException ignore) {
					// nsae.printStackTrace(System.err);
				}
			}
		}).start();
	}

	/**
	 * Temporary vectors to be used by the engine. Pass them around like bong
	 * (HIMYM).
	 */
	public static final Vector3 TMP_VEC = new Vector3(0, 0, 0),
			TMP_VEC_B = new Vector3(0, 0, 0),
			TMP_VEC_C = new Vector3(0, 0, 0);

	/**
	 *
	 */
	public final static Matrix4 TMP_M = new Matrix4();


	/**
	 * Message dispatcher stuff.
	 */
	public interface Dispatcher {

		static final int UPDATE = 0x0;
		
	}
}
