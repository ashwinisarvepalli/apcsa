import gpdraw.*;
public class RecursionMountain
{
    SketchPad myCanvas;
    DrawingTool myPencil;
    DrawingTool moonPencil;
    DrawingTool treePencil;
    DrawingTool cloudPencil;
    DrawingTool snowPencil;
    DrawingTool housePencil;
    
    public RecursionMountain (){
        myCanvas = new SketchPad(400,400); //creates the sketchpad 
        myPencil = new DrawingTool(myCanvas); //creates the pencil to draw the background mountain
        cloudPencil = new DrawingTool(myCanvas); //creates the pencil to draw the clouds
        snowPencil = new DrawingTool(myCanvas); //creates the pencil to draw the snowflakes
        treePencil = new DrawingTool(myCanvas);//creates the pencil to draw the trees
        moonPencil = new DrawingTool(myCanvas);//creates the pencil to draw the moon
        housePencil = new DrawingTool(myCanvas);//creates the pencil to draw house
        myPencil.up();
        myPencil.move(300,0);
        myPencil.turnLeft(180);
        myPencil.down();
        myPencil.forward(560);
        myPencil.turnRight(180);
        myPencil.forward(560);
        myPencil.turnLeft(90);
        myPencil.up(); 
        myPencil.turn(30); //all this sets the base for the mountain, the horizon line
        
    }

    public void drawsierp(int j, int k){ //sierpinski triangle for the roof of the house
        myPencil.down();
        if (j==1){
            housePencil.forward(k);
            housePencil.turn(120);
            housePencil.forward(k);
            housePencil.turn(120);
            housePencil.forward(k);
            housePencil.turn(120);
        } else {
            drawsierp(j-1,k/2);
            housePencil.forward(k);
            housePencil.turnLeft(120);
            drawsierp(j-1,k/2);
            housePencil.forward(k);
            housePencil.turnLeft(120);
            drawsierp(j-1,k/2);
            housePencil.forward(k);
            housePencil.turnLeft(120);
        }
    }
    
    public void draw(int n, int size) { //recursive method for drawing mountain background
        myPencil.setWidth(2);
        myPencil.down(); //base case to create a triangle:
        if (n==0)
        {
            myPencil.forward(size);
            myPencil.turn(120);
            myPencil.forward(size);
            myPencil.turn(120);
            myPencil.forward(size);
            myPencil.turn(120); //turn pencil to the right orientation
        } //recursive case
        else {
            draw(n-1, size/2); //recursive call to draw the below case
            myPencil.forward(size/2); //move forward to draw the next triangle
            draw(n-1, size/2); //recursive call to draw the below case
            myPencil.turn(120); //makes sure to orient the pencil to face the correct way
            myPencil.forward(size/2); //move forward to draw the next triangle
            myPencil.turn(-120); //orient pencil correctly
            draw(n-1, size/2); //recursive call to draw the below case
            myPencil.turn(-120); //orient pencil correctly
            myPencil.forward(size/120); //move forward to draw the next triangle
            myPencil.turn(120); //orient pencil correctly
        }
    }
    
    public void drawmoon(double x){//draws the moon
        moonPencil.up();
        moonPencil.move(-200,280);
        moonPencil.down();
        moonPencil.fillCircle(x); //fills and creates the circle easily
    }
    
    public void drawCloud(double le, double si) { //recursive method for c-curve clouds
        cloudPencil.down();
        if (le == 1){
            cloudPencil.down();
            cloudPencil.forward(si);
        } else {
            cloudPencil.down();
            cloudPencil.turn(45);
            drawCloud(le-1, si/2);
            cloudPencil.turn(-90);
            drawCloud(le-1, si/2);
            cloudPencil.turn(45);
        }
    }
    
    public void drawTree(double l, double s) { //recursive method for the fractal trees
        treePencil.down();
        if (l == 1){
            treePencil.down();
            treePencil.forward(s);
            treePencil.forward(-s);
        } else {
            treePencil.down();
            treePencil.forward(s);
            treePencil.turnLeft(15);
            drawTree(l-1, s*0.75);
            treePencil.turnRight(30);
            drawTree(l-1, s*0.75);
            treePencil.turnLeft(15);
            treePencil.forward(-s);
        }
    }
    
