package state.state_manager;

import state.IState;

public interface IStateManager {
	public void setCircleState();
	public void setRectangleState();
	public void setTriangleState();
	public void setSelectState();
	public void setRotateAndScaleState();
	public void setDragAndDropState();
	public void setDeleteState();
	public IState getCurrentState();
}
