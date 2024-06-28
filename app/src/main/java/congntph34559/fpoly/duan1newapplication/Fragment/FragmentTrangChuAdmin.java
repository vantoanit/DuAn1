package congntph34559.fpoly.duan1newapplication.Fragment;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;

import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

import java.util.ArrayList;

import congntph34559.fpoly.duan1newapplication.Adapter.AdapterFoodAdmin;
import congntph34559.fpoly.duan1newapplication.Adapter.AdapterSanPhamCuAdmin;
import congntph34559.fpoly.duan1newapplication.Adapter.AdapterSanPhamRauAdmin;
import congntph34559.fpoly.duan1newapplication.Adapter.AdapterViewPagerTrangChu;
import congntph34559.fpoly.duan1newapplication.DAO.DanhSachSanPhamDAO;
import congntph34559.fpoly.duan1newapplication.DAO.TrangChuAdminDAO;
import congntph34559.fpoly.duan1newapplication.DTO.DanhSachSanPhamDTO;
import congntph34559.fpoly.duan1newapplication.DTO.SanPhamRauAdminDTO;
import congntph34559.fpoly.duan1newapplication.R;

public class FragmentTrangChuAdmin extends Fragment {

    private TabLayout tabLayoutAdmin;
    private ViewPager2 viewPager2Admin;
    private AdapterViewPagerTrangChu adapterViewPagerTrangChu;
    private TextView tvTenTaiKhoan;
    private EditText edSeachSanPham;
    private TrangChuAdminDAO trangChuAdminDAO;
    private DanhSachSanPhamDAO danhSachSanPhamDAO;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.frg_trang_chu_admin, container, false);


        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        trangChuAdminDAO = new TrangChuAdminDAO(getContext());

        edSeachSanPham = view.findViewById(R.id.edSeachAdmin);
        tvTenTaiKhoan = view.findViewById(R.id.tvTenTaiKhoanAdmin);
        tabLayoutAdmin = view.findViewById(R.id.tabLayoutAdmin);
        viewPager2Admin = view.findViewById(R.id.viewPager2Admin);
        adapterViewPagerTrangChu = new AdapterViewPagerTrangChu(this);
        viewPager2Admin.setAdapter(adapterViewPagerTrangChu);


        SharedPreferences sharedPreferences = getActivity().getSharedPreferences("USER", Context.MODE_PRIVATE);
        String tenDangNhap = sharedPreferences.getString("tenDangNhap", "");
        tvTenTaiKhoan.setText("Hi, " + tenDangNhap);


        new TabLayoutMediator(tabLayoutAdmin, viewPager2Admin, (tab, position) -> {
            switch (position) {
                case 0:
                    tab.setText("Rau");
                    break;
                case 1:
                    tab.setText("Củ");
                    break;
                case 2:
                    tab.setText("Quả");
                    break;
            }
        }).attach();

        edSeachSanPham.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

                if (tabLayoutAdmin.getSelectedTabPosition() == 0) {

                    String tenSpRau = s.toString();
                    timKiemSanPhamRau(tenSpRau);

                } else if (tabLayoutAdmin.getSelectedTabPosition() == 1) {

                    String tenSpCu = s.toString();
                    timKiemSanPhamCu(tenSpCu);

                } else if (tabLayoutAdmin.getSelectedTabPosition() == 2) {

                    String tenSpQua = s.toString();
                    timKiemSanPhamQua(tenSpQua);

                }


            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });


    }

    private void timKiemSanPhamQua(String tenSpQua) {

        ArrayList<SanPhamRauAdminDTO> list = trangChuAdminDAO.timKiemQua(tenSpQua);

        if (list.size() > 0) {

            AdapterFoodAdmin adapterFoodAdmin = new AdapterFoodAdmin(list, getContext());
            FragmentQuaTrangChuAdmin.recyclerViewQuaAdmin.setAdapter(adapterFoodAdmin);
            adapterFoodAdmin.notifyDataSetChanged();

        }


    }

    private void timKiemSanPhamCu(String tenSpCu) {
        ArrayList<SanPhamRauAdminDTO> list = trangChuAdminDAO.timKiemCu(tenSpCu);

        if (list.size() > 0) {

            AdapterSanPhamCuAdmin adapterSanPhamCuAdmin = new AdapterSanPhamCuAdmin(list, getContext());
            FragmentCuTrangChuAdmin.recyclerViewCuAdmin.setAdapter(adapterSanPhamCuAdmin);
            adapterSanPhamCuAdmin.notifyDataSetChanged();

        }


    }

    private void timKiemSanPhamRau(String tenSpRau) {

        ArrayList<SanPhamRauAdminDTO> list = trangChuAdminDAO.timKiemRau(tenSpRau);

        if (list.size() > 0) {

            AdapterSanPhamRauAdmin adapterSanPhamRauAdmin = new AdapterSanPhamRauAdmin(list, getContext());
            FragmentRauTrangChuAdmin.recyclerViewRauAdmin.setAdapter(adapterSanPhamRauAdmin);
            adapterSanPhamRauAdmin.notifyDataSetChanged();

        }


    }
}
