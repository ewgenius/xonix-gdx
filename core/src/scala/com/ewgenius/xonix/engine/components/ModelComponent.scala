package com.ewgenius.xonix.engine.components

import com.badlogic.ashley.core.Component
import com.badlogic.gdx.graphics.g3d.{Shader, ModelInstance}
import com.badlogic.gdx.graphics.glutils.ShaderProgram

class ModelComponent extends Component {
  var modelInstance: ModelInstance = null
  var shader: Shader = null
}
