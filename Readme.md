# 🧙‍♂️ Swingy – Java RPG Game

## 🎮 Description

**Swingy** is the second project in the Java module at 42.  
The goal is to build a text-based RPG game with a graphical interface using the **Swing** framework.

Through this project, I learned how to:
- Develop GUI applications in Java
- Structure a game with multiple states (menu, map, combat, victory…)
- Implement both **console** and **graphical** modes
- Manage character stats, equipment, and progression

<p float="left">
<img src="menu.png" alt="drawing" width="250"/>
<img src="select.png" alt="profil" width="250"/>
<img src="fight.png" alt="projects" width="250"/>
<img src="accessories.png" alt="skills" width="250"/>
<img src="victory.png" alt="drawing" width="250"/>
<img src="winner.png" alt="drawing" width="250"/>
<img src="map.png" alt="drawing" width="250"/>
</p>

---

## 🛠️ Technologies

- **Java 15.0.2**
- **Apache Maven 3.8.1**
- **Swing** (Java GUI framework)
- **SQLite JDBC 3.3**

---

## ⚙️ Build Instructions

```bash
$ cd swingy
$ mvn clean package

## 🚀 How to Play

Navigate to the `target` directory and launch the game in your preferred mode:

### ▶️ Console Mode

```bash
$ java -jar swingy-1.0.jar console

### 🖥️ GUI Mode

```bash
$ java -jar swingy-1.0.jar gui

## 🧠 What I Learned

- Building a modular Java application with Maven  
- Creating and managing GUI components with Swing  
- Handling user input and game logic  
- Persisting data with SQLite
