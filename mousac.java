import java.awt.event.*;
import java.awt.*;
import javax.swing.*;
import java.applet.*;
import java.io.*;
import java.awt.Image;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import java.math.*;
public  class mousac extends Applet implements MouseListener, MouseMotionListener
{
    // instance variables - replace the example below with your own
    private int x;
    public int mx;
    public int my;
 
      static BufferedImage image1;    
      static BufferedImage image2; 
      public String fl;
      public int ix;
      public int iy;

    public void init()
    {
        
         fl=getParameter("filename");
         ix=Integer.parseInt(getParameter("ix"));
         iy=Integer.parseInt(getParameter("iy"));
       addMouseListener(this);
       addMouseMotionListener(this);
       
    }
    
//you may want to add a mediatracker here to make sure the file loaded fully.

 public void mouseMoved1(MouseEvent me){}
   public void mouseMoved(MouseEvent me)
   {
        try{
           image1 = ImageIO.read(new File(fl));
            
            
            }catch(Exception e){}
           

       
       mx=me.getX();
       if(mx>1000){mx=1000;}
       my=me.getY();
       if(my>1000){my=1000;}
       
      
       int x1h=image1.getHeight()/13;
       
       int x1w=image1.getWidth();
       
       int x1x=ix+x1w/2;//center of the image
       int x1y=iy+x1h/2;
        
        if(mx>250 && mx<450 && my>120 && my<500)
        {
           image2= image1.getSubimage(0,12*image1.getHeight()/13,image1.getWidth(),image1.getHeight()/13);//1
           repaint();
        }
       else{
           
        if(mx==x1x&&my==x1y)//front face
           {
            image2= image1.getSubimage(0,12*image1.getHeight()/13,image1.getWidth(),image1.getHeight()/13);//1
           repaint();
         }
        else if(mx==x1x&&my<x1y)//top face
        {
            
            image2= image1.getSubimage(0,9*image1.getHeight()/13,image1.getWidth(),image1.getHeight()/13);//2
            repaint();
        }
          else if(my==x1y&&mx>x1x)//right side face
       {
          
           image2= image1.getSubimage(0,0*image1.getHeight()/13,image1.getWidth(),image1.getHeight()/13);
           repaint();
        }
        
           else if(mx==x1x&&my>x1y)//down face
           {
              image2= image1.getSubimage(0,3*image1.getHeight()/13,image1.getWidth(),image1.getHeight()/13); //8
              repaint();
            }
             else if(my==x1y&&mx<x1x)//left face
           {
              image2= image1.getSubimage(0,7*image1.getHeight()/13,image1.getWidth(),image1.getHeight()/13); //11
              repaint();
            }
            
       if(mx>x1x&&my<x1y)//1st quad faces
       {
           //double d=Math.atan((x1y-my)/(x1x-mx));
           double d=Math.atan((x1y-my)/(mx-x1x));
           double d2=Math.atan(d);
            double theta1=Math.toDegrees(d2);
             showStatus("ix+x1w="+" iy+x1h="+iy+" mx="+mx+" my="+my);
            //showStatus(theta1+"x1x="+x1x+" x1y="+x1y+" mx="+mx+" my="+my);
           
           if(theta1<=30)
           {image2= image1.getSubimage(0,0*image1.getHeight()/13,image1.getWidth(),image1.getHeight()/13);
           
        }
               
         else if(theta1<=55)//
           {
            image2= image1.getSubimage(0,11*image1.getHeight()/13,image1.getWidth(),image1.getHeight()/13);//4
        }
        
        else if(theta1<75)//
        {
            
           image2= image1.getSubimage(0,10*image1.getHeight()/13,image1.getWidth(),image1.getHeight()/13); //3
          
        }
        else if(theta1<90)//
        {
            
           image2= image1.getSubimage(0,9*image1.getHeight()/13,image1.getWidth(),image1.getHeight()/26);//2
            
          
        }
         showStatus(theta1+"ix+x1w="+ix+x1w+" iy+x1h="+ix+x1w+" mx="+mx+" my="+my);
         //showStatus(theta1+"x1x="+x1x+" x1y="+x1y+" mx="+mx+" my="+my);
         repaint();
    }
       
       else if(my>x1y&&mx>x1x)//4th quad
       {
           ///////////////////////
           //double d=Math.atan((x1y-my)/(x1x-mx));
           double d=((my-x1y)/(mx-x1x));
           double d2=Math.atan(d);
            double theta1=Math.toDegrees(d2);
            showStatus(theta1+"ix+x1w="+ix+x1w+" iy+x1h="+ix+x1w+" mx="+mx+" my="+my);
            
            if(theta1<=30)//right face
           {image2= image1.getSubimage(0,0*image1.getHeight()/13,image1.getWidth(),image1.getHeight()/13);
           
        }
          else if(theta1<=55)//
           {
            image2= image1.getSubimage(0,image1.getHeight()/13,image1.getWidth(),image1.getHeight()/13);//6
        }
        
        else if(theta1<=75)//
        {
            
           image2= image1.getSubimage(0,2*image1.getHeight()/13,image1.getWidth(),image1.getHeight()/13); //7
          
        }
        else if(theta1<=90)
           {image2= image1.getSubimage(0,3*image1.getHeight()/13,image1.getWidth(),image1.getHeight()/13);
           
        }
         showStatus(theta1+"ix+x1w="+ix+x1w+" iy+x1h="+ix+x1w+" mx="+mx+" my="+my);
        //showStatus(theta1+"x1x="+x1x+" x1y="+x1y+" mx="+mx+" my="+my);
         repaint();
           ////////////
        }  
        
         else if(my>x1y&&mx<x1x)//3rd quad
       {
           
            ///////////////////////
            //double d=Math.atan((x1y-my)/(x1x-mx));
            double d=((my-x1y)/(x1x-mx));
            double d2=Math.atan(d);
            double theta1=Math.toDegrees(d2);
            showStatus(theta1+"x1x="+x1x+" x1y="+x1y+" mx="+mx+" my="+my);
            if(theta1<=10)
           {
               image2= image1.getSubimage(0,5*image1.getHeight()/13,image1.getWidth(),image1.getHeight()/13);
           
         }
           else if(theta1<=30)//
           {
            image2= image1.getSubimage(0,7*image1.getHeight()/13,image1.getWidth(),image1.getHeight()/13);//10
        }
        
        else if(theta1<=55)//
        {
            
           image2= image1.getSubimage(0,4*image1.getHeight()/13,image1.getWidth(),image1.getHeight()/13); //9
          
        }
        else if(theta1<=90)
           {image2= image1.getSubimage(0,3*image1.getHeight()/13,image1.getWidth(),image1.getHeight()/13);
          
        }
         showStatus(theta1+"ix+x1w="+ix+x1w+" iy+x1h="+ix+x1w+" mx="+mx+" my="+my);
        //showStatus(theta1+"x1x="+x1x+" x1y="+x1y+" mx="+mx+" my="+my);
         repaint();
           ////////////
           
        }
       
            
          else if(my<x1y&&mx<x1x)//2nd quad
          {
          //double d=Math.atan((x1y-my)/(x1x-mx));    
         double d=((x1y-my)/(x1x-mx));
         double d2=Math.atan(d);
            double theta1=Math.toDegrees(d2);
            showStatus(theta1+"x1x="+x1x+" x1y="+x1y+" mx="+mx+" my="+my);
         if(theta1<=20)
           {image2= image1.getSubimage(0,6*image1.getHeight()/13,image1.getWidth(),image1.getHeight()/13);
           
        }
           else if(theta1<=40)//
           {
            image2= image1.getSubimage(0,7*image1.getHeight()/13,image1.getWidth(),image1.getHeight()/13);//12
        }
        
        else if(theta1<=55)//
        {
            
           image2= image1.getSubimage(0,8*image1.getHeight()/13,image1.getWidth(),image1.getHeight()/13); //13
          
        }
        else if(theta1<=90)
           {image2= image1.getSubimage(0,9*image1.getHeight()/13,image1.getWidth(),image1.getHeight()/13);
           
        }
         showStatus(theta1+"ix+x1w="+ix+x1w+" iy+x1h="+ix+x1w+" mx="+mx+" my="+my);
        //showStatus(theta1+"x1x="+x1x+" x1y="+x1y+" mx="+mx+" my="+my);
        repaint();
}
}
}

    public void mouseClicked(MouseEvent me)
{

}
public void mouseReleased(MouseEvent me)
{

}
public void mouseEntered(MouseEvent me)
{

}
public void mouseExited(MouseEvent me)
{

}

public void mousePressed(MouseEvent me)
{

}
public void mouseDragged(MouseEvent me)
{

}

       
    public void paint(Graphics g)
    {
        // simple text displayed on applet
//         g.setColor(Color.white);
//         g.fillRect(0, 0, 200, 100);
//         g.setColor(Color.black);
//         g.drawString("DEB", 200, 110);
       
//         g.setColor(Color.blue);
//         g.drawString("Writtek", 400, 110);
//        g.drawImage(image2, 100,300, this); 
//         g.drawImage(image3, 900,300, this);
//          g.drawImage(image4, 500,10, this);
g.drawImage(image2, ix,iy, this);
// g.drawImage(img3, 500,500, this);
// g.drawImage(img4, 400,300, this);
    }

    
    
}
