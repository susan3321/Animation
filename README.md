# Animation
## Final Project for [CS5004] Object-Oriented Design at Northeastern University
## Instructor: John Wilder

# Introduction

## Part 1 of models:
There are two main parts of classes in the first part of the model:
1.	Motion
2.	Shapes

### Motion:
Motion includes the interface for motion and implementation of motion. Motion constructs by the start point and endpoint of elements' time, x-position, y-position, width, height, and colors. Motions provided methods to get each component.

### Shapes:
Shapes include the interface for the abstract shape IShape, and the abstract class shape, and two derived classes that extend from the abstract shape: Rectangle and Circle. Abstract shape will construct by the shape type, x, y, width, height, and colors. Shapes provided methods to get each component. Abstract shape also includes the function that sets the values of elements by the given values. Rectangle extends the abstract shape and will construct a rectangle; circle extends the abstract shape and will construct a circle. Both the derived classes have additional attributes that are used to present the type of the shape.


## Part 2 of models:
Besides the above classes, there are another three classes: Animation Builder impl, Animation model and Animation Reader will implement the animation and return the status of the animation with the list of shapes.

### Animation reader:
Animation reader was provided and the main purpose is to read the data from the .txt file to get the list of data needed for implementation.

### Animation builder:
Animation builder impl implements the interface of Animation Builder that was provided. Animation builder will set the bound of the board, declare the shape of the element and add the motion to the animation motions.

### Animation model:
Animation model constructs the animation model includes the data of the board and the list of motions and shapes. For the get state method, time is the input. Get state method includes a for loop for each key of shapes and each motion corresponding to the key. If any motion occurs in the given time, the related shape of the motion will update all memebers' values using the calculated value at the current time state. At the end of the loop, the get state method in the animation model will return the Array list of shapes that should appear in the view.


## View:
There are three parts of view, the text view, the animation view and the SVG view. They all implements the common interface IView and override the display method accordingly.

### Animation view:
The AnimationPanel initialize the drawing panel and draws the shapes at each time of an animation produced by the model. The Animation View set the drawing panel and add buttons on it. It draws the animation automatically when called by the user, and can give reaction if certain button is pressed.

### Text view:
TextView is able to produce a textual description which contains the information of the shape objects at certain time interval that are generated by the model. The description includes the type of the shape, its color, X, Y, width and height.

### SVG view:
SVGView produces SVG style code based on the string outputs from the TextView. It gathers the parameters for the color, X, Y, width and height, as well as the type, then rephrase it into one SVG style sentence. Finally the state of shapes at all time intervals will be translated into one SVG style sentence each. They will be append with the header and footer to generate an overall SVG file.


## Controller:
Controller includes the start method that used to controll the showing of different views: visual view, text view and svg view. Buttons will be showed in the view and connected to controller from the Animation view.

## Developer:
Susan Yang
Xinyao Liu

## Tech Stack
Java



