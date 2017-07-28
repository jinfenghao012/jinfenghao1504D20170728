package jin.bwey.com.jinfenghao1504d20170728.Module;


import android.os.Handler;
import android.os.Message;

import com.google.gson.Gson;
import com.squareup.okhttp.Call;
import com.squareup.okhttp.Callback;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;

import java.io.IOException;

/**
 * Created by Administrator on 2017/7/28.
 */

public class network<T> {

    private callback callback;

    public network(callback Callback) {
        this.callback = Callback;
    }

    Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);

            switch (msg.what) {
                case 0:
                    Object obj = msg.obj;
                    callback.Onsusses(obj);
            }
        }
    };


    public void get_okhttp(String url, final Class<T> clazz) {

        //创建okHttpClient对象
        OkHttpClient mOkHttpClient = new OkHttpClient();
        //创建一个Request
        Request request = new Request.Builder()
                .url(url)
                .build();
        //new call
        Call call = mOkHttpClient.newCall(request);
        //请求加入调度
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Request request, IOException e) {


            }

            @Override
            public void onResponse(final Response response) throws IOException {

                Gson gson = new Gson();
                T t = gson.fromJson(response.body().string(), clazz);

                Message message = new Message();

                message.what = 0;
                message.obj = t;

                handler.sendMessage(message);

            }
        });

    }


}
