package freshui.gui;

import freshui.program.FreshProgram;

public class Dropdown {

    FreshProgram freshProgramParent;

    public Dropdown(FreshProgram parent){
        freshProgramParent = parent;
    }

    public FreshProgram getParent(){
        return freshProgramParent;
    }

}
