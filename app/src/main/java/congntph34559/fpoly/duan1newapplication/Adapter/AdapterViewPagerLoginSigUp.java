package congntph34559.fpoly.duan1newapplication.Adapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import congntph34559.fpoly.duan1newapplication.Fragment.FragLogin;
import congntph34559.fpoly.duan1newapplication.Fragment.FragSigUp;


public class AdapterViewPagerLoginSigUp extends FragmentStateAdapter {
    public AdapterViewPagerLoginSigUp(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {

        switch (position){

            case 0:
                return new FragLogin();
            case 1:
                return new FragSigUp();
            default:
                return new FragLogin();

        }


    }

    @Override
    public int getItemCount() {
        return 2;
    }
}
