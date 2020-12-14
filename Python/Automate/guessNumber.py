import random

def findNumber():
    print("I am thinking of a number between 1 and 20.")

    correctNumber = random.randint(1, 20)
    userNumber = 0
    numberOfRounds = 0

    while(userNumber != correctNumber):
        print("Take a guess.")
        userNumber = input()
        
        if(userNumber > correctNumber):
            print("Your guess is too high.")
        elif(userNumber < correctNumber):
            print("Your guess is too low.")
            
        numberOfRounds += 1
            
    print("Good job! You guessed my number in " + str(numberOfRounds) + " guesses!")

findNumber()
