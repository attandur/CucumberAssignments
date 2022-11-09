Feature: Register, Login and Compose email in Elearning


@Assignment
  Scenario Outline: SignIn up in Elearning portal
    Given user navigates to Elearning portal
    When user clicks on  Sign up!
    Then validate Register page is displayed    
    When user enters Registration details "<FirstName>" FirstName "<LastName>" LastName "<Email>" Email "<UserName>" UserName "<Password>" Password "<ConfirmPassword>" ConfirmPassword and submit form
    Then validate Registration complete message
    
    Examples: 
      | FirstName | LastName  | Email 				  | UserName | Password  | ConfirmPassword |
      | Anil750   | Tandur750 | aat750@mail7.io | aat750   | aat750pwd | aat750pwd       |
      
 @Assignment   
  Scenario Outline: Logging-in and composing mail in Elearning portal
        Given user navigates to Elearning portal
        When user enters "<UserName>" UserName and "<Password>" Password and Login
        Then validate that Profile is displayed
        When Click on Inbox and validate that Inbox page is opened
        Then Compose email and Send
        And Validate Messgae has been sent to "<FirstName>" FirstName and "<LastName>" LastName
        
        
    Examples: 
      | FirstName| LastName  | UserName | Password  |
      | Anil750	 | Tandur750 | aat750   | aat750pwd |
        
        
  
     
      
   
