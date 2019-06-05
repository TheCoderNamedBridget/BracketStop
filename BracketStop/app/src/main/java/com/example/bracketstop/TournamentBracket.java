package com.example.bracketstop;
import java.sql.Time;
import java.time.LocalTime;
import java.util.*;


/**
 *
 *
 * @author Jay Kim
 * @version May 24, 2019
 * @author Period - 1
 *
 * @author Assignment -
 *
 * @author Sources -
 */

public class TournamentBracket
{


    ArrayList<Player> playerList = new ArrayList<Player>();

    int numPlayers;

    Queue<Player> winnersQueue = new LinkedList<Player>();

    Queue<Player> losersQueue = new LinkedList<Player>();



    //Initializes number of players
    public TournamentBracket(int numPlayers, Queue<Player> winnersQueue, Queue<Player> losersQueue )
    {
        this.numPlayers = numPlayers;
        this.winnersQueue = winnersQueue;
        this.losersQueue = losersQueue;
    }



    public void addPlayer( Queue queue, Player player )
    {
        queue.add(player);
        playerList.add( player );
    }


    /**
     * returns number of Players
     * @return numPlayers the number of Players in the roster
     */
    public int getNumPlayers()
    {
        return numPlayers;
    }


    /**
     * returns the ArrayList of Players
     * @return playerList the roster of Players
     */
    public ArrayList<Player> getPlayerList()
    {
        return playerList;
    }


    /**
     * returns the queue of winners
     * @return winnersQueue the queue of winners
     */
    public Queue<Player> getWinnersQueue()
    {
        return winnersQueue;
    }

    /**
     * returns the queue of losers
     * @return winnersQueue the queue of losers
     */
    public Queue<Player> getLosersQueue()
    {
        return losersQueue;
    }




    /**
     *
     * Adds the winner to the winners bracket
     * @param player a Player
     */
    public void addWinner(Player player)
    {
        winnersQueue.add( player );
    }


    /**
     *
     * Adds the loser to the losers bracket
     * @param player a Player
     */
    public void addLoser(Player player)
    {
        losersQueue.add( player );
    }


    /**
     *
     * Clears the roster of players
     * @param list the list to clear
     */
    public void clearList( ArrayList<Player> list )
    {
        list.clear();
    }

//    /**
//     *
//     * Returns winner of a match
//     * @param p1 first player
//     * @param p2 second player
//     * @return the winner, null if there is none
//     */
//    public Player pointsWinner( Player p1, Player p2 )
//    {
//        if ( p1.getPts() > p2.getPts() )
//        {
//            return p1;
//        }
//        else if ( p1.getPts() < p2.getPts() )
//        {
//            return p2;
//        }
//        return null;
//    }
//
//    /**
//     *
//     * Returns loser of a match
//     * @param p1 first player
//     * @param p2 second player
//     * @return the loser, null if there is none
//     */
//    public Player pointsLoser( Player p1, Player p2 )
//    {
//        if ( p1.getPts() > p2.getPts() )
//        {
//            return p2;
//        }
//        else if ( p1.getPts() < p2.getPts() )
//        {
//            return p1;
//        }
//        return null;
//    }
//
//    public LocalTime getTime()
//    {
//        return java.time.LocalTime.now();
//    }
//
//
//
//    /**
//     *
//     * Returns a queue of winners from an existing queue. Can use this over and
//     * over
//     *
//     * @param queue
//     *            the queue to get the winner from
//     * @return winner
//     *              the winner's queue
//     */
//    public void winner( Queue<Player> queue )
//    {
//        if ( queue.size() % 2 == 0 )
//        {
//            for ( int i = 0; i < queue.size(); i = i + 2 )
//            {
//                Player prev = queue.remove();
//                Player next = queue.remove();
//                winnersQueue.add( pointsWinner( prev, next ) );
//                losersQueue.add( pointsLoser( prev, next ) );
//            }
//        }
//    }


}

