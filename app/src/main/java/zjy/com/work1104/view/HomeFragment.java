package zjy.com.work1104.view;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import zjy.com.work1104.R;
import zjy.com.work1104.adapter.MyAdapter;
import zjy.com.work1104.bean.MyBean;
import zjy.com.work1104.presenter.Api;
import zjy.com.work1104.presenter.IPresenter;

/**
 * Created by ZhangJiaYu on 2017/11/4.
 */
public class HomeFragment extends Fragment implements IView{

    private RecyclerView recyclerView;
    private IPresenter iPresenter;
    private List<MyBean.DataBean> data;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = View.inflate(getActivity(), R.layout.fragment_home,null);
        recyclerView = (RecyclerView) view.findViewById(R.id.recyclerview);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        IPresenter iPresenter = new IPresenter(this);
        iPresenter.getUri(Api.URL);
        //initData();
        return view;
    }

//    private void initData() {
//        Retrofit retrofit = new Retrofit.Builder().addConverterFactory(GsonConverterFactory.create()).addCallAdapterFactory(RxJavaCallAdapterFactory.create()).build();
//        ApiService apiService = retrofit.create(ApiService.class);
//        Observable<MyBean> bean = apiService.getbean();
//        bean.subscribeOn(Schedulers.io())
//                .observeOn(AndroidSchedulers.mainThread())
//                .subscribe(new Observer<MyBean>() {
//                    @Override
//                    public void onCompleted() {
//
//                    }
//
//                    @Override
//                    public void onError(Throwable e) {
//
//                    }
//
//                    @Override
//                    public void onNext(MyBean myBean) {
//                        data = myBean.getData();
//                        recyclerView.setAdapter(new MyAdapter(data,getActivity()));
//                    }
//                });
//    }

    @Override
    public void getData(List<MyBean.DataBean> list) {
        recyclerView.setAdapter(new MyAdapter(list,getActivity()));
    }
}
