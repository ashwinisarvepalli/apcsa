
class RegularPolygon{
  private int myNumSides;   // # of sides
  private double mySideLength;  // length of side
  private double myR; // radius of circumscribed circle
  private double myr; //radius of inscribed circle

  // constructor to create a triangle, the most basic polygon
  public RegularPolygon(){
    myNumSides = 3; // automatically set to a triangle polygon
    mySideLength = 5; //length can be any length
  }
  // constructor to draw a polygon of any number of sides of any length
  public RegularPolygon (int numSides, double sideLength){
    myNumSides = numSides; //set to the input
    mySideLength = sideLength; //set to the input
    calcr(); // to calculate the radius of the inscribed circle
    calcR(); // to cacluate the radius of the outer circle
    System.out.print("n = " + getNumside() + "  s = " + getSideLength() + "  degrees = " + vertexAngle() + "  r = " + getr() + 
        "  R = " + getR() + "  perimeter = " + Perimeter() + "  area = " + Area());
  }
  
  // private methods  to calulate the radius of the inscribed circle
  private void calcr(){
    myr = ((0.5)*(mySideLength)*(1d/Math.tan(Math.PI / myNumSides)));
  }
  // private method to calculate the radius of the outside/circumscribed circle
  private void calcR(){
    myR = (0.5) * (mySideLength) * (1/Math.sin(Math.PI / myNumSides));
  }
  
  //public method that calculate and returns the angle of the vertex
  public double vertexAngle(){
    double va1 = (Math.round((((double)(myNumSides - 2) / myNumSides) * 180) * 100));
    return va1/100;
  }
  // public method that calculates and returns the perimeter of the polygon
  public double Perimeter(){
    return (myNumSides * mySideLength);
  }
  // a public method that calculates and return the area with two decimal places 
  public double Area(){
    double a1 = Math.round ((0.5d * myNumSides * Math.pow(myR, 2) * Math.sin(2d * Math.PI / myNumSides)) * 100);
    return a1/ 100;
  }
  // a public method that returns the number of sides for a polygon
  public double getNumside(){
    return myNumSides;
  }
  // public method that returns the length of a size of a polygon
  public double getSideLength(){
    return mySideLength;
  }
  // a public method that returns the radius of the outside circle
  public double getR(){
    double R1 = Math.round (myR * 100); 
    return R1 / 100;
  }
  //public method that returns the radius of the inscribed circle
  public double getr(){
    double r1 = Math.round (myr * 100);
    return r1/ 100;
  }
}
