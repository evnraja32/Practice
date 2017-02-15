def calPF(basicSal):
    print ("Amount Entered: ",basicSal)
    pfLogic = basicSal * 0.12
    if (pfLogic > 2000):
        print ('PF to be deducted : Rs. 2000')
    else:
        print ('PF to be deducted : ',pfLogic)

while(input('Want caluclate PF (Y/N): ') == 'Y'):
    print()
    calPF((int)(input("Enter amount:")))
    
