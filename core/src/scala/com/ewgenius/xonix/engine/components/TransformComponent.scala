package com.ewgenius.xonix.engine.components

import com.badlogic.ashley.core.Component
import com.badlogic.gdx.math.{Quaternion, Vector3}

class TransformComponent extends Component {
  var position: Vector3 = new Vector3()
  var scale: Vector3 = new Vector3(1, 1, 1)
  var orientation: Quaternion = new Quaternion()
}
