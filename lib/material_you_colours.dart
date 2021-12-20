import 'dart:async' show Future;

import 'package:flutter/foundation.dart'
    show TargetPlatform, defaultTargetPlatform;
import 'package:flutter/material.dart'
    show
        BottomNavigationBarThemeData,
        ButtonStyle,
        CheckboxThemeData,
        Color,
        Colors,
        ElevatedButtonThemeData,
        FloatingActionButtonThemeData,
        IconThemeData,
        MaterialColor,
        MaterialStateProperty,
        TargetPlatform,
        ThemeData;
import 'package:flutter/services.dart' show MethodChannel, PlatformException;

class MaterialYouColours {
  static const MethodChannel _channel = MethodChannel('material_you_colours');

  static Future<Map<Object?, Object?>?> getMaterialYouColours() async {
    return await _channel.invokeMethod('getMaterialYouColours');
  }
}

Future<MaterialYouPalette?> getMaterialYouColours() async {
  // Material You colors are available on Android only
  if (defaultTargetPlatform != TargetPlatform.android) return null;

  try {
    final datam = await MaterialYouColours.getMaterialYouColours();
    if (datam == null) return null;
    var data = datam.map((key, value) => MapEntry(key as String, value as String));

    return MaterialYouPalette(
      accent1: data.getAccent1(),
      accent2: data.getAccent2(),
      accent3: data.getAccent3(),
      neutral1: data.getNeutral1(),
      neutral2: data.getNeutral2(),
    );
  } on PlatformException catch (_) {
    return null;
  }
}

class MaterialYouPalette {
  final MaterialColor accent1;
  final MaterialColor accent2;
  final MaterialColor accent3;
  final MaterialColor neutral1;
  final MaterialColor neutral2;

  MaterialYouPalette({
    required this.accent1,
    required this.accent2,
    required this.accent3,
    required this.neutral1,
    required this.neutral2,
  });
}

int _parseHexString(String value) =>
    int.parse(value.substring(3, 9), radix: 16) + 0xFF000000;

extension _ColorExtractionExtension on Map<String, dynamic> {
  Color getColor(String colorName) {
    final value = this[colorName];
    final parsed = _parseHexString(value);
    return Color(parsed);
  }

  MaterialColor getColours(String prefix) {
    return MaterialColor(
      _parseHexString(this['${prefix}_100']),
      <int, Color>{
        50: getColor('${prefix}_50'),
        100: getColor('${prefix}_100'),
        200: getColor('${prefix}_200'),
        300: getColor('${prefix}_300'),
        400: getColor('${prefix}_400'),
        500: getColor('${prefix}_500'),
        600: getColor('${prefix}_600'),
        700: getColor('${prefix}_700'),
        800: getColor('${prefix}_800'),
        900: getColor('${prefix}_900'),
      },
    );
  }

  MaterialColor getAccent1() {
    return getColours('system_accent1');
  }

  MaterialColor getAccent2() {
    return getColours('system_accent2');
  }

  MaterialColor getAccent3() {
    return getColours('system_accent3');
  }

  MaterialColor getNeutral1() {
    return getColours('system_neutral1');
  }

  MaterialColor getNeutral2() {
    return getColours('system_neutral2');
  }
}

Future<ThemeData> getMaterialYouThemeData() async {
  var data = await getMaterialYouColours();
  final primarySwatch = data?.accent1 ?? Colors.blue;
  final accent2Swatch = data?.accent2 ?? Colors.blue;
  final accent3Swatch = data?.accent3 ?? Colors.blue;
  return ThemeData(
    primarySwatch: primarySwatch,
    checkboxTheme: CheckboxThemeData(
      fillColor: MaterialStateProperty.resolveWith((states) => accent2Swatch),
    ),
    elevatedButtonTheme: ElevatedButtonThemeData(
      style: ButtonStyle(
        backgroundColor:
            MaterialStateProperty.resolveWith((states) => accent3Swatch),
      ),
    ),
    floatingActionButtonTheme: FloatingActionButtonThemeData(
      backgroundColor: accent3Swatch.shade300,
    ),
    bottomNavigationBarTheme: BottomNavigationBarThemeData(
      backgroundColor: accent2Swatch.shade100,
      selectedIconTheme: IconThemeData(
        color: accent2Swatch.shade900,
      ),
      unselectedIconTheme: IconThemeData(
        color: accent2Swatch.shade300,
      ),
      selectedItemColor: Colors.black,
      unselectedItemColor: Colors.black,
    ),
  );
}
