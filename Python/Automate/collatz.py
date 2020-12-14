def collatz(number):
    numberEdit  = 0
    
    if(number % 2 == 0):
        numberEdit = number // 2
        print(str(numberEdit))
        return numberEdit
    else:
        numberEdit = 3 * number + 1
        print(str(numberEdit))
        return numberEdit

def main():
    print("Enter number:")
    number = int(input())

    while(number != 1):
        number = collatz(number)

    print("------")

main()
