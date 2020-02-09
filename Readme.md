# Read Me First

This is a simple tank battle game. 

# Getting Started

Before you start you should first read this document to have a base knowledge about the game.
If you need more details please use help command.

Before you start
- please compile project using mvn clean install
- go to target directory
- run java -jar tanks-warefare-0.0.1-SNAPSHOT.jar

Steps to start a game

-  Use 'start' to create new game with randomly generated world map (start --hard used to generate very hard mode)
-  Use 'create-character' to create new character for the game
-  Use 'list-vehicle' to get list of available tanks
-  Use 'buy vehicle' to by one of the tanks using the number from the list
-  Remember to 'save' every time you do anything.
-  If you want to get previous game use 'load' command

More details available under help. 

# Game rules
- There are randomly generated enemies on map
- You need to explore to move your tank to specified position
- When you move to specfied square you need to use command to check if enemy exists - the assumption is that all vehicles are hidden to each other.
- If you find enemy you can proceed to battle
- When battle begins you and your and enemy armor will be decreased by the amount of randomly generated value
- You will also get experience after battle - which is visible in you characters profile

### Special price for you

If you want to get information about hidden tanks in world map use 'explore-debug' with password
Password is my surname only lowercase no polish letters
