/**
 * This package handels all the normal coding of the assignment
 *
 * @author Crestena Khidhir
 * Email: ckhidhir@uoguelph.ca
 * Student Number: 1036541
 * @since 23/09/2019
 * Purpose: Assist a Dungeon Master in creating a dungeon
 */
package algorithm;

import java.util.Scanner;
import java.util.ArrayList;
import dnd.models.ChamberContents;
import dnd.models.ChamberShape;
import dnd.models.Exit;
import dnd.models.Monster;
import dnd.exceptions.NotProtectedException;
import dnd.models.Stairs;
import dnd.models.Trap;
import dnd.models.Treasure;
import dnd.exceptions.UnusualShapeException;

public class KhidhirA1 {
    /**
     * main method.
     * displays the menu for the user and calls all other methods
     * @param args arguments for running the code (none are used)
     */
    public static void main(final String[] args) {
        /*Welcome Message*/
        System.out.println("************************************************");
        System.out.println("           Welcome To Dungeon Creator           ");
        System.out.println("************************************************");

        /*Variable Declaration*/
        Scanner kbscanner = new Scanner(System.in);

        /*User choices are preset to defaults*/
        String menuChoice = "0";
        String diceChoice = "n";

        /*Input*/
        /*While the user chooses to use the program they remain in a
        while loop as to navigate the menu*/
        do {
            System.out.println(
                "\nPlease select an option from the menu below:");
            System.out.println(
                "(1) Generate a chamber");
            System.out.println(
                "(2) Generate the size and shape of a chamber");
            System.out.println(
                "(3) Generate the contents of a chamber");
            System.out.println(
                "(4) Generate treasure");
            System.out.println(
                "(5) Exit Program");
            System.out.print(
                "Your choice: ");
            menuChoice = kbscanner.nextLine();

            /*Forces the user to input a valid answer by
            comparing their input to string options*/
            while (!menuChoice.equals("1") && !menuChoice.equals("2")
             && !menuChoice.equals("3") && !menuChoice.equals("4")
              && !menuChoice.equals("5")) {
                System.out.print(
                    "please input a valid response: ");

                menuChoice = kbscanner.nextLine();
            }

            /*Processing*/
            /*Depending on their choice
            the corrosponding menu option is selected*/
            if (menuChoice.equals("1")) {
                System.out.print(
                    "Would you like to use your own dice? (y/n): ");

                diceChoice = kbscanner.nextLine();

                /*Forces the user to input a valid answer by
                comparing their input to string options*/
                while (!diceChoice.equals("y") && !diceChoice.equals("n")) {
                    System.out.print(
                        "please input a valid response: ");

                    diceChoice = kbscanner.nextLine();
                }

                /*Depending on choice,
                the progrm will either run manually or automatically
                calling the proper methods*/
                if (diceChoice.equals("y")) {
                    manualChamberShape();
                    manualChamberContents();
                } else if (diceChoice.equals("n")) {
                    automaticChamberShape();
                    automaticChamberContents();
                }
            } else if (menuChoice.equals("2")) {
                System.out.print(
                    "Would you like to use your own dice? (y/n): ");

                diceChoice = kbscanner.nextLine();

                while (!diceChoice.equals("y") && !diceChoice.equals("n")) {
                    System.out.print(
                        "please input a valid response: ");

                    diceChoice = kbscanner.nextLine();
                }

                if (diceChoice.equals("y")) {
                    manualChamberShape();
                } else if (diceChoice.equals("n")) {
                    automaticChamberShape();
                }
            } else if (menuChoice.equals("3")) {
                System.out.print(
                    "Would you like to use your own dice? (y/n): ");

                diceChoice = kbscanner.nextLine();

                while (!diceChoice.equals("y") && !diceChoice.equals("n")) {
                    System.out.print(
                        "please input a valid response: ");

                    diceChoice = kbscanner.nextLine();
                }

                if (diceChoice.equals("y")) {
                    manualChamberContents();
                } else if (diceChoice.equals("n")) {
                    automaticChamberContents();
                }
            } else if (menuChoice.equals("4")) {
                System.out.print(
                    "Would you like to use your own dice? (y/n): ");

                diceChoice = kbscanner.nextLine();

                while (!diceChoice.equals("y") && !diceChoice.equals("n")) {
                    System.out.print(
                        "please input a valid response: ");

                    diceChoice = kbscanner.nextLine();
                }

                if (diceChoice.equals("y")) {
                    manualTreasure();
                } else if (diceChoice.equals("n")) {
                    automaticTreasure();
                }
            } else if (menuChoice.equals("5")) {
                break;
            }
        } while (0 == 0);

        /*Goodbye Message*/
        System.out.println("");
        System.out.println("************************************************");
        System.out.println("         Thanks For Using This Program!         ");
        System.out.println("************************************************");
    } //main method

