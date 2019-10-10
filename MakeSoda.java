package hca;

import java.util.Scanner;

public class MakeSoda {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("\nStart Soda Machine Y or N ?");
        char d;
        d = scan.next().charAt(0);
        if (d == 'Y' || d == 'y') {
            SodaMachine sodaMachine = new SodaMachine();
            sodaMachine.start();
            System.out.println("Shutting Down...\n");
        } else
            System.out.println("Shutting Down...\n");
    }
}

class SodaMachine {
    static Scanner scan = new Scanner(System.in);
    private double quarter;
    private int sodaCount = 0;

    public SodaMachine() {
        this.quarter = 0;
    }

    private void insertQuarter() {
        System.out.println("\nInserting...");
        this.quarter = 16.0;
        System.out.println("Inserting Completed.");
    }

    private void getQuarterStatus() {
        System.out.println("Available quarters " + String.format("%.1f", this.quarter));
    }

    private void ejectQuarter() {
        System.out.println("\nEject quarter...");
        this.quarter = 0;
        System.out.println("Ejection Completed.");
    }

    private void makeSoda() {
        System.out.println("\n ------------------ ");
        System.out.println("|   Select Type:   |\n ------------------ \n| 1:  Simple Soda |\n| 2:  Strong Soda  |\n| 0   to Discard   |");
        System.out.println(" ------------------ \n");
        char t = scan.next().charAt(0);
        switch (t) {
            case '1':
                this.simpleSoda();
                break;
            case '2':
                this.strongSoda();
                break;
            case '0':
                break;
        }
    }

    private void simpleSoda() {
        if (this.quarter >= 4) {
            System.out.println("\nDispensing one simple soda...");
            System.out.println("\nTaking 4 quarters of Soda.");
            this.quarter = this.quarter - 4;
            this.sodaCount++;
        } else {
            System.out.println("\nAvailable quarters " + String.format("%.1f", this.quarter));
            System.out.println("\nOUT OF SODA. Enough quarter not available, Please Fill before Making Soda.");
        }
    }
    private void strongSoda() {
        if (this.quarter >= 8) {
            System.out.println("\nDispensing one strong soda...");
            System.out.println("\nTaking 8 quarters of Soda.");
            this.quarter = this.quarter - 8;
            this.sodaCount++;
        } else {
            System.out.println("\nAvailable quarters " + String.format("%.1f", this.quarter));
            System.out.println("\nOUT OF SODA. Enough quarter not available, Please Fill before Making Soda.");
        }
    }

    public void start() {
        System.out.println(" ---------------------------------------------- ");
        System.out.println("|                   Soda Machine               |");
        System.out.println(" ---------------------------------------------- ");
        System.out.println("\nCurrent Status: ");
        this.getQuarterStatus();
        boolean t = true;
        while (t) {
            System.out.println("\n ------------------------------------------- ");
            System.out.println("|1:     Quarters left                       |\n ------------------------------------------- \n|2:      Insert Quarters                    |\n ------------------------------------------- \n|3:      Eject Quarters                     |\n -------------------------------------------- \n|4:       Dispense Soda                     |\n -------------------------------------------- \n|5: How many Sodas dispensed?               |\n -------------------------------------------- \n|6:        Exit                             |");
            System.out.println(" -------------------------------------------- \n\n");
            char c = SodaMachine.scan.next().charAt(0);
            switch (c) {
                case '1':
                    System.out.println("------------- Status ------------");
                    this.getQuarterStatus();
                    System.out.println("---------------------------------");
                    break;
                case '2':
                    this.insertQuarter();
                    break;
                case '3':
                    this.ejectQuarter();
                    break;
                case '4':
                    this.makeSoda();
                    break;
                case '5':
                    System.out.println("\nDispensed " + this.sodaCount + " Sodas.");
                    break;
                case '6':
                    System.out.println("\nExiting...\n");
                    t = false;
                    break;
            }
        }
    }
}
