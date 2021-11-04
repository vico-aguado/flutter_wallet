package com.vicoaguado.flutter_wallet;

import io.flutter.plugin.common.MethodCall;
import io.flutter.plugin.common.MethodChannel;
import io.flutter.plugin.common.MethodChannel.MethodCallHandler;
import io.flutter.plugin.common.MethodChannel.Result;
import io.flutter.plugin.common.PluginRegistry.Registrar;
import io.flutter.embedding.engine.plugins.FlutterPlugin;


/** FlutterWalletPlugin */
public class FlutterWalletPlugin implements MethodCallHandler, FlutterPlugin {
  /** Plugin registration. */
  public static void registerWith(Registrar registrar) {
    FlutterWalletPlugin instance = new FlutterWalletPlugin();
    instance.onAttachedToEngine(registrar.messenger());
  }

  @Override
  public void onAttachedToEngine(FlutterPluginBinding binding) {
    onAttachedToEngine(binding.getBinaryMessenger());
  }

  private void onAttachedToEngine(BinaryMessenger messenger) {
    final MethodChannel channel = new MethodChannel(messenger, "flutter_wallet");
    channel.setMethodCallHandler(this);
  }

  @Override
  public void onMethodCall(MethodCall call, Result result) {
    if (call.method.equals("getPlatformVersion")) {
      result.success("Android " + android.os.Build.VERSION.RELEASE);
    } else {
      result.notImplemented();
    }
  }
}
