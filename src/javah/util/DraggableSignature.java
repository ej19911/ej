package javah.util;

import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

/**
 * This class will allow the resizing and displacing of the signature views
 * by binding it to a Draggable Rectangle.
 *
 * @see DraggableRectangle
 */
public class DraggableSignature extends DraggableRectangle {

    /**
     * A reference to the specified signature Image View itself.
     */
    private ImageView mSignatureView;

    /**
     * A constructor that takes a signature image view and binds it to a Draggable
     * Rectangle.
     *
     * @param signatureView
     *        The signature image view.
     */
    public DraggableSignature(ImageView signatureView) {
        // Pass the boundary of the containing pane to DraggableRectangle.
        super((int) ((Pane) signatureView.getParent()).getPrefWidth(), (int) ((Pane) signatureView.getParent()).getPrefHeight());

        mSignatureView = signatureView;

        // Add the rectangle to the parent of mSignatureView.
        Pane parentPane = (Pane) mSignatureView.getParent();
        parentPane.getChildren().add(this);

        // Pass the width and height of the Signature View to Draggable Rectangle
        double signatureWidth = mSignatureView.getFitWidth();
        double signatureHeight = mSignatureView.getFitHeight();
        this.setWidth(signatureWidth);
        this.setHeight(signatureHeight);
        this.setAspectRatio(signatureWidth, signatureHeight);

        // Bind mSignatureView x and y to the rectangle.
        mSignatureView.xProperty().bind(this.xProperty());
        mSignatureView.yProperty().bind(this.yProperty());

        // Bind mSignatureView width and height to the rectangle.
        mSignatureView.fitWidthProperty().bind(this.widthProperty());
        mSignatureView.fitHeightProperty().bind(this.heightProperty());
    }
}
