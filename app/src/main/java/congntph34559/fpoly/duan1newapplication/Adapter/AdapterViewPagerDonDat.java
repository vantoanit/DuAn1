package congntph34559.fpoly.duan1newapplication.Adapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import congntph34559.fpoly.duan1newapplication.Fragment.FragDonDatUser;
import congntph34559.fpoly.duan1newapplication.Fragment.FragDonHuyUser;
import congntph34559.fpoly.duan1newapplication.Fragment.FragGiaoHangUser;
import congntph34559.fpoly.duan1newapplication.Fragment.FragHoanThanhUser;
import congntph34559.fpoly.duan1newapplication.Fragment.FragLogin;
import congntph34559.fpoly.duan1newapplication.Fragment.FragSigUp;


public class AdapterViewPagerDonDat extends FragmentStateAdapter {


    public AdapterViewPagerDonDat(@NonNull Fragment fragment) {
        super(fragment);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {

        switch (position) {

            case 0:
                return new FragDonDatUser();
            case 1:
                return new FragGiaoHangUser();
            case 2:
                return new FragHoanThanhUser();
            case 3:
                return new FragDonHuyUser();
            default:
                return new FragDonDatUser();

        }


    }

    @Override
    public int getItemCount() {
        return 4;
    }
}
