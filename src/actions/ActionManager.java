package actions;

import actions.NewNodeAction;
import actions.RenameNodeAction;
import actions.DeleteNodeAction;
import actions.CloseTabAction;
import actions.CloseAllTabsAction;


public class ActionManager {

	private NewNodeAction 		newNodeAction;
	private RenameNodeAction 	renameNodeAction;
	private DeleteNodeAction 	deleteNodeAction;
	private CloseTabAction 		closeTabAction;
	private CloseAllTabsAction 	closeAllTabsAction;
	private AboutDialogAction 	aboutDialogAction;
	private OpenNodeAction		openNodeAction;
	private SaveNodeAction		saveNodeAction;
	private SaveAsNodeAction	saveAsNodeAction;
	
	private DrawRectangleAction		drawRectangleAction;
	private DrawCircleAction		drawCircleAction;
	private DrawTriangleAction		drawTriangleAction;
	private SelectShapeAction		selectShapeAction;
	
	private RotateAndScaleAction	rotateAndScaleAction;
	private DragAndDropAction		dragAndDropAction;
	private DeleteSlotAction		deleteSlotAction;
	
	private UndoAction		undoAction;
	private RedoAction		redoAction;
	
	private CBCopyAction	copyAction;
	private CBCutAction		cutAction;
	private CBPasteAction	pasteAction;
	private ShareAction 	shareAction;
	
	private TextElementAction 		textElementAction;
	private PictureElementAction 	pictureElementAction;
	private EditSlotElementAction 	editSlotElementAction;
	
	private TrashcanAction 			trashcanAction;
	public ActionManager(){
		initialiseActions();
	}

	private void initialiseActions() {
		newNodeAction = new NewNodeAction();
		renameNodeAction = new RenameNodeAction();
		deleteNodeAction = new DeleteNodeAction();
		closeTabAction = new CloseTabAction();
		closeAllTabsAction = new CloseAllTabsAction();
		aboutDialogAction = new AboutDialogAction();
		openNodeAction = new OpenNodeAction();
		saveNodeAction = new SaveNodeAction();
		saveAsNodeAction = new SaveAsNodeAction();
		drawRectangleAction = new DrawRectangleAction();
		drawCircleAction = new DrawCircleAction();
		drawTriangleAction = new DrawTriangleAction();
		selectShapeAction = new SelectShapeAction();
		rotateAndScaleAction = new RotateAndScaleAction();
		dragAndDropAction = new DragAndDropAction();
		deleteSlotAction = new DeleteSlotAction();
		undoAction = new UndoAction();
		redoAction = new RedoAction();
		copyAction = new CBCopyAction();
		cutAction = new CBCutAction();
		pasteAction = new CBPasteAction();
		shareAction = new ShareAction();
		trashcanAction = new TrashcanAction();
		textElementAction =  new TextElementAction();
		pictureElementAction = new PictureElementAction();
		editSlotElementAction =  new EditSlotElementAction();
	}

	public NewNodeAction getNewNodeAction() {
		return newNodeAction;
	}

	public RenameNodeAction getRenameNodeAction() {
		return renameNodeAction;
	}

	public DeleteNodeAction getDeleteNodeAction() {
		return deleteNodeAction;
	}

	public CloseTabAction getCloseTabAction() {
		return closeTabAction;
	}

	public CloseAllTabsAction getCloseAllTabsAction() {
		return closeAllTabsAction;
	}

	public AboutDialogAction getAboutDialogAction() {
		return aboutDialogAction;
	}

	public void setNewNodeAction(NewNodeAction newNodeAction) {
		this.newNodeAction = newNodeAction;
	}

	public void setRenameNodeAction(RenameNodeAction renameNodeAction) {
		this.renameNodeAction = renameNodeAction;
	}

	public void setDeleteNodeAction(DeleteNodeAction deleteNodeAction) {
		this.deleteNodeAction =  deleteNodeAction;
	}

	public void setCloseTabAction(CloseTabAction closeTabAction) {
		this.closeTabAction = closeTabAction;
	}

	public void setCloseAllTabsAction(CloseAllTabsAction closeAllTabsAction) {
		this.closeAllTabsAction = closeAllTabsAction;
	}

	public void setAboutDialogAction(AboutDialogAction aboutDialogAction) {
		this.aboutDialogAction = aboutDialogAction;
	}

