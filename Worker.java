public class Worker {
    private final OnTaskDoneListener callback;
    private final OnTaskErrorListener errorCallback;

    public Worker(OnTaskDoneListener callback, OnTaskErrorListener errorCallback) {
        this.callback = callback;
        this.errorCallback = errorCallback;
    }

    public void start() {
        for (int i = 0; i < 100; i++) {
            if (i != 33) {
                callback.onDone("Task " + i + " is done");
            } else {
                errorCallback.onError("================Task " + i + " failed===================");
            }
        }
    }

        public static void main (String[]args){
            OnTaskDoneListener listener = System.out::println;
            OnTaskErrorListener errorListener = System.out::println;
            Worker worker = new Worker(listener, errorListener);
            worker.start();
        }
    }
