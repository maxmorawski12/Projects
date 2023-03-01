balance = 1000
def menu():
    global balance
    while True:
        menu = input("Would you like to Withdraw, Deposit, Balance or Quit? ")
        if menu == "Withdraw" or menu == "withdraw":
            withdraw()
        elif menu == "Deposit" or menu == "deposit":
            deposit()
        elif menu == "Balance" or menu == "balance" :
            checkbalance()
        elif menu == "Quit" or menu == "quit":
            exit()
        else:
            print("Please Enter a valid option")

def deposit():
    global balance
    while True:
        amount = input("How much would you like to deposit? ")
        if amount.isdigit():
            amount = int(amount)
            if amount > 0:
                print("You have deposited " + str(amount))
                balance = balance + amount
                menu()
                break
            else: 
                print("Amount must be greater than 0")
        else:
            print("Please Enter a number")

def withdraw():
    global balance
    while True:
        amount = input("How much would you like to withdraw? ")
        if amount.isdigit():
            amount = int(amount)
            if amount > 0:
                balance = balance - amount
                if balance < 0:
                    balance = balance + amount
                    print("Insufficent Funds")
                    break
                print("You have withdrawn " + str(amount))
                menu()
            else: 
                print("Amount must be greater than 0")
        else:
            print("Please Enter a number")

def checkbalance():
    print(str(balance))
    menu()

def main():
    menu()
    
main()    

