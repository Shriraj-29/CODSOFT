import random

def determine_winner(user_choice, computer_choice):
    if user_choice == computer_choice:
        return "It's a tie!"
    elif (user_choice == 'rock' and computer_choice == 'scissors') or \
         (user_choice == 'r' and computer_choice == 'scissors') or \
         (user_choice == 'scissors' and computer_choice == 'paper') or \
         (user_choice == 's' and computer_choice == 'paper') or \
         (user_choice == 'paper' and computer_choice == 'rock') or \
         (user_choice == 'p' and computer_choice == 'rock'):
        return "You win!"
    else:
        return "You lose!"

def play_round():
    while True:
        user_choice = input("Choose rock/r, paper/p, or scissors/s: ").lower()
        if user_choice in ['rock', 'paper', 'scissors', 'r', 'p', 's']:
            break
        else:
            print("Invalid input! Please choose either 'rock/r', 'paper/p', or 'scissors/s'.")
    computer_choice = random.choice(['rock', 'paper', 'scissors'])
    print(f"You chose {user_choice}.")
    print(f"The computer chose {computer_choice}.")
    print(determine_winner(user_choice, computer_choice))

def main():
    print("Welcome to Rock-Paper-Scissors!")
    play_again = 'y'
    while play_again == 'y':
        play_round()
        play_again = input("Do you want to play again? (y/n): ").lower()

if __name__ == "__main__":
    main()
