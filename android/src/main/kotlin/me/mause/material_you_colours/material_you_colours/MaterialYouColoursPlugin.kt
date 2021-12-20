package me.mause.material_you_colours.material_you_colours

import android.content.Context
import androidx.annotation.NonNull

import io.flutter.embedding.engine.plugins.FlutterPlugin
import io.flutter.plugin.common.MethodCall
import io.flutter.plugin.common.MethodChannel
import io.flutter.plugin.common.MethodChannel.MethodCallHandler
import io.flutter.plugin.common.MethodChannel.Result
import android.os.Build
import androidx.core.content.res.ResourcesCompat
import java.util.logging.Logger

/** MaterialYouColoursPlugin */
class MaterialYouColoursPlugin: FlutterPlugin, MethodCallHandler {
  private var appContext: Context? = null
  private val logger = Logger.getLogger("MaterialYouColoursPlugin")

  /// The MethodChannel that will the communication between Flutter and native Android
  ///
  /// This local reference serves to register the plugin with the Flutter Engine and unregister it
  /// when the Flutter Engine is detached from the Activity
  private lateinit var channel : MethodChannel

  override fun onAttachedToEngine(@NonNull flutterPluginBinding: FlutterPlugin.FlutterPluginBinding) {
    channel = MethodChannel(flutterPluginBinding.binaryMessenger, "material_you_colours")
    channel.setMethodCallHandler(this)
    appContext = flutterPluginBinding.applicationContext
  }

  override fun onMethodCall(@NonNull call: MethodCall, @NonNull result: Result) {
    if (call.method == "getMaterialYouColours") {
      result.success(getMaterialYouColours())
    } else {
      result.notImplemented()
    }
  }

  override fun onDetachedFromEngine(@NonNull binding: FlutterPlugin.FlutterPluginBinding) {
    channel.setMethodCallHandler(null)
    appContext = null
  }

  private fun getMaterialYouColours(): Map<String, String>? {
    if (Build.VERSION.SDK_INT < Build.VERSION_CODES.S) {
      return null
    }

    return mapOf(
            "system_accent1_0" to android.R.color.system_accent1_0,
            "system_accent1_10" to android.R.color.system_accent1_10,
            "system_accent1_50" to android.R.color.system_accent1_50,
            "system_accent1_100" to android.R.color.system_accent1_100,
            "system_accent1_200" to android.R.color.system_accent1_200,
            "system_accent1_300" to android.R.color.system_accent1_300,
            "system_accent1_400" to android.R.color.system_accent1_400,
            "system_accent1_500" to android.R.color.system_accent1_500,
            "system_accent1_600" to android.R.color.system_accent1_600,
            "system_accent1_700" to android.R.color.system_accent1_700,
            "system_accent1_800" to android.R.color.system_accent1_800,
            "system_accent1_900" to android.R.color.system_accent1_900,
            "system_accent1_1000" to android.R.color.system_accent1_1000,

            "system_accent2_0" to android.R.color.system_accent2_0,
            "system_accent2_10" to android.R.color.system_accent2_10,
            "system_accent2_50" to android.R.color.system_accent2_50,
            "system_accent2_100" to android.R.color.system_accent2_100,
            "system_accent2_200" to android.R.color.system_accent2_200,
            "system_accent2_300" to android.R.color.system_accent2_300,
            "system_accent2_400" to android.R.color.system_accent2_400,
            "system_accent2_500" to android.R.color.system_accent2_500,
            "system_accent2_600" to android.R.color.system_accent2_600,
            "system_accent2_700" to android.R.color.system_accent2_700,
            "system_accent2_800" to android.R.color.system_accent2_800,
            "system_accent2_900" to android.R.color.system_accent2_900,
            "system_accent2_1000" to android.R.color.system_accent2_1000,

            "system_accent3_0" to android.R.color.system_accent3_0,
            "system_accent3_10" to android.R.color.system_accent3_10,
            "system_accent3_50" to android.R.color.system_accent3_50,
            "system_accent3_100" to android.R.color.system_accent3_100,
            "system_accent3_200" to android.R.color.system_accent3_200,
            "system_accent3_300" to android.R.color.system_accent3_300,
            "system_accent3_400" to android.R.color.system_accent3_400,
            "system_accent3_500" to android.R.color.system_accent3_500,
            "system_accent3_600" to android.R.color.system_accent3_600,
            "system_accent3_700" to android.R.color.system_accent3_700,
            "system_accent3_800" to android.R.color.system_accent3_800,
            "system_accent3_900" to android.R.color.system_accent3_900,
            "system_accent3_1000" to android.R.color.system_accent3_1000,

            "system_neutral1_0" to android.R.color.system_neutral1_0,
            "system_neutral1_10" to android.R.color.system_neutral1_10,
            "system_neutral1_50" to android.R.color.system_neutral1_50,
            "system_neutral1_100" to android.R.color.system_neutral1_100,
            "system_neutral1_200" to android.R.color.system_neutral1_200,
            "system_neutral1_300" to android.R.color.system_neutral1_300,
            "system_neutral1_400" to android.R.color.system_neutral1_400,
            "system_neutral1_500" to android.R.color.system_neutral1_500,
            "system_neutral1_600" to android.R.color.system_neutral1_600,
            "system_neutral1_700" to android.R.color.system_neutral1_700,
            "system_neutral1_800" to android.R.color.system_neutral1_800,
            "system_neutral1_900" to android.R.color.system_neutral1_900,
            "system_neutral1_1000" to android.R.color.system_neutral1_1000,

            "system_neutral2_0" to android.R.color.system_neutral2_0,
            "system_neutral2_10" to android.R.color.system_neutral2_10,
            "system_neutral2_50" to android.R.color.system_neutral2_50,
            "system_neutral2_100" to android.R.color.system_neutral2_100,
            "system_neutral2_200" to android.R.color.system_neutral2_200,
            "system_neutral2_300" to android.R.color.system_neutral2_300,
            "system_neutral2_400" to android.R.color.system_neutral2_400,
            "system_neutral2_500" to android.R.color.system_neutral2_500,
            "system_neutral2_600" to android.R.color.system_neutral2_600,
            "system_neutral2_700" to android.R.color.system_neutral2_700,
            "system_neutral2_800" to android.R.color.system_neutral2_800,
            "system_neutral2_900" to android.R.color.system_neutral2_900,
            "system_neutral2_1000" to android.R.color.system_neutral2_1000
    )
            .map { (name, id) ->
              logger.info("name: $name");
              val color = ResourcesCompat.getColor(appContext!!.resources, id, appContext!!.theme)
              val colorHex = Integer.toHexString(color)
              logger.info("colorhex: $colorHex");
              return mapOf(name to colorHex)
            }
            .toMap()
  }
}
