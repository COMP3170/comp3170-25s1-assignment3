# COMP3170 25s1 Assignment 3

## Contents
- [COMP3170 25s1 Assignment 3](#comp3170-25s1-assignment-3)
  - [Contents](#contents)
- [Learning Outcomes](#learning-outcomes)
- [Deliverables](#deliverables)
- [Group work](#group-work)
- [Features](#features)
  - [General requirements](#general-requirements)
  - [Debug - Wireframe mode](#debug---wireframe-mode)
  - [Debug - Normals mode](#debug---normals-mode)
  - [Boat](#boat)
    - [Mesh \& Normals](#mesh--normals)
    - [UVs \& Textures](#uvs--textures)
    - [Spinning Fan](#spinning-fan)
    - [Movement](#movement)
  - [Height Map](#height-map)
    - [Mesh](#mesh)
    - [Normals](#normals)
    - [UVs \& Textures](#uvs--textures-1)
    - [Texture blending](#texture-blending)
  - [Skybox](#skybox)
    - [Mesh \& Textures](#mesh--textures)
    - [Rotation](#rotation)
  - [Water](#water)
    - [Mesh \& Normals](#mesh--normals-1)
    - [Transparency](#transparency)
    - [Ripples](#ripples)
    - [Skybox Reflections\*](#skybox-reflections)
    - [Fresnel effect\*\*](#fresnel-effect)
  - [Lighting](#lighting)
    - [Day - Sun](#day---sun)
    - [Headlamp](#headlamp)
  - [Cameras](#cameras)
    - [Map view](#map-view)
    - [Third-person view](#third-person-view)
- [Documentation](#documentation)
- [Submission](#submission)
- [Marks](#marks)
  - [Rubrics](#rubrics)
    - [Code](#code)
    - [Documentation](#documentation-1)

# Learning Outcomes

* **ULO 1**: Understand the fundamentals of vector geometry and employ them in devising algorithms to achieve a variety of graphic effects.  
* **ULO 2**: Program 2D and 3D graphical applications using OpenGL embedded in a programming language (such as OpenGL in Java)
* **ULO 3**: Apply vector geometry to implement and combine 3D transformations including rotation, translation, scale and perspective. 
* **ULO 4**: Program vertex and fragment shaders to implement effects such as lighting, texturing, shadows and reflections. 

This assignment covers the following topics:
* 3D modelling with triangular meshes
* 3D Transformations
* Perspective & Orthographic cameras
* Viewport & Scissor rectangles
* Fragment shaders
* Illumination and shading
* Texturing

# Deliverables

You are required to submit:
* An Eclipse project based on the framework provided in this repository, implementing the features listed below.
* A report, based on the Report.md template provided in this repository, describing the implementation of these features.
* Individual peer assessment, via link provided on iLearn.

# Group work

This is two-person assignment. You should make sure to select a partner using the group selection link on iLearn as soon as possible. Individual submissions will not be accepted.

Both partners are expected to contribute equally to the implementation and documentation deliverables. Peer assessment and evidence of contributions in GitHub will be used to assign individual grades (see [Marking](#marking) below).

# Features

Your project will implement a 3D showing a hovercraft around a set of islands. 

Your mark will be based on the features you implement, from the table below. Each feature has a mark value attached. The more challenging elements are marked with an asterisk*. 

Some features include a documentation requirement, which should be included in your [report](#report) (below). Documentation requirements are marked separately.

Features are described in detail below. Example screenshots & video will be provided on iLearn.

| Feature | Marks |
|---------|-------|
| Debug - Wireframe mode | % |
| Debug - Normals mode | % |
| Boat - Mesh & Normals | % |
| Boat - UVs & Textures | % |
| Boat - Spinning Fan | % |
| Boat - Movement | % |
| Height Map - Mesh | % |
| Height Map - Normals | % |
| Height Map - UVs & Textures | % |
| Height Map - Texture blending | % |
| Skybox - Textures | % | 
| Skybox - Rotation | % | 
| Water - Mesh & Normals | % |
| Water - Transparency | % |
| Water - Ripples | % |
| Water - Skybox Reflections* | % |
| Water - Fresnel effect* | % |
| Lighting - Sun | % |
| Lighting - Headlamp | % |
| Cameras - Map | % |
| Cameras - Third-person | % |

## General requirements

Your scene should be implemented using:
* Anti-aliasing using 4x multisampling.
* Backface culling
* Mipmaps for all textures (with trilinear filtering)
* Gamma correction (with a default gamma of 2.2)

World space should be oriented so that the the j axis (i.e. the y coordinate) points upwards. The directions of the i and k axes can be set as you deem appropriate. For all world-unit calculations, 1 unit in world space should be equal to 1 metre. 

## Debug - Wireframe mode
* Pressing ‘B’ should toggle between filled and wireframe views of all the meshes in the scene. 

## Debug - Normals mode
* Pressing ‘N’ should toggle on and off a mode in which all objects are shaded to display their normals in world coordinates (using a normal matrix), where the RGB colour values are equal to the normal coordinates (r,g,b) = (n_x,n_y,n_z).

## Boat 

The boat model is provided as a Wavefront OBJ file `boat.obj`. The mesh includes vertex positions, normals and UVs. An example `Boat.java` class has been provided to illustrate how to access this mesh data using one of these sub-meshes using the `Model.java` class provided.

### Mesh & Normals

* The boat should initially be drawn at the centre of the map, so that it sits on the water, partly immersed.

### UVs & Textures

* •	Texture coordinates (UVs) for the boat are specified in the mesh. You should use these coordinates to texture each part using the `boat.png` texture provided.

### Spinning Fan

A fan model is provided as a Wavefront OBJ file `fan.obj`. 

* Using the scene graph, attach the fan to the boat at position FIXME (in the boat's model space).
* The fan should be animated to spin appropriately around its axis.

### Movement

The boat should be controlled using the WASD keys:
* Holding 'W' and 'S' should cause the boat to move forwards / backwards.
* Holding 'A' and 'D' should cause the boat to turn left / right.

## Height Map

The islands should be generated using the height map image `islands.png`, shown below. Each pixel in the image represents the terrain height at a particular point in x/z coordiantes. Height values vary from 0 to 1. A template `HeighMap.java` class has been provided to read the data from this image file.

### Mesh

* Constuct a height map mesh based on this data. The mesh structure should match the examples given in the week 5 lecture.
* Scale the mesh so the terrain is 100m by 100m. The height of the mesh should be scaled so the a height value of 1 corresponds to a terrain height of 50m. 
* **Document**: Illustrate how you construct the height map mesh, including both the vertex positions and index buffer, using a 3x3 example.

### Normals

* Vertex normals should be calculated for each vertex in the mesh, following the method discussed in the week 9 workshop. 
* **Document**: Explain how you calculate the normal for one vertex in your mesh. Provide an appropriate diagram as well as the relevant equations used in the calculation.

### UVs & Textures

* Appropriate vertex UVs should be assigned for each vertex in the mesh.
* One unit of texture space should map to 1m of world space.
* The `terrain-grass.png` texture should be used to colour the mesh.

### Texture blending

* Parts of the terrain below the water level should be textured using the `terrain-sand.png` texture.
* At the water level, there should be a smooth transition from sand to grass.

## Skybox 

The project should implement day and night modes. Texture files for day and night skyboxes have been provided as `skybox-day` and `skybox-night`.

* Pressing the 'M' key should switch between day and night modes.
* If skyboxes are not implemented, the background colour should switch between blue and black to indicate each mode.

### Mesh & Textures

* A skybox mesh should be implemented.
* The appropriate skybox should be used in each mode.
* Skyboxes should follow the camera and be rendered behind all other scene objects.
* **Document**: Explain how the skybox position is calculated to correctly follow the camera.
* **Document**: Explain how the texture coordinates and depth are calculated for a particular fragment on the skybox.

### Rotation

* Pressing the ',' and '.' keys should rotate the skybox to the west / east.

## Water

### Mesh & Normals

* A flat water mesh should be created as a single quad that covers the entire 100m x 100m terrain, at a height of 20m.
* The mesh should include appropriate vectors normals.
* The mesh should be coloured a suitable shade of cyan (blue-green).

### Transparency

* The water mesh should be semi-transparent, so underwater objects are visible.

### Ripples

* Fragment normals for the water should be calculate in the shader to implement a ripple effect that affect lighting and reflection features (below). 
* This should be implemented without adjusting vertex positions or normals.
* Ripples should be animated to move at constant speed across the surface of the water.
* **Document**: Explain how this normal is calculated for one fragment. Provide an appropriate diagram as well as the relevant equations used in the calculation.

### Skybox Reflections*

* The water surface should implement cube map reflections, to reflect the skybox (but not the boat or terrain).
* If ripples are implemented, the ripples should affect reflections appropriately.
* **Document**: Explain how the reflected colour value is calculated.

### Fresnel effect**

In real-world physics, surfaces are more reflective when viewed at oblique angles and more transparent when viewed straight on. This effect is described by the [Fresnel equations](https://en.wikipedia.org/wiki/Fresnel_equations), but they are rather complicated. We can simulate a simpler effect using the equation:
$$t = \max(0,1 - (v.n))$$
$v$ is the view direction and $n$ is the fragment normal. 

* Use this equation to linearly interpolate between suitable minimum and maximum alpha values on the water mesh, so it is transparent if you look straight down, but reflective if you look along the surface.

## Lighting

There are two lighting modes depending on whether day or night mode is active (see [Skybox](#skybox) above).

Each light mode should implement:
* Ambient lighting on all meshes.
* Diffuse lighting on all meshes.
* Specular lighting on the water surface.

Ambient light levels in each mode should be high during the day and low at night.

### Day - Sun

* In day mode, lighting should use a directional light source based on the position of the sun.
* The source vector for the sun should rotate to match the rotation of the day skybox. If the skybox isn't implemented, then the vector should simply rotate east-to-west using the ',' and '.' keys.
* **Document**: Illustrate how the day-time lighting value for a point on the height map is calculated, for the third-person camera.

### Headlamp

* In night mode, lighting should use a point light source based centred at the front of the boat at position FIXME in model coordinates.
* This light should only affect objects in front of the light source. 
* **Document**: Illustrate how the night-time lighting value for a point on the height map is calculated, for the third-person camera.

## Cameras

There are two different main camera modes: Map and Third person, which can be activated using the `1` and `2` keys respectively. 

**Note**: Make sure you correctly implement the view vector in your lighting based on whether the camera is orthographic or perspective.

### Map view

* The map camera is a top-down orthographic view of the map.
* Resizing the window should make the map larger or smaller.
* *The map should be centred in the window.
* Pressing the 'Page up' and 'Page down' keys should zoom the camera in and out between sensible minimum and maximum values. 
* If the aspect of the window does not match the aspect of the map, then the scissor rectangle should be set so that black bars should be drawn on the left and right or top and bottom depending on whether the window is too wide or too tall.
* Near and far planes should be set so the entire map is visible 
* **Document**: Illustrate the viewport and scissor rectangle for this camera for windows with aspect ratios 2:1 and 1:2. Label the corners of each rectangle with coordinates in NDC, World and Viewport coordinates

### Third-person view

* The third-person camera is a perspective camera that follows the boat from an external point of view.
* The camera should always face towards the boat’s position in world space and maintain a constant distance from the boat’s origin.
* The arrow keys should control the yaw and pitch of the camera
    - Pressing left and right should rotate the camera clockwise and anticlockwise around the boat, respectively.
    - Pressing up and down should pitch the camera up and down, to a maximum of plus or minus 90 degrees (i.e straight up or straight down).
* Pressing the 'Page up' and 'Page down' keys should zoom the camera in and out (i.e. change the field of view of the camera) between sensible minimum and maximum values. 
* Resizing the window should change the aspect of the camera view volume to match.
* Near and far planes should be set so the entire boat is visible, as well as some of the surrounding landscape.
* **Document**: Illustrate how you calculate the position and view volume of the third-person camera.

# Documentation

You should complete the `Report.nd` template included in the project. The report should include:
* A completed table indicating the features you have attempted
* Responses to each of the documentation requirements for the features described above.
  
Documentation is marked separately from implementation, but should reflect the approach taken in your code. You can attempte documentation questions for features you have not implemented or completed, but should indicate that this is the case.

Documentation should include both diagrams and relevant equations to explain your solution. 

**Note**: Merely copying images from the lecture notes or other sources will get zero marks (and may be treated academic misconduct).

# Submission

Both the Eclipse project and report will be submitted using this GitHub repository. Make sure to commit and push your work before the submission deadline. Any commits made after this deadline will be treated as late and standard late penalties will be applied (see the COMP3170 Unit Guide for details). Only work in the `main` branch of your repository will be marked. 

Individual peer assessment should be submitted via the quiz on iLearn. Both team members need to complete this quiz. You each need to provide a grade (following the rubric given in the template) and a justification for the grade. This grade will be kept private from your teammate but will be used as evidence to determine the individual grades.

# Marks

Each of the above components will be individually marked on the rubric below. The total sum of these marks will give you your mark out of 100 for the task (80 for code, 20 for documentation). Marks will not be awarded for elements not meaningfully implemented.

Individual marks will be assigned based on peer assessment and evidence of contributions from the GitHub commit history. Both team members will be given the same mark unless there is evidence of a significant discrepancy between contributions.

## Rubrics

### Code
Each feature attempted by you will be marked using the rubric below.
|Criteria|Grade|Description|
|-|-|-|
|Correctness|HD (100)|Code relevant to feature is free from any apparent errors. Problems are solved in a suitable fashion. Contains no irrelevant code.|
||D (80)|Code relevant to feature has minor errors which do not significantly affect performance. Contains no irrelevant code.|
||CR (70)|Code relevant to feature has one or two minor errors that affect performance. Problems may be solved in ways that are convoluted or otherwise show lack of understanding. Contains some copied code that is not relevant to the problem.|
||P (60)|Code relevant to feature is functional but contains major flaws. Contains large passages of copied code that are not relevant to the problem.|
||F (0-40)|Code relevant to feature compiles and runs, but major elements are not functional.|
|Clarity|HD (100)|Good consistent style. Well structured & commented code relevant to feature. Appropriate division into classes and methods, to make implementation clear.|
||D (80)|Code relevant to feature is readable with no significant code-smell. Code architecture is adequate but could be improved.|
||CR (70)|Code relevant to feature is readable but has some code-smell that needs to be addressed. Code architecture is adequate but could be improved.|
||P (60)|Significant issues with quality of code relevant to feature. Inconsistent application of style. Poor readability with code-smell issues. Code architecture could be improved.|
||F (0-40)|Significant issues with quality of code relevant to feature. Inconsistent application of style. Poor readability with code-smell issues. Messy code architecture with significant encapsulation violations.|

### Documentation
Each component of your documentation will be marked using the rubric below.

|Grade|Description|
|-|-|
|HD (100)|Illustrations are neat, clear and well annotated. Relevant equations are provided and clearly annotated. No discrepancies between explanation and code (except as noted).|
|D (80)|Illustrations are neat and clear. Relevant equations are provided. No discrepancies between explanation and code (except as noted).|
|CR (70)|Minor sloppiness or missing detail. Equations are provided but include minor inaccuracies. Minor discrepencies between documentation and code.|
|P (60)|Significant sloppiness or missing detail. Equations are provided but include major inaccuracies. Values in illustrations show understanding of task, but may not reflect code.|
|F (0-40)|Illustrations are unclear and badly drawn. Does not make use of graph paper. Equations are not provided or are not relevant to explanation.|

