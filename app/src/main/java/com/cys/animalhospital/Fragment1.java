package com.cys.animalhospital;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;

public class Fragment1 extends Fragment {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_1, container, false);
    }

    RecyclerView recyclerView;
    ArrayList<AnimalItem> animalItems = new ArrayList<>();
    AnimalAdapter adapter;
    ImageView iv;
    String key = "c10fe98acffa44a8b1d82149f9fd9b93";

    int i = 1;
    int pSize = 5;

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        //animalItems.add(new AnimalItem("동물병원", "경기도 수원시 권선구", "탑동로", "123456789", "폐업", "031-1111-111", R.drawable.animal_haspital, R.drawable.baseline_call_24));

        recyclerView = view.findViewById(R.id.recycler);
        adapter = new AnimalAdapter(getActivity(), animalItems);
        recyclerView.setAdapter(adapter);
        getView().findViewById(R.id.btn_api).setOnClickListener(v -> clickBtn());
    }


    void clickBtn() {

        new Thread() {
            @Override
            public void run() {
                // https://openapi.gg.go.kr/Animalhosptl?KEY=c10fe98acffa44a8b1d82149f9fd9b93&Type=xml&pIndex=1&pSize=3

                String address = null;
                try {
                    address = "https://openapi.gg.go.kr/Animalhosptl?" +
                            "KEY=" + key +
                            "&Type=xml" +
                            "&pIndex=1" +
                            "&pSize=5" + pSize +
                            "&SIGUN_NM=" + URLEncoder.encode("수원시", "UTF-8");
                } catch (UnsupportedEncodingException e) {
                    throw new RuntimeException(e);
                }

                try {
                    URL url = new URL(address);


                    InputStream is = url.openStream();
                    InputStreamReader isr = new InputStreamReader(is);


                    XmlPullParserFactory factory = XmlPullParserFactory.newInstance();
                    XmlPullParser xpp = factory.newPullParser();
                    xpp.setInput(isr);


                    int eventType = xpp.getEventType();

                    AnimalItem animalItem = null;

                    while (eventType != XmlPullParser.END_DOCUMENT) {
                        switch (eventType) {
                            case XmlPullParser.START_DOCUMENT:


                            case XmlPullParser.COMMENT:
                                break;

                            case XmlPullParser.START_TAG:
                                String tagName = xpp.getName();//테그이름
                                if (tagName.equals("Animalhosptl")) {
                                    animalItem = new AnimalItem();

                                } else if (tagName.equals("BIZPLC_NM")) {
                                    xpp.next();
                                    animalItem.BIZPLC_NM = xpp.getText();

                                } else if (tagName.equals("REFINE_LOTNO_ADDR")) {
                                    xpp.next();
                                    animalItem.REFINE_LOTNO_ADDR = xpp.getText();

                                } else if (tagName.equals("REFINE_ROADNM_ADDR")) {
                                    xpp.next();
                                    animalItem.REFINE_ROADNM_ADDR = xpp.getText();

                                } else if (tagName.equals("BSN_STATE_NM")) {
                                    xpp.next();
                                    animalItem.BSN_STATE_NM = xpp.getText();

                                } else if (tagName.equals("LOCPLC_FACLT_TELNO")) {
                                    xpp.next();
                                    animalItem.LOCPLC_FACLT_TELNO = xpp.getText();

                                } else if (tagName.equals("REFINE_ZIP_CD")) {
                                    xpp.next();
                                    animalItem.REFINE_ZIP_CD = xpp.getText();
                                }
                                break;

                            case XmlPullParser.END_TAG:
                                String tagName2 = xpp.getName();
                                if (tagName2.equals("Animalhosptl")) {
                                    animalItems.add(animalItem);
                                    animalItem = null;
                                }
                                break;
                        }
                        eventType = xpp.next();
                    }//while...

                    getActivity().runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            adapter.notifyDataSetChanged();
                        }
                    });

                } catch (MalformedURLException e) {
                    throw new RuntimeException(e);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                } catch (XmlPullParserException e) {
                    throw new RuntimeException(e);
                }
            }
        }.start();

    }

}


