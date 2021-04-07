import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;
/**
 * Write a description of class Key here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Key extends Actor
{
    int key[], gt;
    World w;
    public Key(int gametype, World wold) // (4, 6, 8)
    {
        //initiate all instance variables no key specified -> automatically empty
        key = new int[gametype];
        gt = gametype;
        w = wold;
    }
    public Key(int[] given, int gametype, World wold)
    {
        //used to convert a given array into a key
        key = Arrays.copyOf(given, gametype);
        gt = gametype;
        w = wold;
    }
    public void random()
    { //randomizes the array
        ArrayList<Integer> knew = new ArrayList<Integer>();
        for(int i = 0; i < 8; i++)
            knew.add(i);
        for(int i = 0; i < key.length; i++)
            key[i] = knew.remove(Greenfoot.getRandomNumber(knew.size()));
    }
    public int[] getKey()//key accessor
    {
        return key;
    }
}
