/*
 * Swagger Petstore
 * This is a sample server Petstore server.  You can find out more about Swagger at [http://swagger.io](http://swagger.io) or on [irc.freenode.net, #swagger](http://swagger.io/irc/).  For this sample, you can use the api key `special-key` to test the authorization filters.
 *
 * OpenAPI spec version: 1.0.3
 * Contact: apiteam@swagger.io
 *
 * NOTE: This class is auto generated by the swagger code generator program.
 * https://github.com/swagger-api/swagger-codegen.git
 * Do not edit the class manually.
 */


package io.swagger.petstore.api;

import com.google.gson.reflect.TypeToken;
import io.swagger.petstore.models.User;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.response.Response;

import java.lang.reflect.Type;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;
import io.swagger.petstore.JSON;

import static io.restassured.http.Method.*;

public class UserApi {

    private RequestSpecBuilder reqSpec;

    private UserApi(RequestSpecBuilder reqSpec) {
        this.reqSpec = reqSpec;
    }

    public static UserApi user(RequestSpecBuilder reqSpec) {
        return new UserApi(reqSpec);
    }


    public CreateUserOper createUser() {
        return new CreateUserOper(reqSpec);
    }

    public CreateUsersWithArrayInputOper createUsersWithArrayInput() {
        return new CreateUsersWithArrayInputOper(reqSpec);
    }

    public CreateUsersWithListInputOper createUsersWithListInput() {
        return new CreateUsersWithListInputOper(reqSpec);
    }

    public DeleteUserOper deleteUser() {
        return new DeleteUserOper(reqSpec);
    }

    public GetUserByNameOper getUserByName() {
        return new GetUserByNameOper(reqSpec);
    }

    public LoginUserOper loginUser() {
        return new LoginUserOper(reqSpec);
    }

    public LogoutUserOper logoutUser() {
        return new LogoutUserOper(reqSpec);
    }

    public UpdateUserOper updateUser() {
        return new UpdateUserOper(reqSpec);
    }

    /**
    * Customise request specification
    */
    public UserApi reqSpec(Consumer<RequestSpecBuilder> consumer) {
        consumer.accept(reqSpec);
        return this;
    }

    /**
     * Create user
     * This can only be done by the logged in user.
     *
     * @see #body Created user object (required)
     */
    public class CreateUserOper {

        public static final String REQ_URI = "/user";

        private RequestSpecBuilder reqSpec;

        private ResponseSpecBuilder respSpec;

        public CreateUserOper() {
            this.reqSpec = new RequestSpecBuilder();
            reqSpec.setContentType("application/json");
            reqSpec.setAccept("application/json");
            this.respSpec = new ResponseSpecBuilder();
        }

        public CreateUserOper(RequestSpecBuilder reqSpec) {
            this.reqSpec = reqSpec;
            reqSpec.setContentType("application/json");
            reqSpec.setAccept("application/json");
            this.respSpec = new ResponseSpecBuilder();
        }

        /**
         * POST /user
         */
        public <T> T execute(Function<Response, T> handler) {
            return handler.apply(RestAssured.given().spec(reqSpec.build()).expect().spec(respSpec.build()).when().request(POST, REQ_URI));
        }

         /**
         * @param body (User) Created user object (required)
         */
        public CreateUserOper body(User body) {
            reqSpec.setBody(body);
            return this;
        }

        /**
         * Customise request specification
         */
        public CreateUserOper reqSpec(Consumer<RequestSpecBuilder> consumer) {
            consumer.accept(reqSpec);
            return this;
        }

        /**
         * Customise response specification
         */
        public CreateUserOper respSpec(Consumer<ResponseSpecBuilder> consumer) {
            consumer.accept(respSpec);
            return this;
        }
    }
    /**
     * Creates list of users with given input array
     * 
     *
     * @see #body List of user object (required)
     */
    public class CreateUsersWithArrayInputOper {

        public static final String REQ_URI = "/user/createWithArray";

