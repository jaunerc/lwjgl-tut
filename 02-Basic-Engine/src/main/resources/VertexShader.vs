#version 110

attribute vec2 aVertexPosition;
uniform mat3 uTransformMat;
uniform mat3 uProjectionMat;

void main(void) {
  vec3 pos = vec3(aVertexPosition, 1.0);
  gl_Position = vec4(uProjectionMat * uTransformMat * pos, 1.0);
}
