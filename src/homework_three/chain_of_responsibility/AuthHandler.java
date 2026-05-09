package homework_three.chain_of_responsibility;

public class AuthHandler extends RequestHandler {
    @Override
    public void handleRequest(HttpRequest request) {
        if (request.getAuthToken() != null && request.getAuthToken().startsWith("Bearer ")) {
            request.setAuthenticated(true);
            System.out.println("✅ Аутентификация пройдена");
        } else {
            System.out.println("❌ Аутентификация не пройдена");
            return;
        }

        if (nextHandler != null) {
            nextHandler.handleRequest(request);
        }
    }
}

