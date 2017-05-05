/*Garrett Graber, CSC 220
4-27-2017 
A crudely drawn Pig that dances around the screen. To win the game, you have to click multiple times. You
may also have to click in the order of the points to delete them. This program can be sensitive.  
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csc220.program5.grabergc;

import csc220.program5.grabergc.List;
import csc220.program5.GameCharacter;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;

/**
 *
 * @author grabergc
 */
public class Pig extends GameCharacter {

    public Pig(int over, int down, int width, int height, int moveInterval) {
        super(over, down, width, height, moveInterval, new List <Point>());
        this.animationPath.add(new Point(over, down));
        this.animationPath.add(new Point(over + 50,down+100));
        this.animationPath.add(new Point(over+70,down+100));
        this.animationPath.add(new Point(over+100,down));
    }

   

    @Override
    public void draw(Graphics g) {
        g.setColor(Color.MAGENTA);
        g.fillOval(getOver(), getDown(), 50, 25);
       
        //head of pig 
        g.fillOval(getOver()-10, getDown()-15, 25, 25);
        
        //legs of pig
        g.fillRect(getOver()+8, getDown()+20 , 15, 15);
        g.fillRect(getOver()+28 , getDown()+20 , 15, 15);
    }
    
}
