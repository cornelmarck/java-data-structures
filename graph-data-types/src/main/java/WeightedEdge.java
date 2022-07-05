public class WeightedEdge<V> implements Comparable<WeightedEdge<V>> {
    private final V from;
    private final V to;
    private final double weight;

    public WeightedEdge(V from, V to, double weight) {
        this.from = from;
        this.to = to;
        this.weight = weight;
    }

    public double getWeight() {
        return weight;
    }

    public V from() {
        return from;
    }

    public V to() {
        return to;
    }

    @Override
    public int compareTo(WeightedEdge<V> other) {
        return Double.compare(getWeight(), other.getWeight());
    }
}
