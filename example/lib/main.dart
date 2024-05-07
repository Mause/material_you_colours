import 'dart:async';

import 'package:flutter/material.dart';
import 'package:material_you_colours/material_you_colours.dart'
    show getMaterialYouThemeData;

void main() {
  runApp(const MyApp());
}

class MyApp extends StatefulWidget {
  const MyApp({super.key});

  @override
  State<MyApp> createState() => _MyAppState();
}

class _MyAppState extends State<MyApp> {
  ThemeData? materialYouThemeData;

  @override
  void initState() {
    super.initState();
    initPlatformState();
  }

  // Platform messages are asynchronous, so we initialize in an async method.
  Future<void> initPlatformState() async {
    var materialYouThemeData = await getMaterialYouThemeData();

    // If the widget was removed from the tree while the asynchronous platform
    // message was in flight, we want to discard the reply rather than calling
    // setState to update our non-existent appearance.
    if (!mounted) return;

    setState(() {
      this.materialYouThemeData = materialYouThemeData;
    });
  }

  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      theme: materialYouThemeData,
      home: Scaffold(
        appBar: AppBar(
          title: const Text('Plugin example app'),
        ),
        body: Center(
          child: Text('Running on: $materialYouThemeData\n'),
        ),
      ),
    );
  }
}
