// Copyright 2023, Christopher Banes and the Tivi project contributors
// SPDX-License-Identifier: Apache-2.0

package app.tivi.util

import app.tivi.appinitializers.AppInitializer
import app.tivi.inject.ApplicationScope
import me.tatarka.inject.annotations.IntoSet
import me.tatarka.inject.annotations.Provides

actual interface LoggerPlatformComponent {
    @Provides
    @ApplicationScope
    fun provideLogger(): Logger = CompositeLogger(KermitLogger, CrashKIosLogger)

    @Provides
    @IntoSet
    fun provideCrashKiOSInitializer(): AppInitializer = IosCrashKiOSInitializer
}
