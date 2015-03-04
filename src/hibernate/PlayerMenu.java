package hibernate;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.Query;

import java.util.List;
import java.util.Iterator;
import org.hibernate.SQLQuery;

/**
 *
 * @author Architect
 */
public class PlayerMenu {

    private List<Player> players;

    void addPlayer(String firstName, String lastName, Integer position, Integer jerseyNumber, String university) {

        Session session = ConnectDB.getSessionFactory().getCurrentSession();
        Transaction transaction = session.beginTransaction();

        try {

            Player newPlayer = new Player();
            Position playerPosition = new Position();
            playerPosition.setPositionID(position);
            newPlayer.setFirstName(firstName);
            newPlayer.setLastName(lastName);
            newPlayer.setPosition(playerPosition);
            newPlayer.setJerseyNumber(jerseyNumber);
            newPlayer.setUniversity(university);

            session.save(newPlayer);

            transaction.commit();

            System.out.println("\nThank you. " + newPlayer.getFirstName() + " " + newPlayer.getLastName() + " has been added to the database.");

        } catch (Exception e) {

            System.err.println("Error entering player into the system");
            transaction.rollback();

        }

    }

    void listPlayers() {

        Session session = ConnectDB.getSessionFactory().getCurrentSession();
        Transaction transaction = session.beginTransaction();
        Query allPlayers = session.createQuery("select p from Player as p");

        players = allPlayers.list();

        System.out.printf("%-3s%-16s%-16s%-20s%-10s%s\n", "ID", "First Name", "Last Name", "Position", "Jersey", "University");
        System.out.println("--- ------------ ----------- ------------- -------- ------------");

        Iterator<Player> playerList = players.iterator();

        while (playerList.hasNext()) {

            Player element = playerList.next();
            System.out.println(element.outputString2());

        }

        transaction.commit();

    }

    void removePlayer(Integer playerID) {

        // TODO Auto-generated method stub
        Session session = ConnectDB.getSessionFactory().getCurrentSession();
        Transaction transaction = session.beginTransaction();
        Query beforeRemoval = session.createQuery("select p from Player as p");
        players = beforeRemoval.list();
        int numPlayersBefore = players.size();
        Integer input = playerID;
        Iterator<Player> playerListBefore = players.iterator();

        System.out.println("\nNumber of Players Before Removal: " + numPlayersBefore);

        try {

            System.out.println("Deleting player: " + players.get(input - 1).getFirstName() + " " + players.get(input - 1).getLastName() + " (Player ID: " + players.get(input - 1).getPlayerID() + ")");
            Query removePlayer = session.createQuery("delete Player where player_id = :input");
            removePlayer.setParameter("input", input);
            removePlayer.executeUpdate();

            Query afterRemoval = session.createQuery("select p from Player as p");
            players = afterRemoval.list();
            Integer numPlayersAfter = players.size();

            System.out.println("Number of Players After Removal: " + numPlayersAfter);

            System.out.printf("%-3s%-16s%-16s%-20s%-10s%s\n", "ID", "First Name", "Last Name", "Position", "Jersey", "University");
            System.out.println("--- ------------ ----------- ------------- -------- ------------");

            Iterator<Player> playerListAfter = players.iterator();

            while (playerListAfter.hasNext()) {

                Player element = playerListAfter.next();
                System.out.println(element.outputString2());

            }

            transaction.commit();

        } catch (Exception e) {

            if (input > numPlayersBefore) {
                System.err.println("Error: Out of range Player ID");
                transaction.rollback();

            } else {

                System.err.println("Error deleting player from the database");

            }

        }

    }

    void removeAllPlayers() {

        Session session = ConnectDB.getSessionFactory().getCurrentSession();
        Transaction transaction = session.beginTransaction();
        Query allPlayers = session.createQuery("select p from Player as p");
        players = allPlayers.list();
        int numPlayers = players.size();

        for (int i = 0; i < numPlayers; i++) {

            System.out.println("Deleting player " + players.get(i).getFirstName() + " " + players.get(i).getLastName());
            session.delete(players.get(i));
        }

        transaction.commit();

        players.clear();

    }

    void resetAI() {

        Session session = ConnectDB.getSessionFactory().getCurrentSession();
        Transaction transaction = session.beginTransaction();

        SQLQuery resetAI = session.createSQLQuery("ALTER TABLE player AUTO_INCREMENT = 1");
        resetAI.executeUpdate();

        transaction.commit();

    }

}
