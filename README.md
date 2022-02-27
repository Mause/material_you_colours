# material_you_colours

Should be fairly straightforward to use - example is below

```dart
import 'package:flutter/flutter.dart';
import 'package:material_you_colours/material_you_colours.dart'
    show getMaterialYouThemeData;

class MyApp extends StatelessWidget {
  const MyApp({Key? key}) : super(key: key);

  @override
  Widget build(BuildContext context) {
    return FutureBuilder(
        future: getMaterialYouThemeData(),
        builder: (BuildContext context, AsyncSnapshot<ThemeData?> theme) =>
            MaterialApp(
              title: 'My App',
              theme: theme.data ?? ThemeData.fallback(),
              home: const MyHomePage(title: 'My App'),
            ));
  }
}
```
