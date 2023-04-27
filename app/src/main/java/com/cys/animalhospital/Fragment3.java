package com.cys.animalhospital;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.bumptech.glide.Glide;

import de.hdodenhof.circleimageview.CircleImageView;

public class Fragment3 extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_3, container, false);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        text_name = view.findViewById(R.id.text_name);
        tvCh_name = view.findViewById(R.id.tv_chName);
        civ = view.findViewById(R.id.civ_chp);
        view.findViewById(R.id.ch_Btn).setOnClickListener(v -> clickCBtn());
        civ.setOnClickListener(v -> clickCiv());

        super.onViewCreated(view, savedInstanceState);
    }

    EditText text_name;
    TextView tvCh_name;
    CircleImageView civ;


    void clickCBtn() {

        tvCh_name.setText(text_name.getText().toString());
        ((MainActivity) getActivity()).headerViewTv.setText(text_name.getText().toString());
        text_name.setText(null);

    }

    void clickCiv() {
        Intent intent = new Intent(Intent.ACTION_OPEN_DOCUMENT).setType("image/*");
        resultLauncher.launch(intent);


    }

    ActivityResultLauncher<Intent> resultLauncher = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), result -> {

        if (result.getResultCode() != Activity.RESULT_CANCELED) {
            Uri uri = result.getData().getData();
            Glide.with(this).load(uri).into(civ);
            Glide.with(this).load(uri).into(((MainActivity) getActivity()).headerViewCiv);

        }
    });
}
