
import java.util.ArrayList;


public class SpellChecker 
{
    static String inputfile;
    static String outputfile;
    public static void main(String[] args) 
    {
        //objects of classes
        TrieTree trie = new TrieTree();
        BinaryTree tree=new BinaryTree();
        ReadFles read=new ReadFles();
        //input out file names
        inputfile=args[0];
        outputfile=args[1];
        //input and dict file data
        ArrayList<String> input= read.readInputFile(inputfile);
        String dictStorage=read.readA1Properties();
        ArrayList<String> arr=read.readDict();
        //choose trie or tree
        if(dictStorage.equalsIgnoreCase("trie"))
        {
            //build Trie
            for(String word:arr)
            {
                trie.insert(word);
            }
            //compare input file data with trie
            for(String word: input)
            {
                //words that found
                boolean check=false;
                if(trie.search(word))
                {
                    read.writeOutput(outputfile, word);
                    check=true;
                }
                else
                {
                    //missing words
                    char [] wordArr=word.toCharArray();
                    int length=wordArr.length-1;
                    while(check==false)
                    {
                        char [] newArr=new char[length];
                        for(int i=0;i<length;i++)
                        {
                            newArr[i]=wordArr[i];
                        }
                        String newWord=String.valueOf(newArr);
                        if(trie.search(newWord))
                        {
                            String con= word+" "+newWord;
                            read.writeOutput(outputfile, con);
                            check=true;
                        }
                        length=length-1;
                    }
                }   
            }
        }
        else
        {
            //build tree
            for(String word:arr)
            {
                tree.insert(word);
            }
            //compare input values with tree
            for(String word: input)
            {
                tree.search(word);
            }
            //code for words that not match
            ArrayList<String> remain = new ArrayList<String>();
            ArrayList<String> written = read.readInputFile(outputfile);
            boolean check;
            for(String ch: input)
            {
                check=true;
                for(String obj:written)
                {
                    if(ch.equals(obj))
                    {
                        check=false;
                        break;
                    }
                }
                if(check)
                {
                    remain.add(ch);
                }
            }
            //call function misword to find pattern with functions
            for(String b:remain)
            {
                tree.misWord(b);
            }
        }
    }
}
