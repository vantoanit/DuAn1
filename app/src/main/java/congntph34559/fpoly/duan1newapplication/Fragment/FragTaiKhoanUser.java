package congntph34559.fpoly.duan1newapplication.Fragment;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.widget.AppCompatButton;
import androidx.fragment.app.Fragment;

import congntph34559.fpoly.duan1newapplication.DiaChiActivity;
import congntph34559.fpoly.duan1newapplication.DoiMatKhauUserActivity;
import congntph34559.fpoly.duan1newapplication.LienHeGopYActivity;
import congntph34559.fpoly.duan1newapplication.R;
import congntph34559.fpoly.duan1newapplication.ThongTinCaNhanActivity;
import congntph34559.fpoly.duan1newapplication.ViCuaToiActivity;
import congntph34559.fpoly.duan1newapplication.WelcomeActivity;


public class FragTaiKhoanUser extends Fragment {

    private AppCompatButton btnThongTinCaNhan, btnViCaNhan, btnLienHeCaNhan, btnDoiMatKhau, btnDangXuat;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.frag_tai_khoan_user, container, false);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        btnThongTinCaNhan = view.findViewById(R.id.btnThongTinCaNhan);
        btnViCaNhan = view.findViewById(R.id.btnViCaNhan);
        btnLienHeCaNhan = view.findViewById(R.id.btnLienHeGopY);
        btnDoiMatKhau = view.findViewById(R.id.btnDoiMatKhau);
        btnDangXuat = view.findViewById(R.id.btnDangXuat);

        //xu ly lay ten damg nhap

        SharedPreferences sharedPreferences = getActivity().getSharedPreferences("USER_FILE", Context.MODE_PRIVATE);
        String loggedInUserName = sharedPreferences.getString("userName", "Default UserName");

        TextView txtTenTaiKhoan = view.findViewById(R.id.txtTenTaiKhoanUser);
        txtTenTaiKhoan.setText(loggedInUserName);


        btnThongTinCaNhan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), ThongTinCaNhanActivity.class);
                startActivity(intent);
            }
        });


        btnViCaNhan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), ViCuaToiActivity.class);
                startActivity(intent);
            }
        });

        btnLienHeCaNhan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), LienHeGopYActivity.class);
                startActivity(intent);
            }
        });

        btnDangXuat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
                View view1 = LayoutInflater.from(getContext()).inflate(R.layout.dialog_xac_nhan, null, false);
                builder.setView(view1);

                AlertDialog dialog = builder.create();
                Window window = dialog.getWindow();
                window.setLayout(WindowManager.LayoutParams.MATCH_PARENT, WindowManager.LayoutParams.WRAP_CONTENT);
                window.setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));

                AppCompatButton btnXacNhan, btnHuy;
                TextView tvNoiDung;

                btnHuy = view1.findViewById(R.id.btnHuyDialog);
                btnXacNhan = view1.findViewById(R.id.btnXacNhanDialog);
                tvNoiDung = view1.findViewById(R.id.tvNoiDungDialog);
                tvNoiDung.setText("Bạn có chắc chắn muốn đăng xuất không ?");

                btnXacNhan.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(getContext(), WelcomeActivity.class);
                        startActivity(intent);
                        getActivity().finish();
                    }
                });
                btnHuy.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        dialog.dismiss();
                    }
                });


                dialog.show();


            }
        });

        btnDoiMatKhau.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), DoiMatKhauUserActivity.class);
                startActivity(intent);
            }
        });
    }
}
