public class RendererFactory {

    public RendererFactory() {

    }

    public Renderer buildRenderer(String rendererType) {
        if (rendererType.equals("console")) {
            return new ConsoleRenderer(Board.SIZE);
        }
        return null;
    }
}
