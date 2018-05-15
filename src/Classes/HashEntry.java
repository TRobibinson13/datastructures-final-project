package Classes;

public class HashEntry <T>
{

    private int key;
    private T value;

    HashEntry(int key,T value)
    {
        this.key = key;
        this.value = value;
    }

    public int getKey()
    {
        return key;
    }

    public T getValue()
    {
        return value;
    }
}