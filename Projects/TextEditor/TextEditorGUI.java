package TextEditor;

import javax.swing.*;
import javax.swing.undo.UndoManager;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.io.*;

public class TextEditorGUI extends JFrame {

    private JTextArea textArea;
    private File currentFile;
    private UndoManager undoManager = new UndoManager();
    public TextEditorGUI(){
        super("TextEditor");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setBounds(400,400,800,700);
        setLocationRelativeTo(null);
        addGuiComponents();
    }

    public void addGuiComponents(){
        JMenuBar menuBar = new JMenuBar();
        JMenu fileMenu = new JMenu("File");
        JMenu editMenu = new JMenu("Edit");
        JMenu fontMenu = new JMenu("Font");
//        JMenu formatMenu = new JMenu("Format");
        JMenu colorMenu = new JMenu("Color");
        JMenu undoRedoMenu = new JMenu("Undo&Redo");

        // file menu items
        JMenuItem newMenuItem = new JMenuItem("New");
        newMenuItem.addActionListener(e -> {newFile(e);});
        JMenuItem openMenuItem = new JMenuItem("Open");
        openMenuItem.addActionListener(e -> {openFile(e);});
        JMenuItem saveMenuItem = new JMenuItem("Save");
        saveMenuItem.addActionListener(e -> {saveFile(e);});

        JMenuItem saveAsMenuItem = new JMenuItem("Save As");
        saveAsMenuItem.addActionListener(e -> {saveAs();});

        JMenuItem exitMenuItem = new JMenuItem("Exit");
        exitMenuItem.addActionListener(e -> {exit(e);});
        //edit menu items
        JMenuItem cutMenuItem = new JMenuItem("Cut");
        cutMenuItem.addActionListener(e -> {cutText();});
        JMenuItem copyMenuItem = new JMenuItem("Copy");
        copyMenuItem.addActionListener(e -> {copyText();});
        JMenuItem pasteMenuItem = new JMenuItem("Paste");
        pasteMenuItem.addActionListener(e -> {pasteText();});
        // font menu items
        JMenuItem boldMenuItem = new JMenuItem("Bold");
        boldMenuItem.addActionListener(e -> {changeFont(Font.BOLD);});
        JMenuItem plainMenuItem = new JMenuItem("Plain");
        plainMenuItem.addActionListener(e -> {changeFont(Font.PLAIN);});
        JMenuItem italicMenuItem = new JMenuItem("Italic");
        italicMenuItem.addActionListener(e -> {changeFont(Font.ITALIC);});
        JMenu sizeMenu = new JMenu("Size");
        int[] fontSizes = { 8, 9, 10, 11, 12, 14, 16, 18, 20, 22,
                24, 26, 28, 32, 36, 40, 44, 48, 52,
                56, 60, 64, 72, 74};

        for (int size : fontSizes) {
            JMenuItem sizeItem = new JMenuItem(String.valueOf(size));

            sizeItem.addActionListener(e -> {
                Font currentFont = textArea.getFont();
                textArea.setFont(new Font(
                        currentFont.getName(),
                        currentFont.getStyle(),
                        size
                ));
            });

            sizeMenu.add(sizeItem);
        }

        //color menu
        JMenuItem backMenuItem = new JMenuItem("Background");
        backMenuItem.addActionListener(e -> {backgroundColorStyle();});
        JMenuItem foreMenuItem = new JMenuItem("Foreground");
        foreMenuItem.addActionListener(e -> {foregroundColorStyle();});
        // undo redo menu
        JMenuItem undoMenuItem = new JMenuItem("Undo");
        undoMenuItem.addActionListener(e -> {undoText();});
        undoMenuItem.setAccelerator(KeyStroke.getKeyStroke("control Z"));
        JMenuItem redoMenuItem = new JMenuItem("Redo");
        redoMenuItem.setAccelerator(KeyStroke.getKeyStroke("control Y"));
        redoMenuItem.addActionListener(e -> {redoText();});

        menuBar.add(fileMenu);
        menuBar.add(editMenu);
        menuBar.add(fontMenu);
//        menuBar.add(formatMenu);
        menuBar.add(colorMenu);
        menuBar.add(undoRedoMenu);

        fileMenu.add(newMenuItem);
        fileMenu.add(openMenuItem);
        fileMenu.add(saveMenuItem);
        fileMenu.add(saveAsMenuItem);
        fileMenu.add(exitMenuItem);

        editMenu.add(cutMenuItem);
        editMenu.add(copyMenuItem);
        editMenu.add(pasteMenuItem);

        fontMenu.add(boldMenuItem);
        fontMenu.add(plainMenuItem);
        fontMenu.add(italicMenuItem);
        fontMenu.add(sizeMenu);

        colorMenu.add(backMenuItem);
        colorMenu.add(foreMenuItem);

        undoRedoMenu.add(undoMenuItem);
        undoRedoMenu.add(redoMenuItem);

//        menuBar.addAncestorListener(this);
        setJMenuBar(menuBar);

        textArea = new JTextArea();
        JScrollPane scrollPane = new JScrollPane(textArea);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);

