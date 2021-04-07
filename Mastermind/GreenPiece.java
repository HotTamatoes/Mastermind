import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class GreenPiece here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class GreenPiece extends Piece
{
    int colour, sBS;
    Proctor p;
    public GreenPiece(Proctor proc)
    {
        sBS = 0;
        colour = 3;
        p = proc;
    }
    public int getColour()
    {
        return colour;
    }
    public void act()
    {
        if(Greenfoot.mouseClicked(this) && sBS != 0)
        {
            p.putBoard(colour);
        }
        sBS++;
    }
}
