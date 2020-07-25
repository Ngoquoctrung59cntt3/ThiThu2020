package vn.edu.ntu.thithu2020;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.fragment.NavHostFragment;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class DangKyFragment extends Fragment {

    NavController controller;
    private EditText mName;
    private EditText mDate;
    private ImageView mBtndate;
    private EditText mSdt;
    private RadioButton mSang;
    private RadioButton mChieu;
    private RadioButton mToi;
    private RadioGroup mRg;
    private Button mBtn;
    Spinner spinner;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_dang_ky, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        controller = NavHostFragment.findNavController(this);
        ((MainActivity) getActivity()).controller = controller;
        addview(view);
        Spinner();
    }
    public void addview(View view)
    {

        mName = view.findViewById(R.id.name);
        mDate =  view.findViewById(R.id.date);
        mBtndate =  view.findViewById(R.id.btndate);
        mSdt =  view.findViewById(R.id.sdt);
        mSang =  view.findViewById(R.id.sang);
        mChieu =  view.findViewById(R.id.chieu);
        mToi =  view.findViewById(R.id.toi);
        mRg =  view.findViewById(R.id.rg);
        mBtn =  view.findViewById(R.id.btn);
        spinner =  view.findViewById(R.id.spinner);
        mBtndate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                chonngay();
            }
        });
        mBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addevent();

            }
        });
    }
    public String Radio()
    {
        switch (mRg.getCheckedRadioButtonId())
        {
            case R.id.sang: return "Sáng";
            case R.id.chieu: return "Chiều";
            case R.id.toi: return "Tối";
            default: return "Sáng";
        }
    }
    public void Spinner()
    {
        List<String> list=new ArrayList<>();
        list.add("java");
        list.add("php");
        ArrayAdapter spinnerAdapter = new ArrayAdapter(getActivity(),android.R.layout.simple_spinner_item,list);
        spinner.setAdapter(spinnerAdapter);

    }
    public void chonngay()
    {
        Calendar calendar= Calendar.getInstance();
        DatePickerDialog.OnDateSetListener listener=new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                StringBuilder buffer=new StringBuilder();
                buffer.append(dayOfMonth)
                        .append("-")
                        .append(++month)
                        .append("-")
                        .append(year);

                mDate.setText(buffer.toString());
            }


        };
        DatePickerDialog datePickerDialog=new DatePickerDialog(getActivity(),
                listener,
                calendar.get(Calendar.YEAR),
                calendar.get(Calendar.MONTH),
                calendar.get(Calendar.DAY_OF_MONTH));
        datePickerDialog.show();
    }
    public void addevent()
    {

       String data= "Họ Tên Sinh Viên: "+mName.getText().toString()+"\n"
                + "Ngày Sinh: "+mDate.getText().toString()+"\n"
        +"Số Điện Thoại: "+mSdt.getText().toString()+"\n"
        +"Đã Đăng Ký Khoa Học: "+"\n"
        +spinner.getSelectedItem()+"\n"
        + "Giờ Học: "+ Radio()+"\n"
        +"Chúng Tôi Liên Hệ Với SỐ điện thoại:"+"\n"
        +mSdt.getText().toString();
        Bundle bundle=new Bundle();
        bundle.putString("data",data);
        controller.navigate(R.id.action_dangKyFragment_to_monHocFragment,bundle);
    }
}