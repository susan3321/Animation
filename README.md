# Animation
Final Project for [CS5004] Object-Oriented Design at Northeastern University

Instructor: John Wilder

# Introduction
Animation graphs can be used to show useful trends in data, for example, a fireworks display is simply a bunch of points moving in certain ways. During this final project, we implemented an easy Animation by Java.

## MVC:

Models:

There are two main parts of classes in the first part of the model:
1.	Motion
2.	Shapes

Besides the above classes, there are another three classes: Animation Builder impl, Animation model and Animation Reader will implement the animation and return the status of the animation with the list of shapes.

View:

There are three parts of view, the text view, the animation view and the SVG view. They all implements the common interface IView and override the display method accordingly

Controller:

Controller includes the start method that used to controll the showing of different views: visual view, text view and svg view. Buttons will be showed in the view and connected to controller from the Animation view.


## Developer:
Susan Yang

Xinyao Liu


## Tech Stack
Java



