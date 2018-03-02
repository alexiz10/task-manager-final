public class Task {

    private String mName;
    private boolean mCompleted;

    Task(TaskBuilder builder) {
        mName = builder.name;
        mCompleted = builder.completed;
    }

    public String getName() {
        return mName;
    }

    public boolean isCompleted() {
        return mCompleted;
    }

    public void markCompleted() {
        mCompleted = true;
    }

    public static class TaskBuilder {

        private String name;
        private boolean completed;

        TaskBuilder(String name, boolean completed) {
            this.name = name;
            this.completed = completed;
        }

        public Task build() {
            return new Task(this);
        }

    }

}