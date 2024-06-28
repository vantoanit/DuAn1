package congntph34559.fpoly.duan1newapplication.Adapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import congntph34559.fpoly.duan1newapplication.DanhSachSanPhamUseActivity;
import congntph34559.fpoly.duan1newapplication.Fragment.FragCuDanhSachSanPhamUse;
import congntph34559.fpoly.duan1newapplication.Fragment.FragQuaDanhSachSanPhamUse;
import congntph34559.fpoly.duan1newapplication.Fragment.FragRauDanhSachSanPhamUse;


public class MyViewPagerAdapter extends FragmentStateAdapter {


    public MyViewPagerAdapter(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch (position){
            case 0:
                return new FragRauDanhSachSanPhamUse();
            case 1:
                return new FragCuDanhSachSanPhamUse();
            case 2:
                return new FragQuaDanhSachSanPhamUse();
            default:
                return new FragRauDanhSachSanPhamUse();
        }
    }

    @Override
    public int getItemCount() {
        return 3;
    }
}
