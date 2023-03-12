print("MICROPROCESSOR 8086")
operator = ""
fristNumber = 0
secondNumber = 0
input_user2 = ""
input_user = ""
MP_reg = ""

#MP_reg = [input("AH:- "), input("AL:- "),input("BH:- "),input("BL:- "),input("CH:- "),input("CL:- "),input("DH:- "),input("DL:- ")]
MP_reg = ["","","","","","","",""]
print(MP_reg)

def regdataGET_use_code():
    global fristNumber,secondNumber,MP_reg
    if input_user2[0] == "AH":
        fristNumber = MP_reg[0]
    elif input_user2[0] == "AL":
        fristNumber = MP_reg[1]
    elif input_user2[0] == "BH":
        fristNumber = MP_reg[2]
    elif input_user2[0] == "BL":
        fristNumber = MP_reg[3]
    elif input_user2[0] == "CH":
        fristNumber = MP_reg[4]
    elif input_user2[0] == "CL":
        fristNumber = MP_reg[5]
    elif input_user2[0] == "DH":
        fristNumber = MP_reg[6]
    elif input_user2[0] == "DL":
        fristNumber = MP_reg[7]
    else:
        print(input_user2[0], "not Valid")

    if input_user2[1] == "AH":
        secondNumber = MP_reg[0]
    elif input_user2[1] == "AL":
        secondNumber = MP_reg[1]
    elif input_user2[1] == "BH":
        secondNumber = MP_reg[2]
    elif input_user2[1] == "BL":
        secondNumber = MP_reg[3]
    elif input_user2[1] == "CH":
        secondNumber = MP_reg[4]
    elif input_user2[1] == "CL":
        secondNumber = MP_reg[5]
    elif input_user2[1] == "DH":
        secondNumber = MP_reg[6]
    elif input_user2[1] == "DL":
        secondNumber = MP_reg[7]
    else:
        print(input_user2[1], "not Valid")
def MP_reg_void():
    global MP_reg
    MP_reg = [input("AH:- "), input("AL:- "),input("BH:- "),input("BL:-"),input("CH:- "),input("CL:- "),input("DH:- "),input("DL:- ")]
    print(MP_reg)
    MP_CALUTION_void()
def MP_reg_set_void(regSet):
    global MP_reg
    register_set_status = "Not Set REG_NOT_VALID"
    if regSet == "AH":
        MP_reg[0] = input("AH:- ")
        register_set_status = "Set"
    elif regSet == "AL":
        MP_reg[1] = input("AL:- ")
        register_set_status = "Set"
    elif regSet == "BH:- ":
        MP_reg[2] = input("BH:- ")
        register_set_status = "Set"
    elif regSet == "BL:- ":
        MP_reg[3] = input("BL:- ")
        register_set_status = "Set"
    elif regSet == "CH":
        MP_reg[4] = input("CH:- ")
        register_set_status = "Set"
    elif regSet == "CL":
        MP_reg[5] = input("CL:- ")
        register_set_status = "Set"
    elif regSet == "DH":
        MP_reg[6] = input("DH:- ")
        register_set_status = "Set"
    elif regSet == "DL":
        MP_reg[7] = input("DL:- ")
        register_set_status = "Set"
    print(regSet," ", register_set_status,MP_reg)
    MP_CALUTION_void()
def MP_CALUTION_void():
    global input_user,input_user2
    add = input("MP: ")
    input_user = add.split()

    if input_user[0] == ("REG_SET"):
        print("")
        MP_reg_void()
    else:
        input_user2 = input_user[1].split(',')
        print(input_user[0])
        print(input_user[1].split(','))
        if input_user[0] == "ADD":
            regdataGET_use_code()
            print(float(fristNumber) + float(secondNumber))
            MP_CALUTION_void()
        elif input_user[0] == "SUB":
            regdataGET_use_code()
            print(float(fristNumber) - float(secondNumber))
            MP_CALUTION_void()
        elif input_user[0] == "MUL":
            regdataGET_use_code()
            print(float(fristNumber) * float(secondNumber))
            MP_CALUTION_void()
        elif input_user[0] == "DIV":
            regdataGET_use_code()
            print(float(fristNumber) / float(secondNumber))
            MP_CALUTION_void()

        if input_user[0] == "REG_SET":
            MP_reg_void()
        elif input_user[0] == "REG-SET":
            if input_user[1] in ("AH", "AL", "BH", "BL", "CH", "CL", "DH", "DL"):
                MP_reg_set_void(input_user[1])
            else:
                print(input_user[1], "reg not valid")

MP_CALUTION_void()

