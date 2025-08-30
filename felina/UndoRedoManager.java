package felina;

public class UndoRedoManager {
    private LinkedListStack undoStack = new LinkedListStack();
    private LinkedListStack redoStack = new LinkedListStack();

    public void performAction(String action) {
        undoStack.push(action);
    }
	

	public void undo() {
		if (undoStack.isEmpty()) {
			System.out.println("Nothing to undo.");
		} else {
			String action = undoStack.pop();
			redoStack.push(action);
		}
	}

    public void redo() {
        if (redoStack.isEmpty()) {
            System.out.println("Nothing to redo.");
        } else {
            String action = redoStack.pop();
            undoStack.push(action);
        }
    }
}
	
