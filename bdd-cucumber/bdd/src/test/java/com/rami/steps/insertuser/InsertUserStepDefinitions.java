package com.rami.steps.insertuser;

import com.rami.User;
import com.rami.steps.RestServiceApplicationSpringBootTest;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.springframework.http.*;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;


public class InsertUserStepDefinitions extends RestServiceApplicationSpringBootTest {

    private User user;
    private String url;
    private ResponseEntity<String> response;
    private HttpStatus httpStatusExpected;
    private HttpHeaders headers = new HttpHeaders();


    @Before
    public void before() {
        user= new User();
    }



    @And("^last name is ([^\"]*)$")
    public void lastNameIsLastName(final String lastName) throws Throwable {
       user.setLastName(lastName);
    }

    @Given("^that the users first name is ([^\"]*)$")
    public void thatTheUsersFirstNameIsFirstName(final String firstName) throws Throwable {
        user.setFirstName(firstName);
    }

    @And("^email is ([^\"]*)$")
    public void emailIsEmail(final String email) throws Throwable {
        user.setEmail(email);
    }

    @And("^the User rest service is at ([^\"]*)$")
    public void theUserRestServiceIsAtInsertUserUrl(final String url) throws Throwable {
        this.url=url;
    }

/*
    @When("^we invoke the insert user endpoint$")
    public void weInvokeTheInsertUserEndpoint() throws Throwable {
        HttpEntity<User> entity = new HttpEntity<User>(user, headers);

       response = template.exchange(url,HttpMethod.POST, entity, String.class);
    }
*/

    @Then("^the response HTTP status is ([^\"]*)$")
    public void theResponseHTTPStatusIsHttpStatus(final String expectedHttpStatusAsString) throws Throwable {
        httpStatusExpected = HttpStatus.valueOf(expectedHttpStatusAsString);
        assertThat(response.getStatusCode(), is(httpStatusExpected));

    }

    @And("^the Http Code is ([^\"]*)$")
    public void theHttpCodeIsHttpCode(final int expectedHttpStatusCode) throws Throwable {
        assertThat(response.getStatusCodeValue(), is(expectedHttpStatusCode));

    }

    @And("^response body is ([^\"]*)$")
    public void responseBodyIsResponseBody(final String expectedResponseBody) throws Throwable {
        assertThat(response.getBody(), is(expectedResponseBody));

    }

    @When("^a call is made to ([^\"]*) using the ([^\"]*) http method$")
    public void aCallIsMadeToUrlUsingTheHttpMethodHttpMethod(final String url, final String httpMethodName) throws Throwable {
        final HttpMethod httpMethod = HttpMethod.valueOf(httpMethodName);
        final HttpEntity<User> entity = new HttpEntity<User>(user, headers);

        response = template.exchange(url,httpMethod, entity, String.class);

    }
}
