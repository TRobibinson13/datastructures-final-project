package Classes;

public class HashEntry <T>
{

    private int key;
    private T value;

    /**
     * Constructor for HashEntry
     * @param key The Key to the HashEntry KVP as an int.
     * @param value The Value to the HashEntry KVP as an undefined Object.
     */
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