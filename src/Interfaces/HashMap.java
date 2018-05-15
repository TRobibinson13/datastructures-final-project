package Interfaces;

public interface HashMap<T>
{
    public Object getValue(Integer key);

    public void setValue(int key, T value);

    public void deleteEntry(int key);
}
