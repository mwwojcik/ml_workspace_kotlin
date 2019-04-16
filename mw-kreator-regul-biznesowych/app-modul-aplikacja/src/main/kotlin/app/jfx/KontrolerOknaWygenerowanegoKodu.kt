package app.jfx

import javafx.fxml.FXML
import javafx.scene.control.Button
import javafx.scene.control.ScrollPane
import javafx.scene.layout.VBox
import javafx.stage.Stage
import org.fxmisc.richtext.CodeArea
import org.springframework.stereotype.Controller
import java.util.regex.Pattern
import java.time.Duration.ofMillis
import org.reactfx.Subscription
import org.fxmisc.richtext.LineNumberFactory
import java.time.Duration
import org.fxmisc.richtext.model.StyleSpansBuilder
import org.fxmisc.richtext.model.StyleSpans
import org.springframework.stereotype.Component
import java.util.*


@Controller
open class KontrolerOknaWygenerowanegoKodu{

    @FXML
    lateinit var zamknijPrzycisk: Button

    @FXML
    lateinit var panelRegul: VBox
    private val KEYWORDS = arrayOf("abstract", "assert", "boolean", "break", "byte", "case", "catch", "char", "class", "const", "continue", "default", "do", "double", "else", "enum", "extends", "final", "finally", "float", "for", "goto", "if", "implements", "import", "instanceof", "int", "interface", "long", "native", "new", "package", "private", "protected", "public", "return", "short", "static", "strictfp", "super", "switch", "synchronized", "this", "throw", "throws", "transient", "try", "void", "volatile", "while")

    private val KEYWORD_PATTERN = "\\b(" + KEYWORDS.joinToString("|") + ")\\b"
    private val PAREN_PATTERN = "\\(|\\)"
    private val BRACE_PATTERN = "\\{|\\}"
    private val BRACKET_PATTERN = "\\[|\\]"
    private val SEMICOLON_PATTERN = "\\;"
    private val STRING_PATTERN = "\"([^\"\\\\]|\\\\.)*\""
    private val COMMENT_PATTERN = "//[^\n]*" + "|" + "/\\*(.|\\R)*?\\*/"

    private val PATTERN = Pattern.compile(
            "(?<KEYWORD>" + KEYWORD_PATTERN + ")"
                    + "|(?<PAREN>" + PAREN_PATTERN + ")"
                    + "|(?<BRACE>" + BRACE_PATTERN + ")"
                    + "|(?<BRACKET>" + BRACKET_PATTERN + ")"
                    + "|(?<SEMICOLON>" + SEMICOLON_PATTERN + ")"
                    + "|(?<STRING>" + STRING_PATTERN + ")"
                    + "|(?<COMMENT>" + COMMENT_PATTERN + ")"
    )

    @FXML
    val edytor=CodeArea()

    //private val sampleCode = arrayOf("package com.example;", "", "import java.util.*;", "", "public class Foo extends Bar implements Baz {", "", "    /*", "     * multi-line comment", "     */", "    public static void main(String[] args) {", "        // single-line comment", "        for(String arg: args) {", "            if(arg.length() != 0)", "                System.out.println(arg);", "            else", "                System.err.println(\"Warning: empty string as argument\");", "        }", "    }", "", "}").joinToString("\n")
    @FXML
    var wygenerowanyKod:String="Hello World"

    @FXML
    fun ustawKod(aKod:String){
        wygenerowanyKod=aKod
        edytor.replaceText(0,0,wygenerowanyKod)
    }

    @FXML
    private fun initialize() {

        edytor.prefWidth=800.0
        edytor.prefHeight=800.0
        val panel=ScrollPane(edytor)
        panelRegul.children.add(panel)

        // add line numbers to the left of area
        edytor.setParagraphGraphicFactory(LineNumberFactory.get(edytor))

        // recompute the syntax highlighting 500 ms after user stops editing area
        val cleanupWhenNoLongerNeedIt = edytor

                // plain changes = ignore style changes that are emitted when syntax highlighting is reapplied
                // multi plain changes = save computation by not rerunning the code multiple times
                //   when making multiple changes (e.g. renaming a method at multiple parts in file)
               .multiPlainChanges()

                // do not emit an event until 500 ms have passed since the last emission of previous stream
               .successionEnds(Duration.ofMillis(500))

                // run the following code block when previous stream emits an event
               .subscribe({ ignore -> edytor.setStyleSpans(0, computeHighlighting(edytor.getText())) })

        // when no longer need syntax highlighting and wish to clean up memory leaks
        // run: `cleanupWhenNoLongerNeedIt.unsubscribe();`

        edytor.replaceText(0, 0, wygenerowanyKod)
    }

    @FXML
    fun onZamknijKLIK() {
        (zamknijPrzycisk.getScene().getWindow() as Stage).close()
    }

    private fun computeHighlighting(text: String): StyleSpans<Collection<String>> {
        val matcher = PATTERN.matcher(text)
        var lastKwEnd = 0
        val spansBuilder = StyleSpansBuilder<Collection<String>>()
        while (matcher.find()) {
            val styleClass = (if (matcher.group("KEYWORD") != null)
                "keyword"
            else if (matcher.group("PAREN") != null)
                "paren"
            else if (matcher.group("BRACE") != null)
                "brace"
            else if (matcher.group("BRACKET") != null)
                "bracket"
            else if (matcher.group("SEMICOLON") != null)
                "semicolon"
            else if (matcher.group("STRING") != null)
                "string"
            else if (matcher.group("COMMENT") != null)
                "comment"
            else
                null)!! /* never happens */
            spansBuilder.add(Collections.emptyList(), matcher.start() - lastKwEnd)
            spansBuilder.add(Collections.singleton(styleClass), matcher.end() - matcher.start())
            lastKwEnd = matcher.end()
        }
        spansBuilder.add(Collections.emptyList(), text.length - lastKwEnd)
        return spansBuilder.create()
    }
}