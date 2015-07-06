package com.ewgenius.xonix.engine.behaviour

import com.badlogic.ashley.core.Entity

class Behaviour {
  var action: (Behaviour, Entity, Float) => Any = (behaviour: Behaviour, entity: Entity, delta: Float) => null

  def update(entity: Entity, delta: Float): Unit = {
    action(this, entity, delta)
  }
}
