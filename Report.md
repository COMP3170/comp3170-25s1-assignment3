# COMP3170 Assignment 1 Report
### Student Name: [Your name here]
### Student ID: [Your ID here]

## Your Development Environment
|Spec|Answer|
|----|-----|
|Java JDK version used for compilation|-|
|Java compiler compliance level used for compilation|-|
|Java JRE version used for execution|-|
|Eclipse version|-|
|Your screen dimensions (width x height)|-|
|Your computer type (Mac/PC)|-|
|Your computer make and model|-|
|Your computer Operating System and version|-|

## Features Attempted
Complete the table below indicating the features you have attempted. This will be used as a guide by your marker for what elements to look for, and dictate your <b>Completeness</b> mark.

| Feature | Weighting | Attempted Y/N |
|---------|-----------|---------------|
| General requirements | 3% | - |
| Debug - Wireframe mode | 3% | - |
| Debug - Normals mode | 3% | - |
| Debug - UV mode | 3% | - |
| Boat - Mesh | 3% | - |
| Boat - Normals | 3% | - |
| Boat - UVs & Textures | 4% | - |
| Boat - Spinning Fan | 4% | - |
| Boat - Movement | 4% | - |
| Height Map - Mesh | 4% | - |
| Height Map - Normals | 4% | - |
| Height Map - UVs & Textures | 4% | - |
| Height Map - Texture blending | 4% | - |
| Water - Mesh & Normals | 2% | - |
| Water - Transparency | 4% | - |
| Water - Ripples | 4% | - |
| Water - Fresnel effect* | 4% | - |
| Lighting - Sun | 8% | - |
| Lighting - Headlamp | 8% | - |
| Cameras - Third-person | 4% | - |
| **Total** | 80% | - |

# Documentation

Documentation is marked separately from implementation, but should reflect the approach taken in your code. You can attempt documentation questions for features you have not implemented or completed, but should clearly indicate that this is the case.

Documentation should include both diagrams and relevant equations to explain your solution. **Note**: Merely copying images from the lecture notes or other sources will get zero marks (and may be treated academic misconduct).

Where requested, meshes should be drawn to scale in model coordinates, including:
* The origin
* The X and Y axes
* The coordinates of each vertex
* The triangles that make the mesh

## Scene Graph (2%)

* Include a drawing (pen-and-paper or digital) of the scene graph used in your project.

## Height Map (6%)

* Illustrate how you construct the height map mesh, including both the vertex positions and index buffer, using a 3x3 example. (3%)

* Explain how you calculate the normal for one vertex in your mesh. Provide an appropriate diagram as well as the relevant equations used in the calculation. (3%)

## Water - Ripples (3%)

* Explain how fragment normal is calculated for the water surface, to implement the ripple effect. Provide an appropriate diagram as well as the relevant equations used in the calculation. (3%)

## Lighting (6%)

* Explain how the day-time lighting value for a point on the height map is calculated, using the third-person camera. Provide an appropriate diagram as well as the relevant equations used in the calculation. (3%)

* Explain how the night-time lighting value for a point on the height map is calculated, using the third-person camera. Provide an appropriate diagram as well as the relevant equations used in the calculation. (3%)

## Camera (3%)

*  Illustrate how you calculate the position and view volume of the third-person camera. (3%)