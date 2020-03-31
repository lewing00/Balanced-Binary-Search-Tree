
/**
 *
 * @author LeeAnna Ewing
 */
public class BSTNode {
    
    //fields
    int number;
    BSTNode left, right;
    
    //Constructor
    public BSTNode(int num){
        number = num;
        left = right = null;
    }
    // no arg
    public BSTNode(){
        number = 0;
        left = right = null;
    }
    //setters
    public void setNumber(int num){
        number = num;
    }
    
    public void setLeft(BSTNode node){
        left = node;
    }
    
    public void setRight(BSTNode node){
        right = node;
    }
    //getters
    public int getNumber(){
        return number;
    }
    
    public BSTNode getLeft(){
        return left;
    }
    
    public BSTNode getRight(){
        return right;
    }
}//fine
