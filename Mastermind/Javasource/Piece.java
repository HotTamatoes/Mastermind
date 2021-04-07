import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;
/**
 * Write a description of class Piece here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public abstract class Piece extends Actor
{
    int colour, stopBreakStart;
    Proctor p;
    public void Piece(Proctor proc) 
    {
        p = proc;
    }
    public abstract void act();
    public abstract int getColour();
}
