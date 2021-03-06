package com.stone.stonemusic.ui.fragment;

import android.content.Context;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bumptech.glide.Glide;
import com.stone.stonemusic.R;
import com.stone.stonemusic.bean.ItemViewChoose;
import com.stone.stonemusic.bean.Music;
import com.stone.stonemusic.model.SongModel;
import com.stone.stonemusic.ui.View.CircleImageView;
import com.stone.stonemusic.ui.activity.LocalListActivity;
import com.stone.stonemusic.ui.activity.PlayActivity;
import com.stone.stonemusic.utils.MediaUtils;
import com.stone.stonemusic.utils.MusicAppUtils;
import com.stone.stonemusic.utils.MusicUtil;

import java.util.ArrayList;
import java.util.List;

public class PlayImageFragment extends Fragment implements PlayActivity.CallPlaysFragment{
    public static final String TAG = "PlayImageFragment";
    private CircleImageView CIVAlbum;
    private List<Music> musicList = new ArrayList<>();
    private PlayActivity.CallPlaysFragment mCallLocalFragment = new PlayActivity.CallPlaysFragment() {
        @Override
        public void ChangeUI() {
            Log.d(TAG, "这里是Fragment的ChangeUI()，这里被回调了");
            PlayImageFragmentHandler.sendEmptyMessage(1);
        }
    };
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        ((PlayActivity)context).setCallPlaysFragment(mCallLocalFragment);
    }

    @Override
    public void ChangeUI() {}
    public PlayImageFragment() {}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_play_image, container, false);

        init(view);

        return view;
    }

    private void init(View view) {
        musicList = SongModel.getInstance().getSongList();
        CIVAlbum = (CircleImageView) view.findViewById(R.id.play_music_album_image);
        initView();
    }
    private void initView(){
        /*设置专辑图*/
        int position = MediaUtils.currentSongPosition;
        String path = MusicUtil.getAlbumArt(new Long(musicList.get(position).getAlbum_id()).intValue());
        if (null == path){
            CIVAlbum.setImageResource(R.drawable.play_background02);
        }else{
            CIVAlbum.setImageBitmap(BitmapFactory.decodeFile(path));
        }
    }

    private Handler PlayImageFragmentHandler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            Log.d(TAG, "Handler 收到位置更新的通知");
            initView();
        }
    };
}
