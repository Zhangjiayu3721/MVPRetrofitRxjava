package zjy.com.work1104.model;

import retrofit2.http.GET;
import rx.Observable;
import zjy.com.work1104.bean.MyBean;

/**
 * Created by ZhangJiaYu on 2017/11/4.
 */

public interface ApiService {

    @GET("type/1/p/1")
    Observable<MyBean> getbean();
}
