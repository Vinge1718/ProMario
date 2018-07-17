# PROJECT NAME
ProMario

# CREATED BY 
- Victor Kinge
- Agnes Kavata
- Stewart Milimu

copyright 2018

# ABOUT
- An arcade game that not only is for fun but also for learning.
- The  game is designed with various levels that let the player run through a virtual world through obstacles gaining points 
  by collecting coins and solving programming questions.

# TECHNOLOGIES USED
## Java
## Android studio
## LibGdx
## Tiled 
## GDX texture packer

# SETUP AND INSTALLATIONS
## Minimum:
- Java Development Kit 8+ (Must be JDK)
- (Recommended) Intellij IDEA 2018.1.3, (community edition is sufficient) (https://www.jetbrains.com/idea/download/#section=windows)
- Android Studio, 3.1.2 (https://developer.android.com/studio/ )

## Android:
- Android SDK (If using IDEA) (https://developer.android.com/studio/#downloads )
- Set the ANDROID_HOME environment variable, or use gradle.properties

# Creating a LibGDX project
Download LibGDX project setup tool (https://libgdx.badlogicgames.com/nightlies/dist/gdx-setup.jar)
## Open up your command line tool, go to the download folder and run the following command
### java -jar gdx-setup.jar

fill in the following in th eopen window
### Name
Name of your project
### Package
Java package for your application, usually a domain you own
### Game class
The main game class Name
### Destination
Destination for project generation
### Android SDK
Path to your Android SDK

### SubProjects
Select which subprojects you want to generate. These are the platforms you'd like to target.

### Extensions
Select the extensions you want included in your project. The LibGDX maintained extensions area shown on the main page, they include:

### Bullet: 
3D Collision Detection and Rigid Body Dynamics Library.
### FreeType Scallable font. 
Great to manipulate font size dynamically. However be aware that it does not work with HTML target if you cross compile for that target.
### Tools Set of tools including: 
particle editor (2d/3d), bitmap font and image texture packers.
### Controller Library 
to handle controllers (e.g.:XBox 360 controller).
### Box2d: 
Box2D is a 2D physics library.
### Box2dlights: 
2D lighting framework that uses box2d for raycasting and OpenGL ES 2.0 for rendering.
### Ashley:
A tiny entity framework.
### Ai: 
An artificial intelligence framework.

## Gradle
   Gradle is a dependency management and build system. A dependency management system is an easy way to pull in 3rd party libraries into your project, without having to store the libraries in your source tree. Instead, the dependency management system relies on a file in your source tree that specifies the names and versions of the libraries you need to be included in your application. Adding, removing and changing the version of a 3rd party library is as easy as changing a few lines in that configuration file. The dependency management system will pull in the libraries you specified from a central repository (in our case Maven Central) and store them in a directory outside of your project. A build system helps with building and packaging your application, without being tied to a specific IDE. This is especially useful if you use a build or continuous integration server, where IDEs aren't readily available. Instead, the build server can call the build system, providing it with a build configuration so it knows how to build your application for different platforms. In case of Gradle, both dependency management and build system go hand in hand. Both are configured in the same set of files.
