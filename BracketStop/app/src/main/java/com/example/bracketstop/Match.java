//package com.example.bracketstop;
//
////package Project;
//
//import java.time.LocalTime;
//import java.util.*;
//
//
///**
// *WE DID NOT END UP USING THIS CLASS
// *
// * @author Jay Kim
// * @version
// * @author Period: 1
// * @author Assignment: Final_Project_TornamentBracketSystem
// *
// * @author Sources: None
// */
//public class Match
//{
//
//    private Player self;
//
//    private Player opponent;
//
//    private LocalTime start;
//
//    private LocalTime end;
//
//    private int duration;
//
//    private int selfPts;
//
//    private int opponentPts;
//
//    private boolean result;
//
//    /**
//     *
//     * @param self the Player
//     * @param opponent the opponent
//     */
//    public Match( Player self, Player opponent  )
//    {
//        this.self = self;
//        this.opponent = opponent;
//
//    }
//
//    /**
//     *
//     * Sets the start time of the match by getting the current time in real time
//     */
//    public void setStartTime()
//    {
//        start = java.time.LocalTime.now();
//    }
//
//
//    /**
//     *
//     * Sets the end time of the match by getting the current time in real time
//     * Also sets the duration the moment of setting the end time
//     */
//    public void setEndTime()
//    {
//        end = java.time.LocalTime.now();
//        duration = end.compareTo( start );
//    }
//
//
//
//    //getter methods
//
//    /**
//     *
//     * returns this Player
//     * @return self this Player
//     */
//    public Player getSelf()
//    {
//        return self;
//    }
//
//
//    /**
//     *
//     * returns the opponent of this Match
//     * @return opponent the opponent
//     */
//    public Player getOpponent()
//    {
//        return opponent;
//    }
//
//
//    /**
//     *
//     * Gets duration of the match by comparing start and end times
//     * @return duration the duration of the match
//     */
//    public int getDuration()
//    {
//        return duration;
//    }
//
//    /**
//     *
//     * returns the current number of points of this player
//     * @return selfPts the points of this Player
//     */
//    public int getOwnPoints()
//    {
//        return selfPts;
//    }
//
//    /**
//     *
//     * returns the current number of points of opponent
//     * @return opponentPts the points of this Player's opponent
//     */
//    public int getOpponentPoints()
//    {
//        return opponentPts;
//    }
//
//
//    /**
//     *
//     * returns the current number of points of this player
//     * true if this player wins, false if opponent wins
//     *
//     * @return result the result of the match
//     */
//    public boolean getResult()
//    {
//        return result;
//    }
//
//
//
//
//}
//
//
//
