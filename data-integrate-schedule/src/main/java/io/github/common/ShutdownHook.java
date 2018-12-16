package io.github.common;

import com.netflix.discovery.DiscoveryManager;

public class ShutdownHook implements Runnable {
    public ShutdownHook() {
    }

    public void run() {  //重写Runnable中的run方法并在此销毁bean
        DiscoveryManager.getInstance().shutdownComponent();
    }
}
