package com.riguz.encryptions;

import com.riguz.encryptions.invoker.AESCall;
import com.riguz.encryptions.invoker.Argon2Call;

import io.flutter.embedding.engine.plugins.FlutterPlugin;
import io.flutter.plugin.common.MethodChannel;

public class EncryptionsPlugin implements FlutterPlugin {
    private MethodChannel channel;
    private static final FlutterCallExecutor executor = new FlutterCallExecutor();

    static {
        executor.register(AESCall.class);
        executor.register(Argon2Call.class);
    }

    @Override
    public void onAttachedToEngine(FlutterPluginBinding binding) {
        channel = new MethodChannel(binding.getBinaryMessenger(), "encryptions");
        channel.setMethodCallHandler(executor);
    }

    @Override
    public void onDetachedFromEngine(FlutterPluginBinding binding) {
        channel.setMethodCallHandler(null);
    }
}
