
# 📘 Brick Breaker Game – Complete Study Notes (Markdown)

## 🧩 1. Overview of the Project
Brick Breaker is a simple Java Swing game where:

- A **ball** moves on the screen.
- A **paddle** at the bottom controls bounce direction.
- Multiple **bricks** at the top break when the ball hits them.
- If ball falls below paddle → life lost.
- If all bricks break → next level.

This project teaches:

- Object-oriented programming
- Game loops
- Collision detection
- Rendering with Swing
- Keyboard input
- Managing multiple entities

---

## 🗂 2. Folder Structure

```
BrickBreaker/
│
├──---------BrickBreakerGame/
│           ├── App.java
│           ├── engine/
│           │   ├── GamePanel.java
│           │   ├── InputHandler.java
│           │   └── CollisionDetector.java
│           ├── entities/
│           │   ├── Ball.java
│           │   ├── Paddle.java
│           │   └── Brick.java
│           └── ui/
│               └── UIHelper.java
```

---

## 🔄 4. Game Flow Summary

### Step 1 – Start Game
Main creates window → adds GamePanel.

### Step 2 – GamePanel Constructor
- Create ball, paddle, bricks
- Add key listener
- Start timer loop

### Step 3 – Game Loop
```
update();
repaint();
```

### Step 4 – update()
- Move paddle
- Move ball
- Detect collisions
- Update score
- Reset level
- Life management

### Step 5 – repaint()
Draw:
- paddle
- ball
- bricks
- score/lives

---

## 🧠 5. Key Learnings
- Game loop using Swing Timer
- Collision detection
- Object-oriented design
- Keyboard input handling
- Rendering with `paintComponent()`

---

## ❓ 6. Common Doubts
- Why Swing Timer?
- Why separate classes?
- How to detect collisions?
- How to increase game difficulty?

---

## ✨ 7. Interview Answers
### Q: How does your game loop work?
A Swing Timer calls update() and repaint() continuously.

### Q: How did you design the game?
Using clean OOP separation across engine, entities, and UI.

### Q: How do collisions work?
By checking rectangle–circle intersection and reversing ball velocity.

---
