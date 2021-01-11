def calculateFibonacci(n):
    if (n<0 or n>45):
        print("The value must be bigger than 0 and smallest than 45")
        return -1
    
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
    


if __name__ == "__main__":
    try:
        n = int(input())
    except:
        print("The input must be an integer value")
        quit()
    print(calculateFibonacci(n))