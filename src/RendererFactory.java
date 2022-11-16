public class RendererFactory {

    public RendererFactory() {

    }

    public Renderer buildRenderer(String type, int size) {
        if (type.equals("console")) {
            return new ConsoleRenderer(size);
        }
        if (type.equals("none")) {
            return new VoidRenderer();
        }
        return null;
    }
}
