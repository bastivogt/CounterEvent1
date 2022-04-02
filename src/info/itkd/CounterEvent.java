package info.itkd;

public class CounterEvent extends Event {

    int count;

    public CounterEvent(Object src, int count) {
        super(src);
        this.count = count;
    }

    public int getCount() {
        return this.count;
    }
}
