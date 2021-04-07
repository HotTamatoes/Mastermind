import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class BlackPiece here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class BlackPiece extends Piece
{
    int colour, stopBreakStart;
    Proctor p;
    public BlackPiece(Proctor proc)
    {
        stopBreakStart = 0;
        colour = 7;
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
