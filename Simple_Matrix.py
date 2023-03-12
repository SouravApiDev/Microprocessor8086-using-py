import math
#Name:- Sourav Ghosh, Roll:- 302211102001, Student of JADAVPUR UNIVERSITY (U-0575), IEE. # Google internship 2022 August Program.
print("#Name:- Sourav Ghosh, Roll:- 302211102001, Student of JADAVPUR UNIVERSITY (U-0575), IEE. # Google internship 2022 August Program.  Simple Matrix")
i = 1
while i < 2:
    OP = ""
    matrixType = input("if 2x2 than 2, or 3x3 than 3:- ")
    if matrixType in("2","3", "2x2", "2X2","2*2","3*3", "3x3", "3X3"):
        OP = input("Operator(like + or add,- sub,* mult,/ div):- ")
    if OP in("+","-","*","x","X","/", "add","Add","ADD","sub","Sub","SUB","mult","Mult","MULT","div","Div","DIV"):
        if matrixType in("2", "2x2","2X2","2*2"):
            print("Matrix 2x2 Format")
            print("A1   A2        D1   D2")
            print("         ", OP)
            print("B1   B2        E1   E2")
            print("")
            fristRow = [float(input("A1:- ")), float(input("A2:- "))]
            fristRow2 = [float(input("B1:- ")), float(input("B1:- "))]
            secondRow = [float(input("D1:- ")), float(input("D2:- "))]
            secondRow2 = [float(input("E1:- ")), float(input("E2:- "))]
            if OP in("+", "add", "Add", "ADD"):
                print("2x2 Matrix add")
                print(fristRow[0] + secondRow[0], "  ", fristRow[1] + secondRow[1])
                print(fristRow2[0] + secondRow2[0], "  ", fristRow2[1] + secondRow2[1])
            elif OP in("-","sub","Sub","SUB"):
                print("2x2 Matrix Sub")
                print(fristRow[0] - secondRow[0], "  ", fristRow[1] - secondRow[1])
                print(fristRow2[0] - secondRow2[0], "  ", fristRow2[1] - secondRow2[1])
            elif OP in("*","mult", "Mult", "MULT"):
                print("2x2 Matrix Mult")
                print(fristRow[0] * secondRow[0], "  ", fristRow[1] * secondRow2[0])
                print(fristRow2[0] * secondRow[1], "  ", fristRow2[1] * secondRow2[1])
            elif OP in("/", "div", "Div", "DIV"):
                print("2x2 Matrix Div")
            else:
                print("Operator Error__")

        elif matrixType in("3","3*3","3x3","3X3"):
            print("Matrix 3x3 Format")
            print("A1   A2   A3          D1   D2   D3")
            print("B1   B2   B3   ", OP, "    E1   E2   E3")
            print("C1   C2   C3          F1   F2   F3")
            print("")
            fristRow = [float(input("A1:- ")), float(input("A2:- ")), float(input("A3:- "))]
            fristRow2 = [float(input("B1:- ")), float(input("B1:- ")), float(input("B3:- "))]
            fristRow3 = [float(input("C1:- ")), float(input("C2:- ")), float(input("C3:- "))]
            secondRow = [float(input("D1:- ")), float(input("D2:- ")), float(input("D3:- "))]
            secondRow2 = [float(input("E1:- ")), float(input("E2:- ")), float(input("E3:- "))]
            secondRow3 = [float(input("F1:- ")), float(input("F2:- ")), float(input("F3:- "))]

            if OP in("+", "add", "Add", "ADD"):
                print("3x3 Matrix add")
                print(fristRow[0] + secondRow[0], "  ", fristRow[1] + secondRow[1], "  ", fristRow[2] + secondRow[2])
                print(fristRow2[0] + secondRow2[0], "  ", fristRow2[1] + secondRow2[1], "  ",fristRow2[2] + secondRow2[2])
                print(fristRow3[0] + secondRow3[0], "  ", fristRow3[1] + secondRow3[1], "  ",fristRow3[2] + secondRow3[2])
            elif OP in("-", "sub", "Sub", "SUB"):
                print("3x3 Matrix Sub")
                print(fristRow[0] - secondRow[0], "  ", fristRow[1] - secondRow[1], fristRow[2] - secondRow[2])
                print(fristRow2[0] - secondRow2[0], "  ", fristRow2[1] - secondRow2[1], "  ",fristRow2[2] - secondRow2[2])
                print(fristRow3[0] - secondRow3[0], "  ", fristRow3[1] - secondRow3[1], "  ",fristRow3[2] - secondRow3[2])
            elif OP in("*", "Mult", "mult", "MULT"):
                print("3x3 Matrix Mul")
                print(fristRow[0] * secondRow[0], "  ", fristRow[1] * secondRow2[0], "  ", fristRow[2] * secondRow3[0])
                print(fristRow2[0] * secondRow[1], "  ", fristRow2[1] * secondRow2[1], "  ",fristRow2[2] * secondRow3[1])
                print(fristRow3[0] * secondRow[2], "  ", fristRow3[1] * secondRow2[2], "  ",fristRow3[2] * secondRow3[2])
            elif OP in("/", "div", "Div", "DIV"):
                print("3x3 Matrix Div")
            else:
                print("Operator Error__")
            fristRow.clear();
            fristRow2.clear();
            fristRow3.clear();
            secondRow.clear();
            secondRow2.clear();
            secondRow3.clear();
