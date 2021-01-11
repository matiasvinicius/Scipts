import math

class FibonacciDigits:
    def __init__(self, n):
        self.n = n
    
    def getLastDigit(self):
        if(self.n==0):
            return 0
        
        penultimate_digit = 0
        last_digit = 1
        current_digit = 0

        for i in range(self.n-1):
            current_digit = penultimate_digit + last_digit
            penultimate_digit = last_digit%10
            last_digit = current_digit%10

        return current_digit%10

if __name__ == "__main__":
    try:
        n = int(input())
    except ValueError:
        print("The input must be an integer value")
        quit()
    if (n<0 or n>math.pow(10,7)):
        print("The value must be bigger than 0 and smallest than 10^7")
        quit()

    fd = FibonacciDigits(n)
    print(fd.getLastDigit())