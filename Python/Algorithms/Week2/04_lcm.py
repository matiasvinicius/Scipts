import math

def calculateGDC(num1,num2):
    if num2 == 0:
        return num1
    return calculateGDC(num2, num1%num2)

def calculateLCM(num1, num2):
    gdc = calculateGDC(num1, num2)
    lcm = num1*num2/gdc
    return int(lcm)

if __name__ == '__main__':
    try:
        values = list(map(int, input().split()))
    except ValueError:
        print("Type two integer values between one space")
        quit()

    if len(values)!=2:
        raise IndexError("Type just two values")
    
    if values[0]<1 or values[1]<1 or values[0]>math.pow(10,7) or values[1]>math.pow(10,7):
        print("The value must be bigger than 0 and smallest than 10^7")
        quit()

    print(calculateLCM(values[0], values [1]))