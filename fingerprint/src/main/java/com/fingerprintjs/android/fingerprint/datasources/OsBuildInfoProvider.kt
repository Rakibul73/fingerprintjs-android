package com.fingerprintjs.android.fingerprint.datasources


import android.os.Build
import com.fingerprintjs.android.fingerprint.tools.executeSafe


interface OsBuildInfoProvider {
    fun modelName(): String
    fun manufacturerName(): String
    fun androidVersion(): String
    fun sdkVersion(): String
    fun kernelVersion(): String
    fun fingerprint(): String
}

class OsBuildInfoProviderImpl : OsBuildInfoProvider {
    override fun modelName(): String {
        return executeSafe({ Build.MODEL }, "")
    }

    override fun manufacturerName(): String {
        return executeSafe({ Build.MANUFACTURER }, "")
    }

    override fun androidVersion(): String {
        return executeSafe({ Build.VERSION.RELEASE }, "")
    }

    override fun sdkVersion(): String {
        return executeSafe({ Build.VERSION.SDK_INT.toString() }, "")
    }

    override fun kernelVersion(): String {
        return executeSafe({ System.getProperty("os.version") ?: "" }, "")
    }

    override fun fingerprint(): String {
        return executeSafe({ Build.FINGERPRINT }, "")
    }
}