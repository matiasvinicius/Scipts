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

def FibSoma(n_inicio, n_fim, modulo):
    pisanoPeriod = [0,1,1]
    i = 3
    soma = 0

    while not(pisanoPeriod[-1]==1 and pisanoPeriod[-2]==0):
        fibonacci = getLastDigits(i,modulo)
        pisanoPeriod.append(fibonacci)
        if i>=n_inicio: soma+=pisanoPeriod[i]
        i+=1

    pisanoPeriod.pop(-1)
    pisanoPeriod.pop(-1)
    soma-=1
    diff = int((n_fim-n_inicio)/(len(pisanoPeriod)))
    resto = (n_fim-n_inicio)%len(pisanoPeriod)
    soma = diff*soma
    i=n_inicio
    while i<=n_inicio+resto:
        soma+=pisanoPeriod[i]
        i+=1
    
    return soma%10

if __name__ == "__main__":
    values = []
    try:
        values = list(map(int, input().split()))
    except ValueError:
        quit()
    
    if(values[1]>values[0] or values[0]<0 or values[0]>math.pow(10,14) or values[1]<0 or values[1]>math.pow(10,14)):
        quit()

    soma = FibSoma(values[0], values[1], 100)
    print(soma)
