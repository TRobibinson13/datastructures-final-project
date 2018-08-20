package Classes;

public class DataTreeNode<T>
{
    private int key;
    private T value;

    DataTreeNode leftChild;
    DataTreeNode rightChild;

    /**
     * T.R.
     * Constructor for DataTreeNode
     * @param key the Key to the DataTreeNode KVP as an int.
     * @param value the Value to the DataTreeNode KVP as an undefined Object.
     */
    DataTreeNode(int key, T value)
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
