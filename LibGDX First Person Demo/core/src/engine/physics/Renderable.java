package engine.physics;

import com.badlogic.gdx.graphics.g3d.ModelBatch;
import com.badlogic.gdx.graphics.g3d.Environment;

public interface Renderable {

    void render(ModelBatch batch, Environment lights);
    
}
