package king.cn.kingtuan.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by rebitco on 2017/9/14.
 */

public class ViewPagerIndicator extends View {

    private Paint mFrontPaint;
    private Paint mBelowPaint;

    public ViewPagerIndicator(Context context) {
        super(context);
        initPaint();
    }

    public ViewPagerIndicator(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        initPaint();
    }

    private void initPaint() {
        mFrontPaint = new Paint();
        mFrontPaint.setAntiAlias(true);
        mFrontPaint.setColor(Color.YELLOW);

        mBelowPaint = new Paint();
        mBelowPaint.setAntiAlias(true);
        mBelowPaint.setColor(Color.GRAY);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        for(int i = 0; i < 3; i++) {
            canvas.drawCircle(60 + i * 15 * 3,60,15, mBelowPaint);
        }
        canvas.drawCircle(60,60,15,mFrontPaint);
    }
}