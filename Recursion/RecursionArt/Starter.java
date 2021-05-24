import gpdraw.*;
public class Starter {
    public static void main() {
        RecursionMountain mountain = new RecursionMountain(); //create the object
        mountain.draw(3,250); //draw the mountain in the background
        mountain.drawmoon(35.0); //draws the moon in the sky
        mountain.makeClouds(); //draws c-curve based clouds
        mountain.buildForest(); //draw fractal trees
        mountain.buildHouse(); //draws a serpinski triangle roof and box for the house
        mountain.snowFall();//draws the snowflaks falling from the clouds
    }
}
