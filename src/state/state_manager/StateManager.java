package state.state_manager;

import state.CircleState;
import state.DeleteState;
import state.DragAndDropState;
import state.IState;
import state.RectangleState;
import state.RotateAndScaleState;
import state.SelectState;
import state.TriangleState;

public class StateManager implements IStateManager {
	private IState currentState;
	private CircleState circleState;
	private RectangleState rectangleState;
	private TriangleState triangleState;
	private SelectState selectState;
	private RotateAndScaleState rotateAndScaleState;
	private DragAndDropState dragAndDropState;
	private DeleteState deleteState;
	public StateManager() {
		circleState = new CircleState();
		rectangleState = new RectangleState();
		triangleState = new TriangleState();
		selectState = new SelectState();
		rotateAndScaleState = new RotateAndScaleState();
		dragAndDropState = new DragAndDropState();
		deleteState = new DeleteState();
		currentState = selectState;
	}
	public void setCircleState() {
		this.currentState = circleState;
	}
	public void setRectangleState() {
		this.currentState = rectangleState;
	}
	public void setTriangleState() {
		this.currentState = triangleState;
	}
	public void setSelectState() {
		this.currentState = selectState;
	}
	public void setRotateAndScaleState() {
		this.currentState = rotateAndScaleState;
	}
	public void setDragAndDropState() {
		this.currentState = dragAndDropState;
	}
	public void setDeleteState() {
		this.currentState = deleteState;
	}
	public IState getCurrentState() {
		return currentState;
	}
}