	public OpenNodeAction getOpenNodeAction() {
		return openNodeAction;
	}

	public void setOpenNodeAction(OpenNodeAction openNodeAction) {
		this.openNodeAction = openNodeAction;
	}

	public SaveNodeAction getSaveNodeAction() {
		return saveNodeAction;
	}

	public void setSaveNodeAction(SaveNodeAction saveNodeAction) {
		this.saveNodeAction = saveNodeAction;
	}
	
	public DrawRectangleAction getDrawRectangleAction() {
		return drawRectangleAction;
	}
	
	public void setDrawRectangleAction(DrawRectangleAction drawRectangleAction) {
		this.drawRectangleAction = drawRectangleAction;
	}
	
	public DrawCircleAction getDrawCircleAction() {
		return drawCircleAction;
	}
	
	public void setDrawCircleAction(DrawCircleAction drawCircleAction) {
		this.drawCircleAction = drawCircleAction;
	}
	
	public DrawTriangleAction getDrawTriangleAction() {
		return drawTriangleAction;
	}
	
	public void setDrawTriangleAction(DrawTriangleAction drawTriangleAction) {
		this.drawTriangleAction = drawTriangleAction;
	}
	
	public SelectShapeAction getSelectShapeAction() {
		return selectShapeAction;
	}
	
	public void setSelectShapeAction(SelectShapeAction selectShapeAction) {
		this.selectShapeAction = selectShapeAction;
	}

	public SaveAsNodeAction getSaveAsNodeAction() {
		return saveAsNodeAction;
	}

	public void setSaveAsNodeAction(SaveAsNodeAction saveAsNodeAction) {
		this.saveAsNodeAction = saveAsNodeAction;
	}
	
	public RotateAndScaleAction getRotateAndScaleAction() {
		return rotateAndScaleAction;
	}

	public void setRotateAndScaleAction(RotateAndScaleAction rotateAndScaleAction) {
		this.rotateAndScaleAction = rotateAndScaleAction;
	}
	
	public DragAndDropAction getDragAndDropAction() {
		return dragAndDropAction;
	}

	public void setDragAndDropAction(DragAndDropAction dragAndDropAction) {
		this.dragAndDropAction = dragAndDropAction;
	}
	
	public DeleteSlotAction getDeleteSlotAction() {
		return deleteSlotAction;
	}

	public void setDeleteSlotAction(DeleteSlotAction deleteSlotAction) {
		this.deleteSlotAction = deleteSlotAction;
	}
	
	public UndoAction getUndoAction() {
		return undoAction;
	}

	public void setUndoAction(UndoAction undoAction) {
		this.undoAction = undoAction;
	}
	
	public RedoAction getRedoAction() {
		return redoAction;
	}

	public void setRedoAction(RedoAction redoAction) {
		this.redoAction = redoAction;
	}

	public CBCopyAction getCopyAction() {
		return copyAction;
	}

	public void setCopyAction(CBCopyAction copyAction) {
		this.copyAction = copyAction;
	}

	public CBCutAction getCutAction() {
		return cutAction;
	}

	public void setCutAction(CBCutAction cutAction) {
		this.cutAction = cutAction;
	}

	public CBPasteAction getPasteAction() {
		return pasteAction;
	}

	public void setPasteAction(CBPasteAction pasteAction) {
		this.pasteAction = pasteAction;
	}

	public ShareAction getShareAction() {
		return shareAction;
	}

	public void setShareAction(ShareAction shareAction) {
		this.shareAction = shareAction;
	}

	public TrashcanAction getTrashcanAction() {
		return trashcanAction;
	}

	public void setTrashcanAction(TrashcanAction trashcanAction) {
		this.trashcanAction = trashcanAction;
	}

	public TextElementAction getTextElementAction() {
		return textElementAction;
	}

	public void setTextElementAction(TextElementAction textElementAction) {
		this.textElementAction = textElementAction;
	}

	public PictureElementAction getPictureElementAction() {
		return pictureElementAction;
	}

	public void setPictureElementAction(PictureElementAction pictureElementAction) {
		this.pictureElementAction = pictureElementAction;
	}

	public EditSlotElementAction getEditSlotElementAction() {
		return editSlotElementAction;
	}

	public void setEditSlotElementAction(EditSlotElementAction editSlotElementAction) {
		this.editSlotElementAction = editSlotElementAction;
	}
}
