import math
def calculateFibonacci(n):
    if(n==0):
        return 0

    fibonacci = 1
    last_fibonacci = 0
    penultimate_fibonacci = 0
    i = 2
    
    while i<=n:
        penultimate_fibonacci = last_fibonacci
        last_fibonacci = fibonacci
        fibonacci = last_fibonacci+penultimate_fibonacci
        i+=1
    return fibonacci 

    
def getLastDigits(n,m):
    if(n==0):
        return 0
    
    penultimate_digit = 0
    last_digit = 1
    current_digit = 0

    for i in range(n-1):
        current_digit = penultimate_digit + last_digit
        penultimate_digit = last_digit%m
        last_digit = current_digit%m

    return current_digit%m

def FibModulo(num, modulo):
    if modulo<2: quit()
    pisanoPeriod = [0,1,1]
    i = 3

    while not(pisanoPeriod[-1]==1 and pisanoPeriod[-2]==0):
        fibonacci = getLastDigits(i,modulo)
        pisanoPeriod.append(fibonacci)
        i+=1

    pisanoPeriod.pop(-1)
    pisanoPeriod.pop(-1)
    f = calculateFibonacci(num%(len(pisanoPeriod)))
    return f%modulo
    
if __name__ == "__main__":
    values=[]
    try:
        values = list(map(int, input().split()))
    except ValueError:
        quit()

    if(values[0]<1 or values[0]>math.pow(10,14) or values[1]<2 or values[1]>1000):
        quit()

    print(FibModulo(values[0], values[1]))


