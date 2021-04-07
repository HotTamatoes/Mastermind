import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;
/**
 * Write a description of class Proctor here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Proctor extends Actor
{
    int[] userK, compK, toBeKey;
    LinkedList<Integer> pieceSpots = new LinkedList<Integer>(); //queue
    LinkedList<Piece> stackPiece = new LinkedList<Piece>(); //stack
    int gt, toBKPos, printer, sBS;
    Key key, solution;
    public boolean gameOver;
    World w;
    NextMove computer;
    public Proctor()
    {
        //should be useless
    }
    public Proctor(int gametype, World world)
    {
        w = world;
        
        //variables that keep track of game state
        sBS = 0; //stands for stop break start
        gameOver = false;
        
        //generate solution key
        solution = new Key(gametype, w);
        solution.random();
        
        //generate everything needed for user
        printer = 9;
        toBKPos = 0;
        gt = gametype;
        toBeKey = new int[gametype];
        
        //fill the pieceSpots array based on gametype
        if(gametype == 4)
        {
            for(int i = 9; i >= 0; i--)
            {
                for(int j = 0; j < gametype; j++)
                {
                    pieceSpots.addLast(132 + (int)(Math.round(37.2*j)));  //x
                    pieceSpots.addLast(52 + (int)(Math.round(37.2*i)));  //y
                }
                pieceSpots.addLast(-1); //new line
            }
        }
        else if(gametype == 6)
        {        
            for(int i = 9; i >= 0; i--)
            {
                for(int j = 0; j < gametype; j++)
                {
                    pieceSpots.addLast(94 + (int)(Math.round(37.32*j)));  //x
                    pieceSpots.addLast(56 + (int)(Math.round(37.45*i)));  //y
                }
                pieceSpots.addLast(-1); //new line
            }
        }
        else if(gametype == 8)
        {        
            for(int i = 9; i >= 0; i--)
            {
                for(int j = 0; j < gametype; j++)
                {
                    pieceSpots.addLast(57 + (int)(Math.round(37.32*j)));  //x
                    pieceSpots.addLast(56 + (int)(Math.round(37.45*i)));  //y
                }
                pieceSpots.addLast(-1); //new line
            }
        }
        
        //generate everything needed for computer
        computer = new NextMove(gametype, this, w);
    }
    public void act() //called periodically (~every 0.1s)
    {
        if(sBS != 0) //game has started
        {
            if(Greenfoot.isKeyDown("a"))
                putBoard(0);
            else if(Greenfoot.isKeyDown("s"))
                putBoard(1);
            else if(Greenfoot.isKeyDown("d"))
                putBoard(2);
            else if(Greenfoot.isKeyDown("f"))
                putBoard(3);
            else if(Greenfoot.isKeyDown("g"))
                putBoard(4);
            else if(Greenfoot.isKeyDown("h"))
                putBoard(5);
            else if(Greenfoot.isKeyDown("j"))
                putBoard(6);
            else if(Greenfoot.isKeyDown("k"))
                putBoard(7);
            else if(Greenfoot.isKeyDown("backspace"))
                putBoard(8); //BackPiece used for undo
            else if(Greenfoot.isKeyDown("enter")) //triggers a new game, note game does not have to be over
            {
                w.setBackground("BlackScreen.png");
                w.showText("Hit 4, 6, or 8 to chooses the game type", 450, 225);
                Greenfoot.setWorld(new MyWorld()); //shifts the game to a new world
            }
        }
        sBS++;
    }
    public void check(Key key) //against solution
    {
        int[] output = new int[2];
        
        //convert keys into arrays
        int[] keyArr = key.getKey();
        int[] solutionArr = solution.getKey();
        
        //goes through each array outputs to output[]
        for(int i = 0; i < keyArr.length; i++)
        {
            for(int j = 0; j < solutionArr.length; j++)
            {
                if(keyArr[i] == solutionArr[j])
                {
                    if(i == j)
                        output[1] = output[1] + 1;
                    else
                        output[0] = output[0] + 1;
                }
            }
        }
        
        //print key P is right place and colour, C is right colour wrong place
        if(gt == 4)
            w.showText("P:    " + output[1] + "     C:    " + output[0], 186, (54 + (int)(Math.round(37.2*printer))));
        else //6 and 8 change y the same amount
            w.showText("P:    " + output[1] + "     C:    " + output[0], 186, (58 + (int)(Math.round(37.45*printer))));
        
        printer--; //prints at the next highest y
        if(output[1] == gt && !gameOver) //user has all the pieces in the correct spot
        {
            w.showText("USER WINS (enter + 4,6,8 to play again)", 450, 15);
            printSolution();
            gameOver = true;
        }
    }
    public int[] check(int[] key, int[] key2) //method used by computer to check separate keys
    {
        int[] output = new int[2];
        for(int i = 0; i < key.length; i++)
        {
            for(int j = 0; j < key2.length; j++)
            {
                if(key[i] == key2[j])
                {
                    if(i == j)
                        output[1] = output[1] + 1;
                    else
                        output[0] = output[0] + 1;
                }
            }
        }
        return output;
    }
    public void putBoard(int colour) //called when a piece is clicked
    {
        Piece add = new failedPiece(this); //failedPiece will get rewritten
        if(gameOver)
            ; //game is donezoe -> do nothing
        else if(colour == 8) // player is removing a piece
        {
            w.showText(null, 450, 15);
            try
            {
                Piece lastPiece = stackPiece.pop();
                
                //using the queue as a stack temporarily to reverse the previous move
                pieceSpots.push(lastPiece.getY());
                pieceSpots.push(lastPiece.getX());
                w.removeObject(lastPiece); //Greenfoot's remove method
                toBKPos--;
            }
            catch(java.util.NoSuchElementException e) //User is trying to delete a previous key
            {
                w.showText("Sorry", 450, 15); //not allowed
            }
        }
        else
        {
            w.showText(null, 450, 15); //clears a "sorry" message
            if(colour == 0) //create a new piece
                add = new RedPiece(this);
            else if(colour == 1)
                add = new OrangePiece(this);
            else if(colour == 2)
                add = new YellowPiece(this);
            else if(colour == 3)
                add = new GreenPiece(this);
            else if(colour == 4)
                add = new LightbluePiece(this);
            else if(colour == 5)
                add = new BluePiece(this);
            else if(colour == 6)
                add = new PurplePiece(this);
            else if(colour == 7)
                add = new BlackPiece(this);
            //add the newly created piece to the stack for possible future removal
            stackPiece.push(add);
            
            //add the piece to the world, dequeueing x and y
            w.addObject(add, pieceSpots.removeFirst(), pieceSpots.removeFirst());
            
            //stores the piece's colour to create a potential key
            toBeKey[toBKPos] = colour;
            toBKPos++; //toBKPos is used for the implementation of the undo function
            if(pieceSpots.get(0) < 0) //full key has been input
            {
                toBKPos = 0; //new key
                pieceSpots.removeFirst();//get rid of the -1
                
                //generate and check the key
                key = new Key(toBeKey, gt, w);
                check(key); //user could win here
                
                //clear the stack so the user can't undo a key w/ output
                for(int i = 0; i < gt; i++)
                    stackPiece.pop();
                
                //Make the computer move
                Key a = computer.selectKey();
                computer.move(a);
            }
            if(pieceSpots.size() == 0 && !gameOver) //if no one has won by the time there are no moves
            {
                w.showText("Game is Over, no Winners (enter + 4,6,8 to play again)", 450, 15);
                gameOver = true;
                printSolution();
            }
        }
    }
    public void printSolution()
    {
        int key[] = solution.getKey(), count = 0; //store key as an array, count is used for printing
        for(int colour: key)
        {
            Piece add = new failedPiece(this); //piece gets overwritten
            if(colour == 0)
                add = new RedPiece(this);
            else if(colour == 1)
                add = new OrangePiece(this);
            else if(colour == 2)
                add = new YellowPiece(this);
            else if(colour == 3)
                add = new GreenPiece(this);
            else if(colour == 4)
                add = new LightbluePiece(this);
            else if(colour == 5)
                add = new BluePiece(this);
            else if(colour == 6)
                add = new PurplePiece(this);
            else if(colour == 7)
                add = new BlackPiece(this);
            
            //had to use different ratios for the different game types because of different spacing
            if(gt == 4)
                w.addObject(add, 769, 162 + (int)(Math.round(37.2*count)));
            else if(gt == 6)
                w.addObject(add, 806,133 + (int)(Math.round(37.45*count)));
            else if(gt == 8)
                w.addObject(add, 844,96 + (int)(Math.round(37.45*count)));
            count++;
        }
    }
}