#version 110

attribute vec2 aVertexPosition;
attribute vec4 aVertexColor;

uniform mat3 uTransformMat;
uniform mat3 uProjectionMat;

varying vec4 vColor;

void main(void) {
  vec3 pos = vec3(aVertexPosition, 1.0);
  vColor = aVertexColor;
  gl_Position = vec4(uProjectionMat * uTransformMat * pos, 1.0);
}
