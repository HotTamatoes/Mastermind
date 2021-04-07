import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class BackPiece here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class BackPiece extends Piece
{
    int colour, stopBreakStart;
    Proctor p;
    public BackPiece(Proctor proc)
    {
        stopBreakStart = 0;
        colour = 8;
        p = proc;
    }
    public int getColour()
    {
        return colour;
    }
    public void act()
    {
        if(Greenfoot.mouseClicked(this) && stopBreakStart != 0)
        {
            p.putBoard(colour);
        }
        stopBreakStart++;
    }
}
