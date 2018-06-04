package Classes;

public class TestCase
{
    private String testCaseTye;
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String email;
    private String userName;
    private int paramCount;
    private int verifiedParams;
    private boolean verification;
    private int testCaseListIndex;
    //private TestCase nextTestCase;

    public TestCase(String testCase)
    {
        String testCaseInfoString = new String(testCase.substring(testCase.indexOf(":") + 2));
        String testCaseType = new String(testCaseInfoString.substring(0, testCaseInfoString.indexOf(" ")));
        String[] testCaseInfo = testCaseInfoString.split(" ");
        this.testCaseTye = testCaseInfo[0];
        this.firstName = testCaseInfo[1];
        this.lastName = testCaseInfo[2];

        for (String params:testCaseInfo)
        {
            this.paramCount ++;
        }

        if(testCaseType.matches("Insert"))
        {
            this.verifiedParams++;

            this.phoneNumber = testCaseInfo[3];
            this.email = testCaseInfo[4];

            verifyName(firstName);
            verifyName(lastName);

            if(phoneNumber.matches("\\d{3}-\\d{3}-\\d{4}"))
            {
                this.verifiedParams++;
            }
            else
            {
                System.out.println("TestCase[" + getTestCaseListIndex() + "]'s PhoneNumber Couldn't be verified");
            }

            if(email.matches("(\\S+)@(\\S+)\\.(\\S+)"))
            {
                this.verifiedParams++;
            }
            else
            {
                System.out.println("TestCase[" + getTestCaseListIndex() + "]'s Email Couldn't be verified");

            }
        }

        else if(testCaseType.matches("Lookup"))
        {
            this.verifiedParams++;
            verifyName(firstName);
            verifyName(lastName);
        }

        else if(testCaseTye.matches("Delete"))
        {
            this.verifiedParams++;
            verifyName(firstName);
            verifyName(lastName);
        }
        //verifyTestCase();
        setUserName(firstName, lastName);
    }

    public void verifyName(String param)
    {
        if(param.matches("\\D*"))
        {
            this.verifiedParams++;
        }
        else
        {
            System.out.println("Name was not Verified");
        }
    }

    public void verifyTestCase(TestCase testCase)
    {
        if(this.verifiedParams == paramCount)
        {
            this.verification = true;
        }
    }

    public String getTestCaseTye()
    {
        return this.testCaseTye;
    }

    public void setTestCaseTye(String testCaseTye)
    {
        this.testCaseTye = testCaseTye;
    }

    public String getFirstName()
    {
        return firstName;
    }

    public void setFirstName(String firstName)
    {
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

    public boolean getVerification(TestCase testCase)
    {
        verifyTestCase(testCase);
        return verification;
    }

    public void setVerification(boolean verification)
    {
        this.verification = verification;
    }

    public String getUserName()
    {
        return userName;
    }

    public void setUserName(String firstName, String lastName)
    {
        if(verification)
        {
            this.userName = (firstName + lastName).toUpperCase();
        }
    }

    public int getTestCaseListIndex()
    {
        return testCaseListIndex;
    }

    public void setTestCaseListIndex(int index)
    {
        this.testCaseListIndex = index;
    }
}
