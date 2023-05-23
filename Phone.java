   import java.util.*;

public class Phone {
    Scanner input  = new Scanner(System.in);
     float balance;

     public Phone() {
        
        balance = 0.0f;
        viewMenu();
    }

   
   

System.out.printf("Hello");
   
    public void checkBalance() { // checking balance 
        System.out.println();
        System.out.println("  your current balance is:  " + getBalance());
    }

    public void loadBalance() {   // loading balance 
        float f = 0.0f;

        System.out.println("Enter your amount: ");
        System.out.println("But amount greater than 60.");
        f = input.nextFloat();
        if (f > 60) {
            f = f + getBalance();
            setBalance(f);
            System.out.println("Amout loaded..");

        } else {
            System.out.println("");
            loadBalance();

        }
    }

    public void Loan() {
        System.out.println("If you want to take Advance loan PRESS.*112# ");
        String advance = "";
        float f = 0.0f;
        advance = input.next();
        if (advance.equals("*112#")) {
          System.out.println("Your request has been received .\n  Please wait....... ");  
          f = 25 + getBalance();
          setBalance(f);
          System.out.println("You have received 25 rupees advance loan. ");
          System.out.println("It will be cut down on your next recharge. ");
          System.out.println("Thank you for taking advance loan service.");

         }
         else {
            System.out.println("You Enter Invalid code.!");
            System.out.println("Please Enter valid code. *112#");
            Loan();
         }


    }

    public void doCall() {
        if (getBalance() > 0) {
            String number = "";
            System.out.println("Enter Number to do Call");
            number = input.next();
            if (number.isEmpty()) {
                System.out.println("please Enter a number :");
            } else {
                if (number.length() == 11) {
                    System.out.println("Calling  " + number);
                    setBalance(getBalance() - 3.0f);
                    try {
                        Thread.sleep(1000);
                        System.out.println("calling ringing.....");
                        Thread.sleep(2000);
                        System.out.println("calling ended, duration i min.");
                    } catch (InterruptedException e) {
                    }

                }
                else {
                    System.out.println("Please Enter a Valid Number.");
                    doCall();

                }
            }
        } else {
            System.out.println("you have enouph space balance :");
        }
    }

    public void sendSMS() {
        if (getBalance() > 0) {
            String number = "";
            String message = "";
            System.out.print("\nEnter number to send message:\n");
            number = input.next();

            if (number.length() == 11) {
                System.out.print("\n Enter your message:\n");
                message = input.next();
                message = input.nextLine();
                System.out.print("sending message to "  +number);
                setBalance(getBalance() - 2.0f);
                try {
                    Thread.sleep(100);
                    System.out.print("message sent !");
                } catch (InterruptedException e) {
                }
                
                
            } else {
                System.out.print("Please Enter a valid  number .");
                sendSMS();
              
            }
        } 
         else {
            System.out.println("you do not  have enough balance .");
        }
        }
    

    public void viewMenu() {
        int choice = 0;
        do {
            System.out.println();
          
            System.out.println("--------------------------------------------------");
            System.out.println(" *****      . Well Come To Jazz World .   *******  ");
            System.out.println("____________________________________________________");
            System.out.println();
            
           // showing main menu to the user 
            System.out.println("    ******    Type Option:  ******  ");
             System.out.println();
             System.out.println("    1.  Check Balance  .       ");
             System.out.println("    2.  Load Balance   .       ");
             System.out.println("    3.  Do Call        .       ");
             System.out.println("    4.  Send SMS       .       ");
             System.out.println("    5.  Loan           .       ");
             System.out.println("    6.  Exist          .       ");
             System.out.println("    7.  About Us       .       ");

           
           // we have  to perform task as per user choice 

            choice = input.nextInt();
            switch (choice) {
                case 1:
                    checkBalance();
                    break;
                case 2:
                    loadBalance();
                    break;
                case 3:
                    doCall();
                    break;
                case 4:
                    sendSMS();
                    break;
                case 5:
                    Loan();
                    break;
                case 6:
                System.exit(1);
                    break;
                case 7:
                    System.out.println(" ** Hello, Here are Irfan Ali and Muntazir Hussain.  ");
                    System.out.println("    We are Students of Computer Science Department of Sindh University.");
                    System.out.println("    This is our First  Mini Java Project and it is only Conceptual Java Mini Project.");
                    System.out.println("    We hope you will like it.");
                    System.out.println("             THANK YOU VERY MUCH FOR USING !  ");
                    break;
                  default:
                    System.out.println("please select a valid option. ");
            }
        } while (choice != 7);
    }

    public float getBalance() {
        return this.balance;
    }

    public void setBalance(float balance) {
        this.balance = balance;
    }

    public static void main(String[] args) {
        new Phone();
    }
}

