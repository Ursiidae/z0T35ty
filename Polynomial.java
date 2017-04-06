/**
*
*Cassidy Gibson
*Febuary 8th, 2017
* * * * * * * * * * * * * * * * * *  *
*
* Create a Polynomial class so that one
* can input co-efficients and degrees so that
* the problem can be evaluated, or put to a string.
*/

public class Polynomial {

  protected double[] coefArray; //Array for coefficients stored
  protected int[] degreeArray; //Array where degrees are stored
  private int counter = 0; //Counts for spot in array

  /**
  *@param size is expected as an integer to dictate size of arrays
  *@precondition int is larger than 0
  *@postcondition creates two arrays of set size, one double array other int array for degree and coefficients which can be input and viewed.
  */
  public Polynomial(int size){
    coefArray = new double[size]; //sets size given
    degreeArray = new int[size];  //sets size given
  }
  
  /**
  *@param int degree, double coef
  *@precondition expects user to input greater to least degree, index given through counter. given int and double by user.
  *@postcondition Fills in created array
  */
  public void setCoefficient(int degree, double coef){
    coefArray[counter] = coef;
    degreeArray[counter] = degree;
    counter++;
  }

  /**
  *@param index >= 0
  *@precondition user inputs an index which they want to see the value of
  *@postcondition recieves value in index of int array holding degree of Poly
  */
  public int returnDegree(int index){
    return degreeArray[index];
  }

  /**
  *@param index >=0
  *@precondition user inputs an index which they want to see the value of
  *@postcondition recieves value in index of double array holding coefficient of poly
  */
  public double returnCoefficient(int index){
    return coefArray[index];
  }

  /**
  *@param
  *@precondition looking for size of arrays
  *@postcondition recieves size of arrays
  */
  public int returnSize(){
    return coefArray.length; 
  }

  /**
  *@param X can be equal to anything. 
  *@precondition User gives x so that the polynomial can be evaluated by it
  *@postcondition Returns value of post-evaluated polynomial
  */
  public double evaluate(double x){
    double willReturn = 0;

    for(int i = 0; i<coefArray.length; i++){
      willReturn+=((Math.pow(x, degreeArray[i]))*coefArray[i]);
    }

    return willReturn;
  }

  /**
  *@postcondition returns string value
  */
  @Override
  public String toString(){
    String willReturn=("");

    for(int i = 0; i < coefArray.length; i++){

      if(i>0){
        willReturn = (willReturn + " + ");
      }

      willReturn = (willReturn + coefArray[i] + "x^" + degreeArray[i] + " ");
    }
    
    return willReturn;
  }

  /**
  *@param user gives another polynomial
  *@precondition filled out polynomial arrays
  *@postcondition returns boolean
  */
  @Override
  public boolean equals(Object other){
    Polynomial thing = (Polynomial)other; 
    if(this.returnSize() == thing.returnSize()){
      for(int i = 0; i < this.returnSize(); i++){
        if(this.returnCoefficient(i) == thing.returnCoefficient(i) && this.returnDegree(i) == thing.returnDegree(i)){
          if(i == this.returnSize()-1){
            return true;
          }
        }
      }
    }

    return false;
  }

}
