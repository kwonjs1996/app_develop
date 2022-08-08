package com.example.drawingapp

import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.util.TypedValue
import android.view.MotionEvent
import android.view.View
import androidx.constraintlayout.motion.widget.MotionHelper
// View 클래스를 상속받는 DrawingView 커스텀 클래스를 만든다.
// View 클래스를 상속받았기 때문에 관련 메소드를 모두 사용 할 수 있다.
class DrawingView(context: Context, attrs: AttributeSet) : View(context, attrs) {
// 변수 선언
    private var mDrawPath: CustomPath? = null
    private var mCanvasBitmap : Bitmap? = null
    private var mDrawPaint : Paint? = null
    private var mCanvasPaint : Paint? = null
    private var mBrushSize : Float? = 0.toFloat()
    private var color = Color.BLACK
    private var canvas : Canvas? = null
    // ArrayList 안에 추가해서 그려 놓은 상태를 유지시키기 위해 변수를 설정한다. val 로 선언하는 이유는 ArrayList 안에
    // 데이터는 바뀔 수 있지만 ArrayList 형식 자체가 바뀌지 않기 때문에
    private val mPaths = ArrayList<CustomPath>()
    private val mUndoPath = ArrayList<CustomPath>()

    // 이니셜라이즈 DrawingView 인스턴스가 생성 될 때 초기화되는 값
    init {
        setUpDrawing()
    }

    fun onClickUndo(){
        if (mPaths.size > 0){
            mUndoPath.add(mPaths.removeAt(mPaths.size - 1))
            //View클래스에 정의된 Invalidate() 메서드를 호출하면,
            //해당 뷰 화면이 무효(invalid)임을 안드로이드에게 알리게 되고,
            //안드로이드는 현재의 뷰 상태를 반영하여 새로 화면을 그려준다.
            //View를 상속 받는 커스텀 뷰 클래스를 생성한 다음,
            //커스텀뷰를 다시 그려야 할 때마다 Invalidate() 메서드를 호출하도록 구현해주면 된다.
            invalidate()
        }
    }
    fun onClickRedo(){
        if (mUndoPath.size > 0){
            mPaths.add(mUndoPath.removeAt(mUndoPath.size - 1))
            invalidate()
        }
    }

    private fun setUpDrawing(){
        mDrawPaint = Paint()
        mDrawPath = CustomPath(color, mBrushSize)
        mDrawPaint!!.color = color
        mDrawPaint!!.style = Paint.Style.STROKE
        mDrawPaint!!.strokeJoin = Paint.Join.ROUND
        mDrawPaint!!.strokeCap = Paint.Cap.ROUND
        mCanvasPaint = Paint(Paint.DITHER_FLAG)
//        mBrushSize = 20.toFloat()

    }

    override fun onSizeChanged(w: Int, h: Int, oldw: Int, oldh: Int) {
        super.onSizeChanged(w, h, oldw, oldh)
        mCanvasBitmap = Bitmap.createBitmap(w, h, Bitmap.Config.ARGB_8888)
        canvas = Canvas(mCanvasBitmap!!)
    }
    // Change Canvas to Canvas? if fails
    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        canvas.drawBitmap(mCanvasBitmap!!, 0f, 0f, mCanvasPaint)

        // 배열(mPath) 안에 있는 것들을 for 문을 이용하여 비트맵 이미지로 스크린에 나타낸다
        for (path in mPaths){
            mDrawPaint!!.strokeWidth = path.brushThickness!!
            mDrawPaint!!.color = path.color
            canvas.drawPath(path, mDrawPaint!!)
        }

        if(!mDrawPath!!.isEmpty){
            mDrawPaint!!.strokeWidth = mDrawPath!!.brushThickness!!
            mDrawPaint!!.color = mDrawPath!!.color
            canvas.drawPath(mDrawPath!!, mDrawPaint!!)
        }
    }

    override fun onTouchEvent(event: MotionEvent?): Boolean {
        val touchX = event?.x
        val touchY = event?.y

        when(event?.action){
            MotionEvent.ACTION_DOWN -> {
                mDrawPath!!.color = color
                mDrawPath!!.brushThickness = mBrushSize

                mDrawPath!!.reset()
                if (touchX != null) {
                    if (touchY != null) {
                        mDrawPath!!.moveTo(touchX, touchY)
                    }
                }
            }
            MotionEvent.ACTION_MOVE -> {
                if (touchX != null) {
                    if (touchY != null) {
                        mDrawPath!!.lineTo(touchX,touchY)
                    }
                }
            }
            //
            MotionEvent.ACTION_UP -> {
                // 스크린에서 손을 뗄 때 그 값을 배열(mPath)에 추가하기.
                mPaths.add(mDrawPath!!)
                mDrawPath = CustomPath(color, mBrushSize)
            }
            else -> return false

        }
        invalidate()


        return true
    }

    fun setSizeForBrush(newSize : Float){
        mBrushSize = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP,
            newSize, resources.displayMetrics
            )
        mDrawPaint!!.strokeWidth = mBrushSize!!
    }

    fun setColor(newColor: String){
        color = Color.parseColor(newColor)
        mDrawPaint!!.color = color
    }

    // An inner class for custom path with two params as color and stroke size.
    internal inner class CustomPath(var color: Int, var brushThickness: Float?) : Path() {

    }


}