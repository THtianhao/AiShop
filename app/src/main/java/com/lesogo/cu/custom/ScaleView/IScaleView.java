
package com.lesogo.cu.custom.ScaleView;

import android.graphics.RectF;
import android.view.View;
import android.widget.ImageView;

public interface IScaleView {

	boolean canZoom();


	RectF getDisplayRect();


	float getMinScale();


	float getMidScale();


	float getMaxScale();


	float getScale();


	ImageView.ScaleType getScaleType();


	void setAllowParentInterceptOnEdge(boolean allow);


	void setMinScale(float minScale);


	void setMidScale(float midScale);


	void setMaxScale(float maxScale);


	void setOnLongClickListener(View.OnLongClickListener listener);


	void setOnMatrixChangeListener(ScaleViewAttacher.OnMatrixChangedListener listener);


	void setOnScaleTapListener(ScaleViewAttacher.OnScaleTapListener listener);


	void setOnViewTapListener(ScaleViewAttacher.OnViewTapListener listener);


	void setScaleType(ImageView.ScaleType scaleType);


	void setZoomable(boolean zoomable);


	void zoomTo(float scale, float focalX, float focalY);
}
