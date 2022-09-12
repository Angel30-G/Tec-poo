def dibujar(matriz):
    for i in range(len(matriz)):
        for j in range(len(matriz[0])):
            print(matriz[i][j],end="")
        print()

#Dominio: Ninguno
#Codominio: Un tablero vacío de 6x7
def conecta4Raiz():
    c4 = []
    for _ in range(6):
        fila = []
        for _ in range(7):
            fila.append(0)
        c4.append(fila)
    return c4

#Dominio: Una posición i,j en la matriz
#Codominio: True si está dentro del tablero
def posvalida(i,j):
    return 0<=i and 0 <=j and i<6 and j <7

#Dominio: Una posición de conecta4
#Codominio: -4 si ganó el segundo jugador, 4 si ganó el primero y 0 si no
def hayGanador(c4):
    direcciones = [[1,0],[0,1],[-1,1],[-1,-1]]
    for i in range(6):
        for j in range(7):
            if(c4[i][j]!=0):
                for di,dj in direcciones:
                    s = 0
                    for k in range(4):
                        if(posvalida(i+k*di,j+k*dj)):
                            s+=c4[i+k*di][j+k*dj]
                    if(abs(s) == 4):
                        return s
    return 0

#Dominio: Un conecta 4
#Codominio: Nada, pero imprime las matrices de forma legible para un ser humano
def mostrar(c4):
    for i in range(6):
        for j in range(7):
            if(c4[i][j]>0):
                print("x",end=" ")
            if(c4[i][j]<0):
                print("o",end=" ")
            if not c4[i][j]:
                print(".",end=" ")
        print()
    for i in range(1,8):
        print(str(i),end=" ")
    print()

#Dominio: Recibe una posición
#Codominio: Una copia de la posición
def copia(c4):
    cp = []
    for i in range(6):
        fila = []
        for j in range(7):
            fila.append(c4[i][j])
        cp.append(fila)
    return cp

#Dominio: Una posición de un tablero y una columna donde jugar
#Codominio: La posición con la columna jugada
def jugar(c4, col):
    tot = 0
    for fil in c4:
        tot+=sum(fil)
    jugador = 1-2*tot
    fila = 5
    while(c4[fila][col]):
        fila-=1
    resp = copia(c4)
    resp[fila][col] = jugador
    return resp

#Dominio: Una posicion de c4
#Codominio: Una lista de los hijos de esa posición
def hijos(c4):
    children = []
    for i in range(7):
        if c4[0][i] == 0:
            hij = []
            hij.append(jugar(c4,i))
            hij.append([])
            children.append(hij)
    return children
'''
Tab = conecta4Raiz()
for hijo in hijos(Tab):
    mostrar(hijo[0])
'''

#Dominio: Un natural altura y una posición de c4 raiz
#Codominio: El arbol completo de c4, con raiz como raiz de ese arbol
def arbolito(altura, raiz):
    if altura == 0 or not hayGanador(raiz):
        return [raiz, []]
    children = hijos(raiz)
    ArbolResultante = [raiz,[]]
    for hijo in children:
        ArbolResultante[1].append(arbolito(altura-1,hijo[0]))
    return ArbolResultante

'''
#Dominio: Arbol de juego
#Codominio: A cada hoja, se le ponen los hijos (si los hubiera)
def agregarnivel(Arb):
    if (Arb[1] == [] and not hayGanador(Arb[0])):  ## es hoja no final
        Arb2 = arbolito(1,Arb[0])
        return Arb2
    Arb2=[Arb[0],[]]
    for hijo in Arb[1]:
        print(agregarnivel(hijo))
        Arb2[1].append(agregarnivel(hijo))
    return Arb2
'''

def preorden(Arb):
    if(Arb == []):
        return
    mostrar(Arb[0])
    for hijo in Arb[1]:
        preorden(hijo)



