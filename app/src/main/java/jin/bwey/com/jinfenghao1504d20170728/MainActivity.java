package jin.bwey.com.jinfenghao1504d20170728;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import jin.bwey.com.jinfenghao1504d20170728.Module.bean;
import jin.bwey.com.jinfenghao1504d20170728.Perstear.MainPersonter;
import jin.bwey.com.jinfenghao1504d20170728.View.Iview;
import jin.bwey.com.jinfenghao1504d20170728.View.Myadapter;

public class MainActivity extends AppCompatActivity implements Iview{

    private  String url = "http://www.yulin520.com/a2a/impressApi/news/mergeList?sign=C7548DE604BCB8A17592EFB9006F9265&pageSize=20&gender=2&ts=1871746850&page=1";
    private List<bean.DataBean> list =new ArrayList<bean.DataBean>();
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = (RecyclerView) findViewById(R.id.recycler);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        Myadapter myadapter = new Myadapter(MainActivity.this,list );
        recyclerView.setAdapter(myadapter);

        new MainPersonter(this).get_personter(url,bean.class);

        myadapter.setItemClickListener(new Myadapter.MyItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                Toast.makeText(MainActivity.this, "position:"+position +"     "+ list.get(position).getIntroduction(), Toast.LENGTH_SHORT).show();
            }
        });

    }

    @Override
    public void Onsusses(Object o) {

        bean bean = (jin.bwey.com.jinfenghao1504d20170728.Module.bean) o;
      list.addAll(bean.getData());


    }

    @Override
    public void onError(Exception e) {

    }
}
