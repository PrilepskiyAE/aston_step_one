package homework_three.chain_of_responsibility;

public class ChainOfResponsibilityExemple {
    public static void invoke(){
        RequestHandler authHandler = new AuthHandler();
        RequestHandler authorizationHandler = new AuthorizationHandler();
        RequestHandler loggingHandler = new LoggingHandler();

        authHandler.setNext(authorizationHandler);
        authorizationHandler.setNext(loggingHandler);

        System.out.println("=== Тест 1: Успешный запрос ===");
        HttpRequest request1 = new HttpRequest("/admin", "GET", "Bearer token123", "ADMIN");
        authHandler.handleRequest(request1);

        System.out.println("\n=== Тест 2: Публичный ресурс ===");
        HttpRequest request2 = new HttpRequest("/public", "GET", "Bearer token123", "USER");
        authHandler.handleRequest(request2);

        System.out.println("\n=== Тест 3: Неавторизованный доступ ===");
        HttpRequest request3 = new HttpRequest("/admin", "GET", null, "USER");
        authHandler.handleRequest(request3);
    }
}
