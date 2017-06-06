package com.example.administrator.mydbcontrol;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    List<tb_city> lists=new ArrayList<>();
    List<tb_province> lists2=new ArrayList<>();
    private static final String DB_PATH = "/data/data/com.example.administrator.mydbcontrol/databases/";
    private static final String DB_NAME = App.getAppInsatnce().DB_NAME;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //查询数据库
        findViewById(R.id.butt).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                lists2= App.getDBManager().selectProvinceList();//查数据库缓存
                if (lists2.size()>0){
                    Log.e("haifeng","数据库表的大小"+lists2.size());

                    for (int i = 0; i < 3; i++) {
                        String name= lists2.get(i).getProvincename()+"";
                        Toast.makeText(App.getAppContext(),"数据库表的大小"+lists2.size()+"；name="+name,Toast.LENGTH_LONG).show();
                    }

                }else {
                    Toast.makeText(App.getAppContext(),"数据库空的",Toast.LENGTH_LONG).show();
                }



            }
        });


        findViewById(R.id.butt2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                lists= App.getDBManager().selectCityList();//查数据库缓存
                if (lists.size()>0){
                    Log.e("haifeng","数据库表的大小"+lists.size());

                    for (int i = 0; i < 3; i++) {
                        String name= lists.get(i).getCityname();
                        Toast.makeText(App.getAppContext(),"数据库表的大小"+lists.size()+"；name="+name,Toast.LENGTH_LONG).show();
                    }

                }else {
                    Toast.makeText(App.getAppContext(),"数据库空的",Toast.LENGTH_LONG).show();
                }
            }
        });

    }

}
