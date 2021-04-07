import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class BluePiece here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class BluePiece extends Piece
{
    int colour, sBS;
    Proctor p;
    public BluePiece(Proctor proc)
    {
        sBS = 0;
        colour = 5;
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
