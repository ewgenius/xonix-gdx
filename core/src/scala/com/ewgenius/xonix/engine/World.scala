package com.ewgenius.xonix.engine

import com.badlogic.ashley.core.{Entity, Engine}
import com.ewgenius.xonix.engine.components.{ModelComponent, TransformComponent}

class World(engine: Engine) {
  def createTestEntity(): Unit = {
    val entity: Entity = new Entity
    entity.add(new TransformComponent)
    entity.add(new ModelComponent)

    engine.addEntity(entity)
  }
}
