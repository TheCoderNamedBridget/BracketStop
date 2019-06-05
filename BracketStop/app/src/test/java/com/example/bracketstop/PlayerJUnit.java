package com.example.bracketstop;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 *
 *  This class tests all of the characteristics of a player.
 *
 *  @author  Nhavin Rangarajan
 *  @version May 27, 2019
 *  @author  Period: 1
 *  @author  Assignment: TornamentBracketSystem
 *
 *  @author  Sources: None
 */
public class PlayerJUnit
{
    Player p;
    String name;
    String school;
    int grade;
    int weight;

    /**
     *
     * Tests the name of the player
     */
    @Test
    public void testPlayerName()
    {
        name = "Nhavin";
        p = new Player(name, "Lynbrook", 12, 170);
        assertEquals(p.getName(), name);
    }

    /**
     *
     * Tests the school of the player
     */
    @Test
    public void testPlayerSchool()
    {
        school = "Lynbrook";
        p = new Player("Bridget", school, 12, 140);
        assertEquals(p.getSchool(), school);
    }

    /**
     *
     * Tests the grade level of the player
     */
    @Test
    public void testPlayerGrade()
    {
        grade = 12;
        p = new Player("Jay", "Lynbrook", grade, 160);
        assertEquals(p.getGrade(), grade);
    }

    /**
     *
     * Tests the weight (in lbs) of the player
     */
    @Test
    public void testPlayerWeight()
    {
        weight = 170;
        p = new Player("Nhavin", "Lynbrook", 12, weight);
        assertEquals(p.getWeight(), weight);
    }



}
