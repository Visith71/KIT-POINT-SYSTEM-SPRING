=========

## KITPoint-System

### Build and Deploy the Project
```
mvn clean install
```

This is a Spring Boot project, so you can deploy it by simply using the main class: `Application.java`


### Set up Email

You need to configure the email by providing your own username and password in application.properties
You also need to use your own host, you can use Amazon or Google for example.
You may also setup an email server locally.  See "email.properties.localhost.sample" for more details.

### AuthenticationSuccessHandler configuration for Custom Login Page article
If you want to activate the configuration for the article [Custom Login Page for Returning User](http://www.baeldung.com/custom-login-page-for-returning-user), then you need to comment the @Component("myAuthenticationSuccessHandler") annotation in the MySimpleUrlAuthenticationSuccessHandler and uncomment the same in MyCustomLoginAuthenticationSuccessHandler.
# KITPoint-System



# git origion is "myOrigin" 
