package com.ewgenius.xonix.engine.components

import com.badlogic.ashley.core.Component
import com.badlogic.gdx.math.{Quaternion, Vector3}

class MovementComponent extends Component {
  var velocity: Vector3 = new Vector3()
  var acceleration: Vector3 = new Vector3()
}
