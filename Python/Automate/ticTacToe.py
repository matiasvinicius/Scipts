# -*- coding: cp1252 -*-
def initializeBoard():
    return {'7': ' ', '8': ' ', '9': ' ',
            '4': ' ', '5': ' ', '6': ' ',
            '1': ' ', '2': ' ', '3': ' '}

def printBoard(board):
    print(board['7'] + '|' + board['8'] + '|' + board['9'])
    print('-+-+-')
    print(board['4'] + '|' + board['5'] + '|' + board['6'])
    print('-+-+-')
    print(board['1'] + '|' + board['2'] + '|' + board['3'])

def nextRoad(turn):
    if turn == 'X':
        return 'O'
    else:
        return 'X'    

#apesar de sempre fazer os mesmos testes, é uma versão de tempo constante e com apenas 8 condições, uma das menores possíveis
def winner(board, turn):
    #marca horizontal
    if(board['1'] == turn and board['2'] == turn and board['3'] == turn):
        return True
    if(board['4'] == turn and board['5'] == turn and board['6'] == turn):
        return True
    if(board['7'] == turn and board['8'] == turn and board['9'] == turn):
        return True

    #marca vertical
    if(board['7'] == turn and board['4'] == turn and board['1'] == turn):
        return True
    if(board['8'] == turn and board['5'] == turn and board['2'] == turn):
        return True
    if(board['9'] == turn and board['6'] == turn and board['3'] == turn):
        return True

    #marca diagonal
    if(board['7'] == turn and board['5'] == turn and board['3'] == turn):
        return True
    if(board['1'] == turn and board['5'] == turn and board['9'] == turn):
        return True

    return False

def playGame():
    board = initializeBoard()
    turn = 'X'
    won = False
    for i in range (9):
        printBoard(board)
        print('Turn for ' + turn + '. Move on which space?')
        move = raw_input()
        board[move] = turn
        if(winner(board, turn) == True):
            won = True
            break
        turn = nextRoad(turn)
    printBoard(board)
    if won == True:
        print(turn + " won!!!")
    else:
        print("Velha!!!")

#executa o jogo
playGame()

