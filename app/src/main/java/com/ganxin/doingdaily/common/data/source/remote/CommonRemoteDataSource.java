package com.ganxin.doingdaily.common.data.source.remote;

import android.support.annotation.NonNull;

import com.ganxin.doingdaily.common.data.source.callback.CommonDataSource;
import com.ganxin.doingdaily.common.network.NetworkManager;

import java.util.Map;

import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.schedulers.Schedulers;

/**
 * Description : 服务端数据源  <br/>
 * author : WangGanxin <br/>
 * date : 2017/7/14 <br/>
 * email : mail@wangganxin.me <br/>
 */
public class CommonRemoteDataSource implements CommonDataSource {
    private static CommonRemoteDataSource INSTANCE;

    private CommonRemoteDataSource() {

    }

    public static CommonRemoteDataSource getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new CommonRemoteDataSource();
        }
        return INSTANCE;
    }

    @Override
    public void getGankPictures(int pageIndex, @NonNull final GankPictureCallback callback) {

        NetworkManager.getGankAPI().getPictures(pageIndex).subscribeOn(Schedulers.newThread())//子线程访问网络
                .observeOn(AndroidSchedulers.mainThread())//回调到主线程
                .subscribe(new Action1<String>() {
                    @Override
                    public void call(String str) {
                        //callback.onLatestNewsLoaded(articleBean);
                    }
                }, new Action1<Throwable>() {
                    @Override
                    public void call(Throwable throwable) {
                        callback.onDataNotAvailable();
                    }
                });
    }

    @Override
    public void getShowPictures(Map<String, String> options, @NonNull final ShowPictureCallback callback) {
        NetworkManager.getShowAPI().getPictures(options).subscribeOn(Schedulers.newThread())//子线程访问网络
                .observeOn(AndroidSchedulers.mainThread())//回调到主线程
                .subscribe(new Action1<String>() {
                    @Override
                    public void call(String str) {
                        //callback.onLatestNewsLoaded(articleBean);
                    }
                }, new Action1<Throwable>() {
                    @Override
                    public void call(Throwable throwable) {
                        callback.onDataNotAvailable();
                    }
                });
    }

    @Override
    public void getVideos(@NonNull final GetVideoCallback callback) {

//        Map<String, String> options = new HashMap<>();
//        options.put("type", "41");
//        options.put("page", "1");
//
//        NetworkManager.getShowAPI().getVideos(options).subscribeOn(Schedulers.newThread())//子线程访问网络
//                .observeOn(AndroidSchedulers.mainThread())//回调到主线程
//                .subscribe(new Action1<String>() {
//                    @Override
//                    public void call(String str) {
//                        //callback.onLatestNewsLoaded(articleBean);
//                    }
//                }, new Action1<Throwable>() {
//                    @Override
//                    public void call(Throwable throwable) {
//                        callback.onDataNotAvailable();
//                    }
//                });
    }
}
