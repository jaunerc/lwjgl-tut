#version 110

attribute vec2 aVertexPosition;
uniform mat3 uTransformMat;

void main(void) {
  vec3 pos = vec3(aVertexPosition, 1.0);
  gl_Position = vec4(uTransformMat * pos, 1.0);
}
