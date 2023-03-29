## LPOO_\<L.EIC03\>\<G01\> - \<Ragnar's journey\>

> The ideia is to have a hero that spawns on a lobby, where he can move to different dungeons. Inside each dungeon there are three rooms and in order to advance to the next one, he has to kill all the monsters and, if he wants, collect  all the coins. The warrior can buy more lives on the shop with a maximum number of lives.<br>
> The project was developed by:<br>
>- Daniel Gago\: 202108791<br>
>- João Padrão\: 202108766<br>
>- Pedro Angélico\: 202108866<br>

### Main idea
![ezgif com-gif-maker](https://user-images.githubusercontent.com/89313201/208412250-c03cf932-fcaf-42fa-a9fa-a7dd5707f2bc.gif)

### UML
![uml](https://user-images.githubusercontent.com/72285606/208432053-81bf103e-bb53-4558-bcd6-a6528b4436a3.png)
### IMPLEMENTED FEATURES
>- **Lake** - Inside the dungeons there are lakes. After leaving the water his colour will change and he can kill a fire monster when he touches it<br>
   ![2](https://user-images.githubusercontent.com/113979321/207180742-a567271b-b5b8-4f43-865c-7a1833d9908d.png)
   ![3](https://user-images.githubusercontent.com/113979321/207180955-cf588ed5-c720-4756-bb41-ef854a56b115.png)

>- **Lobby** - There is a lobby with access to the four different dungeons, to a place that contains a shop and to the warrior's home.
   <br>![lobby](https://user-images.githubusercontent.com/113979321/207171719-b950f714-9519-4901-bec0-e7b2655fcdd9.png)

>- **Dungeons with different rooms** - We implemented multiple dungeons.
   Inside each one we have to kill all the monsters. After that a "door" will open and the player can go to the next room. In the third room,the last one, a "door" will open and the player may leave going back to the lobby.<br>
   ![firedungeon](https://user-images.githubusercontent.com/113979321/207182126-34130857-6343-4c8b-9b4d-e9e984a6def2.png)
   ![4](https://user-images.githubusercontent.com/113979321/207183312-3afa6104-0833-45dc-a021-0f6b0b013f5e.png)
   <br>FireDungeon - Room 1 / FireDungeon - Room 1 (After killing the monsters)
<br><br>![5](https://user-images.githubusercontent.com/113979321/207184798-b5206e9f-ce2a-400c-89e1-33eeeb2d51ec.png)
    ![6](https://user-images.githubusercontent.com/113979321/207184802-55d3f66a-536f-48e3-bac8-5fb9e1a095ac.png)
   <br>MetalDungeon - Room 1 / MetalDungeon - Room 1 (After killing the monsters)
<br><br>![7](https://user-images.githubusercontent.com/113979321/207185563-ebd3d638-99dd-4dcc-9813-1a868727902b.png)
    ![8](https://user-images.githubusercontent.com/113979321/207185568-3c14e18c-0a74-4ecc-b36e-f1bb77966c2f.png)
   <br>WaterDungeon - Room 1 / WaterDungeon - Room 1 (After killing the monsters)
<br><br>![9](https://user-images.githubusercontent.com/113979321/207188173-ec58f45c-277a-4efe-8583-46f4d12eec26.png)
    ![10](https://user-images.githubusercontent.com/113979321/207188198-265fa48b-b411-45c3-9ea9-2e18fa39b7c3.png)
   <br>GrassDungeon - Room 1 / GrassDungeon - Room 1 (After killing the monsters)

>- **Traps** - By pressing a key, the warrior will leave a trap that can kill simple, water, egg (after it's born) and metal monsters that step on it<br>
   ![11](https://user-images.githubusercontent.com/113979321/207192513-a185961c-8331-44fd-8802-2e365846ef1c.png)
   ![12](https://user-images.githubusercontent.com/113979321/207192510-9fd2c797-85cc-4390-aebf-22806b4a8533.png)

>- **Shop** - Inside the shop the warrior can buy more lives with the coins he got inside the dungeons. He can also buy more traps
<br>![shopFoto](https://user-images.githubusercontent.com/113979321/207174961-2777a90c-9525-4f48-af6f-0030382026c1.png)
    ![1](https://user-images.githubusercontent.com/113979321/207176003-58da3acd-c2b7-4500-9490-a6bb41bd2e8c.png)

>- **Trophy** - After completing a dungeon, the player wins the dungeon trophy. He can see  all the trophies inside his house 
<br>![13](https://user-images.githubusercontent.com/113979321/207197203-38e5a4c7-d081-4541-9515-39f94820a6d7.png)
    ![14](https://user-images.githubusercontent.com/113979321/207197206-4716b0bc-93f4-4e6e-bd8c-537be32d4889.png)
<br>![15](https://user-images.githubusercontent.com/113979321/207197210-e20be4da-8fe2-416c-9162-94dee2aa83b3.png)
    ![16](https://user-images.githubusercontent.com/113979321/207197213-fa10a062-1115-4486-b8a1-fd1af8558bec.png)

>- **Different monsters** - There are different types of monsters with specific moves and ways of death:<br>
S - simple monster: In order to kill it, the monster must step on a trap. He has a random move.
<br>F - fire monster: In order to kill it, the player must be wet and touch the monster. The player gets wet when he gets inside the water (his colour will change). He is faster than the simple monsters, but his movements are also random.
<br>W - water monster: In order to kill it, the monster must step on a trap. This monster has two states that alternate with time: 1) his movements are random and similar to the simple monster's movement or 2) he will follow the player will be faster
<br>M - metal monster: In order to kill it, the monster must step on a trap and his movement his similar to the fire monster's movement, however, if the player gets too close, he will change his behaviour and start following the player.
<br>E - egg monster: After some time, the egg will turn into a monster (by changing its colour and start walking), but the player can smash it before a new monster is born by stepping upon it.

## PLANNED FEATURES

All the planned features were successfully implemented.

### DESIGN
#### THE DIFFERENT STATES OF THE GAME

**Problem in Context**<br>
In order to over the different menus (the main one and the one related to the shop) and the Warrior moving actions, we use some keys in common, therefore we would need a lot of conditional logic. This violates the **Single Responsability Principle** because a class should have only one job.<br>

**The Pattern**<br>
We have applied the **State** pattern. This pattern allows you to represent different states with different subclasses. This pattern allowed to address the identified problems because depending on what we want to do (eg. interact with the Menu) we can represent the state with the appropriate subclass.<br>

**Implementation**<br>
These classes can be found in the following files:
- [Game](../src/main/java/com/aor/journey/Game.java)
- [GameState](../src/main/java/com/aor/journey/state/GameState.java)
- [State](../src/main/java/com/aor/journey/state/State.java)
- [MenuState](../src/main/java/com/aor/journey/state/MenuState.java)
- [PlaceState](../src/main/java/com/aor/journey/state/PlaceState.java)

The following figure shows how the pattern’s roles were mapped to the application classes.<br>
![state](https://user-images.githubusercontent.com/72285606/207186038-d7db557d-dcbe-45ef-99fa-49ed4b7a75a0.png)

**Consequences**<br>
The use of the State Pattern in the current design allows the following benefits:

- The state transitions become explicit;
- We can avoid a long set of conditional logic statements associated with the various states by using polimorphism to activate the right behavior;
- We have more classes and instances to manage.<br>
---
#### WARRIOR MUST REMAIN THE SAME

**Problem in Context**<br>
The Warrior needs to store some attributes like lives and coins, which must remain the same through all different states.

**The Pattern**<br>
We have applied the **Singleton** pattern. This pattern allows us to only create one instance of the Warrior at a time.

**Implementation**<br>
These class can be found in the following file:
- [Warrior](../src/main/java/com/aor/journey/model/game/elements/Warrior.java)

The following figure shows how the pattern’s roles were mapped to the application classes.<br>
![image](https://user-images.githubusercontent.com/72285606/207193273-bde67c86-c520-482b-9511-d3efbaebf87d.png)

**Consequences**<br>

The use of the Singleton Pattern in the current design allows the following benefits:

- We don't need to worry about creating a new warrior every time we enter a new room;
- When the warrior dies, we can simply reset it's instance.<br>

---
#### DIFFERENT PLACES CONTAIN DIFFERENT ELEMENTS

**Problem in Context**<br>
Each Place contains different elements. 
The lobby only contains portals and walls but the room contains monsters and coins, for example.

**The Pattern**<br>
We have applied the **Decorator** pattern, in order to attach additional responsibilities to an object dynamically.

**Implementation**<br>
These class can be found in the following file:
- [Viewer](../src/main/java/com/aor/journey/viewer/Viewer.java)
- [PlaceViewer](../src/main/java/com/aor/journey/viewer/game/places/PlaceViewer.java)
- [ConcretePlaceViewer](../src/main/java/com/aor/journey/viewer/game/places/ConcretePlaceViewer.java)
- [HomeDecorator](../src/main/java/com/aor/journey/viewer/game/places/HomeDecorator.java)
- [LobbyDecorator](../src/main/java/com/aor/journey/viewer/game/places/LobbyDecorator.java)
- [PlaceDecorator](../src/main/java/com/aor/journey/viewer/game/places/PlaceDecorator.java)
- [RoomDecorator](../src/main/java/com/aor/journey/viewer/game/places/RoomDecorator.java)
- [ShopDecorator](../src/main/java/com/aor/journey/viewer/game/places/ShopDecorator.java)

The following figure shows how the pattern’s roles were mapped to the application classes.<br>
![image](https://user-images.githubusercontent.com/72285606/207918166-9baa6afd-3351-44ce-9473-3774a282fde7.png)


**Consequences**<br>
The use of the Decorator Pattern in the current design allows the following benefits:
- Avoid classes with too many features and responsibilities;<br>
- More flexibility than static inheritance.

---
#### NOT ALL MONSTERS ARE CREATED EQUAL

**Problem in Context**<br>
Each monster is different, both in the way it dies and the way it moves. Each one as a concrete move and collision.

**The Pattern**<br>
We have applied the **Strategy** pattern on Move and on Collision.
This pattern allowed us to define a family of algorithms, encapsulate each one, and make them interchangeable.

**Implementation on the movement of the monsters**<br>
These class can be found in the following file:
- [Move](../src/main/java/com/aor/journey/behaviour/move/Move.java)
- [FastFollowMove](../src/main/java/com/aor/journey/behaviour/move/FastFollowMove.java)
- [FollowMove](../src/main/java/com/aor/journey/behaviour/move/FollowMove.java)
- [HatchingMove](../src/main/java/com/aor/journey/behaviour/move/HatchingMove.java)
- [RandomMove](../src/main/java/com/aor/journey/behaviour/move/RandomMove.java)

**Implementation on the collision of the monsters**<br>
These class can be found in the following file:
- [Collision](../src/main/java/com/aor/journey/behaviour/collision/Collision.java)
- [SimpleCollision](../src/main/java/com/aor/journey/behaviour/collision/SimpleCollision.java)
- [SmashCollision](../src/main/java/com/aor/journey/behaviour/collision/SmashCollision.java)
- [WaterCollision](../src/main/java/com/aor/journey/behaviour/collision/WaterCollision.java)


The following figure shows how the pattern’s roles were mapped to the application classes.<br>
![image](https://user-images.githubusercontent.com/72285606/207919371-e40ed603-8b67-446b-a2b7-5cb4e095be34.png)


**Consequences**<br>
- We can create many related monsters that differ only on their behaviour;
- Eliminates conditional statements; 
- Provides different implementations.

---
#### ARCHITECTURAL PATTERN

**Problem in Context**<br>
It is relevant to choose the appropriate architecture of the project because it is extremely hard to change it later in development.<br>

**The Pattern**<br>
We have applied the **MVC**  (Model–View–Controller) design pattern with the following division:
- Controller: Processes all changes of the game
- View: Sends user actions to the controller and displays the model
- Model: Represents the data<br>

**Implementation**<br>
We have three directories that represent one of the MVC elements: [Model](https://github.com/FEUP-LDTS-2022/project-l03gr01/tree/main/src/main/java/com/aor/journey/model) [View](https://github.com/FEUP-LDTS-2022/project-l03gr01/tree/main/src/main/java/com/aor/journey/viewer) [Controller](https://github.com/FEUP-LDTS-2022/project-l03gr01/tree/main/src/main/java/com/aor/journey/controller)

**Consequences**<br>

The use of the MVC design pattern in the current design allows the following benefits:

- High cohesion;
- Better readability and testability;
- Easy for future modifications.<br>

## Known Code Smells And Refactoring Suggestions
#### **Data Class**
Due to the **MVC** (Model-View-Controller) architectural pattern there are some classes which only have data fields, however the only reason for that has to do with de chosen design pattern.

#### **Switch Statements**
We use some conditional logic when deciding the type of dungeon (in class Dungeon) and inside the MonsterViewer class. We have decided to do this way, so that we could avoid the creation of multiple classes whose only purpose would be to make some action according to the dungeon type or to the monster type and therefore making our code simpler.  

#### **Alternative Classes with Different Interfaces**
The different types of monsters are based on their type of move and collision. Each one has a class and inside it he passes these parameters to its parent (class Monster) and we have decided to do this way, in order to be easier to create new types of monsters with different behaviours making the game expansible.

#### **Feature envy**
This can be seen inside some controller classes, for instance in the MonsterController and in the ShopController, because their method access more data from the model than from its own data. This is another consequence of the use of the **MVC** (Model-View-Controller).

#### **Large Class**
Some classes, for example the Warrior class, contain many fields and many methods. We have decided that it wouldn't be justifiable to separate these data fields or methods by using the extract method, because these fields and methods should remain together and it wouldn't make any sense otherwise.


### TESTING

- Screenshot of coverage report.
##### COVERAGE
![teste1](https://user-images.githubusercontent.com/113979321/208440287-655fe210-49eb-4b58-8b73-5bb88908597a.png)
##### Tests for control
![teste2](https://user-images.githubusercontent.com/113979321/208440617-5ee32b43-7745-477a-91d9-7eead01203a7.png)
##### Tests for view
![teste3](https://user-images.githubusercontent.com/113979321/208441013-3f428d70-4884-42fe-878a-e4fddc26b7cd.png)
##### Tests for model
![teste4](https://user-images.githubusercontent.com/113979321/208441399-0df0f280-446b-4bc7-b63c-5eb6baf202f2.png)
##### Tests for state
![teste5](https://user-images.githubusercontent.com/113979321/208441677-4265d613-b364-4e76-9adb-06dbfe772e51.png)
##### Tests for behaviour
![teste6](https://user-images.githubusercontent.com/113979321/208441968-fa25409f-02ab-4963-836c-ee980d41b2a6.png)

- [Link](https://github.com/FEUP-LDTS-2022/project-l03gr01/tree/main/pit-report) to mutation testing report.

### Observations of the test coverage and mutants:
- Some classes are trivial, therefore they do not need to be tested (e.g. game and application)
- Some methods are trivial, therefore they do not need to be tested (e.g. method isEmpty and isMonster)
- It is hard to test some classes that work with random values (e.g. HatchingMove), once one of the principles of testing is: "The results of tests should be deterministic"
- We only test the RoomBuilder to analyse if it reads the file properly and do not the other builders, once they are similar
- We only test some branches of some methods for the same reason above (e.g. teleport)
- It is unnecessary to test states given that they only have getters to their viewers and controllers
- Inside decorators, we do not call the ConcretePlaceViewer because it was already tested separately
- It is unnecessary to test the LanternaGUI class since it is an external package and so it does not have the need to be tested

### SELF-EVALUATION

>- Daniel Gago\: 33\% <br>
>- João Padrão\: 33\%<br>
>- Pedro Angélico\: 33\%<br>
