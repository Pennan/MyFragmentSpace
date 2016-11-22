package com.np.daggerdemo.module;

import com.np.daggerdemo.Level;
import com.np.daggerdemo.entity.Coder;

import dagger.Module;
import dagger.Provides;

/**
 * <B>Des</B>
 *
 * @author ningpan 2016/11/21 16:10
 */
@Module
public class AppModule {
    @Provides
    @Level("low")
    Coder provideLowLevelCoder() {
        Coder coder = new Coder();
        coder.setName("菜的掉渣");
        coder.setPower("5");
        return coder;
    }

    @Provides
    @Level("high")
    Coder providerHighLevelCoder() {
        Coder coder = new Coder();
        coder.setName("大神");
        coder.setPower("1000");
        return coder;
    }
}
