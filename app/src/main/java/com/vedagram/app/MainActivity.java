
package com.vedagram.app;

import android.app.Activity;
import android.os.Bundle;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.GradientDrawable;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {
    private final int bg = Color.rgb(16, 16, 32);
    private final int panel = Color.rgb(24, 24, 45);
    private final int purple = Color.rgb(124, 44, 255);
    private final int white = Color.rgb(245, 245, 255);
    private final int muted = Color.rgb(166, 166, 194);
    private LinearLayout content;
    private LinearLayout root;

    @Override public void onCreate(Bundle state) {
        super.onCreate(state);
        getWindow().setStatusBarColor(bg);
        getWindow().setNavigationBarColor(bg);
        showHome();
    }

    private GradientDrawable rounded(int color, int radiusDp) {
        GradientDrawable d = new GradientDrawable();
        d.setColor(color);
        d.setCornerRadius(radiusDp * getResources().getDisplayMetrics().density);
        return d;
    }

    private TextView text(String value, int size, int color, boolean bold) {
        TextView t = new TextView(this);
        t.setText(value);
        t.setTextSize(size);
        t.setTextColor(color);
        if (bold) t.setTypeface(Typeface.DEFAULT, Typeface.BOLD);
        return t;
    }

    private LinearLayout column() {
        LinearLayout l = new LinearLayout(this);
        l.setOrientation(LinearLayout.VERTICAL);
        return l;
    }

    private LinearLayout.LayoutParams lp(int width, int height) {
        return new LinearLayout.LayoutParams(width, height);
    }

    private void showHome() {
        root = column();
        root.setBackgroundColor(bg);
        root.setPadding(dp(20), dp(18), dp(20), dp(12));

        LinearLayout header = new LinearLayout(this);
        header.setGravity(Gravity.CENTER_VERTICAL);
        TextView logo = text("➤", 28, white, true);
        logo.setGravity(Gravity.CENTER);
        logo.setBackground(rounded(purple, 16));
        header.addView(logo, lp(dp(48), dp(48)));

        LinearLayout titleBox = column();
        titleBox.setPadding(dp(12), 0, 0, 0);
        titleBox.addView(text("Vedagram", 25, white, true));
        titleBox.addView(text("Больше, чем общение", 12, muted, false));
        header.addView(titleBox, new LinearLayout.LayoutParams(0, -2, 1));
        TextView search = text("⌕", 30, white, false);
        search.setGravity(Gravity.CENTER);
        header.addView(search, lp(dp(42), dp(48)));
        root.addView(header, lp(-1, -2));

        EditText searchBox = new EditText(this);
        searchBox.setSingleLine(true);
        searchBox.setTextColor(white);
        searchBox.setHintTextColor(muted);
        searchBox.setHint("Поиск чатов");
        searchBox.setPadding(dp(16), 0, dp(16), 0);
        searchBox.setBackground(rounded(panel, 18));
        LinearLayout.LayoutParams searchParams = lp(-1, dp(48));
        searchParams.topMargin = dp(22);
        root.addView(searchBox, searchParams);

        LinearLayout tabs = new LinearLayout(this);
        tabs.setPadding(0, dp(18), 0, dp(14));
        tabs.addView(tab("Все", true), new LinearLayout.LayoutParams(0, dp(38), 1));
        tabs.addView(tab("Личные", false), new LinearLayout.LayoutParams(0, dp(38), 1));
        tabs.addView(tab("Группы", false), new LinearLayout.LayoutParams(0, dp(38), 1));
        tabs.addView(tab("Каналы", false), new LinearLayout.LayoutParams(0, dp(38), 1));
        root.addView(tabs);

        ScrollView scroll = new ScrollView(this);
        content = column();
        addChat("И", "Избранное", "Сохранённые сообщения", "12:25", "", Color.rgb(70, 130, 245));
        addChat("С", "Семья", "Ани: До встречи! 👋", "11:50", "3", Color.rgb(70, 170, 220));
        addChat("V", "Vedagram Updates", "Добро пожаловать в Vedagram ✨", "Вчера", "", purple);
        addChat("Н", "Новости", "Новое обновление", "09:15", "", Color.rgb(245, 245, 255));
        addChat("К", "Фильмы и сериалы", "Рекомендуем сегодня 🎬", "08:20", "12", Color.rgb(80, 110, 160));
        addChat("Т", "Технологии", "Интересная статья", "Вчера", "5", Color.rgb(70, 170, 220));
        addChat("П", "Путешествия", "Фото", "Вчера", "", Color.rgb(90, 150, 210));
        addChat("М", "Музыка", "Новый трек 🎵", "Вчера", "", Color.rgb(235, 70, 160));
        scroll.addView(content);
        root.addView(scroll, new LinearLayout.LayoutParams(-1, 0, 1));

        LinearLayout nav = new LinearLayout(this);
        nav.setGravity(Gravity.CENTER);
        nav.setPadding(0, dp(10), 0, 0);
        nav.addView(navItem("Чаты", true), new LinearLayout.LayoutParams(0, dp(52), 1));
        nav.addView(navItem("Контакты", false), new LinearLayout.LayoutParams(0, dp(52), 1));
        nav.addView(navItem("Настройки", false), new LinearLayout.LayoutParams(0, dp(52), 1));
        root.addView(nav, lp(-1, dp(62)));
        setContentView(root);
    }

    private View tab(String label, boolean selected) {
        TextView t = text(label, 13, selected ? white : muted, selected);
        t.setGravity(Gravity.CENTER);
        if (selected) t.setBackground(rounded(purple, 14));
        return t;
    }

    private void addChat(String initial, String name, String message, String time, String unread, int color) {
        LinearLayout row = new LinearLayout(this);
        row.setGravity(Gravity.CENTER_VERTICAL);
        row.setPadding(dp(12), dp(12), dp(10), dp(12));
        row.setBackground(rounded(panel, 18));
        LinearLayout.LayoutParams rowParams = lp(-1, dp(78));
        rowParams.bottomMargin = dp(10);

        TextView avatar = text(initial, 20, white, true);
        avatar.setGravity(Gravity.CENTER);
        avatar.setBackground(rounded(color, 28));
        row.addView(avatar, lp(dp(48), dp(48)));

        LinearLayout info = column();
        info.setPadding(dp(12), 0, dp(4), 0);
        info.addView(text(name, 15, white, true));
        TextView msg = text(message, 12, muted, false);
        msg.setMaxLines(1);
        info.addView(msg);
        row.addView(info, new LinearLayout.LayoutParams(0, -2, 1));

        LinearLayout meta = column();
        meta.setGravity(Gravity.CENTER);
        meta.addView(text(time, 10, muted, false));
        if (!unread.isEmpty()) {
            TextView badge = text(unread, 10, white, true);
            badge.setGravity(Gravity.CENTER);
            badge.setBackground(rounded(purple, 12));
            LinearLayout.LayoutParams bp = lp(dp(22), dp(22));
            bp.topMargin = dp(5);
            meta.addView(badge, bp);
        }
        row.addView(meta, lp(dp(42), -2));
        row.setOnClickListener(v -> Toast.makeText(this,
            "Демонстрация интерфейса. Подключение Telegram добавим на следующем этапе.", Toast.LENGTH_LONG).show());
        content.addView(row, rowParams);
    }

    private View navItem(String label, boolean selected) {
        TextView t = text(label, 12, selected ? white : muted, selected);
        t.setGravity(Gravity.CENTER);
        t.setOnClickListener(v -> Toast.makeText(this, label + " — скоро", Toast.LENGTH_SHORT).show());
        return t;
    }

    private int dp(int value) {
        return (int)(value * getResources().getDisplayMetrics().density + 0.5f);
    }
}
