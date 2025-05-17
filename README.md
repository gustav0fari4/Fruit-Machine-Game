# 🎰 Fruit Machine Game – Java

A console-based slot machine game written in Java. Players start with 100 credits and can choose different difficulty levels, spin the machine, and win or lose based on symbol matches. The game includes ASCII visuals, a payout system, and interactive options to check or buy credits.

## 🛠️ Technologies Used

- Java (JDK 8+)
- Random number generation
- Scanner for input
- Arrays and loops
- Conditional logic and modular functions

## 🎮 How to Play

1. Clone the project or download the `.java` file
2. Compile the file:

```bash
javac FruitMachine.java

java FruitMachine

🧩 Features

    Starts with 100 credits

    Choose difficulty (Easy, Medium, Hard) – influences cost and reward

    Match 3 symbols to win big

    5% chance of winning €1,000 on '777'

    Option to buy more credits

    Clean and modular code structure

    ASCII slot display for improved user experience

📋 Ruleset

    Match 3 symbols (excluding 7): 150 credits × difficulty × 2

    Match 2 symbols: 50 credits × difficulty × 2

    Match 3 '7' symbols + lucky draw: €1,000 and game ends

    Each play costs 10 credits × difficulty
