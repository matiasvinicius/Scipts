def cript(message, key):
    criptMap = dict()
    criptMessage = ""
    for i in range(26-key):
        criptMap[chr(65+i)] = chr(65+i+key)
    for i in range(key):
        criptMap[chr(91-key+i)] = chr(65+i)

    for c in message:
        if c in criptMap:
            criptMessage += criptMap[c]
        elif c.upper() in criptMap:
            criptMessage += criptMap[c.upper()].lower()
        else:
            criptMessage += c

    return(criptMessage)
        


m = "Hello World"
k = 3
newMessage = cript(m, k)
print(newMessage)
