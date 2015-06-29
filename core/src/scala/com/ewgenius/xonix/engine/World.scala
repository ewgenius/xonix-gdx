package com.ewgenius.xonix.engine

import com.badlogic.ashley.core.{Entity, Engine}
import com.badlogic.gdx.Gdx
import com.badlogic.gdx.graphics.g3d.ModelInstance
import com.badlogic.gdx.graphics.g3d.loader.ObjLoader
import com.badlogic.gdx.math.Vector3
import com.ewgenius.xonix.engine.components.{ModelComponent, TransformComponent}
import com.badlogic.gdx.assets.loaders.ModelLoader

class World(engine: Engine) {
  def createTestEntity(): Unit = {
    val entity: Entity = new Entity

    val transform = new TransformComponent
    transform.position = new Vector3(1, 1, 1)
    entity.add(transform)

    val model = new ModelComponent
    val modelLoader = new ObjLoader()
    model.modelInstance = new ModelInstance(modelLoader.loadModel(Gdx.files.internal("data/ship.obj")))
    entity.add(model)

    engine.addEntity(entity)
  }
}
