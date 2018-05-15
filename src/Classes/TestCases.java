package Classes;

public class TestCases<Node>
{
    public Node firstNode;
    private int numberOfEntries;

    public TestCases()
    {
        firstNode = null;
        this.numberOfEntries = 0;
    }

    public void add(Node newNode)
    {
        if (firstNode == null)
        {
            firstNode = newNode;
        }

        else
        {
            Node currentNode = firstNode;
            while(currentNode.getNodeAfter() !== null)
            {
                currentNode = currentNode.getNodeAfter();
            }
            currentNode.setNodeAfter(newNode);
        }
        numberOfEntries++;
        createdNode.setListPosition;
    }

    public boolean add(int index, Node newNode);
    {
        if (index > (numberOfEntries +1) || < 0)
        {
            return false
        }

        else if(index == 0)
    {
        newNode.setNodeAfter(firstNode);
        firstNode.setNodeBefore(newNode);
        firstNode = newNode;
    }

    else if(index == numberOfEntries)
    {
        add(newNode);
        return true
    }

    else
    {
        int count = 0;
        Node currentNode = firstNode;
        while(count !== index)
        {
            currentNode = currentNode.getNodeAfter();
            count++;
        }
        newNode.setNodeBefore(currentNode.getNodeBefore());
        newNode.setNodeAfter(currentNode);
        currentNode.getNodeBefore().setNodeAfter(newNode);
        currentNode.setNodeBefore(newNode);
    }
        numberOfEntries++;
        return true;
    }

    public boolean remove(int index)
    {
        if (index > (numberOfEntries - 1) || < 0)
        {
            return false
        }

        Node currentNode = firstNode;
        while(count !== index)
        {
            currentNode = currentNode.getNodeAfter();
        }

        currentNode.getNodeBefore().setNextNode(currentNode.getNextNode());
        currentNode.getNextNode().setNodeBefore(currentNode.getNodeBefore());
        currentNode = null;
        numberOfEntries--;
        return true;
    }

    public void clear()
    {
        int count = 0;
        Node currentNode = firstNode;

        while(currentNode.getNextNode() !== null)
        {
            Node nodeToMeetDaleks = currentNode;
            currentNode = currentNode.getNodeAfter();
            nodeToMeetDaleks = null;
            numberOfEntries--;
        }
        if(currentNode.getNodeBeofore() == null)
        {
            currentNode = null;
            numberOfEntries--;
        }
    }

    public void replace(int index, Node newNode)
    {
        int count = 0;
        Node currentNode = firstNode;

        if(index < 0 || >= numberOfEntries)
        {
            while (count !== index)
            {
                currentNode = currentNode.getNodeAfter();
            }
            currentNode.getNodeBefore().setNodeAfter(newNode);
            currentNode.getNodeAfter().setNodeBefore(newNode);
            currentNode = newNode;
        }
    }

    public Node getNode(int index);
    {
        int count = 0;
        Node currentNode = firstNode;

        if(index < 0 || >= numberOfEntries)
        {
            while (count !== index)
            {
                currentNode = currentNode.getNodeAfter();
            }
            return currentNode;
        }
    }

    public boolean contains(Node anEntry);

    public int getLength()
    {
        return numberOfEntries;
    }

    public boolean isEmpty()
    {
        if(this.firstNode == 0)
        {
            return true
        }
        return false
    }

    public Node[] toArray()
    {
        Node testCasesArray[] = new Node[numberOfEntries];
        Node currentNode = firstNode;
        int count = 0;

        while(count <= numberOfEntries)
        {
            testCasesArray[count] = currentNode;
            currentNode = currentNode.getNodeAfter();
        }
        return testCasesArray;
    }
}
