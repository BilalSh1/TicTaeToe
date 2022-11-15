public class RendererFactory {

    public RendererFactory() {

    }

    public Renderer buildRenderer(String rendererType) {
        if (rendererType.equals("console")) {
            return new ConsoleRenderer(Board.SIZE);
        }
        if (rendererType.equals("none")) {
            return new voidRenderer();
        }
        return null;
    }
}
