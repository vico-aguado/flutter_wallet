import 'dart:async';

import 'package:flutter/services.dart';
import 'package:meta/meta.dart';

class FlutterWallet {
  static const MethodChannel _channel =
      const MethodChannel('com.vico-aguado.flutter/wallet');

  static Future<bool> addPass({@required List<int> pkpass}) async {
    final bool result = await _channel.invokeMethod('addWalletPass', <String, dynamic>{'pkpass' : pkpass});
    return result;
  }
}
