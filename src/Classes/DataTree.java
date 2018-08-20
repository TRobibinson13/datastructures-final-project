package Classes;

public class DataTree<T>
{
    DataTreeNode root;

    /**
     * T.R.
     * Adds a new DataTreeNode to the DataTree.
     * @param key The Key to the KVP as an int.
     * @param value The Value to the KVP as an undefined Object
     */
    public void addDataTreeNode(int key, T value)
    {
        DataTreeNode newDataTreeNode = new DataTreeNode(key, value);

        if(root == null)
        {
            root = newDataTreeNode;
        }
        else
        {
            DataTreeNode parent;
            DataTreeNode targetNode = root;

            while(true)
            {
                parent = targetNode;

                if(key < targetNode.getKey())
                {
                    targetNode = targetNode.leftChild;

                    if(targetNode == null)
                    {
                        parent.leftChild = newDataTreeNode;
                        return;
                    }
                }

                else if(key > targetNode.getKey())
                {
                    targetNode = targetNode.rightChild;

                    if(targetNode == null)
                    {
                        parent.rightChild = newDataTreeNode;
                        return;
                    }
                }
            }
        }
    }

    public void inOrderTraverseTree(DataTreeNode targetNode)
    {
        if(targetNode != null)
        {
            inOrderTraverseTree(targetNode.leftChild);
            System.out.println(targetNode);
            inOrderTraverseTree(targetNode.rightChild);
        }
    }

    public void preOrderTraverseTree(DataTreeNode targetNode)
    {
        if(targetNode != null)
        {
            System.out.println(targetNode);
            preOrderTraverseTree(targetNode.leftChild);
            preOrderTraverseTree(targetNode.rightChild);
        }
    }

    public void postOrderTraverseTree(DataTreeNode targetNode)
    {
        if(targetNode != null)
        {
            postOrderTraverseTree(targetNode.leftChild);
            postOrderTraverseTree(targetNode.rightChild);
            System.out.println(targetNode);
        }
    }

    /**
     * T.R.
     * Finds and returns the value of the targeted Object
     * @param key the Key target value that stnads place as the locator for obtaining the value to the KVP.
     * @return the value of the targeted Key as undefined Object.
     */
    public Object findNode(Integer key)
    {
        DataTreeNode targetNode = root;

        while(targetNode.getKey() != key)
        {
            if(key < targetNode.getKey())
            {
                targetNode = targetNode.leftChild;
            }
            else
            {
                targetNode = targetNode.rightChild;
            }

            if(targetNode == null){return null;}
        }
        return targetNode.getValue();
    }

    /**
     * T.R.
     * Removes a Node from the DataTree
     * @param key Locator for targeted Key in a KVP to be removed.
     * @return boolean value of if the target was successfully removed
     */
    public boolean removeNode(int key)
    {
        DataTreeNode targetNode = root;
        DataTreeNode parent = root;

        boolean isALeftChild = true;

        while(targetNode.getKey() != key)
        {
            parent = targetNode;

            if(key < targetNode.getKey())
            {
                isALeftChild = true;
                targetNode = targetNode.leftChild;
            }
            else
            {
                isALeftChild = false;
                targetNode = targetNode.rightChild;
            }

            if(targetNode == null){return false;}
        }

        if(targetNode.leftChild == null && targetNode.rightChild == null)
        {
            if(targetNode == root)
            {
                root = null;
            }
            else if(isALeftChild)
            {
                parent.leftChild = null;
            }
            else
            {
                parent.rightChild = null;
            }
        }

        else if(targetNode.rightChild == null)
        {
            if(targetNode == root)
            {
                root = targetNode.leftChild;
            }
            else if(isALeftChild)
            {
                parent.leftChild = targetNode.leftChild;
            }
            else
            {
                parent.rightChild = targetNode.leftChild;
            }
        }

        else if(targetNode.leftChild == null)
        {
            if(targetNode == root)
            {
                root = targetNode.rightChild;
            }
            else if(isALeftChild)
            {
                parent.leftChild = targetNode.leftChild;
            }
            else
            {
                parent.rightChild = targetNode.leftChild;
                //Just set this to null?
            }
        }

        else
        {
            DataTreeNode replacement = getReplacementNode(targetNode);

            if(targetNode == root)
            {
                root = replacement;
            }
            else if(isALeftChild)
            {
                parent.leftChild = replacement;
            }
            else
            {
                parent.rightChild = replacement;
            }

            replacement.leftChild = targetNode.rightChild;
        }

        return true;
    }

    /**
     * T.R.
     * Replaces DataTreeNode in the DataTree and reconstructs as/if needed.
     * @param replacedNode The DataTreeNode that is to be replaced
     * @return the DataTreeNode that will be taking the @replacedNode 's position
     */
    public DataTreeNode getReplacementNode(DataTreeNode replacedNode)
    {
        DataTreeNode replacementParent = replacedNode;
        DataTreeNode replacement = replacedNode;

        DataTreeNode targetNode = replacedNode.rightChild;

        while (targetNode != null)
        {
            replacementParent = replacement;
            replacement = targetNode;
            targetNode = targetNode.leftChild;
        }
        if(replacement != replacedNode.rightChild)
        {
            replacementParent.leftChild = replacement.rightChild;
            replacement.rightChild = replacedNode.rightChild;
        }

        return replacement;
    }
}
