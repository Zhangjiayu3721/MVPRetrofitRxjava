package zjy.com.work1104.model;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.Observable;
import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;
import zjy.com.work1104.bean.MyBean;
import zjy.com.work1104.presenter.Api;

/**
 * Created by ZhangJiaYu on 2017/11/5.
 */

public class Model implements IModel{

    List<MyBean.DataBean> list;
    OnFinish onFinish;

    public interface OnFinish{
        void OnFinishListener(List<MyBean.DataBean> list);
    }

    public void setOnFinish(OnFinish onFinish){
        this.onFinish = onFinish;
    }

    @Override
    public void getUrl(String url) {
        list = new ArrayList<>();
        Retrofit retrofit = new Retrofit.Builder().baseUrl(Api.URL).addConverterFactory(GsonConverterFactory.create()).addCallAdapterFactory(RxJavaCallAdapterFactory.create()).build();
        ApiService apiService = retrofit.create(ApiService.class);
        Observable<MyBean> bean = apiService.getbean();
        bean.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<MyBean>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(MyBean myBean) {
                        List<MyBean.DataBean> data = myBean.getData();
                        onFinish.OnFinishListener(data);
                    }
                });
    }
}
