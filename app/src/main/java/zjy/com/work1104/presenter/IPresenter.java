package zjy.com.work1104.presenter;

import java.util.List;

import zjy.com.work1104.bean.MyBean;
import zjy.com.work1104.model.Model;
import zjy.com.work1104.view.IView;

/**
 * Created by ZhangJiaYu on 2017/11/5.
 */

public class IPresenter implements Model.OnFinish{

    IView iView;
    Model model;

    public IPresenter(IView iView) {
        this.iView = iView;
        this.model = new Model();
        model.setOnFinish(this);
    }

    public void getUri(String url){
        model.getUrl(url);
    }

    @Override
    public void OnFinishListener(List<MyBean.DataBean> list) {
        iView.getData(list);
    }
}
