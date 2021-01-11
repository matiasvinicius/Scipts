import math
  
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

def FibSomaQuadrada(n, modulo):
    if n==0: return 0
    if n==1: return 1
    pisanoPeriod = [0,1,1]
    i = 3
    soma = 0

    while not(pisanoPeriod[-1]==1 and pisanoPeriod[-2]==0):
        fibonacci = getLastDigits(i,modulo)
        pisanoPeriod.append(fibonacci)
        if i>=n: soma+=pisanoPeriod[i]
        i+=1

    pisanoPeriod.pop(-1)
    pisanoPeriod.pop(-1)

    altura = pisanoPeriod[n%(len(pisanoPeriod))]
    base = pisanoPeriod[n%(len(pisanoPeriod))+1]
    
    return (base*altura)%10

if __name__ == "__main__":
    try:
        n = int(input())
    except ValueError:
        quit()
    
    if(n<0 or n>math.pow(10,14)): quit

    soma = FibSomaQuadrada(n, 10)
    print(soma)
