package homework_three.chain_of_responsibility;

public class HttpRequest {
    private String path;
    private String method;
    private String authToken;
    private String userRole;
    private boolean authenticated = false;
    private boolean authorized = false;

    public HttpRequest(String path, String method, String authToken, String userRole) {
        this.path = path;
        this.method = method;
        this.authToken = authToken;
        this.userRole = userRole;
    }

    public String getPath() { return path; }
    public String getMethod() { return method; }
    public String getAuthToken() { return authToken; }
    public String getUserRole() { return userRole; }
    public boolean isAuthenticated() { return authenticated; }
    public void setAuthenticated(boolean authenticated) { this.authenticated = authenticated; }
    public boolean isAuthorized() { return authorized; }
    public void setAuthorized(boolean authorized) { this.authorized = authorized; }
}
