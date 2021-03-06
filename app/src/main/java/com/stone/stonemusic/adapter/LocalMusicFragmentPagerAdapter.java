package com.stone.stonemusic.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.view.ViewGroup;

import com.stone.stonemusic.R;
import com.stone.stonemusic.ui.activity.LocalListActivity;
import com.stone.stonemusic.ui.fragment.AlbumListFragment;
import com.stone.stonemusic.ui.fragment.ArtistListFragment;
import com.stone.stonemusic.ui.fragment.FolderListFragment;
import com.stone.stonemusic.ui.fragment.MusicListFragment;
import com.stone.stonemusic.utils.MusicAppUtils;

public class LocalMusicFragmentPagerAdapter extends FragmentPagerAdapter {

    private final int PAGER_COUNT = 4;
    private MusicListFragment musicListFragment = null;
    private ArtistListFragment artistListFragment = null;
    private AlbumListFragment albumListFragment = null;
    private FolderListFragment folderListFragment = null;

    private String[] mTitles = new String[]{
            MusicAppUtils.getContext().getResources().getString(R.string.tab_menu_music),
            MusicAppUtils.getContext().getResources().getString(R.string.tab_menu_artist),
            MusicAppUtils.getContext().getResources().getString(R.string.tab_menu_album),
            MusicAppUtils.getContext().getResources().getString(R.string.tab_menu_folder) };

    public LocalMusicFragmentPagerAdapter(FragmentManager fm) {
        super(fm);
        musicListFragment = new MusicListFragment();
        artistListFragment = new ArtistListFragment();
        albumListFragment = new AlbumListFragment();
        folderListFragment = new FolderListFragment();
    }

    @Override
    public int getCount() {
        return PAGER_COUNT;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        return super.instantiateItem(container, position);
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        super.destroyItem(container, position, object);
    }

    @Override
    public Fragment getItem(int position) {
        Fragment fragment = null;
        switch (position) {
            case LocalListActivity.PAGE_MUSIC:
                fragment = musicListFragment;
                break;
            case LocalListActivity.PAGE_ARTIST:
                fragment = artistListFragment;
                break;
            case LocalListActivity.PAGE_ALBUM:
                fragment = albumListFragment;
                break;
            case LocalListActivity.PAGE_FOLDER:
                fragment = folderListFragment;
                break;
        }
        return fragment;
    }

    /*ViewPager与TabLayout绑定后，这里获取到PageTitle就是Tab的Text*/
    @Override
    public CharSequence getPageTitle(int position) {
        return mTitles[position];
    }


}
