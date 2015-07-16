package com.ewgenius.xonix.engine.components

import com.badlogic.ashley.core.{Entity, Component}
import com.badlogic.gdx.utils.Array

class RelationComponent extends Component {
  var parent: Entity = null
  var children: Array[Entity] = new Array[Entity]
}
