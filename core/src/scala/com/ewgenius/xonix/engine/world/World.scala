package com.ewgenius.xonix.engine.world

import com.badlogic.ashley.core.{ComponentMapper, Engine, Entity}
import com.badlogic.gdx.Gdx
import com.badlogic.gdx.graphics.g3d.ModelInstance
import com.badlogic.gdx.graphics.g3d.loader.ObjLoader
import com.badlogic.gdx.math.Vector3
import com.ewgenius.xonix.engine.behaviour.Behaviour
import com.ewgenius.xonix.engine.components.{BehaviourComponent, ModelComponent, MovementComponent, TransformComponent}

class World(engine: Engine) {
  private val modelLoader = new ObjLoader()

  def createTestEntity(): Unit = {
    val entity: Entity = new Entity

    val transform = new TransformComponent
    transform.position = new Vector3(1, 1, 1)
    entity.add(transform)

    val model = new ModelComponent
    model.modelInstance = new ModelInstance(modelLoader.loadModel(Gdx.files.internal("build/cube/cube.obj")))
    entity.add(model)

    val movement = new MovementComponent
    movement.acceleration = new Vector3(0, 0, 0)
    entity.add(movement)

    val behaviour = new BehaviourComponent
    behaviour.behaviour = new Behaviour
    val cm: ComponentMapper[MovementComponent] = ComponentMapper.getFor(classOf[MovementComponent])
    var timer: Float = 0
    behaviour.behaviour.action = (behaviour: Behaviour, entity: Entity, delta: Float) => {
      timer += delta
      val m = cm.get(entity)
      m.velocity.set(new Vector3(0, Math.sin(timer).toFloat, 0))
    }
    entity.add(behaviour)

    engine.addEntity(entity)
  }

  def createField(): Unit = {
    val entity: Entity = new Entity

    val transform = new TransformComponent
    transform.scale.set(5, 5, 5)
    entity.add(transform)

    val model = new ModelComponent
    model.modelInstance = new ModelInstance(modelLoader.loadModel(Gdx.files.internal("build/field/field.obj")))
    entity.add(model)

    engine.addEntity(entity)
  }
}
