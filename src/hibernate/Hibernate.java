package hibernate;

/**
 *
 * @author Architect
 */
public class Hibernate {

    public static void main(String[] args) {

        PlayerMenu playerMenu = new PlayerMenu();
        String firstName, firstName2, lastName, lastName2, university, university2;
        Integer position, position2, jerseyNumber, jerseyNumber2, playerID, playerID2;

        firstName = "Jonathan";
        lastName = "Lundberg";
        position = 4;
        jerseyNumber = 57;
        university = "BYU-I";
        firstName2 = null;
        lastName2 = null;
        position2 = null;
        jerseyNumber2 = null;
        university2 = null;
        playerID = 3;
        playerID2 = 107;

        // Show normal operation of the addPlayer method
        System.out.println("Correct usage of the addPlayer method");
        playerMenu.addPlayer(firstName, lastName, position, jerseyNumber, university);

        // Add more rows to the database
        playerMenu.addPlayer("Jasmine", "Latimer", 3, 24, "BYU-I");
        playerMenu.addPlayer("Craig", "Morris", 1, 34, "BYU-I");
        playerMenu.addPlayer("Kevin", "Kopsa", 2, 79, "BYU-I");
        playerMenu.addPlayer("Colton", "Kopsa", 5, 88, "BYU-I");
        playerMenu.addPlayer("Jacob", "Moore", 2, 42, "BYU-I");

        // Show misuse of the addPlayer method
        System.out.println("Attemping to null values as parameters to the addPlayer method");
        playerMenu.addPlayer(firstName2, lastName2, position2, jerseyNumber2, university2);

        // List all players in the database
        System.out.println("\nList all players in the database");
        playerMenu.listPlayers();

        // Show normal operation of the removePlayer method
        System.out.println("\nCorrect usage of the removePlayer method");
        playerMenu.removePlayer(playerID);

        // Show misuse of the removePlayer method
        System.out.println("\nAttempting to remove a player by passing an out-of-range parameter");
        System.out.println("(deleting a row where the player_id value doesn't exist)");
        playerMenu.removePlayer(playerID2);

        // Remove all rows from the database
        System.out.println("Remove ALL the players");
        playerMenu.removeAllPlayers();

        // Reset AUTO_INCREMENT on the 'PLAYER' table
        playerMenu.resetAI();
    }

}