def porcentaje(jugada,valorDeCambio,ficha):
    direcciones = [[1,0],[0,1],[-1,1],[-1,-1]]
    prioridades = []
    posiciones = []
    for i in range(len(jugada)):
        for j in range(len(jugada[0])):
            for di,dj in direcciones:
                linea = []
                pos = []
                #-------linea vertical--------#
                if(di==1 and dj ==0):
                    tipo = 1
                #-------linea horizontal------#
                elif(di==0 and dj ==1):
                    tipo = 2
                #-------linea horizontal------#
                else:
                    tipo = 3

                for k in range(4):
                    if(posvalida(i+k*di,j+k*dj)):
                        linea.append(jugada[i+k*di][j+k*dj])
                        pos.append(j+k*dj)
                s = 0
                lugares = []
                if(len(linea)==4):
                    for p in range(len(linea)):
                        if(linea[p]==ficha):
                            s+=1
                        elif(linea[p]==ficha*-1):
                            s+=10
                        else:
                            lugares.append(pos[p])
                    if(s*25>=valorDeCambio and s<4):
                        if(tipo == 1):
                            if(len(lugares)>0):
                                if(jugada[(i+k*di)-1][j+k*dj]!=0):
                                    prioridades.append("baja")
                                    posiciones.append(lugares.pop()+1)
                        if(tipo == 2):
                            if(len(lugares)>0):
                                if(jugada[(i+k*di)-1][j+k*dj]==0):
                                    prioridades.append("media")
                                    posiciones.append(lugares.pop()+1)
                        if(tipo == 3):
                            if(len(lugares)>0):
                                if(jugada[(i+k*di)-1][j+k*dj]!=0):
                                    prioridades.append("alta")
                                    posiciones.append(lugares.pop()+1)
    horizontal = []
    vertical = []
    for i in range(len(prioridades)):
            if(prioridades[i] == "alta"):
                return posiciones[i]
            if(prioridades[i] == "media"):
                horizontal.append(posiciones[i])
            if(prioridades[i] == "baja"):
                vertical.append(posiciones[i])
    if(len(horizontal) == 0 and vertical != []):
        return vertical.pop(0)
    elif(horizontal != []):
        print(horizontal)
        return horizontal.pop(0)
    return 0


    

def elegirJugada(posibles):
    #porcentajes = []
    for jugada in posibles:
        porcentaje(jugada)
        
import random

def juegaPC(Tab,comparacion):
    #------verificador del estado rival--------#
    lugar = porcentaje(Tab,comparacion,1)
    #print(lugar)
    if(lugar != 0):
        print("Jugada de PC")
        print("He decidido jugar en "+ str(lugar))
        return jugar(Tab,lugar-1)
    
    lugar = porcentaje(Tab,25,-1)
    if(lugar == 0):
        lugar = random.randint(1,7)
    print("Jugada de PC")
    print("He decidido jugar en " + str(lugar))
    return jugar(Tab,lugar-1)

def juegaPCFacil(Tab):
    pos = random.randint(1, 7)
    print("Jugada de PC")
    print("He decidido jugar en"+ str(pos))
    return jugar(Tab,pos-1)


def validacion(tablero,posX):
    posY = 0
    if(posX>6 or posX<0):
        return False
    for i in range(len(tablero)):
        if(tablero[i][posX] != 0):
            posY +=1
    return posvalida(posY,posX)

def mensajeFinal(Tab,turno):
    if(turno == 1):
        return "Perdistes"
    else:
        mostrar(Tab)
        return "Ganastes"
    
def setDificultad():
    dificultad = int(input("Elija la Dificu"
                           "ltad: "))
    if(dificultad == 0):
        return 0
    return 25*(dificultad-1)

def main():
    #--------Datos iniciales-------------#
    dificultad = setDificultad()
    #nombre = input("Nombre: ")
    Tab = conecta4Raiz()
    turno = 1
    mostrar(Tab)
    while(hayGanador(Tab)==0):
        if(turno == 1):
            try:
                posX = int(input("posición: "))
                if(validacion(Tab,posX-1)):
                    Tab = jugar(Tab,posX-1)
                    turno = 0
            except:
                print()
        else:
            print()
            if(dificultad == 0):
                Tab = juegaPCFacil(Tab)
            else:
                Tab = juegaPC(Tab,dificultad)
            mostrar(Tab)
            turno = 1
    print(mensajeFinal(Tab,turno))

main()


















