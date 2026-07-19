package com.example.pocketbro.data.repository

import android.app.usage.UsageStatsManager
import android.content.Context
import com.example.pocketbro.domain.repository.TimeScreenRepository
import dagger.hilt.android.qualifiers.ApplicationContext
import java.time.LocalDate
import java.time.ZoneId
import java.time.ZonedDateTime
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class TimeScreenRepositoryImpl @Inject constructor(
    @ApplicationContext private val context: Context
): TimeScreenRepository {
    override fun getTimeScreen() : Double {
        val usageStatsManager = context.getSystemService(Context.USAGE_STATS_SERVICE) as UsageStatsManager

        val startTime = ZonedDateTime.of(
            LocalDate.now().atStartOfDay(),
            ZoneId.systemDefault()
        ).toInstant().toEpochMilli()

        val endTime = System.currentTimeMillis()

        val usageStats = usageStatsManager.queryUsageStats(
            UsageStatsManager.INTERVAL_DAILY,
            startTime,
            endTime
        )
        if (usageStats == null || usageStats.isEmpty()){
            return -1.0
        }

        val totalTimeInMillis = usageStats.sumOf { it.totalTimeInForeground }
        return totalTimeInMillis / (1000.0 * 60.0 * 60.0)
    }
}