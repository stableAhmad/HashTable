import java.util.Objects;

class Main
{
public static void main(String [] args)
    {
        HashTable<Integer,Integer> test = new HashTable<>(10); 
        test.add(1 , 1);
        test.add(2 , 2 );
        test.add(3 , 88);
        test.add(3 , 88);
        test.add(3 , 88);
        test.add(3 , 88);
        test.add(3 , 88);
        
        test.add(3 , 88);
    }
}
