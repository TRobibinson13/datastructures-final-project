package Classes;

import sun.tools.jconsole.*;

public class HashMap<T>
{
    HashEntry<T>[] table;
    private static int TABLE_SIZE = 13;

    /**
     * Constructor for HashMap of HashEntry's
     */
    public HashMap()
    {
        table = new HashEntry[TABLE_SIZE];
        fillTableWithNull(table);
    }

    /**
     * Method to fill a targeted table with null value's
      * @param targetTable The Table that is to be targeted
     */
    public void fillTableWithNull(HashEntry<T>[] targetTable)
    {
        for(int i =0; i < TABLE_SIZE; i++)
        {
            targetTable[i] = null;
        }
    }

    public void fillNewTableWithExistingTable(HashEntry<T>[] importedTable, HashEntry<T>[] targetTable)
    {
        if(targetTable.length < importedTable.length)
        {
            System.out.println("Targeted table size is too small in size to import all of the parsed values");
        }
        else
        {
            for(int i =0; i < targetTable.length; i++)
            {
                targetTable[i] = importedTable[i];
            }
        }
    }

    public void modifyExistingTable(int newTableSize)
    {
        HashEntry<T>[] modifiedTable = new HashEntry[getNextPrime(newTableSize)];
        fillTableWithNull(modifiedTable);
        fillNewTableWithExistingTable(table, modifiedTable);

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
        int hash = Math.abs(key % TABLE_SIZE);
        while (table[hash] != null && table[hash].getKey() != key)
        {
            hash = (hash + 1) % TABLE_SIZE;
        }
        return hash;
    }

    public boolean tableSizeIsPrime(int numberToCheck)
    {

        if(numberToCheck % 2 ==0)
        {
            return false;
        }

        for(int i =3; i * i <= numberToCheck; i =+ 2)
        {
            if(numberToCheck % i == 0)
            {
                return false;
            }
        }
        return true;
    }

    public int getNextPrime(int minNumberToCheck)
    {
        for(int i = minNumberToCheck; true; i++)
        {
            if (tableSizeIsPrime(i))
            {
                return i;
            }
        }
    }

    public void increaseArraySize(int minTableSize)
    {
        int newTableSize = getNextPrime(minTableSize);
        modifyExistingTable(newTableSize);
    }


    public int getTableSize()
    {
        return TABLE_SIZE;
    }

    private void setTableSize(int tableSize)
    {
        TABLE_SIZE = tableSize;
    }
}

