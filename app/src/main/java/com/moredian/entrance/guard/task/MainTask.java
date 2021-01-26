package com.moredian.entrance.guard.task;

import android.content.Context;

public class MainTask {

    public MainTask() {

    }

    public static class UpdateTask extends GenericTask {

        public Context mContext;
        public UpdateView updateView;

        public UpdateTask(Context context) {
            mContext = context;
            updateView = new UpdateView(mContext);
        }

        public UpdateTask(Context context, boolean shownull) {
            mContext = context;
            updateView = new UpdateView(mContext, shownull);
        }

        @Override
        protected TaskResult _doInBackground(TaskParams... params) {
            try {
                updateView.Start();
                return TaskResult.OK;
            } catch (Exception ignored) {
            }
            return TaskResult.FAILED;
        }
    }

}
