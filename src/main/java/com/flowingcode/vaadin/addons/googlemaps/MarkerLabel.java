package com.flowingcode.vaadin.addons.googlemaps;

import elemental.json.Json;
import elemental.json.JsonObject;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

import java.util.Objects;
import java.util.Optional;

/**
 * Class representing a marker label.
 */
@Getter
@Setter
public class MarkerLabel {
    /**
     * The text to be displayed in the label. Required field.
     */
    @NonNull
    private String text;

    /**
     * Optional. The color of the label text.
     * Defaults to: <code>'black'</code>
     */
    private String color;

    /**
     * Optional. The font family of the label text (equivalent to the CSS font-family
     * property).
     */
    private String fontFamily;

    /**
     * Optional. The font size of the label text (equivalent to the CSS font-size
     * property).
     * Defaults to: <code>'14px'</code>
     */
    private String fontSize;

    /**
     * Optional. The font weight of the label text (equivalent to the CSS font-weight
     * property).
     */
    private String fontWeight;

    /**
     The className property of the label's element (equivalent to the
     element's class attribute). Multiple space-separated CSS classes can
     be added. The font color, size, weight, and family can only be set via
     the other properties of <code>MarkerLabel</code>. CSS classes should not
     be used to change the position nor orientation of the label (e.g. using
     translations and rotations) if also using <a
     href="https://developers.google.com/maps/documentation/javascript/examples/marker-collision-management">marker
     collision management</a>.     */
    private String className;


    public MarkerLabel(String text) {
        this.text = Objects.requireNonNull(text, "Text cannot be null");
    }

    public MarkerLabel(String text, String color, String fontSize) {
        this.text = Objects.requireNonNull(text, "Text cannot be null");
        this.color = color;
        this.fontSize = fontSize;
    }

    protected JsonObject getJson() {
        JsonObject js = Json.createObject();
        Optional.of(getText()).ifPresent(value -> js.put("text", value));
        Optional.ofNullable(getColor()).ifPresent(value -> js.put("color", value));
        Optional.ofNullable(getFontFamily()).ifPresent(value -> js.put("fontFamily", value));
        Optional.ofNullable(getFontSize()).ifPresent(value -> js.put("fontSize", value));
        Optional.ofNullable(getFontWeight()).ifPresent(value -> js.put("fontWeight", value));
        Optional.ofNullable(getClassName()).ifPresent(value -> js.put("className", value));
        return js;
    }
}