    /**
     * Takes in the user's input for dice values.
     * Creates the object type ChamberShape to create a shape/size decription
     * Exception used when shape is unusual
     *           thus length and width may not be calculated
     */
    public static void manualChamberShape() {
        ChamberShape shape = new ChamberShape();
        int dice = 0;

        ArrayList<Exit> userExitList;

        System.out.print(
            "\nPlease input dice value to roll for shape: ");

        dice = forceInteger();
        shape.setShape(dice);

        System.out.print(
            "Please input dice value to roll for number of exits: ");

        dice = forceInteger();
        shape.setNumExits(dice);

        userExitList = shape.getExits();

        System.out.println(
            "\n\tThe chamber is " + shape.getShape() + ".");

        try {
            System.out.println(
                "\tThe length is "
                 + shape.getLength()
                  + "' and the width is "
                   + shape.getWidth()
                    + "'");
        } catch (UnusualShapeException e) {
            System.out.println(
                "\tThe chamber's area is "
                 + shape.getArea()
                  + "sq ft.");
        }

        System.out.println(
            "\n\tThere are "
             + shape.getNumExits()
              + " exits:");

        for (Exit ex: userExitList) {
            System.out.print(
                "\tlocated "
                 + ex.getDirection());
            System.out.println(
                " on "
                 + ex.getLocation());
        }
    }

    /**
     * This method creates its own input for dice values.
     * Creates the object type ChamberShape to create a shape/size decription
     * Exception used when shape is unusual
     *           thus length and width may not be calculated
     */
    public static void automaticChamberShape() {
        ChamberShape shape = new ChamberShape();
        int dice = 0;

        ArrayList<Exit> userExitList;

        /*Rolls the dice for the user*/
        dice = (int) ((Math.random() * 20) + 1);
        shape.setShape(dice);

        dice = (int) ((Math.random() * 20) + 1);
        shape.setNumExits(dice);

        userExitList = shape.getExits();

        System.out.println(
            "\n\tThe chamber is "
             + shape.getShape()
              + ".");

        try {
            System.out.println(
                "\tThe length is "
                 + shape.getLength()
                  + "' and the width is "
                   + shape.getWidth()
                    + "'");
        } catch (UnusualShapeException e) {
            System.out.println(
                "\tThe chamber's area is "
                 + shape.getArea()
                  + "sq ft.");
        }

        System.out.println(
            "\n\tThere are "
             + shape.getNumExits()
             + " exits:");

        for (Exit ex: userExitList) {
            System.out.print(
                "\tlocated "
                 + ex.getDirection());
            System.out.println(
                " on "
                 + ex.getLocation());
        }
    }

    /**
     * Takes in the user's input for dice values.
     * Creates all objects under ChamberContents to create
     * a description of the chamber along with its contents
     */
    public static void manualChamberContents() {
        ChamberContents contents = new ChamberContents();
        int dice  = 0;

        System.out.print(
            "\nPlease input dice value to roll for contents: ");

        dice = forceInteger();
        contents.setDescription(dice);

        System.out.print("\n\t");

        /*Depending on the results of the roll and the resultant contents,
        the proper methods for creating the contents are called*/
        if (contents.getDescription().equals("empty")) {
            System.out.println(
                "The chamber is empty.");
        } else if (contents.getDescription().equals("monster only")) {
            System.out.println(
                "In the chamber, there is "
                 + contents.getDescription());

            manualMonster();
        } else if (contents.getDescription().equals("monster and treasure")) {
            System.out.println(
                "In the chamber, there is "
                 + contents.getDescription());

            manualMonster();
            manualTreasure();
        } else if (contents.getDescription().equals("stairs")) {
            System.out.println(
                "In the chamber, there is "
                 + contents.getDescription());

            manualStairs();
        } else if (contents.getDescription().equals("trap")) {
            System.out.println(
                "In the chamber, there is a"
                 + contents.getDescription());

            manualTrap();
        } else if (contents.getDescription().equals("treasure")) {
            System.out.println(
                "In the chamber, there is "
                 + contents.getDescription());

            manualTreasure();
        }
    }

