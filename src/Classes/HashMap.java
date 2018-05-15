package Classes;

public class HashMap<T>
{
    private final static int TABLE_SIZE = 13;

    HashEntry<T>[] table;

    HashMap()
    {
        table = new HashEntry[TABLE_SIZE];
        for (int i = 0; i < TABLE_SIZE; i++)
        {
            table[i] = null;
        }
    }

    public Object getValue(Integer key)
    {
        int hash = (key % TABLE_SIZE);
        while (table[hash] != null && table[hash].getKey() != key)
        {
            hash = (hash + 1) % TABLE_SIZE;
        }
        if (table[hash] == null)
        {
            return null;
        }
        else
        {
            return table[hash].getValue();
        }
    }

    public void setValue(int key, T value)
    {
        int hash = getHashIndex(key);
        table[hash] = new HashEntry(key,value);
    }

    public void deleteEntry(int key)
    {
        int hash = getHashIndex(key);
        table[hash] = null;
        //Output if error
    }

    private int getHashIndex(int key)
    {
        int hash = (key % TABLE_SIZE);
        while (table[hash] != null && table[hash].getKey() != key)
        {
            hash = (hash + 1) % TABLE_SIZE;
        }
        return hash;
    }
}

