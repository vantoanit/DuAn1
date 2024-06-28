package congntph34559.fpoly.duan1newapplication.Adapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import congntph34559.fpoly.duan1newapplication.Fragment.DonDatAdminFragment;
import congntph34559.fpoly.duan1newapplication.Fragment.DangGiaoHangAdminFragment;
import congntph34559.fpoly.duan1newapplication.Fragment.HoanThanhDonDatAdminFragment;

public class QlTrangThaiDonDatAdminAdapter extends FragmentStateAdapter {
    public QlTrangThaiDonDatAdminAdapter(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch (position) {
            case 0:
                return new DonDatAdminFragment();
            case 1:
                return new DangGiaoHangAdminFragment();
            case 2:
                return new HoanThanhDonDatAdminFragment();
            default:
                return null;
        }
    }

    @Override
    public int getItemCount() {
        return 3;
    }
}
