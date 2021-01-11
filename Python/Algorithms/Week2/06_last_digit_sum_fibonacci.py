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

def FibSoma(num, modulo):
    if num==0: return 0
    if num==1: return 1
    pisanoPeriod = [0,1,1]
    i = 3
    soma = 2

    while not(pisanoPeriod[-1]==1 and pisanoPeriod[-2]==0):
        fibonacci = getLastDigits(i,modulo)
        pisanoPeriod.append(fibonacci)
        soma+=pisanoPeriod[i]
        i+=1

    pisanoPeriod.pop(-1)
    pisanoPeriod.pop(-1)
    soma-=1

    diff = int(num/(len(pisanoPeriod)))
    resto = num%len(pisanoPeriod)
    soma = diff*soma
    i=0
    while i<=resto:
        soma+=pisanoPeriod[i]
        i+=1
    
    return soma

if __name__ == "__main__":
    try:
        n = int(input())
    except ValueError:
        quit()
 
    if(n<0 or n>math.pow(10,14)):
        quit()

    soma = FibSoma(n, 10)
    print(soma%10)
