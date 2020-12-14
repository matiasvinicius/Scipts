def buildCryptMap(key):
    criptMap = dict()
    
    for i in range(26-key):
        criptMap[chr(65+i)] = chr(65+i+key)
    for i in range(key):
        criptMap[chr(91-key+i)] = chr(65+i)
    
    return criptMap

def encypt(message, key):
    criptMessage = ""
    criptMap = buildCryptMap(key)
    
    for c in message:
        if c in criptMap:
            criptMessage += criptMap[c]
        elif c.upper() in criptMap:
            criptMessage += criptMap[c.upper()].lower()
        else:
            criptMessage += c
    
    return criptMessage
        
def main():
    while(True):
        m = input("Digite a mensagem: ")
        k = input("Digite o valor da chave: ")
        
        try:        
            k = int(k)
        except:
            print("Digite um valor inteiro para a chave.")
            quit()
        
        encyptedMessage = encypt(m, k)
        print(encyptedMessage)
        
        continuar = input("Digite 0 para parar ou outra tecla para continuar: ")
        if(continuar=="0"):
            break

#Run
#TO DO: Reconhecimento de acentos (UTF-8)
main()