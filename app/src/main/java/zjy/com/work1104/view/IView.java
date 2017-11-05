package zjy.com.work1104.view;

import java.util.List;

import zjy.com.work1104.bean.MyBean;

/**
 * Created by ZhangJiaYu on 2017/11/5.
 */

public interface IView {
    void getData(List<MyBean.DataBean> list);
}
