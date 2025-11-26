# Number Guessing Game – Notes

## What the Program Does
- Generates a random number (1–50)
- User guesses the number
- Shows "Too High", "Too Low" or "Correct"
- Counts attempts
- Asks user if they want to play again

## Key Concepts Learned
### Random Number

### Scanner Input
Used to take user guesses from the keyboard.

### Loop
`while` loop keeps the game running until the guess is correct.

### Methods Used
- `userInput()` → get and validate guess
- `systemGenerateNumber()` → create random number
- `checker()` → compare user guess
- `playAgain()` → restart or exit game

### Validation
- If user enters number outside `1-50`, do not count attempt.

## Game Flow
1. Generate system number
2. Take user input
3. Compare and show result
4. If correct → ask to play again
5. Reset attempts and number if yes

## Skills Practiced
- Loops
- Conditionals
- Scanner
- Random number generation
- Method structure
- Basic game logic
