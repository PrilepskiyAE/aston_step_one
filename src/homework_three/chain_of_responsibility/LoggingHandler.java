package homework_three.chain_of_responsibility;

public class LoggingHandler extends RequestHandler {
    @Override
    public void handleRequest(HttpRequest request) {
        System.out.println("📊 Логирование: " + request.getMethod() + " " + request.getPath());
        System.out.println("   Токен: " + (request.getAuthToken() != null ? "скрыт" : "отсутствует"));
        System.out.println("   Роль: " + request.getUserRole());

        // Это последний обработчик, дальше передавать не нужно
    }
}

