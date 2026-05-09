package homework_three.chain_of_responsibility;

public class AuthorizationHandler extends RequestHandler {
    @Override
    public void handleRequest(HttpRequest request) {
        if (!request.isAuthenticated()) {
            System.out.println("❌ Запрос не аутентифицирован, авторизация невозможна");
            return;
        }

        if ("ADMIN".equals(request.getUserRole())) {
            request.setAuthorized(true);
            System.out.println("✅ Авторизация пройдена (роль: ADMIN)");
        } else if ("/public".equals(request.getPath())) {
            request.setAuthorized(true);
            System.out.println("✅ Авторизация пройдена (публичный ресурс)");
        } else {
            System.out.println("❌ Доступ запрещён");
            return; // Запрещаем доступ и прерываем цепочку
        }

        // Передаём дальше
        if (nextHandler != null) {
            nextHandler.handleRequest(request);
        }
    }
}
