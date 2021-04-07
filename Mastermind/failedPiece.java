import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class failedPiece here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class failedPiece extends Piece
{
    int colour;
    Proctor p;
    public failedPiece(Proctor proc)
    {
        colour = 9;
        p = proc;
    }
    public int getColour()
    {
        return colour;
    }
    public void act()
    {
        if(Greenfoot.mouseClicked(this))
        {
            p.putBoard(colour);
        }
    }
}
