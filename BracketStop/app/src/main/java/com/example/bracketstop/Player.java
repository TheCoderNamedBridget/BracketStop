package com.example.bracketstop;

/**
 *
 *  This class creates a person, who has certain credentials like
 *  name, the school they attend, their grade level, their class, and their
 *  weight (in lbs?)
 *
 *  @author  Nhavin Rangarajan
 *  @version May 9, 2019
 *  @author  Period: 1
 *  @author  Assignment: Final_Project_TornamentBracketSystem
 *
 *  @author  Sources: None
 */
public class Player
{
    /**
     * Name of the person
     */
    private String name;

    /**
     * School of the person
     */
    private String school;

    /**
     * Grade of the person
     */
    private int grade;

    /**
     * Class of the person
     */
    private String myClass;

    /**
     * Weight of the person in lbs
     */
    private int weight;

    /**
     * Weight of the person in lbs
     */
    private int pts;

    /**
     *
     * @param name the name of the person
     * @param school the school of the person
     * @param grade the grade of the person
     * @param weight the weight of the person in lbs.
     */
    public Player( String name, String school, int grade, int weight )
    {
        this.name = name;
        this.school = school;
        this.grade = grade;
        this.weight = weight;
    }

    /**
     *
     * Returns the name of the person
     * @return name the name of the person
     */
    public String getName()
    {
        return name;
    }

    /**
     *
     * Returns the school of the person
     * @return school the school of the person
     */
    public String getSchool()
    {
        return school;
    }

    /**
     *
     * Returns the grade of the person.
     * @return grade the grade of the person.
     */
    public int getGrade()
    {
        return grade;
    }

    /**
     *
     * Returns the class of the person
     * @return myClass the class of the person
     */
    public String getMyClass()
    {
        return myClass;
    }

    /**
     *
     * Returns the weight of the person
     * @return weight the weight of the person
     */
    public int getWeight()
    {
        return weight;
    }

    /**
     *
     * Returns the weight of the person
     * @return weight the weight of the person
     */
    public int getPts()
    {
        return pts;
    }

}