        private RequestSpecBuilder reqSpec;

        private ResponseSpecBuilder respSpec;

        public CreateUsersWithArrayInputOper() {
            this.reqSpec = new RequestSpecBuilder();
            reqSpec.setContentType("application/json");
            reqSpec.setAccept("application/json");
            this.respSpec = new ResponseSpecBuilder();
        }

        public CreateUsersWithArrayInputOper(RequestSpecBuilder reqSpec) {
            this.reqSpec = reqSpec;
            reqSpec.setContentType("application/json");
            reqSpec.setAccept("application/json");
            this.respSpec = new ResponseSpecBuilder();
        }

        /**
         * POST /user/createWithArray
         */
        public <T> T execute(Function<Response, T> handler) {
            return handler.apply(RestAssured.given().spec(reqSpec.build()).expect().spec(respSpec.build()).when().request(POST, REQ_URI));
        }

         /**
         * @param body (List<User>) List of user object (required)
         */
        public CreateUsersWithArrayInputOper body(List<User> body) {
            reqSpec.setBody(body);
            return this;
        }

        /**
         * Customise request specification
         */
        public CreateUsersWithArrayInputOper reqSpec(Consumer<RequestSpecBuilder> consumer) {
            consumer.accept(reqSpec);
            return this;
        }

        /**
         * Customise response specification
         */
        public CreateUsersWithArrayInputOper respSpec(Consumer<ResponseSpecBuilder> consumer) {
            consumer.accept(respSpec);
            return this;
        }
    }
    /**
     * Creates list of users with given input array
     * 
     *
     * @see #body List of user object (required)
     */
    public class CreateUsersWithListInputOper {

        public static final String REQ_URI = "/user/createWithList";

        private RequestSpecBuilder reqSpec;

        private ResponseSpecBuilder respSpec;

        public CreateUsersWithListInputOper() {
            this.reqSpec = new RequestSpecBuilder();
            reqSpec.setContentType("application/json");
            reqSpec.setAccept("application/json");
            this.respSpec = new ResponseSpecBuilder();
        }

        public CreateUsersWithListInputOper(RequestSpecBuilder reqSpec) {
            this.reqSpec = reqSpec;
            reqSpec.setContentType("application/json");
            reqSpec.setAccept("application/json");
            this.respSpec = new ResponseSpecBuilder();
        }

        /**
         * POST /user/createWithList
         */
        public <T> T execute(Function<Response, T> handler) {
            return handler.apply(RestAssured.given().spec(reqSpec.build()).expect().spec(respSpec.build()).when().request(POST, REQ_URI));
        }

         /**
         * @param body (List<User>) List of user object (required)
         */
        public CreateUsersWithListInputOper body(List<User> body) {
            reqSpec.setBody(body);
            return this;
        }

        /**
         * Customise request specification
         */
        public CreateUsersWithListInputOper reqSpec(Consumer<RequestSpecBuilder> consumer) {
            consumer.accept(reqSpec);
            return this;
        }

        /**
         * Customise response specification
         */
        public CreateUsersWithListInputOper respSpec(Consumer<ResponseSpecBuilder> consumer) {
            consumer.accept(respSpec);
            return this;
        }
    }
    /**
     * Delete user
     * This can only be done by the logged in user.
     *
     * @see #usernamePath The name that needs to be deleted (required)
     */
    public class DeleteUserOper {

        public static final String REQ_URI = "/user/{username}";

        private RequestSpecBuilder reqSpec;

        private ResponseSpecBuilder respSpec;

        public DeleteUserOper() {
            this.reqSpec = new RequestSpecBuilder();
            reqSpec.setAccept("application/json");
            this.respSpec = new ResponseSpecBuilder();
        }

        public DeleteUserOper(RequestSpecBuilder reqSpec) {
            this.reqSpec = reqSpec;
            reqSpec.setAccept("application/json");
            this.respSpec = new ResponseSpecBuilder();
        }

