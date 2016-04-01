package com.yong.job.four;

import android.app.Activity;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;

import com.yong.job.R;

public class AsynTaskActivity extends Activity implements View.OnClickListener {

    private Button start;
    private ProgressBar bar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.four_asyn_task_activity);
        start = (Button) findViewById(R.id.start);
        start.setOnClickListener(this);
        bar = (ProgressBar) findViewById(R.id.progress);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.start:
                new DownloadTask(bar).execute();
                break;
        }
    }

    class DownloadTask extends AsyncTask<Void, Integer, Boolean> {

        private ProgressBar bar;

        public DownloadTask(ProgressBar bar) {
            super();
            this.bar = bar;
        }

        @Override
        protected Boolean doInBackground(Void... params) {
            for (int i = 0; i <= 100; i += 10) {
                publishProgress(i);
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            return true;
        }

        @Override
        protected void onProgressUpdate(Integer... values) {
            bar.setProgress(values[0]);
        }

        @Override
        protected void onPostExecute(Boolean aBoolean) {

        }
    }
}
