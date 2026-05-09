package homework_three.chain_of_responsibility;

public abstract class RequestHandler {
    protected RequestHandler nextHandler;

    public void setNext(RequestHandler handler) {
        this.nextHandler = handler;
    }

    public abstract void handleRequest(HttpRequest request);
}