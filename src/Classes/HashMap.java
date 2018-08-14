package Classes;

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

    /**
     * Method to fill a targeted table with another tables values.
     * @param importedTable The source table that's values are going be imported.
     * @param targetTable The destination table that is to import the importedTable's values.
     */
    public void fillNewTableWithExistingTable(HashEntry<T>[] importedTable, HashEntry<T>[] targetTable)
    {
        if(targetTable.length < importedTable.length)
        {
            System.out.println("Targeted table size is too small in size to import all of the parsed values");
        }
        else
        {
            for(int i =0; i < importedTable.length; i++)
            {
                if(importedTable[i] == null)
                {
                    continue;
                }
                int hash = getHashIndex(importedTable[i].getKey());
                targetTable[hash] = new HashEntry(importedTable[i].getKey(),importedTable[i].getValue());
            }
            table = targetTable;
        }
    }

    /**
     * Method to modify an existing table's size by means of creating a new table with the desired values.
     * @param newTableSize the desired size of the new/modified table as an int.
     */
    public void modifyExistingTable(int newTableSize)
    {
        HashEntry<T>[] modifiedTable = new HashEntry[getNextPrime(newTableSize)];
        fillTableWithNull(modifiedTable);
        TABLE_SIZE = newTableSize;
        fillNewTableWithExistingTable(table, modifiedTable);

    }

    /**
     * Method to retrieve the value of a HashEntry which uses its key to find the relative index of the entry.
     * @param key The key that is to be passed into the method
     * @return the value of the KVP.
     */
    public Object getValue(Integer key)
    {
        int hash = getHashIndex(key);
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

    /**
     * Method to delete a HashEntry from the HashMap by setting its key to null.
     * @param key
     */
    public void deleteEntry(int key)
    {
        int hash = getHashIndex(key);
        table[hash] = null;
        //Output if error
    }

    /**
     * Creates a hash value for the index  for  of desired KVP's key
     * @param key
     * @return
     */
    private int getHashIndex(int key)
    {
        int hash = Math.abs(key % TABLE_SIZE);
        while (table[hash] != null && table[hash].getKey() != key)
        {
            hash = (hash + 1) % TABLE_SIZE;
        }
        return hash;
    }


    /**
     * Boolean method check to confirm the current table size is Prime in efforts to eliminate possible collisions.
     * @param numberToCheck
     * @return the boolen status of the method
     */
    public boolean tableSizeIsPrime(int numberToCheck)
    {

        if(numberToCheck % 2 ==0)
        {
            return false;
        }

        for(int i =3; i * i <= numberToCheck; i += 2)
        {
            if(numberToCheck % i == 0)
            {
                return false;
            }
        }
        return true;
    }

    /**
     * Method to find the next prime value for a table's table size relative to the parsed int.
     * @param minNumberToCheck
     * @return
     */
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

    /**
     * Method to increase the current table size, and set that as the new constant.
     * @param minTableSize the minimum acceptable table size for determining the new table size.
     */
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

