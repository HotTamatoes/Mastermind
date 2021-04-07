import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class LightbluePiece here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class LightbluePiece extends Piece
{
    int colour, sBS;
    Proctor p;
    public LightbluePiece(Proctor proc)
    {
        sBS = 0;
        colour = 4;
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
