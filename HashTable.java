import java.util.Objects;
import java.util.*;

//to do
//add (key ,value) : void
//get (key) : returns value
//load factor 
//test with a problem

class HashNode<keyType,valueType>
{
   keyType key;
   valueType value;
   HashNode next;
   public HashNode(keyType x , valueType y)
    {
        this.key = x;
        this.value = y;
        this.next = null;
    }
    public void print_self()
        {
            System.out.println("key is "+this.key +" the value is "+this.value);

        }
}

class HashTable<keyType ,valueType>
{
    int initSize ;
    ArrayList<HashNode<keyType,valueType>> table;
    int added = 0;
    double loadFactor  = 0 ;
    double LIMIT = 0.7 ; 

    HashTable(int x )
        {
            this.initSize = x;
            table = new ArrayList<>(this.initSize);
            this.init_table();
        }

    private void init_table()
        {
            for(int i = 0 ; i< this.initSize ; i++)
                {
                    this.table.add(null);
                }
        }

    private int hash(keyType key)
        {
            return Objects.hashCode(key);
        }

    public void add(keyType key , valueType value)
        {
            int code = this.hash(key)%this.initSize;
            HashNode<keyType , valueType> new_node = new HashNode<>(key , value);
            HashNode<keyType , valueType> current = this.table.get(code);
            if(current == null)
                {
                    this.table.set(code , new_node);

                }else
                {
                    while(current.next != null)
                        {
                            current =current.next;
                        }
                        current.next = new_node;
                }
                this.added++;
                this.loadFactor = (double)this.added / this.initSize;
                if(this.loadFactor > this.LIMIT)
                    {
                        this.initSize *=2;
                        ArrayList<HashNode<keyType , valueType>> temp = this.table;
                        this.table = new ArrayList<>(this.initSize);
                        this.init_table();
                        this.added = 0;
                        for(HashNode node : temp)
                            {
                                
                                HashNode current2= node;
                                while(current2 != null)
                                    {
                                        this.add(  (keyType)current2.key , (valueType)current2.value);
                                        current2 = current2.next;
                                    }
                            }
                            this.LIMIT*=2;
                            this.loadFactor = (double)this.added  / this.initSize;

                    }
        }
    public void print()
        {
            for(HashNode node : this.table)
                {
                    while(node != null)
                        {

                            node.print_self();
                            node = node.next;
                        }
                }
        }
    public valueType get(keyType key)
        {
            int code = this.hash(key);
            return this.table.get(code).value;
        }

}
