import math

def valuesOnRange(num1, num2):
    if num1<1 or num2<1 or num1>2*math.pow(10,9) or num2>2*math.pow(10,9):
        return False
    return True

def getGCD(num1, num2):
    if(num1 > num2):
        bigger = num1
        smallest = num2
    else:
        bigger = num2
        smallest = num1

    if smallest == 0:
        return bigger
    
    return getGCD(smallest, bigger%smallest)

if __name__ == "__main__":
    try:
        values = list(map(int, input().split()))
    except ValueError:
        print("Type just two integer values between one space")
        quit()
    
    if len(values) != 2:
        raise IndexError("Type just two values")

    if valuesOnRange(values[0], values[1]) == False:
        print("The values must be whole numbers between 1 and 2 billion")
        quit()
    print(getGCD(values[0], values[1]))

