package Classes;

public class Tasks
{
    public void insert(String userName, User user)
    {
        testCaseUsers.setValue(userName.hashCode(),user);
    }

    public String[] lookup(String userName)
    {
        User user = convertUserNameToUser(userName);
        String[] userInfo = {user.getFirstName(),user.getLastName()};
        return userInfo;
    }

    public void delete(String userName)
    {
        testCaseUsers.deleteEntry(userName.hashCode());
    }

    public User convertUserNameToUser(String userName)
    {
        User user = testCaseUsers.getValue(userName.hashCode());
        return user;
    }
}
