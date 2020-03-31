
/**
 *
 * @author LeeAnna Ewing
 */
public class BSTFunctions {
   
    //fields
    static BSTNode root;
    
    //no-arg constructor
    public BSTFunctions(){
        root = null;
    }
    
    //Send sorted array to be converted to a balanced bst
    public BSTNode sortedArrayToBST(int arr[], int start, int end){
        
        //base case
        if (start > end){
            return null;
        }
        
        // Get the middle element and make it the root
        int mid = (start + end)/2;
        BSTNode node = new BSTNode(arr[mid]);
        
        // Recusively contrust the left subtree and make it the left
        // child of the rook
        node.left = sortedArrayToBST(arr, start, mid -1);
        
        // Recursively construct the right subtree an make it the right
        // child of the root
        node.right = sortedArrayToBST(arr, mid + 1, end);
        
        return node;
    }
    
    public void inOrder(BSTNode node){
        if (node == null){
        return;
        }
            inOrder(node.left);
            System.out.print(node.number + " ");
            inOrder(node.right);
    }
    
    //recursively searches tree for a given node
    public boolean BSTSearch(BSTNode root, int key){
     
        if(root == null)
            return false;
        
        else if(root.number == key)
            return true;
        
        if(root.number > key)
           return BSTSearch(root.left, key);
        else 
          return BSTSearch(root.right, key);  
       
    }
    
    //recursively descends the left children from the root to find min value
    public int minValue(BSTNode root){
        BSTNode current = root;
        
        while(current.left != null){
            current = current.left;
        }   
        return (current.number);
    }
    
    //recursively descends the right children from the root to find max value
    public int maxValue(BSTNode root){
        BSTNode current = root;
        
        while(current.right != null){
            current = current.right;   
        }
        
        return (current.number);
    }
    
    public BSTNode deleteNode(BSTNode root, int key){
      // Base Case: If the tree is empty (should not be but just in case the use keeps deleting all the things)
      if (root == null )
      {
          return root;
      }
      
      
      //recur down the tree right or left depending on if min or max value is being deleted
      if (key < root.number)
          root.left = deleteNode(root.left, key);
      else if (key > root.number)
          root.right = deleteNode(root.right, key);
      
      
      //when the root number is the same as the key ... delete
      else if (key == root.number)
      { 
           if (root.left == null)
              root = root.right;
          else if (root.right == null)
              root = root.left;
      }
  
      return root;
    }
    
}//fine
