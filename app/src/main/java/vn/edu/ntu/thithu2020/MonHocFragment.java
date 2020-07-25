package vn.edu.ntu.thithu2020;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.fragment.NavHostFragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;


public class MonHocFragment extends Fragment {

     NavController controller;
     TextView data;
     Button btn;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_mon_hoc, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        controller= NavHostFragment.findNavController(this);
        ((MainActivity)getActivity()).controller=controller;
        data=view.findViewById(R.id.data);
        btn=view.findViewById(R.id.btn);
        Bundle bundle =getArguments();
        String dulieu=bundle.getString("data");
        data.setText(dulieu);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                controller.navigate(R.id.action_monHocFragment_to_dangKyFragment);
            }
        });
    }
}