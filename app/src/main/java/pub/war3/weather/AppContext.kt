package pub.war3.weather

import android.app.Application

/**
 * Created by turbo on 2017/6/15.
 */
class AppContext : Application() {

    override fun onCreate() {
        super.onCreate()
        instance = this
    }

    companion object {
        var instance: AppContext? = null
            private set
    }
}
