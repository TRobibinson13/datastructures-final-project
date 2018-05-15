package Classes;

public class User
{
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String email;
    private String userName;
    private Integer userKey;

    public User(String firstName, String lastName, String phoneNumber, String email)
    {
        setFirstName(firstName);
        setLastName(lastName);
        setPhoneNumber(phoneNumber);
        setEmail(email);
        setUserName();
        setUserKey();
    }

    public String getFirstName()
    {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName()
    {
        return lastName;
    }

    public void setLastName(String lastName)
    {
        this.lastName = lastName;
    }

    public String getPhoneNumber()
    {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber)
    {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail()
    {
        return email;
    }

    public void setEmail(String email)
    {
        this.email = email;
    }

    public String getUserName()
    {
        return this.userName;
    }

    private void setUserName()
    {
        this.userName = (this.firstName + this.lastName).toUpperCase();
    }

    public Integer getUserKey()
    {
        if (this.userKey == null)
        {
            setUserKey();
        }
        return userKey;
    }

    public void setUserKey()
    {
        this.userKey = (this.userName).hashCode();
    }

}
