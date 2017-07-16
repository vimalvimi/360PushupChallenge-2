package com.example.batman.a360pushupchallenge.widget;

import android.app.PendingIntent;
import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.Context;
import android.content.Intent;
import android.widget.RemoteViews;

import com.example.batman.a360pushupchallenge.R;
import com.example.batman.a360pushupchallenge.helper.PushupList;
import com.example.batman.a360pushupchallenge.ui.CounterActivity;


public class PushupQuickWidget extends AppWidgetProvider {

    static void updateAppWidget(Context context, AppWidgetManager appWidgetManager,
                                int appWidgetId) {

        CharSequence widgetText = PushupQuickWidgetConfigureActivity.loadTitlePref(context, appWidgetId);

        // Construct the RemoteViews object
        RemoteViews views = new RemoteViews(context.getPackageName(), R.layout.pushup_quick_widget);
        views.setTextViewText(R.id.appwidget_text, widgetText);

        PushupList pushupList = new PushupList();
        String lastUriPath = pushupList.matchName(widgetText.toString());

        Intent intent = new Intent(context, CounterActivity.class);
        intent.putExtra(context.getString(R.string.extra_last_path), lastUriPath);

        PendingIntent pendingIntent = PendingIntent
                .getActivity(context, appWidgetId, intent,PendingIntent.FLAG_UPDATE_CURRENT);
        views.setOnClickPendingIntent(R.id.widget_layout, pendingIntent);

        // Instruct the widget manager to update the widget
        appWidgetManager.updateAppWidget(appWidgetId, views);
    }

    @Override
    public void onUpdate(Context context, AppWidgetManager appWidgetManager, int[] appWidgetIds) {
        // There may be multiple widgets active, so update all of them
        for (int appWidgetId : appWidgetIds) {
            updateAppWidget(context, appWidgetManager, appWidgetId);
        }
    }

    @Override
    public void onDeleted(Context context, int[] appWidgetIds) {
        // When the user deletes the widget, delete the preference associated with it.
        for (int appWidgetId : appWidgetIds) {
            PushupQuickWidgetConfigureActivity.deleteTitlePref(context, appWidgetId);
        }
    }

    @Override
    public void onEnabled(Context context) {
        // Enter relevant functionality for when the first widget is created
    }

    @Override
    public void onDisabled(Context context) {
        // Enter relevant functionality for when the last widget is disabled
    }
}