        /**
         * DELETE /user/{username}
         */
        public <T> T execute(Function<Response, T> handler) {
            return handler.apply(RestAssured.given().spec(reqSpec.build()).expect().spec(respSpec.build()).when().request(DELETE, REQ_URI));
        }

        /**
         * @param username (String) The name that needs to be deleted (required)
         */
        public DeleteUserOper usernamePath(Object username) {
            reqSpec.addPathParam("username", username);
            return this;
        }

        /**
         * Customise request specification
         */
        public DeleteUserOper reqSpec(Consumer<RequestSpecBuilder> consumer) {
            consumer.accept(reqSpec);
            return this;
        }

        /**
         * Customise response specification
         */
        public DeleteUserOper respSpec(Consumer<ResponseSpecBuilder> consumer) {
            consumer.accept(respSpec);
            return this;
        }
    }
    /**
     * Get user by user name
     * 
     *
     * @see #usernamePath The name that needs to be fetched. Use user1 for testing.  (required)
     * return User
     */
    public class GetUserByNameOper {

        public static final String REQ_URI = "/user/{username}";

        private RequestSpecBuilder reqSpec;

        private ResponseSpecBuilder respSpec;

        public GetUserByNameOper() {
            this.reqSpec = new RequestSpecBuilder();
            reqSpec.setAccept("application/json");
            this.respSpec = new ResponseSpecBuilder();
        }

        public GetUserByNameOper(RequestSpecBuilder reqSpec) {
            this.reqSpec = reqSpec;
            reqSpec.setAccept("application/json");
            this.respSpec = new ResponseSpecBuilder();
        }

        /**
         * GET /user/{username}
         */
        public <T> T execute(Function<Response, T> handler) {
            return handler.apply(RestAssured.given().spec(reqSpec.build()).expect().spec(respSpec.build()).when().request(GET, REQ_URI));
        }

        /**
         * GET /user/{username}
         * @return User
         */
        public User executeAs(Function<Response, Response> handler) {
            Type type = new TypeToken<User>(){}.getType();
            return execute(handler).as(type);
        }

        /**
         * @param username (String) The name that needs to be fetched. Use user1 for testing.  (required)
         */
        public GetUserByNameOper usernamePath(Object username) {
            reqSpec.addPathParam("username", username);
            return this;
        }

        /**
         * Customise request specification
         */
        public GetUserByNameOper reqSpec(Consumer<RequestSpecBuilder> consumer) {
            consumer.accept(reqSpec);
            return this;
        }

        /**
         * Customise response specification
         */
        public GetUserByNameOper respSpec(Consumer<ResponseSpecBuilder> consumer) {
            consumer.accept(respSpec);
            return this;
        }
    }
    /**
     * Logs user into the system
     * 
     *
     * @see #usernameQuery The user name for login (required)
     * @see #passwordQuery The password for login in clear text (required)
     * return String
     */
    public class LoginUserOper {

        public static final String REQ_URI = "/user/login";

        private RequestSpecBuilder reqSpec;

        private ResponseSpecBuilder respSpec;

        public LoginUserOper() {
            this.reqSpec = new RequestSpecBuilder();
            reqSpec.setAccept("application/json");
            this.respSpec = new ResponseSpecBuilder();
        }

        public LoginUserOper(RequestSpecBuilder reqSpec) {
            this.reqSpec = reqSpec;
            reqSpec.setAccept("application/json");
            this.respSpec = new ResponseSpecBuilder();
        }

        /**
         * GET /user/login
         */
        public <T> T execute(Function<Response, T> handler) {
            return handler.apply(RestAssured.given().spec(reqSpec.build()).expect().spec(respSpec.build()).when().request(GET, REQ_URI));
        }

        /**
         * GET /user/login
         * @return String
         */
        public String executeAs(Function<Response, Response> handler) {
            Type type = new TypeToken<String>(){}.getType();
            return execute(handler).as(type);
        }

