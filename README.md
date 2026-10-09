# ARENA – AnnounceTournament (Tic-Tac-Toe Edition)

Simple Java implementation of the **analysis model** for the use case  
**AnnounceTournament** from the textbook  

> Bernd Bruegge & Allen H. Dutoit  
> *Object-Oriented Software Engineering – Using UML, Patterns, and Java* (3rd Edition)

## Scenario
- Game: **Tic-Tac-Toe**
- Number of players: **8**
- Console-based simulation of the complete flow of events (Figure 4-24)
  and the sequence diagrams (Figures 5-26, 5-27, 5-28).

## Project structure (Eclipse / JDK 21)

```
ArenaTicTacToe/
├── src/
│   └── com/
│       └── arena/
│           ├── Main.java
│           ├── boundary/
│           │   └── AnnounceTournamentBoundary.java
│           ├── control/
│           │   └── AnnounceTournamentControl.java
│           └── model/
│               ├── ArenaSystem.java
│               ├── Player.java
│               └── Tournament.java
```

## How to run (Eclipse 2024 / JDK 21)

1. Import the project as an **Existing Projects into Workspace**  
   (or create a new Java project and copy the `src` folder).
2. Make sure the project uses **Java 21**.
3. Run the class `arena.Main`.





