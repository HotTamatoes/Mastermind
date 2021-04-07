import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;
/**
 * Write a description of class Possibilities here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Possibilities extends Actor
{
    int[][] poss;
    public Possibilities(int gametype)
    {
        poss = new int[factorial(8)/factorial(8-gametype)][gametype];
        if(gametype == 4)
            render4();
        if(gametype == 6)
            render6();
        if(gametype == 8)
            render8();
        shuffle();
    }
    public int[][] getPoss()
    {
        return poss;
    }
    public void render4()
    {
        int counter = 0;
        for(int i = 0; i < 8; i++)
        {
            for(int j = 0; j < 8; j++)
            {
                for(int k = 0; k < 8; k++)
                {
                    for(int l = 0; l < 8; l++)
                    {
                        if(i != j && i != k && i != l && j != k && j!= l && k != l)
                        {
                            poss[counter][0] = i;
                            poss[counter][1] = j;
                            poss[counter][2] = k;
                            poss[counter][3] = l;
                            counter++;
                        }
                    }
                }
            }
        }
    }
    public void render6()
    {
        int counter = 0;
        for(int i = 0; i < 8; i++)
        {
            for(int j = 0; j < 8; j++)
            {
                for(int k = 0; k < 8; k++)
                {
                    for(int l = 0; l < 8; l++)
                    {
                        for(int m = 0; m < 8; m++)
                        {
                            for(int n = 0; n < 8; n++)
                            {
                                if(i != j && i != k && i != l && i != m && i!=n && j != k && j != l && j != m && j != n && k != l && k != m && k != n && l != m && l != n && m !=n)
                                {
                                    poss[counter][0] = i;
                                    poss[counter][1] = j;
                                    poss[counter][2] = k;
                                    poss[counter][3] = l;
                                    poss[counter][4] = m;
                                    poss[counter][5] = n;
                                    counter++;
                                }
                            }
                        }
                    }
                }
            }
        }
    }
    public void render8()
    {
        int counter = 0;
        for(int i = 0; i < 8; i++)
        {
            for(int j = 0; j < 8; j++)
            {
                for(int k = 0; k < 8; k++)
                {
                    for(int l = 0; l < 8; l++)
                    {
                        for(int m = 0; m < 8; m++)
                        {
                            for(int n = 0; n < 8; n++)
                            {
                                for(int o = 0; o < 8; o++)
                                {
                                    for(int p = 0; p < 8; p++)
                                    {
                                        if(i != j && i != k && i != l && i != m && i !=n && i != o && i != p && j != k && j != l && j != m && j != n && j != o && j != p && k != l && k != m && k != n && k != o && k != p && l != m && l != n && l != o && l != p && m != n && m != o && m != p && n != o && n != p && o != p)
                                        {
                                            poss[counter][0] = i;
                                            poss[counter][1] = j;
                                            poss[counter][2] = k;
                                            poss[counter][3] = l;
                                            poss[counter][4] = m;
                                            poss[counter][5] = n;
                                            poss[counter][6] = o;
                                            poss[counter][7] = p;
                                            counter++;
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }
    public void shuffle()
    {
        for(int i = 0; i < poss.length; i++)
        {
            int j = Greenfoot.getRandomNumber(poss.length);
            int temp[] = poss[i];
            poss[i] = poss[j];
            poss[j] = temp;
        }
    }
    public int factorial(int start)
    {
        int output = 1;
        if(start == 0 || start == 1)
            return output;
        return start * factorial(start - 1);
    }
}