        textArea.setFont(new Font("Monospaced", Font.PLAIN, 15));
        textArea.getDocument().addUndoableEditListener(e -> undoManager.addEdit(e.getEdit()));
        getContentPane().add(scrollPane, BorderLayout.CENTER);
    }
    private void newFile(ActionEvent e) {
        int choice = JOptionPane.showConfirmDialog(
                this,
                "Do you want to save the current file before creating a new one?",
                "Save File",
                JOptionPane.YES_NO_CANCEL_OPTION
        );
        if(choice == JOptionPane.YES_OPTION){
            saveFile(e);
        }else if(choice == JOptionPane.CANCEL_OPTION){
            return;
        }
        textArea.setText("");
        currentFile = null;
        setTitle("TextEditor - New File");
    }
    private void openFile(ActionEvent e) {
        JFileChooser fileChooser = new JFileChooser();
        int result = fileChooser.showOpenDialog(this);

        if(result == fileChooser.APPROVE_OPTION){
            currentFile = fileChooser.getSelectedFile();
            try(BufferedReader reader = new BufferedReader(new FileReader(currentFile))){
                textArea.read(reader, null);
            }catch(IOException ex){
                JOptionPane.showMessageDialog(this,"Error File Opening");
            }
        }
    }
    private void saveFile(ActionEvent e){
        if(currentFile == null){
            saveAs();
        }
        try(BufferedWriter writer = new BufferedWriter(new FileWriter(currentFile))){
            textArea.write(writer);
            setTitle("TextEditor - " + currentFile.getName());
        }catch (IOException ex){
            JOptionPane.showMessageDialog(this, "Error Saving File");
        }
    }
    private void saveAs(){
        JFileChooser fileChooser = new JFileChooser();
        int choice = fileChooser.showSaveDialog(this);

        if(choice == JFileChooser.APPROVE_OPTION){
            currentFile = fileChooser.getSelectedFile();

            try(BufferedWriter writer = new BufferedWriter(new FileWriter(currentFile))){
                textArea.write(writer);
                setTitle("TextEditor - " + currentFile.getName());
            }catch (IOException ex){
                JOptionPane.showMessageDialog(this, "Error Saving File");
            };
        }
    }
    private void exit(ActionEvent e){
        int choice = JOptionPane.showConfirmDialog(
                this,
                "Do you want to save before exit?",
                "Exit",
                JOptionPane.YES_NO_CANCEL_OPTION
        );
        if(choice == JOptionPane.YES_OPTION){
            saveFile(e);
            System.exit(0);
        } else if(choice == JOptionPane.NO_OPTION){
            System.exit(0);
        }
    }

    private void cutText(){
        textArea.cut();
    }
    private void copyText(){
        textArea.copy();
    }
    private void pasteText(){
        textArea.paste();
    }

    private void changeFont(int fontStyle){
        Font currentFont = textArea.getFont();
        textArea.setFont(new Font(currentFont.getName(), fontStyle, currentFont.getSize()));
    }

    private void backgroundColorStyle(){
        Color selectedColor = JColorChooser.showDialog(null, "Color", textArea.getBackground());

        if(selectedColor != null){
            textArea.setBackground(selectedColor);
        }
    }
    private void foregroundColorStyle(){
        Color selectedColor = JColorChooser.showDialog(null, "Color", textArea.getForeground());

        if(selectedColor != null){
            textArea.setForeground(selectedColor);
        }
    }
    private void undoText(){
        if(undoManager.canUndo()){
            undoManager.undo();
        }
    }
    private void redoText(){
        if(undoManager.canRedo()){
            undoManager.redo();
        }
    }
}
