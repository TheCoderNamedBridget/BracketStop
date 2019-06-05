package com.example.bracketstop;


import java.time.LocalTime;

import java.util.*;

import org.junit.Test;

import static org.junit.Assert.*;



/**
 *
 * JUnit test for TournamentBracket class
 *
 * @author Jay Kim
 * @version May 25, 2019
 * @author Period: 1
 * @author Assignment: TournamentBracket
 *
 * @author Sources:
 */
public class TournamentBracketTest
{
    TournamentBracket bracket;


    /**
     *
     * tests getNumPlayers method
     */
    @Test
    public void getNumPlayersTest()
    {
        bracket = new TournamentBracket( 4, null, null );
        assertEquals( bracket.getNumPlayers(), 4);
    }


    /**
     *
     * tests getWinnersQueue method
     */
    @Test
    public void getWinnersQueueTest()
    {
        bracket = new TournamentBracket( 4, null, null );
        assertNotNull( bracket.getWinnersQueue() );
    }


    /**
     *
     * test getLosersQueue method
     */
    @Test
    public void getLosersQueueTest()
    {
        bracket = new TournamentBracket( 4, null, null );
        assertNotNull( bracket.getLosersQueue() );
    }


    /**
     *
     * tests addPlayer method
     */
    @Test
    public void addPlayerTest()
    {
        bracket = new TournamentBracket( 4, null, null );
        bracket.addPlayer( null, new Player( "Jay", "Lynbrook", 12, 160 ) );
        assertEquals( bracket.getPlayerList().size(), 1 );
    }


