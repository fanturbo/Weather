package pub.war3.weather.api

import rx.Observable
import rx.android.schedulers.AndroidSchedulers
import rx.schedulers.Schedulers

/**
 * 通用的Rx线程转换类
 * 参考:http://www.jcodecraeer.com/a/anzhuokaifa/androidkaifa/2015/0819/3327.html
 */
object RxSchedulers {

    private val schedulersTransformer = object : Observable.Transformer<Any, Any> {
        override fun call(t: Observable<Any>?): Observable<Any> {
            return (t as Observable<Any>).subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
        }
    }

    fun <T> applySchedulers(): Observable.Transformer<T, T> {
        return schedulersTransformer as Observable.Transformer<T, T>
    }
}
