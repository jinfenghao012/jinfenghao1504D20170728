package jin.bwey.com.jinfenghao1504d20170728.Perstear;

import jin.bwey.com.jinfenghao1504d20170728.Module.callback;
import jin.bwey.com.jinfenghao1504d20170728.Module.network;
import jin.bwey.com.jinfenghao1504d20170728.View.Iview;

/**
 * Created by Administrator on 2017/7/28.
 */

public class MainPersonter implements callback {

    network network;
    Iview iview;
    public MainPersonter(Iview iview){
    network = new network(this);
        this.iview=iview;
    }

    public <T>void get_personter(String url ,Class<T> clazz){

        network.get_okhttp(url,clazz);

    }


    @Override
    public void Onsusses(Object o) {

        iview.Onsusses(o);

    }

    @Override
    public void onError(Exception e) {

    }
}