    /**
     *
     * tests clearList method
     */
    @Test
    public void clearListTest()
    {
        Player Bridget = new Player( "Bridget", "Lynbrook", 12, 140);
        Player Nhavin = new Player( "Nhavin", "Lynbrook", 12, 150);
        Player Jay = new Player( "Jay", "Lynbrook", 12, 160 );

        bracket = new TournamentBracket( 4, null, null );
        bracket.addPlayer( null, Bridget );
        bracket.addPlayer( null, Nhavin );
        bracket.addPlayer( null, Jay );

        bracket.clearList( bracket.getPlayerList() );

        assertEquals( bracket.getPlayerList(), new ArrayList<Player>() );
    }


//
//
//    /**
//     *
//     * tests addWinner method
//     */
//    @Test
//    public void addWinnerTest()
//    {
//        bracket = new TournamentBracket( 4 );
//        Player Bridget = new Player( "Bridget", "Lynbrook", 12, "Class", 140, 20, null );
//        Player Nhavin = new Player( "Nhavin", "Lynbrook", 12, "Class", 150, 10, null );
//        bracket.addWinner( Bridget );
//        assertEquals(bracket.getWinnersQueue().remove(), Bridget);
//    }
//
//
//    /**
//     *
//     * Tests addLoser method
//     */
//    @Test
//    public void addLoserTest()
//    {
//        bracket = new TournamentBracket( 4 );
//        Player Bridget = new Player( "Bridget", "Lynbrook", 12, "Class", 140, 20, null );
//        Player Nhavin = new Player( "Nhavin", "Lynbrook", 12, "Class", 150, 10, null );
//        bracket.addLoser( Bridget );
//        assertEquals(bracket.getLosersQueue().remove(), Bridget);
//    }
//

//
//
//    /**
//     *
//     * tests pointsWinner method's first case in which first player has more
//     * points than second player
//     */
//    @Test
//    public void pointsWinner1stOver2nd()
//    {
//        bracket = new TournamentBracket( 4 );
//        Player Nhavin = new Player( "Nhavin", "Lynbrook", 12, "Class", 150, 20, null );
//        Player Jay = new Player( "Jay", "Lynbrook", 12, "Class", 160, 15, null );
//        assertEquals( bracket.pointsWinner( Nhavin, Jay ), Nhavin );
//    }
//
//    /**
//     *
//     * tests pointsWinner method's second case in which second player has more
//     * points than first player
//     */
//    @Test
//    public void pointsWinner2ndOver1st()
//    {
//        bracket = new TournamentBracket( 4 );
//        Player Nhavin = new Player( "Nhavin", "Lynbrook", 12, "Class", 150, 10, null );
//        Player Jay = new Player( "Jay", "Lynbrook", 12, "Class", 160, 15, null );
//        assertEquals( bracket.pointsWinner( Nhavin, Jay ), Jay );
//    }
//
//
//    /**
//     *
//     * tests pointsWinner method's first case in which both players have same
//     * points
//     */
//    @Test
//    public void pointsWinnerEqualPoints()
//    {
//        bracket = new TournamentBracket( 4 );
//        Player Nhavin = new Player( "Nhavin", "Lynbrook", 12, "Class", 150, 15, null );
//        Player Jay = new Player( "Jay", "Lynbrook", 12, "Class", 160, 15, null );
//        assertEquals( bracket.pointsWinner( Nhavin, Jay ), null );
//    }
//
//
//
//
//    /**
//     *
//     * tests pointsLoser method's first case in which second player has less
//     * points than first player
//     */
//    @Test
//    public void pointsLoser1stOver2nd()
//    {
//        bracket = new TournamentBracket( 4 );
//        Player Nhavin = new Player( "Nhavin", "Lynbrook", 12, "Class", 150, 20, null );
//        Player Jay = new Player( "Jay", "Lynbrook", 12, "Class", 160, 15, null );
//        assertEquals( bracket.pointsLoser( Nhavin, Jay ), Jay );
//    }
//
//    /**
//     *
//     * tests pointsLoser method's second case in which first player has less
//     * points than second player
//     */
//    @Test
//    public void pointsLoser2ndOver1st()
//    {
//        bracket = new TournamentBracket( 4 );
//        Player Nhavin = new Player( "Nhavin", "Lynbrook", 12, "Class", 150, 10, null );
//        Player Jay = new Player( "Jay", "Lynbrook", 12, "Class", 160, 15, null );
//        assertEquals( bracket.pointsLoser( Nhavin, Jay ), Nhavin );
//    }
//
//
//    /**
//     *
//     * tests pointsLoser method's first case in which both players have same
//     * amount of points
//     */
//    @Test
//    public void pointsLoserEqualPoints()
//    {
//        bracket = new TournamentBracket( 4 );
//        Player Nhavin = new Player( "Nhavin", "Lynbrook", 12, "Class", 150, 15, null );
//        Player Jay = new Player( "Jay", "Lynbrook", 12, "Class", 160, 15, null );
//        assertEquals( bracket.pointsLoser( Nhavin, Jay ), null );
//    }
//
//
//    /**
//     *
//     * tests getTime method
//     */
//    @Test
//    public void getTimeTest()
//    {
//        bracket = new TournamentBracket( 4 );
//        LocalTime test = bracket.getTime();
//        assertNotNull( test );
//    }
//
//
//    /**
//     *
//     * Tests winner method's first case in which there are no players in the
//     * bracket
//     */
//    @Test
//    public void winnerTestNoPeople()
//    {
//        Queue<Player> queue = new LinkedList<Player>();
//
//        bracket = new TournamentBracket( 4 );
//
//        bracket.winner( queue );
//
//        assertEquals( bracket.getWinnersQueue(), new LinkedList<Player>() );
//        assertEquals( bracket.getLosersQueue(), new LinkedList<Player>() );
//    }
//
//
//    /**
//     *
//     * Tests winner method's second case in which there is only one player in
//     * the bracket, making that player the champion
//     */
//    @Test
//    public void winnerTest1Person()
//    {
//        Player Bridget = new Player( "Bridget", "Lynbrook", 12, "Class", 140, 20, null );
//        Queue<Player> queue = new LinkedList<Player>();
//
//        bracket = new TournamentBracket( 4 );
//        bracket.addPlayer( Bridget );
//        for ( Player player : bracket.getPlayerList() )
//        {
//            queue.add( player );
//        }
//        bracket.winner( queue );
//
//        Queue<Player> winners = bracket.getWinnersQueue();
//
//        String result = "";
//
//        while ( !winners.isEmpty() )
//        {
//            result += winners.remove().getName();
//        }
//
//        assertEquals( result, "Bridget" );
//    }
//
//
//    /**
//     *
//     * Tests winner method's third case in which there is an even number
//     * of players( gets name from winners queue and losers queue )
//     */
//    @Test
//    public void winnerTest2People()
//    {
//        Player Nhavin = new Player( "Nhavin", "Lynbrook", 12, "Class", 150, 10, null );
//        Player Jay = new Player( "Jay", "Lynbrook", 12, "Class", 160, 15, null );
//        Queue<Player> queue = new LinkedList<Player>();
//
//        bracket = new TournamentBracket( 4 );
//        bracket.addPlayer( Nhavin );
//        bracket.addPlayer( Jay );
//        for ( Player player : bracket.getPlayerList() )
//        {
//            queue.add( player );
//        }
//
//        bracket.winner( queue );
//
//        Queue<Player> winners = bracket.getWinnersQueue();
//
//        String result1 = "";
//
//        while ( !winners.isEmpty() )
//        {
//            result1 += winners.remove().getName();
//        }
//
//        Queue<Player> losers = bracket.getLosersQueue();
//
//        String result2 = "";
//
//        while ( !losers.isEmpty() )
//        {
//            result2 += losers.remove().getName();
//        }
//
//        assertEquals( result1, "Jay" );
//        assertEquals( result2, "Nhavin" );
//    }
//
//
//    /**
//     *
//     * Tests winner method's third case in which there is an odd number
//     * of players( gets name from winners queue and losers queue )
//     */
//    @Test
//    public void winnerTest3People() {
//        Player Bridget = new Player("Bridget", "Lynbrook", 12, "Class", 140, 20, null);
//        Player Nhavin = new Player("Nhavin", "Lynbrook", 12, "Class", 150, 10, null);
//        Player Jay = new Player("Jay", "Lynbrook", 12, "Class", 160, 15, null);
//        Queue<Player> queue = new LinkedList<Player>();
//
//        bracket = new TournamentBracket(4);
//        bracket.addPlayer(Bridget);
//        bracket.addPlayer(Nhavin);
//        bracket.addPlayer(Jay);
//
//        for (Player player : bracket.getPlayerList()) {
//            queue.add(player);
//        }
//
//        bracket.winner(queue);
//
//        Queue<Player> winners = bracket.getWinnersQueue();
//
//        String result1 = "";
//
//        while (!winners.isEmpty()) {
//            result1 += winners.remove().getName();
//        }
//
//        Queue<Player> losers = bracket.getLosersQueue();
//
//        String result2 = "";
//
//        while (!losers.isEmpty()) {
//            result2 += losers.remove().getName();
//        }
//
//        assertEquals(result1, "BridgetJay");
//        assertEquals(result2, "Nhavin");
//
//    }


    }
