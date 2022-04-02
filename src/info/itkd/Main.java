package info.itkd;

public class Main implements CounterFinishHandler {

    public static void main(String[] args) {
	    Counter counter = new Counter();
        counter.setCounterStartHandler(new CounterStartHandler() {
            @Override
            public void counterStart(CounterEvent evt) {
                System.out.println("COUNTER_START: " + evt.getCount());
            }
        });

        counter.setCounterChangeHandler(new CounterChangeHandler() {
            @Override
            public void counterChange(CounterEvent evt) {
                System.out.println("COUNTER_CHANGE: " + evt.getCount());
            }
        });

        /*counter.setCounterFinishHandler(new CounterFinishHandler() {
            @Override
            public void counterFinish(CounterEvent evt) {
                System.out.println("COUNTER_FINISH (Annonimous class) : " + evt.getCount());
            }
        });*/
        //counter.setCounterFinishHandler(new Main());
        //counter.removeCounterFinishHandler();

        counter.setCounterFinishHandler((CounterEvent evt) -> {
            System.out.println("COUNTER_FINISH (Lambda): " + evt.getCount());
        });
        counter.run();
    }

    public void counterFinish(CounterEvent evt) {
        Counter src = (Counter) evt.getSrc();
        System.out.println("COUNTER_FINISH (Main class): " + src.getCount());
    }
}
