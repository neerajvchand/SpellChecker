
import java.util.ArrayList;

public class BinaryTree 
{
    public TreeNode root;
    ReadFles obj;
    static int count=0;
    public BinaryTree()
    {
        root = null;
        obj=new ReadFles();
    }
    
    public TreeNode returnRoot()
    {
        return root;
    }
    
    public boolean isEmpty()
    {
        return root == null;
    }
    
    public void insert(String value)
    {
        if(isEmpty())
        {
            root = new TreeNode(value);
        }
        else
        {
            root.add(value);
        }
    }
    public void search(String word)
    {
        searchWord(root,word);
    }
    public void searchWord(TreeNode root,String word)
    {
        if(root!=null)
        {
            searchWord(root.getLeft(),word);
            if(word.equals(root.getWord()))
            {
                obj.writeOutput(SpellChecker.outputfile, word);
            }
            searchWord(root.getRight(),word);
        }
    }
    public void misWord(String obj)
    {
        misSpelledWords(root,obj);
        count=0;
    }
    public void misSpelledWords(TreeNode root,String word)
    {
        if(root!=null)
        {
            misSpelledWords(root.getLeft(),word);
            String war=root.getWord();
            //if(word.startsWith(root.getWord()) || word.endsWith(root.getWord()))
            if(word.contains(war) || war.contains(word))
            {
                if(count<3)
                { 
                    String w= word.concat(" "+war);
                    obj.writeOutput(SpellChecker.outputfile, w);
                    count++;
                    return;
                }
            }
            misSpelledWords(root.getRight(),word);
        }
    }
    public TreeNode getRoot()
    {
        return root;
    }
    public void preOrder() 
    {
        preOrder(root);
    }
          // using the function ...
    public void preOrder(TreeNode root) 
    {
        if (root != null) 
        {            
            System.out.println(root.getWord());   // root
            preOrder(root.getLeft());        // left
            preOrder(root.getRight());       // right
        }
    }
}
