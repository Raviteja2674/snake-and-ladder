import random

# Function to roll a die
def roll_die():
    return random.randint(1, 6)

# Function to move the player on the board
def move_player(player, steps):
    player += steps
    # Define snakes and ladders
    snakes_and_ladders = {16: 6, 47: 26, 49: 11, 56: 53, 62: 19, 64: 60, 87: 24, 93: 73, 95: 75, 98: 78}
    # Check for snakes and ladders
    if player in snakes_and_ladders:
        new_position = snakes_and_ladders[player]
        if new_position > player:
            print(f"Yay! You found a ladder! Climb up to {new_position}.")
        else:
            print(f"Oops! You found a snake! Slide down to {new_position}.")
        player = new_position
    return player

# Function to play the game
def play_game():
    player1_position = 1
    player2_position = 1

    while True:
        input("Player 1, press Enter to roll the die.")
        roll = roll_die()
        print(f"Player 1 rolled a {roll}.")
        player1_position = move_player(player1_position, roll)
        print(f"Player 1 is now at position {player1_position}.\n")

        if player1_position >= 100:
            print("Player 1 wins!")
            break

        input("Player 2, press Enter to roll the die.")
        roll = roll_die()
        print(f"Player 2 rolled a {roll}.")
        player2_position = move_player(player2_position, roll)
        print(f"Player 2 is now at position {player2_position}.\n")

        if player2_position >= 100:
            print("Player 2 wins!")
            break

# Start the game
play_game()