    /**
     * This method creates its own input for dice values.
     * Creates all objects under ChamberContents to create
     * a description of the chamber along with its contents
     */
    public static void automaticChamberContents() {
        ChamberContents contents = new ChamberContents();
        int dice  = 0;

        dice = (int) ((Math.random() * 20) + 1);
        contents.setDescription(dice);

        System.out.print("\n\t");

        /*Depending on the results of the roll and the resultant contents,
        the proper methods for creating the contents are called*/
        if (contents.getDescription().equals("empty")) {
            System.out.println(
                "The chamber is empty.");
        } else if (contents.getDescription().equals("monster only")) {
            System.out.println(
                "In the chamber, there is "
                 + contents.getDescription());

            automaticMonster();
        } else if (contents.getDescription().equals("monster and treasure")) {
            System.out.println(
                "In the chamber, there is "
                 + contents.getDescription());

            automaticMonster();
            automaticTreasure();
        } else if (contents.getDescription().equals("stairs")) {
            System.out.println(
                "In the chamber, there is "
                 + contents.getDescription());

            automaticStairs();
        } else if (contents.getDescription().equals("trap")) {
            System.out.println(
                "In the chamber, there is a"
                 + contents.getDescription());

            automaticTrap();
        } else if (contents.getDescription().equals("treasure")) {
            System.out.println(
                "In the chamber, there is "
                 + contents.getDescription());

            automaticTreasure();
        }
    }

    /**
     * Takes in the user's input for dice values.
     * Creates the object Monster to create a description of all mosters
     */
    public static void manualMonster() {
        Monster monster = new Monster();
        int dice = 0;

        System.out.print(
            "\nPlease input dice value to roll for monster: ");

        dice = forceInteger();
        monster.setType(dice);

        System.out.print("\n\t");

        System.out.println(
            "A "
             + monster.getDescription()
             + " appears! There is between "
              + monster.getMinNum()
               + " and "
               + monster.getMaxNum()
                + " of them");
    }

    /**
     * This method creates its own input for dice values.
     * Creates the object Monster to create a description of all mosters
     */
    public static void automaticMonster() {
        Monster monster = new Monster();
        int dice = 0;

        dice = (int) ((Math.random() * 20) + 1);
        monster.setType(dice);

        System.out.print("\n\t");

        System.out.println(
            "A "
             + monster.getDescription()
             + " appears! There is between "
              + monster.getMinNum()
               + " and "
               + monster.getMaxNum()
                + " of them");
    }

    /**
     * Takes in the user's input for dice values.
     * Creates the object Stairs to create a complete description of all stairs
     * This includes their location
     */
    public static void manualStairs() {
        Stairs stairs = new Stairs();
        int dice = 0;

        System.out.println(
            "\nPlease input dice value to roll for stairs:");
        dice = forceInteger();
        stairs.setType(dice);

        System.out.print("\n\t");

        System.out.println(
            "They are "
             + stairs.getDescription());
    }

    /**
     * This method creates its own input for dice values.
     * Creates the object Stairs to create a complete description of all stairs
     * This includes their location
     */
    public static void automaticStairs() {
        Stairs stairs = new Stairs();
        int dice = 0;

        dice = (int) ((Math.random() * 20) + 1);
        stairs.setType(dice);

        System.out.print("\n\t");

        System.out.println(
            "\nThey are "
             + stairs.getDescription());
    }

    /**
     * Takes in the user's input for dice values.
     * Creates the object Trap to create a complete description of all Traps
     */
    public static void manualTrap() {
        Trap trap = new Trap();
        int dice = 0;

        System.out.print(
            "\nPlease input dice value to roll for trap: ");
        dice = forceInteger();
        trap.setDescription(dice);

        System.out.print("\n\t");

        System.out.println(
            "There is a "
             + trap.getDescription());
    }

    /**
     * This method creates its own input for dice values.
     * Creates the object Trap to create a complete description of all Traps
     */
    public static void automaticTrap() {
        Trap trap = new Trap();
        int dice = 0;

        dice = (int) ((Math.random() * 20) + 1);
        trap.setDescription(dice);

        System.out.print("\n\t");

        System.out.println(
            "There is a " + trap.getDescription());
    }

