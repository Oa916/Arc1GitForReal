

import java.util.Scanner;
import java.util.Random;

// this is a test for git lets goooo

void main() {
    boolean MenuRunning = true;
    Random Random = new Random();
    Scanner Scanner = new Scanner(System.in);
    String name = "";
    int CaughtCreature = 8;
    System.out.println("What is your name, Trainer?");
    name = Scanner.nextLine();


    ArrayList<Creatures> WildCreatures = new ArrayList<>();
    WildCreatures.add(new Creatures("Bulby", 37, 3, 25, 49, 49, false, 50));
    WildCreatures.add(new Creatures("Fire Dragon", 64, 5, 78, 84, 78, false, 50));
    WildCreatures.add(new Creatures("Blue Turt", 1, 2, 44, 48, 65, false, 50));
    WildCreatures.add(new Creatures("Meow 3", 30, 5, 106, 110, 90, false, 80));
    WildCreatures.add(new Creatures("Gingivitis", 61, 4, 60, 60, 65, false, 60));
    WildCreatures.add(new Creatures("DevilDog", 5, 8, 75, 90, 50, false, 70));


    ArrayList<Creatures> Crew = new ArrayList<>();


    ArrayList<Creatures> GRAVEYARD = new ArrayList<>();


    System.out.println("What is your choice of starter trainer???");
    System.out.println("0 For Bulby");
    System.out.println("1 For Fire Dragon");
    System.out.println("2 For Blue Turt");
    CaughtCreature = Scanner.nextInt();
    while (CaughtCreature != 0 && CaughtCreature != 1 && CaughtCreature != 2 && CaughtCreature != 8) {
        System.out.println("Please input 0, 1, or 2!!");
        CaughtCreature = Scanner.nextInt();
    }
    Crew.add(WildCreatures.get(CaughtCreature));
    WildCreatures.remove(WildCreatures.get(CaughtCreature));
    while (MenuRunning) {
        System.out.println("Welcome " + name + "! Here are your Creature(s): ");
        System.out.print(Crew);
        System.out.println("");




        int Choice = 0;
        int Attacker = 5;
        int Attackee = 3;
        String Capture = "e";
        int TryingToCatch = 0;
        String Release = "nada";
        int ReleaseOption = 0;
        System.out.println("Would you like to fight? 1 if yes 2 for no)");
        Choice = Scanner.nextInt();
        while (Choice != 1 && Choice != 2) {
            System.out.println("Please input 1 or 2!!!");
            Choice = Scanner.nextInt();


        }
        if (Choice == 1) {
            System.out.println("Which Creature are you using to attack?");
            System.out.println("Your first Creature in the list will represent 0 and the second will represent 1 and so on and so forth. (I know you know this Mr. Johnson Don't play dumb \uD83E\uDD28)");
            for (int i = 0; i < Crew.size(); i++) {
                System.out.println(i + " for " + Crew.get(i).getSpecies());
            }
            Attacker = Scanner.nextInt();
            while (Attacker < 0 || Attacker >= Crew.size()) {
                System.out.println("Invalid!!! Choice must be between 0 and " + (Crew.size() - 1) + " Unless you only have a starter then that's your only option pal");
               Scanner.nextLine();
                Attacker = Scanner.nextInt();
            }
            System.out.println("Excellent, now who do you want to attack? (Again Staring from 0 and up cough cough Mr. Johnson)");
            for (int i = 0; i < WildCreatures.size(); i++) {
                System.out.println(i + " for " + WildCreatures.get(i).getSpecies());
            }
            Attackee = Scanner.nextInt();
            while (Attackee < 0 || Attackee >= WildCreatures.size()) {
                System.out.println("Invalid choice, must be between 0 and " + (WildCreatures.size()) + "!!!");
                Attackee = Scanner.nextInt();
            }
            Crew.get(Attacker).Attack(WildCreatures.get(Attackee));
            if (WildCreatures.get(Attackee).getDEAD() == true) {
                System.out.println("You have dropped " + WildCreatures.get(Attackee).getSpecies() + " to 0 health!");
                System.out.println("Would you like to attempt to Capture " + WildCreatures.get(Attackee).getSpecies() + " (Please answer with a yes or no!)");
                Capture = Scanner.nextLine();
                Capture.toLowerCase();
                while (!Capture.equals("yes") && !Capture.equals("no")) {
                    System.out.println("Please answer with yes or no!!!! (not cap sensitive)");
                    Capture = Scanner.nextLine();
                    Capture.toLowerCase();
                }
                if (Capture.equals("yes")) {
                    System.out.println("Attempting to Catch!");
                    int Catch = Random.nextInt(101);
                    if (Catch >= WildCreatures.get(Attackee).getCatchRate()) {
                        WildCreatures.get(Attackee).setDEAD(false);
                        WildCreatures.get(Attackee).resetForCapture();
                        Crew.add(WildCreatures.get(Attackee));
                        WildCreatures.remove(WildCreatures.get(Attackee));

                    }
                    if (Catch <= WildCreatures.get(Attackee).getCatchRate()) {
                        System.out.println("You have failed to catch the creature, they will be added to the GRAVEYARD!");
                        GRAVEYARD.add(WildCreatures.get(Attackee));
                        WildCreatures.remove(WildCreatures.get(Attackee));


                    }
                }
                if (Capture.equals("no")) {
                    System.out.println("You have decided not to capture " + WildCreatures.get(Attackee).getSpecies() + ", they will be added to the GRAVEYARD!!!");
                    GRAVEYARD.add(WildCreatures.get(Attackee));
                    WildCreatures.remove(WildCreatures.get(Attackee));
                }
            }




        }


        if (Choice == 2) {
            System.out.println(name + ", you have decided not to fight!");
            String message = ".....";
            slowPrint(message, 2000);
            System.out.println("Would you like to fight now..?");
            System.out.println("(1 for yes 2 for no, Additionally you may attempt to catch a creature with 3 or release a creature with 4!");
            if (Choice != 1 && Choice != 2 && Choice != 3 && Choice != 4) {
                System.out.println("Please input 1 or 2 or 3 or 4!!!");
            }
            Choice = Scanner.nextInt();
        }


        if (Choice == 3) {
            System.out.println("You have decided to try and catch a Creature! Know that they have a better chance of being caught after you fight them!");
            System.out.println("Who would you like to try and catch?");
            for (int i = 0; i < WildCreatures.size(); i++) {
                System.out.println(i + " for " + WildCreatures.get(i).getSpecies());
            }
            TryingToCatch = Scanner.nextInt();
            while (TryingToCatch > 0 || TryingToCatch > WildCreatures.size() - 1) {
                System.out.println("Not a valid choice must be between 0 and " + (WildCreatures.size() - 1));
            }
            int Catch = Random.nextInt(101);
            if (Catch >= WildCreatures.get(Attackee).getCatchRate()+ 10) {
                System.out.println("You have caught " + WildCreatures.get(Attackee).getSpecies() + "!!!");
                Crew.add(WildCreatures.get(TryingToCatch));
                WildCreatures.remove(WildCreatures.get(TryingToCatch));
            }
            if (Catch <= WildCreatures.get(Attackee).getCatchRate() + 10) {
                System.out.println("You have failed to catch the creature!!!");
            }
        }


        if (Choice == 4) {
            System.out.println("YOU HAVE SELECTED TO RELEASE A CREATURE ARE YOU POSITIVE??? (TYPE POSITIVE IF YOU ARE SURE, ANY OTHER RESPONSE WILL CANCEL THE RELEASE");
            Scanner.nextLine();
            Release = Scanner.nextLine();
            if (Release.equalsIgnoreCase("positive")) {
                for (int i = 0; i < Crew.size(); i++) {
                    System.out.println(i + " for " + Crew.get(i).getSpecies());
                }
                System.out.println("Please Select which Creature you would like to release");
                ReleaseOption = Scanner.nextInt();
                while (ReleaseOption < 0 || ReleaseOption > Crew.size() - 1) {
                    System.out.println("Invalid choice options must range from 0 to " + (Crew.size() - 1 + " "));
                    ReleaseOption = Scanner.nextInt();
                    WildCreatures.add(Crew.get(ReleaseOption));
                    Crew.remove(ReleaseOption);
                }


            }
        }


    }
}


public static void slowPrint (String text,long delayMillis){
    for (char c : text.toCharArray()) {
        System.out.print(c);
        try {
            Thread.sleep(delayMillis);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.err.println("The delay was interrupted");
        }
    }
}


