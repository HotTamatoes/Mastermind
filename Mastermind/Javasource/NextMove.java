import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;
/**
 * Write a description of class NextMove here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class NextMove extends Actor
{
    LinkedList<Integer> moveList = new LinkedList<Integer>(); //queue
    int gt, moves, preOutputs[][][], possies[][];
    Possibilities poss;
    Proctor p;
    World w;
    public NextMove(int gametype, Proctor proc, World wold)
    {
        //stores game specific variables
        w = wold;
        gt = gametype;
        p = proc;
        moves = 0; //computer has made no moves
        
        //stores the computer's move possibilities in an array
        poss = new Possibilities(gametype);
        possies = poss.getPoss();
        
        //computer an only make ten moves and there are two arrays I want to store per move
        preOutputs = new int[10][2][];
        //the individual key lengths are different from the length of the game's output
        for(int i = 0; i < preOutputs.length; i++)
        {
            preOutputs[i][0] = new int[gametype];//first pos per move stores the key
            preOutputs[i][1] = new int[2];//second pos per move stores the game's output
        }
        
        //the different gametypes have different sets of places to put pieces
        if(gametype == 4)
        {
            for(int i = 9; i >= 0; i--)
            {
                for(int j = 0; j < gametype; j++)
                {
                    moveList.addLast(581 + (int)(Math.round(37.2*j)));  //x
                    moveList.addLast(50 + (int)(Math.round(37.2*i)));  //y
                }
                //note no -1 added because unnecessary
            }
        }
        else if (gametype == 6)
        {        
            for(int i = 9; i >= 0; i--)
            {
                for(int j = 0; j < gametype; j++)
                {
                    moveList.addLast(544 + (int)(Math.round(37.32*j))); //x
                    moveList.addLast(58 + (int)(Math.round(37.45*i)));  //y
                }
                //note no -1 added because unnecessary
            }
        }
        else if (gametype == 8)
        {        
            for(int i = 9; i >= 0; i--)
            {
                for(int j = 0; j < gametype; j++)
                {
                    moveList.addLast(506 + (int)(Math.round(37.5*j)));  //x
                    moveList.addLast(58 + (int)(Math.round(37.45*i)));  //y
                }
                //note no -1 added because unnecessary
            }
        }
    }
    public Key selectKey()
    {
        Key autoOutput = new Key(gt, w); autoOutput.random();
        for(int i = 0; i < possies.length; i++) 
        {   //goes through possible moves returning first working one
            try {
                autoOutput = new Key(possies[i], gt, w);
            }catch(java.lang.NullPointerException e){}//the key was tried in the past at some point
            possies[i] = null; //don't want to try the same key again - won't improve
            if(autoOutput != null && checkSelectKey(autoOutput)) //doublecheck the key is not null, then check if it works
                return autoOutput;
        }
        return autoOutput; //shouldn't run this line
    }
    /**
     * For every previous move the computer makes, the computer compares the previous move's output with the solution
     * to the current move's output with the previous move
     */
    public boolean checkSelectKey(Key input)
    {
        boolean good = true;
        for(int i = 0; i < moves; i++)
        {
            if(!compare(preOutputs[i][1],(p.check(preOutputs[i][0], input.getKey()))))
                good = false;
        }
        return good;
    }
    public boolean compare(int[] two, int[] one)//, boolean debug) // 0 for just colour
    { //tells if the move improves on the last move
        if(one[0] + one[1] >= two[0] + two[1] && one[1] >= two[1])// place + colour >= colour and place >= place
            return true;
        return false;
    }
    public void move(Key a)
    {
        //updates the computer's move knowledge
        preOutputs[moves][0] = a.getKey(); //the key itself
        preOutputs[moves][1] = p.check(a.getKey(), p.solution.getKey()); //the output with the solution
        
        //print the key
        for(int val: a.getKey())
        {
            if(val == 0)
                w.addObject(new RedPiece(p), moveList.remove(0), moveList.remove(0));
            else if(val == 1)
                w.addObject(new OrangePiece(p), moveList.remove(0), moveList.remove(0));
            else if(val == 2)
                w.addObject(new YellowPiece(p), moveList.remove(0), moveList.remove(0));
            else if(val == 3)
                w.addObject(new GreenPiece(p), moveList.remove(0), moveList.remove(0));
            else if(val == 4)
                w.addObject(new LightbluePiece(p), moveList.remove(0), moveList.remove(0));
            else if(val == 5)
                w.addObject(new BluePiece(p), moveList.remove(0), moveList.remove(0));
            else if(val == 6)
                w.addObject(new PurplePiece(p), moveList.remove(0), moveList.remove(0));
            else if(val == 7)
                w.addObject(new BlackPiece(p), moveList.remove(0), moveList.remove(0));
        }
        
        //check to see if the computer wins the game
        if(preOutputs[moves][1][1] == gt && !p.gameOver) //user must not have already won
        {
            w.showText("Computer wins! (enter + 4,6,8 to play again)", 450, 15);
            p.printSolution();
            p.gameOver = true;
        }
        moves++;
    }
}