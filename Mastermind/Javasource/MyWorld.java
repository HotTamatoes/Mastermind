import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MyWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MyWorld extends World
{
    Boolean keyHit;
    /**
     * Constructor for objects of class MyWorld.
     * 
     */
    public MyWorld()
    {    
        // Create a new world with 957x720 cells with a cell size of 1x1 pixels.
        super(900, 450, 1);
        setBackground("BlackScreen.png");
        showText("Hit 4, 6, or 8 to chooses the game type", 450, 225);
        keyHit = false;
    }

    public void act()
    {
        Proctor p = new Proctor(); //this proctor gets changed
        while(!keyHit)
        {
            if(Greenfoot.isKeyDown("4"))
            {
                keyHit = true;
                setBackground("Board4.png");
                p = new Proctor(4, this);
                prepare4(p);
            }
            else if(Greenfoot.isKeyDown("6"))
            {
                keyHit = true;
                setBackground("Board6.png");
                p = new Proctor(6, this);
                prepare6(p);
            }
            else if(Greenfoot.isKeyDown("8"))
            {
                keyHit = true;
                setBackground("Board8.png");
                p = new Proctor(8, this);
                prepare8(p);
            }
        }
        showText(null, 450, 225);
    }

    /**
     * Prepare the world for the start of the program.
     * That is: create the initial objects and add them to the world.
     */
    private void prepare4(Proctor p)
    {
        RedPiece redPiece = new RedPiece(p);
        addObject(p, 319, 90);
        addObject(redPiece,319,90);
        showText("a", 319, 90);
        //redPiece.setLocation(769, 162);
        
        OrangePiece orangePiece = new OrangePiece(p);
        addObject(orangePiece,319,127);
        showText("s", 319, 127);

        YellowPiece yellowPiece = new YellowPiece(p);
        addObject(yellowPiece,319,164);
        showText("d", 319, 164);

        GreenPiece greenPiece = new GreenPiece(p);
        addObject(greenPiece,319,202);
        showText("f", 319, 202);

        LightbluePiece lightbluePiece = new LightbluePiece(p);
        addObject(lightbluePiece,319,239);
        showText("g", 319, 239);

        BluePiece bluePiece = new BluePiece(p);
        addObject(bluePiece,319,276);
        showText("h", 319, 276);

        PurplePiece purplePiece = new PurplePiece(p);
        addObject(purplePiece,319,314);
        showText("j", 319, 314);

        BlackPiece blackPiece = new BlackPiece(p);
        addObject(blackPiece,319,351);
        showText("k", 319, 351);
        
        BackPiece backPiece = new BackPiece(p);
        addObject(backPiece,319,388);
    }

    /**
     * Prepare the world for the start of the program.
     * That is: create the initial objects and add them to the world.
     */
    private void prepare6(Proctor p)
    {
        RedPiece redPiece = new RedPiece(p);
        addObject(p, 356, 94);
        addObject(redPiece,356,94);
        showText("a", 356, 94);
        //redPiece.setLocation(806, 133);
        
        OrangePiece orangePiece = new OrangePiece(p);
        addObject(orangePiece,356,132);
        showText("s", 356, 132);

        YellowPiece yellowPiece = new YellowPiece(p);
        addObject(yellowPiece,356,169);
        showText("d", 356, 169);

        GreenPiece greenPiece = new GreenPiece(p);
        addObject(greenPiece,356,207);
        showText("f", 356, 207);

        LightbluePiece lightbluePiece = new LightbluePiece(p);
        addObject(lightbluePiece,356,244);
        showText("g", 356, 244);

        BluePiece bluePiece = new BluePiece(p);
        addObject(bluePiece,356,282);
        showText("h", 356, 282);

        PurplePiece purplePiece = new PurplePiece(p);
        addObject(purplePiece,356,319);
        showText("j", 356, 319);

        BlackPiece blackPiece = new BlackPiece(p);
        addObject(blackPiece,356,356);
        showText("k", 356, 356);
        
        BackPiece backPiece = new BackPiece(p);
        addObject(backPiece,356,394);
    }

    /**
     * Prepare the world for the start of the program.
     * That is: create the initial objects and add them to the world.
     */
    private void prepare8(Proctor p)
    {
        RedPiece redPiece = new RedPiece(p);
        addObject(p, 394, 94);
        addObject(redPiece,394,94);
        showText("a", 394, 94);
        //redPiece.setLocation(844, 96);
        
        OrangePiece orangePiece = new OrangePiece(p);
        addObject(orangePiece,394,132);
        showText("s", 394, 132);

        YellowPiece yellowPiece = new YellowPiece(p);
        addObject(yellowPiece,394,169);
        showText("d", 394, 169);

        GreenPiece greenPiece = new GreenPiece(p);
        addObject(greenPiece,394,207);
        showText("f", 394, 207);

        LightbluePiece lightbluePiece = new LightbluePiece(p);
        addObject(lightbluePiece,394,244);
        showText("g", 394, 244);

        BluePiece bluePiece = new BluePiece(p);
        addObject(bluePiece,394,282);
        showText("h", 394, 282);

        PurplePiece purplePiece = new PurplePiece(p);
        addObject(purplePiece,394,319);
        showText("j", 394, 319);

        BlackPiece blackPiece = new BlackPiece(p);
        addObject(blackPiece,394,356);
        showText("k", 394, 356);
        
        BackPiece backPiece = new BackPiece(p);
        addObject(backPiece,394,394);
    }
}