    public void partSnow(double levels, double size){ //recursive helper method to create part of snowflake
        snowPencil.down();
        if (levels == 1){
            snowPencil.forward(size);
        }else{
            partSnow(levels - 1, size/3);
            snowPencil.turnLeft(60);
            partSnow(levels - 1, size/3);
            snowPencil.turnRight(120);
            partSnow(levels - 1, size/3);
            snowPencil.turnLeft(60);
            partSnow(levels-1,size/3);
            
        }
    }
    
    public void drawSnow(double x, double y){ //creates the full snowflakes using the helper method
        snowPencil.down();
        partSnow(x,y);
        snowPencil.turnRight(120);
        partSnow(x,y);
        snowPencil.turnRight(120);
        partSnow(x,y);
    }
    
    public void makeClouds(){ //creates the clouds in the sky
        cloudPencil.up();
        cloudPencil.move(200,200);
        cloudPencil.turnRight(45);
        drawCloud(9.0,1000.0);
        cloudPencil.up();
        cloudPencil.move(-195,160);
        cloudPencil.turnRight(185);
        drawCloud(9.0,900.0);
        cloudPencil.up();
        cloudPencil.move(-20,250);
        cloudPencil.turnRight(36);
        drawCloud(9.0,1000.0);
        cloudPencil.up();
        cloudPencil.move(-130,230);
        cloudPencil.down();
        cloudPencil.turnRight(185);
        drawCloud(9.0,800.0);
        cloudPencil.up();
        cloudPencil.move(90,220);
        drawCloud(9.0,800.0);
        cloudPencil.up();
        cloudPencil.move(-296,200);
        cloudPencil.down();
        cloudPencil.turnRight(185);
        drawCloud(9.0,850.0);
    }
    
    public void buildForest(){ //creats the forest on the ground
        treePencil.setWidth(1);  
        treePencil.up();
        treePencil.move(-250,-150);
        treePencil.turnRight(130);
        drawTree(10.0,50.0);
        treePencil.up();
        treePencil.move(-150,-100);
        treePencil.turnLeft(50);
        drawTree(10.0,50.0);
        treePencil.up();
        treePencil.move(-350,-100);
        treePencil.turnRight(100);
        drawTree(10.0,50.0);
        treePencil.up();
        treePencil.move(150,-100);
        treePencil.turnLeft(105);
        drawTree(10.0,50.0);
        treePencil.up();
        treePencil.move(250,-150);
        treePencil.turnLeft(125);
        drawTree(10.0,50.0);
        treePencil.up();
        treePencil.move(350,-100);
        treePencil.turnLeft(75);
        drawTree(10.0,50.0);
        treePencil.up();
    }
    
    public void buildHouse(){ //creates the house
        housePencil.setWidth(3);
        housePencil.up();
        housePencil.move(-50,50);
        housePencil.turnRight(135);
        housePencil.down();
        drawsierp(4,100); //create the roof of the house
        housePencil.move(0,50);
        housePencil.turnRight(90);
        housePencil.forward(35);
        housePencil.turnLeft(180);
        housePencil.fillRect(90,70); //easily create the base of the house
    }
    
    public void snowFall(){ //creates the many snowflakes in the sky
        snowPencil.up();
        snowPencil.move(180,150);
        drawSnow(3.0,40.0);
        snowPencil.up();
        snowPencil.move(260,140);
        drawSnow(3.0,25.0);
        snowPencil.up();
        snowPencil.move(250,160);
        drawSnow(3.0,20.0);
        snowPencil.up();
        snowPencil.move(240,110);
        drawSnow(3.0,20.0);
        snowPencil.up();
        snowPencil.move(-150,100);
        drawSnow(3.0,40.0);
        snowPencil.up();
        snowPencil.move(100,180);
        drawSnow(3.0,30.0);
        snowPencil.up();
        snowPencil.move(40,205);
        drawSnow(3.0,25.0);
        snowPencil.up();
        snowPencil.move(-50,180);
        drawSnow(3.0,25.0);
        snowPencil.up();
        snowPencil.move(130,110);
        drawSnow(3.0,35.0);
        snowPencil.up();
        snowPencil.move(-120,90);
        drawSnow(3.0,15.0);
        snowPencil.up();
        snowPencil.move(-280,100);
        drawSnow(3.0,30.0);
        snowPencil.up();
        snowPencil.move(-260,130);
        drawSnow(3.0,25.0);
        snowPencil.up();
        snowPencil.move(-280,160);
        drawSnow(3.0,20.0);
        snowPencil.up();
        snowPencil.move(100,140);
        drawSnow(3.0,15.0);
        snowPencil.up();
    }
}