    /**
     * Takes in the user's input for dice values.
     * Creates the object Treasure to output a description of all Treasures
     * This inlcludes the type of treasure, its container and any protection
     * Exception when there is no protection that may not be outputted
     */
    public static void manualTreasure() {
        Treasure treasure = new Treasure();
        int dice = 0;

        Scanner kbscanner = new Scanner(System.in);

        System.out.println("");

        System.out.print(
            "Please input dice value to roll for treasure description: ");

        dice = forceInteger100();
        treasure.setDescription(dice);

        System.out.print(
            "Please input dice value to roll for treasure container: ");

        dice = forceInteger();
        treasure.setContainer(dice);

        System.out.print("\n\t");

        if (treasure.getContainer() != null) {
            System.out.println(
            "The treasure is "
             + treasure.getDescription()
             + " and it is contained in "
             + treasure.getContainer());
        } else {
            System.out.println(
            "The treasure is "
             + treasure.getDescription());
        }


        try {
            System.out.println(
                "\tThere is a "
                 + treasure.getProtection()
                  + " protection");
        } catch (NotProtectedException e) {
            System.out.println(
                "\tThere is no protection for the treasure");
        }
    }

    /**
     * This method creates its own input for dice values
     * Creates the object Treasure as to create a complete description
     * of any Traps in the chamber. This includes the type of
     * treasure along with its container and any protection on it
     * Exception used when the treasure is not proteced
     *           thus the protection may not be outputted
     */
    public static void automaticTreasure() {
        Treasure treasure = new Treasure();
        int dice = 0;

        dice = (int) ((Math.random() * 100) + 1);
        treasure.setDescription(dice);

        dice = (int) ((Math.random() * 100) + 1);
        treasure.setContainer(dice);

        System.out.print("\n\t");

        if (treasure.getContainer() != null) {
            System.out.println(
            "The treasure is "
             + treasure.getDescription()
             + " and it is contained in "
             + treasure.getContainer());
        } else {
            System.out.println(
            "The treasure is "
             + treasure.getDescription());
        }

        try {
            System.out.println(
                "\tThere is a "
                 + treasure.getProtection()
                  + " protection");
        } catch (NotProtectedException e) {
            System.out.println(
                "\tThere is no protection for the treasure");
        }
    }

    /**
     * (1-20)
     * Ensures that a given input for a dice roll is vallid.
     * Taking in the user'sstring and comparing it to valid integers
     * Used throughout the program in most intances of asking for a dice roll
     * Exception ensures that integer parsing is succesful
     * @return returnValue returns the integer value in the user string
     */
    public static int forceInteger() {
        Scanner kbscanner = new Scanner(System.in);
        String i = kbscanner.nextLine();

        int returnValue = 0;

        while (!i.equals("1") && !i.equals("2")
            && !i.equals("3") && !i.equals("4")
            && !i.equals("5") && !i.equals("6")
             && !i.equals("7") && !i.equals("8")
             && !i.equals("9") && !i.equals("10")
              && !i.equals("11") && !i.equals("12")
              && !i.equals("13") && !i.equals("14")
               && !i.equals("15") && !i.equals("16")
               && !i.equals("17") && !i.equals("18")
                && !i.equals("19") && !i.equals("20")) {
            System.out.print("Please input a valid response: ");
            i = kbscanner.nextLine();
        }

        try {
            returnValue = Integer.parseInt(i.trim());
        } catch (NumberFormatException e) {
            System.out.println("[Error] Not a Number");
        }

        return returnValue;
    }

    /**
     * (1-100)
     * Ensures that a given input for a dice roll is vallid.
     * Taking in the user'sstring and comparing it to valid integers
     * Used throughout the program in most intances of asking for a dice roll
     * Exception ensures that integer parsing is succesful
     * @return returnValue returns the integer value in the user string
     */
    public static int forceInteger100() {
        Scanner kbscanner = new Scanner(System.in);
        String i = "";

        int returnValue = 0;

        while (returnValue < 1 || returnValue > 100) {
            i = kbscanner.nextLine();

            try {
                returnValue = Integer.parseInt(i);
            } catch (NumberFormatException e) {
                returnValue = 0;
                System.out.println("[Error] Not a Number");
            }

            if (returnValue < 1 || returnValue > 100) {
                System.out.print("Please input a valid response: ");
            }
        }

        return returnValue;
    }
} //KhidhirA1 class
