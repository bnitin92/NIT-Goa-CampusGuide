package com.example.gm;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.text.Html;
import android.text.method.LinkMovementMethod;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.IOException;


public class CampusNews extends ActionBarActivity {
    Document doc = null;
    Elements newsHeadlines;
    String[] stri1 = new String[2];
    String[] stri2 = new String[2];
    String[] stri3 = new String[2];
    String[] stri4 = new String[2];
    TextView txt1,txt2,txt3,txt4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.campusnews);
        
        txt1 = (TextView)findViewById(R.id.txtView1);
        txt2 = (TextView)findViewById(R.id.txtView2);
        txt3 = (TextView)findViewById(R.id.txtView3);
        txt4 = (TextView)findViewById(R.id.txtView4);

        txt1.setClickable(true);
        txt2.setClickable(true);
        txt3.setClickable(true);
        txt4.setClickable(true);

        txt1.setMovementMethod(LinkMovementMethod.getInstance());
        txt2.setMovementMethod(LinkMovementMethod.getInstance());
        txt3.setMovementMethod(LinkMovementMethod.getInstance());
        txt4.setMovementMethod(LinkMovementMethod.getInstance());
        
        new JsoupListView().execute();
    }

    private class JsoupListView extends AsyncTask<Void, Void, Void> {
        @Override
        protected Void doInBackground(Void... params) {
            try {
                doc = Jsoup.connect("http://nitgoa.ac.in").get();
                newsHeadlines = doc.select("#news-marquee > table > tbody > tr > td > marquee > p:nth-child(2) > a");
                stri1[0] = newsHeadlines.text();
                stri1[1] = "http://nitgoa.ac.in/" + newsHeadlines.attr("href");
                newsHeadlines = doc.select("#news-marquee > table > tbody > tr > td > marquee > p:nth-child(6) > a");
                stri2[0] = newsHeadlines.text();
                stri2[1] = "http://nitgoa.ac.in/" + newsHeadlines.attr("href");
                newsHeadlines = doc.select("#news-marquee > table > tbody > tr > td > marquee > p:nth-child(10) > a");
                stri3[0] = newsHeadlines.text();
                stri3[1] = "http://nitgoa.ac.in/" + newsHeadlines.attr("href");
                newsHeadlines = doc.select("#news-marquee > table > tbody > tr > td > marquee > p:nth-child(14) > a");
                stri4[0] = newsHeadlines.text();
                stri4[1] = "http://nitgoa.ac.in/" + newsHeadlines.attr("href");
            } catch (IOException e) {
                e.printStackTrace();
            }

            return null;
        }

        @Override
        protected void onPostExecute(Void result) {
            Toast.makeText(CampusNews.this, "Done",Toast.LENGTH_LONG).show();
            String text;
            text = "<a href='"+stri1[1]+"'> "+stri1[0]+" </a>";
            txt1.setText(Html.fromHtml(text));
            text = "<a href='"+stri2[1]+"'> "+stri2[0]+" </a>";
            txt2.setText(Html.fromHtml(text));
            text = "<a href='"+stri3[1]+"'> "+stri3[0]+" </a>";
            txt3.setText(Html.fromHtml(text));
            text = "<a href='"+stri4[1]+"'> "+stri4[0]+" </a>";
            txt4.setText(Html.fromHtml(text));
        }


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