        /**
         * @param username (String) The user name for login (required)
         */
        public LoginUserOper usernameQuery(Object... username) {
            reqSpec.addQueryParam("username", username);
            return this;
        }

        /**
         * @param password (String) The password for login in clear text (required)
         */
        public LoginUserOper passwordQuery(Object... password) {
            reqSpec.addQueryParam("password", password);
            return this;
        }

        /**
         * Customise request specification
         */
        public LoginUserOper reqSpec(Consumer<RequestSpecBuilder> consumer) {
            consumer.accept(reqSpec);
            return this;
        }

        /**
         * Customise response specification
         */
        public LoginUserOper respSpec(Consumer<ResponseSpecBuilder> consumer) {
            consumer.accept(respSpec);
            return this;
        }
    }
    /**
     * Logs out current logged in user session
     * 
     *
     */
    public class LogoutUserOper {

        public static final String REQ_URI = "/user/logout";

        private RequestSpecBuilder reqSpec;

        private ResponseSpecBuilder respSpec;

        public LogoutUserOper() {
            this.reqSpec = new RequestSpecBuilder();
            reqSpec.setAccept("application/json");
            this.respSpec = new ResponseSpecBuilder();
        }

        public LogoutUserOper(RequestSpecBuilder reqSpec) {
            this.reqSpec = reqSpec;
            reqSpec.setAccept("application/json");
            this.respSpec = new ResponseSpecBuilder();
        }

        /**
         * GET /user/logout
         */
        public <T> T execute(Function<Response, T> handler) {
            return handler.apply(RestAssured.given().spec(reqSpec.build()).expect().spec(respSpec.build()).when().request(GET, REQ_URI));
        }

        /**
         * Customise request specification
         */
        public LogoutUserOper reqSpec(Consumer<RequestSpecBuilder> consumer) {
            consumer.accept(reqSpec);
            return this;
        }

        /**
         * Customise response specification
         */
        public LogoutUserOper respSpec(Consumer<ResponseSpecBuilder> consumer) {
            consumer.accept(respSpec);
            return this;
        }
    }
    /**
     * Updated user
     * This can only be done by the logged in user.
     *
     * @see #usernamePath name that need to be updated (required)
     * @see #body Updated user object (required)
     */
    public class UpdateUserOper {

        public static final String REQ_URI = "/user/{username}";

        private RequestSpecBuilder reqSpec;

        private ResponseSpecBuilder respSpec;

        public UpdateUserOper() {
            this.reqSpec = new RequestSpecBuilder();
            reqSpec.setContentType("application/json");
            reqSpec.setAccept("application/json");
            this.respSpec = new ResponseSpecBuilder();
        }

        public UpdateUserOper(RequestSpecBuilder reqSpec) {
            this.reqSpec = reqSpec;
            reqSpec.setContentType("application/json");
            reqSpec.setAccept("application/json");
            this.respSpec = new ResponseSpecBuilder();
        }

        /**
         * PUT /user/{username}
         */
        public <T> T execute(Function<Response, T> handler) {
            return handler.apply(RestAssured.given().spec(reqSpec.build()).expect().spec(respSpec.build()).when().request(PUT, REQ_URI));
        }

         /**
         * @param body (User) Updated user object (required)
         */
        public UpdateUserOper body(User body) {
            reqSpec.setBody(body);
            return this;
        }

        /**
         * @param username (String) name that need to be updated (required)
         */
        public UpdateUserOper usernamePath(Object username) {
            reqSpec.addPathParam("username", username);
            return this;
        }

        /**
         * Customise request specification
         */
        public UpdateUserOper reqSpec(Consumer<RequestSpecBuilder> consumer) {
            consumer.accept(reqSpec);
            return this;
        }

        /**
         * Customise response specification
         */
        public UpdateUserOper respSpec(Consumer<ResponseSpecBuilder> consumer) {
            consumer.accept(respSpec);
            return this;
        }
    }
}